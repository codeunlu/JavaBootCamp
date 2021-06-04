package com.codeunlu.HrmsFinal.core.adapters.images;

import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageUploadService {
    DataResult<Map<String,String>> upload(MultipartFile file);
}
