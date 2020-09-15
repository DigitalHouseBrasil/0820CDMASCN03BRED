package aula07

fun main() {

    val gol = Gol()
    gol.som = "som xpto 2020"
    println(gol.motor())
}



open class Gol : Carro {

    override val chassi: String = "38t4234i23b4"
    override val modelo: String = "2020"

    override var som: String = "Som xpto"

    override fun motor(cilindradas: Int) : String {
        return  "Implementacao moto gol"
    }

    override fun motor(cilindradas: Int, teste: String) {
    }

    fun freio() {
    }

    override fun motor(): String {
        return "Motor modificado"
    }
}

class GolGti : Gol(), Teste{

    override fun teste() {
        TODO("Not yet implemented")
    }
}

interface Teste {

    fun teste()
}

class Onix: Carro {

    override val chassi: String
        get() = TODO("Not yet implemented")
    override val modelo: String
        get() = TODO("Not yet implemented")
    override var som: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun motor(cilindradas: Int): String {
        TODO("Not yet implemented")
    }

    override fun motor(cilindradas: Int, teste: String) {
        TODO("Not yet implemented")
    }
}

interface Carro {

    val chassi: String

    val modelo: String

    var som: String

    fun motor(cilindradas: Int) : String

    fun motor(cilindradas: Int, teste: String)

    fun motor(): String {
        return "Motor padrão"
    }
}