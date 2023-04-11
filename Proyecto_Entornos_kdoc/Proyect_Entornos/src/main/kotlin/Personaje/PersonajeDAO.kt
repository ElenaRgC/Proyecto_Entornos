package Personaje

/**
 * Personaje dao
 * Interface para acceder a los datos de un personaje
 * @constructor Create empty Personaje dao
 */
interface PersonajeDAO {
    /**
     * Todos los campos
     *
     * @return Lista de personajes
     */
    fun todosLosCampos(): List<Personaje>

    /**
     * Insertar fila
     *
     * @param personaje El personaje a ser insertado.
     * @return True si la operación fue exitosa, false en caso contrario.
     */
    fun insertarFila(personaje: Personaje): Boolean

    /**
     * Borrar fila
     *
     * @param nombre El nombre del Personaje a ser borrado.
     * @return True si la operación fue exitosa, false en caso contrario.
     */
    fun borrarFila(nombre: String): Boolean

    /**
     * Recibir descripcion
     *
     * @param nombrePersonaje El nombre del personaje del que se desea obtener la descripción.
     * @return La descripción del Personaje, o null si no se encuentra en la fuente de datos.
     */
    fun recibirDescripcion(nombrePersonaje: String): String?

    /**
     * Modificar campo
     *
     * @param nombrePersonaje El nombre del Personaje cuyo campo se desea modificar.
     * @param nombreCampo El nombre del campo que se desea modificar.
     * @param nuevoValorCampo El nuevo valor que se desea asignar al campo.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    fun modificarCampo(nombrePersonaje: String, nombreCampo: String, nuevoValorCampo: String): Boolean
}