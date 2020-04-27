package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.list_view_person.view.*
import models.Person

class PersonAdapter(val context: Context, val layout: Int, val list: List<Person>): BaseAdapter(){

    private val mInflator: LayoutInflater = LayoutInflater.from(context)

    override fun getItem(position: Int): Any {
        //Este metodo lo que hace resvir la posicion de la lista, en forma ordenada
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        //Este metodo lo que hace es pasar la position a un .toLong (este metodo casi nunca se utiliza)
        return position.toLong()
    }

    override fun getCount(): Int{
        //Estem metodo lo que hace es decidir el tamaño de la lista en base a las position, que tiene es decir 10 position creara 10 espacios
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Este metodo sera llamado cada vez que queramos llenar una fila es decir que es el metodo que se estara ejecutando mas seguido y por lo tanto el mas importante.
        val view: View
        val vh: PersonViewHolder

        if (convertView == null){
            //Se infla la vista
            view = mInflator.inflate(layout, parent, false)
            //Ese view es el view inflado con el layout y que pasa como referencia los dos textview con el nomnbre y el año.
            vh = PersonViewHolder(view)
            view.tag = vh
        }else{
            //Si no infla nada lo que hace es recuperar el viewHolder con los datos ya cargados
            view = convertView
            vh = view.tag as PersonViewHolder
        }
        //De esta manera estamos rellenando el fullName y age el esas posiciones
        val fullName = "${list[position].firstname}, ${list[position].lastname}"
        vh.fullName.text = fullName
        vh.age.text = "${list[position].age}"
        return view
    }

}

//Esta clase nos ayudara a implementar el patron de diseño del ViewHolder
private class PersonViewHolder(view: View){
    val fullName: TextView = view.textViewName
    val age: TextView = view.textViewAge
}