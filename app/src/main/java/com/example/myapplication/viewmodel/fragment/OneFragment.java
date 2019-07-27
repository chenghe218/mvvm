package com.example.myapplication.viewmodel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.viewmodel.model.User;
import com.example.myapplication.viewmodel.vm.MainViewModel;

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/23 15:26
 */
public class OneFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        final MainViewModel mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        Button button = view.findViewById(R.id.bt_one_fragment);
        final TextView textView = view.findViewById(R.id.tv_text_one_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.getUsers().postValue(new User("OneFragment", "shanghai", 29));
            }
        });

        mainViewModel.getUsers().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                textView.setText(String.format(getString(R.string.formatStr),user.getName(),user.getCity(),user.getAge()));
            }
        });
        return view;
    }
}
