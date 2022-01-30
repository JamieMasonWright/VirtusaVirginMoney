package com.jamie.virginmoney.ui.people

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamie.virginmoney.data.model.People
import com.jamie.virginmoney.databinding.LayoutPeopleListItemBinding
import com.squareup.picasso.Picasso

class PeopleListAdapter(private val dataSet: ArrayList<People>, private val itemClick: ItemClick) :
    RecyclerView.Adapter<PeopleListAdapter.ViewHolder>() {

    class ViewHolder(private val view: LayoutPeopleListItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: People) {
            view.name.text = """${item.firstName}  ${item.lastName}"""
            view.email.text = """${item.email}"""
            view.job.text = "${item.jobTitle}"
            Picasso.get().load(item.avatar).into(view.profile);
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutPeopleListItemBinding =
            LayoutPeopleListItemBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val dataModel: People = dataSet[position]
        viewHolder.bind(dataModel)
        viewHolder.itemView.setOnClickListener {
            itemClick.onItemClick(dataSet[position])
        }
    }

    override fun getItemCount() = dataSet.size

}


