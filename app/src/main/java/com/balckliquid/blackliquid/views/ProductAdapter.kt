package com.balckliquid.blackliquid.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.balckliquid.blackliquid.R
import com.balckliquid.blackliquid.models.Util

class ProductAdapter(private val context: Context, private val products: ArrayList<Util>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.product_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.name?.text = product.product_name
        holder.price?.text = product.product_id
        //holder..text = product.product_name
    }

    override fun getItemCount(): Int = products.size

    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        //val textCourse = itemView?.findViewById<TextView?>(R.id.textCourse)
        val name = itemView?.findViewById<TextView?>(R.id.txtName)
        val price = itemView?.findViewById<TextView?>(R.id.txtPrice)

        init {
            itemView?.setOnClickListener {
                Toast.makeText(context,"hey there",Toast.LENGTH_LONG).show()
            }
        }
    }
}























