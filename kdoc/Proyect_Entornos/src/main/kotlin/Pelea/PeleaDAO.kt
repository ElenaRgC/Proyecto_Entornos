package Pelea

/**
 * Pelea dao
 *
 * Define los métodos para acceder a los datos de las peleas.
 * @constructor Crea una instancia de la interfaz PeleaDAO.
 */
interface PeleaDAO {
    /**
     * Todos los campos
     *
     * @return una lista de objetos Pelea con todas las filas de la tabla.
     */
    fun todosLosCampos(): List<Pelea>

    /**
     * Insertar fila
     *
     * @param pelea Objeto Pelea a insertar
     * @return Verdadero si la inserción fue exitosa, falso en caso contrario.
     */
    fun insertarFila(pelea: Pelea): Boolean

    /**
     * Borrar fila
     *
     * @param nombre Nombre del personaje a borrar.
     * @return Verdadero si la eliminación fue exitora, falso en caso contrario.
     */
    fun borrarFila(nombre: String): Boolean

    /**
     * Modificar campo
     *
     * @param nombre Nombre del personaje a modificar.
     * @param nombreCampo Nombre del campo a modificar.
     * @param nuevoValorCampo Nuevo valor del campo a modificar.
     * @return Verdadero si la modificación fue exitosa, falso en caso contrario.
     */
    fun modificarCampo(nombre: String, nombreCampo: String, nuevoValorCampo: String): Boolean
}
