/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-09 19:55:29
 * @modify date 2020-04-09 20:14:45
 * @desc Produt bean
 */
package com.spring.labrestproduct.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ApiModel Used to Specify detail about a model class
 * @ApiModelProperty Specifies the model property details
 */
@ApiModel(value = "Product Entity containing id, name, price")
public class Product {

    @ApiModelProperty(value = "Product ID")
    private int productId;
    @ApiModelProperty(value = "Product Name")
    private String productName;
    @ApiModelProperty(value = "Product Price")
    private double productPrice;

    public Product() {

    }

    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductId(){
        return productId;
    }

    public double getProductPrice(){
        return productPrice;
    }

    public String getProductName(){
        return productName;
    }

    public void setId(int productId){
        this.productId = productId;
    }

    @Override
    public String toString(){
        return "productId: " + productId + ", productName: " + productName + ", productPrice" + productPrice;
    }

}