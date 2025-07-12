package com.vijay.androiddatabase.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.vijay.androiddatabase.data.DbHelper
import com.vijay.androiddatabase.presenter.screens.LoginScreen
import com.vijay.androiddatabase.presenter.screens.ProfileScreen
import com.vijay.androiddatabase.presenter.screens.RegisterScreen
import com.vijay.androiddatabase.presenter.screens.UserListScreen
import com.vijay.androiddatabase.presenter.utils.ScreenNames
import com.vijay.androiddatabase.presenter.utils.UserData
import com.vijay.androiddatabase.ui.theme.AndroidDataBaseTheme

class MainActivity : ComponentActivity() {

    private lateinit var dbHelper : DbHelper
    private var lastEnteredEmail : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dbHelper = DbHelper(applicationContext)
        setContent {
            AndroidDataBaseTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen(modifier: Modifier = Modifier) {
        var screenName by remember { mutableStateOf(ScreenNames.REGISTER_SCREEN) }
        LaunchedEffect(Unit) {
            if (getAllUsers().isNotEmpty()) {
                screenName = ScreenNames.USERS_LIST
            }
        }

        when (screenName) {
            ScreenNames.REGISTER_SCREEN -> {
                RegisterScreen(
                    onRegisterClick = ::registerUser,
                    onBackClick = {
                        screenName = ScreenNames.LOGIN_SCREEN
                    }
                )
            }
            ScreenNames.LOGIN_SCREEN -> {
                LoginScreen(
                    onLoginClick = ::loginUser,
                    onLoginSuccess = {
                        screenName = ScreenNames.PROFILE_SCREEN
                    },
                    onRegisterClick = {
                        screenName = ScreenNames.REGISTER_SCREEN
                    }
                )
            }
            ScreenNames.PROFILE_SCREEN -> {
                ProfileScreen(
                    onBackClick = {
                        screenName = ScreenNames.LOGIN_SCREEN
                    },
                    userData = getUserData(email = lastEnteredEmail.orEmpty()),
                    getAllUserClick = {
                        screenName = ScreenNames.USERS_LIST
                    }
                )
            }

            ScreenNames.USERS_LIST -> {
                UserListScreen(
                    usersList= getAllUsers(),
                    onBackClick = {
                        screenName = ScreenNames.LOGIN_SCREEN
                    }
                )
            }
        }
    }

    fun getAllUsers() = dbHelper.getAllUsersHelper()

    fun getUserData(email: String) : UserData? {
        return dbHelper.getUserDetails(email)
    }


    fun loginUser(
        email: String,
        pass : String
    ) : Boolean {
        lastEnteredEmail = email
        return dbHelper.loginHelper(
            email = email,
            pass = pass
        )
    }

    fun registerUser(
        name : String,
        email: String,
        pass : String,
        gender: String
    ) : Boolean {
        return dbHelper.registerUserHelper(
            name = name,
            email = email,
            pass = pass,
            gender = gender
        )
    }
}


