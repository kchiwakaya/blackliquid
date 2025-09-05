package com.balckliquid.blackliquid

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.balckliquid.blackliquid.models.Util
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.balckliquid.blackliquid.databinding.FragmentAddProductBinding
import com.balckliquid.blackliquid.databinding.FragmentProductBinding
import com.balckliquid.blackliquid.views.MyCustomAdapter
import com.google.firebase.firestore.toObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private var _binding: FragmentAddProductBinding? = null

// This property is only valid between onCreateView and
// onDestroyView.
private val binding get() = _binding!!
val db = Firebase.firestore
class AddProductFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val db = Firebase.firestore


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
        _binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val products = loadProducts()
        val adapter = MyCustomAdapter(requireContext(),  products)

        val autoCompleteTextView = binding.txtProd
        autoCompleteTextView.threshold = 1
        autoCompleteTextView.setAdapter(adapter)

    }
    /*autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
        val selectedKey = adapter.getItem(position)?.key
        // Use the selected key as needed
    }*/


    private fun loadProducts(): ArrayList<Util> {
        val products = ArrayList<Util>()
        db.collection("prods")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val product = document.toObject<Util>()
                    if (product != null) {
                        products.add(product)
                    }
                }
            }
        return products
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddProductFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}