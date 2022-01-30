package com.jamie.virginmoney.ui.room

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.jamie.virginmoney.data.repository.Repository

class RoomViewModel @ViewModelInject constructor(repository: Repository) : ViewModel() {
    val room = repository.getRoomListData()
}