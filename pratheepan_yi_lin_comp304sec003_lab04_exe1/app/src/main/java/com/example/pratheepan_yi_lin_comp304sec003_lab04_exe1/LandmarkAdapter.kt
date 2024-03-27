package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe1.Database.LandmarkEntity

class LandmarkAdapter(private val landmarks: List<LandmarkEntity>) :
    RecyclerView.Adapter<LandmarkAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.textViewLandmarkName)
        val addressTextView: TextView = view.findViewById(R.id.textViewLandmarkAddress)
        val typeTextView: TextView = view.findViewById(R.id.textViewLandmarkType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.landmark_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val landmark = landmarks[position]
        holder.nameTextView.text = landmark.name
        holder.addressTextView.text = landmark.address
        holder.typeTextView.text = landmark.type
    }

    override fun getItemCount() = landmarks.size
}
