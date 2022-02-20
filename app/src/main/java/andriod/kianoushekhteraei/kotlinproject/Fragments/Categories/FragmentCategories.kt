package andriod.kianoushekhteraei.kotlinproject.Fragments.Categories

import andriod.kianoushekhteraei.kotlinproject.Adapters.CategoriesAdp
import andriod.kianoushekhteraei.kotlinproject.Adapters.ProductsAdp
import andriod.kianoushekhteraei.kotlinproject.Adapters.SkillsAdp
import andriod.kianoushekhteraei.kotlinproject.Components.Base.ApplicationClass
import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.databinding.FragmentCategoryBinding
import andriod.kianoushekhteraei.kotlinproject.databinding.FragmentProfileBinding
import andriod.kianoushekhteraei.kotlinproject.domain.model.Categories
import andriod.kianoushekhteraei.kotlinproject.domain.model.Product
import andriod.kianoushekhteraei.kotlinproject.domain.model.Skills
import andriod.kianoushekhteraei.kotlinproject.network.base.ApiClient
import andriod.kianoushekhteraei.kotlinproject.network.base.CategoryFrgServices
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import javax.inject.Inject
import androidx.compose.material.ExperimentalMaterialApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ExperimentalMaterialApi
@AndroidEntryPoint
class FragmentCategories : Fragment() {

    @Inject
    lateinit var application: ApplicationClass

    lateinit var viewModel: CategoryViewModel

    lateinit var binding: FragmentCategoryBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)

        defineRecycler()

        defineRecyclerSelectCategory()

        return binding.root
    }

    private fun defineRecyclerSelectCategory() {

        val categories : ArrayList<Categories> = arrayListOf()

        for (i in 1..10) {
            categories.add(Categories(1, "دسته بندی ها" + i))
        }

        binding.rvSelectCategory.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,true)
            adapter = CategoriesAdp(categories)
        }

    }

    private fun defineRecycler() {


        val request = ApiClient.buildServiceProduct(CategoryFrgServices::class.java)
        val call = request.getProducts()

        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    binding.progressBarCategory.visibility = View.GONE
                    binding.rvProducts.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = ProductsAdp(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {

                Toast.makeText(requireContext(), "${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}





