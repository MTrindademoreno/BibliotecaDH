class Coleção (
    var código: Int ,
    var titulo:String,
    var autor: String,
    var anoLançamento: Int,
    var preçoDeVenda: Double,
    var preçoAluguel: Double,
    var estado:Estado,
    var listaDeLivros:MutableList<Livro>
    ){

}