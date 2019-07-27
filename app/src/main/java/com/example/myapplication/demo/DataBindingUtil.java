package com.example.myapplication.demo;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/26 10:56
 */
public class DataBindingUtil {
    @BindingAdapter(value = {"url"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }
}
