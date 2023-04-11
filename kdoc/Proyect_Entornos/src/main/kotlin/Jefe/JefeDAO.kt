package Jefe

/**
 * Jefe dao
 *
 * @constructor Create empty Jefe d a o
 */
interface JefeDAO {
    /**
     * Todos los campos
     *
     * @return una lista con todos los registros de la tabla jefe.
     */
    fun todosLosCampos(): List<Jefe>

    /**
     * Insertar fila
     *
     * @param jefe El objeto Jefe que se desea insertar.
     * @return true si se insertó correctamente, false en caso contrario.
     */
    fun insertarFila(jefe: Jefe): Boolean

    /**
     * Recibir descripcion
     *
     * @param nombreJefe El nombre del jefe del que se quiere obtener la descripción
     * @return la descripción del jefe, o null si no se encuentra el jefe.
     */
    fun recibirDescripcion(nombreJefe: String): String?

    /**
     * Borrar fila
     *
     * @param nombre El nombre del jefe que se desea borrar
     * @return true si se borró correctamente, false en caso contrario.
     */
    fun borrarFila(nombre: String): Boolean

    /**
     * Modificar campo
     *
     * @param nombre El nombre del jefe a modificar.
     * @param nombreCampo El nombre del campo que se desea modificar.
     * @param nuevoValorCampo El nuevo valor del campo que se desea modificar.
     * @return true si se modificó correctamente, false en caso contrario.
     */
    fun modificarCampo(nombre: String, nombreCampo: String, nuevoValorCampo: String): Boolean
}