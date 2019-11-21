import models.TableSymbol
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor


abstract class TableSymbolReader : TableSymbol() {

    init {
        val yaml = Yaml(Constructor(TableSymbol::class.java))
        val inputStream = this.javaClass.classLoader.getResourceAsStream("reservedWords.yaml")
        val tableSimbol = yaml.load<TableSymbol>(inputStream)
        alphabet = tableSimbol.alphabet
        numbers = tableSimbol.numbers
        operators = tableSimbol.operators
        reservedWords = tableSimbol.reservedWords
    }

}
