package andriod.kianoushekhteraei.kotlinproject.Activities.Login

import andriod.kianoushekhteraei.kotlinproject.Activities.ForgetPassword.StpOne_GetEmail
import andriod.kianoushekhteraei.kotlinproject.Activities.Main.MainActivity
import andriod.kianoushekhteraei.kotlinproject.Activities.SignUp.SignUpActivity
import andriod.kianoushekhteraei.kotlinproject.Components.Base.BaseActivity
import andriod.kianoushekhteraei.kotlinproject.Components.Base.SPClass
import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.databinding.ActivityLoginBinding
import android.content.Context
import android.os.Bundle
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.bumptech.glide.Glide

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var context: Context
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var sp : SPClass

    private val emailPattern: String = "[a-zA-Z0-9+-_]+@[a-z]+\\.+[a-z]+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        sp = SPClass(context)
        defineBinding()
        setImages()
        setUpListeners()

    }

    private fun setUpListeners(){
        binding.btnLogin.setOnClickListener {
            getEmail()
            if (checkEmail()) {

                getPassword()
                if (checkPassword()) {
                    sp.saveBoolean(sp.User_Login,true)
                    changeActivity(context,MainActivity::class.java)

                } else {


                }

            }

        }

        binding.tvTitleMakeAccount.setOnClickListener {

            changeActivity(context,SignUpActivity::class.java)

        }
        binding.tvTitleForgetPassword.setOnClickListener {

            changeActivity(context,StpOne_GetEmail::class.java)


        }

    }

    private fun defineBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun getEmail() {
       email =  binding.etUsernameLogin.getText().toString()
    }

    private fun getPassword() {

       password =  binding.etPasswordLogin.getText().toString()

    }

    private fun setImages(){

        Glide.with(context).load(R.drawable.logo).into(binding.ivLogoLogin)
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