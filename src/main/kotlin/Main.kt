fun main(){
    val livro = Livro(123,"o Livro","jonh hoo",1934,100.0,10.0,Estado.DISPONIVEL)
    val livro1 = Livro(122,"A arte da guerra","xxxxxx",1950,150.0,15.0,Estado.DISPONIVEL)
    val livro3 = Livro(121,"o Pequeno Principe", "yyyyyy",1890,200.0,20.0,Estado.DISPONIVEL)

    val biblioteca= Biblioteca("Livraria",17091978)
    biblioteca.cadastrarLivro(livro)
    biblioteca.cadastrarLivro(livro1)
    biblioteca.cadastrarLivro(livro3)




//    biblioteca.consultaLivro(1)
//    biblioteca.alugarLivro(1)
//    biblioteca.consultaLivro(2)


    val lista = mutableListOf(livro,livro1,livro3)
    val coleção1 = Coleção(345,"cole","joao",1900,100.0,10.0,Estado.DISPONIVEL,lista)

    biblioteca.cadastrarColeção(coleção1)


    biblioteca.consultaColeçao(345)

    biblioteca.vendaLivro(9)
    biblioteca.estoque()
}