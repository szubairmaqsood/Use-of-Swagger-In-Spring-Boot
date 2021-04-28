package com.example.SpringBootSwagger2Use.models

import io.swagger.annotations.ApiModelProperty
import java.math.BigDecimal
import javax.persistence.*


@Entity
@Table(name = "Product")
class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    var id: Int = 0

    @ApiModelProperty(notes = "The product description")
    var description: String

    @ApiModelProperty(notes = "The price of the product", required = true)
     var price:   Int

     constructor(){
     description=""
         price=35
     }
     constructor(description: String="" ,price:     Int ){
         this.description = description
         this.price = price
     }


}