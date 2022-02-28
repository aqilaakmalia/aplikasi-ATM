package Perbankan;

import Logic.ATM;
import Logic.Teller;
import Logic.Nasabah;
import javax.swing.JFrame;

public class FrameDasar extends javax.swing.JFrame{
    private ATM atmControll;
    private Teller tellerControll;
    private Nasabah nasabah;
    
    public FrameDasar(){
        this.atmControll = new ATM();
        this.tellerControll = new Teller();
    }
    
    public FrameDasar(Nasabah nasabah){
        this.nasabah = nasabah ;
        this.atmControll = new ATM(nasabah);
        this.tellerControll = new Teller(nasabah);
    }
    
    protected void changeFrame(Object obj){
        JFrame frame = (JFrame) obj ;
        frame.setVisible(true );
        this.dispose();
    }
    
    //Encapsulasi
    public ATM getAtmControll() {
        return atmControll;
    }

    public Teller getTellerControll() {
        return tellerControll;
    }

    public Nasabah getNasabah() {
        return nasabah;
    } 
}
