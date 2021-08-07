package com.example.jsmall.modelclass


 class DataModel{
     var title: String? = null
     var price: Double? = null
     var description : String? = null
     var category : String? = null
     var image: String? = null

     constructor()
     constructor(
         title: String?,
         price: Double?,
         description: String?,
         category: String?,
         image: String?
     ) {
         this.title = title
         this.price = price
         this.description = description
         this.category = category
         this.image = image
     }

 }
