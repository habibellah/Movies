package habibellah.ayata.data.repositories

import habibellah.ayata.data.movieAppDataSource.remote.movieApi.MovieApi
import habibellah.ayata.domain.entity.*
import habibellah.ayata.domain.repositories.AuthenticationRepository

class AuthenticationRepositoryImpl(
    private val movieApi : MovieApi
) : AuthenticationRepository {
    override suspend fun logIn(userName : String, password : String) =
        getRequestToken(userName, password)

    override suspend fun getRequestToken(userName : String, password : String) =
        movieApi.getRequestToken()

    override suspend fun checkLoginInformation(checkLoginBody : CheckLoginBody) =
        movieApi.checkLoginInformation(userInformation = checkLoginBody)

    override suspend fun getSessionId(requestToken : String) =
        movieApi.getSessionId(tokenRequest = requestToken)

    override suspend fun getAccountId(sessionId : String) =
        movieApi.getAccountId(session_id = sessionId)
}