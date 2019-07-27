package com.example.myapplication.demo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/25 21:02
 */
public class DemoActivityViewModel extends AndroidViewModel {

    private ImageRepository imageRepository ;
    private MutableLiveData<BaseData<ImageBean>> imageBean ;

    public DemoActivityViewModel(@NonNull Application application) {
        super(application);
        imageRepository=new ImageRepository();
        imageBean=new MutableLiveData<>();
    }

    public MutableLiveData<BaseData<ImageBean>> getImageBean() {
        return imageBean;
    }

    /**
     * 获取图片
     *
     * @return
     */
    public void getImage() {
        imageBean = imageRepository.getBingImage();
    }

    /**
     * 获取下一张
     */
    public void getNextImage() {
        imageBean = imageRepository.getNextImage();
    }

    /**
     * 获取上一张
     */
    public void getPreviousImage() {
        imageBean = imageRepository.getPreviousImage();
    }

}
