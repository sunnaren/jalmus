package net.jalmus;

/**
 * <p>Title: Java Lecture Musicale</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author RICHARD Christophe
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
//import java.awt.Image;
import java.awt.Graphics2D;
import java.util.ResourceBundle;
import java.awt.GraphicsEnvironment;

public class Tonality {
  int alterationsNumber;
  String Alteration;

  public Tonality(int nb, String alt) {
    this.Alteration = alt;
    this.alterationsNumber = nb;
  }

  public void init(int i, String s) {
    this.Alteration = s;
    this.alterationsNumber = i;
  }

  public void printtest(){
    System.out.println("Alteration : "+this.Alteration+" Nb alt : "+this.alterationsNumber);
  }

  public void copy(Tonality t) {
    this.Alteration = t.Alteration;
    this.alterationsNumber = t.alterationsNumber;
  }

  public void setalterationsNumber(int nb) {
    this.alterationsNumber = nb;
  }

  public int getAlterationsNumber() {
    return this.alterationsNumber;
  }

  public String getAlteration() {
    return this.Alteration;
  }

  public boolean issharp() {
	    return this.Alteration.equalsIgnoreCase("#");
	  }
  
  public boolean isflat() {
	    return this.Alteration.equalsIgnoreCase("b");
	  }
  
  public void setAlteration(String s) {
    this.Alteration = s;
  }

  //*****ALTERATION

  public void drawAlteration(Graphics g, Font f, int x, int y, String type, Component j) {
	g.setColor(Color.black);
	g.setFont(f.deriveFont(54f));
	if (type == "B")
	  g.drawString(type, x+2, y + 21);
	else
	  g.drawString(type, x+2, y + 22);
  }

  public void paint(int gametype, String cle, Graphics g, Font f, int marge, int dportee, Component j, ResourceBundle bundle) {

    int decalagecle = 0;
    int nbline = 1;

    String sharp = "B"; // # alteration
    String flat = "b"; // b alteration

    if (gametype == 1) { // notereading
    	decalagecle = 0;
    	nbline = 1;
    	 drawName(g, marge, 90,  bundle);
    }
    else if (gametype == 3) { // scorereading
    	decalagecle = 0;
    	nbline = 4;
    	 drawName(g, marge, 80,  bundle);
    }
    
    if (cle.equals("treble") | cle.equals("bass"))
      if ( cle.equals("bass"))
        decalagecle = 10;
   
    
	for (int i=0; i<nbline; i++) {

    if (this.Alteration.equalsIgnoreCase("#")) {
      if (this.alterationsNumber >= 1) // FA#
        drawAlteration(g, f, marge, dportee - 15 + decalagecle + i*100, sharp, j); //-9
      if (this.alterationsNumber >= 2) // DO#
        drawAlteration(g, f, marge + 10, dportee + decalagecle + i*100, sharp, j);
      if (this.alterationsNumber >= 3) // SOL#
        drawAlteration(g, f, marge + 20, dportee - 20 + decalagecle + i*100, sharp, j);
      if (this.alterationsNumber >= 4) // RE#
        drawAlteration(g, f, marge + 30, dportee - 5 + decalagecle + i*100, sharp, j);
      if (this.alterationsNumber >= 5) // LA#
        drawAlteration(g, f, marge + 40, dportee + 10 + decalagecle + i*100, sharp, j);
      if (this.alterationsNumber >= 6) // MI#
        drawAlteration(g, f, marge + 50, dportee - 10 + decalagecle + i*100, sharp, j);
      if (this.alterationsNumber >= 7) // SI#
        drawAlteration(g, f, marge + 60, dportee + 5 + decalagecle + i*100, sharp, j);
    }

    if (this.Alteration.equalsIgnoreCase("b")) {
      if (this.alterationsNumber >= 1) // SIb
        drawAlteration(g, f, marge, dportee + 5 + decalagecle + i*100, flat, j);
      if (this.alterationsNumber >= 2) // MIb
        drawAlteration(g, f, marge + 9, dportee - 10 + decalagecle + i*100, flat, j);
      if (this.alterationsNumber >= 3) // LAb
        drawAlteration(g, f, marge + 18, dportee + 10 + decalagecle + i*100, flat, j);
      if (this.alterationsNumber >= 4) // REb
        drawAlteration(g, f, marge + 27, dportee - 5 + decalagecle + i*100, flat, j);
      if (this.alterationsNumber >= 5) // SOLb
        drawAlteration(g, f, marge + 36, dportee + 15 + decalagecle + i*100, flat, j);
      if (this.alterationsNumber >= 6) // DOb
        drawAlteration(g, f, marge + 45, dportee + decalagecle + i*100, flat, j);
      if (this.alterationsNumber >= 7) // FAb
        drawAlteration(g, f, marge + 54, dportee + 20 + decalagecle + i*100, flat, j);
    }

    if (cle.equals("both")) {
      decalagecle = 100;

      if (this.Alteration.equalsIgnoreCase("#")) {
        if (this.alterationsNumber >= 1) // FA#
          drawAlteration(g, f, marge, dportee - 15 + decalagecle, sharp, j);
        if (this.alterationsNumber >= 2) // DO#
          drawAlteration(g, f, marge + 10, dportee + decalagecle, sharp, j);
        if (this.alterationsNumber >= 3) // SOL#
          drawAlteration(g, f, marge + 20, dportee - 20 + decalagecle, sharp, j);
        if (this.alterationsNumber >= 4) // RE#
          drawAlteration(g, f, marge + 30, dportee - 5 + decalagecle, sharp, j);
        if (this.alterationsNumber >= 5) // LA#
          drawAlteration(g, f, marge + 40, dportee + 10 + decalagecle, sharp, j);
        if (this.alterationsNumber >= 6) // MI#
          drawAlteration(g, f, marge + 50, dportee - 10 + decalagecle, sharp, j);
        if (this.alterationsNumber >= 7) // SI#
          drawAlteration(g, f, marge + 60, dportee + 5 + decalagecle, sharp, j);
      }

      if (this.Alteration.equalsIgnoreCase("b")) {
    	  
        if (this.alterationsNumber >= 1) // SIb
          drawAlteration(g, f, marge, dportee + 5 + decalagecle, flat, j);
        if (this.alterationsNumber >= 2) // MIb
          drawAlteration(g, f, marge + 9, dportee - 10 + decalagecle, flat, j);
        if (this.alterationsNumber >= 3) // LAb
          drawAlteration(g, f, marge + 18, dportee + 10 + decalagecle, flat, j);
        if (this.alterationsNumber >= 4) // REb
          drawAlteration(g, f, marge + 27, dportee - 5 + decalagecle, flat, j);
        if (this.alterationsNumber >= 5) // SOLb
          drawAlteration(g, f, marge + 36, dportee + 15 + decalagecle, flat, j);
        if (this.alterationsNumber >= 6) // DOb
          drawAlteration(g, f, marge + 45, dportee + decalagecle, flat, j);
        if (this.alterationsNumber >= 7) // FAb
          drawAlteration(g, f, marge + 54, dportee + 20 + decalagecle, flat, j);
      }
    }
	}

  }

  public void drawName(Graphics g, int marge, int h, ResourceBundle bundle) {
    String nom = "";

    String DO = bundle.getString("_do");
    String RE = bundle.getString("_re");
    String MI = bundle.getString("_mi");
    String FA = bundle.getString("_fa");
    String SOL = bundle.getString("_sol");
    String LA = bundle.getString("_la");
    String SI = bundle.getString("_si");

    g.setColor(Color.green);
    g.setFont(new Font("Arial", Font.BOLD, 17));

    if (this.alterationsNumber == 0)
      nom = DO + " Maj | " + LA + " min";
    else if (this.alterationsNumber == 1)
      if (this.Alteration.equals("#"))
        nom = SOL + " Maj | " + MI + " min";
      else
        nom = FA + " Maj | " + RE + " min";
    if (this.alterationsNumber == 2)
      if (this.Alteration.equals("#"))
        nom = RE + " Maj | " + SI + " min";
      else
        nom = SI + "b Maj | " + SOL + " min";
    if (this.alterationsNumber == 3)
      if (this.Alteration.equals("#"))
        nom = LA + " Maj | " + FA + "# min";
      else
        nom = MI + "b Maj | " + DO + " min";
    if (this.alterationsNumber == 4)
      if (this.Alteration.equals("#"))
        nom = MI + " Maj | " + DO + "# min";
      else
        nom = LA + "b Maj | " + FA + " min";
    if (this.alterationsNumber == 5)
      if (this.Alteration.equals("#"))
        nom = SI + " Maj | " + SOL + "# min";
      else
        nom = RE + "b Maj | " + SI + "b min";
    if (this.alterationsNumber == 6)
      if (this.Alteration.equals("#"))
        nom = FA + "# Maj | " + RE + "# min";
      else
        nom = SOL + "b Maj | " + MI + "b min";
    if (this.alterationsNumber == 7)
      if (this.Alteration.equals("#"))
        nom = DO + "# Maj |" + LA + "# min";
      else
        nom = DO + "b Maj |" + LA + "b min";

    g.setColor(Color.gray);
   // g.setFont(new Font("Arial", Font.ITALIC, 11));
    Graphics2D graphics2D = (Graphics2D) g;
    GraphicsEnvironment.getLocalGraphicsEnvironment();
    graphics2D.setFont(new Font("LucidaSans", Font.PLAIN, 11));
    graphics2D.drawString(nom, marge, h);
  

  }

}

