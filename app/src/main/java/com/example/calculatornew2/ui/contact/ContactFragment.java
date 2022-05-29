package com.example.calculatornew2.ui.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatornew2.databinding.FragmentContactBinding;

public class ContactFragment extends Fragment {

    private FragmentContactBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ContactViewModel contactviewmodel =
                new ViewModelProvider(this).get(ContactViewModel.class);

        binding = FragmentContactBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri git = Uri.parse("https://github.com/kavicastelo");
                Intent github = new Intent(Intent.ACTION_VIEW,git);
                startActivity(github);
            }
        });
        binding.imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"kkavindu221@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Calculator V1.0");
                startActivity(Intent.createChooser(i,"Choose a application"));
            }
        });
        binding.imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ContactFragment.this.getActivity(), "not web page found", Toast.LENGTH_SHORT).show();
            }
        });
        binding.imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri whatsap = Uri.parse("smsto:"+"+94773431660");
                Intent i = new Intent(Intent.ACTION_SENDTO,whatsap);
                i.setPackage("com.whatsapp");
                i.putExtra(Intent.EXTRA_TEXT,"About Calculator V1.0\n");
                startActivity(Intent.createChooser(i, ""));
            }
        });
        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:0773431660");
                Intent i = new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent msg = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+ "0773431660"));
                msg.putExtra("sms_body","About Calculater V1.0\n");
                startActivity(msg);
            }
        });

        final TextView textView = binding.textContact;
        contactviewmodel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}
