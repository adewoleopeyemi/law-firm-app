package com.example.successsynergyapp.dashboard.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.successsynergyapp.R
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemGeneral
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemPopular
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemTopRated
import com.example.successsynergyapp.dashboard.home.search.SearchActivity
import com.example.successsynergyapp.databinding.LayoutHomeBinding
import com.example.successsynergyapp.extensions.onClick
import com.example.successsynergyapp.model.ModelAds
import com.example.successsynergyapp.model.ModelServiceProvider
import com.example.successsynergyapp.model.SingleAdFragment
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class HomeFragment : Fragment() {
    lateinit var binding: LayoutHomeBinding
    var serviceProviderRef: DatabaseReference? = null
    var popularUsers: ArrayList<ModelServiceProvider> = ArrayList()
    var allCat: ArrayList<ArrayList<ModelServiceProvider>> = ArrayList()
    var allUsers: ArrayList<ModelServiceProvider> = ArrayList()

    var topRatedUsers: ArrayList<ModelServiceProvider> = ArrayList()
    var search: String? = null
    var onAllRated = true
    var currentPage = 0
    var allAds: ArrayList<ModelAds> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.layout_home, container, false)
        serviceProviderRef = Firebase.database.getReference("ServiceProvider")
        search = requireArguments().getString("search")
        if (search == null){
            searchDb()
        }
        else{
            setUpAdsViewPager()
            initPopularRecyclerView()
        }
        toggleAllRated()
        binding.etSearch.setOnClickListener(){
            var i = Intent(context, SearchActivity::class.java)
            i.putExtra("popularUsers", popularUsers)
            startActivity(i)
        }
        return binding.root
    }

    private fun setUpAdsViewPager() {
        fetchAllAds()
    }

    var Update: Runnable? = null
    private fun setUpAutoScroll(){
        Update = Runnable {
            if (currentPage === allAds.size) {
                currentPage = 0
            }
            binding.adsViewPager.setCurrentItem(currentPage++, true)
            Handler().postDelayed(Update!!, 3000)
        }
        Update!!.run()
    }

    private fun fetchAllAds() {
        allAds.clear()
        var ref = FirebaseDatabase.getInstance().reference
        ref.child("Adverts").addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (adverts in snapshot.children){
                    var singleAd : ModelAds? = adverts.getValue(ModelAds::class.java)
                    allAds.add(singleAd!!)
                }
                var adapter = MyAdapter(fragmentManager!!, allAds)
                binding.adsViewPager.adapter= adapter
                binding.indicator.setViewPager(binding.adsViewPager)
                setUpAutoScroll()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    inner class MyAdapter(fm: FragmentManager, private var ads: ArrayList<ModelAds>) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return SingleAdFragment(ads.get(position).imagePath)
        }

        override fun getCount(): Int = ads.size
    }


    private fun searchDb() {
        binding.tvPopular.visibility = View.GONE
        binding.tvGeneral.visibility = View.GONE
        binding.tvSearchResults.visibility = View.VISIBLE
        allUsers.clear()
        val postListener = object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children){
                    for (user in data.children){
                        var singleUser: ModelServiceProvider? = user!!.getValue<ModelServiceProvider>()
                        if (search!!.toLowerCase() in singleUser!!.fullname.toLowerCase() ){
                            allUsers.add(singleUser!!)
                        }
                    }
                }
                var adapterGeneral: AdapterItemGeneral = AdapterItemGeneral(context, allUsers)

                binding.rvAll.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvAll.adapter = adapterGeneral
                binding.rlLoading.visibility = View.GONE
            }
        }
        serviceProviderRef!!.addListenerForSingleValueEvent(postListener)
    }

    private fun toggleAllRated(){
        binding.tvAllUsers.onClick {
            binding.tvPopular.visibility = View.VISIBLE
            binding.rvPopular.visibility = View.VISIBLE
            binding.allRl.visibility = View.VISIBLE
            //binding.rvAll.visibility = View.VISIBLE
            binding.tvGeneral.visibility = View.VISIBLE
            binding.rvTopRated.visibility = View.GONE
            setConstraintGravity(0)
        }
        binding.tvTopRatedUsers.onClick {
            binding.tvPopular.visibility = View.GONE
            binding.rvPopular.visibility = View.GONE
            binding.allRl.visibility = View.GONE
            //binding.rvAll.visibility = View.GONE
            binding.tvGeneral.visibility = View.GONE
            binding.rvTopRated.visibility = View.VISIBLE
            setConstraintGravity(1)
        }
    }

    private fun setConstraintGravity(i: Int) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.userSelection)
        update()
        when (i) {
            0 -> {
                binding.tvAllUsers.setTextColor(ContextCompat.getColor(requireContext(), R.color.t12_colorPrimary))
                constraintSet.clear(R.id.selected_category, ConstraintSet.END)
                constraintSet.connect(
                        R.id.selected_category,
                        ConstraintSet.START,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.START,
                        0
                )
            }
            1 -> {
                binding.tvTopRatedUsers.setTextColor(ContextCompat.getColor(requireContext(), R.color.t12_colorPrimary))
                constraintSet.clear(R.id.selected_category, ConstraintSet.START)
                constraintSet.connect(
                        R.id.selected_category,
                        ConstraintSet.END,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.END,
                        0
                )
            }
        }
        TransitionManager.beginDelayedTransition(binding.userSelection)
        constraintSet.applyTo(binding.userSelection)
    }
    private fun update() {
        context?.let { ContextCompat.getColor(it, R.color.t12_textColorPrimary) }?.let { binding.tvAllUsers.setTextColor(it) }
        context?.let { ContextCompat.getColor(it, R.color.t12_textColorPrimary) }?.let { binding.tvTopRatedUsers.setTextColor(it) }
    }
    private fun initPopularRecyclerView() {
        binding.tvSearchResults.visibility = View.GONE
        allUsers.clear()
        popularUsers.clear()
        topRatedUsers.clear()
        allCat.clear()
        val postListener = object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children){
                    for (user in data.children){
                        var singleUser: ModelServiceProvider? = user!!.getValue<ModelServiceProvider>()
                        if (singleUser!!.approved){
                            if (singleUser!!.num_cases_solved > 15){
                                popularUsers.add(singleUser!!)
                            }
                            if (singleUser.rating >= 4.0f){
                                topRatedUsers.add(singleUser!!)
                            }
                            allUsers.add(singleUser!!)

                        }
                    }
                }
                var adapterPopular: AdapterItemPopular = AdapterItemPopular(context, popularUsers)
                var adapterGeneral: AdapterItemGeneral = AdapterItemGeneral(context, allUsers)
                var adapterItemTopRated: AdapterItemTopRated = AdapterItemTopRated(context, topRatedUsers)
                binding.rvPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.rvAll.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvPopular.adapter = adapterPopular
                binding.rvAll.adapter = adapterGeneral
                //binding.rvAll.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                //binding.rvAll.adapter = adapterGeneral

                binding.rvTopRated.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvTopRated.adapter = adapterItemTopRated

                if (allUsers.isEmpty()){
                    binding.noGeneralUsers.visibility = VISIBLE
                    binding.noGeneralUsers.playAnimation()
                    binding.rvAll.visibility = GONE
                }
                if (popularUsers.isEmpty()){
                    binding.noPopularUsersAnim.visibility = VISIBLE
                    binding.noPopularUsersAnim.playAnimation()
                    binding.rvPopular.visibility = GONE
                }
                binding.rlLoading.visibility = View.GONE
            }
        }
        serviceProviderRef!!.addListenerForSingleValueEvent(postListener)
    }

}