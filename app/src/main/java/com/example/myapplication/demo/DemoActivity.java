package com.example.myapplication.demo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityDemoBinding;

/**
 * @Description: 必应每日一图(mvvm小demo)
 * @Author: ch
 * @CreateDate: 2019/7/25 20:59
 */
public class DemoActivity extends AppCompatActivity {
    private ActivityDemoBinding activityDemoBinding;
    private DemoActivityViewModel demoActivityViewModel;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDemoBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo);
        demoActivityViewModel = ViewModelProviders.of(this).get(DemoActivityViewModel.class);
        activityDemoBinding.setViewModel(demoActivityViewModel);
        activityDemoBinding.setEventListener(new OnEventListener());
        progressDialog = new ProgressDialog(DemoActivity.this);
        progressDialog.setMessage("加载中。。。。");
        demoActivityViewModel.getImage();
        progressDialog.show();
        demoActivityViewModel.getImageBean().observe(this, new Observer<BaseData<ImageBean>>() {
            @Override
            public void onChanged(BaseData<ImageBean> imageBeanBaseData) {
                if (imageBeanBaseData.getData() != null) {
                    //1.直接代码赋值
//                    Glide.with(DemoActivity.this)
//                            .load("https://www.bing.com" + imageBeanBaseData.getData().getImages().get(0).getUrl())
//                            .into(activityDemoBinding.ivImg);
//                    activityDemoBinding.tvContent.setText(imageBeanBaseData.getData().getImages().get(0).getCopyright());

                    //2.利用DataBinding直接赋值

                    activityDemoBinding.setImage(imageBeanBaseData.getData().getImages().get(0));
                } else {
                    Toast.makeText(DemoActivity.this, imageBeanBaseData.getMessage(), Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    public class OnEventListener {
        public void onClick(View view) {
            progressDialog.show();
            switch (view.getId()) {
                case R.id.tv_previous:
                    demoActivityViewModel.getPreviousImage();
                    break;
                case R.id.tv_next:
                    demoActivityViewModel.getNextImage();
                    break;
                default:
                    break;
            }
        }
    }

}
