package helpers

fun searchCaracter(caracter: Char, tipo: String): Boolean {
    val elemento: CharArray = tipo.toCharArray()

    for (i in elemento) {
        if (caracter == i) {
            return true
        }
    }
    return false
}

