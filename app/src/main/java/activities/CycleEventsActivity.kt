package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.kotlinseccion4.R

class CycleEventsActivity : LifeCycleEventsActivity() {
    private var ExitEnable = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycle_events)
    }

    /*Este metodo onBackPressed es el que hace que funcione el boton fisico del telefono es decir que si sobreescribimos este metodo y quitamos
    y lo quitamos estariamos deshabilitando esta funcion. Se declara una variable en false para hacer que si de verdad quiere salir de esa screen
    tenga que hacerlo dos veces asi se puede evitar que el usuario salga por haberlo presionado sin darse cuenta.*/
    override fun onBackPressed() {
        if (ExitEnable) {
            super.onBackPressed()
        }
        ExitEnable= true
        Toast.makeText(this, "Press back again to exit this window", Toast.LENGTH_SHORT).show()
        /*Este metodo Handler y postDelayed lo que hacen es hacer una condicion para el back, es decir que el usuario presiona una vez el boton
        de back se lanza el if manda un toast con el mensaje y el hace que para volver atras se tenga que volver a presionar, si no es asi el metodo
         Hnadler da un tiempo de 2 segundos si no lo presiona la variable se vuelve a poner en false repitiendo el ciclo.*/
        Handler().postDelayed(Runnable { ExitEnable = false }, 2000)
    }
}
