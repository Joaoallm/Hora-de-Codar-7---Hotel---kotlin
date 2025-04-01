package hotel
data class registro(val hospede: String, val idade: Int)
    val hospedagens = mutableListOf<registro>()
fun inteiraMeiaGratuita() {
    var totalGratuidade = 0
    var totalMeias = 0
    var totalValor = 0
    println("Qual o valor padrão da diaria?")
    val diaria = readln().toIntOrNull()
    if (diaria == null || diaria <= 0) {
        println("Valor da diária inválido. O programa será encerrado.")
        return
    }

    while (true) {
        println("Qual o nome do Hóspede?")
        val hospede = readln()

        println("Qual a idade do hóspede?")
        val idade = readln().toIntOrNull()

        if (idade != null) {
            when {
                idade <= 6 -> {
                    totalGratuidade++
                    println("$hospede cadastrado com sucesso. $hospede possui gratuidade.")
                }

                idade >= 60 -> {
                    totalMeias++
                    totalValor += diaria / 2
                    println("$hospede cadastrado com sucesso. $hospede paga meia: R\$${diaria / 2}.")

                }

                else -> {
                    totalValor += diaria
                    println("$hospede cadastrado com sucesso. $hospede paga o valor integral: R\$$diaria.")

                }
            }
            hospedagens.add(registro(hospede, idade)) // Adiciona o hóspede à lista de registros
        } else {
            println("Idade inválida. Tente novamente.")
            continue
        }

        println("Se deseja parar, digite 'pare'. Caso contrário, pressione Enter para continuar.")
        val pare = readln()
        if (pare.equals("pare", ignoreCase = true)) {
            println("Relatório final:")
            println(
                "O valor total das hospedagens é:$totalValor, $totalGratuidade gratuidade, $totalMeias meia"
                )

            break // Encerra o loop aqui
        }
    }
}
// Quando você pressiona Enter, o método readln() retorna uma string vazia ("").
//
//No caso da pergunta sobre idade,
// o código tenta converter essa entrada para um número (readln().toIntOrNull()),
// mas uma string vazia não pode ser convertida.
// Isso faz com que a variável idade seja null.
//
//Quando idade == null, o código entra no bloco:
//

//println("Idade inválida. Tente novamente.")
//continue

//Isso força o programa a retornar para o início
// do loop e refazer as perguntas.