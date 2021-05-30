package com.codeunlu.HrmsFinal.core.adapters.emails;

import com.codeunlu.HrmsFinal.core.utilies.results.Result;

public interface EmailSendService {
    Result send(String email, String code);
}
