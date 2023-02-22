package habibellah.ayata.domain.repositories

import habibellah.ayata.domain.entity.*
import retrofit2.Response

interface AuthenticationRepository {
    suspend fun logIn(userName : String, password : String) : Response<RequestToken>
    suspend fun getRequestToken(userName : String, password : String) : Response<RequestToken>
    suspend fun checkLoginInformation(checkLoginBody : CheckLoginBody) : Response<AuthenticationTokenResponse>
    suspend fun getSessionId(requestToken : String) : Response<SessionIdResponse>
    suspend fun getAccountId(sessionId : String) : Response<AccountResponse>
}