package com.github.cesar1287.desafiopicpayandroid.tmdb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.TmdbHomeBusiness
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.TopRated
import com.github.cesar1287.desafiopicpayandroid.tmdb.paging.TmdbDataSourceFactory
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Paging.FIRST_PAGE
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Paging.PAGE_SIZE
import kotlinx.coroutines.launch

class TmdbHomeViewModel : ViewModel() {

    val onResultTopRated: MutableLiveData<TopRated> = MutableLiveData()
    val onResultFailure: MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        TmdbHomeBusiness()
    }

    var moviePagedList: LiveData<PagedList<Result>>? = null
    private var tmdbLiveDataSource: LiveData<PageKeyedDataSource<Int, Result>>? = null

    init {
        val tmdbDataSourceFactory = TmdbDataSourceFactory()

        tmdbLiveDataSource = tmdbDataSourceFactory.getSearchLiveDataSource()

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_SIZE).build()

        moviePagedList = LivePagedListBuilder(tmdbDataSourceFactory, pagedListConfig)
            .build()
    }

    fun getTopRated() {
        viewModelScope.launch {
            when(val response = business.getRated(FIRST_PAGE)) {
                is ResponseApi.Success -> {
                    onResultTopRated.postValue(
                        response.data as TopRated
                    )
                }
                is ResponseApi.Error -> {
                    onResultFailure.postValue(response.message)
                }
            }
        }
    }
}