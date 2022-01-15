package com.example.covidapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CovidAdapter(val infoModel: MutableList<InfoModel>) : RecyclerView.Adapter<CovidViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_covid,parent,false)
        return CovidViewHolder(view)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        return holder.bindView(infoModel[position])
    }

    override fun getItemCount(): Int {
        return infoModel.size
    }
}

class CovidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
    private val tvCCI: TextView = itemView.findViewById(R.id.tvCCI)
    private val tvCCF: TextView = itemView.findViewById(R.id.tvCCF)
    private val tvDS: TextView = itemView.findViewById(R.id.tvDS)
    private val tvDT: TextView = itemView.findViewById(R.id.tvDT)
    private val tvTF: TextView = itemView.findViewById(R.id.tvTF)

    fun bindView(infoModel: InfoModel){
        tvLocation.text = infoModel.loc
        tvCCI.text = infoModel.confirmedCasesIndian.toString()
        tvCCF.text = infoModel.confirmedCasesForeign.toString()
        tvDS.text = infoModel.discharged.toString()
        tvDT.text = infoModel.deaths.toString()
        tvTF.text = infoModel.totalConfirmed.toString()

    }
}