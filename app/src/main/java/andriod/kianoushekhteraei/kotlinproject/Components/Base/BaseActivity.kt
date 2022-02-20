package andriod.kianoushekhteraei.kotlinproject.Components.Base

import andriod.kianoushekhteraei.kotlinproject.R
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper

open class BaseActivity : AppCompatActivity() {

    private lateinit var contex: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contex = this
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
    }


    fun checkNetwork(): Boolean {

        var result = false

        var cm = contex.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {

                    result = when {

                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true

                        else -> false

                    }
                }

            }

        } else {
            cm?.run {

                cm.activeNetworkInfo?.run {

                    if (type == ConnectivityManager.TYPE_WIFI) {

                        result = true


                    } else if (type == ConnectivityManager.TYPE_MOBILE) {

                        result = false
                    }


                }
            }
        }
        return result

    }

    fun getDisplayWidth(context: Context): Int {

        val displayMatrix = DisplayMetrics()

        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMatrix)

        return displayMatrix.widthPixels

    }

    fun showToastLong(message: String){

        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }

    fun changeActivity(context: Context , newActivity:Class<*>?){

        val start = Intent(context,newActivity)
        startActivity(start)

    }

    fun changeFragment(fragment:Fragment){

        supportFragmentManager.beginTransaction().replace(R.id.fl_all,fragment).commit()

    }

}
