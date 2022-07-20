package other.viewmodel

import com.android.tools.idea.wizard.template.RecipeExecutor
import other.viewmodel.src.app_package.viewModel
import other.viewmodel.test.app_package.viewModelSpec
import other.viewmodel.test.app_package.viewModelTest
import util.slashedPackageName
import java.io.File

fun RecipeExecutor.viewModelRecipe(
    moduleName: String,
    packageName: String,
    viewModelName: String,
    junitTestFileRequired: Boolean,
    kotestSpecFileRequired: Boolean
) {
    val mainSourcePath = "${moduleName}/src/main/java/${packageName.slashedPackageName()}"
    val testSourcePath = "${moduleName}/src/test/java/${packageName.slashedPackageName()}"

    val viewModelPath = "$mainSourcePath/${viewModelName}.kt"
    save(
        viewModel(
            packageName = packageName,
            viewModelName = viewModelName
        ),
        File(viewModelPath)
    )
    open(File(viewModelPath))
    if (junitTestFileRequired) {
        val viewModelTestPath = "$testSourcePath/${viewModelName}Test.kt"
        save(
            viewModelTest(
                packageName = packageName,
                viewModelName = viewModelName
            ),
            File(viewModelTestPath)
        )
        open(File(viewModelPath))
    }
    if (kotestSpecFileRequired) {
        val viewModelSpecPath = "$testSourcePath/${viewModelName}Spec.kt"
        save(
            viewModelSpec(
                packageName = packageName,
                viewModelName = viewModelName
            ),
            File(viewModelSpecPath)
        )
        open(File(viewModelSpecPath))
    }
}

