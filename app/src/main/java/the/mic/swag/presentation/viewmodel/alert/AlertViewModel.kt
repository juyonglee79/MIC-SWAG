package the.mic.swag.presentation.viewmodel.alert

import androidx.lifecycle.ViewModel
import the.mic.swag.domain.repository.alert.AlertRepository

class AlertViewModel(val alertRepository: AlertRepository) : ViewModel()