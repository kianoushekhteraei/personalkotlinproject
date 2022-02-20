package andriod.kianoushekhteraei.kotlinproject.Activities.SignUp

import andriod.kianoushekhteraei.kotlinproject.Activities.Dialogs.InternetActivity
import andriod.kianoushekhteraei.kotlinproject.Activities.Main.MainActivity
import andriod.kianoushekhteraei.kotlinproject.Components.Base.BaseActivity
import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.databinding.ActivitySignUpBinding
import android.content.Context
import android.os.Bundle
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.bumptech.glide.Glide

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
class SignUpActivity : BaseActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var context : Context
    private lateinit var email : String
    private lateinit var password : String
    private lateinit var confrimPassword : String
    private val emailPattern: String = "[a-zA-Z0-9+-_]+@[a-z]+\\.+[a-z]+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        defineBinding()
        setImages()
        binding.btnSignUp.setOnClickListener {
            
            if (checkNetwork()) {
                doSignUp()
            }else{

                changeActivity(context,InternetActivity::class.java)
            }
            
        }
    }


    private fun defineBinding(){
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setImages(){
        Glide.with(context).load(R.drawable.logo).into(binding.ivLogoSignUp)
    }

    private fun getEmail(){

       email =  binding.etUsernameSignUp.text.toString()

    }
    private fun getPassword(){
     password =    binding.etPasswordSignUp.text.toString()

    }
    private fun getConfirmPassword(){
      confrimPassword =   binding.etConfirmPasswordSignUp.text.toString()

    }

    
    private fun doSignUp(){

        getEmail()
        if (checkEmail()){
            getPassword()
            if (checkPassword()){
                getConfirmPassword()
                if (checkConfirmPassword()){

                    changeActivity(context,MainActivity::class.java)
                }
            }
        }
        
        
        
    }
    private fun checkConfirmPassword():Boolean{


        if (confrimPassword.length == 0){

            return false
            showToastLong("confirm password is empty")

        }else{

            return if (confrimPassword.equals(password)){

                true

            }else{

                showToastLong("password and confirm password is not same")
                false
            }

        }


    }
    private fun checkEmail(): Boolean {

        if (email.length == 0) {

            showToastLong("Username Cant be Empty")

            return false


        } else {

            if (validateEmail(email)) {


                return true

            } else {

                showToastLong("Email is Invalid")

                return false
            }


        }
    }


    private fun checkPassword(): Boolean {


        if (password.length == 0) {

            showToastLong("Password Cant be Empty")

            return false


        } else {

            if (password.length >= 6) {

                return true

            } else {

                showToastLong("Password is Invalid")

                return false
            }


        }


    }

    private fun validateEmail(eml: String): Boolean {

        return eml.matches(emailPattern.toRegex())

    }
}