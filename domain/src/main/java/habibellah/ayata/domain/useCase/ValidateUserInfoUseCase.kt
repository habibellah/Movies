package habibellah.ayata.domain.useCase

import habibellah.ayata.domain.entity.*
import habibellah.ayata.domain.repositories.AuthenticationRepository
import habibellah.ayata.domain.repositories.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class ValidateUserInfoUseCase(
    private val authenticationRepository : AuthenticationRepository,
    private val userInfoRepository : UserInfoRepository
) {
    suspend fun login(
        userName : String,
        password : String
    ) : Flow<MovieState<AuthenticationState?>> {
        return flow {
            emit(MovieState.Loading)
            try {
                val result = authenticationRepository.logIn(userName, password)
                if (result.isSuccessful) {
                    emit(
                        MovieState.Success(
                            checkLoginInformation(
                                CheckLoginBody(
                                    password,
                                    result.body()?.requestToken,
                                    userName
                                )
                            )
                        )
                    )
                } else {
                    emit(MovieState.Error(result.message()))
                }
            } catch (e : Exception) {
                emit(MovieState.Error(e.message.toString()))
            }
        }
    }

    private suspend fun checkLoginInformation(checkLoginBody : CheckLoginBody) : AuthenticationState? {
        val response =
            authenticationRepository.checkLoginInformation(checkLoginBody = checkLoginBody)
        if (response.isSuccessful) {
            if (response.body()?.success == true) {
                return response.body()!!.requestToken?.let { getSessionId(it) }
            }
        }
        return AuthenticationState.Error
    }

    private suspend fun getSessionId(requestToken : String) : AuthenticationState? {
        val response = authenticationRepository.getSessionId(requestToken = requestToken)
        if (response.isSuccessful) {
            if (response.body()?.success == true) {
                return response.body()!!.sessionId?.let { getAccountId(it) }
            }
        }
        return AuthenticationState.Error
    }

    private suspend fun getAccountId(sessionId : String) : AuthenticationState {
        val response = authenticationRepository.getAccountId(sessionId = sessionId)
        return if (response.isSuccessful) {
            response.body()?.id?.let { userInfoRepository.storeAccountId(it) }
            response.body()?.id?.let { userInfoRepository.storeSessionId(sessionId) }
            response.body()?.name?.let { userInfoRepository.storeUserName(it) }
            AuthenticationState.Success
        } else {
            AuthenticationState.Error
        }
    }

    private fun <T> wrapWithFlow(
        doAfterSuccess : () -> Unit,
        function : suspend () -> Response<T>
    ) : Flow<MovieState<T?>> {
        return flow {
            emit(MovieState.Loading)
            try {
                val result = function()
                if (result.isSuccessful) {
                    emit(MovieState.Success(result.body()))
                    doAfterSuccess()
                } else {
                    emit(MovieState.Error(result.message()))
                }
            } catch (e : Exception) {
                emit(MovieState.Error(e.message.toString()))
            }
        }
    }
}
