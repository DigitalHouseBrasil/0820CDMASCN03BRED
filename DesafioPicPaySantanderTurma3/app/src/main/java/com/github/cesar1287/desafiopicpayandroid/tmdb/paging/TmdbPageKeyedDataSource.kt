package com.github.cesar1287.desafiopicpayandroid.tmdb.paging

import android.content.Context
import androidx.paging.PageKeyedDataSource
import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.extensions.getFullImagePath
import com.github.cesar1287.desafiopicpayandroid.tmdb.database.TmdbDatabase
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.TopRated
import com.github.cesar1287.desafiopicpayandroid.tmdb.repository.TmdbHomeRepository
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Paging.FIRST_PAGE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TmdbPageKeyedDataSource(
    private val context: Context
) : PageKeyedDataSource<Int, Result>() {

    private val repository by lazy {
        TmdbHomeRepository(context)
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {
        CoroutineScope(IO).launch {
            when(val response = repository.getTopRated(FIRST_PAGE)) {
                is ResponseApi.Success -> {
                    val data = response.data as TopRated
                    data.results.forEach {
                        it.posterPath = it.posterPath.getFullImagePath()
                    }

                    val movieDao = TmdbDatabase.getDatabase(context).movieDao()
                    movieDao.insertAllMovies(data.results)

                    callback.onResult(data.results, null, FIRST_PAGE + 1)
                }
                is ResponseApi.Error -> {
                    val movieDao = TmdbDatabase.getDatabase(context).movieDao()
                    val movies = movieDao.getAllMovies()
                    callback.onResult(movies, null, FIRST_PAGE + 1)
                }
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Result>
    ) {
        val page = params.key

        CoroutineScope(IO).launch {
            when(val response = repository.getTopRated(page)) {
                is ResponseApi.Success -> {
                    val data = response.data as TopRated
                    data.results.forEach {
                        it.posterPath = it.posterPath.getFullImagePath()
                    }

                    val movieDao = TmdbDatabase.getDatabase(context).movieDao()
                    movieDao.insertAllMovies(data.results)

                    callback.onResult(data.results, page + 1)
                }
                is ResponseApi.Error -> {
                    callback.onResult(mutableListOf(), page + 1)
                }
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Result>
    ) {
        val page = params.key

        CoroutineScope(IO).launch {
            when(val response = repository.getTopRated(page)) {
                is ResponseApi.Success -> {
                    val data = response.data as TopRated
                    data.results.forEach {
                        it.posterPath = it.posterPath.getFullImagePath()
                    }

                    val movieDao = TmdbDatabase.getDatabase(context).movieDao()
                    movieDao.insertAllMovies(data.results)

                    callback.onResult(data.results, page - 1)
                }
                is ResponseApi.Error -> {
                    callback.onResult(mutableListOf(), page - 1)
                }
            }
        }
    }
}