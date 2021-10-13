/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Burak Kacmaz
 */
public class Deneme {

    public static void polymorphicYazdir(GeometrikNesne nesneler) {

        if (nesneler != null) {//dizi değişince uzunluk degisebilsin diye null olunca durdurdum.
            System.out.println(nesneler.toString());
            System.out.println("Alan: " + nesneler.alanHesapla());
            System.out.println("Cevre: " + nesneler.cevreHesapla());

            if (nesneler.getEtiket().contains("sil")) {//Silindirse hacim de yazdirmak icin
                Silindir s = (Silindir) nesneler;
                System.out.println("Hacim: " + s.hacimHesapla());
            }

            System.out.println("");
        }
    }

    public static void karsilastir(GeometrikNesne g, GeometrikNesne h) {//2 GeometrikNesne'yi karsılastırma ve gerekli
        if(g != null && h != null){                                     //donus icin
            System.out.println("Karsilastiriyor: " + g.compareTo(h));
        }
    }

    public static double getSmallest(Double[] a, int total) {//Alan ve cevre icin en kucuk degerleri bulma
        double temp;
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[0];
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan;
        int lineCount = 0;
        scan = new Scanner(new File("input.txt"));
        while (scan.hasNextLine()) {//Satır sayısını bulmak icin, bu satır sayısı alan ve cevreleri tutan dizinin uzunluguna
            scan.nextLine();        //kolayca ekleme yapabilmek için
            lineCount++;
        }

        scan = new Scanner(new File("input.txt"));
        GeometrikNesne[] nesneler = new GeometrikNesne[50];
        Daire[] daireler = new Daire[10];
        Dikdortgen[] dikdortgenler = new Dikdortgen[10];
        Silindir[] silindirler = new Silindir[10];
        Double[] alanlar = new Double[lineCount];//copy constructor ile 3 nesne daha gelecegi icin
        Double[] cevreler = new Double[lineCount];//copy constructor ile 3 nesne daha gelecegi icin
        Double[] hesaplar = new Double[10];

        int i = 0;
        int k = 0;
        int j = 0;
        int l = 0;
        while (scan.hasNextLine()) {
            String[] temp = scan.nextLine().split(" ");
            String isim = temp[0];
            if (isim.equals("daire")) {//ilk kelimeye gore sınıflandırma icin
                String etiket = temp[1];
                double yaricap = Double.parseDouble(temp[2]);
                String d = temp[3];
                int month = Integer.parseInt(temp[4]);
                int day = Integer.parseInt(temp[5]);
                int year = Integer.parseInt(temp[6]);
                Date tempdate = new Date(month, day, year);//tarih yazdırma
                Daire daire = new Daire(etiket, tempdate, yaricap);
                daireler[k] = daire;//copy constructor ile kopyalama yaparken erismek icin
                nesneler[i] = daire;
                k++;
            } else if (isim.equals("dikdortgen")) {//ilk kelimeye gore sınıflandırma icin
                String etiket = temp[1];
                double en = Double.parseDouble(temp[2]);
                double boy = Double.parseDouble(temp[3]);
                String d = temp[4];
                int month = Integer.parseInt(temp[5]);
                int day = Integer.parseInt(temp[6]);
                int year = Integer.parseInt(temp[7]);
                Date tempdate = new Date(month, day, year);//tarih yazdırma
                Dikdortgen dikdortgen = new Dikdortgen(etiket, tempdate, en, boy);
                dikdortgenler[j] = dikdortgen;//copy constructor ile kopyalama yaparken erismek icin
                nesneler[i] = dikdortgen;
                j++;
            } else if (isim.equals("silindir")) {//ilk kelimeye gore sınıflandırma icin
                String etiket = temp[1];
                double yaricap = Double.parseDouble(temp[2]);
                double uzunluk = Double.parseDouble(temp[3]);
                String d = temp[4];
                int month = Integer.parseInt(temp[5]);
                int day = Integer.parseInt(temp[6]);
                int year = Integer.parseInt(temp[7]);
                Date tempdate = new Date(month, day, year);//tarih yazdırma
                Silindir silindir = new Silindir(etiket, tempdate, yaricap, uzunluk);
                silindirler[l] = silindir;//copy constructor ile kopyalama yaparken erismek icin
                nesneler[i] = silindir;
                l++;
            }
            i++;
        }
        scan.close();
        
        Daire copy1 = new Daire(daireler[k-1]);//Copy constructor ile yeni daire
        daireler[k] = copy1;
        nesneler[lineCount + 1] = copy1;
        
        Dikdortgen copy2 = new Dikdortgen(dikdortgenler[j-1]);//Copy constructor ile yeni dikdortgen
        dikdortgenler[j] = copy2;
        nesneler[lineCount + 2] = copy2;
        
        Silindir copy3 = new Silindir(silindirler[l-1]);//Copy constructor ile yeni silindir
        silindirler[l] = copy3;
        nesneler[lineCount + 3] = copy3;
        
        double a = i ;//copy constructor ile 3 tane daha nesne geleceği icin

        

        double cevretoplam = 0;
        double alantoplam = 0;
        double hacimtoplam = 0;
        double sil_sayisi = 0;

        for (i = 0; i < a; i++) {
            cevretoplam += nesneler[i].cevreHesapla();
            alantoplam += nesneler[i].alanHesapla();
            alanlar[i] = nesneler[i].alanHesapla();//alanların tutuldugu dizi
            cevreler[i] = nesneler[i].cevreHesapla();//cevrelerin tutuldugu dizi

            if (nesneler[i].getEtiket().contains("sil")) {
                Silindir silindir = (Silindir) nesneler[i];
                hacimtoplam += silindir.hacimHesapla();
                sil_sayisi++;
            }
        }

        double cevre_ort = cevretoplam / a;
        hesaplar[0] = cevre_ort;
        double alan_ort = alantoplam / a;
        hesaplar[1] = alan_ort;
        double hacim_ort = hacimtoplam / sil_sayisi;
        hesaplar[2] = hacim_ort;

        double maxAlan = 0;
        double maxCevre = 0;
        
        

        for (int counter = 1; counter < alanlar.length; counter++) {//en buyuk alanı bulmak icin
            if (alanlar[counter] > maxAlan) {
                maxAlan = alanlar[counter];
            }
        }

        for (int counter = 1; counter < cevreler.length; counter++) {//en buyuk cevreyi bulmak icin
            if (cevreler[counter] > maxCevre) {
                maxCevre = cevreler[counter];
            }
        }
        
        
        karsilastir(daireler[0], daireler[k]);//ilk ve son daire
        karsilastir(daireler[k], daireler[k-1]);//son ve sondan önceki daire
        karsilastir(dikdortgenler[0], dikdortgenler[j]);//ilk ve son dikdortgen
        karsilastir(dikdortgenler[j], dikdortgenler[j-1]);//son ve sondan onceki dikdortgen
        karsilastir(silindirler[0], silindirler[l]);//ilk ve son silindir
        karsilastir(silindirler[l], silindirler[l-1]);//son ve sondan onceki silindir
        
        for (i = 0; i < nesneler.length; i++) {//nesneler dizisinin her elemanının yazımı için
            polymorphicYazdir(nesneler[i]);
        }
        
        //Ortalama cevre, alan ve hacim degerlerinin yazdırılması
        System.out.println("Ortalama cevre: " + hesaplar[0]);
        System.out.println("Ortalama alan: " + hesaplar[1]);
        System.out.println("Silindirler icin ortalama hacim: " + hesaplar[2]);
        
        //En buyuk ve en kucuk, alan ve cevre degerlerinin yazımı icin
        System.out.println("En buyuk alan: " + maxAlan);
        System.out.println("En kucuk alan: " + getSmallest(alanlar,lineCount));
        System.out.println("En buyuk cevre: " + maxCevre);
        System.out.println("En kucuk cevre: " + getSmallest(cevreler,lineCount));
    }
}
