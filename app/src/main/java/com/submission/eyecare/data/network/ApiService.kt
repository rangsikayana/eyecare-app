package com.submission.eyecare.data.network

import com.submission.eyecare.data.network.response.RegisterResponse
import com.submission.eyecare.data.network.response.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @FormUrlEncoded
    @POST("/register")
    suspend fun register(
        @Field("firstName") firstName: String,
        @Field("LastName") lastName: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ) : RegisterResponse

    @FormUrlEncoded
    @POST("/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ) : LoginResponse

  /*  //??
    @FormUrlEncoded
    @POST("/users/{userId}/eyeHealthRecords")
    suspend fun records(
        @Path("userId") userId:  String,
        @Field("symptoms") symptoms: String,
        @Field("diagnosis") diagnosis: String
    )

    //not finished
    @FormUrlEncoded
    @POST("/users/{userId}/nutritionRecommendations")
    suspend fun nutrition(
        @Path("userId") userId:  String,
        @Field("symptoms") symptoms: String,
        @Field("diagnosis") diagnosis: String
    )

    //not finished
    @POST("/users/{userId}/eyeImages")
    suspend fun eyeImage()*/

}