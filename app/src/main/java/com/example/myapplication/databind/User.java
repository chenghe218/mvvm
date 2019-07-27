package com.example.myapplication.databind;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.myapplication.BR;

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/22 20:56
 */
public class User extends BaseObservable {

    private String name;
    private String age;
    private String school;

    public User(String name, String age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getAge() {
        return age;
    }

    @Bindable
    public String getSchool() {
        return school;
    }

    public void setName(String name) {
        this.name = name;
        //更新所有字段
        notifyChange();
    }

    public void setAge(String age) {
        this.age = age;
        //只更新本字段
        notifyPropertyChanged(BR.age);
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
