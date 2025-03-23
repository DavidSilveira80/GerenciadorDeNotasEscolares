class Gerenciador {
    val alunosMatriculados = mutableListOf<Aluno>()
    val NUMERO_MAXIMO_DE_NOTAS = 4
    var alunosAprovados = mutableListOf<Aluno>()
    var alunosReprovados = mutableListOf<Aluno>()
    // VALIDAÇÕES


    // VERIFICAÇÕES

    fun verificaSeListaAlunosHeVazia(): Boolean {
        return alunosMatriculados.isEmpty()
    }

    fun verificaSeMatriculaJaExiste(matricula: String): Boolean {
        return alunosMatriculados.any { it.matricula == matricula }
    }

    fun verificaSeNomeSeRepete(nome: String): Boolean {
        return alunosMatriculados.any { it.nome == nome }
    }

    fun verificaTamanhoListaNotas(notas: List<Double>): Boolean {
        return notas.size == NUMERO_MAXIMO_DE_NOTAS
    }


    // FUNCIONALIDADES

    fun cadastrarAluno(nome: String, matricula: String) {
        alunosMatriculados.add(Aluno(nome, matricula))
    }

    fun buscarAlunoComBaseNaMatricula(matricula: String): Aluno? {
        return alunosMatriculados.find { it.matricula == matricula }
    }

    fun adicionarNota(aluno: Aluno, nota: Double) {
        aluno.adicionarNota(nota)
    }

    fun listarAlunos() {
        for (aluno in alunosMatriculados) {
            println(" ${aluno.nome} ${aluno.getNotas()}")
        }
    }

    fun computarAlunosAprovadosEReprovados() {
        if (alunosMatriculados.all { it.getNotas().size == NUMERO_MAXIMO_DE_NOTAS }) {
            for(aluno in alunosMatriculados){
                aluno.calculaMedia()
            }
            filtrarAlunosAprovados()
            filtrarAlunosReprovados()
        } else {
            println("Ainda faltam notas à serem lançadas para computar os resultados.")
        }
    }

    // FILTROS

    fun filtrarAlunosAprovados(){
        for (aluno in alunosMatriculados) {
            if (aluno.getMedia() >= 7.0) {
                alunosAprovados.add(aluno)
            }
        }

    }

    fun filtrarAlunosReprovados(){
        for (aluno in alunosMatriculados) {
            if (aluno.getMedia() < 7.0) {
                alunosReprovados.add(aluno)
            }
        }
    }

    // GERADORES

    fun gerarRelatorio() {

        println("----- RELATÓRIO DE NOTAS ----- ")
        println("**ALUNOS APROVADOS:**")
        for (aprovado in alunosAprovados) {
            println("- ${aprovado.nome.uppercase()} -> MÉDIA: ${aprovado.getMedia()}")
        }
        println()
        println()
        println("**ALUNOS REPROVADOS:**")
        for (reprovado in alunosReprovados) {
            println("- ${reprovado.nome.uppercase()} -> MÉDIA: ${reprovado.getMedia()}")
        }
    }
}
