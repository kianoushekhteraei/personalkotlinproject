package andriod.kianoushekhteraei.kotlinproject.Activities.ForgetPassword

import andriod.kianoushekhteraei.kotlinproject.Components.Base.BaseActivity
import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.databinding.StpTwoVerifyCodeBinding
import android.content.Context
import android.os.Bundle
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.bumptech.glide.Glide

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
class StpTwo_VerifyCode : BaseActivity() {

    private lateinit var binding : StpTwoVerifyCodeBinding
    private lateinit var context : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        defineBinding()
        setImages()
        setUpListeners()
    }

    private fun defineBinding() {

        binding = StpTwoVerifyCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setUpListeners(){

        binding.btnGetVerificationCode.setOnClickListener {

            changeActivity(context,Stp_Three_NewPassword::class.java)
        }
    }

    private fun setImages() {

        Glide.with(context).load(R.drawable.logo).into(binding.ivLogoStpTwoVerifyCode)
    }
}