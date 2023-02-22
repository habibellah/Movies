package habibellah.ayata.movies.ui.viewModels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.domain.useCase.GetUserInfoUseCase
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val getUserInfoUseCase : GetUserInfoUseCase
) : ViewModel() {
    fun getUserName() : String? = getUserInfoUseCase.getUserName()
}