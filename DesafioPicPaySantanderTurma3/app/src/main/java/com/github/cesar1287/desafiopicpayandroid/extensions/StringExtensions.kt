package com.github.cesar1287.desafiopicpayandroid.extensions

import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.BASE_URL_ORIGINAL_IMAGE

fun String.unmask(): String {
    return this.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "").replace("[/]".toRegex(), "")
        .replace("[(]".toRegex(), "").replace(
            "[ ]".toRegex(), ""
        ).replace("[:]".toRegex(), "").replace("[)]".toRegex(), "")
}

fun String.getFullImagePath(): String {
    return "${BASE_URL_ORIGINAL_IMAGE}${this}"
}