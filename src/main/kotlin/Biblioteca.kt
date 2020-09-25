import java.util.*

class Biblioteca(var nome: String, var dataDeCriaçao: Int) {
    private var listaLivros = hashMapOf<Int, Livro>()
    private var listaColeção = mutableMapOf<Int, Coleção>()
    private var qtddisponivel=0
    private var qtdalugado =0
    private var qtdvendido=0
    private var venda=0.0
    private var locaçao =0.0
    private var locaçaoConcluida=0
    private var operaçoes= mutableListOf<String>()
    private var hcliente= hashMapOf<Int,MutableList<String>>()
    private var hfunc = hashMapOf<Int,MutableList<String>>()
    private val date = Calendar.getInstance().time




    fun cadastrarLivros(livro: Livro) {
        if (!listaLivros.contains(livro.codigo)) {
            listaLivros.put(livro.codigo, livro)
            qtddisponivel++
        }

    }


    fun cadastrarColeção(coleção: Coleção) {
        if (!listaColeção.contains(coleção.código)) {
            listaColeção[coleção.código] = coleção
            qtddisponivel++
        }

    }


    fun mostraLivros(id: String) {
        if (id != "") {
            listaLivros.forEach { (t, u) ->

                if (u.titulo == id) {
                    println("Código do Livro:${t}")
                    println("Titulo -> ${u.titulo} ")
                    println("Autor-> ${u.autor}")
                    println("Ano de Lançamento ->${u.anoLançamento}")
                    println("Preço De Venda -> ${u.preçoDeVenda}")
                    println("Preço do Aluguel -> ${u.preçoAluguel}")
                    println("Estado Atual -> ${u.estado}")
                }
            }
        } else {
            println("Titulo não encontrado")
        }
    }

    fun mostraLivros(id: Int) {
        if (listaLivros.contains(id)) {
            listaLivros.forEach { (t, u) ->
                if (t == id) {
                    println("Código do Livro:${t}")
                    println("Titulo -> ${u.titulo} ")
                    println("Autor-> ${u.autor}")
                    println("Ano de Lançamento ->${u.anoLançamento}")
                    println("Preço De Venda -> ${u.preçoDeVenda}")
                    println("Preço do Aluguel -> ${u.preçoAluguel}")
                    println("Estado Atual -> ${u.estado}")
                }
            }
        } else {
            println("Código não encontrado")
        }
    }


    fun mostraColeção(id: Any) {


        listaColeção.forEach { (t, u) ->
            if (t == id || id == u.titulo) {
                println("Código da coleção:${u.código}")
                println("Titulo -> ${u.titulo} ")
                println("Autor-> ${u.autor}")
                println("Ano de Lançamento ->${u.anoLançamento}")
                println("Preço De Venda -> ${u.preçoDeVenda}")
                println("Preço do Aluguel -> ${u.preçoAluguel}")
                println("Estado Atual -> ${u.estado}")
                println("Livros da Coleção:")
                u.listaDeLivros.forEach {
                    println("Código :${it.codigo}")
                    println("Titulo:${it.titulo}")
                    println("Autor :${it.autor}")
                    println("Ano:${it.anoLançamento}")
                }
            } else {
                println("Coleção não encontrada")
            }

        }
    }

    fun alugar(id: Int, tipo: String,cliente: Cliente,funcionario:Funcionario) {
        when (tipo) {
            "Coleção" -> {
                listaColeção.forEach { (t, u) ->
                    if (id == t && u.estado == Estado.DISPONIVEL) {
                        u.estado = Estado.ALUGADO
                        qtdalugado++
                        qtddisponivel--
                        locaçaoConcluida++
                        operaçoes.add("${date}aluguel Coleção${u.titulo}")
                        hcliente[cliente.rg] = operaçoes
                        hfunc[funcionario.rg] = operaçoes

                    } else {
                        println("Titulo indisponivel para locação")
                    }
                }
            }
            "Livro" -> {
                listaLivros.forEach { (t, u) ->
                    if (id==t && u.estado ==Estado.DISPONIVEL){
                        u.estado =Estado.ALUGADO
                        qtdalugado++
                        qtddisponivel--
                        locaçaoConcluida++
                        operaçoes.add("$date ->aluguel livro :${u.titulo}")
                        hcliente[cliente.rg] = operaçoes
                        hfunc[funcionario.rg] = operaçoes

                    }
                }
            }
            else -> {println("Titulo indisponivel para Locação")}
        }

    }


