package cn.jinyulei.mybaby.data

import retrofit2.http.Body
import retrofit2.http.POST

interface BabyService {

    @POST("users")
    suspend fun createUser(@Body registerInfo: RegisterInfo)
}