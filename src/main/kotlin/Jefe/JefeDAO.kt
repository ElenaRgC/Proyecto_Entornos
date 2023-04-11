package Jefe

/**
 * Jefe d a o
 *
 * @constructor Create empty Jefe d a o
 */
interface JefeDAO {
    /**
     * Todos los campos
     *
     * @return
     */
    fun todosLosCampos(): List<Jefe>

    /**
     * Insertar fila
     *
     * @param jefe
     * @return
     */
    fun insertarFila(jefe: Jefe): Boolean

    /**
     * Recibir descripcion
     *
     * @param nombreJefe
     * @return
     */
    fun recibirDescripcion(nombreJefe: String): String?

    /**
     * Borrar fila
     *
     * @param nombre
     * @return
     */
    fun borrarFila(nombre: String): Boolean

    /**
     * Modificar campo
     *
     * @param nombre
     * @param nombreCampo
     * @param nuevoValorCampo
     * @return
     */
    fun modificarCampo(nombre: String, nombreCampo: String, nuevoValorCampo: String): Boolean
}