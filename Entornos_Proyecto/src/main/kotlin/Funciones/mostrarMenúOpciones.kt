package Funciones

fun mostrarMenuOpciones(nombreTabla: String): String {
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