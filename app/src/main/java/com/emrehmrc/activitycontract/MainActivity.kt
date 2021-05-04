package com.emrehmrc.activitycontract

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.emrehmrc.activitycontract.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGo.setOnClickListener {
            customContract.launch(User("Hamurcu", 26))
        }
        binding.btnPickImage.setOnClickListener {
            pickImage.launch("image/*")
        }
        binding.btnMultiPerm.setOnClickListener {
            askMultiplePermissions.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA))
        }
    }

    private val customContract = registerForActivityResult(SimpleContract()) { data ->
        binding.textView.text = data
    }
    private val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        binding.textView.text = granted.toString()
    }
    private val askMultiplePermissions =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
                for (entry in map.entries) {
                    Toast.makeText(this, "${entry.key} = ${entry.value}", Toast.LENGTH_SHORT).show()
                }
            }
    private val pickImage =
            registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
                binding.textView.text = uri?.toString()
            }
}