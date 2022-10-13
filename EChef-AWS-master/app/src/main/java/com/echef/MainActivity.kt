package com.echef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.UserStateDetails
import com.orhanobut.logger.Logger
import com.amazonaws.mobile.client.AWSMobileClient.getInstance
import com.echef.base.BaseActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}