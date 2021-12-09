package io.github.diduseetheocean.uisamples.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.diduseetheocean.uisamples.R

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Empty"
    }
    val text: LiveData<String> = _text
}