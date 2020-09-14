package aula06

fun main() {

    val cachorro = Cachorro("hulk")

    val viraLata = ViraLata("caramelo")

    val loboGuara = LoboGuara("nota de 200")

    println(viraLata.corMamifero())
//    println(viraLata.ehDomestico())
//    println(cachorro.ehDomestico())
//    println(viraLata.comoEuCorro())
//    viraLata.tempoGestacao(3)
//    println(viraLata.tempoGestacao)
//    println(viraLata.corMamifero())

    //println(cachorro.racaMamifero("Pitbull"))

//    cachorro.nasce()
//    cachorro.come()
//    viraLata.som()

    //Animal -> Cachorro -> Vira Lata
}

open class Animal(var nomeDoAnimal: String): Mamifero() {

    open var raca: String = ""
    open var tempoGestacao = 0

    open var domestico = true

    val pele = "eh igual para todos"

    open fun come() {
        println("Eu me alimento do jeito x")
    }

    open fun corre(): String {
        return "acao xpto"
    }

    open fun som() {

    }

    fun nasce() {
        println("Eu nasci do jeito xpto")
    }

    override fun racaMamifero(raca: String) {
        this.raca = raca
        println(this.raca)
    }

    override fun tempoGestacao(meses: Int): Int {
        this.tempoGestacao = meses
        return this.tempoGestacao
    }
}

open class Cachorro(nomeDoCachorro: String) : Animal(nomeDoCachorro) {

    init {
        super.domestico = false
    }

    open fun ehDomestico(): Boolean {
        return super.domestico
    }

    override fun come() {
        println("Eu me alimento do jeito y")
    }

    override fun som() {
        super.som()
    }

    override final fun corre():String {
        return "Eu corro como um cachorro"
    }
}

open class LoboGuara(nomeDoLobo: String) : Animal(nomeDoLobo) {

    init {
        super.domestico = false
    }

    fun ehDomestico(): Boolean {
        return super.domestico
    }
}

class ViraLata(nomeDoViraLata: String) : Cachorro(nomeDoViraLata) {

    init {
        super.domestico = false
    }

    override fun ehDomestico(): Boolean {
        return super.domestico
    }

    fun comoEuCorro(): String {
        return super.corre()
    }

    override fun come() {
        super.come()
    }

    override fun som() {
        println("Eu emito som diferente")
    }

}

abstract class Mamifero: Mamifero2() {

    abstract fun racaMamifero(raca: String)
    abstract fun tempoGestacao(meses: Int): Int

    override fun corMamifero(): String {
        return "Minha cor é preta"
    }
}

abstract class Mamifero2 {

    abstract fun corMamifero(): String
}

class ContaPoupanca(): Conta() {

    override fun saldo(saldo: Double) {

    }

}

abstract class Conta {

    abstract fun saldo(saldo: Double)
}