package Personaje

/**
 * Personaje d a o
 *
 * @constructor Create empty Personaje d a o
 */
interface PersonajeDAO {
    /**
     * Todos los campos
     *
     * @return
     */
    fun todosLosCampos(): List<Personaje>

    /**
     * Insertar fila
     *
     * @param personaje
     * @return
     */
    fun insertarFila(personaje: Personaje): Boolean

    /**
     * Borrar fila
     *
     * @param nombre
     * @return
     */
    fun borrarFila(nombre: String): Boolean

    /**
     * Recibir descripcion
     *
     * @param nombrePersonaje
     * @return
     */
    fun recibirDescripcion(nombrePersonaje: String): String?

    /**
     * Modificar campo
     *
     * @param nombrePersonaje
     * @param nombreCampo
     * @param nuevoValorCampo
     * @return
     */
    fun modificarCampo(nombrePersonaje: String, nombreCampo: String, nuevoValorCampo: String): Boolean
}