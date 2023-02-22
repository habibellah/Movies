package habibellah.ayata.domain.repositories

interface UserInfoRepository {
    fun storeUserName(userName : String)
    fun getUserName() : String?
    fun storeSessionId(sessionId : String)
    fun storeAccountId(accountId : Int)
}