package com.example.SpringBootSwagger2Use.controllers

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
@RequestMapping("/Product")
class ProductController {


    @GetMapping("/list")
    @ApiOperation(value = "View a list of available products")
    fun list():String{
        return "This is the method which shows all list products"
    }

    @ApiOperation(value = "Show a product")
    @GetMapping("/show/{id}")
    fun showProduct(@PathVariable id:Int):String{
        return "The prodouct show id is" + id.toString()
    }

    @ApiOperation(value = "Add a product")
    @PostMapping ("/add")
    fun saveProduct():String{
        return "Save Product is called"
    }

    @ApiOperation(value = "Update a product")
    @PutMapping("/update/{id}")
    fun updateProduct(@PathVariable id:Int):String{
        return "The prodouct update id is" + id.toString()
    }
    @ApiOperation(value = "Delete a product")
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Int):String{
        return "The prodouct delete id is" + id.toString()
    }
}