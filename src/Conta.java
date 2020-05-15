import java.util.*;
/**
 * @author Yan
 */
public class Conta {
    
    //Lista pública de contas
    public static List<Conta> lista = new ArrayList<Conta>();
    
    //Atributos
    private int numero;
    private double saldo;
        
    //Construtor customizado
    public Conta(int n, double s) {
        numero = n;
        saldo = s;
    }
    
    //Métodos de acesso
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void debito(int num, double valor) throws SIException {
        if (valor <= saldo){
            saldo -= valor;
        } else {
            SIException e = new SIException(num, saldo);
            throw e; //lançar a exceção tratada para o programa principal
        }
    }
    
    public void credito(double valor){
        saldo += valor;
    }
    
    //Método utilizado para incluir uma conta na lista
   public static void incluirConta(int num, double saldo) {
       lista.add(new Conta(num, saldo));
   }
   
   //Método para remover uma conta
   public static void removerConta(int n) {
       boolean achou = false;
       for (Conta l : lista) {
           if (l.getNumero() == n){
               lista.remove(l);
               System.out.println("Conta excluída!");
               achou = true;
               break;
           }
       }
       if (achou == false) {System.out.println("Conta não encontrada!");}
   }

   //Método utilizado para procurar uma conta na lsita
   public static void imprimirSaldo(int n) {
       for (Conta l : lista) {
           if (l.getNumero() == n){
               System.out.println("Saldo da conta é: " + l.getSaldo());
           }
       }
   }
   
   //Método utilizado para DEBITAR um valor da conta
   public static void debitar(int num, double val) throws SIException {
       for (Conta l : lista) {
           if (l.getNumero() == num){
               l.debito(num, val);
           }
       }
   }
   
   //Método utilizado para CREDITAR um valor na conta
   public static void creditar(int num, double val) {
       for (Conta l : lista) {
           if (l.getNumero() == num){
               l.credito(val);
           }
       }
   }
   
   //Método para transferência de valor entre contas
   public static void transferir(int origem, int destino, double valor) {
       //Procurar a conta origem e DEBITAR
       for (Conta l : lista) {
           if (l.getNumero() == origem){
               //l.debito(valor);
           }
       }
       //Procurar a conta destino e CREDITAR
       for (Conta l : lista) {
           if (l.getNumero() == destino){
               l.credito(valor);
           }
       }
   }
}