package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import com.example.kotlinseccion4.R

class CLickEventsActivity : AppCompatActivity(), View.OnLongClickListener {

    //Configuracion toolbar
    private lateinit var toolbar: Toolbar

    // 1)Click in XML
    // 2)Click in line
    // 3)Click by IDS en when

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c_lick_events)

        //Configuracion toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        ClickInLine()

        //Para que se pueda utilizar los botones multi se deben de declarar pasandole el metodo
        val btn1 = findViewById<Button>(R.id.buttonMulti1)
        val btn2 = findViewById<Button>(R.id.buttonMulti2)
        val btn3 = findViewById<Button>(R.id.buttonMulti3)
        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)

    }

    //Logica para el boton Click By XML
    //Regla obligatoria para clicks en XML.
    //1.-El metodo tiene que ser publico (por defecto es publico)
    //2.-Los nombres tienen que coincidir con el del XML
    //3.-Recibe un solo parametro y es un view
    //De esta manera si vamos al XML podremos importar el evento onClick directamente.
    fun XMLClick(view: View){
        Toast.makeText(this, "Click by XML", Toast.LENGTH_SHORT).show()
    }

    //Logica para el boton Click in Line
    private fun ClickInLine(){
        val btnClickInLine = findViewById<Button>(R.id.buttonClickInLine)
        btnClickInLine.setOnClickListener { Toast.makeText(this, "Click in Line", Toast.LENGTH_SHORT).show() }
    }

    //Logica para los botones multi con LongClick utilizando un when
    override fun onLongClick(view: View): Boolean {
        when(view.id){
            R.id.buttonMulti1 -> Toast.makeText(this, "Click in multi1", Toast.LENGTH_SHORT).show()
            R.id.buttonMulti2 -> Toast.makeText(this, "Click in multi2", Toast.LENGTH_SHORT).show()
            R.id.buttonMulti3 -> Toast.makeText(this, "Click in multi3", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
