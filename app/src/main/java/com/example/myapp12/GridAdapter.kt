package com.example.myapp12

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class GridAdapter(private val context: Context, private val items: Array<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val textView: TextView

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
            textView = view.findViewById(android.R.id.text1)
            textView.setPadding(8, 8, 8, 8)
        } else {
            view = convertView
            textView = view.findViewById(android.R.id.text1)
        }

        textView.text = items[position]
        return view
    }
}
