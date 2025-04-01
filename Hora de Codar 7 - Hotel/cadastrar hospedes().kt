package hotel

import kotlin.system.exitProcess

fun cadastrarHospedes() {
    val listaHospedes = mutableListOf(
        "Carlos Villagran",
        "Maria Antonieta de las Nieves",
        "Roberto Gómez Bolaños",
        "Florinda Meza",
        "Ramón Valdés",
        "Rubén Aguirre",
        "Angelines Fernández",
        "Edgar Vivar",
        "Horácio Gómez Bolaños",
        "Raúl Padilla"
    )

    while (true) {
        println(
            """Cadastro de Hóspedes
            Selecione uma opção:
            1. Cadastrar
            2. Pesquisar
            3. Listar
            4. Sair"""
        )

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarNovoHospede(listaHospedes)
            2 -> pesquisarHospede(listaHospedes)
            3 -> listar(listaHospedes)
            4 -> sairCadastroDeHospedes()
            else -> erroCadastroDeHospedes()
        }
    }
}

fun cadastrarNovoHospede(listaHospedes: MutableList<String>) {
    if (listaHospedes.size < 15) {
        println("Cadastro de Hóspedes.\nPor favor, informe o nome da Hóspede:")
        val novoHospede = readln()
        listaHospedes.add(novoHospede)
        println("$novoHospede cadastrada com sucesso!")
        println("Lista de Hóspedes atuais $listaHospedes")
    } else {
        println("A lista está cheia chefão")
    }
}

fun pesquisarHospede(listaHospedes: MutableList<String>) {
    println("Pesquisa de Hóspedes.\nPor favor, informe o nome da Hóspede:")
    val nomeHospede = readln()

    if (listaHospedes.any { it.contains(nomeHospede, ignoreCase = true) }) {
        println("\nEncontramos a(s) hóspede(s):")
        listaHospedes.filter { it.contains(nomeHospede, ignoreCase = true) }
            .forEach { println(it) }
    } else {
        println("Não encontramos nenhuma hóspede com esse nome.")
    }
}

fun listar(listaHospedes: MutableList<String>) {
    println("Lista de Hóspedes um a um:")
    for (nomeHospede in listaHospedes) {
        println(nomeHospede)
    }
}

fun sairCadastroDeHospedes() {
    println("Você deseja sair? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        "S" -> {
            println("Hasta la vista, Baby.")
            exitProcess(0)
        }
        "N" -> {
            println("Ok, voltando ao início.")
            cadastrarHospedes()
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeHospedes()
        }
    }
}

fun erroCadastroDeHospedes() {
    println("Por favor, informe um número entre 1 e 4.")
}