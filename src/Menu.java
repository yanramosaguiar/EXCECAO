import java.util.Scanner;

public class Menu {
    
    static Scanner tecla = new Scanner(System.in);
    
    public static void main(String args[])
    {
        int op;
        do
        {
            System.out.println("1-Inserir conta");
            System.out.println("2-Excluir conta");
            System.out.println("3-Efetuar Débito");
            System.out.println("4-Efetuar crédito");
            System.out.println("5-Efetuar Transferência");
            System.out.println("6-Consultar Saldo");
            System.out.println("7-Sair");
            System.out.print("Digite a opção:");
            op = tecla.nextInt();
            switch(op) {
                case 1: inserir(); break;
                case 2: excluir(); break;
                case 3: debitar(); break;
                case 4: creditar(); break;
                case 5: transferir(); break;
                case 6: consultarSaldo(); break;
                case 7: System.exit(0);
            }
        }while(op!=7);
    }
    
    public static void inserir(){
        System.out.println("***************************************");
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o saldo: ");
        double saldo = tecla.nextDouble();
        Conta.incluirConta(num, saldo);
    }
    
    public static void excluir(){
        System.out.println("***************************************");
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        Conta.removerConta(num);
    }
    
    public static void debitar(){
        try {
            System.out.println("***************************************");
            System.out.println("Digite o número da conta:");
            int num = tecla.nextInt();
            System.out.println("Digite o valor do saque");
            double valor = tecla.nextDouble();
            Conta.debitar(num, valor); 
        } catch (SIException e) {
            System.out.println(e.getMessage());
            System.out.print("Conta/saldo: ");
            System.out.println(e.getNumero()+ "/" + e.getSaldo());
        }
    }
    
    public static void creditar(){
        System.out.println("***************************************");
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o valor do depósito");
        double valor = tecla.nextDouble();
        Conta.creditar(num, valor);
    }
    
    public static void transferir(){
        System.out.println("***************************************");
        System.out.println("Digite o número da conta origem:");
        int numOrigem = tecla.nextInt();
        System.out.println("Digite o número da conta destino:");
        int numDestino = tecla.nextInt();
        System.out.println("Digite o valor da transferência:");
        double valor = tecla.nextDouble();
        Conta.transferir(numOrigem, numDestino, valor);
    }
    
    public static void consultarSaldo(){
        System.out.println("***************************************");
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        Conta.imprimirSaldo(num);
    }
}