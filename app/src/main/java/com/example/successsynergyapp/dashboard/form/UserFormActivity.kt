package com.example.successsynergyapp.dashboard.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.successsynergyapp.R
import com.example.successsynergyapp.dashboard.form.adapters.FormsRecyclerViewAdapter
import com.example.successsynergyapp.databinding.ActivityUserFormBinding
import com.example.successsynergyapp.databinding.LayoutSingleFormQuestionBinding
import com.example.successsynergyapp.model.ModelForm
import com.example.successsynergyapp.model.SingleQuestionModel
import com.example.successsynergyapp.utils.theme3bottomnavigation.theme11utils.getAppColor
import com.example.successsynergyapp.utils.theme3bottomnavigation.theme11utils.onClick
import com.yuyakaido.android.cardstackview.*
import kotlinx.android.synthetic.main.layout_single_form_question.*
import kotlinx.android.synthetic.main.layout_single_form_question.view.*

class UserFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserFormBinding
    private var mProgress = 0
    private var mSize = 0
    var form: ModelForm = ModelForm()
    var curQuuestion = SingleQuestionModel()
    lateinit var runnable: Runnable



    private val mOnlineTestAdapter =
            FormsRecyclerViewAdapter<SingleQuestionModel>(R.layout.layout_single_form_question,
                    onBind = { view: View, item, position ->
                        view.tvQuestion.text = item.question
                        if (item.requiresTyping) run {
                            view.et_answer.hint = "Please type your answer here"
                            view.et_answer.visibility = VISIBLE
                            view.et_answer.hint = "Please type your answer here"
                            view.rd_grp.visibility = GONE
                            runnable = Runnable {
                                try{
                                    curQuuestion.answer = et_answer.text.toString()
                                }
                                catch (e: Exception){

                                }
                                Handler().postDelayed(runnable, 100)
                            }
                            runnable.run()
                        }
                        else {
                            view.rd_grp.visibility = VISIBLE
                            view.btn_yes.text = "Yes"
                            view.btn_no.text = "No"
                            view.et_answer.visibility = GONE
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
            Toast.makeText(applicationContext, ""+curQuuestion.answer.toString(), Toast.LENGTH_SHORT).show()
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
            model1.isBoolean = false
            model1.requiresTyping = true
            model1.position = 1

            val model2 = SingleQuestionModel()
            model2.question = "Where is your Location/Country? "
            model2.isBoolean = false
            model2.requiresTyping = true
            model1.position = 2

            val model3 = SingleQuestionModel()
            model3.question = "Where is your State/Providence/City?"
            model3.isBoolean = false
            model3.requiresTyping = true
            model3.position = 3

            val model4 = SingleQuestionModel()
            model4.question = "Street?"
            model4.isBoolean = false
            model4.requiresTyping = true
            model4.position = 4

            val model5 = SingleQuestionModel()
            model5.question = "email address?"
            model5.isBoolean = false
            model5.requiresTyping = true
            model5.position = 5

            val model6 = SingleQuestionModel()
            model6.question = "phone number? "
            model6.isBoolean = false
            model6.requiresTyping = true
            model6.position = 6

            val model7 = SingleQuestionModel()
            model7.question = "Type of service required? "
            model7.requiresTyping = true
            model7.isBoolean = false
            model7.position = 7

            val model8 = SingleQuestionModel()
            model8.question = "Bullet points of issues requiring legal services? "
            model8.requiresTyping = true
            model8.isBoolean = false

            val model9 = SingleQuestionModel()
            model9.question = "Are you willing to pay for the service? (Yes/No)"
            model9.isBoolean = true
            model9.requiresTyping = false

            val model10 = SingleQuestionModel()
            model10.question = "what is your budget? (please specify currency in words)"
            model10.isBoolean = false
            model10.requiresTyping = true

            val model11 = SingleQuestionModel()
            model11.question = "Do you consent to resonable variations in fees?"
            model11.isBoolean = true
            model11.requiresTyping = false

            val model12 = SingleQuestionModel()
            model12.question = "Are you ready to deposit the balance of the lawyers fee with us to ensure payment upon completion?"
            model12.isBoolean = true
            model12.requiresTyping = false

            val model13 = SingleQuestionModel()
            model13.question = "If no how do you intend to pay?"
            model13.isBoolean = false
            model13.requiresTyping = true

            val model14 = SingleQuestionModel()
            model14.question = "By clicking submit you agree to the terms and conditions of our services and additional terms as included as lawyers?"
            model14.isBoolean = true
            model14.requiresTyping = false

            list.add(model1)
            list.add(model2)
            list.add(model3)
            list.add(model4)
            list.add(model5)
            list.add(model6)
            list.add(model7)
            list.add(model8)
            list.add(model9)
            list.add(model10)
            list.add(model11)
            list.add(model12)
            list.add(model13)
            list.add(model14)

            return list
        }

    }
}