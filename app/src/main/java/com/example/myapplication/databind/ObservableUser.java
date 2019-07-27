package com.example.myapplication.databind;

import androidx.databinding.ObservableField;

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/23 10:32
 */
public class ObservableUser {
    private ObservableField<String> name;
    private ObservableField<String> school;
    private ObservableField<String> city;

    public ObservableUser(String name, String school, String city) {
        this.name = new ObservableField<>(name);
        this.school = new ObservableField<>(school);
        this.city = new ObservableField<>(city);
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name = new ObservableField<>(name);
    }

    public ObservableField<String> getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = new ObservableField<>(school);
    }

    public ObservableField<String> getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = new ObservableField<>(city);
    }
}
