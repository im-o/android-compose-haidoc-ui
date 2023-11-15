package id.rivaldy.core.data.model.local.screen.auth

/** Created by github.com/im-o on 11/15/2023. */

sealed class AuthScreenRoute(val route: String) {
    object LoginUser : AuthScreenRoute(route = "login")
    object RegisterUser : AuthScreenRoute(route = "register")
}