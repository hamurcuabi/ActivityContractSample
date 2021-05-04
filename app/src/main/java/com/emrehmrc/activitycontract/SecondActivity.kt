package com.emrehmrc.activitycontract

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emrehmrc.activitycontract.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getParcelableExtra<User>(KEY_USER_OBJECT)
        binding.apply {
            txtUser.text = user.toString()
            btnSetResult.setOnClickListener { setResult() }
        }
    }

    private fun setResult() {
        val intent = Intent()
        intent.putExtra(KEY_RESULT, "Başarılııı!")
        setResult(RESULT_OK, intent)
        finish()
    }

}
