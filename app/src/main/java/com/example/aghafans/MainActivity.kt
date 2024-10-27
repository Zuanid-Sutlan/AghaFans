package com.example.aghafans

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.aghafans.presentation.components.ModifiedBottomBar
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.aghafans.presentation.navigations.SetUpNavGraph
import com.example.aghafans.ui.theme.AghaFansTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Hide the status bar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        installSplashScreen().apply {

            // Conditional visibility part
//            setKeepOnScreenCondition {
//                // It will wait for API to conclude
//                // It will keep its visibility until the condition remains true
//                !homeViewModel.apiResponse.value
//            }

            // Animation part
            setOnExitAnimationListener { sp ->
                // Create your custom animation.
                sp.iconView.animate().rotation(180F).duration = 3000L
                val slideUp = ObjectAnimator.ofFloat(
                    sp.iconView,
                    View.TRANSLATION_Y,
                    0f,
                    -sp.iconView.height.toFloat()
                )
                slideUp.interpolator = AnticipateInterpolator()
                slideUp.duration = 3000L

                // Call SplashScreenView.remove at the end of your custom animation.
                slideUp.doOnEnd { sp.remove() }

                // Run your animation.
                slideUp.start()
            }
        }

        appContext = this
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            var currentScreenIndex by rememberSaveable { mutableIntStateOf(0) }

            AghaFansTheme(darkTheme = isSystemInDarkTheme()) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
//                        ModifiedBottomBar(
////                            modifier = Modifier.align(Alignment.BottomCenter),
//                            currentScreenIndex = currentScreenIndex,
//                            onItemSelected = { index, route ->
//                                navController.navigate(route)
//                                currentScreenIndex = index
//                            }
//                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                    ){
                        SetUpNavGraph(navController = navController)

                    }
                }
            }
        }
    }

    companion object{
        lateinit var appContext : Context
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AghaFansTheme {
        Greeting("Android")
    }
}