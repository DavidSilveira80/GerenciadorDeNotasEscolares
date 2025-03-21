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

fun verificaSeOptValida(opt: String): Boolean{
    return !("12345".contains(opt))
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
            if(verificaSeOptValida(opt)){
                println("Por favor insira uma opção válida.")
            }
        }while(verificaSeOptValida(opt))

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
                    if(gerenciador.verificaTamanhoListaNotas(aluno.getNotas())){
                        println("TODAS AS NOTAS FORAM LANÇADAS")
                    }else{

                        print("Informe a nota do Aluno(Entre 0.0 e 10.0): ")
                        try {
                            val nota = readln().toDouble()
                                gerenciador.adicionarNota(aluno, nota)
                        } catch (e: NumberFormatException){
                            println("Por favor, insira um valor numérico válido.")
                        }
                    }
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

            "5" -> {
                println("ENCERRANDO SISTEMA.")
                continuarFluxo = false
            }
        }
    }
}
