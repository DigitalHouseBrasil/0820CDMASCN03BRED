package com.github.cesar1287.desafiopicpayandroid.tmdb.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomWarnings
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movies")
data class Result(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    var posterPath: String,
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    val releaseDate: String,
    var title: String,
    val video: Boolean,
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    val voteCount: Int
) : Parcelable {

    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<Result> = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}