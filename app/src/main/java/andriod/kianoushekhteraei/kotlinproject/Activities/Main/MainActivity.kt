package andriod.kianoushekhteraei.kotlinproject.Activities.Main

import andriod.kianoushekhteraei.kotlinproject.Components.Base.BaseActivity
import andriod.kianoushekhteraei.kotlinproject.Fragments.Categories.FragmentCategories
import andriod.kianoushekhteraei.kotlinproject.Fragments.Home.FragmentHome
import andriod.kianoushekhteraei.kotlinproject.Fragments.Shop.FragmentShop
import andriod.kianoushekhteraei.kotlinproject.Fragments.Profile.FragmentProfile
import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.databinding.ActivityMainBinding
import android.content.Context
import android.os.Bundle
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import dagger.hilt.android.AndroidEntryPoint


@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context
    private var currentFragment : String = "home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        defineBinding()
        setUpListeners()
        defaultFragment()
    }

    private fun defineBinding() {

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpListeners() {
        binding.btmNavigation.llProfile.setOnClickListener {

            fragmentProfile()
        }
        binding.btmNavigation.llCategories.setOnClickListener {

            fragmentCategories()
        }
        binding.btmNavigation.llHome.setOnClickListener {

            fragmentHome()
        }
        binding.btmNavigation.llShop.setOnClickListener {

            fragmentShop()
        }

    }

    private fun defaultFragment() {
        fragmentHome()
    }


    private fun fragmentProfile() {
        deselectFragment(currentFragment)
        currentFragment = "profile"
        binding.btmNavigation.ivIconProfile.setImageDrawable(getDrawable(R.drawable.ic_user_black))
        binding.btmNavigation.tvTitleProfile.setTextColor(getColor(R.color.black))
        changeFragment(FragmentProfile())

    }

    private fun fragmentShop() {
        deselectFragment(currentFragment)
        currentFragment = "shop"
        binding.btmNavigation.ivIconShop.setImageDrawable(getDrawable(R.drawable.ic_shop_black))
        binding.btmNavigation.tvTitleShop.setTextColor(getColor(R.color.black))
        changeFragment(FragmentShop())
    }

    private fun fragmentCategories() {
        deselectFragment(currentFragment)
        currentFragment = "categories"
        binding.btmNavigation.ivIconCategory.setImageDrawable(getDrawable(R.drawable.ic_category_black))
        binding.btmNavigation.tvTileCategories.setTextColor(getColor(R.color.black))
        changeFragment(FragmentCategories())

    }

    private fun fragmentHome() {
        deselectFragment(currentFragment)
        currentFragment = "home"
        binding.btmNavigation.ivIconHome.setImageDrawable(getDrawable(R.drawable.ic_home_black))
        binding.btmNavigation.tvTitleHome.setTextColor(getColor(R.color.black))
        changeFragment(FragmentHome())

    }

    private fun deselectFragment(item: String) {

        when (item) {

            "home" -> {
                binding.btmNavigation.ivIconHome.setImageDrawable(getDrawable(R.drawable.ic_home_white))
                binding.btmNavigation.tvTitleHome.setTextColor(getColor(R.color.white))

            }
            "profile" -> {
                binding.btmNavigation.ivIconProfile.setImageDrawable(getDrawable(R.drawable.ic_user_white))
                binding.btmNavigation.tvTitleProfile.setTextColor(getColor(R.color.white))

            }
            "categories" -> {
                binding.btmNavigation.ivIconCategory.setImageDrawable(getDrawable(R.drawable.ic_category_white))
                binding.btmNavigation.tvTileCategories.setTextColor(getColor(R.color.white))
            }
            "shop" -> {
                binding.btmNavigation.ivIconShop.setImageDrawable(getDrawable(R.drawable.ic_shop_white))
                binding.btmNavigation.tvTitleShop.setTextColor(getColor(R.color.white))
            }


        }

    }

}