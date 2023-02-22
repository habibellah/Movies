package habibellah.ayata.data.movieAppDataSource.local

interface SharedPreferences {
    fun storeUserName(userName : String)
    fun getUserName() : String?
    fun storeSessionId(sessionId : String)
    fun storeAccountId(accountId : Int)
    fun initSharedStorage()
}