package habibellah.ayata.domain.repositories

import habibellah.ayata.domain.entity.ActorsResponse
import retrofit2.Response

interface ActorRepository {
  suspend  fun getActorsList(id: Int):Response<ActorsResponse>
}