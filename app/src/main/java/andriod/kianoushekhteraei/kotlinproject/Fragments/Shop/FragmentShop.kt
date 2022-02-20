package andriod.kianoushekhteraei.kotlinproject.Fragments.Shop

import andriod.kianoushekhteraei.kotlinproject.Components.*
import andriod.kianoushekhteraei.kotlinproject.Components.Base.ApplicationClass
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class FragmentShop : Fragment() {

    @Inject
    lateinit var application: ApplicationClass

    private val snackbarController = SnackController(lifecycleScope)


    private val viewModel: ShopViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {

            setContent {

                val recipes = viewModel.recipes.value

                val query = viewModel.query.value

                val selectedCategory = viewModel.selectedCategory.value

                val loading = viewModel.loading.value

                val page = viewModel.page.value

                val scaffoldState = rememberScaffoldState()

                AppTheme(
                    displayProgressBar = loading,
                    scaffoldState = scaffoldState,
                    darkTheme = application.isDark.value,
                ) {

                    Scaffold(
                        topBar = {
                            SearchAppBar(
                                query = query,
                                onQueryChanged = viewModel::onQueryChanged,
                                onExecuteSearch = {


                                    // Search All  Content  of Categories
                                    viewModel.onTriggerEvent(RecipeListEvent.NewSearchEvent)

                                    // Show SnackBar For Selected Category
//                                    if (viewModel.selectedCategory.value?.value == "Milk") {
//                                        snackbarController.getScope().launch {
//                                            snackbarController.showSnackbar(
//                                                scaffoldState = scaffoldState,
//                                                message = "Invalid category: MILK",
//                                                actionLabel = "Hide"
//                                            )
//                                        }
//                                    } else {
//                                        viewModel.onTriggerEvent(RecipeListEvent.NewSearchEvent)
//                                    }
                                },
                                categories = getAllFoodCategories(),
                                selectedCategory = selectedCategory,
                                onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                                onToggleTheme = application::toggleLightTheme
                            )
                        },
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        },

                        ) {
                        RecipeList(
                            loading = loading,
                            recipes = recipes,
                            onChangeScrollPosition = viewModel::onChangeRecipeScrollPosition,
                            page = page,
                            onTriggerNextPage = { viewModel.onTriggerEvent(RecipeListEvent.NextPageEvent) },
                            onNavigateToRecipeDetailScreen = {
                                val bundle = Bundle()
                                bundle.putInt("recipeId", it)
//                                findNavController().navigate(R.id.viewRecipe, bundle)
                            }
                        )
                    }
                }
            }

        }
    }
}