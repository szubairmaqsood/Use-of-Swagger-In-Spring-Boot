package com.example.SpringBootSwagger2Use.controllers

import com.example.SpringBootSwagger2Use.models.Product
import com.example.SpringBootSwagger2Use.services.ProductService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
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

    @GetMapping("/")
    fun Root():String{
        return "This is server root"
    }

    @GetMapping("/list")
    @ApiOperation(value = "View a list of available products")
    @ApiResponses(
            value = [
                ApiResponse(code = 200, message = "List Reterived Successfully"),
            ]
    )

    fun list():ResponseEntity<Collection<Product>>{
        return productService.listAllProducts()
    }

    @ApiOperation(value = "Show a product")
    @GetMapping("/show/{id}")
    @ApiResponses(
            value = [
                ApiResponse(code = 200, message = "List Reterived Successfully"),
                ApiResponse(code = 404, message = "Product with ID not Found"),
            ]
    )

    fun showProduct(@PathVariable id:Int):ResponseEntity<Optional<Product>>{
     return productService.showProduct(id)
    }

    @ApiOperation(value = "Add a product")
    @PostMapping ("/add")
    @ApiResponses(
            value = [
                ApiResponse(code = 201, message = "Product Created Successfully"),

            ]
    )
    fun saveProduct(@RequestBody product:Product):ResponseEntity<Product>{
        return productService.addProduct(product)
    }

    @ApiOperation(value = "Update a product")
    @PutMapping("/update/{id}")
    @ApiResponses(
            value = [
                ApiResponse(code = 200, message = "Product created successfully"),
                ApiResponse(code = 404, message = "Product with this ID does not exist"),

            ]
    )
    fun updateProduct(@PathVariable id: Int, @RequestBody product:Product):ResponseEntity<Product>{
        return productService.updateProduct(id,product)

    }


    @ApiOperation(value = "Delete a product")
    @ApiResponses(
            value = [
                ApiResponse(code = 200, message = "Product deleted successfully"),
                ApiResponse(code = 404, message = "Product with this ID does not exist"),

            ]
    )
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<String> {
        return productService.DeleteProduct(id)

    }
}