    fun devolver(id: Int, tipo: String,diasLocados:Int,cliente: Cliente,funcionario: Funcionario) {
        when (tipo) {
            "Coleção" -> {
                listaColeção.forEach { (t, u) ->
                    if (id == t && u.estado == Estado.ALUGADO) {
                        u.estado = Estado.DISPONIVEL
                        qtdalugado--
                        qtddisponivel++
                        locaçao += diasLocados * u.preçoAluguel
                        operaçoes.add("${date}devolução Coleção${u.titulo}")
                        hcliente[cliente.rg] = operaçoes
                        hfunc[funcionario.rg] = operaçoes

                    } else {
                        println("Titulo  não está alugado")
                    }
                }
            }
            "Livro" -> {
                listaLivros.forEach { (t, u) ->
                    if (id==t && u.estado ==Estado.ALUGADO){
                        u.estado =Estado.DISPONIVEL
                        qtdalugado--
                        qtddisponivel++
                        locaçao += diasLocados * u.preçoAluguel
                        operaçoes.add("${date}devolução Livro${u.titulo}")
                        hcliente[cliente.rg] = operaçoes
                        hfunc[funcionario.rg] = operaçoes
                    }
                }
            }
            else -> {println("Titulo não está alugado")}
        }

    }

    fun vender(id: Int,tipo: String,cliente: Cliente,funcionario: Funcionario){
        when (tipo) {
            "Coleção" -> {
                listaColeção.forEach { (t, u) ->
                    if (id == t && u.estado == Estado.DISPONIVEL) {
                        u.estado = Estado.VENDIDO
                        qtddisponivel--
                        qtdvendido++
                        venda += u.preçoDeVenda
                        operaçoes.add("${date}venda/compra(cliente) Coleção${u.titulo}")
                        hcliente[cliente.rg] = operaçoes
                        hfunc[funcionario.rg] = operaçoes
                    } else {
                        println("Titulo indisponivel para venda")
                    }
                }
            }
            "Livro" -> {
                listaLivros.forEach { (t, u) ->
                    if (id==t && u.estado ==Estado.DISPONIVEL){
                        u.estado =Estado.VENDIDO
                        qtddisponivel--
                        qtdvendido++
                        venda += u.preçoDeVenda
                        venda += u.preçoDeVenda
                        operaçoes.add("${date}venda/compra(cliente) Livro ${u.titulo}")
                        hcliente[cliente.rg] = operaçoes
                        hfunc[funcionario.rg] = operaçoes
                    }
                }
            }
            else -> {println("Titulo indisponivel para venda")}
        }


    }
    fun hcliente(id:Int) {
        println("Historico de cliente:")

        hcliente.forEach { (t, u) ->
            if (t == id) {

                u.forEach {
                    println("$it")

                }
            }


        }
    }

    fun hfunc(id:Int) {
        println("Historico de funcionario:")

        hfunc.forEach { (t, u) ->
            if (t == id) {

                u.forEach {
                    println(it)

                }
            }


        }
    }

    fun estoque(){
        println("Quantidade de livros/coleções disponiveis: $qtddisponivel")
        println("Quantidade de livros/coleções alugados $qtdalugado")
        println("Quandidade de livros/coleções vendidos:${qtdvendido}")
        println("Quantidade de locações no periodo:${locaçaoConcluida}")
        println("Valor total de locações livros/coleções${locaçao}")
        println("Valor total de vendas livros/coleções:${venda}")
        println("Receita total ${locaçao+venda}")



    }


}

