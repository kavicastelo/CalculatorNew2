package com.example.calculatornew2.ui.slideshow;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatornew2.MainActivity;
import com.example.calculatornew2.R;
import com.example.calculatornew2.databinding.FragmentSlideshowBinding;
import com.example.calculatornew2.ui.gallery.GalleryFragment;
import com.example.calculatornew2.ui.home.HomeFragment;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.radiobtnlight.isChecked())
                {
                    Toast.makeText(getView().getContext(), "Light Theme applied", Toast.LENGTH_SHORT).show();
                    Fragment mFragment = new HomeFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.themeLayout, mFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    binding.textView20.setVisibility(View.GONE);
                    binding.textSlideshow.setVisibility(View.GONE);
                    binding.textView21.setVisibility(View.GONE);
                    binding.btnapply.setVisibility(View.GONE);
                    binding.btncancel.setVisibility(View.GONE);
                    binding.themegrp.setVisibility(View.GONE);
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    //binding.radiobtnlight.setChecked(true);
                }
                else if(binding.radiobtndark.isChecked())
                {
                    Toast.makeText(getView().getContext(), "Dark Theme applied", Toast.LENGTH_SHORT).show();
                    Fragment mFragment = new HomeFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.themeLayout, mFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    binding.textView20.setVisibility(View.GONE);
                    binding.textSlideshow.setVisibility(View.GONE);
                    binding.textView21.setVisibility(View.GONE);
                    binding.btnapply.setVisibility(View.GONE);
                    binding.btncancel.setVisibility(View.GONE);
                    binding.themegrp.setVisibility(View.GONE);
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    //binding.radiobtndark.setChecked(true);
                }
            }
        });
        binding.radiobtnlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radiobtnlight.setChecked(true);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
        binding.radiobtndark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radiobtndark.setChecked(true);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        });
        binding.btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                Intent i = new Intent(SlideshowFragment.this.getActivity(), MainActivity.class);
                startActivity(i);
            }
        });

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}