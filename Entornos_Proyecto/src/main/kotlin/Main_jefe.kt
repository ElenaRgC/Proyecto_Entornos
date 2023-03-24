import Habilidad.Habilidad
import Jefe.Jefe
import Jefe.JefeDAOImpl
import Jefe.JefeFichero


fun main() {
    val JefeDAO = JefeDAOImpl()
    val JefeFichero = JefeFichero()

    val jefe = JefeDAO.todosLosJefes()
    println("Lista de jefes:")
    jefe.forEach { println(it) }
    println(jefe)

    val nuevoJefe = Jefe(13,"Ashava El Pestilente",7500,"Facil", "Utiliza su mano derecha para aplastar y causar daño de área")
    if (JefeDAO.insertarJefe(nuevoJefe)) {
        println("Se insertó correctamente el jefe ${nuevoJefe.nombreJ}")
    } else {
        println("No se pudo insertar el jefe ${nuevoJefe.nombreJ}")
    }
}