package com.narnia.dt.convertidortemperatura


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var conversion : Int = 0
    private var value : String = ""
    private  var result : Double = 0.0
    private lateinit var  total : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinnerTemp)
        total = findViewById(R.id.textVResultado)
        val temp = findViewById<EditText>(R.id.editTextNTemp)
        val buttonConvertir = findViewById<Button>(R.id.buttonConvertir)


        val options = resources.getStringArray(R.array.convert_options)

        if (spinner != null ){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?, position: Int, id: Long){
                    conversion = position
                    Toast.makeText(this@MainActivity, "Opcion Seleccionada " + position , Toast.LENGTH_SHORT).show()


                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

        }



        buttonConvertir.setOnClickListener{
            value = temp.text.toString()
            converter(conversion)

        }

    }

    fun converter(convert: Int){

        when(convert) {
            0 ->{
                Toast.makeText(this, "Opcion no Valida", Toast.LENGTH_SHORT).show()
            }
            1 ->{
                Toast.makeText(this, "°C to °F", Toast.LENGTH_SHORT).show()

                //grados C x 9/5 + 32
                result = ((value.toDouble()* 9/5 + 32))
                total.text = result.toString()


            }
            2 ->{
                Toast.makeText(this, "°C to °K", Toast.LENGTH_SHORT).show()
                //
                result = ((value.toDouble()+ 273.15))
                total.text = result.toString()

            }
            3 ->{
                Toast.makeText(this, "°F to °C", Toast.LENGTH_SHORT).show()
                //
                result = ((value.toDouble()- 32) * 5/9)
                total.text = result.toString()

            }
            4 ->{
                Toast.makeText(this, "°F to °K", Toast.LENGTH_SHORT).show()
                //
                result = ((value.toDouble()- 32)* 5/9 + 273.15)
                total.text = result.toString()
            }
            5 ->{
                Toast.makeText(this, "°K to °C", Toast.LENGTH_SHORT).show()
                //
                result = ((value.toDouble() - 273.15))
                total.text = result.toString()
            }
            6 ->{
                Toast.makeText(this, "°K to °K", Toast.LENGTH_SHORT).show()
                //
                result = ((value.toDouble()- 273.15)* 9/5 + 32)
                total.text = result.toString()

            }

        }
        //TODO Add when statement to process conversions.
    }
}