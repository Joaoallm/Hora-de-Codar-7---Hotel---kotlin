
package hotel

// Inicialize a lista de quartos globalmente
 // Lista para armazenar os números dos quartos

fun cadastrarQuartos() {
    var diaria: Int
    var dias: Int
    var nome: String

    // Preenche a lista de quartos com números de 1 a 20 (se ainda não tiver sido preenchida)
    if (quartos.isEmpty()) {
        for (i in 1..20) {
            quartos.add(i)
        }
    }

    // Valida a diária
    while (true) {
        println("Qual o valor da diária?")
        diaria = readln().toIntOrNull() ?: -1 // Garante que a entrada seja válida
        if (diaria <= 0) {
            println("Valor inválido, tente novamente.")
            continue
        }
        break // Sai do loop quando a entrada for válida
    }

    // Valida os dias de hospedagem
    while (true) {
        println("Quantos dias de hospedagem?")
        dias = readln().toIntOrNull() ?: -1 // Garante que a entrada seja válida
        if (dias <= 0 || dias > 30) {
            println("Valor inválido, por favor insira um número entre 1 e 30.")
            continue
        }
        break // Sai do loop quando a entrada for válida
    }

    // Calcula e exibe o valor total da hospedagem
    val valortotal = diaria * dias
    println("O valor total da hospedagem é: R$ $valortotal")

    // Solicita o nome do hóspede
    println("Qual o nome do hóspede?")
    nome = readln()
    println("Hóspede: $nome")

    // Exibe a lista de quartos disponíveis
    println("Lista de quartos disponíveis:")
    println(quartos)

    // Solicita o número do quarto desejado
    println("Escolha um número de quarto:")
    val numeroEscolhido = readln().toIntOrNull()

    if (numeroEscolhido != null) {
        val indice = quartos.indexOf(numeroEscolhido)
        if (indice != -1) {
            quartos[indice] = "Ocupado" // Marca o quarto como ocupado com -1 (ou substitua por "ocupado" se preferir)
            println("Quarto $numeroEscolhido agora está ocupado.")
        } else {
            println("Quarto não encontrado ou já ocupado.")
        }
    } else {
        println("Entrada inválida.")
        return // Encerra a função se a entrada for inválida
    }

    println("Quartos disponíveis atualizados: $quartos")

    // Confirmação da reserva
    println("$nome, você confirma a hospedagem por $dias dias no quarto $numeroEscolhido por R\$$valortotal? S/N")
    val confirmacao = readln()
    if (confirmacao.equals("s", ignoreCase = true)) {
        println("$nome, reserva efetuada com sucesso!")
    } else {
        println("Reserva não confirmada. Reiniciando cadastro.")
        cadastrarQuartos() // Reinicia o cadastro
    }
}