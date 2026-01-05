package com.eval.evalspring.exception;

public class ProduitNotFoundException extends RuntimeException{

    public ProduitNotFoundException(String message)
    {
        super(message);
    }
}
