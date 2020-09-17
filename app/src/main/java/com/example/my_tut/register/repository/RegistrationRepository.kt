package com.example.my_tut.register.repository

import com.example.my_tut.network.ApiClient
import com.example.my_tut.register.RegistrationAPI
import com.example.my_tut.register.data.RegistrationModel
import com.example.my_tut.register.data.RegistrationResponseModel

/**

 * Created by Mina Roger on September,2020

 */

class RegistrationRepository {
    private var apiService: RegistrationAPI? = null
    init {
        apiService = ApiClient.getApiClient().create(RegistrationAPI::class.java)
    }
    suspend fun register(user: RegistrationModel): RegistrationResponseModel? {
        return try {
            apiService?.register(user)
        } catch (ex: Exception) {
            null
        }
    }
}
