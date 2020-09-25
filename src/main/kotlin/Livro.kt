open class Livro(
    var codigo:Int,
            var titulo:String,
            var autor:String,
            var anoLançamento:Int,
            var preçoDeVenda:Double,
            var preçoAluguel:Double,
            var estado:Estado=Estado.DISPONIVEL
) {

}