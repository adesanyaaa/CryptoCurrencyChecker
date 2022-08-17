package com.adesoftware.cryptocurrencychecker.presentation.coin_detail

import com.adesoftware.cryptocurrencychecker.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
