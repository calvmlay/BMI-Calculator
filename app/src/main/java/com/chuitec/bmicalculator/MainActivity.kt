package com.chuitec.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var weight: EditText
    private lateinit var height: EditText
    private lateinit var button: Button
    private lateinit var BMI: TextView
    private lateinit var BMIMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weight = findViewById<EditText>(R.id.etWeight)
        height = findViewById<EditText>(R.id.etHeight)
        button = findViewById<Button>(R.id.btnCalculate)
        BMI = findViewById<TextView>(R.id.tvBMI)
        BMIMessage = findViewById<TextView>(R.id.tvBMIMessage)

        button.setOnClickListener {
            val userWeight = weight.text.toString().toDoubleOrNull()
            val userHeight = height.text.toString().toDoubleOrNull()

            if (userWeight != null && userHeight != null && userHeight > 0) {
                val bmi = userWeight / (userHeight * userHeight)
                BMI.text = "BMI Value: %.2f".format(bmi)

                // Provide a comment based on BMI value
                val comment = when {
                    bmi < 18.5 -> "Underweight"
                    bmi < 24.9 -> "Normal weight"
                    bmi < 29.9 -> "Overweight"
                    else -> "Obese"
                }
                BMIMessage.text = "Comment: $comment"
            } else {
                // Handle invalid input
                BMI.text = "BMI Value: N/A"
                BMIMessage.text = "Comment: Invalid input"
            }
        }



    }
}