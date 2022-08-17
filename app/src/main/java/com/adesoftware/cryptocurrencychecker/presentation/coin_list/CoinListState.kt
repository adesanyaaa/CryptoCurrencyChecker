package com.adesoftware.cryptocurrencychecker.presentation.coin_list

import com.adesoftware.cryptocurrencychecker.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
