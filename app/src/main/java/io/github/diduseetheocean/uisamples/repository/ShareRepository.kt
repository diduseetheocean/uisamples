package io.github.diduseetheocean.uisamples.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.diduseetheocean.uisamples.data.ShareDetails
import io.github.diduseetheocean.uisamples.utils.Utils

object ShareRepository {
    private val shareLiveData = MutableLiveData<ShareDetails>().apply {
        value = Utils.localShareDetails
    }

    fun getShareDetails(): LiveData<ShareDetails> {
        return shareLiveData
    }
}