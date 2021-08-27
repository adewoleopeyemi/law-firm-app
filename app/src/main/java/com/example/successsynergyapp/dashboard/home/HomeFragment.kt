package com.example.successsynergyapp.dashboard.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.successsynergyapp.R
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemGeneral
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemPopular
import com.example.successsynergyapp.dashboard.home.adpaters.AdapterItemTopRated
import com.example.successsynergyapp.dashboard.home.adpaters.AllTabLayoutAdapter
import com.example.successsynergyapp.dashboard.home.search.SearchActivity
import com.example.successsynergyapp.databinding.LayoutHomeBinding
import com.example.successsynergyapp.extensions.onClick
import com.example.successsynergyapp.model.ModelServiceProvider
import com.google.android.material.tabs.TabLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_home.*
import kotlinx.android.synthetic.main.layout_home.tabLayout

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
    var criminalLaw: ArrayList<ModelServiceProvider> = ArrayList()
    var civilLaw: ArrayList<ModelServiceProvider> = ArrayList()
    var humanRights: ArrayList<ModelServiceProvider> = ArrayList()
    var maritime: ArrayList<ModelServiceProvider> = ArrayList()
    var corporateAffairs: ArrayList<ModelServiceProvider> = ArrayList()
    var InternationalAndCrossBorder: ArrayList<ModelServiceProvider> = ArrayList()
    var debtRecovery: ArrayList<ModelServiceProvider> = ArrayList()
    var litigationService: ArrayList<ModelServiceProvider> = ArrayList()
    var offshoreLegal: ArrayList<ModelServiceProvider> = ArrayList()
    var realEstateSolution: ArrayList<ModelServiceProvider> = ArrayList()
    var titleDocumentRegsitration: ArrayList<ModelServiceProvider> = ArrayList()
    var crossBorder: ArrayList<ModelServiceProvider> = ArrayList()
    var purchaseOfLand: ArrayList<ModelServiceProvider> = ArrayList()
    var companySecretarialService: ArrayList<ModelServiceProvider> = ArrayList()
    var maritmeAndInternationalLaw: ArrayList<ModelServiceProvider> = ArrayList()
    var legalDraftingAndContract: ArrayList<ModelServiceProvider> = ArrayList()
    var familyLaw: ArrayList<ModelServiceProvider> = ArrayList()
    var matrimonialCoursesAndChildRight: ArrayList<ModelServiceProvider> = ArrayList()
    var humanRightsMatter: ArrayList<ModelServiceProvider> = ArrayList()
    var intellectualPropertyLaw: ArrayList<ModelServiceProvider> = ArrayList()
    var legalOpinions: ArrayList<ModelServiceProvider> = ArrayList()
    var proBono: ArrayList<ModelServiceProvider> = ArrayList()
    var entertainmentLaw: ArrayList<ModelServiceProvider> = ArrayList()
    var sportsLaw: ArrayList<ModelServiceProvider> = ArrayList()

    var topRatedUsers: ArrayList<ModelServiceProvider> = ArrayList()
    var search: String? = null
    var onAllRated = true
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.layout_home, container, false)
        serviceProviderRef = Firebase.database.getReference("ServiceProvider")
        search = requireArguments().getString("search")
        if (search != null){
            //searchDb()
        }
        else{
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

    private fun setUpViewPager(value: ArrayList<String>) {
        for (i in value){
            //binding.tabLayout.addTab(binding.tabLayout.newTab().setText(i.toString()))
        }
        var adapter = AllTabLayoutAdapter(context, value,allCat, this.parentFragmentManager)
        binding.viewpagerAll.adapter = adapter
        binding.viewpagerAll.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.setupWithViewPager(binding.viewpagerAll)
    }

    /*private fun searchDb() {
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

                //binding.rvAll.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                //binding.rvAll.adapter = adapterGeneral
                binding.rlLoading.visibility = View.GONE
            }
        }
        serviceProviderRef!!.addListenerForSingleValueEvent(postListener)
    }*/

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
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children){
                    for (user in data.children){
                        var singleUser: ModelServiceProvider? = user!!.getValue<ModelServiceProvider>()
                        if (singleUser!!.num_cases_solved > 15){
                            popularUsers.add(singleUser!!)
                        }
                        if (singleUser.rating >= 4.0f){
                            topRatedUsers.add(singleUser!!)
                        }
                        if (data.key!!.toString().equals("Criminal Law")){
                            criminalLaw.add(singleUser)

                        }
                        else if (data.key!!.toString().equals("Civil Law")){
                            civilLaw.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Human Rights")){
                            humanRights.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Maritime")){
                            maritime.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Corporate Affairs")){
                            corporateAffairs.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("International and Cross Border Legal")){
                            InternationalAndCrossBorder.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Debt  Recoveries")){
                            debtRecovery.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Litigation Services")){
                            litigationService.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Offshore Legal Representation")){
                            offshoreLegal.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Real Estate Solutions")){
                            realEstateSolution.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Title Documents Registration")){
                            titleDocumentRegsitration.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Cross Border Real Estate Services")){
                            crossBorder.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Purchase of land for Nigerians in the Diasporas")){
                            purchaseOfLand.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Company Secretarial Services")){
                            companySecretarialService.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Maritime and International Trade Laws")){
                            maritmeAndInternationalLaw.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Legal drafting and contract documentations")){
                            legalDraftingAndContract.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Family Law")){
                            familyLaw.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Matrimonial Courses and Child Right Laws")){
                            matrimonialCoursesAndChildRight.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Human Rights matter")){
                            humanRightsMatter.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Intellectual Property Law")){
                            intellectualPropertyLaw.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Legal Opinions on all areas of law")){
                            legalOpinions.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("pro bono services")){
                            proBono.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Entertainment law")){
                            entertainmentLaw.add(singleUser)
                        }
                        else if (data.key!!.toString().equals("Sports law")){
                            sportsLaw.add(singleUser)
                        }
                        allCat.add(criminalLaw)
                        allCat.add(civilLaw)
                        allCat.add(humanRights)
                        allCat.add(maritime)
                        allCat.add(corporateAffairs)
                        allCat.add(InternationalAndCrossBorder)
                        allCat.add(debtRecovery)
                        allCat.add(litigationService)
                        allCat.add(offshoreLegal)
                        allCat.add(realEstateSolution)
                        allCat.add(titleDocumentRegsitration)
                        allCat.add(crossBorder)
                        allCat.add(purchaseOfLand)
                        allCat.add(companySecretarialService)
                        allCat.add(maritmeAndInternationalLaw)
                        allCat.add(legalDraftingAndContract)
                        allCat.add(familyLaw)
                        allCat.add(matrimonialCoursesAndChildRight)
                        allCat.add(humanRightsMatter)
                        allCat.add(intellectualPropertyLaw)
                        allCat.add(legalOpinions)
                        allCat.add(proBono)
                        allCat.add(entertainmentLaw)
                        allCat.add(sportsLaw)

                    }
                }
                var adapterPopular: AdapterItemPopular = AdapterItemPopular(context, popularUsers)
                var adapterGeneral: AdapterItemGeneral = AdapterItemGeneral(context, allUsers)
                var adapterItemTopRated: AdapterItemTopRated = AdapterItemTopRated(context, topRatedUsers)
                binding.rvPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.rvPopular.adapter = adapterPopular
                val value:ArrayList<String> = arrayListOf("Criminal Law", "Civil Law", "Human Rights", "Maritime", "Corporate Affairs",
                        "International and Cross Border Legal", "Debt  Recoveries", "Litigation Services", "Offshore Legal Representation",
                        "Real Estate Solutions", "Title Documents Registration", "Cross Border Real Estate Services", "Purchase of land for Nigerians in the Diasporas",
                        "Company Secretarial Services", "Maritime and International Trade Laws", "Legal drafting and contract documentations", "Family Law",
                        "Matrimonial Courses and Child Right Laws", "Human Rights matter", "Intellectual Property Law", "Legal Opinions on all areas of law",
                        "pro bono services", "Entertainment law", "Sports law")
                setUpViewPager(value)

                //binding.rvAll.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                //binding.rvAll.adapter = adapterGeneral

                binding.rvTopRated.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvTopRated.adapter = adapterItemTopRated
                binding.rlLoading.visibility = View.GONE
            }
        }
        serviceProviderRef!!.addListenerForSingleValueEvent(postListener)
    }

}