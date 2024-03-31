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
import com.phearak.aba_mobile.screens.FavoriteScreen
import com.phearak.aba_mobile.screens.FavoriteTransfer
import com.phearak.aba_mobile.screens.GovernmentServices
import com.phearak.aba_mobile.screens.Home
import com.phearak.aba_mobile.screens.Loan
import com.phearak.aba_mobile.screens.LoansScreen
import com.phearak.aba_mobile.screens.Locator
import com.phearak.aba_mobile.screens.PaymentScreen
import com.phearak.aba_mobile.screens.ScanQrScreen
import com.phearak.aba_mobile.screens.Screens
import com.phearak.aba_mobile.screens.ServicesScreen
import com.phearak.aba_mobile.screens.TransferScreen
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
                    Nav()
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
        drawerContent = {  }) {

            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.screen){
                composable(Screens.Home.screen){ Home(navigationController) }
                composable(Screens.ABAScan.screen){ ScanQrScreen(navigationController) }
                composable(Screens.ABATransfers.screen){ TransfersScreen(navigationController) }
                composable(Screens.Transfer.screen){ TransferScreen(navigationController) }
                composable(Screens.ABAAccounts.screen){ AccountsScreen(navigationController) }
                composable(Screens.ABAServices.screen){ ServicesScreen(navigationController) }
                composable(Screens.FavoriteScreen.screen){ FavoriteScreen(navigationController) }
                composable(Screens.FavoriteTransferScreen.screen){ FavoriteTransfer(navigationController) }
                composable(Screens.AccountOpening.screen){ AccountOpeningScreen(navigationController) }
                composable(Screens.AccountOpening.screen){ AccountOpeningScreen(navigationController) }
                composable(Screens.ABAPayment.screen){ PaymentScreen(navigationController) }
                composable("loan"){ LoansScreen(navigationController) }
            }

    }
}
