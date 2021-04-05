package com.antorpo.colormyviews
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Primer funcion en llamarse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun makeColored(view: View) {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)

        // Sintaxis equivalente al Switch/Case de Java pero con una sintaxis mas amigable
        // y con mas flexibilidad para poder obtener los casos.
        when(view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)
            R.id.red_button -> boxOneText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> boxTwoText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxThreeText.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY) // Equivalente al default en Java
        }
    }

    private fun makeDrawable(view: View){
        when(view.id){
            R.id.box_one_text -> view.setBackgroundResource(R.drawable.aguila_image)
            R.id.box_two_text -> view.setBackgroundResource(R.drawable.buldog_image)
            R.id.box_three_text -> view.setBackgroundResource(R.drawable.elefante_image)
            R.id.box_four_text -> view.setBackgroundResource(R.drawable.pirana_image)
            R.id.box_five_text -> view.setBackgroundResource(R.drawable.tigre_image)
            else -> view.setBackgroundColor(Color.LTGRAY) // Equivalente al default en Java
        }
    }

    private fun setListeners(){

        // Recuperamos una referencia a los Views identificandolos por su Id
        // Variables de tipo TextView y View
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)
        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)


        // Creamos una lista de Views para asignar de manera mas eficiente los listeners
        // como los TextView heredan de View podemos crear una lista de tipo <View>
        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout,
                redButton, greenButton, yellowButton)

        // Agregamos los oyentes que esperan que el evento se produzca para realizar las acciones
        // cada view va a tener un click listener que va a invocar la funcion makeColored la
        // cual dependiendo del id del elemento presionado va a cambiar su color
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }

        }


}