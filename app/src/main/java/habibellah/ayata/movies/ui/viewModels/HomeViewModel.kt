package habibellah.ayata.movies.ui.viewModels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.movies.ui.viewModels.states.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(){
    private val _homeState = MutableStateFlow(HomeUiState())
    val homeState = _homeState.asStateFlow()
}