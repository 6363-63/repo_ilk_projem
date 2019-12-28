import org.w3c.dom.DOMError;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Kisi  k1=new Ogrenci(12,"engin",499);
        Kisi  k3=new Ogrenci(22,"ali",448);

        Kisi k2=new Hoca("mahmut",25,"matematik ");
        Ders d1=new Ders("programlama",4,60,40,80);
        Ders d2=new Ders("mat",2);
        ((Ogrenci)k1).dersEkle(d1);
        ((Ogrenci)k1).dersEkle(d2);
        ((Ogrenci)k1).bilgileriniGoster();

    }
}
abstract class Kisi{
    static ArrayList<Kisi> Kisiler=new ArrayList<Kisi>();
    private int yas;
    private String ad;
    public Kisi(){

    }
    public Kisi(String ad,int yas){
        this.ad=ad;
        if(yas<0) yas=0;
        this.yas=yas;
    }
    abstract  void bilgileriniGoster();

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "ad = "+ ad+" yas= "+ yas;
    }
}
class Ogrenci extends Kisi implements interfaceDers{
    ArrayList<Ders> Dersler;
    private int okulNumara;
    public Ogrenci(int yas,String ad,int okulNumara){
        super(ad,yas);
        this.okulNumara=okulNumara;
        Kisiler.add(this);
        Dersler=new ArrayList<Ders>();
    }

    void dersEkle(Ders d1){
        Dersler.add(d1);
    }


    @Override
    public void dersleriniGoster() {
        for (Ders gecici:Dersler){
            System.out.println(gecici.toString());

        }
    }

    @Override
    void bilgileriniGoster() {
        System.out.println("bilgiler..."+this.toString());
    }
}
class Hoca extends Kisi implements interfaceDers{
    private String brans;
    ArrayList<Ders> verdigiDersler;

    public Hoca(String ad, int yas,String brans) {
        super(ad, yas);
        this.brans=brans;
        verdigiDersler=new ArrayList<Ders>();
        Kisiler.add(this);
    }
    public  Hoca(){
        verdigiDersler=new ArrayList<Ders>();
        Kisiler.add(this);

    }
    void DersEkle(Ders d1){
        verdigiDersler.add(d1);
    }

    @Override
    void bilgileriniGoster() {
        System.out.println(super.toString()+" branş = "+ brans+" " );
    }

    @Override
    public void dersleriniGoster() {

    }
}
class Ders{
    notlar dersNotlar;
    private String dersAdi;
    private int dersKredisi;
    public Ders(String dersAdi,int dersKredisi){
        this.dersAdi=dersAdi;
        this.dersKredisi=dersKredisi;
        this.dersNotlar= new notlar();
    }
    public Ders(String dersAdi,int dersKredisi,int vize1,int vize2,int finall){
        this.dersAdi=dersAdi;
        this.dersKredisi=dersKredisi;
        this.dersNotlar= new notlar();

        dersNotlar.setFinall(finall);
        dersNotlar.setVize1(vize1);
        dersNotlar.setVize2(vize2);
    }

    void dersNotuEkle(int vize1,int vize2,int finall){
        notlar nott=new notlar(vize1,vize2,finall);
        dersNotlar=nott;
    }
    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public int getDersKredisi() {
        return dersKredisi;
    }

    public void setDersKredisi(int dersKredisi) {
        if(dersKredisi<0) dersKredisi=1; // min ders kredisi
        this.dersKredisi = dersKredisi;
    }
    void dersNotlariniGoster(){

    }

    @Override
    public String toString() {
        return "ders adi = "+ dersAdi+" ders kredisi = "+ dersKredisi+ " ders notları =>  = "+dersNotlar.toString();

    }
}
class notlar{
    private int vize1;
    private int vize2;
    private int finall;
    int ortalama=0;
    public notlar(){

    }
    public notlar(int vize1,int vize2,int finall){
        this.finall=finall;
        this.vize1=vize1;
        this.vize2=vize2;
        ortalama=(int) ((((vize1+vize2)/2)*0.4)+(finall*0.6));
    }
    public int getOrtalama(){
        return ortalama;
    }

    public int getVize1() {
        return vize1;
    }

    public void setVize1(int vize1) {
        this.vize1 = vize1;
    }

    public int getVize2() {
        return vize2;
    }

    public void setVize2(int vize2) {
        this.vize2 = vize2;
    }

    public int getFinall() {
        return finall;
    }

    public void setFinall(int finall) {
        this.finall = finall;
    }

    @Override
    public String toString() {

        return " vize 1 = "+vize1+ " vize 2 = "+ vize2 +" final =  "+ finall+ " dersOrtalaması = "+ortalama;
    }
}
interface interfaceDers{
    void dersleriniGoster();

}


