package com.practicaexamen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.practicaexamen.databinding.PlanetaFilaBinding
import com.practicaexamen.model.Planeta
import com.practicaexamen.ui.home.HomeFragmentDirections

class PlanetaAdapter: RecyclerView.Adapter<PlanetaAdapter.PlanetaViewHolder>() {

    private var listaPlanetas = emptyList<Planeta>()

    inner class PlanetaViewHolder(private val itemBinding: PlanetaFilaBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(planeta: Planeta){
            itemBinding.tvNombre.text = planeta.nombre
            itemBinding.tvCapital.text = planeta.capital
            itemBinding.tvPoblacion.text = planeta.poblacion
            itemBinding.tvMoneda.text = planeta.moneda

            itemBinding.vistaFila.setOnClickListener{
                val accion = HomeFragmentDirections.actionNavHomeToNavUpdatePlaneta(planeta)
                itemView.findNavController().navigate(accion)
            }
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetaViewHolder {
        val itemBinding = PlanetaFilaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return PlanetaViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PlanetaViewHolder, position: Int) {
        val lugar = listaPlanetas[position]
        holder.bind(lugar)
    }

    override fun getItemCount(): Int {
        return listaPlanetas.size
    }

    fun setData(planetas: List<Planeta>){
        this.listaPlanetas = planetas
        notifyDataSetChanged()
    }
}