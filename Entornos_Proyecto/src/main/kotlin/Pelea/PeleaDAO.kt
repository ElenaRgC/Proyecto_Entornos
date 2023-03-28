package Pelea

import Pelea.Pelea

interface PeleaDAO {
    fun todosLasPeleas(): List<Pelea>
    fun insertarLista(c:ArrayList<Pelea>):ArrayList<Pelea>
    fun insertarPelea(pelea: Pelea): Boolean

}