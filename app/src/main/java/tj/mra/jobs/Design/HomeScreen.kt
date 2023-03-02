@file:Suppress("UNNECESSARY_SAFE_CALL")

package com.example.project.Design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tj.mra.jobs.Nav_Graph
import tj.mra.jobs.R
import tj.mra.jobs.list

@Composable
fun Home() {
    Head()
}
@Preview(showBackground =true)
@Composable
fun Head() {
    var navController = rememberNavController()
    Column {

      Scaffold(
          modifier = Modifier,
          topBar = {TopAppBar(title = { Text(text = "MRA Jobs", fontSize = 28.sp, modifier = Modifier.padding(start = 20.dp))}
          , backgroundColor = colorResource(id = R.color.background_topBar)
          ); }
      ) {
          Column {
              LazyColumn(){
                  items(items = list) {
                      CardDemo(textTitle = it.title, textDesc = it.desc)
                  }
              }


              NavHost(navController = navController, startDestination = "home_screen"){
                  composable("home_screen"){
                      Home()
                  }
                  composable("second_screen"){
                      Second()
                  }
              }

          }


      }



    }
}



@Composable
fun CardDemo(textTitle:String,textDesc:String) {
    var navController:NavHostController = rememberNavController()

    Box(modifier = Modifier.padding(top = 16.dp, start = 25.dp, end = 25.dp, bottom = 16.dp)) {

        Column {

            Card(modifier = Modifier
                .width(360.dp)
                .height(226.dp),
                elevation = 2.dp,
                shape = RoundedCornerShape(10.dp),
                backgroundColor = colorResource(id = R.color.background_topBar)) {
                Column {
                    Text(
                        text = "$textTitle",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp, start = 16.dp)
                    )

                    Text(
                        text = "$textDesc",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(
                            top = 16.dp,
                            start = 16.dp,
                            end = 16.dp,
                        ),
                    )

                    Button(
                        modifier = Modifier
                            .padding(start = 200.dp, top = 10.dp)
                            .width(140.dp)
                            .height(40.dp)
                           ,
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.button_color)),
                        onClick = {
                            navController.navigate("second_screen")
                        }) {
                                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                                Text(text = "Подробное")
                    }
                }




            }

        }

    }

}






