package com.example.bufi

sealed class NavigationItem(val route:String){
    object Home:NavigationItem("home")
    object splash:NavigationItem("intro")
    object DetailPage:NavigationItem("detailpage")
}
