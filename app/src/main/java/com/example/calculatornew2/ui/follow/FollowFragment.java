package com.example.calculatornew2.ui.follow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatornew2.databinding.FragmentFollowBinding;
import com.example.calculatornew2.databinding.FragmentSlideshowBinding;
import com.example.calculatornew2.ui.slideshow.SlideshowViewModel;

public class FollowFragment extends Fragment {

    private FragmentFollowBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FollowViewModel followviewmodel =
                new ViewModelProvider(this).get(FollowViewModel.class);

        binding = FragmentFollowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri git = Uri.parse("https://github.com/kavicastelo");
                Intent github = new Intent(Intent.ACTION_VIEW,git);
                startActivity(github);
            }
        });
        binding.btninsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FollowFragment.this.getActivity(), "not set yet", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btntwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FollowFragment.this.getActivity(), "not set yet", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnlinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FollowFragment.this.getActivity(), "not set yet", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FollowFragment.this.getActivity(), "not set yet", Toast.LENGTH_SHORT).show();
            }
        });

        final TextView textView = binding.textFollow;
        followviewmodel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
