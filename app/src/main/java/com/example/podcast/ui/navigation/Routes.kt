package com.example.podcast.ui.navigation


abstract sealed class Routes(
    open val route: String
)

object EmptyRoute : Routes("")

sealed class AuthRoutes(override val route: String) : Routes("auth/$route") {
    object Splash : AuthRoutes("splash_screen")
    object SignUp : AuthRoutes("sign_up_screen")
    object SignIn : AuthRoutes("sign_in_screen")
}