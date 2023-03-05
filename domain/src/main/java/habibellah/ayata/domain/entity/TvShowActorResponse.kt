package habibellah.ayata.domain.entity


import com.google.gson.annotations.SerializedName

data class TvShowActorResponse(
    @SerializedName("cast")
    val cast: List<CastX>?,
    @SerializedName("crew")
    val crew: List<Crew>?,
    @SerializedName("id")
    val id: Int?
)