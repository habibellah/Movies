package habibellah.ayata.movies.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.domain.useCase.AuthenticationState
import habibellah.ayata.domain.useCase.MovieState
import habibellah.ayata.domain.useCase.ValidateUserInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateUserInfoUseCase : ValidateUserInfoUseCase
) : ViewModel() {
    private val _authState : MutableStateFlow<AuthenticationState> =
        MutableStateFlow(AuthenticationState.BeforeLoginClick)
    val authState = _authState.asStateFlow()
    fun logIn(userName : String, password : String) {
        viewModelScope.launch {
            validateUserInfoUseCase.login(userName, password).collect {
                when (it) {
                    is MovieState.Loading -> {
                        _authState.emit(AuthenticationState.Loading)
                    }
                    is MovieState.Success -> {
                        _authState.emit(it.data!!)
                    }
                    is MovieState.Error -> {
                        _authState.emit(AuthenticationState.Error)
                    }
                }
            }
        }
    }
}