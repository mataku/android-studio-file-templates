package other.viewmodel.test.app_package

fun viewModelSpec(
    packageName: String,
    viewModelName: String
) = """package $packageName
   
import io.kotest.core.spec.style.DescribeSpec

class ${viewModelName}Spec : DescribeSpec({
    
})
"""