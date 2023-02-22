package habibellah.ayata.domain.entity


import com.google.gson.annotations.SerializedName

data class CheckLoginBody(
    @SerializedName("password")
    val password: String?,
    @SerializedName("request_token")
    val requestToken: String?,
    @SerializedName("username")
    val username: String?
)