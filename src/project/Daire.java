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
public class Daire extends GeometrikNesne 
{
    public static final double PI = 3.14159;
    private double yaricap;
    
    public Daire()//parametresiz constructor
    {
        super();
        yaricap = 1.0;
    }
    
    public Daire(String theEtiket, Date theDate, double theYaricap)//parametreli constructor
    {
         super(theEtiket, theDate);
         setYaricap(theYaricap);
    }
    
    public Daire(Daire originalObject)//copy constructor
    {
        super(originalObject);
        this.yaricap = originalObject.yaricap;
        //yaricap = originalObject.yaricap;
        
    }

    /**
     * @return the yaricap
     */
    public double getYaricap() {
        return yaricap;
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
    
    
    
    
    @Override
    public double alanHesapla()//GeometrikNesnede imzası olan alanHesapla metodunu uygulama
    {
        return PI * getYaricap() * getYaricap();
    }
    
    @Override
    public double cevreHesapla()//GeometrikNesnede imzası olan cevreHesapla metodunu uygulama
    {
        return 2 * PI * getYaricap();
    }
    
    @Override
    public int compareTo(GeometrikNesne nesneler) {//GeometrikNesnede imzası olan compareTo metodunu uygulama
        Daire daire = (Daire) nesneler;
        if(getYaricap() > daire.yaricap)
           return 1;
        if(getYaricap() < daire.yaricap)
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
        return temp;
    }
}
