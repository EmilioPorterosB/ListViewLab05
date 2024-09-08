package com.example.listviewlab05

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var arrOS = arrayOf("Android", "iOS", "Firefox OS", "Blackberry OS", "Windows Phone", "Amazon World", "Symbian OS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lsvOS: ListView = findViewById(R.id.lsvSO)
        val adaptador: Any? = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1,arrOS)

        lsvOS.adapter = adaptador as ListAdapter?

        lsvOS.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText( this, "Estamos en la pasición: $position", Toast.LENGTH_LONG).show()
        }

    }
}