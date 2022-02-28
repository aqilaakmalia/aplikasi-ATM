package Logic;

import java.util.ArrayList;

//berisi manggil bank, logic nasabah, mengembalikan bank
//bank udah diinstasiasi mengembalikan list nasabah
public class DataAccessObject {
    public ArrayList<Nasabah> getList(){
        return Bank.getInstance().getListNasabah();
    }
}
