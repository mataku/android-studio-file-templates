package com.github.mataku.androidstudiofiletemplates.services

import com.intellij.openapi.project.Project
import com.github.mataku.androidstudiofiletemplates.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
