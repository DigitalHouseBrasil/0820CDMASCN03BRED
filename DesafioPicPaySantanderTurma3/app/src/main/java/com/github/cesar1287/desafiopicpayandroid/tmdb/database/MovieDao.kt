package com.github.cesar1287.desafiopicpayandroid.tmdb.database

import androidx.room.*
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<Result>

    @Query("SELECT * FROM movies WHERE id = :movieId")
    suspend fun getMovieById(movieId: Int) : Result

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movies: List<Result>)

    @Delete
    suspend fun deleteMovie(movie: Result)

    @Update
    suspend fun updateMovie(movie: Result)
}