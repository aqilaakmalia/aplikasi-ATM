package Logic;

import java.awt.Component;
import javax.swing.JOptionPane;

public abstract class Controller {
    private Nasabah nasabah;
    
    public Controller(Nasabah nasabah) {
        this.nasabah = nasabah;
    }
    
    //Encapsulasi
    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }
    public Nasabah getNasabah() {
        return nasabah;
    }
    
    protected void hasValidate(Nasabah nasabah){
        this.nasabah = nasabah;
    }
    
    public double checkDeposit(){
      return nasabah.check();
    }
    
    public void saving(double mount){
        nasabah.saving(mount);
    }
    
    public double bayar(double mount){
        getNasabah().getAkun().setSaldo(getNasabah().getAkun().getSaldo() - mount);
        return getNasabah().getAkun().getSaldo();
    }
    
    public Nasabah cekTransfer(String akunDestinasi){
        try{
            int i = 0;
            //cari nomer rekening tujuan
            //selama akun destinasi belum cari dilakukan terus whilenya sampai menemukan NomorRekening
            while(!akunDestinasi.equals(getNasabah().getList().get(i).getAkun().getNoRek()))
                i++;
            //ngembalikan nasabah dengan akun destinasi
            return getNasabah().getList().get(i);
            
            //kalo akun tidak ditemukan, destinasi salah
        }catch(Exception e){
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,"Destinasi Anda Salah","Akun tidak Valid",JOptionPane.WARNING_MESSAGE);
        }
        //kalo tdk menemukan nasabah, mengembalikan list nasabahnya
        Nasabah nasabah = new Nasabah();
        return nasabah;
    }
    
    //Overriden
    //check login
    public abstract Nasabah validate(String noRek, String pin);
    //overriden
    //setor
    public abstract double withdraw(double mount);
    //Overriden
    //transfer
    public abstract void transfer(Nasabah nasabah, double mount);
}
