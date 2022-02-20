package andriod.kianoushekhteraei.kotlinproject.Fragments.Home

import andriod.kianoushekhteraei.kotlinproject.Adapters.DrinkAdp
import andriod.kianoushekhteraei.kotlinproject.Adapters.ImgSliderAdp
import andriod.kianoushekhteraei.kotlinproject.Components.Base.ApplicationClass
import andriod.kianoushekhteraei.kotlinproject.Components.Base.ItemOffsetDecoration
import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.databinding.FragmentCategoryBinding
import andriod.kianoushekhteraei.kotlinproject.databinding.FragmentHomeBinding
import andriod.kianoushekhteraei.kotlinproject.domain.model.Cocktail
import andriod.kianoushekhteraei.kotlinproject.domain.model.ImgSlider
import andriod.kianoushekhteraei.kotlinproject.network.base.ApiClient
import andriod.kianoushekhteraei.kotlinproject.network.base.HomeFrgServices
import andriod.kianoushekhteraei.kotlinproject.network.model.CocktailDtoMapper
import andriod.kianoushekhteraei.kotlinproject.network.response.CocktailSearchResponse
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class FragmentHome : Fragment() {

    @Inject
    lateinit var application: ApplicationClass

    lateinit var binding: FragmentHomeBinding

    lateinit var adp: DrinkAdp

    lateinit var drinks: ArrayList<Cocktail>

    var currentPage = 0

    val mapper = CocktailDtoMapper()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        initSlider()
        dataSlider()
        defineRecyclerMostSells()
        defineRecyclerMostViews()
        defineRecyclerNewPrd()
        return binding.root
    }

    private fun dataSlider() {

        val request = ApiClient.buildServiceSlider(HomeFrgServices::class.java)
        val call = request.getImgSlider()

        call.enqueue(object : Callback<List<ImgSlider>> {

            override fun onResponse(
                call: Call<List<ImgSlider>>,
                response: Response<List<ImgSlider>>
            ) {
                if (response.isSuccessful)

                    binding.progressBarHome.visibility = View.GONE

                binding.vpSlider.adapter = ImgSliderAdp(response.body()!!, layoutInflater)
                binding.vpSlider.clipToPadding = false
                binding.vpSlider.setPadding(50, 0, 50, 0) // center image padding and scale
                binding.vpSlider.pageMargin = 20 // space between left and right image
                binding.vpSlider.currentItem = currentPage

            }

            override fun onFailure(call: Call<List<ImgSlider>>, t: Throwable) {

                Toast.makeText(requireContext(), "${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initSlider() {

        val displayMetrics = DisplayMetrics()
        (requireActivity()).windowManager.defaultDisplay.getMetrics(displayMetrics)

        val mHeight = binding.vpSlider.layoutParams

        mHeight.height = getScreenHeight(requireContext()) / 3 + 30

        binding.vpSlider.layoutParams = mHeight

        // Auto start of viewpager
        val handler = Handler()
        val update = Runnable {
            if (currentPage == 5) {
                currentPage = 0

            }
            binding.vpSlider.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, 500, 3000)
    }

    private fun getScreenHeight(context: Context): Int {

        val displayMetrics = DisplayMetrics()
        (requireActivity()).windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    private fun getScreenWidth(context: Context): Int {

        val displayMetrics = DisplayMetrics()
        (requireActivity()).windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

    private fun defineRecyclerNewPrd() {
        val request = ApiClient.buildServiceDrink(HomeFrgServices::class.java)
        val call = request.getCocktails()

        call.enqueue(object : Callback<CocktailSearchResponse> {
            override fun onResponse(
                call: Call<CocktailSearchResponse>,
                response: Response<CocktailSearchResponse>
            ) {
                if (response.isSuccessful) {
                    binding.progressBarHome.visibility = View.GONE
                    binding.rvNewPrd.apply {
                        setHasFixedSize(true)
                        this.layoutManager = GridLayoutManager(
                            requireContext(),
                            2
                        )
                        val itemDecoration = ItemOffsetDecoration(2, R.dimen.margin_5dp)
                        this.addItemDecoration(itemDecoration)

                        adapter = DrinkAdp(mapper.toDomainList(response.body()!!.drinks))

                    }
                }
            }

            override fun onFailure(call: Call<CocktailSearchResponse>, t: Throwable) {

                Toast.makeText(requireContext(), "${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun defineRecyclerMostViews() {
        val request = ApiClient.buildServiceDrink(HomeFrgServices::class.java)
        val call = request.getCocktails()

        call.enqueue(object : Callback<CocktailSearchResponse> {
            override fun onResponse(
                call: Call<CocktailSearchResponse>,
                response: Response<CocktailSearchResponse>
            ) {
                if (response.isSuccessful) {
                    binding.progressBarHome.visibility = View.GONE
                    binding.rvMostViewProduct.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(
                            requireContext(),
                            LinearLayoutManager.HORIZONTAL,
                            true
                        )
                        adapter = DrinkAdp(mapper.toDomainList(response.body()!!.drinks))

                    }
                }
            }

            override fun onFailure(call: Call<CocktailSearchResponse>, t: Throwable) {

                Toast.makeText(requireContext(), "${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun defineRecyclerMostSells() {
        val request = ApiClient.buildServiceDrink(HomeFrgServices::class.java)
        val call = request.getCocktails()

        call.enqueue(object : Callback<CocktailSearchResponse> {
            override fun onResponse(
                call: Call<CocktailSearchResponse>,
                response: Response<CocktailSearchResponse>
            ) {
                if (response.isSuccessful) {
                    binding.progressBarHome.visibility = View.GONE
                    binding.rvMostSellProduct.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(
                            requireContext(),
                            LinearLayoutManager.HORIZONTAL,
                            true
                        )
                        adapter = DrinkAdp(mapper.toDomainList(response.body()!!.drinks))

                    }
                }
            }

            override fun onFailure(call: Call<CocktailSearchResponse>, t: Throwable) {

                Toast.makeText(requireContext(), "${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}



