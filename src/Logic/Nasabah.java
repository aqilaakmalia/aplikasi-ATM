package Logic;
import java.util.ArrayList;

public class Nasabah{
    private String nama; 
    private Akun akun;
    //data nasabah
    private DataAccessObject dao = new DataAccessObject();
    
    //overloading
    public Nasabah(String nama, Akun akun){
        this.nama = nama; 
        this.akun = akun;
    }
    
    //overloading
     public Nasabah(){
        //waktu new nasabah bisa dijalankan 
    }

    // Enkapsulasi
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }
    
    public Akun getAkun() {
        return akun;
    }

    public void setAkun(Akun akun) {
        this.akun = akun;
    }
    
    public void withdraw(double mount){
        getAkun().setSaldo(getAkun().getSaldo() - mount);
    }
    
    public double check(){
        return getAkun().getSaldo();
    }
    
    public void saving(double mount){
        getAkun().setSaldo(getAkun().getSaldo() + mount);
    }
    
    public void transfer(Nasabah nasabah, double mount){
        //nomor rekening tujuan ->Nasabah nasabah
        //mount ->jumlahnya
        
        this.withdraw(mount);
        nasabah.getAkun().setSaldo(nasabah.getAkun().getSaldo()+ mount);
    }
    
    //save/delete list yang ada dinasabah
    public void save(){
        dao.getList().add(this);
    }
    public void delete(){
        dao.getList().remove(this);
    }
    
    //manggil getList maka bisa nambah dan hapus. 
    public ArrayList<Nasabah> getList(){
        return dao.getList();
    }
}