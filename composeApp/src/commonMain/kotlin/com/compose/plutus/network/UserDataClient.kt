package com.compose.plutus.network

import com.compose.plutus.data.UserData
import com.compose.plutus.util.NetworkError
import io.ktor.client.HttpClient
import com.compose.plutus.util.Result
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.SerializationException

class UserDataClient(
    private val httpClient: HttpClient
) {
    suspend fun getUserData(): Result<UserData, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = "http://192.168.1.221:8080/"
            )
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        } catch (e: Exception) {
            return Result.Error(NetworkError.UNKNOWN)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val censoredText = response.body<UserData>()
                Result.Success(censoredText)
            }
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}