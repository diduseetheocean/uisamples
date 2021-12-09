package io.github.diduseetheocean.uisamples.data

data class ShareDetails (
    val shareName: String = "",
    val accountId: String = "",
    val accountTotal: Long = 0,
    val date: String = "",
    val secondCol: String = "",
    val thirdCol: String = "",
    val rows: List<ShareDetailsListItem> = emptyList()
)