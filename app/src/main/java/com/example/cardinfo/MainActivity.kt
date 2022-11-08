package com.example.cardinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {

    private lateinit var cardNumber: EditText
    private lateinit var expMonth: EditText
    private lateinit var expYear: EditText
    private lateinit var code: EditText
    private lateinit var finish: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()



        cardNumber = findViewById(R.id.cardnumber)
        expMonth = findViewById(R.id.month)
        expYear = findViewById(R.id.year)
        finish = findViewById(R.id.finish)
        code = findViewById(R.id.cvv)


        finish.setOnClickListener {

            if(cardNumber.length() != 16){

                cardNumber.error = "შეიყვანეთ სწორი ბარათის ნომერი"
                return@setOnClickListener
            }

           if(expMonth.text.toString().toInt() > 12 || expMonth.text.toString().toInt() < 1){

                expMonth.error= "შეიყვანეთ სწორი თვე"
                return@setOnClickListener
            }
           if(expYear.text.toString().toInt() >100 || expYear.text.toString().toInt() < 22) {

               expYear.error = "შეიყვანეთ სწორი წელი"
               return@setOnClickListener
           }

            if(code.length() != 3){

                code.error = "შეიყვანეთ სწორი CVC/CVV კოდი"
                return@setOnClickListener
            }


         Toast.makeText(this, "გადახდა წარმატებით განხორციელდა", Toast.LENGTH_SHORT).show()




        }


    }
}