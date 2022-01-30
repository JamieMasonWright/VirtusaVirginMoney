package com.jamie.virginmoney.data.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.jamie.virginmoney.data.service.Resource.Status.ERROR
import com.jamie.virginmoney.data.service.Resource.Status.SUCCESS
import kotlinx.coroutines.Dispatchers

fun <A> callGetService(networkCall: suspend () -> Resource<A>): LiveData<Resource<A>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val responseStatus = networkCall.invoke()
        if (responseStatus.status == SUCCESS) {
            emit(Resource.success(responseStatus.data!!))

        } else if (responseStatus.status == ERROR) {
            emit(Resource.error(responseStatus.message!!))
        }
    }