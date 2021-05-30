package com.codeunlu.HrmsFinal.core.utilies.results;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult(T data, boolean success, String message) {
        super(data, true, message);
    }

    public SuccessDataResult(String message) {
        super(null, true,message);
    }

    public SuccessDataResult(T data, String message) {
        super(data, true,message);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(){
        super(null,true);
    }
}
