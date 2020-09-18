package aula08

fun main() {
    val list: List<String?> = listOf("Arroz", "Feijão", "Macarrao", null)
    list.get(0)
    list.size
    list.last()
    list.first()

    val listaMutavel: MutableList<String> = mutableListOf("Cesar", "Edu", "Matheus")
    listaMutavel.add("Jonatas")
    listaMutavel.add("Luciana")

    val listaDeQualquerCoisa = mutableListOf("1", 2, true, list)


    val arroz = ItemVenda(produto = "arroz", quantidade = 2, valor = 10.0)
    val instalarTv = Servico(descricao = "tv", horas = 4, precoHora = 50.0)
    val macarrao = ItemVenda(produto = "macarrao", quantidade = 3, valor = 4.0)

//    val listItemVenda: MutableList<ItemVenda> = mutableListOf()
//    println("O tamanho da minha lista é ${listItemVenda.size}")
//    listItemVenda.add(arroz)
//    listItemVenda.add(macarrao)
//    println("O tamanho da minha lista é ${listItemVenda.size}")
//
    val venda1 = RegistroRecebimentos()
//
//    venda1.adicionarRecebimento(arroz)
//    venda1.adicionarRecebimento(instalarTv)
//    venda1.adicionarRecebimento(macarrao)
//
//    println(venda1.apresentarRecebimentos())
//    val cachorro = Cachorro()
//    cachorro.batimentos()
//
    var maca: ItemVenda? = ItemVenda(produto = "maca", quantidade = 2, valor = 3.0)
//
//    var nome: String? = null
//    nome = "Cesar"

    if (maca != null) {
        println("executou")
        venda1.adicionarRecebimento(maca)
        maca.produto
    }

    maca?.let { macaNaoNula ->
        println("executou")
        venda1.adicionarRecebimento(macaNaoNula)
        macaNaoNula.produto
    }

    maca?.also(::println)

    maca?.apply {
        this.produto
    }
}

class Cachorro : Animal, Pundle() {

    override val nome: String = "Thor"

    override fun andar() {
        println("Eu ando do jeito xpto")
    }

    override fun comer() {
        println("Eu como como um cachorro")
    }

    override fun dormir() {
        println("Eu durmo bastante")
    }

    override fun batimentos() {
        println("Meu coração bate como cachorro")
    }

    override val peloPudle: String = "branco"

    override fun correrPudle() {
        println("corro como pudle")
    }
}

abstract class Pundle: PastorAlemao() {
    abstract val peloPudle: String

    abstract fun correrPudle()

    override fun correrPastorAlemao() {
        println("corro como pastor alemao")
    }
}

abstract class PastorAlemao {

    abstract fun correrPastorAlemao()
}

interface Animal {
    val nome: String

    fun andar()

    fun comer()

    fun dormir()

    fun batimentos() {
        println("Meu coração bate")
    }
}

class RegistroRecebimentos {
    val listaDeProdutos: MutableList<IRecebivel> = mutableListOf()
    var totalDeRecebimentos = 0.0

    fun registroRecebimentos() {
        totalDeRecebimentos = 0.0
        listaDeProdutos.forEach {
            totalDeRecebimentos += it.totalizarReceita()
        }
    }

    fun adicionarRecebimento(produto: IRecebivel) {
        listaDeProdutos.add(produto)
        registroRecebimentos()
    }

    fun apresentarRecebimentos(): Double {
        return totalDeRecebimentos
    }
}

interface IRecebivel {

    fun totalizarReceita(): Double

    fun toStringSobrescrito(): String
}

class ItemVenda(val produto: String, val quantidade: Int, val valor: Double): IRecebivel {

    override fun totalizarReceita(): Double {
        return quantidade * valor
    }

    override fun toStringSobrescrito(): String {
        return "O produto é $produto, na quantidade $quantidade, na valor de R$ $valor"
    }
}

class Servico(val descricao: String, val horas: Int, val precoHora: Double): IRecebivel {

    override fun totalizarReceita(): Double {
        return horas * precoHora
    }

    override fun toStringSobrescrito(): String {
        return "O serviço é $descricao, as foram $horas, e o valor/hora de R$ $precoHora"
    }
}

class Professor(override var registro: String, override var nome: String): IPessoa {

}

interface IPessoa {

    var registro: String
    var nome: String
}

class Cliente {

    val professor = Professor("teste", "teste")
}


