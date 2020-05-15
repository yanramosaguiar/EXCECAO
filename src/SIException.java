/**
 *
 * @author Yan
 */
class SIException extends Exception {
    
    //Atributos
    private int numero;
    private double saldo;
    
    SIException (int n, double s) {
        super ("Saldo Insuficiente!");
        saldo = s;
        numero = n;
    }
    
    double getSaldo() {return saldo;}
    int getNumero() {return numero;}
    
    /* ... */
}
