package habibellah.ayata.domain.useCase

import habibellah.ayata.domain.repositories.UserInfoRepository

class GetUserInfoUseCase(private val userInfoRepository : UserInfoRepository) {
    fun storeUserName(userName : String) {
        userInfoRepository.storeUserName(userName)
    }

    fun getUserName() = userInfoRepository.getUserName()
}