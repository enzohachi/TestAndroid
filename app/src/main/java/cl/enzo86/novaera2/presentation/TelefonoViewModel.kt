package cl.enzo86.novaera2.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.enzo86.novaera2.domain.ObtenerTelefonoUseCase
import cl.enzo86.novaera2.domain.model.Telefono
import kotlinx.coroutines.launch
import java.lang.Exception

class TelefonoViewModel (private val obtenerTelefonoUseCase: ObtenerTelefonoUseCase
) : ViewModel(){

    private val liveData = MutableLiveData<TelefonoUiState>()

    fun getLiveData() = liveData

    fun obtenerProductos(){
        liveData.postValue(TelefonoUiState.LoadingTelefonoUiState)
        viewModelScope.launch {
            try {
                val result = obtenerTelefonoUseCase.execute()
                handleResult(result)
            }catch (e: Exception){
                handleError(e)
            }
        }
    }

    private fun handleError(e: Exception) {
        liveData.postValue(TelefonoUiState.ErrorServerTelefonoUiState)
    }

    private fun handleResult(result: List<Telefono>) {
        if(result.isEmpty()){
            liveData.postValue(TelefonoUiState.EmptyListTelefonoUiState)
        }else{
            liveData.postValue(TelefonoUiState.Success(result))
        }
    }
}
