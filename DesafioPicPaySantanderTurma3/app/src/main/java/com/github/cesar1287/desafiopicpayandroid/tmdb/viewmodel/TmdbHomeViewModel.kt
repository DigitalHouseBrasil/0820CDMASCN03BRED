package com.github.cesar1287.desafiopicpayandroid.tmdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import com.github.cesar1287.desafiopicpayandroid.tmdb.paging.TmdbDataSourceFactory
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Paging.PAGE_SIZE

class TmdbHomeViewModel(
    application: Application
) : AndroidViewModel(
    application
) {

    var moviePagedList: LiveData<PagedList<Result>>? = null
    private var tmdbLiveDataSource: LiveData<PageKeyedDataSource<Int, Result>>? = null

    init {
        val tmdbDataSourceFactory = TmdbDataSourceFactory(application)

        tmdbLiveDataSource = tmdbDataSourceFactory.getSearchLiveDataSource()

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_SIZE).build()

        moviePagedList = LivePagedListBuilder(tmdbDataSourceFactory, pagedListConfig)
            .build()
    }

//    val onResultTopRated: MutableLiveData<TopRated> = MutableLiveData()
//    val onResultFailure: MutableLiveData<String> = MutableLiveData()
//
//    private val business by lazy {
//        TmdbHomeBusiness()
//    }
//
//    fun getTopRated() {
//        viewModelScope.launch {
//            when(val response = business.getRated(FIRST_PAGE)) {
//                is ResponseApi.Success -> {
//                    onResultTopRated.postValue(
//                        response.data as TopRated
//                    )
//                }
//                is ResponseApi.Error -> {
//                    onResultFailure.postValue(response.message)
//                }
//            }
//        }
//    }
}