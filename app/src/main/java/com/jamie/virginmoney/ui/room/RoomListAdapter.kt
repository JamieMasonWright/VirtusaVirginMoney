package com.jamie.virginmoney.ui.room

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamie.virginmoney.data.model.Room
import com.jamie.virginmoney.databinding.LayoutRoomListItemBinding

class RoomListAdapter(private val dataSet: ArrayList<Room>) :
    RecyclerView.Adapter<RoomListAdapter.ViewHolder>() {

    class ViewHolder(private val view: LayoutRoomListItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(item: Room) {
            "Maximum Capacity :  ${item.maxOccupancy}".also { view.capacity.text = it }
            "Room Id : ${item.id}".also { view.id.text = it }
            if (item.isOccupied == true) {
                "Occupied".also { view.occupied.text = it }
                view.occupied.setTextColor(Color.parseColor("#ff0000"))
            } else {
                "Not Occupied".also { view.occupied.text = it }
                view.occupied.setTextColor(Color.parseColor("#007500"))
            }

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutRoomListItemBinding =
            LayoutRoomListItemBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val dataModel: Room = dataSet[position]
        viewHolder.bind(dataModel)
    }

    override fun getItemCount() = dataSet.size
}