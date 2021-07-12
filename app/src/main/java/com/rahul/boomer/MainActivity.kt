package com.rahul.boomer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val capture=findViewById<Button>(R.id.capture)
        val save=findViewById<Button>(R.id.save)
        val detect=findViewById<Button>(R.id.detect)
        val gallery=findViewById<Button>(R.id.gallery)
        capture.isEnabled=false
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),111)
        }
        else
            capture.isEnabled=true

        fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if (requestCode==111 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                capture.isEnabled=true
            }
        }

        fun detectText(){

        }



    }
}