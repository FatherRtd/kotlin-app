package com.example.newapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button
    private lateinit var resultText: TextView
    private lateinit var operationSign: TextView
    private lateinit var equalSign: TextView
    private lateinit var closeButton: Button

    private var operation: String = ""
    private var result: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        divideButton = findViewById(R.id.divideButton)
        resultText = findViewById(R.id.resultText)
        operationSign = findViewById(R.id.operationSign)
        equalSign = findViewById(R.id.equalSign)
        closeButton = findViewById(R.id.closeButton)

        addButton.setOnClickListener { calculate("+") }
        subtractButton.setOnClickListener { calculate("-") }
        multiplyButton.setOnClickListener { calculate("*") }
        divideButton.setOnClickListener { calculate("/") }

        closeButton.setOnClickListener { finish() }

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                clearResult()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        number1.addTextChangedListener(textWatcher)
        number2.addTextChangedListener(textWatcher)
    }

    private fun calculate(op: String) {
        val num1 = number1.text.toString().toDoubleOrNull()
        val num2 = number2.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            result = when (op) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else null
                else -> null
            }
            operation = op
            displayResult()
        }
    }

    private fun displayResult() {
        result?.let {
            operationSign.text = operation
            equalSign.text = "="
            resultText.text = it.toString()
        }
    }

    private fun clearResult() {
        operationSign.text = ""
        equalSign.text = ""
        resultText.text = ""
    }
}