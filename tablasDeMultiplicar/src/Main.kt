/**
 * Solicita un número entero en un rango.
 *
 * @param min Int - valor mínimo
 * @param max Int - valor máximo
 *
 * @return Int - número entero válido dentro del rango especificado
 */
fun pedirNum(min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): Int {

    var numero = 1
    var todoOk = false

    do {
        try {
            numero = readln().trim().toInt()

            if (numero < min) {
                throw NumberFormatException("")
            } else if (numero > max) {
                throw NumberFormatException("")
            } else {
                todoOk = true
            }
        } catch (e: NumberFormatException) {
            print("Error, número no válido. Intentelo otra vez: ")
        } catch (e: Exception) {
            println("Error desconocido: ${e.message}")
            print("Intentelo otra vez: ")
        }
    } while (!todoOk)

    return numero
}

/**
 * Realiza una pregunta para contestar con s/si ó n/no
 *
 * @param text String - Texto de la pregunta
 *
 * @return Boolean - true/false dependiendo de la respuesta válida a la pregunta
 */
fun pregunta(text: String): Boolean {
    var todoOk = false
    var input: String
    var retorno = false

    do {
        print(text)
        input = readln().trim().lowercase()

        if (input != "si" && input != "no") {
            println("Error, por favor Introduzca Si o No (S/N).")
        } else {
            todoOk = true
            if (input == "si") {
                retorno = true
            }
        }
    } while (!todoOk)

    return retorno
}

fun limpiaConsola() {
    for (i in 1..20) {
        println()
    }
}

fun main() {
    //Hasta que se responda negativamente a la pregunta "¿Desea generar otra tabla de multiplicación? (s/n)"
    var todoOk: Boolean
    var numero: Int

    do {
        limpiaConsola()
        print("Introduzca un número entre 1 y 100: ")
        numero = pedirNum(1, 100)

        for (j in (1..10)) {

            println("$j -> $numero x $j = ${numero*j}")
        }

        todoOk = pregunta("¿Desea generar otra tabla de multiplicación? (s/n): ")
    } while (todoOk)
}