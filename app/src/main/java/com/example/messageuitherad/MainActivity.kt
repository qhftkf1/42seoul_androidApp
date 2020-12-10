package com.example.messageuitherad

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.w3c.dom.Text
import java.util.jar.Manifest

class PermissionCheck(val permissionActivity: Activity, val requirePermissions: Array<String>){
    private val permissionRequestCode = 100

    public fun permissionCheck(){
        var failRequestPermissionList = ArrayList<String>()

        for(permission in requirePermissions){
            if(ContextCompat.checkSelfPermission(permissionActivity.applicationContext, permission) != PackageManager.PERMISSION_GRANTED){
                failRequestPermissionList.add(permission)
            }
        }
        if(failRequestPermissionList.isNotEmpty()){
            val array = arrayOfNulls<String>(failRequestPermissionList.size)
            ActivityCompat.requestPermissions(permissionActivity, failRequestPermissionList.toArray(array), permissionRequestCode)
        }
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
//        var v = MyView(this)
//        setContentView(v)
        var requirePermissions = arrayOf(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val permissionCheck = PermissionCheck(this, requirePermissions)
        permissionCheck.permissionCheck()

        playButton.setOnClickListener {
            startActivity(Intent(this, List::class.java))
        }
    }
}