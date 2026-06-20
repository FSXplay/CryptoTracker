package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.CoinPrice
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.CryptoRepository
import kotlinx.coroutines.launch

class CryptoViewModel(
    private val repository: CryptoRepository = CryptoRepository()
) : ViewModel() {

    var coins by mutableStateOf<List<CoinPrice>>(emptyList())
        private set

    var currency by mutableStateOf("sgd")
        private set

    var isLoading by mutableStateOf(false)
        private set

//    init {
//        loadCoins()
//    }

    fun updateCurrency(newCurrency: String) {
        currency = newCurrency
        loadCoins()
    }

    private fun loadCoins() {
        viewModelScope.launch {
            isLoading = true
            coins = repository.getTopCoins(currency)
            isLoading = false
        }
    }
}