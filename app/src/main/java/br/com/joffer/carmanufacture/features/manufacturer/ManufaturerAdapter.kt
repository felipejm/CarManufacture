package br.com.joffer.carmanufacture.features.manufacturer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.joffer.carmanufacture.R
import kotlinx.android.synthetic.main.view_manufaturer_item.view.*

class ManufaturerAdapter(val manufaturers: List<Pair<String, String>>): RecyclerView.Adapter<ManufaturerAdapter.ViewHolder>() {

    var onClickListener: (String) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_manufaturer_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount()= manufaturers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = manufaturers[position].first
        val subtitle = manufaturers[position].second
        holder.bind(title, subtitle)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(title: String, subtitle: String){
            itemView.title.text = title
            itemView.subtitle.text = subtitle

            itemView.setOnClickListener { onClickListener(subtitle) }
        }
    }
}