 /**
* Sistema de gerenciamento de conta bancaria em Java, sistema feito para fins de exercicio de
* conceitos aplicados do Bootcamp Back-End Java Santander 2024.
* @author Yssaky Assad Luz.
* @version 0.0.1 (29/04/2024).
*/

//Importa das Bibliotecas Utilitarias
import java.util.Scanner;

public class ContaTerminal {

    private static double saldoEmConta = 0; // Static variable for account balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("Seja bem-vindo ao ATM Java");
            spaceLiner();
            System.out.println("\nSeu saldo em conta é: R$" + getSaldoEmConta());
            spaceLiner();

            System.out.println("\nQual operação Deseja Realizar?");
            System.out.println("\n1: Saque");
            System.out.println("\n2: Deposito");
            System.out.println("\n3: Saldo Consulta\n");
            int escolhaOperacao = scanner.nextInt();
            spaceLiner();

            switch (escolhaOperacao) {
                case 1:
                    System.out.println("\nA operação escolhida foi: Saque");
                    try {
                        System.out.print("\nDigite o valor do Saque (R$): ");
                        double valorSaque = scanner.nextDouble();
                        System.out.println("\nVocê está sacando R$" + valorSaque);
                        saldoEmConta = operacaoDeSaque(valorSaque); // Update balance directly
                        System.out.println("\nSeu saldo em conta agora é: R$" + getSaldoEmConta());
                        spaceLiner();
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage()); // Informative error message
                    }
                    break;
                case 2:
                    System.out.println("\nA operação escolhida foi: Deposito");
                    try {
                        System.out.print("\nDigite o valor do deposito (R$): ");
                        double valorDeposito = scanner.nextDouble();
                        System.out.println("\nVocê está depositando R$" + valorDeposito);
                        saldoEmConta = operacaoDeDeposito(valorDeposito); // Update balance directly
                        System.out.println("\nSeu saldo em conta agora é: R$" + getSaldoEmConta());
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage()); // Informative error message
                    }
                    break;
                case 3:
                    System.out.println("\nSeu saldo em conta é: R$" + getSaldoEmConta());
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }

            System.out.println("\nDeseja realizar outra operação?");
            System.out.println("\n1: Sim");
            System.out.println("\n2: Não (Sair)\n");
            int continuarOperacao = scanner.nextInt();
            spaceLiner();

            if (continuarOperacao == 2) {
                System.out.println("\nObrigado por usar o ATM Java!");
                continueOperations = false;
            }
        }

        scanner.close();
    }

    public static double operacaoDeSaque(double valorDoSaque) throws IllegalArgumentException {
        if (valorDoSaque <= 0 || valorDoSaque > saldoEmConta) {
            throw new IllegalArgumentException("Valor do saque inválido!");
        }

        saldoEmConta -= valorDoSaque;
        return saldoEmConta;
    }

    public static double operacaoDeDeposito(double valorDoDeposito) throws IllegalArgumentException {
        if (valorDoDeposito <= 0) {
            throw new IllegalArgumentException("Valor do depósito inválido!");
        }

        saldoEmConta += valorDoDeposito;
        return saldoEmConta;
    }

    public static void spaceLiner() {
        System.out.println(" ");
        for (int i = 0; i < 50; i++) {
            System.out.print("_");
        }
        System.out.println(" ");
    }

    public static double getSaldoEmConta() {
        return saldoEmConta;
    }
}