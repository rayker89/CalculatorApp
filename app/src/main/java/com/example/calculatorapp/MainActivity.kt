package com.example.calculatorapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view: View) {
        val mp = MediaPlayer.create(getApplicationContext(), R.raw.ac)
        mp.start()
        if(isNewOp) {
            etShowNumber.setText("")
        }
        isNewOp = false

        val buSelected = view as Button
        var Number:String = etShowNumber.text.toString()

        val myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        buSelected.startAnimation(myAnim)

        when(buSelected.id) {
            bu1.id -> {
                Number += "1"
            }

            bu2.id -> {
                Number += "2"
            }

            bu3.id -> {
                Number += "3"
            }

            bu4.id -> {
                Number += "4"
            }

            bu5.id -> {
                Number += "5"
            }

            bu6.id -> {
                Number += "6"
            }

            bu7.id -> {
                Number += "7"
            }

            bu8.id -> {
                Number += "8"
            }

            bu9.id -> {
                Number += "9"
            }

            bu0.id -> {
                Number += "0"
            }

            buDot.id -> {
                Number += "."
            }

            buPlusMinus.id -> {
                Number = "-" + Number
            }
        }

        etShowNumber.setText(Number)
    }

    var oldNumber = ""
    var isNewOp = true
    var op = "*"

    fun OperationEvent(view: View) {
        val mp = MediaPlayer.create(getApplicationContext(), R.raw.numbers)
        mp.start()
        val buSelected = view as Button

        val myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        buSelected.startAnimation(myAnim)

        when(buSelected.id) {
            buAdd.id -> {
                op = "+"

            }

            buDiv.id -> {
                op = "/"
            }

            buMul.id -> {
                op = "*"
            }

            buSub.id -> {
                op = "-"
            }

        }
        oldNumber = etShowNumber.text.toString()
        isNewOp = true

    }

    fun EqualEvent(view: View) {
        val mp = MediaPlayer.create(getApplicationContext(), R.raw.equal)
        mp.start()
        val buSelected = view as Button
        val newNumber = etShowNumber.text.toString()
        var finalNumber:Double? = null

        val myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        buSelected.startAnimation(myAnim)

        when(op) {
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
        }

        etShowNumber.setText(finalNumber.toString())
        isNewOp = true


    }

    fun buPercent(view: View) {
        val mp = MediaPlayer.create(getApplicationContext(), R.raw.numbers)
        mp.start()

        val buSelected = view as Button

        val myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        buSelected.startAnimation(myAnim)

        val oldNumber = etShowNumber.text.toString().toDouble()/100

        etShowNumber.setText(oldNumber.toString())
        isNewOp = true



    }

    fun buAC(view: View) {
        val mp = MediaPlayer.create(getApplicationContext(), R.raw.operation)
        mp.start()

        val buSelected = view as Button

        val myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        buSelected.startAnimation(myAnim)

        etShowNumber.setText("0")
        isNewOp = true
    }
}
