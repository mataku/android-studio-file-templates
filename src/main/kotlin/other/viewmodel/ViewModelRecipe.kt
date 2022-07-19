package other.viewmodel

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.viewmodel.src.app_package.viewModelTemplate

fun RecipeExecutor.viewModelRecipe(
    moduleData: ModuleTemplateData,
    packageName: String,
    viewModelName: String
) {
    val (_, srcOut, _) = moduleData

    save(
        viewModelTemplate(
            packageName = packageName,
            viewModelName = viewModelName
        ),
        srcOut.resolve("$viewModelName.kt")
    )
}