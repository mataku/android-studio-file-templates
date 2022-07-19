package other.viewmodel.src.app_package

fun viewModelTemplate(
    packageName: String,
    viewModelName: String
) = """package $packageName

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
    
@HiltViewModel
class $viewModelName @Inject constructor(

) : ViewModel() {
}
"""