package aula07

fun retornaValorPadrao(): String {
    return "1234"
}

fun main() {
    val clienteCesar = Cliente(codigo = null, nome = null, rg = "12345", cpf = "120837213")
    val santanderCesar = ContaPoupanca(0.0, clienteCesar, juros = 1.5)
    val santanderCesarCorrente = ContaCorrente(0.0,
            clienteCesar, 500.0)

    val numero: Double? = null
    val floatNum: Float? = null

    println(santanderCesar.cliente?.codigo ?: "1234")

    println()

    santanderCesar.cliente?.let {
        it.codigo?.let {
            println("o codigo nao eh nulo")
        } ?: println("o codigo eh nulo")
    } ?: println("o cliente eh nulo")

    if (santanderCesar.cliente != null && santanderCesar.cliente?.codigo != null) {
        println("o codigo nao eh nulo")
    }

//    val codigoNaoNulo: String = clienteCesar.codigo ?: retornaValorPadrao()
//    println(codigoNaoNulo)
//
//    val codigoNaoNulo2 = clienteCesar.codigo?.let {
//        "12"
//    } ?: run {
//        "1234"
//    }

//    println(codigoNaoNulo2)

//    santanderCesar.depositar(100.0)
//    santanderCesar.recolherJuros()
//    val saldo = santanderCesar.verSaldo()
//
//    santanderCesarCorrente.sacar(500.0)

//    clienteCesar.codigo?.apply {
//        println(this.length)
//    }
//
//    clienteCesar.codigo?.also {
//        println(it)
//    }
//
//    clienteCesar.codigo?.let {
//        println("eu nao sou nulo")
//    } ?: run {
//        println("eu sou nulo")
//    }

//    if (clienteCesar.codigo != null) {
//        println("eu nao sou nulo")
//    } else {
//        println("eu sou nulo")
//    }

    //println("Meu saldo é $saldo")
}

open class Pessoa(var mae: String?)

class Cliente(
        var codigo: String?,
        var nome: String?,
        var rg: String,
        var cpf: String
): Pessoa("Sivirina")

open class Conta(
        var saldo: Double,
        var cliente: Cliente?
) {

    fun verSaldo(): Double {
        return saldo
    }

    fun codigo(codigo: String) {

    }

    fun depositar(valor: Double) {
        if (valor < 0.0) {
            println("Você não pode depositar um valor negativo")
        } else {
            saldo += valor
        }
    }

    open fun sacar(valor: Double) {
        if (valor <= saldo) {
            saldo -= valor
            println("Saque de $valor efetuado com sucesso")
        } else {
            println("Você não tem esse valor disponível para saque")
        }
    }
}

class ContaPoupanca(
        saldo: Double,
        cliente: Cliente?,
        var juros: Double
): Conta(saldo, cliente) {

    fun recolherJuros() {
        val rendimento = saldo * (juros / 100.0)
        depositar(rendimento)
    }
}

class ContaCorrente(saldo: Double,
                    cliente: Cliente,
                    var valorChequeEspecial: Double
): Conta(saldo, cliente) {

    override fun sacar(valor: Double) {
        when {
            valor <= saldo -> {
                saldo -= valor
                println("Saque de $valor efetuado com sucesso")
            }
            valor <= valorChequeEspecial -> {
                valorChequeEspecial -= valor
                println("Você sacou $valor reais do cheque especial")
            }
            else -> {
                println("Você não tem esse valor disponível para saque")
            }
        }
    }

    fun depositarCheque(cheque: Cheque) {
        depositar(cheque.valor)
    }
}

class Cheque(var valor: Double, bancoEmissor: String, dataPagamento: String)