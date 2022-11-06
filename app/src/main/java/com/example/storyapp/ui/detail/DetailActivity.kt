package com.example.storyapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.storyapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var binding: ActivityDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.apply {
            title = "Detail Story"
            show()
        }

        showDataInView(binding)
    }

    private fun showDataInView(binding: ActivityDetailBinding?) {
        binding?.apply {
            Glide.with(this@DetailActivity)
                .load(intent.getStringExtra("photo"))
                .into(photoDetailIv)
            titleDetailTv.text = intent.getStringExtra("title")
            descDetailTv.text = intent.getStringExtra("desc")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}