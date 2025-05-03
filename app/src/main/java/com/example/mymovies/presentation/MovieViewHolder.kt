package com.example.mymovies.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.R

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val ivPoster : ImageView = itemView.findViewById(R.id.ivPoster)
    val tvKpRating : TextView = itemView.findViewById(R.id.tvKpRating)
    val tvImdbRating : TextView = itemView.findViewById(R.id.tvImdbRating)
}