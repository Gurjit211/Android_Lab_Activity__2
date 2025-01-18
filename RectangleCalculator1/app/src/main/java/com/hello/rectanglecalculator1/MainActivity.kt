package com.hello.rectanglecalculator1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lengthInput: EditText = findViewById(R.id.lengthInput)
        val widthInput: EditText = findViewById(R.id.widthInput)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resetButton: Button = findViewById(R.id.resetButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val length = lengthInput.text.toString().toDoubleOrNull()
            val width = widthInput.text.toString().toDoubleOrNull()

            if (validateInput(length, width)) {
                val results = calculateResultsIteratively(length!!, width!!)
                resultTextView.text = results
            } else {
                resultTextView.text = "Invalid input. Please enter positive numbers for length and width."
            }
        }

        resetButton.setOnClickListener {
            // Clear inputs and reset result
            lengthInput.text.clear()
            widthInput.text.clear()
            resultTextView.text = "Results will be displayed here."
        }
    }

    private fun validateInput(length: Double?, width: Double?): Boolean {
        return length != null && width != null && length > 0 && width > 0
    }

    private fun calculatePerimeter(length: Double, width: Double): Double {
        return 2 * (length + width)
    }

    private fun calculateArea(length: Double, width: Double): Double {
        return length * width
    }

    private fun calculateResultsIteratively(length: Double, width: Double): String {
        var results = ""
        var count = 1

        while (count <= 3) {
            val perimeter = calculatePerimeter(length, width)
            val area = calculateArea(length, width)
            results += "Iteration $count:\nPerimeter = $perimeter\nArea = $area\n\n"
            count++
        }

        return results
    }
}
