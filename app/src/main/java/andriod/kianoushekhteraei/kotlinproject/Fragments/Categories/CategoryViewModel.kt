package andriod.kianoushekhteraei.kotlinproject.Fragments.Categories

import andriod.kianoushekhteraei.kotlinproject.domain.model.Product
import andriod.kianoushekhteraei.kotlinproject.repository.ProductRepository
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel
@Inject constructor(

    val repository: ProductRepository

) : ViewModel() {

    val products =  MutableLiveData<List<Product>> ()

    val loading = mutableStateOf(false)


    init {

        viewModelScope.launch {

            newSearch()
        }

    }

    private suspend fun newSearch() {

        loading.value = true


        val result = repository.get(
        )
        products.value = result

        loading.value = false
    }


}


