package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

enum class LandmarkType(val description: String) {
    OLD_BUILDING("Old Building"),
    MUSEUM("Museum"),
    ATTRACTION("Attraction")
}
@Parcelize
@Entity(tableName = "landmarks")
data class LandmarkEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val address: String,
    val type: String // store the enum name as a String
) : Parcelable

