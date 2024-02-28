package com.jes.wikiworld

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.jes.wikiworld.databinding.ActivityCreditBinding

class CreditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreditBinding
    private val ARG_USER_NAME = "userName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra(ARG_USER_NAME)

        if (savedInstanceState == null) {
            val fragment = CreditFragment.newInstance(userName ?: "")
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_credit, fragment)
                .commit()
        }
    }


        fun newInstance(userName: String): CreditFragment {
            val fragment = CreditFragment()
            val args = Bundle().apply {
                putString(ARG_USER_NAME, userName)
            }
            fragment.arguments = args
            return fragment
        }

    }
