public class Main {

    public static void main(String[] args) {
        Conta cc = new ContaCorrente();
        Conta Poupanca = new ContaPoupanca();

        cc.imprimirExtrato();
        Poupanca.imprimirExtrato();
    }
}
