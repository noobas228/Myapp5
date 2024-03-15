package com.example.myapplication2

import androidx.lifecycle.MutableLiveData
import com.example.myapplication2.network.CharacterData
import androidx.paging.DataSource

class CharacterListDataSourceFactory(): DataSource.Factory<Int, CharacterData>(){
    private var mutableLiveData: MutableLiveData<CharacterListDataSource>? = null

    init {

        mutableLiveData = MutableLiveData()
    }

    override fun create(): DataSource<Int, CharacterData> {
        val listDataSource = CharacterListDataSource()
        mutableLiveData?.postValue(listDataSource)
        return listDataSource
    }

}
