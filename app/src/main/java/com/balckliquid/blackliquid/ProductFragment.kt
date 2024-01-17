package com.balckliquid.blackliquid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.balckliquid.blackliquid.models.Util
import com.balckliquid.blackliquid.views.ProductAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val products = ArrayList<Util>()

        var recyclerView = view.findViewById<RecyclerView>(R.id.prorecyclerview)
        val product = Util("Chibuku Super","123")
        val product1 = Util("Super Maheu","123")
        val product2 = Util("Baby powder","123")
        val product3 = Util("Chibuku Super","123")
        val product4 = Util("Super Maheu","123")
        val product5 = Util("Baby powder","123")
        val product6 = Util("Chibuku Super","123")
        val product7 = Util("Super Maheu","123")
        val product8 = Util("Baby powder","123")



        products?.add(product)
        products?.add(product1)
        products?.add(product3)
        products?.add(product4)
        products?.add(product5)
        products?.add(product6)
        products?.add(product7)
        products?.add(product8)
        val adapter = ProductAdapter(requireContext(), products)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}