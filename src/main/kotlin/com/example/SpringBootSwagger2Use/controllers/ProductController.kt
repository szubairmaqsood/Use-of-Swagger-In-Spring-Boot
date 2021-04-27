package com.example.SpringBootSwagger2Use.controllers

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/Product")
class ProductController {

    @GetMapping("/list")
    fun list():String{
        return "This is the method which shows all list products"
    }

    @GetMapping("/show/{id}")
    fun showProduct(@PathVariable id:Int):String{
        return "The prodouct show id is" + id.toString()
    }

    @PostMapping ("/add")
    fun saveProduct():String{
        return "Save Product is called"
    }

    @PutMapping("/update/{id}")
    fun updateProduct(@PathVariable id:Int):String{
        return "The prodouct update id is" + id.toString()
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Int):String{
        return "The prodouct delete id is" + id.toString()
    }
}