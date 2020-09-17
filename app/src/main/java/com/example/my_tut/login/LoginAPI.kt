package com.example.my_tut.login

import com.example.my_tut.login.data.LoginModel
import com.example.my_tut.login.data.LoginResponseModel
import retrofit2.http.Body
import retrofit2.http.POST


/**

 * Created by Mina Roger on September,2020

 */
interface LoginAPI {
    @POST("login/")
    suspend fun login(@Body loginModel: LoginModel): LoginResponseModel
}

