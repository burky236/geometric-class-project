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
public abstract class GeometrikNesne implements Comparable<GeometrikNesne>{
    private String etiket;
    private Date date;
    
    
    public GeometrikNesne( ) // parametresiz constructor
    {
         etiket = "Etiket yok.";
         date = new Date("Jan", 1, 1000); //Just a placeholder.
    }
    
    public GeometrikNesne(String theEtiket, Date theDate) //parametreli constructor
    {
        setEtiket(theEtiket);
        setDate(theDate);
    }
    
    public GeometrikNesne(GeometrikNesne originalObject)  //copy constructor
    {
        etiket = originalObject.etiket;
        date = new Date(originalObject.getDate());
    }

    /**
     * @return the etiket
     */
    public String getEtiket() 
    {
        return etiket;
    }

    /**
     * @return the date
     */
    public Date getDate() 
    {
        return new Date(date);
    }
    
    public void setEtiket(String newEtiket)
    {
        if (newEtiket == null)
        {
             System.out.println("Isci ismi girilirken hata oldu.");
             System.exit(0);
        }
       else
            etiket = newEtiket;
    }
    
    public void setDate(Date newDate)
    {
        if (newDate == null)
        {
             System.out.println("Tarih girilirken hata oldu.");
             System.exit(0);
        }
        else
            date = new Date(newDate);
    }
    
    @Override
    public String toString( )
    {
       return String.format("Etiket: %s%nTarih: %s%n" , etiket, date.toString());
    }
    
    public abstract double alanHesapla();
    public abstract double cevreHesapla();
    public abstract int compareTo(GeometrikNesne nesneler);
}
