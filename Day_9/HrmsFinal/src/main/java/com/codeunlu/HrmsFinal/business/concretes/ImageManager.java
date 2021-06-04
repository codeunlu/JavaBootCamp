package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.ImageService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.ImageDao;
import com.codeunlu.HrmsFinal.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageManager implements ImageService {
    private ImageDao imageDao;
    @Autowired
    public ImageManager(ImageDao imageDao){
        this.imageDao = imageDao;
    }
    @Override
    public Result add(Image image) {
        imageDao.save(image);
        return new SuccessResult("Registered is Images");
    }
}
