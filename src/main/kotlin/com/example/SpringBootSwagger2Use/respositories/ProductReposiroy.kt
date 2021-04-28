package com.example.SpringBootSwagger2Use.respositories

import com.example.SpringBootSwagger2Use.models.Product
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Qualifier("Product")
@Repository
interface ProductReposiory:JpaRepository<Product,Int> {
    //fun listAllProducts():Collection<Product>{
     //   return findAll()
   // }

}