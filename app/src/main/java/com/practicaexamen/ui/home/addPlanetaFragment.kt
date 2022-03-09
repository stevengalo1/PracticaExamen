package com.practicaexamen.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.practicaexamen.R
import com.practicaexamen.databinding.FragmentAddPlanetaBinding
import com.practicaexamen.model.Planeta
import com.practicaexamen.viewmodel.HomeViewModel

class addPlanetaFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentAddPlanetaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentAddPlanetaBinding.inflate(inflater, container, false)

        binding.btAddPlaneta.setOnClickListener{
            agregarPlaneta()
        }

        return binding.root
    }
    private fun agregarPlaneta() {
        val nombre=binding.etNombre.text.toString()
        if(nombre.isNotEmpty()){
            val capital=binding.etCapital.text.toString()
            val poblacion=binding.etPoblacion.text.toString()
            val moneda=binding.etMoneda.text.toString()

            val planeta= Planeta(0,nombre,capital,poblacion,moneda)
            homeViewModel.addPlaneta(planeta)
            Toast.makeText(requireContext(),
                getString(R.string.msg_pais_add),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_addPlaneta_to_nav_home)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}