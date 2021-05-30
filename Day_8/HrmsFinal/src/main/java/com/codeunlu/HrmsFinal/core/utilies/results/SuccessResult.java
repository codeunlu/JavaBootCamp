package com.codeunlu.HrmsFinal.core.utilies.results;

public class SuccessResult extends Result{
    public SuccessResult(String message) {
        super(true, message);
    }

    public SuccessResult(boolean success) {
        super(true);
    }
}
