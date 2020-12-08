package com.github.cesar1287.desafiopicpayandroid.tmdb.database

import androidx.room.*
import com.github.cesar1287.desafiopicpayandroid.model.Movie
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result

@Dao
interface MovieDao {

    //CRUD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Query("SELECT * FROM movies WHERE id = :movieId")
    suspend fun getMovieById(movieId: Int): Movie

    @Update
    suspend fun updateMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)
}