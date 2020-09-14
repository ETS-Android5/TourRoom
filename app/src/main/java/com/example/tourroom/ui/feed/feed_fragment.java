package com.example.tourroom.ui.feed;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tourroom.R;
import com.example.tourroom.ui.profile.other_profile_activity;

import java.util.Objects;

public class feed_fragment extends Fragment {
    RecyclerView feed_recycler_view;
    Feed_Recycler_Adapter feed_recycler_adapter;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FeedFragmentViewModel mViewModel = new ViewModelProvider(this).get(FeedFragmentViewModel.class);
        return inflater.inflate(R.layout.feed_fragment, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(!Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).isShowing()){
            Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).show();
        }

        feed_recycler_view=view.findViewById(R.id.feed_recyclerview);
        feed_recycler_adapter=new Feed_Recycler_Adapter();

        feed_recycler_view.setLayoutManager(new LinearLayoutManager(requireActivity()));

        feed_recycler_view.setAdapter(feed_recycler_adapter);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(requireActivity(),DividerItemDecoration.VERTICAL);
        feed_recycler_view.addItemDecoration(dividerItemDecoration);

       /* Button button=view.findViewById(R.id.other_profile_from_feed);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), other_profile_activity.class);
                startActivity(intent);
            }
        });*/
    }
}
