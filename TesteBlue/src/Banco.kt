class Banco {
    var conta: String? = null
    var deposito: Double = 0.0
    var totalBonus: Double = 0.0
    var digitoVerificador: String? = null


    constructor(){}
    constructor(conta: String?, deposito: Double) {
        this.conta = conta
        this.deposito = deposito
        this.digitoVerificador = this.conta?.takeLast(1)
        definirBonus()
    }

    override fun toString(): String {
        return "Banco [conta=" + conta + ", deposito=" + deposito + ", totalBonus=" + totalBonus + "]"
    }

    fun definirBonus(){
        if(digitoVerificador  == "1" || digitoVerificador  == "2" || digitoVerificador  == "3"){
            this.totalBonus = (this.deposito * 0.1)
        }

        if (digitoVerificador  == "4" || digitoVerificador  == "5" || digitoVerificador  == "6"
            || digitoVerificador  == "7" || digitoVerificador  == "8"){
            this.totalBonus = (this.deposito * 0.05)
        }

        if (digitoVerificador  == "0"){
            this.totalBonus = (this.deposito * 0.01)
        }

    }

    fun adicionarDeposito(deposito: Double){
        this.deposito += deposito

        if(digitoVerificador  == "1" || digitoVerificador  == "2" || digitoVerificador  == "3"){
            this.totalBonus += (deposito * 0.1)
        }

        if (digitoVerificador  == "4" || digitoVerificador  == "5" || digitoVerificador  == "6"
            || digitoVerificador  == "7" || digitoVerificador  == "8"){
            this.totalBonus += (deposito * 0.05)
        }

        if (digitoVerificador  == "0"){
            this.totalBonus += (deposito * 0.01)
        }
    }
}