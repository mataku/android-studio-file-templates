package com.github.mataku.template.services

import com.intellij.openapi.project.Project
import com.github.mataku.template.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
