package com.codeunlu.HrmsFinal.core.utilies.results;

public class ErrorResult extends Result{

    public ErrorResult(String message) {
        super(false, message);
    }

    public ErrorResult(boolean success) {
        super(false);
    }
}
