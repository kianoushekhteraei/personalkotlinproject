package andriod.kianoushekhteraei.kotlinproject.Activities.Splash

import andriod.kianoushekhteraei.kotlinproject.Activities.Dialogs.InternetActivity
import andriod.kianoushekhteraei.kotlinproject.Activities.Login.LoginActivity
import andriod.kianoushekhteraei.kotlinproject.Activities.Main.MainActivity
import andriod.kianoushekhteraei.kotlinproject.Components.Base.BaseActivity
import andriod.kianoushekhteraei.kotlinproject.Components.Base.SPClass
import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.databinding.ActivitySplashBinding
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.bumptech.glide.Glide

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
class SplashActivity : BaseActivity() {

    private lateinit var binding:ActivitySplashBinding
    private lateinit var anim: Animation
    private lateinit var context: Context
    private val TIME_OUT : Long = 2500
    private lateinit var sp : SPClass


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        sp = SPClass(context)
        defineBinding()
        showSplash()
        setImages()
        defineAnim()

    }

    private fun showSplash() {

        Handler().postDelayed(
            {
                if (checkNetwork()) {
                    if (sp.getBoolean(sp.User_Login)==true){

                        changeActivity(context,MainActivity::class.java)

                    }else{

                        changeActivity(context,LoginActivity::class.java)
                    }
                    finish()

                } else {
                    changeActivity(context,InternetActivity::class.java)
                }

            }, TIME_OUT
        )
    }

    private fun defineBinding() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setImages() {
        Glide.with(context).load(R.drawable.logo).into(binding.ivLogoSplash)
    }

    private fun defineAnim() {
        anim = AnimationUtils.loadAnimation(context,R.anim.fade_in)
        binding.ivLogoSplash.startAnimation(anim)

    }
}