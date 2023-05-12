package com.example.cardview_sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper
    lateinit var inputemail: EditText
    lateinit var inputpass: EditText
    lateinit var inputusername: EditText
    lateinit var inputfullname: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputemail = findViewById(R.id.input_email)
        inputpass = findViewById(R.id.input_password)
        inputusername = findViewById(R.id.input_username)
        inputfullname = findViewById(R.id.input_nama)
        userDBHelper = DBHelper(this)
    }

    fun addData(view: View) {
        val emailin = inputemail.text.toString()
        val passin = inputpass.text.toString()
        val usernamein = inputusername.text.toString()
        val fullnamein = inputfullname.text.toString()
        userDBHelper.insertData(emailin, passin, usernamein, fullnamein)
        inputemail.setText("")
        inputpass.setText("")
        inputusername.setText("")
        inputfullname.setText("")
    }

    fun showAll(view: View) {
        val pindah = Intent(this, RvDbActivity::class.java)
        this.startActivity(pindah)
    }
}
