/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Burak Kacmaz
 */
public class Dikdortgen extends GeometrikNesne {

    private double en;
    private double boy;

    public Dikdortgen()//parametresiz constructor
    {
        super();
        en = 1.0;
        boy = 1.0;
    }

    public Dikdortgen(String theEtiket, Date theDate, double theEn, double theBoy)//parametreli constructor
    {
        super(theEtiket, theDate);
        setEn(theEn);
        setBoy(theBoy);
    }

    public Dikdortgen(Dikdortgen originalObject) //copy constructor
    {
        super(originalObject);
        en = originalObject.en;
        boy = originalObject.boy;
    }

    /**
     * @return the en
     */
    public double getEn() {
        return en;
    }

    /**
     * @return the boy
     */
    public double getBoy() {
        return boy;
    }
    
    public void setBoy(double newBoy)
    {
         if (newBoy >= 0)
             boy = newBoy;
         else
         {
             System.out.println("Boy girerken hata oldu.");
             System.exit(0);
         }
    }
    
    public void setEn(double newEn)
    {
         if (newEn >= 0)
             en = newEn;
         else
         {
             System.out.println("En girerken hata oldu.");
             System.exit(0);
         }
    }
    
    @Override
    public double alanHesapla()//GeometrikNesnede imzası olan alanHesapla metodunu uygulama
    {
        return  getBoy() * getEn();
    }
    
    @Override
    public double cevreHesapla()//GeometrikNesnede imzası olan cevreHesapla metodunu uygulama
    {
        return 2 * (getBoy() + getEn());
    }
    
    @Override
    public int compareTo(GeometrikNesne geometriknesne) {//GeometrikNesnede imzası olan compareTo metodunu uygulama
       Dikdortgen dikdortgen = (Dikdortgen) geometriknesne;
       if(alanHesapla()>dikdortgen.alanHesapla())
           return 1;
       if(alanHesapla()<dikdortgen.alanHesapla())
           return -1;
       else
           return 0;
    }
    
    @Override
    public String toString( )
    {
        String temp = "";
        temp += String.format(super.toString());
        temp += String.format("En: %.2f%n", en);
        temp += String.format("Boy: %.2f%n", boy);
        return temp;
    }
    
    
}
