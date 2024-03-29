package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1

import android.app.Application
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database.AppDatabase

class LandmarkApplication:Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}