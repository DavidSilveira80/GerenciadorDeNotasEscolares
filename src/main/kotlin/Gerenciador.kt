class Gerenciador {
    val alunos = mutableListOf<Aluno>()

    fun cadastrarAluno(nome: String, matricula: String){
        alunos.add(Aluno(nome, matricula))
    }

    fun adicionarNota(aluno: Aluno, nota: Double){
        aluno.adicionarNota(nota)
    }

    fun listarAlunos(){
        for(aluno in alunos){
            println(aluno.toString())
        }
    }
}
