package other.viewmodel.test.app_package

fun viewModelTest(
    packageName: String,
    viewModelName: String
) = """package $packageName
   
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class ${viewModelName}Test {
    @BeforeTest
    fun setUp() {
    }
    
    @AfterTest
    fun tearDown() {
    }
    
    @Test
    fun testFunc() {
    }
}
"""