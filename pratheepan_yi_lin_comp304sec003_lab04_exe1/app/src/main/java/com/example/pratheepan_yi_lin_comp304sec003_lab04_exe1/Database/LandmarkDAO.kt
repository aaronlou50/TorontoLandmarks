package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database

import androidx.room.Dao
import androidx.room.Query
import androidx.lifecycle.LiveData
@Dao
interface LandmarkDao {
    @Query("SELECT * FROM landmarks WHERE type = :type")
    fun getLandmarksByType(type: String): LiveData<List<LandmarkEntity>>



}

