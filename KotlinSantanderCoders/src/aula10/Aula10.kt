package aula10

fun main() {

    val cesar = Pessoa("Cesar", 25)
    val cesar1 = Pessoa("Cesar", 25)

    println(cesar.toString())
    println(cesar1.toString())

    println(cesar.equals(null))

//    val testeDoSucesso = mutableSetOf(cesar)
//    testeDoSucesso.add(cesar1)
//
//    println(testeDoSucesso)



}

class Pessoa (private var nome: String, private var idade: Int) {

    fun setNome(nome: String) {
        this.nome = nome
    }

    fun getNome(): String {
        return nome
    }

    override fun equals(other: Any?): Boolean {
        return other?.let {
            val pessoa = (it as? Pessoa)
            pessoa?.let {
                it.nome == nome && it.idade == idade
            } ?: false
        } ?: false
    }

    override fun hashCode(): Int {
        return 1
    }

    override fun toString(): String {
        return "Meu nome é $nome e minha idade é $idade"
    }
}

data class Animal(val nome: String, val tipo: String)