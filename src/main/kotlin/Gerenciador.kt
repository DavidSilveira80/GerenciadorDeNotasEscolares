class Gerenciador {
    val alunos = mutableListOf<Aluno>()
    val NUMERO_MAXIMO_DE_NOTAS = 4
    var aprovados = mutableListOf<Aluno>()
    var reprovados = mutableListOf<Aluno>()
    // VALIDAÇÕES


    // VERIFICAÇÕES

    fun verificaSeListaAlunosHeVazia(): Boolean {
        return alunos.isEmpty()
    }

    fun verificaSeMatriculaJaExiste(matricula: String): Boolean {
        return alunos.any { it.matricula == matricula }
    }

    fun verificaSeNomeSeRepete(nome: String): Boolean {
        return alunos.any { it.nome == nome }
    }

    fun verificaTamanhoListaNotas(notas: List<Double>): Boolean {
        return notas.size == NUMERO_MAXIMO_DE_NOTAS
    }


    // FUNCIONALIDADES

    fun cadastrarAluno(nome: String, matricula: String) {
        alunos.add(Aluno(nome, matricula))
    }

    fun buscarAlunoComBaseNaMatricula(matricula: String): Aluno? {
        return alunos.find { it.matricula == matricula }
    }

    fun adicionarNota(aluno: Aluno, nota: Double) {
        aluno.adicionarNota(nota)
    }

    fun listarAlunos() {
        for (aluno in alunos) {
            println(" ${aluno.nome} ${aluno.getNotas()}")
        }
    }

    fun computarAlunosAprovadosEReprovados() {
        if (alunos.all { it.getNotas().size == NUMERO_MAXIMO_DE_NOTAS }) {
            filtrarAlunosAprovados()
            filtrarAlunosReprovados()
        } else {
            println("Ainda faltam notas à serem lançadas para computar os resultados.")
        }
    }

    // FILTROS

    fun filtrarAlunosAprovados(){
        for (aluno in alunos) {
            if (aluno.calculaMedia() >= 7.0) {
                aprovados.add(aluno)
            }
        }

    }

    fun filtrarAlunosReprovados(){
        for (aluno in alunos) {
            if (aluno.calculaMedia() < 7.0) {
                reprovados.add(aluno)
            }
        }
    }

    // GERADORES

    fun gerarRelatorio() {

        println("----- RELATÓRIO DE NOTAS ----- ")
        println("**ALUNOS APROVADOS:**")
        for (aprovado in aprovados) {
            println("- ${aprovado.nome.uppercase()} -> MÉDIA: ${aprovado.getMedia()}")
        }
        println()
        println()
        println("**ALUNOS REPROVADOS:**")
        for (reprovado in reprovados) {
            println("- ${reprovado.nome.uppercase()} -> MÉDIA: ${reprovado.getMedia()}")
        }

    }

}
