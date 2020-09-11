package aula05

fun meuNome(nome: String, sobrenome: String) {
    println("Meu nome é $nome $sobrenome")
}

fun qualNumeroEhMaior(numero1: Int, numero2: Int): Int {
    return if (numero1 > numero2) {
        numero1
    } else {
        numero2
    }
}

fun exercicioUm(numero: Int): Int {
    var contador = numero
    var fatorial = 1
    while (contador > 0) {
        fatorial *= contador
        contador--
    }

    return fatorial
}

fun exercicioDois(idade: Int, anosContribuicao: Int, sexo: String) {
    when {
        sexo == "F" && idade >= 60 && anosContribuicao >= 30 -> {
            println(true)
        }
        sexo == "M" && idade >= 65 && anosContribuicao >= 30 -> {
            println(true)
        }
        else -> println(false)
    }
}

fun exercicioTres(lista: MutableList<Int>): Int {
    //MutableList - posso modificar
    //ArrayList - posso modificar
    //List - imutável
    return lista.reduce(Int::times)
}

fun main() {
    //println(exercicioUm(5))

    //println(exercicioDois(65, 30, "M"))

    //println(exercicioTres(mutableListOf(1, 3, 5)))

    val pessoa1 = Pessoa("Matheus", "Menezes")
    val pessoa2 = Pessoa("Cesar", "Rodrigues", 25)
    val pessoa3 = Pessoa(12)

    val cliente = Cliente("Cesar")
    val conta = Conta(123, cliente)

    pessoa3.age = 13
    pessoa3.firstName = "Pedro"

    println("O primeiro nome da pessoa1 é ${pessoa3.qualEhOPrimeiroNome()}")
    println("O segundo nome da pessoa1 é ${pessoa3.qualEhOSegundoNome()}")
    println("A idade da pessoa1 é ${pessoa3.qualEhAIdade()}")
}

class Pessoa(nome: String, sobrenome: String) {

    constructor(nome: String = "Matheus", sobrenome: String = "Meneses", idade: Int = 24)
            : this(nome, sobrenome) {
        firstName = nome
        lastName = sobrenome
        age = idade
    }

    constructor(idade: Int)
            : this("Antonio", "Fagundes", 24) {
        age = idade
    }

    var firstName = nome
    var lastName = sobrenome
    var age = 0

    fun qualEhOPrimeiroNome(): String {
        return firstName
    }

    fun qualEhOSegundoNome(): String {
        return lastName
    }

    fun qualEhAIdade(): Int {
        return pegarIdade()
    }

    private fun pegarIdade(): Int {
        return age
    }
}

class Cliente(var nome: String, var sobrenome: String) {

    constructor(nome: String): this(nome, sobrenome = ""){
        this.nome = nome
    }
}

class Conta(numeroConta: Int, cliente: Cliente) {
    var saldo = 0.0
    val conta = numeroConta
    val customer = cliente
}