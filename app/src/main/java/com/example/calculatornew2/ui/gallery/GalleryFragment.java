package com.example.calculatornew2.ui.gallery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatornew2.R;
import com.example.calculatornew2.database;
import com.example.calculatornew2.databinding.FragmentGalleryBinding;
import com.example.calculatornew2.login;
import com.google.android.material.snackbar.Snackbar;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        view = inflater.inflate(R.layout.fragment_gallery, container,false);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        database myDB = new database(getActivity());

        binding.btnregi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.txtuname.getText().toString().equals(""))
                {
                    Snackbar.make(view, "Username is Required Information", Snackbar.LENGTH_SHORT).show();
                }
                else if(binding.txtpwd.getText().toString().equals(""))
                {
                    Snackbar.make(view, "Password is Required Information", Snackbar.LENGTH_SHORT).show();
                }
                else if(binding.txtfname.getText().toString().equals(""))
                {
                    Snackbar.make(view, "First name is Required Information", Snackbar.LENGTH_SHORT).show();
                }
                else if(binding.txtlname.getText().toString().equals(""))
                {
                    Snackbar.make(view, "Last name is Required Information", Snackbar.LENGTH_SHORT).show();
                }
                else if(binding.txtemail.getText().toString().equals(""))
                {
                    Snackbar.make(view, "Email is Required Information", Snackbar.LENGTH_SHORT).show();
                }
                else if(binding.txtphone.getText().toString().equals(""))
                {
                    Snackbar.make(view, "Phone number is Required Information", Snackbar.LENGTH_SHORT).show();
                }
                else if(binding.txtdob.getText().toString().equals(""))
                {
                    Snackbar.make(view, "date of birth is Required Information", Snackbar.LENGTH_SHORT).show();
                }
                else
                {

                    boolean isAdded = myDB.AddMember(binding.txtfname.getText().toString(),binding.txtlname.getText().toString(),
                            binding.txtemail.getText().toString(), binding.txtphone.getText().toString(),
                            binding.txtdob.getText().toString(), binding.spinnergen.getSelectedItem().toString());

                    if(isAdded)
                    {
                        boolean isLoginAdded = myDB.addLoginDet(binding.txtuname.getText().toString(),binding.txtpwd.getText().toString());

                        if(isLoginAdded)
                        {
                            Toast.makeText(GalleryFragment.this.getActivity(), "Account Created..!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(GalleryFragment.this.getActivity(), "Account not Created..!", Toast.LENGTH_SHORT).show();
                        }

                        binding.txtlname.setText("");
                        binding.txtfname.setText("");
                        binding.txtemail.setText("");
                        binding.txtphone.setText("");
                        binding.txtdob.setText("");
                        binding.txtuname.setText("");
                        binding.txtpwd.setText("");
                    }
                    else
                    {
                        Snackbar.make(view, "details are not added..!!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }

            }
        });
        binding.btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtfname.setText(null);
                binding.txtlname.setText(null);
                binding.txtemail.setText(null);
                binding.txtphone.setText(null);
                binding.txtdob.setText(null);
                binding.txtuname.setText(null);
                binding.txtpwd.setText(null);
            }
        });
        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GalleryFragment.this.getActivity(), login.class);
                startActivity(i);
            }
        });
        binding.viewregipass.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(binding.txtpwd.getTransformationMethod().equals(PasswordTransformationMethod.getInstance()))
                {

                    //binding.viewregipass.setImageResource(Integer.parseInt(String.valueOf(view.getResources().getDrawable(R.drawable.ic_viewpass))));
                    binding.txtpwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    //binding.viewregipass.setImageResource(Integer.parseInt(String.valueOf(view.getResources().getDrawable(R.drawable.ic_hidepass))));
                    binding.txtpwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}