class Gerenciador {
    val alunos = mutableListOf<Aluno>()
    val NUMERO_MAXIMO_DE_NOTAS = 4

    // VALIDAÇÕES


    // VERIFICAÇÕES

    fun verificaSeListaAlunosHeVazia(): Boolean{
        return alunos.isEmpty()
    }

    fun verificaSeMatriculaJaExiste(matricula: String): Boolean{
        return alunos.any{it.matricula == matricula}
    }

    fun verificaSeNomeSeRepete(nome: String): Boolean{
        return alunos.any{it.nome == nome}
    }

    fun verificaTamanhoListaNotas(notas: List<Double>): Boolean{
        return notas.size == NUMERO_MAXIMO_DE_NOTAS
    }


    // FUNCIONALIDADES

    fun cadastrarAluno(nome: String, matricula: String){
        alunos.add(Aluno(nome, matricula))
    }

    fun buscarAlunoComBaseNaMatricula(matricula: String): Aluno?{
        return alunos.find { it.matricula == matricula }
    }

    fun adicionarNota(aluno: Aluno, nota: Double){
            aluno.adicionarNota(nota)
    }

    fun listarAlunos(){
        for(aluno in alunos){
            println(" ${aluno.nome} ${aluno.getNotas()}")
        }
    }

    // FILTROS

    fun filtrarAlunosAprovados(): List<Aluno>{
        val aprovados : List<Aluno> = alunos.filter { it.calculaMedia() >= 7.0 }
        return aprovados
    }

    fun filtrarAlunosReprovados(): List<Aluno>{
        val reprovados : List<Aluno> = alunos.filter { it.calculaMedia() < 7.0 }
        return reprovados
    }

    // GERADORES

    fun gerarRelatorio(){
        if(alunos.all { it.getNotas().size == NUMERO_MAXIMO_DE_NOTAS }){
            val aprovados = filtrarAlunosAprovados()
            val reprovados = filtrarAlunosReprovados()

            println("----- RELATÓRIO DE NOTAS ----- ")
            println("**ALUNOS APROVADOS:**")
            for(aprovado in aprovados){
                println("- ${aprovado.nome.uppercase()} -> MÉDIA: ${aprovado.getMedia()}")
            }
            println()
            println()
            println("**ALUNOS REPROVADOS:**")
            for(reprovado in reprovados){
                println("- ${reprovado.nome.uppercase()} -> MÉDIA: ${reprovado.getMedia()}")
            }
        }else{
            println("Ainda faltam notas à serem lançadas para gerar relatório.")
        }
    }
}
