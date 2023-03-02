package tj.mra.jobs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tj.mra.jobs.Design.Home
import tj.mra.jobs.Design.Second

@Composable
fun Nav_Graph() {

    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_screen"){
        composable("home_screen"){
            Home(navController)
        }
        composable("second_screen"){
            Second(navController)
        }
    }
}