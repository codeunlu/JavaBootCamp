package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.Language;

public interface LanguageService {
    Result add(Language language);
}
