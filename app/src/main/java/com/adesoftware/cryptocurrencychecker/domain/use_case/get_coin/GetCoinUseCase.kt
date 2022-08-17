package com.adesoftware.cryptocurrencychecker.domain.use_case.get_coin

import com.adesoftware.cryptocurrencychecker.common.Resource
import com.adesoftware.cryptocurrencychecker.data.remote.dto.CoinRepository
import com.adesoftware.cryptocurrencychecker.data.remote.dto.toCoin
import com.adesoftware.cryptocurrencychecker.data.remote.dto.toCoinDetail
import com.adesoftware.cryptocurrencychecker.domain.model.Coin
import com.adesoftware.cryptocurrencychecker.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?:
            "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>(
                "Could not reach server. Check your internet connection."))
        }
    }
}