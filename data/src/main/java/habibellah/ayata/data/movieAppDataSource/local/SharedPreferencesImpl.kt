package habibellah.ayata.data.movieAppDataSource.local

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesImpl(private val context : Context) :
    habibellah.ayata.data.movieAppDataSource.local.SharedPreferences {
    private lateinit var sharedPref : SharedPreferences

    override fun storeUserName(userName : String) {
        initSharedStorage()
        val e = sharedPref.edit()
        e.putString(SharedPreferencesConstants.USER_NAME_KEY, userName)
        e.apply()
    }

    override fun getUserName() : String? {
        initSharedStorage()
        return sharedPref.getString(SharedPreferencesConstants.USER_NAME_KEY, null)
    }

    override fun storeSessionId(sessionId : String) {
        initSharedStorage()
        val e = sharedPref.edit()
        e.putString(SharedPreferencesConstants.SESSION_ID_KEY, sessionId)
        e.apply()
    }

    override fun storeAccountId(accountId : Int) {
        initSharedStorage()
        val e = sharedPref.edit()
        e.putInt(SharedPreferencesConstants.ACCOUNT_ID_KEY, accountId)
        e.apply()
    }

    override fun initSharedStorage() {
        sharedPref = context.getSharedPreferences(
            SharedPreferencesConstants.SHARED_STORE_NAME,
            Context.MODE_PRIVATE
        )
    }
}