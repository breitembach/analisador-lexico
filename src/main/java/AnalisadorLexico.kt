import helpers.searchCaracter

class AnalisadorLexico(dependencies: TableSimbolReader) {
    private val reserverdWords = dependencies.reservedWords
    private val operators = dependencies.operators
    private val alphabet = dependencies.alphabet
    private val numbers = dependencies.numbers
    var token: Token = Token()
    val END = 9999999



    init {
        while (true) {
            print("Digite > ")
            val expression = readLine()
            if(expression == "0") {
                print("PROGRAMA FINALIZADO! \n")
                break
            }
            var state = 0

            state = scanner(expression?.toCharArray()!!)
//            println("Tokens Criados"+token.tokens.toString())


            if (state == -1) {
                println("A expressão - ${expression}> está correta!")
            } else {
                println("A expressão - ${expression}> apresentou erro no estado ${state}")
            }




//            reserverdWords.forEach {


//                var rp = ".".repeat(50 - it.length)


//            }
        }


    }

//    private fun novoScan(expression : CharArray): Int {
//        var i = 0
//        var state = 0
//        var currentVar = ""
//
//        while(state != -1) {
//            when(state) {
//                0 -> {
//                    while (searchCaracter(expression[i], alphabet) && i < (expression.size - 1)){
//                        if(searchCaracter(expression[i], " ")) {
//                            token.createToken(currentVar, i)
//                            state = 2
//                        }else {
//                            return state
//                        }
//
//                    }
//                    token.createToken(currentVar, i)
//                    i++
//                    currentVar += expression[i]
//                    return state
//                }
////                1 -> {
////                    token.createToken(currentVar, i)
////                    i++
////                    currentVar += expression[i]
////                    return state
////                }
////                2 -> {
////                    token.createToken(currentVar, i)
////                    i++
////                    currentVar += expression[i]
////                    return state
////                }
//            }
//        }
//        throw Exception("ERRR")
//    }

