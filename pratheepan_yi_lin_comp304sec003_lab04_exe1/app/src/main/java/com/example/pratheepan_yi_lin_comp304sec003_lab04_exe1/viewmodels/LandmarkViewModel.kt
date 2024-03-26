package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.viewmodels



import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database.AppDatabase
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database.LandmarkEntity


class LandmarkViewModel(application: Application) : AndroidViewModel(application) {
    private val landmarkDao = AppDatabase.getDatabase(application).landmarkDao()

    fun getLandmarksByType(type: String): LiveData<List<LandmarkEntity>> {
        return landmarkDao.getLandmarksByType(type)
    }
}