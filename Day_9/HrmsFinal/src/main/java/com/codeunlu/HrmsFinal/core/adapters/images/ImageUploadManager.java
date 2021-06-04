package com.codeunlu.HrmsFinal.core.adapters.images;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.codeunlu.HrmsFinal.core.utilies.results.DataResult;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploadManager implements ImageUploadService{

    private Cloudinary cloudinary;

    @Autowired
    public ImageUploadManager(Cloudinary cloudinary){
        this.cloudinary = cloudinary;
    }

    @Override
    public DataResult<Map<String, String>> upload(MultipartFile multipartFile){

        Map<String,String> uploadResultMap = null;

        try {
            File file = convert(multipartFile);
            uploadResultMap = this.cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
//			bellekte tutulan dosyayı silmek için
            file.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SuccessDataResult<Map<String,String>>(uploadResultMap);
    }

    //	multipartfile ı file a dönüştürür.
    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
    }
}
