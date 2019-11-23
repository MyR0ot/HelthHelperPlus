package com.example.helthhelperplus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()!!.hide();
        setContentView(R.layout.activity_recycler)

        l_click.setOnClickListener{
            Intent(this@RecyclerActivity, UserActivity::class.java).also {
                it.putExtra("login", "empty login")
                startActivity(it)
            }
        }
    }




}
