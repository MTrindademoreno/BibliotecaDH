class Biblioteca(var nome: String, var dataDeCriaçao: Int) {

    var mapLivros: MutableMap<Int, Livro> = mutableMapOf()
    var mapColeçoes: MutableMap<Int, Coleção> = mutableMapOf()
    var alugado = 0
    var disponivel = 0
    var vendido = 0
    var soma = 0.0


    fun cadastrarLivro(livro: Livro) {
        var codigo = livro.codigo
        mapLivros[codigo] = livro
        disponivel++


    }

    fun cadastrarColeção(coleção: Coleção) {
        var codigoc = coleção.código
        mapColeçoes[codigoc] = coleção
        codigoc++

    }

    fun consultaLivro(id: Int) {

        if (mapLivros[id] != null && mapLivros.contains(id)) {
            println("Codigo: ${id}")
            println("Titulo :${mapLivros[id]?.titulo}")
            println("Autor: ${mapLivros[id]?.autor}")
            println("Ano:${mapLivros[id]?.anoLançamento}")
            println("Valor de Venda:${mapLivros[id]?.preçoDeVenda}")
            println("Valor do Aluguel: ${mapLivros[id]?.preçoAluguel}")
            println("Status: ${mapLivros[id]?.estadoDAV}")
        } else {
            println("Livro não encontrado")
        }


    }

    fun consultaColeçao(id: Int) {
        if (mapColeçoes[id] != null && mapColeçoes.contains(id)) {
            println("Codigo: ${id}")
            println("Titulo :${mapColeçoes[id]?.titulo}")
            println("Autor: ${mapColeçoes[id]?.autor}")
            println("Ano:${mapColeçoes[id]?.anoLançamento}")
            println("Valor de Venda:${mapColeçoes[id]?.preçoDeVenda}")
            println("Valor do Aluguel: ${mapColeçoes[id]?.preçoAluguel}")
            println("Status: ${mapColeçoes[id]?.EstadoAtual}")

            mapColeçoes[id]?.listaLivros?.forEach {
                println("${it.titulo}")

            }
        } else {
            println("Coleção não encontrada")
        }


    }


    fun alugarLivro(id: Int) {

        if (mapLivros != null && mapLivros.contains(id)) {
            mapLivros[id]?.estadoDAV = Estado.ALUGADO
            disponivel--
            alugado++
        }


    }


    fun devolverLivro(id: Int) {
        if (mapLivros != null && mapLivros.contains(id)) {
            mapLivros[id]?.estadoDAV = Estado.DISPONIVEL
            alugado--
            disponivel++
        }
    }

    fun vendaLivro(id: Int) {
        if (mapLivros != null && mapLivros.contains(id)) {
            mapLivros[id]?.estadoDAV = Estado.VENDIDO
            disponivel--
            vendido++
        } else {
            println("Código inválido")
        }
    }

    fun vendaColeçao(id: Int) {
        if (mapColeçoes != null && mapColeçoes.contains(id)) {
            mapColeçoes[id]?.EstadoAtual
        }
    }

    fun estoque(){
        if(mapLivros!=null){
            mapLivros.values.forEach {
                soma += it.preçoDeVenda
            }

        }
        println("Livros Disponiveis: ${disponivel}")
        println("livros Alugados:${alugado}")
        println("Livros Vendidos: ${vendido}")
        println("Valor total dos Livros: ${soma}")

    }


}