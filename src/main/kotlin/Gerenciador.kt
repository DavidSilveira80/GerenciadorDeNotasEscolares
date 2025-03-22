class Gerenciador {
    val alunos = mutableListOf<Aluno>()
    val NUMERO_MAXIMO_DE_NOTAS = 3

    fun cadastrarAluno(nome: String, matricula: String){
        alunos.add(Aluno(nome, matricula))
    }

    fun verificaSeListaAlunosHeVazia(): Boolean{
        return alunos.isEmpty()
    }

    fun buscarAlunoComBaseNaMatricula(matricula: String): Aluno?{
        return alunos.find { it.matricula == matricula }
    }

    fun adicionarNota(aluno: Aluno, nota: Double){
        if(aluno.notas.size <= NUMERO_MAXIMO_DE_NOTAS){
            aluno.adicionarNota(nota)
        }else{
            println("TODAS AS NOTAS DO ALUNO FORAM LANÇADAS.")
        }
    }

    fun listarAlunos(){
        for(aluno in alunos){
            println(" ${aluno.nome} ${aluno.notas}")
        }
    }

    fun filtrarAlunosAprovados(): List<Aluno>{
        val aprovados : List<Aluno> = alunos.filter { it.calculaMedia() >= 7.0 }
        return aprovados
    }

    fun filtrarAlunosReprovados(): List<Aluno>{
        val reprovados : List<Aluno> = alunos.filter { it.calculaMedia() < 7.0 }
        return reprovados
    }

    fun gerarRelatorio(){
        val aprovados = filtrarAlunosAprovados()
        val reprovados = filtrarAlunosReprovados()

        println("----- RELATÓRIO DE NOTAS ----- ")
        println("**ALUNOS APROVADOS:**")
        for(aprovado in aprovados){
            println("- ${aprovado.nome.uppercase()} -> MÉDIA: ${aprovado.calculaMedia()}")
        }
        println()
        println()
        println("**ALUNOS REPROVADOS:**")
        for(reprovado in reprovados){
            println("- ${reprovado.nome.uppercase()} -> MÉDIA: ${reprovado.calculaMedia()}")
        }
    }
}
