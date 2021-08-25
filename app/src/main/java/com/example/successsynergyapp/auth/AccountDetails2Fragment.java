package com.example.successsynergyapp.auth;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.databinding.FragmentAccountDetails2Binding;
import com.example.successsynergyapp.model.ModelServiceProvider;
import com.example.successsynergyapp.model.ModelUser;
import com.example.successsynergyapp.utils.RealPathUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class AccountDetails2Fragment extends Fragment {
    FragmentAccountDetails2Binding binding;
    ModelServiceProvider serviceProviderModel;
    ModelUser userModel;
    String forWhat;
    Uri ImageUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account_details2, container, false);
        forWhat = getArguments().getString("for");
        if (forWhat.equals("ServiceProvider")){
            serviceProviderModel = (ModelServiceProvider) getArguments().getSerializable("user");
            userModel = new ModelUser();
            binding.btnNext2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validateUserInput();
                }
            });
        }
        else{
            binding.phoneNumber.setVisibility(View.GONE);
            userModel = (ModelUser) getArguments().getSerializable("user");
            serviceProviderModel = new ModelServiceProvider();
            binding.btnNext2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validateUserInputForUser();
                }
            });
        }

        binding.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set up gallery picker
                takePictureFromGallery();
            }
        });
        return binding.getRoot();
    }

    private void validateUserInput(){
        if (binding.phoneNumber.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "please input your phone number", Toast.LENGTH_SHORT).show();
        }
        else if (ImageUri == null){
            Toast.makeText(getActivity(), "please select an image", Toast.LENGTH_SHORT).show();
        }
        else{
            setUserDetails();
            ((EditProfileActivity) getActivity()).loadTocFragment(userModel, serviceProviderModel, ImageUri, forWhat);
        }
    }

    private void validateUserInputForUser(){
        if (ImageUri == null){
            Toast.makeText(getActivity(), "please select an image", Toast.LENGTH_SHORT).show();
        }
        else{
            setRealUserDetails();
            ((EditProfileActivity) getActivity()).loadTocFragment(userModel, serviceProviderModel, ImageUri, forWhat);
        }
    }

    private void setUserDetails(){
        serviceProviderModel.setPhone_number(binding.phoneNumber.getText().toString());
        serviceProviderModel.setCor_profile(RealPathUtils.getRealPathFromURI_API19(getActivity(), ImageUri));
        //user.setAddress(binding.);
    }

    private void setRealUserDetails(){
        userModel.setProfile_pic(RealPathUtils.getRealPathFromURI_API19(getActivity(), ImageUri));
        //user.setAddress(binding.);
    }

    private void takePictureFromGallery() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK);
        pickPhoto.setType("image/*");
        startActivityForResult(Intent.createChooser(pickPhoto, "Select Picture"), 1);
    }

    private void takePictureFromCamera() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePicture.setType("image/*");
        if (takePicture.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePicture, 2);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    try {
                        ImageUri = data.getData();
                        final InputStream imageStream = getActivity().getContentResolver().openInputStream(ImageUri);
                        final Bitmap image = BitmapFactory.decodeStream(imageStream);
                        binding.ivProfile.setImageBitmap(image);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    //Bitmap photo = (Bitmap) data.getExtras().get("data");
                }
            case 2:
                if (resultCode == RESULT_OK){
                }
        }
    }
}