package io.github.diduseetheocean.uisamples.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.diduseetheocean.uisamples.repository.ShareRepository

class DashboardViewModel(private val repository: ShareRepository = ShareRepository) : ViewModel() {

    val shareDetailsLiveData = repository.getShareDetails()
}