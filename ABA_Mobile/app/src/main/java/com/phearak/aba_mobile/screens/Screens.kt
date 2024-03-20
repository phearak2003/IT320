package com.phearak.aba_mobile.screens

sealed class Screens(val screen: String){
    data object Home:Screens("home")
    data object Locator:Screens("locator")
    data object GovernmentServices:Screens("governmentServices")
    data object ABACashBack:Screens("abaCashBack")
}
