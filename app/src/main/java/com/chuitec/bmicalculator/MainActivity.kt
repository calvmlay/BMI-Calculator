package com.chuitec.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var weight: EditText
    private lateinit var height: EditText
    private lateinit var button: Button
    private lateinit var BMI: TextView
    private lateinit var BMIMessage: TextView
    private lateinit var resultCard: CardView
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weight = findViewById<EditText>(R.id.etWeight)
        height = findViewById<EditText>(R.id.etHeight)
        button = findViewById<Button>(R.id.btnCalculate)
        BMI = findViewById<TextView>(R.id.tvBMI)
        BMIMessage = findViewById<TextView>(R.id.tvBMIMessage)
        resultCard = findViewById<CardView>(R.id.resultCard)
        resultText = findViewById<TextView>(R.id.tvResultHead)

        button.setOnClickListener {
            val userWeight = weight.text.toString().toDoubleOrNull()
            val userHeightCm = height.text.toString().toDoubleOrNull()

            if (userWeight != null && userHeightCm != null && userHeightCm > 0) {
                // Convert height from centimeters (cm) to meters (m)
                val userHeightM = userHeightCm / 100.0

                val bmi = userWeight / (userHeightM * userHeightM)
                BMI.text = "BMI : %.2f".format(bmi)

                // Provide a comment based on BMI value
                val comment = when {
                    bmi < 18.5 -> "Underweight"
                    bmi < 24.9 -> "Normal weight"
                    bmi < 29.9 -> "Overweight"
                    else -> "Obese"
                }
                BMIMessage.text = "$comment"

                resultCard.visibility = View.VISIBLE
                resultText.visibility = View.VISIBLE

            } else {

                // Handle invalid input
                BMI.text = "BMI : N/A"
                BMIMessage.text = "Invalid input"
                resultCard.visibility = View.VISIBLE
                resultText.visibility = View.VISIBLE
            }
        }



    }
}