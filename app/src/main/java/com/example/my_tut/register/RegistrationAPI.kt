package com.example.my_tut.register

import com.example.my_tut.register.data.RegistrationModel
import com.example.my_tut.register.data.RegistrationResponseModel
import retrofit2.http.Body
import retrofit2.http.POST


/**

 * Created by Mina Roger on September,2020

 */

interface RegistrationAPI {
    @POST("register/")
    suspend fun register(@Body registrationModel: RegistrationModel): RegistrationResponseModel
}