package com.example.successsynergyapp.dashboard.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.successsynergyapp.R
import com.example.successsynergyapp.dashboard.form.adapters.FormsRecyclerViewAdapter
import com.example.successsynergyapp.databinding.ActivityUserFormBinding
import com.example.successsynergyapp.databinding.LayoutSingleFormQuestionBinding
import com.example.successsynergyapp.model.SingleQuestionModel
import com.example.successsynergyapp.utils.theme3bottomnavigation.theme11utils.getAppColor
import com.example.successsynergyapp.utils.theme3bottomnavigation.theme11utils.onClick
import com.yuyakaido.android.cardstackview.*
import kotlinx.android.synthetic.main.layout_single_form_question.view.*

class UserFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserFormBinding
    private var mProgress = 0
    private var mSize = 0

    private val mOnlineTestAdapter =
            FormsRecyclerViewAdapter<SingleQuestionModel>(R.layout.layout_single_form_question,
                    onBind = { view: View, item, position ->
                        view.tvQuestion.text = item.question
                        if (item.requiresTyping) run {
                            view.tvAns1.visibility = GONE
                            view.tvA.visibility = GONE
                            view.tvB.visibility = GONE
                            view.tvC.visibility = GONE
                            view.tvAns2.visibility = GONE
                            view.tvAns3.visibility = GONE
                            view.et_answer.visibility = VISIBLE
                        }
                        else{
                            view.tvAns1.text = item.ans1
                            view.tvAns2.text = item.ans2
                            view.tvAns3.text = item.ans3

                            view.llAns1.background = resources.getDrawable(R.drawable.theme7_bg_rounded_border)
                            view.llAns2.background = resources.getDrawable(R.drawable.theme7_bg_rounded_border)
                            view.llAns3.background = resources.getDrawable(R.drawable.theme7_bg_rounded_border)
                            view.tvAns1.setTextColor(getAppColor(R.color.Theme7_textColorSecondary))
                            view.tvAns2.setTextColor(getAppColor(R.color.Theme7_textColorSecondary))
                            view.tvAns3.setTextColor(getAppColor(R.color.Theme7_textColorSecondary))
                            view.tvA.setTextColor(getAppColor(R.color.Theme7_textColorSecondary))
                            view.tvB.setTextColor(getAppColor(R.color.Theme7_textColorSecondary))
                            view.tvC.setTextColor(getAppColor(R.color.Theme7_textColorSecondary))

                            when {
                                item.isSelected == 1 -> {
                                    view.llAns1.background = resources.getDrawable(R.drawable.theme7_bg_rounded_border_fill)
                                    view.tvAns1.setTextColor(getAppColor(R.color.Theme7_white))
                                    view.tvA.setTextColor(getAppColor(R.color.Theme7_white))
                                }
                                item.isSelected == 2 -> {
                                    view.llAns2.background = resources.getDrawable(R.drawable.theme7_bg_rounded_border_fill)
                                    view.tvAns2.setTextColor(getAppColor(R.color.Theme7_white))
                                    view.tvB.setTextColor(getAppColor(R.color.Theme7_white))
                                }
                                item.isSelected == 3 -> {
                                    view.llAns3.background = resources.getDrawable(R.drawable.theme7_bg_rounded_border_fill)
                                    view.tvAns3.setTextColor(getAppColor(R.color.Theme7_white))
                                    view.tvC.setTextColor(getAppColor(R.color.Theme7_white))
                                }
                            }
                        }
                        view.llAns1.onClick {
                            item.isSelected = 1
                            handleClickEvent(view, item, position)
                        }
                        view.llAns2.onClick {
                            item.isSelected = 2
                            handleClickEvent(view, item, position)
                        }
                        view.llAns3.onClick {
                            item.isSelected = 3
                            handleClickEvent(view, item, position)
                        }
                    })


    private val manager by lazy { CardStackLayoutManager(this) }
    private fun handleClickEvent(view: View, item: SingleQuestionModel, position: Int) {
        mOnlineTestAdapter.notifyItemChanged(position)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_form)
        mSize = getData().size
        supportActionBar!!.hide()
        binding.ivClose.onClick { onBackPressed() }
        initialize()
        val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
        binding.btnLogin.setOnClickListener {
            manager.setSwipeAnimationSetting(setting)
            binding.cardStackView.swipe()
            mProgress++
            binding.sBar.progress = mProgress
            if (binding.sBar.progress==binding.sBar.max){
                finish()
            }
        }
        binding.sBar.max = getData().size
    }

    private fun initialize() {
        manager.setStackFrom(StackFrom.Top)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(12.0f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(false)
        manager.setCanScrollVertical(false)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        binding.cardStackView.layoutManager = manager
        binding.cardStackView.adapter = mOnlineTestAdapter
        mOnlineTestAdapter.addItems(getData())
        binding.cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }
    companion object{
        fun getData(): ArrayList<SingleQuestionModel> {
            val list = ArrayList<SingleQuestionModel>()
            val model1 = SingleQuestionModel()
            model1.question = "What is your full name?"
            model1.ans1 = "Yes"
            model1.ans2 = "No"
            model1.ans3 = "Maybe"
            model1.ans4 = "One Steps"
            model1.requiresTyping = true

            val model2 = SingleQuestionModel()
            model2.question = "Where is your Location/Country? "
            model2.ans1 = "Capillaries"
            model2.ans2 = "Arterioles"
            model2.ans3 = "Venules"
            model2.ans4 = "Lymphatic"
            model2.requiresTyping = true

            val model3 = SingleQuestionModel()
            model3.question = "Where is your State/Providence/City?"
            model3.ans1 = "Phruvic acid"
            model3.ans2 = "Glucose"
            model3.ans3 = "Fructose"
            model3.ans4 = "Glycolate"
            model3.requiresTyping = true

            list.add(model1)
            list.add(model2)
            list.add(model3)

            return list
        }

    }
}