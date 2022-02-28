package Logic;

public class Akun {
    private String pin;
    private String noRek;
    private double saldo;

    //construktor inputin, min saldo bawaan
    public Akun(String noRek, String pin, double saldo) {
        this.noRek = noRek;
        this.pin = pin;
        this.saldo = saldo;
    }
    
    //Encapsulasi
    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }
    public String getNoRek() {
        return noRek;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    public String getPin() {
        return pin;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }
}
