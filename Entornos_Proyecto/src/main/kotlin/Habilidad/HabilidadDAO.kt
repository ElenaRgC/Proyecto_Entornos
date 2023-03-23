package Habilidad

import Habilidad.Habilidad
interface HabilidadDAO {
    fun todosLasHabilidades(): List<Habilidad>
    fun insertarLista(c:ArrayList<Habilidad>):ArrayList<Habilidad>
}