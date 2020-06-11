package com.awrcorp.bitmoney_app.ui.main.wallet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awrcorp.bitmoney_app.R
import com.awrcorp.bitmoney_app.vo.Income
import kotlinx.android.synthetic.main.list_income.view.*

class WalletAdapter : RecyclerView.Adapter<WalletAdapter.ViewHolder>() {
    private val incomeList = ArrayList<Income>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_income, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = incomeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(incomeList[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(income: Income) {
            with(itemView) {
                tv_nama_income.text = income.name
                tv_tanggal_income.text = income.date
                tv_amount_income.text = "Rp " + income.amount.toString()
            }
        }
    }

    fun setIncomeList(incomeLists: List<Income>) {
        if (this.incomeList.isNotEmpty()) {
            this.incomeList.clear()
        }
        this.incomeList.addAll(incomeLists)
        notifyDataSetChanged()
    }
}