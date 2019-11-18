
class Token { // val literal: Any?,val type: TokenType, val lexeme: String, val pos: Int
    val tokens = ArrayList<Token>()

    constructor()
    constructor(type: TokenType, lexeme: String, pos: Int)

    fun createToken(expression: String, pos: Int) {
        when(expression) {
            TokenType.VAR.text -> {
                tokens.add(Token(TokenType.VAR, expression, pos))
                return
            }
        }
        return
    }

}
