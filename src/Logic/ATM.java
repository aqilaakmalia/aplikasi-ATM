package Logic;
import java.util.ArrayList;
import java.awt.Component;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import Logic.Teller;

//Inheritance
public class ATM extends Controller  {

    //overloading
    //construktor manggil di controll
    public ATM(Nasabah nasabah) {
        super(nasabah);
    }
    
    //overloading
    //tidak bawa paremeter, intansiasi new nasabah
    public ATM(){
        super(new Nasabah());
    }
    
    //check jumlah uang yang akan ditransfer
    private boolean checkTransfer(double mount){
        // akan mengembalikan nilai benar jika jumlah transfer <= saldo
        if(mount <= getNasabah().getAkun().getSaldo())
            return true ;
        else {
            return false;
        }
    }
    
    @Override
    public double withdraw(double mount){
        //pengecekan apakah saldonya cukup
        Component rootPane = null ;
        if(mount <= getNasabah().getAkun().getSaldo())
            getNasabah().withdraw(mount); //withdraw di class nasabah
        else
             JOptionPane.showMessageDialog(rootPane,"Saldo Anda tidak mencukupi","Not Allowed",JOptionPane.WARNING_MESSAGE);
      
        //mengembalikan saldo terbaru
        return getNasabah().getAkun().getSaldo();
    }
    
    @Override
    //method transfer di nasabah
    public void transfer(Nasabah nasabah, double mount){
        Component parentComponent = null ;
       //transfer di class Nasabah->saldo pertama berkurang
        if(checkTransfer(mount)){
            getNasabah().transfer(nasabah, mount);
            JOptionPane.showMessageDialog(null, "Transfer Sukses");
        } else {
            JOptionPane.showMessageDialog(parentComponent, "Saldo Anda tidak mencukupi","Not Allowed",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    @Override
    //buat validasi
    public Nasabah validate(String noRek, String pin){
        try{
           int i = 0;
           //selama akunNumber belum ada, maka mencari dilakukan terus whilenya sampai menemukan NomorRekening
           while(!noRek.equals(Bank.getInstance().getListNasabah().get(i).getAkun().getNoRek()))
               i++;
           if(pin.equals(Bank.getInstance().getListNasabah().get(i).getAkun().getPin()))
               return Bank.getInstance().getListNasabah().get(i);
        }catch(Exception e){
            
        }
        return null;
    }
    
}
