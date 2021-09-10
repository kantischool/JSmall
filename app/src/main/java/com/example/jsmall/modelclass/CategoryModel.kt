package com.example.jsmall.modelclass

class CategoryModel {
    var categoryIcon : String? = null
    var categoryName : String? = null

    constructor()
    constructor(categoryIcon: String?, categoryName: String?) {
        this.categoryIcon = categoryIcon
        this.categoryName = categoryName
    }

}