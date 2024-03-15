package com.example.myapplication2

import androidx.paging.PageKeyedDataSource
import com.example.myapplication2.network.RetroInstance
import com.example.myapplication2.network.CharacterData

import com.example.rikmorty.network.RetroService
import com.example.myapplication2.network.RickAndMorty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterListDataSource():PageKeyedDataSource<Int, CharacterData>() {
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterData>) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromApi(params.key+1 )
        call.enqueue(/* callback = */ object :Callback<RickAndMorty>{
            override fun onResponse(
                call:Call<RickAndMorty>,
                response: Response<RickAndMorty>
            ) {
                if (response.isSuccessful
                ) {
                    callback.onResult(response.body()?.results!!, params.key+1)
                }
            }
            override fun onFailure(call: Call<RickAndMorty>, t: Throwable) {

            }

        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterData>) {

    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CharacterData>
    ) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromApi( 1)
        call.enqueue(object :Callback<RickAndMorty>{
            override fun onResponse(
                call:Call<RickAndMorty>,
                response: Response<RickAndMorty>
            ) {

                if (response.isSuccessful) {
                    callback.onResult(response?.body()?.results!!, null, 2)
                }
            }
            override fun onFailure(call: Call<RickAndMorty>, t: Throwable) {

            }

        })
    }
}