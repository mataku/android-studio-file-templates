package other.viewmodel

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.CheckBoxWidget
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.booleanParameter
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template

val viewModelTemplate = template {
    name = "ViewModel with Hilt"
    description = "Creates a new ViewModel with Dagger Hilt."
    minApi = MIN_API
    category = Category.Other
    formFactor = FormFactor.Mobile
    screens = listOf(
        WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry,
        WizardUiContext.NewProject, WizardUiContext.NewModule
    )
    val moduleNameParam = stringParameter {
        name = "Module name"
        default = "app"
        help = "Name of module to put ViewModel into"
        constraints = listOf(Constraint.NONEMPTY)
    }
    val viewModelNameParam = stringParameter {
        name = "ViewModel class name"
        default = "ViewModel"
        help = "Name of ViewModel class to create"
        constraints = listOf(Constraint.NONEMPTY)
    }
    val packageNameParam = stringParameter {
        name = "Package name"
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }
    val junitParam = booleanParameter {
        name = "Generate JUnit Test file"
        default = false
        help = "Set checked if you want to generate junit test file too"
    }
    val kotestParam = booleanParameter {
        name = "Generate kotest spec file"
        default = false
        help = "Set checked if you want to generate kotest spec file too"
    }
    widgets(
        TextFieldWidget(viewModelNameParam),
        TextFieldWidget(moduleNameParam),
        PackageNameWidget(packageNameParam),
        CheckBoxWidget(junitParam),
        CheckBoxWidget(kotestParam)
    )
    recipe = { data: TemplateData ->
        viewModelRecipe(
            data as ModuleTemplateData,
            moduleName = moduleNameParam.value,
            packageName = packageNameParam.value,
            viewModelName = viewModelNameParam.value,
            junitTestFileRequired = junitParam.value,
            kotestSpecFileRequired = kotestParam.value
        )
    }
}