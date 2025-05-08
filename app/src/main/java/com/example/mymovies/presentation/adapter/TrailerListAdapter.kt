package com.example.mymovies.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.R
import com.example.mymovies.domain.Trailer

class TrailerListAdapter : RecyclerView.Adapter<TrailerListAdapter.TrailerViewHolder>() {

    private var trailers : List<Trailer> = emptyList()

    fun setTrailers(trailers : List<Trailer>){
        this.trailers = trailers
        notifyDataSetChanged()
    }

    var onPlayClickListener : OnPlayClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.trailer_item,
            parent,
            false
        )
        return TrailerViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrailerViewHolder, position: Int) {
        val trailer = trailers[position]

        with(holder){
            tvTrailerName.text = trailer.name

            ivPlayButton.setOnClickListener{
                onPlayClickListener?.onPlayClick(trailer)
            }
        }


    }

    override fun getItemCount(): Int {
        return trailers.size
    }

    interface OnPlayClickListener{
        fun onPlayClick(trailer: Trailer)
    }

    class TrailerViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvTrailerName : TextView = view.findViewById(R.id.tvTrailerName)
        val ivPlayButton : ImageView = view.findViewById(R.id.ivPlayButton)
    }
}