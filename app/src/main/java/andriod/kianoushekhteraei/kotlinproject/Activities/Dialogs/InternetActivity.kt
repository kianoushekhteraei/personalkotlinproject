package andriod.kianoushekhteraei.kotlinproject.Activities.Dialogs

import andriod.kianoushekhteraei.kotlinproject.Components.Base.BaseActivity
import andriod.kianoushekhteraei.kotlinproject.databinding.ActivityInternetBinding
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup

class InternetActivity : BaseActivity() {
    private lateinit var binding: ActivityInternetBinding
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        defineBinding()
        defineDialog()
        setListeners()
    }

    private fun defineBinding() {
        binding = ActivityInternetBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun setListeners() {

        binding.btnMobileData.setOnClickListener { goToDataMobile() }
        binding.btnWifi.setOnClickListener { goToWifi() }
    }

    fun goToWifi() {

        startActivity(Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
//        val start = Intent(Intent.ACTION_MAIN,null)
//        start.addCategory(Intent.CATEGORY_LAUNCHER)
//        val cn = ComponentName("com.android.settings", "com.android.settings.Settings.wifi.WifiSettings")
//        start.component = cn
//        start.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//        startActivity(start)

    }

    fun goToDataMobile() {

        val intent = Intent()
        intent.component = ComponentName("com.android.settings", "com.android.settings.Settings\$DataUsageSummaryActivity"
        )
        startActivity(intent)
    }

    private fun defineDialog() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {

            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        val mWidth: ViewGroup.LayoutParams = binding.clRootInternet.layoutParams

        mWidth.width = getDisplayWidth(context) - 100

        binding.clRootInternet.setLayoutParams(mWidth)

    }
}

