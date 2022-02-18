package com.github.muldrik.mykotlinanalysisplugin.services

import com.intellij.openapi.project.Project
import com.github.muldrik.mykotlinanalysisplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
