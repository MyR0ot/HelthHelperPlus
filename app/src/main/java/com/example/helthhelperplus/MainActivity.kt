package com.example.helthhelperplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val doctors: Map<String, String> = mapOf(
        "admin" to "qwerty",
        "root" to "qwerty",
        "main" to "qwerty",
        "doctor" to "qwerty",
        "secret" to "qwerty"
    )

    private val users: Map<String, String> = mapOf(
        "user" to "qwerty",
        "user1" to "qwerty",
        "user2" to "qwerty",
        "user3" to "qwerty",
        "1" to "qwerty",
        "user4" to "qwerty",
        "user5" to "qwerty",
        "user6" to "qwerty"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        b_sign.setOnClickListener {

            val login = edit_login.text.toString()
            val pass = edit_pass.text.toString()
            if(passIsCorrected(login, pass)){
                if(isDoctor(login)){
                    Intent(this@MainActivity, DoctorActivity::class.java).also {
                        it.putExtra("login", login)
                        startActivity(it)
                    }
                }
                if(isUser(login)){
                    Intent(this@MainActivity, UserActivity::class.java).also {
                        it.putExtra("login", login)
                        startActivity(it)
                    }
                }
            }
        }

        b_register.setOnClickListener {
            this.register()
        }
    }

    private fun load(): Unit {

    }

    private fun openDetailedActivity(id: String): Unit {

        Intent(this@MainActivity, DoctorActivity::class.java).also {
            it.putExtra("id", id)
            startActivity(it)
        }
    }


    private fun isDoctor(login: String):Boolean {
        this.doctors.forEach{ if(it.key == login.toLowerCase()) return true}
        return false;
    }

    private fun isUser(login: String):Boolean {
        this.users.forEach{ if(it.key == login.toLowerCase()) return true}
        return false;
    }

    private fun passIsCorrected(login: String, pass: String): Boolean {
        return true; // :)
    }


    private fun register(): Unit {
        // TODO: регистрация пользователя
    }

}
