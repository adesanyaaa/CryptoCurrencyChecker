package com.adesoftware.cryptocurrencychecker.domain.use_case.get_coins

import com.adesoftware.cryptocurrencychecker.common.Resource
import com.adesoftware.cryptocurrencychecker.data.remote.dto.CoinRepository
import com.adesoftware.cryptocurrencychecker.data.remote.dto.toCoin
import com.adesoftware.cryptocurrencychecker.domain.model.Coin
import com.adesoftware.cryptocurrencychecker.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(
                "Could not reach server. Check your internet connection."))
        }
    }
}