import models.TableSimbol
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor


class TableSimbolReader : TableSimbol() {

    init {
        val yaml = Yaml(Constructor(TableSimbol::class.java))
        val inputStream = this.javaClass.classLoader.getResourceAsStream("reservedWords.yaml")
        val tableSimbol = yaml.load<TableSimbol>(inputStream)
        alphabet = tableSimbol.alphabet
        numbers = tableSimbol.numbers
        operators = tableSimbol.operators
        reservedWords = tableSimbol.reservedWords

    }

}
