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
public class Silindir extends GeometrikNesne 
{
    public static final double PI = 3.14159;
    private double yaricap;
    private double uzunluk;
    
    public Silindir()//parametresiz constructor
    {
        super();
        yaricap = 1.0;
        uzunluk = 1.0;
    }
    
    public Silindir(String theEtiket, Date theDate, double theYaricap, double theUzunluk)//parametreli constructor
    {
         super(theEtiket, theDate);
         setYaricap(theYaricap);
         setUzunluk(theUzunluk);
    }
    
    public Silindir(Silindir originalObject)//copy constructor
    {
        super(originalObject);
        yaricap = originalObject.yaricap;
        uzunluk = originalObject.uzunluk;
    }

    /**
     * @return the yaricap
     */
    public double getYaricap() 
    {
        return yaricap;
    }

    /**
     * @return the uzunluk
     */
    public double getUzunluk() {
        return uzunluk;
    }
    
    public void setYaricap(double newYaricap)
    {
         if (newYaricap >= 0)
             yaricap = newYaricap;
         else
         {
             System.out.println("Yaricap girerken hata oldu.");
             System.exit(0);
         }
    }
    
    public void setUzunluk(double newUzunluk)
    {
         if (newUzunluk >= 0)
             uzunluk = newUzunluk;
         else
         {
             System.out.println("Uzunluk girerken hata oldu.");
             System.exit(0);
         }
    }
    
    @Override
    public double alanHesapla()//GeometrikNesnede imzası olan alanHesapla metodunu uygulama
    {
        return 2 * PI * getYaricap() * (getYaricap() + getUzunluk());
    }
    
    @Override
    public double cevreHesapla()//GeometrikNesnede imzası olan cevreHesapla metodunu uygulama
    {
        return (2 * 2 * PI * getYaricap()) + (2 * getUzunluk());
    }
    
    public double hacimHesapla()
    {
        return PI * getYaricap() * getYaricap () * getUzunluk();
    }
    
    @Override
    public int compareTo(GeometrikNesne geometriknesne) {//GeometrikNesnede imzası olan compareTo metodunu uygulama
          Silindir silindir = (Silindir) geometriknesne;
       if(this.hacimHesapla() > silindir.hacimHesapla())
           return 1;
       if(this.hacimHesapla() < silindir.hacimHesapla())
           return -1;
       else
           return 0;
    }
    
    @Override
    public String toString( )
    {
        String temp = "";
        temp += String.format(super.toString());
        temp += String.format("Yaricap: %.2f%n", yaricap);
        temp += String.format("Uzunluk: %.2f%n", uzunluk);
        return temp;
    }
}
