package com.balckliquid.blackliquid

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.balckliquid.blackliquid.databinding.FragmentSellBinding
import com.balckliquid.blackliquid.models.Product
import com.balckliquid.blackliquid.models.Sale
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDateTime
import java.util.Date

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SellFragment : Fragment() {

    private var _binding: FragmentSellBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSellBinding.inflate(inflater, container, false)
        return binding.root

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currencies = arrayOf("USD","Zim Dollar(Bond)","Ecocash USD", "Ecocash RTGS","RTGS","Rand","Pounds","Euro")
        val adapter = ArrayAdapter(context!!,android.R.layout.simple_spinner_item,currencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinner = binding.spinner
        spinner.adapter = adapter
        var selectedCurrency:Array<String>

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                 selectedCurrency = arrayOf(currencies[p2])
                Toast.makeText(context,selectedCurrency.first().toString(),Toast.LENGTH_LONG).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

       binding.btnSale.setOnClickListener {
           val product = Product(binding.editProdName.text.toString(),"232","Chibuku",34.40,
               Date(12/12/2023) ,3)
           val price: Double = (binding.editPrice.text.toString()).toDouble()
          val sale = Sale(product,price,(binding.editQuntity.text.toString()).toDouble(), LocalDateTime.now(),"Chikwereti")
           db.collection("sales")
               .add(sale)
               .addOnSuccessListener { documentReference ->
                   Toast.makeText(activity,"Success",Toast.LENGTH_LONG).show()
               }
               .addOnFailureListener { e ->
                   Toast.makeText(activity,"Failed",Toast.LENGTH_LONG).show()
               }
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}