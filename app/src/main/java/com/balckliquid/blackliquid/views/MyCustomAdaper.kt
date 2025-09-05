package com.balckliquid.blackliquid.views

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.balckliquid.blackliquid.models.Util

class MyCustomAdapter(context: Context, items: ArrayList<Util>) :
    ArrayAdapter<Util>(context, android.R.layout.simple_list_item_1, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = getItem(position)?.product_name
        return view
    }
}
