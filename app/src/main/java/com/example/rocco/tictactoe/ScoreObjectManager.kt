package com.example.rocco.tictactoe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ScoreObjectManager(val data: ArrayList<ObjectScore>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView : View
        val viewHolder : ViewHolder
        if (convertView == null) {
            rowView = LayoutInflater.from(parent!!.context).inflate(R.layout.row_score, parent, false)
            viewHolder = ViewHolder(rowView)
            rowView.tag = viewHolder
        } else {
            rowView = convertView
            viewHolder = rowView.tag as ViewHolder
        }

        viewHolder.player.text = getItem(position).player
        viewHolder.date.text = getItem(position).date

        return rowView
    }

    override fun getItem(position: Int): ObjectScore {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) {
        val player : TextView = itemView.findViewById(R.id.player)
        val date : TextView = itemView.findViewById(R.id.date)
    }
}