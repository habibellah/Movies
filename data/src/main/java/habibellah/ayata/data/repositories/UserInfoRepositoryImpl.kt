package habibellah.ayata.data.repositories

import habibellah.ayata.data.movieAppDataSource.local.SharedPreferences
import habibellah.ayata.domain.repositories.UserInfoRepository

class UserInfoRepositoryImpl(private val preferencesDataStore : SharedPreferences) :
    UserInfoRepository {
    override fun storeUserName(userName : String) {
        preferencesDataStore.storeUserName(userName)
    }

    override fun getUserName() = preferencesDataStore.getUserName()
    override fun storeSessionId(sessionId : String) {
        preferencesDataStore.storeSessionId(sessionId)
    }

    override fun storeAccountId(accountId : Int) {
       preferencesDataStore.storeAccountId(accountId)
    }
}