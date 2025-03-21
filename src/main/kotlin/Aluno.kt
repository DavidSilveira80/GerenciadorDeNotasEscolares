class Aluno(val nome: String, val matricula: String) {
    var notas = mutableListOf<Double>()

    fun calculaMedia(): Double{
        return if(notas.isEmpty()){
            0.0
        }else {
            notas.sum() / notas.size
        }
    }
}
