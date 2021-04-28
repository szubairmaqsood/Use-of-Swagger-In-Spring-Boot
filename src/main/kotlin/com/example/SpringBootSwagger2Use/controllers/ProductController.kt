package com.example.SpringBootSwagger2Use.controllers

import com.example.SpringBootSwagger2Use.models.Product
import com.example.SpringBootSwagger2Use.services.ProductService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
@RequestMapping("/Product")
class ProductController {

    var productService: ProductService
    @Autowired
    constructor(productService: ProductService){
        this.productService= productService
    }

    @GetMapping("/list")
    @ApiOperation(value = "View a list of available products")
    fun list():ResponseEntity<Collection<Product>>{
        return productService.listAllProducts()
    }

    @ApiOperation(value = "Show a product")
    @GetMapping("/show/{id}")
    fun showProduct(@PathVariable id:Int):ResponseEntity<Optional<Product>>{
     return productService.showProduct(id)
    }

    @ApiOperation(value = "Add a product")
    @PostMapping ("/add")
    fun saveProduct(@RequestBody product:Product):ResponseEntity<Product>{
        return productService.addProduct(product)
    }

    @ApiOperation(value = "Update a product")
    @PutMapping("/update/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody product:Product):ResponseEntity<Product>{
        return productService.updateProduct(id,product)

    }


    @ApiOperation(value = "Delete a product")
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<String> {
        return productService.DeleteProduct(id)

    }
}