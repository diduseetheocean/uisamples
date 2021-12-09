package io.github.diduseetheocean.uisamples

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.diduseetheocean.uisamples.data.ShareDetails
import io.github.diduseetheocean.uisamples.utils.Utils
import org.junit.Assert.assertEquals
import org.junit.Test

class JsonTest {

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val jsonAdapter: JsonAdapter<ShareDetails> = moshi.adapter(ShareDetails::class.java)

    @Test
    fun `deserialization THEN property should have correct value`() {
        val jsonDeserialized = Utils
            .loadJsonFileFromResources("example.json")
            .let {
                jsonAdapter.fromJson(it)
            }

        assertEquals("adidas", jsonDeserialized)
    }

    @Test
    fun `localShareDetails should not be empty`() {
        assertEquals("adidas", Utils.localShareDetails)
    }
}