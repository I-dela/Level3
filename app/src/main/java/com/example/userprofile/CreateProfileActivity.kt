package com.example.userprofile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_profile.*

const val GALLERY_REQUEST_CODE = 100
private var profileImageUri: Uri? = null


class CreateProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)
        initViews()
    }


    private fun initViews() {
        buttonGallery.setOnClickListener { onGalleryClick() }
        buttonConfirm.setOnClickListener{onConfirmClick()}
    }

    private fun onGalleryClick() {
        // Create an Intent with action as ACTION_PICK
        val galleryIntent = Intent(Intent.ACTION_PICK)

        // Sets the type as image/*. This ensures only components of type image are selected
        galleryIntent.type = "image/*"

        // Start the activity using the gallery intent
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE)
    }


    private fun onConfirmClick() {

        //First a Profile object is created using the input the user has given.
        val profile = Profile(
            profileName.text.toString(),
            profileLastName.text.toString(),
            profileDescription.text.toString(),
            profileImageUri
        )

        //An Intent is created with the ProfileActivity class to indicate that we want to start this Activity.
        val profileActivityIntent = Intent(this, ProfileActivity::class.java)

      //  The Profile object is put as an extra with using a constant key.
        profileActivityIntent.putExtra(ProfileActivity.PROFILE_EXTRA, profile)

        //The activity is started using startActivity with the intent.
        startActivity(profileActivityIntent)
    }


    //Check if the result code equals Activity.RESULT_OK and check if the requestCode equals GALLERY_REQUEST_CODE.

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        //If the result and request code matches then you can get the uri from the selected image using data?.data.
        if (resultCode == Activity.RESULT_OK) {

            when (requestCode) {
                //   Create a class variable called profileImageUri and set it to the value from data?.data. Also set the imageView to the profileImageUri.
                GALLERY_REQUEST_CODE -> {
                    profileImageUri = data?.data
                    profileImage.setImageURI(profileImageUri)
                }
            }
        }

    }

}