package hotel
import kotlin.math.ceil
var empresa : String = ""
var diaSemana : String = ""
var horario : Int = 0

fun Eventos() {
    println("Qual o número de convidados para o seu evento?")
    val numConvidados = readln().toInt()
    if (numConvidados <= 0) {
        println("Número inválido. Por favor, insira um valor maior que 0.")
    }
    val auditorio = when {
        numConvidados <= 150 -> {
             "auditorio laranja"
        }

        numConvidados <= 220 -> {
            val cadeirasExtras = (numConvidados - 150).coerceAtMost(70) // Limitar a no máximo 70 cadeiras extras
            " auditorio laranja, inclua $cadeirasExtras cadeiras"
        }

        numConvidados <= 350 -> {
            "Use o auditorio colorado"
        }

        else -> {
            "Quantidade de convidados superior à capacidade máxima"
        }
    }
    println("\nEvento no $auditorio")

    if (numConvidados > 350) {
        println("Quantidade de convidados superior à capacidade máxima")
        Eventos()
    }
    while (true) {
        println("Qual o dia do seu evento?")
        diaSemana = readln()

        println("Qual a hora do seu evento?")
        horario = readln().toInt()
        if (diaSemana == "sabado" || diaSemana == "domingo") {
            if (horario !in 7..15) {
                println("Auditorio indisponivel")
                continue
            }
        } else {
            println("Qual o nome da empresa?")
            empresa = readln()

            println("auditorio reservado para $empresa. $diaSemana-feira ás $horario horas")
            break
        }

    }
    println("Qual a duração do evento em horas?")
    val duracaoEvento = readln().toInt()
    val garcomAdicional = duracaoEvento / 2


    val garconsNecessarios = ceil(numConvidados / 12.0).toInt() + garcomAdicional
    val custo = ceil(garconsNecessarios * 10.50).toInt()
    println("São necessarios $garconsNecessarios garçons")
    println("\nCusto: $custo")
    println("\nAgora vamos calcular o custo do buffet do hotel para o evento.")

    val cafe = numConvidados * 0.80
    val agua = numConvidados * 0.40
    val salgado = (numConvidados * 34) / 7

    println("\nO evento precisará de $cafe litros de café, $agua litros de água, $salgado salgados.")

    println(
        "\nRelatório" +
                "\nEvento no $auditorio" +
                "\nNome da empresa: $empresa" +
                "\nData: $diaSemana,das $horario horas ás ${horario+duracaoEvento} horas" +
                "\nDuraçao do evento: $duracaoEvento horas" +
                "\nQuantidade de garçons: $garconsNecessarios" +
                "\nQuantidade de Convidados: $numConvidados" +
                "" +
                "\nCusto do garçons: R$$custo,00" +
                "\nCusto do Buffet: R$${cafe + agua + salgado},00" +
                "" +
                "\nValor total do Evento: R$${custo + (cafe + agua + salgado)}"
    )

    println("Gostaria de efetuar a reserva?")
    val confirmaçao = readln()
    if (confirmaçao == "s") {
        println("$nome, reserva efetuada com sucesso")
    }
    else{
        println("Reserva não efetuada")
    }
}