
import java.io.IOException
import java.lang.Exception
import java.io.BufferedReader
import java.io.FileReader
import java.util.ArrayList


private val BANCO_CONTA_IDX = 0
private val BANCO_DEPOSITO_IDX = 1

fun main(args: Array<String>) {

    println("Digite o nome do arquivo junto com sua extensão:")
    val nomeArquivo = readLine()!!

    lerCsv(nomeArquivo)


}

fun lerCsv(nomeArquivo: String?) {

    var fileReader: BufferedReader? = null

    try {
        val bancos = ArrayList<Banco>()
        var linha: String?

        fileReader = BufferedReader(FileReader(nomeArquivo))

        fileReader.readLine()

        linha = fileReader.readLine()

        while (linha != null) {

            val tokens = linha.split(";")

            if (tokens.size > 0) {
                //Verifica se já existe uma conta com numero da agencia e caso não haja cria uma
                var existeBanco: Boolean = false

                for (banco in bancos) {
                    if (banco.conta == tokens[BANCO_CONTA_IDX]) {
                        banco.adicionarDeposito((tokens[BANCO_DEPOSITO_IDX]).toDouble())
                        existeBanco = true
                        break
                    }
                }
                if (existeBanco != true) {
                    val banco = Banco(
                        tokens[BANCO_CONTA_IDX],
                        ((tokens[BANCO_DEPOSITO_IDX]).toDouble())
                    )
                    bancos.add(banco)
                }

            }
            linha = fileReader.readLine()
        }

        //Printa resultado
        println("Conta     Depositos     Total de Bônus")
        for (banco in bancos) {
            println(banco.conta + "     " + banco.deposito + "        " + banco.totalBonus)
        }
    } catch (e: Exception) {
        println("Erro na leitura do csv!")
        e.printStackTrace()
    } finally {
        try {
            fileReader!!.close()
        } catch (e: IOException) {
            println("Erro ao fechar o arquivo!")
            e.printStackTrace()
        }
    }

}