    private fun scanner(expression : CharArray) : Int{

        var i = 0
        var estado = 0

        while(estado != 51) {
            if (i == expression.size && estado != 10 && estado != 15){
                return estado
            }
            when(estado){
                0-> {
                    while (expression[i] == ' '){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(searchCaracter(expression[i], alphabet)){
                        estado = 1
                        i++
                    }else if (expression[i] == '/'){
                        estado = 11
                        i++
                    } else {
                        return estado
                    }
                }

                1 -> {
                    while (searchCaracter(expression[i], alphabet) || searchCaracter(expression[i], numbers)){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == ' '){
                        estado = 2
                        i++
                    }else if(expression[i] == '='){
                        estado = 3
                        i++
                    }else if(expression[i] == '/'){
                        estado = 16
                        i++

                    }else {
                        return estado
                    }
                }

                2 -> {
                    while (expression[i] == ' '){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '='){
                        estado = 3
                        i++
                    }else if(expression[i] == '/'){
                        estado = 19
                        i++
                    }else {
                        return estado
                    }
                }

                3 -> {
                    if(expression[i] == ' '){
                        estado = 5
                        i++
                    }else if(searchCaracter(expression[i], alphabet)){
                        estado = 4
                        i++
                    }else if(searchCaracter(expression[i], numbers)) {
                        estado = 9
                        i++
                    }else if(expression[i] == '/'){
                        estado = 22
                        i++
                    }else {
                        return estado
                    }
                }

                4 -> {
                    while (searchCaracter(expression[i], alphabet) || searchCaracter(expression[i], numbers)){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == ' '){
                        estado = 6
                        i++
                    }else if(searchCaracter(expression[i], operators)){
                        estado = 7
                        i++
                    }else if(expression[i] == '/'){
                        estado = 25
                        i++
                    }else if(expression[i] == ';'){
                        estado = 10
                        i++
                    }else {
                        return estado
                    }
                }

                5 -> {
                    if(searchCaracter(expression[i], alphabet)){
                        estado = 4
                        i++
                    }else if(searchCaracter(expression[i], numbers)) {
                        estado = 9
                        i++
                    }else if (expression[i] == '/'){
                        estado = 30
                        i++
                    }else if(expression[i] == ' '){
                        estado = 5
                        i++
                    }else {
                        return estado
                    }
                }

                6 -> {
                    while (expression[i] == ' '){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(searchCaracter(expression[i], operators)){
                        estado = 7
                        i++
                    }else if (expression[i] == '/'){
                        estado = 33
                        i++
                    }else if(expression[i] == ';'){
                        estado = 10
                        i++
                    }else {
                        return estado
                    }

                }

                7 -> {
                    if(expression[i] == ' '){
                        estado = 5
                        i++
                    }else if(searchCaracter(expression[i], alphabet)){
                        estado = 8
                        i++
                    }else if(searchCaracter(expression[i], numbers)) {
                        estado = 9
                        i++
                    }else if (expression[i] == '/'){
                        estado = 38
                        i++
                    }else {
                        return estado
                    }
                }

                8 -> {
                    while (searchCaracter(expression[i], alphabet) || searchCaracter(expression[i], numbers)){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(searchCaracter(expression[i], operators)){
                        estado = 7
                        i++
                    }else if (expression[i] == '/'){
                        estado = 41
                        i++
                    }else if(expression[i] == ' '){
                        estado = 6
                        i++
                    }else if(expression[i] == ';'){
                        estado = 10
                        i++
                    }else {
                        return estado
                    }
                }

                9 -> {
                    while(searchCaracter(expression[i], numbers)){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == ' '){
                        estado = 6
                        i++
                    }else if(searchCaracter(expression[i], operators)){
                        estado = 7
                        i++
                    }else if (expression[i] == '/'){
                        estado = 46
                        i++
                    }else if(expression[i] == ';'){
                        estado = 10
                        i++
                    }else {
                        return estado
                    }
                }

                10 -> {
                    return -1
                }

                11 -> {
                    if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else if (expression[i] == '*'){
                        estado = 12
                        i++
                    }
                    else {
                        return estado
                    }
                }

                12 -> {
                    while (expression[i] != '*') {
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '*'){
                        estado = 13
                        i++
                    }
                    else {
                        return estado
                    }
                }

                13 -> {
                    while (expression[i] == '*'){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '/'){
                        estado = 14
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return -1
                        }
                    }else if (expression[i] != '*'){
                        estado = 12
                        i++
                    }else {
                        return estado
                    }
                }

                14 -> {
                    while (expression[i] == ' '){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if (searchCaracter(expression[i], alphabet)){
                        estado = 1
                        i++
                    }else if (expression[i] == '/') {
                        estado = 11
                        i++
                    } else {
                        return estado
                    }
                }

                15 -> {
                    return -1
                }

                16 -> {
                    if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else if (expression[i] == '*'){
                        estado = 17
                        i++
                    }
                    else {
                        return estado
                    }
                }

                17 -> {
                    while (expression[i] != '*') {
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '*'){
                        estado = 18
                        i++
                    }
                    else {
                        return estado
                    }
                }

                18 -> {
                    while (expression[i] == '*'){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '/'){
                        estado = 1
                        i++
                    }else if (expression[i] != '*'){
                        //(expression[i] != '*' && expression[i] != '/')
                        estado = 17
                        i++
                    }else {
                        return estado
                    }
                }

                19 -> {
                    if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else if (expression[i] == '*'){
                        estado = 20
                        i++
                    }
                    else {
                        return estado
                    }
                }

                20 -> {
                    while (expression[i] != '*') {
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '*'){
                        estado = 21
                        i++
                    }
                    else {
                        return estado
                    }
                }

                21 -> {
                    while (expression[i] == '*'){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '/'){
                        estado = 2
                        i++
                    }else if (expression[i] != '*'){
                        estado = 20
                        i++
                    }else {
                        return estado
                    }
                }

                22 -> {
                    if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else if (expression[i] == '*'){
                        estado = 23
                        i++
                    }
                    else {
                        return estado
                    }
                }

                23 -> {
                    while (expression[i] != '*') {
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '*'){
                        estado = 24
                        i++
                    }
                    else {
                        return estado
                    }
                }

                24 -> {
                    while (expression[i] == '*'){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '/'){
                        estado = 3
                        i++
                    }else if (expression[i] != '*'){
                        estado = 23
                        i++
                    }else {
                        return estado
                    }
                }

                25 -> {
                    if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else if (expression[i] == '*'){
                        estado = 28
                        i++
                    }else if(expression[i] == ' '){
                        estado = 27
                        i++
                    }else if(searchCaracter(expression[i], numbers)){
                        estado = 9
                        i++
                    }else if(searchCaracter(expression[i], alphabet)){
                        estado = 4
                        i++
                    }
                    else {
                        return estado
                    }
                }

                26 -> {
                    if(expression[i] == '*'){
                        estado = 28
                        i++
                    }else if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else {
                        return estado
                    }
                }

                27 -> {
                    if(searchCaracter(expression[i], numbers)){
                        estado = 9
                        i++
                    }else if(searchCaracter(expression[i], alphabet)){
                        estado = 4
                        i++
                    }else if(expression[i] == ' '){
                        estado = 27
                        i++
                    }else if(expression[i] == '/'){
                        estado = 26
                        i++
                    }else {
                        return estado
                    }
                }

                28 -> {
                    while (expression[i] != '*') {
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '*'){
                        estado = 29
                        i++
                    }
                    else {
                        return estado
                    }
                }

                29 -> {
                    while (expression[i] == '*'){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '/'){
                        estado = 4
                        i++
                    }else if (expression[i] != '*'){
                        estado = 28
                        i++
                    }else {
                        return estado
                    }
                }

                30 -> {
                    if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else if (expression[i] == '*'){
                        estado = 31
                        i++
                    }
                    else {
                        return estado
                    }
                }

                31 -> {
                    while (expression[i] != '*') {
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '*'){
                        estado = 32
                        i++
                    }
                    else {
                        return estado
                    }
                }

                32 -> {
                    while (expression[i] == '*'){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '/'){
                        estado = 5
                        i++
                    }else if (expression[i] != '*'){
                        estado = 31
                        i++
                    }else {
                        return estado
                    }
                }

                33 -> {
                    if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else if (expression[i] == '*'){
                        estado = 36
                        i++
                    }else if(expression[i] == ' '){
                        estado = 35
                        i++
                    }else if(searchCaracter(expression[i], numbers)){
                        estado = 9
                        i++
                    }else if(searchCaracter(expression[i], alphabet)){
                        estado = 4
                        i++
                    }
                    else {
                        return estado
                    }
                }

                34 -> {
                    if(expression[i] == '*'){
                        estado = 36
                        i++
                    }else if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else {
                        return estado
                    }
                }

                35 -> {
                    if(searchCaracter(expression[i], numbers)){
                        estado = 9
                        i++
                    }else if(searchCaracter(expression[i], alphabet)){
                        estado = 4
                        i++
                    }else if(expression[i] == ' '){
                        estado = 35
                        i++
                    }else if(expression[i] == '/'){
                        estado = 34
                        i++
                    }else {
                        return estado
                    }
                }

                36 -> {
                    while (expression[i] != '*') {
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '*'){
                        estado = 37
                        i++
                    }
                    else {
                        return estado
                    }
                }

                37 -> {
                    while (expression[i] == '*'){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '/'){
                        estado = 6
                        i++
                    }else if (expression[i] != '*'){
                        estado = 36
                        i++
                    }else {
                        return estado
                    }
                }

                38 -> {
                    if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else if (expression[i] == '*'){
                        estado = 39
                        i++
                    }
                    else {
                        return estado
                    }
                }

                39 -> {
                    while (expression[i] != '*') {
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '*'){
                        estado = 40
                        i++
                    }
                    else {
                        return estado
                    }
                }

                40 -> {
                    while (expression[i] == '*'){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '/'){
                        estado = 7
                        i++
                    }else if (expression[i] != '*'){
                        estado = 39
                        i++
                    }else {
                        return estado
                    }
                }

                41 -> {
                    if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else if (expression[i] == '*'){
                        estado = 44
                        i++
                    }else if(expression[i] == ' '){
                        estado = 43
                        i++
                    }else if(searchCaracter(expression[i], numbers)){
                        estado = 9
                        i++
                    }else if(searchCaracter(expression[i], alphabet)){
                        estado = 8
                        i++
                    }
                    else {
                        return estado
                    }
                }

                42 -> {
                    if(expression[i] == '*'){
                        estado = 44
                        i++
                    }else if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else {
                        return estado
                    }
                }

                43 -> {
                    if(searchCaracter(expression[i], numbers)){
                        estado = 9
                        i++
                    }else if(searchCaracter(expression[i], alphabet)){
                        estado = 8
                        i++
                    }else if(expression[i] == ' '){
                        estado = 43
                        i++
                    }else if(expression[i] == '/'){
                        estado = 42
                        i++
                    }else {
                        return estado
                    }
                }

                44 -> {
                    while (expression[i] != '*') {
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '*'){
                        estado = 45
                        i++
                    }
                    else {
                        return estado
                    }
                }

                45 -> {
                    while (expression[i] == '*'){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '/'){
                        estado = 8
                        i++
                    }else if (expression[i] != '*'){
                        estado = 44
                        i++
                    }else {
                        return estado
                    }
                }

                46 -> {
                    if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else if (expression[i] == '*'){
                        estado = 49
                        i++
                    }else if(expression[i] == ' '){
                        estado = 48
                        i++
                    }else if(searchCaracter(expression[i], numbers)){
                        estado = 9
                        i++
                    }else if(searchCaracter(expression[i], alphabet)){
                        estado = 4
                        i++
                    }
                    else {
                        return estado
                    }
                }

                47 -> {
                    if(expression[i] == '*'){
                        estado = 49
                        i++
                    }else if(expression[i] == '/'){
                        estado = 15
                        i++
                    }else {
                        return estado
                    }
                }

                48 -> {
                    if(searchCaracter(expression[i], numbers)){
                        estado = 9
                        i++
                    }else if(searchCaracter(expression[i], alphabet)){
                        estado = 4
                        i++
                    }else if(expression[i] == ' '){
                        estado = 48
                        i++
                    }else if(expression[i] == '/'){
                        estado = 47
                        i++
                    }else {
                        return estado
                    }
                }

                49 -> {
                    while (expression[i] != '*') {
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '*'){
                        estado = 50
                        i++
                    }
                    else {
                        return estado
                    }
                }

                50 -> {
                    while (expression[i] == '*'){
                        if (i < (expression.size - 1)){
                            i++
                        } else {
                            return estado
                        }
                    }
                    if(expression[i] == '/'){
                        estado = 9
                        i++
                    }else if (expression[i] != '*'){
                        estado = 49
                        i++
                    }else {
                        return estado
                    }
                }

                else -> {
                    println("Default case")
                }
            }
        }
        return -1
    }

}
