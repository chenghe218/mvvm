package com.example.myapplication.demo;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/25 21:09
 */
public class NetUtil {

    private Retrofit retrofit;

    public NetUtil() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://cn.bing.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public interface ImageService {
        @GET("HPImageArchive.aspx")
        Observable<ImageBean> getBingImage(@Query("format") String format,
                                     @Query("idx") int idx,
                                     @Query("n") int n);
    }

    public Observable<ImageBean> getBingImage(String format, int idx, int n) {
        return retrofit.create(ImageService.class).getBingImage(format, idx, n);
    }

}

