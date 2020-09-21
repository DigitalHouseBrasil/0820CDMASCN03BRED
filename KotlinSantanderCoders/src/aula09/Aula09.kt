fun main() {

    val listaNaoMutavel = listOf("cesar", true, 1, 1.0, 1.0f, "a")

    val listaMutavel = mutableListOf("cesar", true, 1, 1.0, 1.0f, "a")
    listaMutavel.add(2)
    listaMutavel.add(3)
    listaMutavel.add("String")

    val listaDeStringsNaoMutavel = listOf("Cesar", "Eduardo", "Mariana", "Patricia")
    val listaDouble = listOf<Double>(2.0, 1.0, 10.0, 11.0)

    val listaStringMutavel = mutableListOf<Any>("Cesar", "Eduardo", "Mariana", "Patricia")
    listaStringMutavel.add(2.0)
    listaStringMutavel.add(true)

    val animal = Animal()

    listaStringMutavel.add(animal)

    val teste: MutableList<Double> = mutableListOf(2.0, 1.0)

    val conjuntoSet = setOf(1, "Cesar", "Eduardo", "Cesar", 2, 3)
    val conjuntoSetMutavel = mutableSetOf(1, "Cesar", "Eduardo", "Cesar", 2, 3)

    conjuntoSetMutavel.add(1)
    conjuntoSetMutavel.add(10)
    conjuntoSetMutavel.add("Cesar")
    conjuntoSetMutavel.addAll(conjuntoSet)
    //println(conjuntoSetMutavel)
    conjuntoSetMutavel.size

    val mapaDeValoresNaoMutavel = mapOf("Chave" to "Cesar", 2 to "Eduardo", 3 to true)
    val mapaDeValoresMutavel = mutableMapOf("Chave" to "Cesar", 2 to "Eduardo", 3 to true)

    mapaDeValoresMutavel.set("1", "Mariana")
    mapaDeValoresMutavel[1] = "Jonathas"

    //println(mapaDeValoresMutavel[1])
    //println(mapaDeValoresMutavel.get("Cesar"))
    mapaDeValoresMutavel.set(2 to 4, "Cesar")
    mapaDeValoresMutavel[5..10] = "Cesar"

    //println(mapaDeValoresMutavel)

    mapaDeValoresMutavel[6] = "Alexandre"

    //println(mapaDeValoresMutavel.get(Pair(2, 4)))

    //println(mapaDeValoresMutavel)

    //println(mapaDeValoresMutavel[6])

    mapaDeValoresMutavel.forEach {
        //println(it)
    }

    //println(mapaDeValoresMutavel.keys)
    //println(mapaDeValoresMutavel.values)

    println(mapaDeValoresMutavel.containsKey("Chave"))
    println(mapaDeValoresMutavel.containsValue("Cesar"))
    println(mapaDeValoresMutavel.contains(2 to 4))
    mapaDeValoresMutavel.put("2", 2)

    val cliente = Cliente()
    val caixa = mutableMapOf("023812930" to cliente)
    caixa["023812930"]
    //                0  1  2  3
    val list = listOf(1, 1, 1, 2, 2, 3, 1, 3, 1)
    //println(list.indexOfFirst { it % 2 == 0 && it != 2 })
    //println(list.indexOf(2))

    val bob = Person("Bob", 31)
    val bob2 = Person("Bob", 31)
    val people = mutableListOf(Person("Adam", 20), bob, bob)
    val pessoas = listOf(Person("Adam", 20), Person("Bob", 31), bob)

//    if (bob == people[1]) {
//        println("verdadeiro")
//    } else {
//        println("falso")
//    }
//    if (people == pessoas) {
//        println("verdadeiro")
//    } else {
//        println("falso")
//    }

    people.removeAt(1)
    //println(people)

    val numeros = mutableListOf(1, 2, 3, 3, 3, 4, 6)
    //numeros.removeAt(3)
    numeros.removeAll(2..4)
    //println(numeros)

    val conjuntoA = setOf(1, 2, 3, 4)
    val conjuntoB = setOf(4, 3, 2, 1)

//    if (conjuntoA == conjuntoB) {
//        println("verdadeiro")
//    }
    if (conjuntoA.contains(5)) {
        //println("Contem o elemento 5")
    } else {
        //println("Nao Contem o elemento 5")
    }

    val numerosTeste = listOf(1, 2, 4, 5)

    val conjuntoNaoMutavel = setOf(1, 3, 3, 2, 1)
    println(conjuntoNaoMutavel)
    val conjuntoMutavel = mutableSetOf(2, 1, 4, 3, 4, 1)

    val mapNaoMutavel = mapOf(1 to "Cesar", 2 to "Vinicius", 3 to "Edu")

    val listMatrix = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
    )



    mapNaoMutavel.forEach {
        println("A chave é ${it.key} e o valor ${it.value}")
    }

    listaMutavel.forEachIndexed { chave, valor ->

    }

    mapNaoMutavel.forEach { x, y ->
        println("A chave é $x e o valor $y")
    }

    for ((chave, valor) in mapNaoMutavel) {
        println("A chave é $chave e o valor $valor")
    }
}

class Person(nome: String, idade: Int)

class Pessoa(nome: String, idade: Int)

class Cliente()

class Animal()
