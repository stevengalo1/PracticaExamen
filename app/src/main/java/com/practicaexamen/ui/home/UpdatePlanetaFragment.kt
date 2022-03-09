package com.practicaexamen.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.practicaexamen.R
import com.practicaexamen.databinding.FragmentUpdatePlanetaBinding
import com.practicaexamen.model.Planeta
import com.practicaexamen.viewmodel.HomeViewModel

class UpdatePlanetaFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentUpdatePlanetaBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<UpdatePlanetaFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentUpdatePlanetaBinding.inflate(inflater, container, false)

        binding.etNombre.setText(args.planeta.nombre)
        binding.etCapital.setText(args.planeta.capital)
        binding.etPoblacion.setText(args.planeta.poblacion)
        binding.etMoneda.setText(args.planeta.moneda)

        binding.btUpdatePlaneta.setOnClickListener{ actualizarPlaneta() }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.delete_menu){
            deletePlaneta()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun actualizarPlaneta() {
        val nombre=binding.etNombre.text.toString()
        if(nombre.isNotEmpty()){
            val capital=binding.etCapital.text.toString()
            val poblacion=binding.etPoblacion.text.toString()
            val moneda=binding.etMoneda.text.toString()

            val planeta= Planeta(args.planeta.id,nombre,capital,poblacion,moneda)
            homeViewModel.updatePlaneta(planeta)
            Toast.makeText(requireContext(),
                getString(R.string.msg_pais_update),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_nav_updatePlaneta_to_nav_home)
        }
    }

    private fun deletePlaneta(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(R.string.msg_pais_delete)
        builder.setMessage(getString(R.string.msg_seguroBorrar)+ "${args.planeta.nombre}?")
        builder.setNegativeButton(getString(R.string.no)) {_,_ ->}
        builder.setPositiveButton(getString(R.string.si)) {_,_ ->
            homeViewModel.deletePlaneta(args.planeta)
            findNavController().navigate(R.id.action_nav_updatePlaneta_to_nav_home)
        }
        builder.create().show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}