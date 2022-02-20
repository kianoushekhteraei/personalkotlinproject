package andriod.kianoushekhteraei.kotlinproject.Fragments.Home

import andriod.kianoushekhteraei.kotlinproject.domain.model.Cocktail
import andriod.kianoushekhteraei.kotlinproject.repository.CocktailRepository
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val repository: CocktailRepository,
): ViewModel() {

    private val cocktail : MutableState<List<Cocktail>> = mutableStateOf(ArrayList())

    val loading = mutableStateOf(false)

    init {

        viewModelScope.launch {

            newSearch()

        }
    }

    private suspend fun newSearch() {

        loading.value = true

        delay(500)

        val result = repository.get(
        )
        cocktail.value = result

        loading.value = false
    }
}

