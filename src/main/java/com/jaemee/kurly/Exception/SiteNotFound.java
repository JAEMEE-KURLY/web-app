package com.jaemee.kurly.Exception;

public class SiteNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public SiteNotFound(String msg){
        super(msg);
    }
    
}
