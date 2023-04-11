package Clases

import Habilidad.Habilidad
import java.sql.PreparedStatement
import java.sql.SQLException

/**
 * Implementacion
 *
 * Clase que define las operaciones básicas de inserción, consulta, modificación y eliminación en una tabla de base de datos.
 * Las operaciones deben ser implementadas en clases derivadas.
 * @constructor Create empty Implementacion
 */
open class Implementacion {

    /**
     * Todos los campos
     *
     * Devuelve una lista con todas las filas de la tabla.
     *
     * @return Lista de objetos Fila que representan las filas de la tabla.
     */
    open fun todosLosCampos(): List<Fila> {

        return listOf<Fila>()
    }

    /**
     * Insertar fila
     *
     * @param c Lista de objetos Fila que representan las filas que se quieren insertar en la tabla.
     * @return Lista de objetos Fila que representan las filas insertadas en la tabla.
     */
    open fun insertarFila(c:ArrayList<Fila>):ArrayList<Fila>{
        return arrayListOf<Fila>()
    }

    /**
     * Insertar fila
     *
     * @param fila Objeto Fila que representa la fila que se quiere insertar en la tabla.
     * @return Verdadero si se ha insertado correctamente la fila, falso en caso contrario.
     */
    open fun insertarFila(fila: Fila): Boolean {
        return true
    }

    /**
     * Recibir descripcion
     *
     * Devuelve la descripción correspondiente a una clave primaria.
     *
     * @param clavePrincipal Valor de la clave primaria de la fila.
     * @return Cadena de caracteres que representa la descripción correspondiente a la clave primaria.
     */
    open fun recibirDescripcion(clavePrincipal: String): String? {
        return ""
    }

    /**
     * Borrar fila
     *
     * Elimina una fila de la tabla
     *
     * @param clavePrincipal Valor de la clave primaria de la fila que se quiere eliminar.
     * @return Verdadero si se ha eliminado correctamente la fila, falso en caso contrario.
     */
    open fun borrarFila(clavePrincipal: String): Boolean {
        return true
    }

    /**
     * Modificar campo
     *
     * Modifica el valor de un campo de una fila de la tabla.
     *
     * @param clavePrincipal Valor de la clave primaria de la fila que se quiere modificar.
     * @param nombreCampo Nombre del campo que se quiere modificar.
     * @param nuevoValor Nuevo valor que se quiere asignar al campo.
     * @return Verdadero si se ha modificado correctamente el campo, falso en caso contrario.
     */
    open fun modificarCampo(clavePrincipal: String, nombreCampo: String, nuevoValor: String): Boolean {
        return true
    }

}