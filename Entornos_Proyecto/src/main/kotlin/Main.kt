import Habilidad.*
import Jefe.*
import Pelea.*
import Personaje.*

fun main(args: Array<String>) {
    val HabilidadDAO = HabilidadDAOImpl()
    val HabilidadFichero= HabilidadFichero()
    val JefeDAO = JefeDAOImpl()
    val JefeFichero = JefeFichero()
    val PeleaDAO = PeleaDAOImpl()
    val PeleaFichero = PeleaFichero()
    val PersonajeDAO = PersonajeDAOImpl()
    val PersonajeFichero = PersonajeFichero()

    //Ejemplo de sacar de bb a fichero

       var c = PersonajeDAO.todosLosPersonajes()
       PersonajeFichero.insertar(c,Constantes.ficheroPersonaje,false)
       println("Control por la salida Estandar")
       for (i in c!!) {
           println(i)
       }}


    //ejemplo de insertar de fichero a bbdd
    //AutoresDAO.insertarLista(AutoresFichero.recuperar(Constantes.ficheroAutores))}
    //EditorialesDAO.insertarLista (EditorialesFichero.recuperar(Constantes.ficheroEditoriales)) }