package tj.mra.jobs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project.Design.Home
import com.example.project.Design.Second

@Composable
fun Nav_Graph() {

    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_screen"){
        composable("home_screen"){
            Home()
        }
        composable("second_screen"){
            Second()
        }
    }
}