package com.example.ui

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose1.R
import com.example.ui.bottomNav.*
import com.example.ui.viewModels.ProfileViewModel
import com.example.ui.viewModels.ProfileViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        val profileViewModel: ProfileViewModel = viewModel(
            LocalViewModelStoreOwner.current!!,
            "ProfileViewModel",
            ProfileViewModelFactory(
                LocalContext.current.applicationContext
                    as Application
            )
        )

        Scaffold(
            bottomBar = { BottomNavigationBar(navController) }
        ) {
            Navigation(navController = navController, profileViewModel = profileViewModel)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        MainScreen()
    }

    @Composable
    fun BottomNavigationBar(navController: NavController) {
        val items = listOf(
            BottomNavItem.Profile,
            BottomNavItem.Projects,
            BottomNavItem.Following,
            BottomNavItem.Stars,
        )
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.purple_700),
            contentColor = Color.White
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = null
                        )
                    },
                    label = { Text(stringResource(item.title)) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            // Avoid multiple copies of the same destination when
                            // re-selecting the same item
                            launchSingleTop = true
                            // Restore state when re-selecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

    @Composable
    fun Navigation(navController: NavHostController, profileViewModel: ProfileViewModel) {
        NavHost(navController, startDestination = BottomNavItem.Profile.route) {
            composable(BottomNavItem.Profile.route) {
                Profile(onChange = {
                    profileViewModel.saveInput(it)
                })
            }
            composable(BottomNavItem.Stars.route) {
                Stars()
            }
            composable(BottomNavItem.Projects.route) {
                Projects()
            }
            composable(BottomNavItem.Following.route) {
                Following()
            }
        }
    }
}
