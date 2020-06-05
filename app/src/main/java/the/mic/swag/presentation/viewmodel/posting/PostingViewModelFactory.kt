package the.mic.swag.presentation.viewmodel.posting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import the.mic.swag.domain.repository.posting.PostingRepository

class PostingViewModelFactory(val postingRepository: PostingRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return PostingViewModel(postingRepository) as T
    }
}
