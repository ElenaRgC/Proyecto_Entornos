package Jefe

import Habilidad.Habilidad
import Jefe.Jefe

interface JefeDAO {
    fun todosLosJefes(): List<Jefe>
    fun insertarLista(c:ArrayList<Jefe>):ArrayList<Jefe>
    fun insertarJefe(jefe: Jefe): Boolean
    fun recibirDescripcion(nombreJefe: String): String?
}