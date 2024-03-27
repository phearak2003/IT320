package com.phearak.aba_mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.phearak.aba_mobile.screens.AccountOpeningScreen
import com.phearak.aba_mobile.screens.AccountsScreen
import com.phearak.aba_mobile.screens.GovernmentServices
import com.phearak.aba_mobile.screens.Home
import com.phearak.aba_mobile.screens.LoansScreen
import com.phearak.aba_mobile.screens.Locator
import com.phearak.aba_mobile.screens.ScanQrScreen
import com.phearak.aba_mobile.screens.Screens
import com.phearak.aba_mobile.screens.ServicesScreen
import com.phearak.aba_mobile.screens.TransfersScreen
import com.phearak.aba_mobile.ui.theme.ABA_MobileTheme
import com.phearak.aba_mobile.ui.theme.Primary
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ABA_MobileTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    //ScanQrScreen(navController = navController)
                    //TransfersScreen(navController)
                    //ServicesScreen(navController)
                    //AccountsScreen(navController)
                    AccountOpeningScreen(navController)
                   // Nav()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Nav(){
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)){
                    Text(text = "")
                }

                Divider()

                NavigationDrawerItem(
                    label = {Text(text = "Home", color = Primary)},
                    selected = false,
                    icon = {
                        Icon(imageVector = Icons.Default.Home,
                            contentDescription = "home",
                            tint = Primary)},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }

                        navigationController.navigate(Screens.Home.screen){
                            popUpTo(0)
                        }
                    }
                )

                NavigationDrawerItem(label = {
                    Text(text = "ABA Cash Back", color = Primary)},
                    selected = false,
                    icon = {
                        Icon(imageVector = Icons.Default.Home,
                            contentDescription = "abaCashBack",
                            tint = Primary)},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }

                        Toast.makeText(context, "Cash Back", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }) {
        Scaffold(
            topBar = {
                val corotineScope = rememberCoroutineScope()
                TopAppBar(
                    title = { Text(text = "ABA Bank") },
                    actions = {
                        IconButton(onClick = { /* Handle bell icon click */ }) {
                            Icon(
                                Icons.Rounded.Notifications,
                                tint = Color.White,
                                contentDescription = "Notifications"
                            )
                        }
                        IconButton(onClick = { /* Handle bell icon click */ }) {
                            Icon(
                                Icons.Rounded.AddCircle,
                                tint = Color.White,
                                contentDescription = "Scan"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Primary,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                Icons.Rounded.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.screen){
                composable(Screens.Home.screen){ GovernmentServices() }
                composable(Screens.Home.screen){ Locator() }
                composable(Screens.Home.screen){ Home() }
                composable(Screens.Home.screen){ ScanQrScreen(navigationController) }
                composable(Screens.Home.screen){ TransfersScreen(navigationController) }
                composable(Screens.Home.screen){ AccountsScreen(navigationController) }
                composable(Screens.Home.screen){ ServicesScreen(navigationController) }
            }
        }
    }
}
