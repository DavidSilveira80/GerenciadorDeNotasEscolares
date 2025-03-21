class Gerenciador {
    val alunos = mutableListOf<Aluno>()

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
        aluno.adicionarNota(nota)
    }

    fun listarAlunos(){
        for(aluno in alunos){
            println(aluno.toString())
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
}
