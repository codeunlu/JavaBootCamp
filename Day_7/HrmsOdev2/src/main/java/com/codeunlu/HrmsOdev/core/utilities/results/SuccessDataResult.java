package com.codeunlu.HrmsOdev.core.utilities.results;


import java.util.List;

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
