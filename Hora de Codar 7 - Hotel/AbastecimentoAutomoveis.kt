package hotel

fun AbastecimentoDeAutomoveis() {

    println("Qual o valor do alcool no posto Wayne Oil?")
    val AlcoolWayne = readln().toDouble()

    println("Qual o valor da gasolina no posto Wayne Oil?")
    val GasolinaWayne = readln().toDouble()

    println("Qual o valor do alcool no posto Stark?")
    val AlcoolStark = readln().toDouble()

    println("Qual o valor da gasolina no posto Stark?")
    val GasolinaStark = readln().toDouble()

    // regra: alcool so compensa se for 30% mais barato que a gasolina
    val alcoolCompensaWayne = AlcoolWayne <= GasolinaWayne * 0.7
    val alcoolCompensaStark =  AlcoolStark <=  GasolinaStark * 0.7

    // Calculando o custo total para abastecer 42 litros
    val custoAlcoolWayne = AlcoolWayne * 42
    val custoGasolinaWayne = GasolinaWayne * 42
    val custoAlcoolStark = AlcoolStark * 42
    val custoGasolinaStark = GasolinaStark * 42

    if (alcoolCompensaWayne && custoAlcoolWayne <= custoAlcoolStark){
        println("É mais barato abastecer com alcool no posto Wayne Oil")
    }
    else if (alcoolCompensaStark && custoAlcoolStark < custoAlcoolWayne){
        println("É mais barato abastecer com alcool no posto Stark Petroil")
    }
    else if (custoGasolinaWayne <= custoGasolinaStark) {
        println("É mais barato abastecer com Gasolina no posto Wayne Oil")
    }
    else{
        println("É mais barato abastecer com gasolina no posto Stark Petroil")
    }
    }

//Valores fornecidos:
//Álcool Wayne: 7.0
//
//Gasolina Wayne: 9.0
//
//Álcool Stark: 6.50
//
//Gasolina Stark: 9.10
//
//Cálculos:
//Regra do álcool ser 30% mais barato que a gasolina:
//
//Wayne:
//7.0≤(9.0×0.7)
//
//7.0≤6.3 ➡️ Falso
//
//Stark:
//6.50≤(9.10×0.7)
//
//6.50 ≤ 6.37➡️ Falso
//
//Em ambos os postos, o álcool não compensa em relação à gasolina.
//
//Custo total para abastecer 42 litros:
//
//Wayne (álcool):
//7.0×42= 294.0
//
//Wayne (gasolina):
//9.0×42= 378.0
//
//Stark (álcool):
//6.50×42= 273.0
//
//Stark (gasolina):
//9.10×42= 382.2
//
//Comparação dos custos:
//
//Álcool não compensa em nenhum dos postos.
//
//Gasolina Wayne (378.0) é mais barata que Gasolina Stark (382.2).
//É mais barato abastecer com Gasolina no posto Wayne Oil