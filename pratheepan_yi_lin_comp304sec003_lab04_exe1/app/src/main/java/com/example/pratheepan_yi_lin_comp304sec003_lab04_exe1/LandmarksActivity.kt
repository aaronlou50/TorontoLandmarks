package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database.LandmarkEntity
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database.LandmarkType
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.viewmodels.LandmarkViewModel
class LandmarksActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: LandmarkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmarks)

        viewModel = ViewModelProvider(this)[LandmarkViewModel::class.java]
        recyclerView = findViewById(R.id.recyclerViewLandmarks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Retrieving the landmark type name from the Intent extras
        val typeName = intent.getStringExtra(EXTRA_LANDMARK_TYPE)



        // Observe the LiveData from the ViewModel
        typeName?.let {
            val type = typeName?.let { LandmarkType.valueOf(it) }
            viewModel.getLandmarksByType(typeName).observe(this, { landmarks ->
                recyclerView.adapter = LandmarkAdapter(landmarks)
            })
        }
    }

    companion object {
        const val EXTRA_LANDMARK_TYPE = "EXTRA_LANDMARK_TYPE"
    }
}

