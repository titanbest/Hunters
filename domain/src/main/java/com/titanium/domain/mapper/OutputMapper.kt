package com.titanium.domain.mapper

interface OutputMapper<in From, out To> {
    fun transformFromDomain(item: From): To
}