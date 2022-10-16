package com.example.bufi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Preview(showBackground = true)
@Composable
fun IntroScreen( navController: NavController ) {
    val openSans = FontFamily(
        Font(com.example.bufi.R.font.opensans_extrabold, FontWeight.ExtraBold),
        Font(com.example.bufi.R.font.opensans_bold, FontWeight.Bold),
        Font(com.example.bufi.R.font.opensans_italic, FontWeight.Medium),
    )
    Scaffold (
        backgroundColor = Color.Black
    ){
        Box(

        ) {
            Image(
                modifier = Modifier.size(size = 500.dp),
                contentScale = ContentScale.FillHeight,
                painter = painterResource(
                    id = com.example.bufi.R.drawable.introbackground), contentDescription ="backrgroundimage" )

        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Spacer(modifier = Modifier.size(size = 250.dp))
                Text(text ="Bu.fi" ,color = Color( 0xffFFC700), fontSize = 96.sp, fontWeight = FontWeight.ExtraBold, fontFamily = openSans
                )
                Spacer(modifier = Modifier.size(size = 50.dp))
                Button(onClick = { navController.navigate("home") }
                    , modifier = Modifier.size(height = 60.dp, width = 60.dp),
                    shape = RoundedCornerShape(15),

                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF4B4B4B),
                        contentColor = Color(0xffffffff)
                    ),
                    elevation = ButtonDefaults.elevation(10.dp)

                ) {
                    Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "iconsforwaord")
                }
            }
        }

    }


}