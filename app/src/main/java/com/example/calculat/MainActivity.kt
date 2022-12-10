package com.example.calculat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        binding.btnPlus.setOnClickListener{setTextFields("+")}
//        binding.btnMinus.setOnClickListener{setTextFields("-")}
//        binding.btnMulti.setOnClickListener{setTextFields("*")}
//        binding.btnDiv.setOnClickListener{setTextFields("/")}

        val btnPlus=findViewById<TextView>(R.id.btn_plus)
        btnPlus.setOnClickListener{setTextFields("+")}
        val btnMinus=findViewById<TextView>(R.id.btn_minus)
        btnMinus.setOnClickListener{setTextFields("-")}
        val btnMulti=findViewById<TextView>(R.id.btn_multi)
        btnMulti.setOnClickListener{setTextFields("*")}
        val btnDiv=findViewById<TextView>(R.id.btn_div)
        btnDiv.setOnClickListener{setTextFields("/")}
        val mathNumbers=findViewById<EditText>(R.id.math_numbers)
        //mathNumbers.setOnClickListener{setTextFields("/")}
        val btnBack=findViewById<TextView>(R.id.btn_back)
        val math=findViewById<TextView>(R.id.math_operation)
        val btnEquals = findViewById<TextView>(R.id.btn_equals)
        mathNumbers.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                // if the event is a key down event on the enter button
                if (event.action == KeyEvent.ACTION_DOWN &&
                    keyCode == KeyEvent.KEYCODE_ENTER
                ) {
                    setTextFields1()
                    //hide cursor from edit text
                    mathNumbers.isCursorVisible = false
                    return true
                }
                return false
            }
        })

        btnBack.setOnClickListener {
//            val str = binding.mathOperation.text.toString()
//            if(str.isNotEmpty()){
//                binding.mathOperation.text = str.substring(0,str.length-1)
//            }
            val str = math.text.toString()
            if(str.isNotEmpty()){
                math.text = str.substring(0,str.length-1)
            }
        }
        btnEquals.setOnClickListener{
            try {
                val ex = ExpressionBuilder(math.text.toString()).build()
                val result = ex.evaluate()
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", result)
                startActivity(intent)
            }catch (e:Exception) {
                Log.d("Error","message: ${e.message}")
            }
        }
    }
    fun setTextFields(str: String){
        val math=findViewById<TextView>(R.id.math_operation)
//        val mathNumbers=findViewById<EditText>(R.id.math_numbers)
//        if( mathNumbers.text.isNotEmpty())
//        {
//            math.append(mathNumbers.text)
//            mathNumbers.setText("")
//        }

        math.append(str)
        //binding.mathOperation.append(str)
    }
    fun setTextFields1(){
        val math=findViewById<TextView>(R.id.math_operation)
        val mathNumbers=findViewById<EditText>(R.id.math_numbers)
        if( mathNumbers.text.isNotEmpty())
        {
            math.append(mathNumbers.text)
            mathNumbers.setText("")
        }}
}