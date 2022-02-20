package andriod.kianoushekhteraei.kotlinproject.Components

import andriod.kianoushekhteraei.kotlinproject.Components.Theme.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.ui.tooling.preview.Preview


private val LightThemeColors = lightColors(
    primary = Gray300,
    primaryVariant = Gray400,
    onPrimary = Black1,
    secondary = Color.White,
    secondaryVariant = Gray500,
    onSecondary = Color.Black,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Grey1,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Black2,
)
//
//private val DarkThemeColors = darkColors(
//    primary = Blue700,
//    primaryVariant = Color.White,
//    onPrimary = Color.White,
//    secondary = Black1,
//    onSecondary = Color.White,
//    error = RedErrorLight,
//    background = Color.Black,
//    onBackground = Color.White,
//    surface = Black1,
//    onSurface = Color.White,
//)


@ExperimentalMaterialApi
@Composable
fun AppTheme(
    darkTheme: Boolean,
    displayProgressBar: Boolean,
    scaffoldState: ScaffoldState,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = lightColors(),
//        typography = QuickSandTypography,
//        shapes = AppShapes
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            content()
            CircularIndeterminateProgressBar(isDisplayed = displayProgressBar, 0.3f)
            DefaultSnackbar(
                snackbarHostState = scaffoldState.snackbarHostState,
                onDismiss = {
                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
