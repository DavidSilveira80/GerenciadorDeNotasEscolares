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
    val gerenciador = Gerenciador()

    var continuarFluxo = true
    var opt = ""

    while(continuarFluxo){
        do{
            menuPrincipal()
            print("-> ")
            opt = readln()
        }while(opt != "1" && opt != "2" && opt != "3" && opt != "4" && opt != "5")

        when(opt){

            "1" -> {
                println("CADASTRAR ALUNO")
                print("Informe o nome completo do Aluno: ")
                val nome = readln()
                print("Informe a matrícula única do Aluno: ")
                val matricula = readln()
                if(gerenciador.verificaSeMatriculaJaExiste(matricula) || gerenciador.verificaSeNomeSeRepete(nome)){
                    println("ALUNO JÁ ESTÁ MATRICULADO.")
                }else{
                    gerenciador.cadastrarAluno(nome, matricula)
                }
            }

            "2" -> {
                println("ADICIONAR NOTA")

                print("Informe a matrícula do Aluno: ")
                val matricula = readln()
                val aluno = gerenciador.buscarAlunoComBaseNaMatricula(matricula)
                if(aluno != null){
                    print("Informe a nota do Aluno: ")
                    val nota = readln().toDouble()
                    gerenciador.adicionarNota(aluno, nota)
                }else{
                    println("ALUNO NÃO MATRICULADO..")
                }
            }

            "3" -> {
                println("GERAR RELATÓRIO.")
                gerenciador.gerarRelatorio()
            }

            "4" -> {
                println("LISTAR ALUNOS.")
                println()
                if(gerenciador.verificaSeListaAlunosHeVazia()){
                    println("NÃO HÁ ALUNOS MATRICULADOS.")
                }else{
                    gerenciador.listarAlunos()
                }
            }

            "5" ->{
                println("ENCERRANDO SISTEMA.")
                continuarFluxo = false
            }
        }
    }
}
