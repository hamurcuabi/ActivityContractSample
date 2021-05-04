package com.emrehmrc.activitycontract

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.activity.result.contract.ActivityResultContract
import kotlinx.android.parcel.Parcelize

//Create Custom Contract
const val KEY_USER_OBJECT = "KEY_USER_OBJECT"
const val KEY_RESULT = "RESULT"

@Parcelize
data class User(val name: String, val age: Int) : Parcelable

class SimpleContract : ActivityResultContract<User, String?>() {

    override fun createIntent(context: Context, input: User): Intent {
        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra(KEY_USER_OBJECT, input)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? = when {
        resultCode != Activity.RESULT_OK -> null
        else -> intent?.getStringExtra(KEY_RESULT)
    }
}

