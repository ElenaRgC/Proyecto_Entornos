package Clases

import Habilidad.Habilidad
import java.sql.PreparedStatement
import java.sql.SQLException

open class Implementacion {

    open fun todosLosCampos(): List<Fila> {

        return listOf<Fila>()
    }

    open fun insertarFila(c:ArrayList<Fila>):ArrayList<Fila>{
        return arrayListOf<Fila>()
    }

    open fun insertarFila(fila: Fila): Boolean {
        return true
    }

    open fun recibirDescripcion(clavePrincipal: String): String? {
        return ""
    }

    open fun borrarFila(clavePrincipal: String): Boolean {
        return true
    }

    open fun modificarCampo(clavePrincipal: String, nombreCampo: String, nuevoValor: String): Boolean {
        return true
    }

}