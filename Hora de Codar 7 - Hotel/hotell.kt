package hotel

var nome = ""

val quartos = mutableListOf<Any>()
fun main() {
    print("Bem vindo ao Hotel Johny Johny, é um imenso prazer ter você aqui!\n")
    println("Qual o seu nome?")
     nome = readln()
    // Função principal que chama a função inicio().
    iniciar()
}
var diaria = Int
var dias = Int
fun senha() {
    println("Informe a senha: ")
    val senha = readln().toInt()
    if (senha != 2678) {
        println("Senha incorreta, tente novamente")
        senha()
    }
    else{
        opcoes()
    }
}
fun iniciar(){
        senha()
    }


    // A varival escolha armazena a opção escolhida pelo usuário.
    // uma variavel local é utilizada apenas dentro da função inicio().


fun opcoes() {
    println("Escolha uma opção:\n 1. Cadastras Quartos \n2. Cadastras Hospedes \n3. Abastecimento de automoveis \n4. inteira Meia Gratuita \n5. Eventos \n6. Sair do hotel")

    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> cadastrarQuartos()
        2 -> cadastrarHospedes()
        3 -> AbastecimentoDeAutomoveis()
        4 -> inteiraMeiaGratuita()
        5 -> Eventos()
        6 -> ManutençaoArCondicionado()
        7 -> sairDoHotel()
        else -> erro()
    }
}





fun sairDoHotel() {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    val confirma = readln().toBoolean() // digite true ou false ou 1 ou 0
    if (confirma) {
        println("Até logo!")
    } else {
        opcoes()
    }
}

fun erro() {
    println("Por favor, informe um número entre 1 e 4.")
    opcoes()
}