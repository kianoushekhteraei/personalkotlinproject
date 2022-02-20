package andriod.kianoushekhteraei.kotlinproject.Activities.ForgetPassword

import andriod.kianoushekhteraei.kotlinproject.Components.Base.BaseActivity
import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.databinding.StpOneGetEmailBinding
import android.content.Context
import android.os.Bundle
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.bumptech.glide.Glide

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
class StpOne_GetEmail : BaseActivity() {
    private lateinit var binding: StpOneGetEmailBinding
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        defineBinding()
        setImages()
        setUpListeners()
    }

    private fun defineBinding(){

        binding = StpOneGetEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setImages(){

        Glide.with(context).load(R.drawable.logo).into(binding.ivLogoStpOneGetEmail)
    }

    private fun setUpListeners(){
        binding.btnGetVerificationCode.setOnClickListener {

            changeActivity(context,StpTwo_VerifyCode::class.java)
        }
    }
}