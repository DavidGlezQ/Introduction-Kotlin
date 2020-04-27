package activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinseccion4.R
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        btn_extra.setOnClickListener { goIntentExtra() }
        btn_flags.setOnClickListener { goIntentFlags() }
        btn_objects.setOnClickListener { goIntentObject() }
    }

    //El intentExtra nos permite pasar vaores de un activity a otro
    private fun goIntentExtra(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        //Estos son datos que se van a mandar al IntentExtraActivity, estos datos se pueden tener el mismo valor pero no se pueden llamar igual.
        intent.putExtra("name", "David")
        intent.putExtra("lastName", "Gonzalez")
        intent.putExtra("age", 21)
        intent.putExtra("developer", true)
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY/*Este intentFlag puede ser buena practica en ciertas ocaciones ya que no guarda en el stack
        el activity donde se muestran los datos decir, el orden no se altera ya que si vamos al activity presionamos go back y presionamos el boton
        de back del movil nos deja donde mismo y no mostraria el activity otra vez.*/
        startActivity(intent)
    }

    private fun goIntentFlags(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY //no guarda el activity en el historial o stack
        //El stack activity lo que hace es crear una pila de los activities es decir los va acumulando segun se van haciendo los startActivity.
        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION //Sin animacion.
        //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK //Borra el stack completo
        startActivity(intent)
        //finish()//El finish destruye el activity
    }

    private fun goIntentObject(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        startActivity(intent)
    }
}
