package the.mic.swag.presentation.viewmodel.alert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import the.mic.swag.domain.repository.alert.AlertRepository

class AlertViewModelFactory (val alertRepository: AlertRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return AlertViewModel(alertRepository) as T
    }
}
