package com.example.helthhelperplus

import android.content.Intent
import android.nfc.NfcAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_doctor.*
import org.jetbrains.anko.toast

class DoctorActivity : AppCompatActivity() {

    private var mNfcAdapter: NfcAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()!!.hide();
        setContentView(R.layout.activity_doctor)

        mNfcAdapter = NfcAdapter.getDefaultAdapter(this)


        b_all_users.setOnClickListener {
            Intent(this@DoctorActivity, RecyclerActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        turn()

    }

    private fun turn(): Unit {
        layout_info.visibility = View.VISIBLE
        b_all_users.visibility = View.VISIBLE
        layout_load.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        mNfcAdapter?.let {
            NFCUtil.enableNFCInForeground(it, this, javaClass)
        }
    }

    override fun onPause() {
        super.onPause()
        mNfcAdapter?.let {
            NFCUtil.disableNFCInForeground(it, this)
        }
    }

    private fun loadInfo(info: Info): Unit {



    }



}
