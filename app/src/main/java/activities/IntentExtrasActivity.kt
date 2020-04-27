package activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinseccion4.R
import kotlinx.android.synthetic.main.activity_intent_extras.*
import kotlinx.android.synthetic.main.list_view_person.textViewName
import models.Student

class IntentExtrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)
        //Evento para boton regresar en una sola linea.
        btn_back.setOnClickListener { startActivity(Intent(this, IntentsActivity::class.java)) }

        val isExtraSet = setIntentExtrasFromPreviousActivity()

        val isParcelableSet = setParcelableFromPreviousActivity()

        if (!isExtraSet && !isParcelableSet){
            checkBoxDeveloper.visibility = View.INVISIBLE
        }
    }

    private fun setParcelableFromPreviousActivity(): Boolean{
        //Se llama con le key que le pusimos antes "student"
        val student = intent.getParcelableExtra<Student>("student")
        student?.let{
            textViewName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = "${student.age}"
            checkBoxDeveloper.text = "Developer"
            checkBoxDeveloper.isChecked = student.isDeveloper
            return true
        }
        return false
    }

    private fun setIntentExtrasFromPreviousActivity(): Boolean{
        //Recoger los datos del IntentExtra. Ese name es una key es decir que se le dice que valor es el que recogera.
        val name: String? = intent.getStringExtra("name")
        val lastName: String? = intent.getStringExtra("lastName")
        val age: Int = intent.getIntExtra("age", -1)
        val developer = intent.getBooleanExtra("developer", false)

        //Con este if se comprueba que los valores no esten en null y arroge algun otro valor.
        if (name != null && lastName != null && age >= 0){
            textViewName.text = name
            textViewLastName.text = lastName
            textViewAge.text = "$age"
            checkBoxDeveloper.text = "Developer"
            checkBoxDeveloper.isChecked = developer
            return true
        }
        return false
    }
}
