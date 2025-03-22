class Aluno(val nome: String, val matricula: String) {
    private var notas = mutableListOf<Double>()
    private var media = 0.0

    fun getNotas(): List<Double>{
        return notas.toList()
    }

    fun getMedia(): Double{
        return media
    }

    fun adicionarNota(nota: Double){
        if(nota in 0.0..10.0){
            notas.add(nota)
        }else{
            println("Nota fora da faixa de 0.0 e 10.0")
        }

    }

    fun calculaMedia(): Double{
        if(notas.isEmpty()){
            return 0.0
        }else{
            media = notas.sum() / notas.size
            return notas.sum() / notas.size
        }
    }

    override fun toString(): String {
        return "Aluno(nome='$nome', matricula='$matricula', notas=$notas)"
    }
}
