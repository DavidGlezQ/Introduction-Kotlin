package models

import android.os.Parcel
import android.os.Parcelable

//Parcel es un contenedor para un mensaje, puede ser usado para mandar un objeto serializado atraves de un intent, mejor rendimiento que Serializer.
data class Student(val name: String, val lastName: String, val age: Int, val isDeveloper: Boolean = true) : Parcelable{

    //Los parametros del constructor deben de ser iguales a los del data class y en el mismo orden.
    constructor(parcel: Parcel): this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte())//Nota:  Parcelable no entiende boolean, por lo tanto se aplican bytes. Es decir si el valor en byte es 0 es falso y si es diferente es true.

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //Aqui tenemos que escribir los parametros en el mismo orden que el constructor.
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDeveloper) 1 else 0)
    }

    //Describe el tipo de contenido del objeto Parcelable
    //0 siempre se usa, el otro valor es 1 o CONTENTS_FILE_DESCRIPTOR, para tipos de datos que implementan un file Descriptor
    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Student>{
        //Este metodo creara el objeto desde el aprcel llamando al constructor secundario
        //Metodo que creara un Student desde un pacelable.
        override fun createFromParcel(parcel: Parcel) = Student(parcel)
        //Este metodo ayudara a serializar arrays de objetos del mismo tipo que esta clase (Student)
        override fun newArray(size: Int) =  arrayOfNulls<Student?>(size)
    }
}
