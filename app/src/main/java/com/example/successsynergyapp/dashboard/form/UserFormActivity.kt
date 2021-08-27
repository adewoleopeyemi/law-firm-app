package com.example.successsynergyapp.dashboard.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
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
import com.example.successsynergyapp.dashboard.form.adapters.AdapterSingleQuestion
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
    var TAG = "UserFormActiivity"


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
            registerData(adapter!!)
            Toast.makeText(applicationContext, ""+ adapter!!.currentAnswer.question, Toast.LENGTH_SHORT).show()
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

    private fun registerData(adapter: AdapterSingleQuestion) {
        if (adapter!!.currentAnswer.question ==ques1){
            form.first_name = adapter!!.currentAnswer.answer
            Toast.makeText(applicationContext, "first name entered", Toast.LENGTH_SHORT).show()
        }
        else if (adapter!!.currentAnswer.question == ques2){
            form.surname = adapter!!.currentAnswer.answer
            Toast.makeText(applicationContext, "qeustion 2 entered", Toast.LENGTH_SHORT).show()
        }
        else if (adapter!!.currentAnswer.question == ques3){
            form.location = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == ques4){
            form.state = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == ques5){
            form.street = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == quest6){
            form.email_address = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == quest7){
            form.phone_number = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == quest8){
            form.type_of_service = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == quest9){
            form.bullet_point = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == quest10){
            form.willing_to_pay = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == quest11){
            form.budget = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == quest12){
            form.ready_to_deposit = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == quest13){
            form.intend_to_pay = adapter!!.currentAnswer.answer
        }
        else if (adapter!!.currentAnswer.question == quest14){
            form.agreed = adapter!!.currentAnswer.answer
        }
    }

    var adapter: AdapterSingleQuestion? = null
    private fun initialize() {
        adapter = AdapterSingleQuestion(getData(), applicationContext)
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
        binding.cardStackView.adapter = adapter
        //mOnlineTestAdapter.addItems(getData())
        binding.cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }
    var ques1 = "What is your full name?"
    var ques2 = "What is your surname?"
    var ques3 = "Where is your Location/Country?"
    var ques4 = "Where is your State/Providence/City?"
    var ques5 = "Your Street?"
    var quest6 = "email address?"
    var quest7 = "phone number? "
    var quest8 = "Type of service required? "
    var quest9 = "Bullet points of issues requiring legal services? "
    var quest10 = "Are you willing to pay for the service? (Yes/No)"
    var quest11 = "what is your budget? (please specify currency in words)"
    var quest12 = "Do you consent to resonable variations in fees?"
    var quest13 = "Are you ready to deposit the balance of the lawyers fee with us to ensure payment upon completion?"
    var quest14 = "If no how do you intend to pay?"
    var quest15 = "By clicking submit you agree to the terms and conditions of our services and additional terms as included as lawyers?"
    companion object{
        fun getData(): ArrayList<SingleQuestionModel> {
            val list = ArrayList<SingleQuestionModel>()
            val model1 = SingleQuestionModel()
            model1.question = "What is your full name?"
            model1.isBoolean = false
            model1.requiresTyping = true
            model1.position = 1

            val model2 = SingleQuestionModel()
            model2.question = "What is your surname?"
            model2.isBoolean = false
            model2.requiresTyping = true
            model2.position = 2

            val model3 = SingleQuestionModel()
            model3.question = "Where is your Location/Country?"
            model3.isBoolean = false
            model3.requiresTyping = true
            model3.position = 3

            val model4 = SingleQuestionModel()
            model4.question = "Where is your State/Providence/City?"
            model4.isBoolean = false
            model4.requiresTyping = true
            model4.position = 4

            val model5 = SingleQuestionModel()
            model5.question = "Your Street?"
            model5.isBoolean = false
            model5.requiresTyping = true
            model5.position = 5

            val model6 = SingleQuestionModel()
            model6.question = "email address?"
            model6.isBoolean = false
            model6.requiresTyping = true
            model6.position = 6

            val model7 = SingleQuestionModel()
            model7.question = "phone number? "
            model7.isBoolean = false
            model7.requiresTyping = true
            model7.position = 7

            val model8 = SingleQuestionModel()
            model8.question = "Type of service required? "
            model8.requiresTyping = true
            model8.isBoolean = false
            model8.position = 8

            val model9 = SingleQuestionModel()
            model9.question = "Bullet points of issues requiring legal services? "
            model9.requiresTyping = true
            model9.isBoolean = false
            model9.position = 9

            val model10 = SingleQuestionModel()
            model10.question = "Are you willing to pay for the service? (Yes/No)"
            model10.isBoolean = true
            model10.requiresTyping = false
            model10.position = 10

            val model11 = SingleQuestionModel()
            model11.question = "what is your budget? (please specify currency in words)"
            model11.isBoolean = false
            model11.requiresTyping = true
            model11.position = 11

            val model12 = SingleQuestionModel()
            model12.question = "Do you consent to resonable variations in fees?"
            model12.isBoolean = true
            model12.requiresTyping = false

            val model13 = SingleQuestionModel()
            model13.question = "Are you ready to deposit the balance of the lawyers fee with us to ensure payment upon completion?"
            model13.isBoolean = true
            model13.requiresTyping = false
            model13.position = 13

            val model14 = SingleQuestionModel()
            model14.question = "If no how do you intend to pay?"
            model14.isBoolean = false
            model14.requiresTyping = true
            model14.position = 14

            val model15 = SingleQuestionModel()
            model15.question = "By clicking submit you agree to the terms and conditions of our services and additional terms as included as lawyers?"
            model15.isBoolean = true
            model15.requiresTyping = false
            model15.position = 15

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
            list.add(model15)

            return list
        }

    }
}