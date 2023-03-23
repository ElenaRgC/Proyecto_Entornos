package Jefe

import Jefe.Jefe

interface JefeDAO {
    fun todosLosJefes(): List<Jefe>
    fun insertarLista(c:ArrayList<Jefe>):ArrayList<Jefe>
}