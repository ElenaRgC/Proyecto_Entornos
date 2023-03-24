import Habilidad.Habilidad
import Habilidad.HabilidadDAOImpl
import Habilidad.HabilidadFichero

fun main() {
    val HabilidadDAO = HabilidadDAOImpl()
    val HabilidadFichero = HabilidadFichero()

    val habilidad = HabilidadDAO.todosLasHabilidades()
    println("Lista de habilidades:")
    habilidad.forEach { println(it) }
    println(habilidad)

    val nuevaHabilidad = Habilidad(1, "Licantropia","Fisico", "Mejora las habilidades de Hombre Lobo y Hombre Oso.", 0, "Giovanni")
    if (HabilidadDAO.insertarHabilidad(nuevaHabilidad)) {
        println("Se insertó correctamente la habilidad ${nuevaHabilidad.nombre}")
    } else {
        println("No se pudo insertar la categoria ${nuevaHabilidad.nombre}")
    }

}