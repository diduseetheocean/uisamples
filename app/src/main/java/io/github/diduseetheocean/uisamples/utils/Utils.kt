package io.github.diduseetheocean.uisamples.utils

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.diduseetheocean.uisamples.data.ShareDetails
import java.io.InputStreamReader

object Utils {

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val jsonAdapter: JsonAdapter<ShareDetails> = moshi.adapter(ShareDetails::class.java)

    val localShareDetails = loadJsonFileFromResources("example.json")
        .let {
            jsonAdapter.fromJson(it)
        } ?: ShareDetails()


    fun loadJsonFileFromResources(path: String): String {
        val resourceAsStream = javaClass.classLoader?.getResourceAsStream(path)
        val reader = InputStreamReader(resourceAsStream)
        return reader.use { it.readText() }
    }
}

