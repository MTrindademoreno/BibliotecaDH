fun main() {
    val livro = Livro(123, "o Livro", "jonh hoo", 1934, 100.0, 10.0, Estado.DISPONIVEL)
    val livro1 = Livro(122, "A arte da guerra", "xxxxxx", 1950, 150.0, 15.0, Estado.DISPONIVEL)
    val livro3 = Livro(121, "o Pequeno Principe", "yyyyyy", 1890, 200.0, 20.0, Estado.DISPONIVEL)
    val livro4 = Livro(124, "Fogo no Parquinho", "desconhecido", 1500, 500.0, 50.0, Estado.DISPONIVEL)
    val livro5vol1 = Livro(1201, "Quinto1", "JJJ", 2010, 110.0, 11.0, Estado.DISPONIVEL)
    val livro5vol2 = Livro(1202, "Quinto2", "JJJ", 2011, 110.0, 11.0, Estado.DISPONIVEL)
    val livro5vol3 = Livro(1203, "Quinto3", "JJJ", 2012, 110.0, 11.0, Estado.DISPONIVEL)
    var coleção1 = Coleção(
        1204,
        "Quinto",
        "JJJ",
        2012,
        110.0,
        11.0,
        Estado.DISPONIVEL,
        mutableListOf(livro5vol1, livro5vol2, livro5vol3)
    )
    val gv = Biblioteca("Livreiro", 10091988)
    val cliente =Cliente("Marcio",29442968)
    val funcionario=Funcionario("iuri",1234)

    with(gv) {
        cadastrarLivros(livro)
        cadastrarLivros(livro1)
        cadastrarLivros(livro3)
        cadastrarLivros(livro4)
        mostraLivros("o Livro")
        cadastrarColeção(coleção1)
        mostraLivros(123)
        alugar(123,"Livro",cliente,funcionario)
        devolver(123,"Livro",10,cliente, funcionario)
        vender(121,"Livro",cliente, funcionario)
        estoque()
        hcliente(29442968)
        hfunc(1234)

    }



}

