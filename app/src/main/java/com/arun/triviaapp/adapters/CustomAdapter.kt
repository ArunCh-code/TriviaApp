package com.arun.triviaapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arun.triviaapp.R
import com.arun.triviaapp.room.Answers

class CustomAdapter(val historyList: List<Answers>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvId: TextView
        val tvName: TextView
        val tvAns1: TextView
        val tvAns2: TextView
        val tvDate: TextView

        init {
            // Initilize the ViewHolder's View.
            tvId = view.findViewById(R.id.tvId)
            tvName = view.findViewById(R.id.tvName)
            tvAns1 = view.findViewById(R.id.tvAns1)
            tvAns2 = view.findViewById(R.id.tvAns2)
            tvDate = view.findViewById(R.id.tvDate)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from historyList at this position and replace the
        // contents of the view with that element
        viewHolder.tvId.text = "GAME"+historyList.get(position).id
        viewHolder.tvDate.text = historyList.get(position).date
        viewHolder.tvName.text = historyList.get(position).name
        viewHolder.tvAns1.text = historyList.get(position).player
        viewHolder.tvAns2.text = historyList.get(position).colurs
    }

    // Return the size of historyList (invoked by the layout manager)
    override fun getItemCount() = historyList.size

}

