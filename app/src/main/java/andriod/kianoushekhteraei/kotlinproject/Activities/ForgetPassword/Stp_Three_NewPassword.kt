package andriod.kianoushekhteraei.kotlinproject.Activities.ForgetPassword

import andriod.kianoushekhteraei.kotlinproject.Activities.Main.MainActivity
import andriod.kianoushekhteraei.kotlinproject.Components.Base.BaseActivity
import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.databinding.StpThreeNewPasswordBinding
import android.content.Context
import android.os.Bundle
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.bumptech.glide.Glide

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
class Stp_Three_NewPassword : BaseActivity() {

    private lateinit var binding:StpThreeNewPasswordBinding
    private lateinit var context:Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        defineBinding()
        setImages()
        setUpListeners()
    }

    private fun defineBinding() {

        binding = StpThreeNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setUpListeners(){

        binding.btnChangePassword.setOnClickListener {

            changeActivity(context,MainActivity::class.java)
        }
    }

    private fun setImages() {

        Glide.with(context).load(R.drawable.logo).into(binding.ivLogoStpThreeNewPassword)
    }
}