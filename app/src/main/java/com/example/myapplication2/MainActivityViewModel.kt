package com.example.myapplication2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.myapplication2.network.CharacterData
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MainActivityViewModel:ViewModel() {

    private var characterList : LiveData<PagedList<CharacterData>>? = null

    init {
        initpaging()
    }

    private fun initpaging() {
        val factory = CharacterListDataSourceFactory()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20)
            .build()

        val executor: Executor = Executors.newFixedThreadPool(5)
        characterList = LivePagedListBuilder<Int, CharacterData>(factory, config)
            .setFetchExecutor(executor)
            .build()
    }



    fun getRecyclerListObserver(): LiveData<PagedList<CharacterData>>? {
        return characterList
    }
}