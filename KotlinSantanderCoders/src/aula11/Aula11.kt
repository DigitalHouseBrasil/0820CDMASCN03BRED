package aula11

import java.lang.ClassCastException
import java.lang.NullPointerException
import java.lang.NumberFormatException

fun main() {

    var nome: String? = "Maria"
    println("meu nome é $nome e meu tamanho é ${nome?.length}")
    nome = null
    println("meu nome é ${nome ?: "sem nome"} e meu tamanho é ${nome?.length}")
//
//    var numero: Int? = 3
//    numero = null
//
//    var numeroPontoFlutuante: Double? = 2.0
//    numeroPontoFlutuante = null
//
//    val cesar = Pessoa(null, idade = 25)
//    val cesar1 = Pessoa("Cesar", idade = 25)
//
//    println(cesar.getNome())
//
//    println(cesar.equals(2.0))

//    val lista: List<Int> = listOf(1, 2, 3, 4)
//    val nome = "Cesar"
//
//    try {
//        println(nome.toDouble())
//        println("eu quero acessar a posição ${lista.get(3)}")
//    } catch (exception: ArrayIndexOutOfBoundsException) {
//        println("não existe posição 3 do array")
//    } catch (exception: NumberFormatException) {
//        println("não consigo transformar para double")
//    } finally {
//        println("Vou executar sempre")
//    }
}

class Pessoa (private var nome: String?, private var idade: Int) {

    fun setNome(nome: String) {
        this.nome = nome
    }

    fun getNome(): String? {
        return nome
    }

    override fun equals(other: Any?): Boolean {
        return try {
            val pessoa = other as Pessoa
            pessoa.nome == nome && pessoa.idade == idade
        } catch (exception: NullPointerException) {
            println(exception.localizedMessage)
            return false
        } catch (exception: ClassCastException) {
            println(exception.localizedMessage)
            return false
        }
    }

    override fun hashCode(): Int {
        return 1
    }

    override fun toString(): String {
        return "Meu nome é $nome e minha idade é $idade"
    }
}