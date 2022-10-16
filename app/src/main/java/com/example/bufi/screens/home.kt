@file:OptIn(ExperimentalPagerApi::class)

package com.example.bufi

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bufi.ui.theme.DarkBgPri
import com.example.bufi.ui.theme.DarkBgSec
import com.example.bufi.ui.theme.YelloPri
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay




@Preview

@Composable
fun Homepage ( navController: NavController){
    val openSans = FontFamily(
        Font(R.font.opensans_extrabold, FontWeight.ExtraBold),
        Font(R.font.opensans_bold, FontWeight.Bold),
        Font(R.font.opensans_italic, FontWeight.Medium),
    )
    Scaffold(
        backgroundColor = DarkBgPri
    ) {
        Column {
            TopAppBar(modifier = Modifier.height(120.dp),
                backgroundColor = Color.Transparent
            ) {
                Spacer(modifier = Modifier.width(40.dp))
                Card (
                    backgroundColor =   DarkBgSec,
                    elevation = 20.dp,
                    shape = RoundedCornerShape(14.dp)
                ){
                    Text(modifier = Modifier.padding(vertical = 10.dp , horizontal = 25.dp), text ="Bu.fi" ,color = Color( 0xffFFC700), fontSize = 36.sp, fontWeight = FontWeight.ExtraBold, fontFamily = openSans
                    )


                }
                Spacer(modifier = Modifier.weight(1.0F))
                Box(Modifier.padding(end = 40.dp)){
                    IconButton(onClick = { navController.navigate("detailpage") }) {
                        Image(modifier = Modifier.size(48.dp),painter = painterResource(id = R.drawable.moreicon), contentDescription ="dsfs" )

                    }

                }

            }
            Box(modifier = Modifier.fillMaxWidth())
            {
                Homebggrid()
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {


                    Box(
                        Modifier
                            .background(color = Color.Transparent)
                            .width(340.dp)){
                        Text(text = "Info_Channel for the University",modifier = Modifier.padding(start = 40.dp, top = 20.dp) ,color = Color.White, fontSize = 38.sp, fontWeight = FontWeight.ExtraBold, fontFamily = openSans)

                    }
                    Image(modifier = Modifier.size(48.dp),painter = painterResource(id = R.drawable.uyellobg), contentDescription ="uicon" )

                }
            }
            Row(
                modifier = Modifier.padding(top = 32.dp, bottom = 10.dp)
            ) {
                Text(
                    modifier = Modifier.padding(start = 46.dp),
                    text = "Notification",color= Color.White,fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, fontFamily = openSans)

                Spacer(modifier = Modifier.weight(1.0F))
                Box(Modifier.padding(end = 40.dp)) {
                    Icon( modifier = Modifier.size(31.dp), tint = Color.White,imageVector = Icons.Outlined.Notifications , contentDescription = "sn")

                }

            }
            Box(modifier = Modifier.height(200.dp)){
                ListCarousel(bgcolor = Color.Transparent , navController)
            }
            Row(
                modifier = Modifier.padding(top = 32.dp, bottom = 10.dp)
            ) {
                Text(
                    modifier = Modifier.padding(start = 46.dp),
                    text = "Upcomming Events",color= Color.White,fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, fontFamily = openSans)
                Spacer(modifier = Modifier.weight(1.0F))

                Box(Modifier.padding(end = 40.dp)) {
                    Icon( modifier = Modifier.size(31.dp), tint = Color.White,imageVector = Icons.Outlined.Notifications , contentDescription = "sn")

                }

            }
            Box(modifier = Modifier.height(200.dp)){
                ListCarousel(bgcolor = YelloPri , navController )
            }



        }
    }

}

@Composable
fun Homebggrid(){

    Column {

        for ( i in 1..15){
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = if(!listOf<Int>(8,11).contains(i) ){
                    var gray = Color.Gray
                    gray
                }else YelloPri
                )
            )
        }
    }
}


@Composable
fun ListCarousel( bgcolor :Color , navController: NavController) {

    val carouselText = listOf(
        "Bitcoin latest price is now at $100000",
        "Eth is on the verge of surpassing bitcoin's market capitalization",
        "Harmony one is the latestest coin to hit the $10 price mark!!"
    )
    val carouseldiscription = listOf(
        "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet ",
        "Eth is on the verge of surpassing bitcoin's market capitalization",
        "Harmony one is the latestest coin to hit the $10 price mark!!"
    )
    val pageState = rememberPagerState()
    Row {
        HorizontalPager(
            state = pageState,
            count = carouselText.size
        ){
                page ->Card(
                elevation = 8.dp,
                shape = RoundedCornerShape(18.dp),
                backgroundColor = bgcolor,

                modifier = Modifier
                    .size(width = 390.dp, height = 160.dp)
                    .padding(start = 30.dp, end = 30.dp, top = 16.dp)
                    .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(24.dp)).clickable { var onClick = {
                        navController.navigate("detailpage")
                    } }
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(all = 20.dp),
                ) {
                    Text(modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        text = carouselText[page],
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        fontWeight= FontWeight.Bold,


                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        color = Color.White,
                        text = carouseldiscription[page],
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 12.sp,
                        textAlign =TextAlign.Left,


                    )

                }
            }


        }
    }
    LaunchedEffect(pageState.currentPage) {
        // wait for 3 seconds.
        delay(3000)
        // increasing the position and check the size
        var newPosition = pageState.currentPage + 1
        if (newPosition > carouselText.lastIndex) newPosition = 0
        // scrolling to the new position(starting from the beginning).
        pageState.animateScrollToPage(newPosition)
    }
}
