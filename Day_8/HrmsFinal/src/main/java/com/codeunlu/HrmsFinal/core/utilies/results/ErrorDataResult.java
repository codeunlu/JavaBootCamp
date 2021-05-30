package com.codeunlu.HrmsFinal.core.utilies.results;

public class ErrorDataResult<T> extends DataResult<T>{
    public ErrorDataResult(T data, boolean success, String message) {
        super(data, false, message);
    }

    public ErrorDataResult(String message) {
        super(null, false,message);
    }

    public ErrorDataResult(T data){
        super(data,false);
    }

    public ErrorDataResult(){
        super(null,false);
    }
}
