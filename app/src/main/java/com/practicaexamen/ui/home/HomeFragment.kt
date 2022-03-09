package com.practicaexamen.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.practicaexamen.R
import com.practicaexamen.adapter.PlanetaAdapter
import com.practicaexamen.databinding.FragmentHomeBinding
import com.practicaexamen.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_home_to_addPlaneta)
        }

        val planetaAdapter= PlanetaAdapter()
        val reciclador = binding.reciclador

        reciclador.adapter = planetaAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        homeViewModel.getAllData.observe(viewLifecycleOwner) { planetas->
            planetaAdapter.setData(planetas)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}