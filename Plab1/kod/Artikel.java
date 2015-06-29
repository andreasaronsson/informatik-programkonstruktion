/**
 *  Klassen Artikel inneh�ller privata attribut, konstruktorer, 
 *  get- och setmetoder och tre olika metoder som h�mtar hela objektet
 *  Andreas Aronsson, pk01-14 den 6 november 2001
 *  @author Andreas Aronsson
 *  @version 1.1
 */

import java.util.*;

public class Artikel {

    private double aPris, bestPkt, lagerMgd, inMgd;
    private String varuNamn, enhet, eanKod;
    
    /**
     *  Konstruktor som skapar ett nytt Artikel-objekt med
     *  nya: eankod, varunamn, pris, enhet, lagerm�ngd och best�llningspkt
     *  @param    nyEanKod    eankod
     *  @param    NyVaruNamn  varunnamn
     *  @param    nyAPris     apris
     *  @param    nyEnhet     enhet
     *  @param    nyLagerMgd  lagerm�ngd
     *  @param    nyBestPkt   best�llningspunkt
     */
    public Artikel (String nyEanKod, String nyVaruNamn, double nyAPris, 
		    String nyEnhet, double nyLagerMgd, double nyBestPkt) {
	eanKod=nyEanKod;
	varuNamn=nyVaruNamn;
	aPris=nyAPris;
	enhet=nyEnhet;
	lagerMgd=nyLagerMgd;
	bestPkt=nyBestPkt;
    }
    /**
     *  Konstruktor som skapar nytt Artikel-objekt med ny eankod och inm�ngd
     *  @param    nyEanKod    eankod
     *  @param    nyInMgd     inm�ngd
     */
    public Artikel (String nyEanKod, double nyInMgd) {
	eanKod=nyEanKod;
	inMgd=nyInMgd;
    }
    /**
     *  Parameterl�s konstruktor som skapar ett nytt Artikelobjekt
     */
    public Artikel() {}
    /**
     *  Konstruktor f�r artikelfil
     *  @param    enRad    en rad i artikelfilen
     *
     */
    public Artikel(String enRad) {
	StringTokenizer sT = new StringTokenizer(enRad);
	eanKod=sT.nextToken();
	varuNamn=sT.nextToken();
	aPris=Double.parseDouble(sT.nextToken());
	enhet=sT.nextToken();
	lagerMgd=Double.parseDouble(sT.nextToken());
	bestPkt=Double.parseDouble(sT.nextToken());
    }
    /**
     *   Eankod h�mtas
     *   @return    eanKod    String "eanKod"
     */
    public String getEanKod() {
	return eanKod;
    }
    /**
     *   Varunamn h�mtas
     *   @return    varuNamn    String "varuNamn"
     */
    public String getVaruNamn() {
	return varuNamn;
    }
    /**
     *   Apris h�mtas
     *   @return    aPris    double "aPris"
     */
    public double getAPris() {
	return aPris;
    }
    /**
     *   Enhet h�mtas
     *   @return    enhet    String "enhet"
     */
    public String getEnhet() {
	return enhet;
    }
    /**
     *   Lagerm�ngd h�mtas
     *   @return     lagerMgd    double "lagerMgd"
     */
    public double getLagerMgd() {
	return lagerMgd;
    }
    /**
     *   Best�llningspunkt h�mtas
     *   @return    bestPkt      double "bestPkt"
     */
    public double getBestPkt() {
	return bestPkt;
    }
    /**
     *   Info om en best�llning h�mtas
     *   @return    eanKod and appropriate number of units
     */
    public String getOrder() {
	return eanKod + " " +  bestPkt * 3;
    }
    /**
     *   All info om en artikel h�mtas
     *   @return    all info about an Artikel
     */
    public String getRow() {
	return eanKod + " " + varuNamn + " " + aPris + " " + enhet + " "
	    + lagerMgd + " " + bestPkt;
    }
    /**
     *   Sorterad info om en artikel h�mtas
     *   @return    all info on a certain manner
     */
    public String getSortedRow() {
	return eanKod + " " + aPris + " " + enhet + " " + lagerMgd + " " 
	    + bestPkt + " " + varuNamn;
    }
    /**
     *   All info om en artikel h�mtas f�r att visas p� sk�rmen
     *   @return   another format (for screen display)
     */
    public String getSortRowDisp() {
	return eanKod + "\t" + aPris + "\t" + enhet + "\t" + lagerMgd + "\t" 
	    + bestPkt + "\t" + varuNamn;
    }
    /**
     *  Ny lagerm�ngd s�tts
     *
     */
    public void setLagerMgd(double nyLagerMgd) {
	lagerMgd=nyLagerMgd;
    }
    /**
     *  Ny eankod s�tts
     *
     */
    public void setEanKod(String nyEanKod) {
	eanKod=nyEanKod;
    }
    /**
     *  Nytt varunamn s�tts
     *
     */
    public void setVaruNamn(String nyVaruNamn) {
	varuNamn=nyVaruNamn;
    }
    /**
     *  Nytt apris s�tts
     *
     */
    public void setAPris(double nyAPris) {
	aPris=nyAPris;
    }
    /**
     *  Ny enhet s�tts
     *
     */
    public void setEnhet(String nyEnhet) {
	enhet=nyEnhet;
    }
    /**
     *  Ny best�llningspunkt s�tts
     *
     */
    public void setBestPkt(double nyBestPkt) {
	bestPkt=nyBestPkt;
    }
} //slut Artikel
