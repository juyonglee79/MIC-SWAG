package the.mic.swag.presentation.viewmodel.mypage

import androidx.lifecycle.ViewModel
import the.mic.swag.domain.repository.mypage.MyPageRepository

class MyPageViewModel(val myPageRepository: MyPageRepository) : ViewModel() {
}