/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-10 23:30:02
 * @modify date 2020-04-10 23:30:02
 * @desc Product Not found custom Exception thrown when invlaid ID is entered
 */
package com.spring.labrestproduct.exception;

public class ProductNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 4048038566195910939L;

    public ProductNotFoundException(String message) {
        super(message);
    }

}