package Habilidad

/**
 * Habilidad dao
 *
 * Interfaz que define los métodos para el acceso a datos de la tabla "Habilidad".
 * @constructor Create empty Habilidad dao
 */
interface HabilidadDAO {
    /**
     * Todos los campos
     *
     * Obtiene todos los campos de la tabla "Habilidad".
     * @return una lista con todas las habilidades en la tabla.
     */
    fun todosLosCampos(): List<Habilidad>

    /**
     * Insertar fila
     *
     * Inserta una fila en la tabla "Habilidad".
     * @param habilidad es la habilidad a insertar
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    fun insertarFila(habilidad: Habilidad): Boolean

    /**
     * Recibir descripcion
     *
     * Recibe la descripción de una habilidad a partir de su nombre.
     *
     * @param nombreHabilidad el nombre de la habilidad de la que se quiere obtener la descripción.
     * @return la descripción de la habilidad si se encontró, null en caso contrario.
     */
    fun recibirDescripcion(nombreHabilidad: String): String?

    /**
     * Borrar fila
     *
     * Borrar una fila de la tabla "Habilidad" a partir de su nombre.
     *
     * @param nombre el nombre de la habilidad a borrar
     * @return true si se eliminó la fila exitosamente, false en caso contrario.
     */
    fun borrarFila(nombre: String): Boolean

    /**
     * Modificar campo
     *
     * Modificar un campo de una fila de la tabla "Habilidad".
     *
     * @param nombre el nombre de la habilidad a modificar.
     * @param nombreCampo el nombre del campo a modificar.
     * @param nuevoValorCampo el nuevo valor para el campo a modifica.
     * @return true si la modificación fue exitosa, false en caso contrario.
     */
    fun modificarCampo(nombre: String, nombreCampo: String, nuevoValorCampo: String): Boolean
}