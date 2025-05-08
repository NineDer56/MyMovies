package com.example.mymovies.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.R
import com.example.mymovies.domain.dto.review.Review
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class ReviewListAdapter : RecyclerView.Adapter<ReviewListAdapter.ReviewViewHolder>() {

    private var reviews: List<Review> = emptyList()

    fun setReviews(reviews: List<Review>) {
        this.reviews = reviews
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.review_item,
            parent,
            false
        )
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviews[position]

        with(holder) {
            tvAuthor.text = review.author
            tvDate.text = convertDate(review.updatedAt)
            tvReviewTitle.text = review.title
            tvReview.text = review.review
            tvUseful.text = String.format(
                holder.itemView.context.getString(R.string.usefulCount),
                review.reviewLikes
            )
            tvUseless.text = String.format(
                holder.itemView.context.getString(R.string.uselessCount),
                review.reviewDislikes
            )
            clReview.setBackgroundColor(
                when (review.type) {
                    "Позитивный" -> ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.LightGreen
                    )

                    "Негативный" -> ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.LightCoral
                    )

                    else -> ContextCompat.getColor(holder.itemView.context, R.color.LightGray)
                }
            )
        }

    }

    private fun convertDate(date: String): String {
        val instant = Instant.parse(date)
        val localTime = instant.atZone(ZoneId.systemDefault())
        return localTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAuthor: TextView = view.findViewById(R.id.tvAuthor)
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvReviewTitle: TextView = view.findViewById(R.id.tvReviewTitle)
        val tvReview: TextView = view.findViewById(R.id.tvReview)
        val tvUseful: TextView = view.findViewById(R.id.tvUseful)
        val tvUseless: TextView = view.findViewById(R.id.tvUseless)
        val clReview: ConstraintLayout = view.findViewById(R.id.clReview)
    }
}