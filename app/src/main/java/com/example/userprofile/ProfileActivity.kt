package com.example.userprofile

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_profile.*
import kotlinx.android.synthetic.main.activity_create_profile.profileImage
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }

    /**
     * In the initViews method the Profile object sent with the Intent
     * is retrieved using intent.getParcelableExtra with the PROFILE_EXTRA key.
     */
    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "This is your profile!"
        val profile = intent.getParcelableExtra<Profile>(PROFILE_EXTRA)

        //The name TextView is populated using the firstName and lastName from the profile
        // object which have been concatenated using a String with two placeholders from the Strings.xml resource file.
        if (profile != null) {
            tvName.text = getString(R.string.profileName, profile.firstName, profile.lastName)
            //The description is populated using the description from the profile object.
            tvDescription.text = profile.description
            //The ImageView has been set using the imageUri from the Profile object.
            if (profile.imageUri != null) profileImage.setImageURI(profile.imageUri)
        }
    }


    companion object {
        const val PROFILE_EXTRA = "PROFILE_EXTRA"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }



}

