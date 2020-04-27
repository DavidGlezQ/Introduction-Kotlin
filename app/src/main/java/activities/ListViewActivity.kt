package activities

import adapter.PersonAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinseccion4.R
import kotlinx.android.synthetic.main.activity_list_view.*
import models.Person

class ListViewActivity : AppCompatActivity() {
    //Una buena practica es guardar las referencias
    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        personList = getPerson()//Conseguimos las personas de la lista
        adapter = PersonAdapter(this, R.layout.list_view_person, getPerson())//Creamos el adaptador
        ListView.adapter = adapter
    }

    //Este metodo es para crear una lista en este caso de personas para despues poder imprimirla en el ListView
    private fun getPerson(): List<Person> {
        return listOf(
            Person("David", "Gonzalez", 21),
            Person("Alejandro", "Lopez", 18),
            Person("Pedro", "Romero", 45),
            Person("Monica", "Quezada", 35),
            Person("Pedro", "Fernandez", 45),
            Person("Juan", "Hernandez", 63),
            Person("Pablo", "Escobar", 35),
            Person("Jorge", "Lora", 25),
            Person("Diana", "Vega", 15),
            Person("Angel", "Cardoso", 19),
            Person("David", "Gonzalez", 21),
            Person("Alejandro", "Lopez", 18),
            Person("Pedro", "Romero", 45),
            Person("Monica", "Quezada", 35),
            Person("Pedro", "Fernandez", 45),
            Person("Juan", "Hernandez", 63),
            Person("Pablo", "Escobar", 35),
            Person("Jorge", "Lora", 25),
            Person("Diana", "Vega", 15),
            Person("Diana", "Vega", 15),
            Person("Angel", "Cardoso", 19),
            Person("David", "Gonzalez", 21),
            Person("Alejandro", "Lopez", 18),
            Person("Pedro", "Romero", 45),
            Person("Monica", "Quezada", 35),
            Person("Pedro", "Fernandez", 45),
            Person("Juan", "Hernandez", 63),
            Person("Pablo", "Escobar", 35),
            Person("Jorge", "Lora", 25),
            Person("Diana", "Vega", 15),
            Person("Angel", "Cardoso", 19)
        )
    }
}

/*Para crear este ListView primero debemos crear una modelo con lo aparametros que necesitemos utilizar, en este caso esta en el paquete models y
el archivo es Person, despues se necesita una vista, esta se llama list_view_person en el cual hay dos textview donde se van a cargar los parametros
nombre y año.
Despues de eso de debe de crear un adaptador en el cual crearemos adaptadores para kotlin, este archivo contiene toda la logica para poder rellenar
los campos del listView.
Ya por ultimo se inflan las vistas en el activity.*/