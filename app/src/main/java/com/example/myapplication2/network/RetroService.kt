package com.example.rikmorty.network

import com.example.myapplication2.network.CharacterData
import com.example.myapplication2.network.RickAndMorty
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface RetroService {
    @GET("character")
    fun getDataFromApi(@Query("page") page: Int): Call<RickAndMorty>
    @GET("character/{id}")
    suspend fun getRickAndMorty(@Path("id") id:Int): CharacterData

}