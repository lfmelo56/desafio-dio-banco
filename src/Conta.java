public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int sequencial = 1;

    protected int agencia = AGENCIA_PADRAO;
    protected int numero = sequencial++;
    protected double saldo;

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser maior que zero.");
        }
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para realizar saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser maior que zero.");
        }
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta destino não pode ser nula.");
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    // GETTERS
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void imprimirInfosComuns() {
        System.out.printf("Agencia: %d%nNumero: %d%nSaldo: %.2f%n", agencia, numero, saldo);
    }
}
