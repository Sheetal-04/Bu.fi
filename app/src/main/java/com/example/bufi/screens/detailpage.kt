package com.example.bufi.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bufi.R
import com.example.bufi.ui.theme.DarkBgPri
import com.example.bufi.ui.theme.DarkBgSec


@Preview

@Composable
fun DetailPage(navController: NavController){
    Scaffold (
        backgroundColor = DarkBgPri
            ){

        Box(
            Modifier
                .background(color = Color.Transparent)
                .fillMaxSize()
        ){
            Column() {
                Box(modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .height(300.dp)){
                    Image(modifier = Modifier.fillMaxSize() , painter = painterResource(id = R.drawable.bufipng), contentDescription = "bgimage")
                    Box (
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Transparent,
                                        Color.Transparent,
                                        DarkBgPri
                                    )
                                )
                            )
                            ){

                    }
                    Box(
                        modifier = Modifier.padding(all = 30.dp)
                    ) {
                        Button(onClick = {
                                         navController.navigate("home"){
                                             popUpTo("detailpage")
                                         }
                        }
                            , modifier = Modifier.size(height = 60.dp, width = 60.dp),
                            shape = RoundedCornerShape(15),

                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = DarkBgSec,
                                contentColor = Color(0xffffffff)
                            ),
                            elevation = ButtonDefaults.elevation(10.dp)

                        ) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "iconsforwaord")
                        }
                    }

                }
                Text(
                    modifier = Modifier.padding(horizontal = 26.dp, vertical = 22.dp),
                    text = "Dummy Text Of The Printing And Typesetting Industry",color= Color.White,fontSize = 28.sp, fontWeight = FontWeight.ExtraBold,)
                
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    backgroundColor = DarkBgSec,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(33.dp)

                ) {
                    Text(
                        modifier = Modifier.padding(all = 20.dp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 12 ,
                        text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",color= Color.White,fontSize = 16.sp, fontWeight = FontWeight.Normal,)
                }
            }

        }

    }

}

