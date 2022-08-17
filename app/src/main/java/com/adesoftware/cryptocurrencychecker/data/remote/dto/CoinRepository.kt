package com.adesoftware.cryptocurrencychecker.data.remote.dto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}