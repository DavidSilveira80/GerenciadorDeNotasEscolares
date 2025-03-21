fun menuPrincipal(){
    println("------------------------------------")
    println("   GERENCIADOR DE NOTAS ESCOLARES   ")
    println()
    println("      1 - CADASTRAR ALUNO           ")
    println("      2 - ADICIONAR NOTA            ")
    println("      3 - GERAR RELATÓRIO           ")
    println("      4 - LISTAR ALUNOS             ")
    println("      5 - SAIR                      ")
    println("------------------------------------")
}


fun main(){
    var paradaDeFluxo = "C"
    var opt = ""

    while(paradaDeFluxo == "C"){
        do{
            menuPrincipal()
            print("-> ")
            opt = readln()
        }while(opt != "1" && opt != "2" && opt != "3" && opt != "4" && opt != "5")

        when(opt){
            "1" -> println("CADASTRAR ALUNO")
            "2" -> println("ADICIONAR NOTA")
            "3" -> println("GERAR RELATÓRIO")
            "4" -> println("LISTAR ALUNOS")
            "5" -> paradaDeFluxo = "S"
        }
    }
}
