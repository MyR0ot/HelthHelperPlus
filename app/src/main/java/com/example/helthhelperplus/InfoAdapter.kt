package com.example.helthhelperplus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.ConfigurationCompat
import androidx.recyclerview.widget.RecyclerView

class InfoAdapter(var items: List<Info>, isRussianLocale: Boolean,  val callback: Callback): RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    private var producerTitle: String = "Producer"

    init {
        if(isRussianLocale){
            producerTitle = "Режиссер"
        } else {
            producerTitle = "Producer"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = InfoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.info_list_item, parent, false))

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size


    inner class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name = itemView.findViewById<TextView>(R.id.tv_name)
        private val dr = itemView.findViewById<TextView>(R.id.tv_dr)


        fun bind(info: Info) {
            name.text = info.name
            dr.text = info.dr

            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(info)
            }
        }

        private fun setTextView(tv: TextView, title:String, text: String): Unit {
            if(text.isNotEmpty()){
                tv.text = "$title: $text"
            } else {
                tv.text = ""
            }
        }
    }

    interface Callback {
        fun onItemClicked(item: Info)
    }


    fun updateList(newList: List<Info>): Unit {
        items = newList
        notifyDataSetChanged()
    }

}