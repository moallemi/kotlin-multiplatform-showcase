package me.moallemi.kmpshowcase.server.utils

fun getResourceContent(filePath: String) = object {}.javaClass.classLoader.getResource(filePath).readText()