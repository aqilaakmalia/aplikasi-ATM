package Logic;
import Logic.ATM;
import java.awt.Component;
import javax.swing.JOptionPane;

//Inheritance
public class Teller extends Controller {
    
    //overloading
    public Teller(){
        super(new Nasabah());
    }
    
    //overloading
    public Teller(Nasabah nasabah){
        super(nasabah);
    }
    
    //nasabah baru dari teller langsung ada atm
    public void addNasabah(String nama, String noRek , String pin, double saldo){
        //polimorphis
        Akun newAkun = null;
        newAkun = new Akun(noRek, pin, saldo);
        
        // buat nasabahnya
        Nasabah newNasabah = new Nasabah(nama, new Akun(noRek, pin, saldo));
        //masuk arraylistnya
        newNasabah.save();
    }
    
    //buat delete nasabah
    public void delete(){
        getNasabah().delete();
    }
    
    //check jumlah uang untuk transfer
    private boolean checkTransfer(double mount){
        // akan mengembalikan nilai benar jika jumlah transfer <= saldo
        if(mount <= getNasabah().getAkun().getSaldo())
            return true ;
        else 
            return false;
    }
    
    @Override
    //tidak pake pengecekan (tdk ada batasan)
    public double withdraw(double mount){
        getNasabah().getAkun().setSaldo(getNasabah().getAkun().getSaldo() - mount);
        return getNasabah().getAkun().getSaldo();
    }
    
    @Override
    //method transfer di nasabah
    public void transfer(Nasabah nasabah, double mount){
        Component parentComponent = null ;
        if(checkTransfer(mount)){
            getNasabah().transfer(nasabah, mount);
            JOptionPane.showMessageDialog(null, "Transfer Sukses");
        } else {
            JOptionPane.showMessageDialog(parentComponent, "Saldo Anda tidak mencukupi","Not Allowed",JOptionPane.WARNING_MESSAGE);
        }
    }
        
    @Override
    //buat validasi
    public Nasabah validate(String noRek , String pin){
        try{
           int i = 0;
            //selama noRek belum ada, maka mencari dilakukan terus whilenya sampai menemukan NomorRekening
           while(!noRek.equals(Bank.getInstance().getListNasabah().get(i).getAkun().getNoRek()))
               i++;
           //jika pin sudah sama maka akan mengembalikan index nasabah
           if(pin.equals(Bank.getInstance().getListNasabah().get(i).getAkun().getPin()))
               return Bank.getInstance().getListNasabah().get(i);
        }catch(Exception e){
            
        }
            return null;
    }
    
}
