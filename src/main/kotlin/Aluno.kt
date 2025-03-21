class Aluno(val nome: String, val matricula: String) {
    var notas = mutableListOf<Double>()

    fun adicionarNota(nota: Double){
        notas.add(nota)
    }

    fun calculaMedia(): Double{
        return if(notas.isEmpty()){
            0.0
        }else {
            notas.sum() / notas.size
        }
    }

    override fun toString(): String {
        return "Aluno(nome='$nome', matricula='$matricula', notas=$notas)"
    }
}
