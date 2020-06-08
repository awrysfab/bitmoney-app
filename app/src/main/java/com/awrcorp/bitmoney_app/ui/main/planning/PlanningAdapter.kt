package com.awrcorp.bitmoney_app.ui.main.planning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awrcorp.bitmoney_app.R
import com.awrcorp.bitmoney_app.vo.Outcome
import kotlinx.android.synthetic.main.list_outcome.view.*

class PlanningAdapter : RecyclerView.Adapter<PlanningAdapter.ViewHolder>() {
    private val planList = ArrayList<Outcome>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_outcome, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = planList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(planList[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(plan: Outcome) {
            with(itemView) {
                tv_kategori_outcome.text = plan.category
                tv_nama_outcome.text = plan.name
                tv_harga_outcome.text = "Rp " + plan.amount.toString()
                tv_tanggal_outcome.visibility = View.GONE
            }
        }
    }

    fun setPlanList(planLists: List<Outcome>) {
        if (this.planList.isNotEmpty()) {
            this.planList.clear()
        }
        this.planList.addAll(planLists)
        notifyDataSetChanged()
    }
}