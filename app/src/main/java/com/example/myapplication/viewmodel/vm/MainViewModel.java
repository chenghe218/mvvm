package com.example.myapplication.viewmodel.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.viewmodel.model.User;

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/23 15:52
 */
public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<User> users;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<User> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            //TODO可以从网络获取
            //.......
        }
        return users;
    }

    //setValue():必须在主线程中才能使用  postValue():既可在主线程也可在子线程中调用 即在工作线程中调用
    public void setUsers(String name, String city, int age) {
        users.setValue(new User(name, city, age));
    }
}
