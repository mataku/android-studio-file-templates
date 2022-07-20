package other.viewmodel

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.viewmodel.src.app_package.viewModel
import other.viewmodel.test.app_package.viewModelSpec
import other.viewmodel.test.app_package.viewModelTest
import util.slashedPackageName
import java.io.File

fun RecipeExecutor.viewModelRecipe(
    moduleData: ModuleTemplateData,
    moduleName: String,
    packageName: String,
    viewModelName: String,
    junitTestFileRequired: Boolean,
    kotestSpecFileRequired: Boolean
) {
    val (_, srcOut, _) = moduleData

    val mainSourcePath = "${moduleName}/src/main/java/${packageName.slashedPackageName()}"
    val testSourcePath = "${moduleName}/src/test/java/${packageName.slashedPackageName()}"

    save(
        viewModel(
            packageName = packageName,
            viewModelName = viewModelName
        ),
        File("$mainSourcePath/${viewModelName}.kt")
    )
    if (junitTestFileRequired) {
        save(
            viewModelTest(
                packageName = packageName,
                viewModelName = viewModelName
            ),
            File("$testSourcePath/${viewModelName}Test.kt")
        )
    }
    if (kotestSpecFileRequired) {
        save(
            viewModelSpec(
                packageName = packageName,
                viewModelName = viewModelName
            ),
            File("$testSourcePath/${viewModelName}Spec.kt")
        )
    }
}

