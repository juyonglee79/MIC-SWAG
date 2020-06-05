package the.mic.swag.presentation.viewmodel.posting

import androidx.lifecycle.ViewModel
import the.mic.swag.domain.repository.posting.PostingRepository

class PostingViewModel(val postingRepository: PostingRepository) : ViewModel() {
}