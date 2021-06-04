package com.codeunlu.HrmsFinal.core.adapters.emails;

import com.codeunlu.HrmsFinal.core.utilies.results.ErrorResult;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailSendManager implements EmailSendService{
    @Override
    public Result send(String email, String code) {
        if(email.isEmpty() || code.isEmpty()){
            return new ErrorResult("Information is missing");
        }
        return new SuccessResult("A confirmation code has been sent to your e-mail address.");
    }
}
