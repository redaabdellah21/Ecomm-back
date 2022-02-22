package org.pharmacie.appecommerce.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
