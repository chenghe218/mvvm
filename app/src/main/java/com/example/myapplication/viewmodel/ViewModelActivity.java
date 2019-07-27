package com.example.myapplication.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityViewModelBinding;
import com.example.myapplication.viewmodel.model.User;
import com.example.myapplication.viewmodel.vm.MainViewModel;

/**
 * @Description: JetPack之 viewModel liveData
 * @Author: ch
 * @CreateDate: 2019/7/23 14:52
 */
public class ViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        final ActivityViewModelBinding activityViewModelBinding= DataBindingUtil.setContentView(this,R.layout.activity_view_model);

        activityViewModelBinding.setData(mainViewModel);
        activityViewModelBinding.setLifecycleOwner(this);

        activityViewModelBinding.btActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mainViewModel.getUsers().postValue(new User("Activity", "hangzhou", 19));
                mainViewModel.setUsers("Activity", "hangzhou", 19);
            }
        });

//        mainViewModel.getUsers().observe(this, new Observer<User>() {
//            @Override
//            public void onChanged(User user) {
//                activityViewModelBinding.tvTextActivity.setText(String.format(getString(R.string.formatStr),user.getName(),user.getCity(),user.getAge()));
//            }
//        });
    }

    public String getString(String name, String city, int age){
        return String.format(getString(R.string.formatStr),name,city,age);
    }
}
