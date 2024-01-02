package com.balckliquid.blackliquid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.balckliquid.blackliquid.databinding.FragmentHomrBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomrBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomrBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSell.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.btnStock.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_productsFragment)
        }
        binding.btnProducts.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_addProductFragment)
        }
        binding.btnPorfitLoss.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_profitLossFragment)
        }
        binding.btnDebts.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_debtsFragment)
        }
        binding.btnCashIn.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_cashInFragment)
        }
        binding.btnCashOut.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_cashOutFragment)
        }
        binding.btnPay.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_paybillsFragment)
        }
        binding.btnLosses.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_lossesFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}