import Habilidad.HabilidadDAOImpl
import Habilidad.HabilidadFichero

val HabilidadDAO = HabilidadDAOImpl()
val HabilidadFichero = HabilidadFichero()

fun main() {
    val HabilidadDAO = HabilidadDAOImpl()
    val HabilidadFichero = HabilidadFichero()

    val habilidad = HabilidadDAO.todosLasHabilidades()
    println("Lista de habilidades:")
    habilidad.forEach { println(it) }
    println(habilidad)

}