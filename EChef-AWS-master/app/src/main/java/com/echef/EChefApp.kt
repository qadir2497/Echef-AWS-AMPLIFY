package com.echef

import android.content.Context
import android.util.Log
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger


class EChefApp : MultiDexApplication() {


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(AndroidLogAdapter())
        }

        initAmplifyAuth()
    }

    private fun initAmplifyAuth() {
        try {
            // Add this line, to include the Auth plugin.
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.configure(applicationContext)
            Logger.e("MyAmplifyApp Initialized Amplify")
            Amplify.Auth.fetchAuthSession(
                {
                    Logger.e(" Success full$it")
                    Logger.e("Signed in?: "+it.isSignedIn)

                }
                ,
                {
                        Logger.e("Some error"+it.localizedMessage)
                }
            )
        } catch (error: AmplifyException) {
            Logger.e("MyAmplifyApp Could not initialize Amplify", error)
        }
    }
}