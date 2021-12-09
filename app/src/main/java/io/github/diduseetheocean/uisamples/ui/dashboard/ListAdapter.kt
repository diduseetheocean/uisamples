package io.github.diduseetheocean.uisamples.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.diduseetheocean.uisamples.R
import io.github.diduseetheocean.uisamples.data.ShareDetailsListItem

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var itemList: List<ShareDetailsListItem> = emptyList()

    // Describes an item view and its place within the RecyclerView
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val timeRangeTextView: TextView = itemView.findViewById(R.id.timeRange)
        private val performanceTextView: TextView = itemView.findViewById(R.id.performance)
        private val volatilityTextView: TextView = itemView.findViewById(R.id.volatility)

        fun bind(item: ShareDetailsListItem, index: Int) {
            timeRangeTextView.text = item.timeRange
            performanceTextView.text = item.performance.format()
            volatilityTextView.text = when (item.volatility) {
                null -> "-"
                else -> item.volatility.format()
            }

            performanceTextView.setBackgroundResource(
                when {
                    item.performance > 0 -> R.drawable.green_shape
                    item.performance < 0 -> R.drawable.orange_shape
                    else -> R.drawable.grey_shape
                }
            )

            if (index % 2 == 0) {
                itemView.setBackgroundResource(R.color.background_primary)
            } else {
                itemView.setBackgroundResource(R.color.white)
            }
        }
    }

    fun submitList(list: List<ShareDetailsListItem>) {
        itemList = list
    }

    // Returns a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ListViewHolder(view)
    }

    // Returns size of data list
    override fun getItemCount(): Int {
        return itemList.size
    }

    // Displays data at a certain position
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(itemList[position], position)
    }
}

fun Float.format(): String {
    return String.format("%.1f", this).let {
        when {
            this > 0 -> "+$it %"
            this < 0 -> "$it %"
            else -> "±$it %"
        }
    }
}