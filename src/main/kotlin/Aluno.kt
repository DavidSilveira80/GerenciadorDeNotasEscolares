class Aluno(val nome: String, val matricula: String) {
    private var notas = mutableListOf<Double>()

    fun getNotas(): List<Double>{
        return notas.toList()
    }

    fun adicionarNota(nota: Double){
        if(nota in 0.0..10.0){
            notas.add(nota)
        }else{
            println("Nota fora da faixa de 0.0 e 10.0")
        }

    }

    fun calculaMedia(): Double{
        return notas.sum() / notas.size
    }

    override fun toString(): String {
        return "Aluno(nome='$nome', matricula='$matricula', notas=$notas)"
    }
}
