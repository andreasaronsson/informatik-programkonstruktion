/**
 *  Klassen Artikel innehåller privata attribut, konstruktorer, 
 *  get- och setmetoder och tre olika metoder som hämtar hela objektet
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
     *  nya: eankod, varunamn, pris, enhet, lagermängd och beställningspkt
     *  @param    nyEanKod    eankod
     *  @param    NyVaruNamn  varunnamn
     *  @param    nyAPris     apris
     *  @param    nyEnhet     enhet
     *  @param    nyLagerMgd  lagermängd
     *  @param    nyBestPkt   beställningspunkt
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
     *  Konstruktor som skapar nytt Artikel-objekt med ny eankod och inmängd
     *  @param    nyEanKod    eankod
     *  @param    nyInMgd     inmängd
     */
    public Artikel (String nyEanKod, double nyInMgd) {
	eanKod=nyEanKod;
	inMgd=nyInMgd;
    }
    /**
     *  Parameterlös konstruktor som skapar ett nytt Artikelobjekt
     */
    public Artikel() {}
    /**
     *  Konstruktor för artikelfil
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
     *   Eankod hämtas
     *   @return    eanKod    String "eanKod"
     */
    public String getEanKod() {
	return eanKod;
    }
    /**
     *   Varunamn hämtas
     *   @return    varuNamn    String "varuNamn"
     */
    public String getVaruNamn() {
	return varuNamn;
    }
    /**
     *   Apris hämtas
     *   @return    aPris    double "aPris"
     */
    public double getAPris() {
	return aPris;
    }
    /**
     *   Enhet hämtas
     *   @return    enhet    String "enhet"
     */
    public String getEnhet() {
	return enhet;
    }
    /**
     *   Lagermängd hämtas
     *   @return     lagerMgd    double "lagerMgd"
     */
    public double getLagerMgd() {
	return lagerMgd;
    }
    /**
     *   Beställningspunkt hämtas
     *   @return    bestPkt      double "bestPkt"
     */
    public double getBestPkt() {
	return bestPkt;
    }
    /**
     *   Info om en beställning hämtas
     *   @return    eanKod and appropriate number of units
     */
    public String getOrder() {
	return eanKod + " " +  bestPkt * 3;
    }
    /**
     *   All info om en artikel hämtas
     *   @return    all info about an Artikel
     */
    public String getRow() {
	return eanKod + " " + varuNamn + " " + aPris + " " + enhet + " "
	    + lagerMgd + " " + bestPkt;
    }
    /**
     *   Sorterad info om en artikel hämtas
     *   @return    all info on a certain manner
     */
    public String getSortedRow() {
	return eanKod + " " + aPris + " " + enhet + " " + lagerMgd + " " 
	    + bestPkt + " " + varuNamn;
    }
    /**
     *   All info om en artikel hämtas för att visas på skärmen
     *   @return   another format (for screen display)
     */
    public String getSortRowDisp() {
	return eanKod + "\t" + aPris + "\t" + enhet + "\t" + lagerMgd + "\t" 
	    + bestPkt + "\t" + varuNamn;
    }
    /**
     *  Ny lagermängd sätts
     *
     */
    public void setLagerMgd(double nyLagerMgd) {
	lagerMgd=nyLagerMgd;
    }
    /**
     *  Ny eankod sätts
     *
     */
    public void setEanKod(String nyEanKod) {
	eanKod=nyEanKod;
    }
    /**
     *  Nytt varunamn sätts
     *
     */
    public void setVaruNamn(String nyVaruNamn) {
	varuNamn=nyVaruNamn;
    }
    /**
     *  Nytt apris sätts
     *
     */
    public void setAPris(double nyAPris) {
	aPris=nyAPris;
    }
    /**
     *  Ny enhet sätts
     *
     */
    public void setEnhet(String nyEnhet) {
	enhet=nyEnhet;
    }
    /**
     *  Ny beställningspunkt sätts
     *
     */
    public void setBestPkt(double nyBestPkt) {
	bestPkt=nyBestPkt;
    }
} //slut Artikel
