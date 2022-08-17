package com.adesoftware.cryptocurrencychecker.data.repository

import com.adesoftware.cryptocurrencychecker.data.remote.CoinPaprikaApi
import com.adesoftware.cryptocurrencychecker.data.remote.dto.CoinDetailDto
import com.adesoftware.cryptocurrencychecker.data.remote.dto.CoinDto
import com.adesoftware.cryptocurrencychecker.data.remote.dto.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}