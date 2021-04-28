package com.example.SpringBootSwagger2Use.services

import com.example.SpringBootSwagger2Use.models.Product
import com.example.SpringBootSwagger2Use.respositories.ProductReposiory
//import com.example.SpringBootSwagger2Use.respositories.ProductReposiory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService {

    var  productRepository: ProductReposiory

    @Autowired
    constructor(@Qualifier("Product") _productRepository: ProductReposiory){
        this.productRepository=_productRepository
    }

    fun listAllProducts():ResponseEntity<Collection<Product>>{
        return  ResponseEntity(productRepository.findAll(),HttpStatus.OK)
    }

    fun showProduct(id:Int): ResponseEntity<Optional<Product>> {
        var product:Optional<Product> = productRepository.findById(id)
        if(product.isPresent){
            return  ResponseEntity(product,HttpStatus.OK)
        }else{
            return  ResponseEntity.notFound().build();
        }

    }

    fun addProduct(product:Product):ResponseEntity<Product>{

        productRepository.saveAndFlush(product)
       return  ResponseEntity(product,HttpStatus.OK)
    }

    fun DeleteProduct(id:Int): ResponseEntity<String> {
        var product:Optional<Product> = productRepository.findById(id)
        if(product.isPresent){
            productRepository.deleteById(id)
            return ResponseEntity("The product with id " + id.toString()  + " deleted successfully",HttpStatus.OK)
        }
        else{
            return ResponseEntity("The product with id " + id.toString()  + " does not exist",HttpStatus.BAD_REQUEST)
        }


    }

    fun updateProduct(id:Int,product:Product):ResponseEntity<Product>{
    var _product:Optional<Product> = productRepository.findById(id)

        if(_product.isPresent) {
            var product1:Product    =_product.get()
            product1.description = product.description
            product1.price = product.price
            productRepository.saveAndFlush(product1)
            return ResponseEntity(product1,HttpStatus.OK)
        }
        else{
            return ResponseEntity.badRequest().build()
        }
    }


}