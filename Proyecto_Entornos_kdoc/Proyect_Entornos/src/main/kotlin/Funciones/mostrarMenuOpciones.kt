package Funciones

/**
 * Mostrar menu opciones
 *
 * Muestra las diferentes opciones de trabajo para la tabla indicada por 'nombreTabla'.
 *
 * @param nombreTabla El nombre de la tabla.
 * @return La opción seleccionada por el usuario como una cadena de texto en minúsuclas.
 */
fun mostrarMenuOpciones(nombreTabla: String): String { // en esta funcion se señalan las diferentes opciones de trabajo
    print("Que quieres hacer con la tabla ${nombreTabla.uppercase()}?")
    println(" (Introduzca la palabra indicada en mayúsculas o su número correspondiente.)")
    println("1. ANADIR una fila.")
    println("2. BORRAR una fila.")
    println("3. MODIFICAR un campo.")
    println("\n O también:")
    println("4. CAMBIAR a otra tabla.")
    println("5. SALIR del programa.")

    return readln().trim().lowercase()
}