package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var edittext1 = findViewById<EditText>(R.id.num1)
        var edittext2 = findViewById<EditText>(R.id.num2)
        var btnadd = findViewById<Button>(R.id.btnAdd)
        var btnsub = findViewById<Button>(R.id.btnSub)
        var btnmulti = findViewById<Button>(R.id.btnMultiply)
        var btndivide = findViewById<Button>(R.id.btnDivide)
        var result = findViewById<TextView>(R.id.result)
        var exit = findViewById<Button>(R.id.btnExit)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnadd.setOnClickListener {
            val number1 = edittext1.text.toString().toFloatOrNull()
            val number2 = edittext2.text.toString().toFloatOrNull()
            if (number1 != null && number2 != null) {
                result.text = (number1 + number2).toString()
            } else {
                result.text = "Invalid Input"
            }
        }

        btnsub.setOnClickListener {
            val number1 = edittext1.text.toString().toIntOrNull()
            val number2 = edittext2.text.toString().toIntOrNull()
            if (number1 != null && number2 != null) {
                result.text = (number1 - number2).toString()
            } else {
                result.text = "Invalid Input"
            }
        }

        btnmulti.setOnClickListener {
            val number1 = edittext1.text.toString().toIntOrNull()
            val number2 = edittext2.text.toString().toIntOrNull()
            if (number1 != null && number2 != null) {
                result.text = (number1 * number2).toString()
            } else {
                result.text = "Invalid Input"
            }
        }

        btndivide.setOnClickListener {
            val number1 = edittext1.text.toString().toFloatOrNull()
            val number2 = edittext2.text.toString().toFloatOrNull()
            if (number1 != null && number2 != null) {
                if (number2 != 0f){
                    result.text = (number1 / number2).toString()
                } else {
                    result.text = "Error Not Divisible By Zero"
                }
            } else {
                result.text = "Invalid Input"
            }
        }

        exit.setOnClickListener {
            finish()
        }
    }
}