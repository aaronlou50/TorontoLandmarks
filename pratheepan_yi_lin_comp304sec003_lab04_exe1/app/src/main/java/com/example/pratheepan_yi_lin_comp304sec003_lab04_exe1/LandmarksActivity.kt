package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database.LandmarkEntity
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database.LandmarkType
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.viewmodels.LandmarkViewModel
class LandmarksActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var viewModel: LandmarkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmarks) // Ensure this is your layout with ListView

        viewModel = ViewModelProvider(this)[LandmarkViewModel::class.java]

        val type = intent.getStringExtra(EXTRA_LANDMARK_TYPE) // Make sure to pass the type as String

        listView = findViewById(R.id.recyclerViewLandmarks) // Ensure your ListView has this ID

        // Observe the LiveData from the ViewModel
        type?.let { typeName ->
            viewModel.getLandmarksByType(typeName).observe(this, { landmarks ->

                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarks.map { landmark -> "${landmark.name}, ${landmark.address}" })
                listView.adapter = adapter
            })
        }
    }

    companion object {
        const val EXTRA_LANDMARK_TYPE = "EXTRA_LANDMARK_TYPE"
    }
}

