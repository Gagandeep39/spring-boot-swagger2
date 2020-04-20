/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-09 19:55:24
 * @modify date 2020-04-10 23:15:23
 * @desc Controller containing various product related Get post methods
 */
package com.spring.labrestproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import com.spring.labrestproduct.entity.Product;
import com.spring.labrestproduct.exception.ProductNotFoundException;
import com.spring.labrestproduct.repository.ProductRepository;

@RestController
@RequestMapping(value = "/api")
@Api("This is a product class, It is sued to provide Products related REST services")
public class ProductController {

    /**
     * Used to access the product repository
     */
    @Autowired
    private ProductRepository respository;

    /**
     * Used to display all the products from the reository
     * 
     * @return List of All products
     * 
     * @ApiOperation
     * Displays Method name, return Object by default 
     * value: Short title
     * notes: Description
     * response: Object to be sent to client
     */
    @GetMapping("/all")
    @ApiOperation(
        value = "Show All products", 
        notes = "Fetches a list of products from the repository", 
        response = Product.class)
    public List<Product> showAllProducts() {
        return respository.fetchAll();
    }

    /**
     * @ApiOperation value: Short Definition notes: Detailed Description reponse:
     *               Reponse Class
     */

    /**
     * @param Product Save Data in product repository
     * @return Product with an ID
     * @ApiOperations
     * value: Short Description
     * notes: Detailed description
     * response: Object to be sent to client
     * @ApiParam Parameter description 
     */
    @PostMapping(value = "/add")
    @ApiOperation(
        value = "Add product", 
        notes = "Adds the product to repository", 
        response = Product.class)
    public Product saveProduct(
            @ApiParam(value = "Product object to be stoored in repository", required = true) @RequestBody Product product) {
        return respository.addProduct(product);
    }

    /**
     * @param productId The index to be fetched
     * @return The product whose id is passed as parameter ***********Addeding below
     *         line somehow gives error************ **********FIXED - It was giving
     *         error as consmption media is text and not json consumes =
     *         MediaType.APPLICATION_JSON_VALUE, produces =
     *         MediaType.APPLICATION_JSON_VALUE
     */
    @GetMapping(value = "/{productId}")
    public Product fetchById(@PathVariable int productId) {
        if (productId < 0 || productId >= respository.fetchAll().size()) {
            throw new ProductNotFoundException("Product Not available");
        } else {
            return respository.findById(productId);
        }
    }

}