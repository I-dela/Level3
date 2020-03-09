package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_activity_add.*

class AddPortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title  = "Create a Portal"
        addPortalBtn.setOnClickListener{
            addPortal()
        }
    }

    private fun addPortal(){
        if(tvPortalTitle.text.toString().isBlank()){
            return Snackbar.make(tvPortalTitle,"reminder cannot be empty!", Snackbar.LENGTH_LONG).show()

        }

        val portal = Portal(tvPortalTitle.text.toString(), tvPortalUrl.text.toString())

        val resultIntent = Intent()
        resultIntent.putExtra(EXTRA_PORTAL,portal)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()

        tvPortalTitle.text?.clear()
        tvPortalUrl.text?.clear()


    }

    companion object{
        val EXTRA_PORTAL = "EXTRA_PORTAL"

    }

}
