package com.qt.aplicaciondispositivosmoviles.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import coil.load
import com.qt.aplicaciondispositivosmoviles.databinding.ViewAutomovilesBinding
import com.qt.aplicaciondispositivosmoviles.model.Automoviles
                           /*contex = entornodonde estoy trabajando */
class AutomovilesAdapter (val contextEntrada: Context, val listaAutomovilesEntrada: ArrayList<Automoviles>) : BaseAdapter(){
    var context : Context
    var listaAutomoviles : ArrayList<Automoviles>

    init {
        this.context = contextEntrada
        this.listaAutomoviles = listaAutomovilesEntrada
    }

    override fun getCount(): Int {
        val sizeList =  this.listaAutomoviles.size
        return sizeList
    }

    override fun getItem(positionList: Int): Any {
        val itemList = this.listaAutomoviles.get(positionList)
        return itemList
    }

    override fun getItemId(positionList: Int): Long {
        val itemId = positionList.toLong()
        return itemId
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var binding = ViewAutomovilesBinding.inflate(LayoutInflater.from(parent?.context),parent,false)

        val autoActual = listaAutomoviles.get(position)
        binding.textViewMarca.text = autoActual.marca
        binding.textViewReferencia.text = autoActual.referencia
        binding.textViewModelo.text = autoActual.modelo.toString()
        binding.textViewCilindraje.text = autoActual.cilindraje.toString()
        binding.textViewNUmeroPuertas.text = autoActual.numeroPuertas.toString()
        binding.textViewColor.text = autoActual.color
        binding.imageAutomovil.load(autoActual.urlFoto)

        return binding.root
    }


}