package com.jaemee.kurly.Exception;

public class CategoryNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CategoryNotFound(String msg){
        super(msg);
    }
    
}
