package boardgame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Map extends javax.swing.JFrame {

    //Cei doi jucatori
    public Player player1 = new Player();
    public Player player2 = new Player();

    //Functie pentru resetare a jocului
    public void resetGame() {
        turn = 1;
        //Resetarea proprietatilor
        for (Proprietate p : listaProprietati) {
            p.cumparata = false;
            p.proprietar = 0;
            p.chirie = p.chirieInitiala;
            p.numarMagazine = 0;
            p.seMaiPotConstruiMagazine = true;
            p.seMaiPoateConstruiSupermarket = true;
            p.setLabelPretProprietar("Pret: " + String.valueOf(p.pretCumparare + "$"));
        }
        //Resetarea playerilor
        for (Player p : listaPlayeri) {
            p.resetPlayer();
        }
        afiseazaBuget();
        ascundePioniiPlayer1();
        ascundePioniiPlayer2();
        ascundeToateButoaneleProprietatilor();
        poz0.setIcon(iconPion);
        pozitieP2_0.setIcon(iconPion2);
    }

    //Frame ul pentru negoiere
    public Trade trade;

    private int turn = 1;  //  1/2/1/2/1/2....
    private int zar1; // 1 2 3 4 5 6
    private int zar2; // 1 2 3 4 5 6

    //Imagini pentru background,pioni si zaruri
    public ImageIcon backgroundStart = new ImageIcon(this.getClass().getResource("Zaruri" + File.separator + "backgroundStart.jpg"));
    public ImageIcon iconPion = new ImageIcon(this.getClass().getResource("Zaruri" + File.separator + "pion.png"));
    public ImageIcon iconPion2 = new ImageIcon(this.getClass().getResource("Zaruri" + File.separator + "PionNegru.png"));
    public ImageIcon iconZar1 = new ImageIcon(this.getClass().getResource("Zaruri" + File.separator + "zar1.png"));
    public ImageIcon iconZar2 = new ImageIcon(this.getClass().getResource("Zaruri" + File.separator + "zar2.png"));
    public ImageIcon iconZar3 = new ImageIcon(this.getClass().getResource("Zaruri" + File.separator + "zar3.png"));
    public ImageIcon iconZar4 = new ImageIcon(this.getClass().getResource("Zaruri" + File.separator + "zar4.png"));
    public ImageIcon iconZar5 = new ImageIcon(this.getClass().getResource("Zaruri" + File.separator + "zar5.png"));
    public ImageIcon iconZar6 = new ImageIcon(this.getClass().getResource("Zaruri" + File.separator + "zar6.png"));

    //Listele cartilor Chance si Chest
    public HashMap<Integer, Chance> listaChance = new HashMap<>();
    public HashMap<Integer, Chest> listaChest = new HashMap<>();

    //Imaginile si declararea celor 2 fabrici
    public ImageIcon imagineFabricaElectrica = new ImageIcon(this.getClass().getResource("Fabrici" + File.separator + "electric.png"));
    public ImageIcon imagineFabricaApa = new ImageIcon(this.getClass().getResource("Fabrici" + File.separator + "water.png"));
    public Fabrica fabricaElectrica = new Fabrica(12, "Fabrica Electrica", imagineFabricaElectrica);
    public Fabrica fabricaApa = new Fabrica(27, "Fabrica Apa", imagineFabricaApa);

    private Chance carteChanceTrasa;
    private int carteChanceAleasa;
    private Chest carteChestTrasa;
    private int carteChestAleasa;

    ActionListener actionListenerButon;//pentru butonul de Cumparare
    ActionListener actionListenerButonCumparaMagazin;
    ActionListener actionListenerButonCumparaSupermarket;

    //Declararea celor 4 metrouri.
    public ImageIcon trainIcon = new ImageIcon(this.getClass().getResource("Train//Train.png"));
    public Train metrou1 = new Train(5, "Metrou Berceni");
    public Train metrou2 = new Train(15, "Metrou Pipera");
    public Train metrou3 = new Train(25, "Metrou Preciziei");
    public Train metrou4 = new Train(35, "Metrou Dristor");

    //Declararea Proprietatilor
    public Proprietate Rahova = new Proprietate(1, "Rahova", new Color(51, 0, 0), 2, 10, 30, 90, 160, 250, 50, 50, 60);
    public Proprietate Ferentari = new Proprietate(3, "Ferentari", new Color(51, 0, 0), 4, 20, 60, 180, 320, 450, 50, 50, 60);

    public Proprietate Titan = new Proprietate(6, "Titan", new Color(102, 204, 255), 6, 30, 90, 270, 400, 550, 50, 50, 100);
    public Proprietate Vitan = new Proprietate(8, "Vitan", new Color(102, 204, 255), 6, 30, 90, 270, 400, 550, 50, 50, 100);
    public Proprietate StefanCelMare = new Proprietate(9, "Stefan cel Mare", new Color(102, 204, 255), 8, 40, 100, 300, 450, 600, 50, 50, 110);

    public Proprietate Izvor = new Proprietate(11, "Izvor", new Color(204, 0, 204), 10, 50, 150, 450, 625, 750, 100, 100, 150);
    public Proprietate MegaMall = new Proprietate(13, "MegaMall", new Color(204, 0, 204), 12, 60, 180, 500, 700, 900, 100, 100, 150);
    public Proprietate LibertyCenter = new Proprietate(14, "Libetry Center", new Color(204, 0, 204), 10, 50, 150, 450, 625, 750, 100, 100, 160);

    public Proprietate Militari = new Proprietate(16, "Militari", new Color(255, 51, 0), 14, 70, 200, 550, 750, 950, 100, 100, 180);
    public Proprietate DrumuTaberei = new Proprietate(18, "Drumu Taberei", new Color(255, 51, 0), 14, 70, 200, 550, 750, 950, 100, 100, 180);
    public Proprietate TreispeSeptembrie = new Proprietate(19, "13 Septembrie", new Color(255, 51, 0), 16, 80, 220, 600, 800, 1000, 100, 100, 200);

    public Proprietate Cotroceni = new Proprietate(21, "Cotroceni", new Color(255, 0, 0), 18, 90, 250, 700, 875, 1050, 150, 150, 220);
    public Proprietate OraselulCopiilor = new Proprietate(22, "Oraselul Copiilor", new Color(255, 0, 0), 18, 90, 250, 700, 875, 1050, 150, 150, 220);
    public Proprietate Cismigiu = new Proprietate(24, "Cismigiu", new Color(255, 0, 0), 20, 100, 300, 750, 925, 1100, 150, 150, 240);

    public Proprietate PiataUnirii = new Proprietate(26, "Piata Unirii", new Color(255, 255, 51), 22, 110, 330, 800, 975, 1150, 150, 150, 260);
    public Proprietate Berceni = new Proprietate(28, "Berceni", new Color(255, 255, 51), 22, 110, 330, 800, 975, 1150, 150, 150, 260);
    public Proprietate Baneasa = new Proprietate(29, "Baneasa", new Color(255, 255, 51), 24, 120, 360, 850, 1025, 1200, 150, 150, 280);

    public Proprietate ParkLake = new Proprietate(31, "Park Lake", new Color(0, 153, 51), 26, 130, 390, 900, 1100, 1275, 200, 200, 300);
    public Proprietate AfiPalace = new Proprietate(32, "Afi Palace", new Color(0, 153, 51), 26, 130, 390, 900, 1100, 1275, 200, 200, 300);
    public Proprietate Herastrau = new Proprietate(34, "Herastrau", new Color(0, 153, 51), 28, 150, 450, 1000, 1200, 1400, 200, 200, 320);

    public Proprietate Dorobanti = new Proprietate(37, "Dorobanti", new Color(0, 102, 204), 35, 175, 500, 1100, 1500, 1700, 200, 200, 350);
    public Proprietate CentruVechi = new Proprietate(39, "Centrul Vechi", new Color(0, 102, 204), 50, 205, 600, 1400, 1700, 2000, 200, 200, 400);

    //Liste pentru fiecare domeniu in parte
    public List<Player> listaPlayeri = new LinkedList<>();
    public List<Proprietate> listaProprietati = new LinkedList<>();
    public List<Train> listaMetrouri = new LinkedList<>();
    public List<Fabrica> listaFabrici = new LinkedList<>();

    //Metoda pentru adaugarea tuturor domeniilor declarate in listele corespunzatoare
    public void adaugaToateDomeniileInListe() {
        listaProprietati.add(Rahova);
        listaProprietati.add(Ferentari);
        listaProprietati.add(Titan);
        listaProprietati.add(Vitan);
        listaProprietati.add(StefanCelMare);
        listaProprietati.add(Izvor);
        listaProprietati.add(MegaMall);
        listaProprietati.add(LibertyCenter);
        listaProprietati.add(Militari);
        listaProprietati.add(DrumuTaberei);
        listaProprietati.add(TreispeSeptembrie);
        listaProprietati.add(Cotroceni);
        listaProprietati.add(OraselulCopiilor);
        listaProprietati.add(Cismigiu);
        listaProprietati.add(PiataUnirii);
        listaProprietati.add(Berceni);
        listaProprietati.add(Baneasa);
        listaProprietati.add(ParkLake);
        listaProprietati.add(AfiPalace);
        listaProprietati.add(Herastrau);
        listaProprietati.add(Dorobanti);
        listaProprietati.add(CentruVechi);
        listaMetrouri.add(metrou1);
        listaMetrouri.add(metrou2);
        listaMetrouri.add(metrou3);
        listaMetrouri.add(metrou4);
        listaFabrici.add(fabricaApa);
        listaFabrici.add(fabricaElectrica);
    }

    //Aruncatul cu zarurile
    int deCateOriSeRotescZarurile = 0;
    Timer timerZaruri = new Timer(150, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            deCateOriSeRotescZarurile++;
            int zar1Random = (int) (Math.random() * 6) + 1;
            int zar2Random = (int) (Math.random() * 6) + 1;

            switch (zar1Random) {
                case 1:
                    labelZar1.setIcon(iconZar1);
                    break;
                case 2:
                    labelZar1.setIcon(iconZar2);
                    break;
                case 3:
                    labelZar1.setIcon(iconZar3);
                    break;
                case 4:
                    labelZar1.setIcon(iconZar4);
                    break;
                case 5:
                    labelZar1.setIcon(iconZar5);
                    break;
                case 6:
                    labelZar1.setIcon(iconZar6);
                    break;
            }
            switch (zar2Random) {
                case 1:
                    labelZar2.setIcon(iconZar1);
                    break;
                case 2:
                    labelZar2.setIcon(iconZar2);
                    break;
                case 3:
                    labelZar2.setIcon(iconZar3);
                    break;
                case 4:
                    labelZar2.setIcon(iconZar4);
                    break;
                case 5:
                    labelZar2.setIcon(iconZar5);
                    break;
                case 6:
                    labelZar2.setIcon(iconZar6);
                    break;
            }
            //La 10 rostogoliri,zarurile se opresc
            if (deCateOriSeRotescZarurile == 10) {
                timerZaruri.stop();
                deCateOriSeRotescZarurile = 0;
                zar1 = zar1Random;
                zar2 = zar2Random;
                if (zar1 == zar2) { //Daca dam dubla,mai avem o aruncare
                    bIncheieTura.setVisible(false);
                    butonZaruri.setVisible(true);
                }
                pornestePionii();
            }
        }
    });

    public void pornestePionii() {
        labelZar.setText(String.valueOf(zar1) + " x " + String.valueOf(zar2));
        if (turn % 2 != 0) {
            if (player1.asteptarePlayer <= 0) {
                timerPlayer1.start();
                player1.pozitieNouaPlayer += zar1 + zar2;
                player2.asteptarePlayer--;
            } else {
                timerPlayer2.start();
                player2.pozitieNouaPlayer += zar1 + zar2;
            }
        } else if (turn % 2 == 0) {
            if (player2.asteptarePlayer <= 0) {
                timerPlayer2.start();
                player2.pozitieNouaPlayer += zar1 + zar2;
                player1.asteptarePlayer--;
            } else {
                timerPlayer1.start();
                player1.pozitieNouaPlayer += zar1 + zar2;
            }

        }
    }

    //Refresh pentru Board.ascunderea Pionilor
    public void ascundePioniiPlayer1() {
        poz0.setIcon(null);
        poz1.setIcon(null);
        poz2.setIcon(null);
        poz3.setIcon(null);
        poz4.setIcon(null);
        poz5.setIcon(null);
        poz6.setIcon(null);
        poz7.setIcon(null);
        poz8.setIcon(null);
        poz9.setIcon(null);
        poz10.setIcon(null);
        poz11.setIcon(null);
        poz12.setIcon(null);
        poz13.setIcon(null);
        poz14.setIcon(null);
        poz15.setIcon(null);
        poz16.setIcon(null);
        poz17.setIcon(null);
        poz18.setIcon(null);
        poz19.setIcon(null);
        poz20.setIcon(null);
        poz21.setIcon(null);
        poz22.setIcon(null);
        poz23.setIcon(null);
        poz24.setIcon(null);
        poz25.setIcon(null);
        poz26.setIcon(null);
        poz27.setIcon(null);
        poz28.setIcon(null);
        poz29.setIcon(null);
        poz30.setIcon(null);
        poz31.setIcon(null);
        poz32.setIcon(null);
        poz33.setIcon(null);
        poz34.setIcon(null);
        poz35.setIcon(null);
        poz36.setIcon(null);
        poz37.setIcon(null);
        poz38.setIcon(null);
        poz39.setIcon(null);
        pozInchisoare.setIcon(null);

    }

    public void ascundePioniiPlayer2() {
        pozitieP2_0.setIcon(null);
        pozitieP2_1.setIcon(null);
        pozitieP2_2.setIcon(null);
        pozitieP2_3.setIcon(null);
        pozitieP2_4.setIcon(null);
        pozitieP2_5.setIcon(null);
        pozitieP2_6.setIcon(null);
        pozitieP2_7.setIcon(null);
        pozitieP2_8.setIcon(null);
        pozitieP2_9.setIcon(null);
        pozitieP2_10.setIcon(null);
        pozitieP2_11.setIcon(null);
        pozitieP2_12.setIcon(null);
        pozitieP2_13.setIcon(null);
        pozitieP2_14.setIcon(null);
        pozitieP2_15.setIcon(null);
        pozitieP2_16.setIcon(null);
        pozitieP2_17.setIcon(null);
        pozitieP2_18.setIcon(null);
        pozitieP2_19.setIcon(null);
        pozitieP2_20.setIcon(null);
        pozitieP2_21.setIcon(null);
        pozitieP2_22.setIcon(null);
        pozitieP2_23.setIcon(null);
        pozitieP2_24.setIcon(null);
        pozitieP2_25.setIcon(null);
        pozitieP2_26.setIcon(null);
        pozitieP2_27.setIcon(null);
        pozitieP2_28.setIcon(null);
        pozitieP2_29.setIcon(null);
        pozitieP2_30.setIcon(null);
        pozitieP2_31.setIcon(null);
        pozitieP2_32.setIcon(null);
        pozitieP2_33.setIcon(null);
        pozitieP2_34.setIcon(null);
        pozitieP2_35.setIcon(null);
        pozitieP2_36.setIcon(null);
        pozitieP2_37.setIcon(null);
        pozitieP2_38.setIcon(null);
        pozitieP2_39.setIcon(null);
        pozitieP2_Inchisoare.setIcon(null);
    }

    //Pionul va fi desenat pe harta in functie de pozitia curenta
    public void pozitiePionPeMapa() {
        ascundePioniiPlayer1(); //Ascunderea tuturor celorlalti pioni de pe pozitiile precedente
        switch (player1.pozitiePlayer) {
            case 0:
                poz0.setIcon(iconPion);
                break;
            case 1:
                poz1.setIcon(iconPion);
                break;
            case 2:
                poz2.setIcon(iconPion);
                break;
            case 3:
                poz3.setIcon(iconPion);
                break;
            case 4:
                poz4.setIcon(iconPion);
                break;
            case 5:
                poz5.setIcon(iconPion);
                break;
            case 6:
                poz6.setIcon(iconPion);
                break;
            case 7:
                poz7.setIcon(iconPion);
                break;
            case 8:
                poz8.setIcon(iconPion);
                break;
            case 9:
                poz9.setIcon(iconPion);
                break;
            case 10:
                poz10.setIcon(iconPion);
                break;
            case 11:
                poz11.setIcon(iconPion);
                break;
            case 12:
                poz12.setIcon(iconPion);
                break;
            case 13:
                poz13.setIcon(iconPion);
                break;
            case 14:
                poz14.setIcon(iconPion);
                break;
            case 15:
                poz15.setIcon(iconPion);
                break;
            case 16:
                poz16.setIcon(iconPion);
                break;
            case 17:
                poz17.setIcon(iconPion);
                break;
            case 18:
                poz18.setIcon(iconPion);
                break;
            case 19:
                poz19.setIcon(iconPion);
                break;
            case 20:
                poz20.setIcon(iconPion);
                break;
            case 21:
                poz21.setIcon(iconPion);
                break;
            case 22:
                poz22.setIcon(iconPion);
                break;
            case 23:
                poz23.setIcon(iconPion);
                break;
            case 24:
                poz24.setIcon(iconPion);
                break;
            case 25:
                poz25.setIcon(iconPion);
                break;
            case 26:
                poz26.setIcon(iconPion);
                break;
            case 27:
                poz27.setIcon(iconPion);
                break;
            case 28:
                poz28.setIcon(iconPion);
                break;
            case 29:
                poz29.setIcon(iconPion);
                break;
            case 30:
                poz30.setIcon(iconPion);
                break;
            case 31:
                poz31.setIcon(iconPion);
                break;
            case 32:
                poz32.setIcon(iconPion);
                break;
            case 33:
                poz33.setIcon(iconPion);
                break;
            case 34:
                poz34.setIcon(iconPion);
                break;
            case 35:
                poz35.setIcon(iconPion);
                break;
            case 36:
                poz36.setIcon(iconPion);
                break;
            case 37:
                poz37.setIcon(iconPion);
                break;
            case 38:
                poz38.setIcon(iconPion);
                break;
            case 39:
                poz39.setIcon(iconPion);
                break;

        }
    }

    //Pionul va fi desenat pe harta in functie de pozitia curenta
    public void pozitiePionPeMapaPlayer2() {
        ascundePioniiPlayer2();//Ascunderea tuturor celorlalti pioni de pe pozitiile precedente
        switch (player2.pozitiePlayer) {
            case 0:
                pozitieP2_0.setIcon(iconPion2);
                break;
            case 1:
                pozitieP2_1.setIcon(iconPion2);
                break;
            case 2:
                pozitieP2_2.setIcon(iconPion2);
                break;
            case 3:
                pozitieP2_3.setIcon(iconPion2);
                break;
            case 4:
                pozitieP2_4.setIcon(iconPion2);
                break;
            case 5:
                pozitieP2_5.setIcon(iconPion2);
                break;
            case 6:
                pozitieP2_6.setIcon(iconPion2);
                break;
            case 7:
                pozitieP2_7.setIcon(iconPion2);
                break;
            case 8:
                pozitieP2_8.setIcon(iconPion2);
                break;
            case 9:
                pozitieP2_9.setIcon(iconPion2);
                break;
            case 10:
                pozitieP2_10.setIcon(iconPion2);
                break;
            case 11:
                pozitieP2_11.setIcon(iconPion2);
                break;
            case 12:
                pozitieP2_12.setIcon(iconPion2);
                break;
            case 13:
                pozitieP2_13.setIcon(iconPion2);
                break;
            case 14:
                pozitieP2_14.setIcon(iconPion2);
                break;
            case 15:
                pozitieP2_15.setIcon(iconPion2);
                break;
            case 16:
                pozitieP2_16.setIcon(iconPion2);
                break;
            case 17:
                pozitieP2_17.setIcon(iconPion2);
                break;
            case 18:
                pozitieP2_18.setIcon(iconPion2);
                break;
            case 19:
                pozitieP2_19.setIcon(iconPion2);
                break;
            case 20:
                pozitieP2_20.setIcon(iconPion2);
                break;
            case 21:
                pozitieP2_21.setIcon(iconPion2);
                break;
            case 22:
                pozitieP2_22.setIcon(iconPion2);
                break;
            case 23:
                pozitieP2_23.setIcon(iconPion2);
                break;
            case 24:
                pozitieP2_24.setIcon(iconPion2);
                break;
            case 25:
                pozitieP2_25.setIcon(iconPion2);
                break;
            case 26:
                pozitieP2_26.setIcon(iconPion2);
                break;
            case 27:
                pozitieP2_27.setIcon(iconPion2);
                break;
            case 28:
                pozitieP2_28.setIcon(iconPion2);
                break;
            case 29:
                pozitieP2_29.setIcon(iconPion2);
                break;
            case 30:
                pozitieP2_30.setIcon(iconPion2);
                break;
            case 31:
                pozitieP2_31.setIcon(iconPion2);
                break;
            case 32:
                pozitieP2_32.setIcon(iconPion2);
                break;
            case 33:
                pozitieP2_33.setIcon(iconPion2);
                break;
            case 34:
                pozitieP2_34.setIcon(iconPion2);
                break;
            case 35:
                pozitieP2_35.setIcon(iconPion2);
                break;
            case 36:
                pozitieP2_36.setIcon(iconPion2);
                break;
            case 37:
                pozitieP2_37.setIcon(iconPion2);
                break;
            case 38:
                pozitieP2_38.setIcon(iconPion2);
                break;
            case 39:
                pozitieP2_39.setIcon(iconPion2);
                break;
        }
    }

    Timer timerPlayer1 = new Timer(400, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //In cazul in care player1 trece prin start
            dacaPlayer1TrecePrinStart();
            //Avansarea pionului
            if (player1.pozitiePlayer < player1.pozitieNouaPlayer) {
                player1.pozitiePlayer++;
                pozitiePionPeMapa(); //redesenare
            }
            //Oprirea pionului
            if (player1.pozitiePlayer == player1.pozitieNouaPlayer) {
                timerPlayer1.stop();
                panelAfisare.revalidate();
                panelAfisare.repaint();
                //Actiunile intamplate in functie de pozitia pe care a picat pionul
                switch (player1.pozitieNouaPlayer) {
                    case 1:
                        player1PicaPe(Rahova);
                        break;
                    case 3:
                        player1PicaPe(Ferentari);
                        break;
                    case 6:
                        player1PicaPe(Titan);
                        break;
                    case 8:
                        player1PicaPe(Vitan);
                        break;
                    case 9:
                        player1PicaPe(StefanCelMare);
                        break;
                    case 11:
                        player1PicaPe(Izvor);
                        break;
                    case 13:
                        player1PicaPe(MegaMall);
                        break;
                    case 14:
                        player1PicaPe(LibertyCenter);
                        break;
                    case 16:
                        player1PicaPe(Militari);
                        break;
                    case 18:
                        player1PicaPe(DrumuTaberei);
                        break;
                    case 19:
                        player1PicaPe(TreispeSeptembrie);
                        break;
                    case 21:
                        player1PicaPe(Cotroceni);
                        break;
                    case 22:
                        player1PicaPe(OraselulCopiilor);
                        break;
                    case 24:
                        player1PicaPe(Cismigiu);
                        break;
                    case 26:
                        player1PicaPe(PiataUnirii);
                        break;
                    case 28:
                        player1PicaPe(Berceni);
                        break;
                    case 29:
                        player1PicaPe(Baneasa);
                        break;
                    case 31:
                        player1PicaPe(ParkLake);
                        break;
                    case 32:
                        player1PicaPe(AfiPalace);
                        break;
                    case 34:
                        player1PicaPe(Herastrau);
                        break;
                    case 37:
                        player1PicaPe(Dorobanti);
                        break;
                    case 39:
                        player1PicaPe(CentruVechi);
                        break;

                    case 5: //metrou1
                        player1PicaPeStatiaDeMetrou(metrou1);
                        break;

                    case 15: //metroul2
                        player1PicaPeStatiaDeMetrou(metrou2);
                        break;

                    case 25: //metroul3
                        player1PicaPeStatiaDeMetrou(metrou3);
                        break;

                    case 35: //metroul4
                        player1PicaPeStatiaDeMetrou(metrou4);
                        break;

                    case 12: //cand pica pe fabrica electrica
                        player1PicaPeFabrica(fabricaElectrica);
                        break;
                    case 27: //cand pica pe fabrica de apa
                        player1PicaPeFabrica(fabricaApa);
                        break;

                    case 4: //Cand pica pe taxe
                        player1.bugetPlayer -= 150;
                        labelTaxa1.setText("Taxa:platesti 150$");
                        break;
                    case 38:
                        player1.bugetPlayer -= 150;
                        labelTaxa2.setText("Taxa:platesti 150$");
                        break;
                    case 7: //Cand pica pe Chance
                    case 23:
                    case 36:
                        player1PicaPeChance();
                        break;
                    case 2://Cand pica pe Chest
                    case 17:
                    case 33:
                        player1PicaPeChest();
                        break;
                }
                afiseazaBuget();
            }
            dacaPlayer1PicaInInchisoare();
        }
    });

    Timer timerPlayer2 = new Timer(400, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            dacaPlayer2TrecePrinStart();
            //Avansarea pionului
            if (player2.pozitiePlayer < player2.pozitieNouaPlayer) {
                player2.pozitiePlayer++;
                pozitiePionPeMapaPlayer2();
            }
            //Oprirea pionului
            if (player2.pozitiePlayer == player2.pozitieNouaPlayer) {
                timerPlayer2.stop();
                panelAfisare.revalidate();
                panelAfisare.repaint();
                //Actiunile intamplate in functie de pozitia pe care a picat pionul
                switch (player2.pozitieNouaPlayer) {
                    case 1:
                        player2PicaPe(Rahova);
                        break;
                    case 3:
                        player2PicaPe(Ferentari);
                        break;
                    case 6:
                        player2PicaPe(Titan);
                        break;
                    case 8:
                        player2PicaPe(Vitan);
                        break;
                    case 9:
                        player2PicaPe(StefanCelMare);
                        break;
                    case 11:
                        player2PicaPe(Izvor);
                        break;
                    case 13:
                        player2PicaPe(MegaMall);
                        break;
                    case 14:
                        player2PicaPe(LibertyCenter);
                        break;
                    case 16:
                        player2PicaPe(Militari);
                        break;
                    case 18:
                        player2PicaPe(DrumuTaberei);
                        break;
                    case 19:
                        player2PicaPe(TreispeSeptembrie);
                        break;
                    case 21:
                        player2PicaPe(Cotroceni);
                        break;
                    case 22:
                        player2PicaPe(OraselulCopiilor);
                        break;
                    case 24:
                        player2PicaPe(Cismigiu);
                        break;
                    case 26:
                        player2PicaPe(PiataUnirii);
                        break;
                    case 28:
                        player2PicaPe(Berceni);
                        break;
                    case 29:
                        player2PicaPe(Baneasa);
                        break;
                    case 31:
                        player2PicaPe(ParkLake);
                        break;
                    case 32:
                        player2PicaPe(AfiPalace);
                        break;
                    case 34:
                        player2PicaPe(Herastrau);
                        break;
                    case 37:
                        player2PicaPe(Dorobanti);
                        break;
                    case 39:
                        player2PicaPe(CentruVechi);
                        break;

                    case 5:
                        player2PicaPeStatiaDeMetrou(metrou1);
                        break;
                    case 15: //metroul2
                        player2PicaPeStatiaDeMetrou(metrou2);
                        break;

                    case 25: //metroul3
                        player2PicaPeStatiaDeMetrou(metrou3);
                        break;
                    case 35: //metroul4
                        player2PicaPeStatiaDeMetrou(metrou4);
                        break;

                    case 12: //cand pica pe fabrica electrica
                        player2PicaPeFabrica(fabricaElectrica);
                        break;
                    case 27: //cand pica pe fabrica de apa
                        player2PicaPeFabrica(fabricaApa);
                        break;

                    case 4: //cand pica pe taxe
                        player2.bugetPlayer -= 150;
                        labelTaxa1.setText("Taxa:platesti 150$");
                        break;
                    case 38: //cand pica pe taxe
                        player2.bugetPlayer -= 150;
                        labelTaxa2.setText("Taxa:platesti 150$");
                        break;
                    case 7: //Cand pica pe Chance
                    case 23:
                    case 36:
                        player2PicaPeChance();
                        break;

                    case 2: //Cand pica pe Chest
                    case 17:
                    case 33:
                        player2PicaPeChest();
                        break;

                }
                afiseazaBuget();
            }
            dacaPlayer2PicaInInchisoare();
        }
    });

    //In functie de domeniul pe care vor pica pionii,vom avea 3 cazuri:
    // 1)domeniul nu este cumparat
    // 2)domeniul este cumparat de tine
    // 3)domeniul este cumparat de adversar
    //In cazul proprietatilor:
    public void proprietateaNuEsteCumparata(Proprietate proprietate, int player) {
        if (player == 1) { //daca pica player 1
            //Refresh
            panelAfisare.removeAll();
            panelAfisare.revalidate();
            panelAfisare.repaint();
            panelAfisare.add(proprietate);
            if (proprietate.proprietar == 0) { //In caz ca nu are proprietar,apare optiunea de a o cumpara
                bCumpara.setVisible(true);
                actionListenerButon = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        proprietate.cumparaProprietate(1);
                        player1.listaDomeniiPlayer.add(proprietate);
                        bCumpara.setVisible(false);
                        player1.bugetPlayer -= proprietate.pretCumparare;
                        afiseazaBuget();
                        //Afisarea butoanelor scurtatura in listele proprietatilor playerului
                        //Si incrementarea numarului proprietatilor de culoarea respectiva
                        switch (proprietate.idProprietate) {
                            case 1:
                                b1.setVisible(true);
                                player1.proprietatiPlayer.proprietati_1_3++;

                                break;
                            case 3:
                                b3.setVisible(true);
                                player1.proprietatiPlayer.proprietati_1_3++;
                                break;
                            case 6:
                                b6.setVisible(true);
                                player1.proprietatiPlayer.proprietati_6_8_9++;
                                break;
                            case 8:
                                b8.setVisible(true);
                                player1.proprietatiPlayer.proprietati_6_8_9++;
                                break;
                            case 9:
                                b9.setVisible(true);
                                player1.proprietatiPlayer.proprietati_6_8_9++;
                                break;
                            case 11:
                                b11.setVisible(true);
                                player1.proprietatiPlayer.proprietati_11_13_14++;
                                break;
                            case 13:
                                b13.setVisible(true);
                                player1.proprietatiPlayer.proprietati_11_13_14++;
                                break;
                            case 14:
                                b14.setVisible(true);
                                player1.proprietatiPlayer.proprietati_11_13_14++;
                                break;
                            case 16:
                                b16.setVisible(true);
                                player1.proprietatiPlayer.proprietati_16_18_19++;
                                break;
                            case 18:
                                b18.setVisible(true);
                                player1.proprietatiPlayer.proprietati_16_18_19++;
                                break;
                            case 19:
                                b19.setVisible(true);
                                player1.proprietatiPlayer.proprietati_16_18_19++;
                                break;
                            case 21:
                                b21.setVisible(true);
                                player1.proprietatiPlayer.proprietati_21_22_24++;
                                break;
                            case 22:
                                b22.setVisible(true);
                                player1.proprietatiPlayer.proprietati_21_22_24++;
                                break;
                            case 24:
                                b24.setVisible(true);
                                player1.proprietatiPlayer.proprietati_21_22_24++;
                                break;
                            case 26:
                                b26.setVisible(true);
                                player1.proprietatiPlayer.proprietati_26_28_29++;
                                break;
                            case 28:
                                b28.setVisible(true);
                                player1.proprietatiPlayer.proprietati_26_28_29++;
                                break;
                            case 29:
                                b29.setVisible(true);
                                player1.proprietatiPlayer.proprietati_26_28_29++;
                                break;
                            case 31:
                                b31.setVisible(true);
                                player1.proprietatiPlayer.proprietati_31_32_34++;
                                break;
                            case 32:
                                b32.setVisible(true);
                                player1.proprietatiPlayer.proprietati_31_32_34++;
                                break;
                            case 34:
                                b34.setVisible(true);
                                player1.proprietatiPlayer.proprietati_31_32_34++;
                                break;
                            case 37:
                                b37.setVisible(true);
                                player1.proprietatiPlayer.proprietati_37_39++;
                                break;
                            case 39:
                                b39.setVisible(true);
                                player1.proprietatiPlayer.proprietati_37_39++;
                                break;
                        }
                    }
                };
                //Daca banii sunt suficienti,vom putea cumpara proprietatea
                if (player1.bugetPlayer > proprietate.pretCumparare) {
                    bCumpara.addActionListener(actionListenerButon);
                } //daca nu,
                else {
                    labelNuAiBani.setText("Nu ai bani suficienti!");
                }
            }
        } else if (player == 2) { //Daca pica player 2
            panelAfisare.removeAll();
            panelAfisare.revalidate();
            panelAfisare.repaint();
            panelAfisare.add(proprietate);
            if (proprietate.proprietar == 0) { //In caz ca nu are proprietar,apare optiunea de a o cumpara
                bCumpara.setVisible(true);
                actionListenerButon = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        proprietate.cumparaProprietate(2);
                        player2.listaDomeniiPlayer.add(proprietate);
                        player2.bugetPlayer -= proprietate.pretCumparare;
                        afiseazaBuget();
                        bCumpara.setVisible(false);
                        //Afisarea butoanelor scurtatura in listele proprietatilor playerului
                        switch (proprietate.idProprietate) {
                            case 1:
                                b1_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_1_3++;

                                break;
                            case 3:
                                b3_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_1_3++;
                                break;
                            case 6:
                                b6_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_6_8_9++;
                                break;
                            case 8:
                                b8_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_6_8_9++;
                                break;
                            case 9:
                                b9_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_6_8_9++;
                                break;
                            case 11:
                                b11_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_11_13_14++;
                                break;
                            case 13:
                                b13_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_11_13_14++;
                                break;
                            case 14:
                                b14_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_11_13_14++;
                                break;
                            case 16:
                                b16_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_16_18_19++;
                                break;
                            case 18:
                                b18_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_16_18_19++;
                                break;
                            case 19:
                                b19_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_16_18_19++;
                                break;
                            case 21:
                                b21_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_21_22_24++;
                                break;
                            case 22:
                                b22_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_21_22_24++;
                                break;
                            case 24:
                                b24_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_21_22_24++;
                                break;
                            case 26:
                                b26_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_26_28_29++;
                                break;
                            case 28:
                                b28_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_26_28_29++;
                                break;
                            case 29:
                                b29_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_26_28_29++;
                                break;
                            case 31:
                                b31_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_31_32_34++;
                                break;
                            case 32:
                                b32_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_31_32_34++;
                                break;
                            case 34:
                                b34_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_31_32_34++;
                                break;
                            case 37:
                                b37_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_37_39++;
                                break;
                            case 39:
                                b39_2.setVisible(true);
                                player2.proprietatiPlayer.proprietati_37_39++;
                                break;
                        }
                    }
                };
                //Daca player2 are suficienti bani,va putea cumpara proprietatea
                if (player2.bugetPlayer > proprietate.pretCumparare) {
                    bCumpara.addActionListener(actionListenerButon);
                } //Daca nu,
                else {
                    labelNuAiBani.setText("Nu ai bani suficienti!");
                }
            }
        }
    }

    public void proprietateaEsteCumparataDeTine(Proprietate proprietate, int player) {
        if (player == 1) { //Daca pica player1
            if (proprietate.proprietar == 1) {//Daca proprietatea este a ta,
                bCumpara.setVisible(false);
                if ( //DACA PE POZITIA IN CARE ESTI AI CUMPARATE TOATE PROPRIETATILE DE ACEEASI CULOARE
                        (proprietate.idProprietate == 1 && player1.proprietatiPlayer.proprietati_1_3 == 2)
                        || (proprietate.idProprietate == 3 && player1.proprietatiPlayer.proprietati_1_3 == 2)
                        || (proprietate.idProprietate == 6 && player1.proprietatiPlayer.proprietati_6_8_9 == 3)
                        || (proprietate.idProprietate == 8 && player1.proprietatiPlayer.proprietati_6_8_9 == 3)
                        || (proprietate.idProprietate == 9 && player1.proprietatiPlayer.proprietati_6_8_9 == 3)
                        || (proprietate.idProprietate == 11 && player1.proprietatiPlayer.proprietati_11_13_14 == 3)
                        || (proprietate.idProprietate == 13 && player1.proprietatiPlayer.proprietati_11_13_14 == 3)
                        || (proprietate.idProprietate == 14 && player1.proprietatiPlayer.proprietati_11_13_14 == 3)
                        || (proprietate.idProprietate == 16 && player1.proprietatiPlayer.proprietati_16_18_19 == 3)
                        || (proprietate.idProprietate == 18 && player1.proprietatiPlayer.proprietati_16_18_19 == 3)
                        || (proprietate.idProprietate == 19 && player1.proprietatiPlayer.proprietati_16_18_19 == 3)
                        || (proprietate.idProprietate == 21 && player1.proprietatiPlayer.proprietati_21_22_24 == 3)
                        || (proprietate.idProprietate == 22 && player1.proprietatiPlayer.proprietati_21_22_24 == 3)
                        || (proprietate.idProprietate == 24 && player1.proprietatiPlayer.proprietati_21_22_24 == 3)
                        || (proprietate.idProprietate == 26 && player1.proprietatiPlayer.proprietati_26_28_29 == 3)
                        || (proprietate.idProprietate == 28 && player1.proprietatiPlayer.proprietati_26_28_29 == 3)
                        || (proprietate.idProprietate == 29 && player1.proprietatiPlayer.proprietati_26_28_29 == 3)
                        || (proprietate.idProprietate == 31 && player1.proprietatiPlayer.proprietati_31_32_34 == 3)
                        || (proprietate.idProprietate == 32 && player1.proprietatiPlayer.proprietati_31_32_34 == 3)
                        || (proprietate.idProprietate == 34 && player1.proprietatiPlayer.proprietati_31_32_34 == 3)
                        || (proprietate.idProprietate == 37 && player1.proprietatiPlayer.proprietati_37_39 == 2)
                        || (proprietate.idProprietate == 39 && player1.proprietatiPlayer.proprietati_37_39 == 2)) {

                    //Daca nu s-a atins inca numarul maxim de magazine
                    if (proprietate.numarMagazine < 4) {
                        bCumparaMagazin.setVisible(true);
                        actionListenerButonCumparaMagazin = new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                if (player1.bugetPlayer >= proprietate.pretMagazin) {
                                    proprietate.numarMagazine++;
                                    player1.bugetPlayer -= proprietate.pretMagazin;
                                    afiseazaBuget();
                                    switch (proprietate.numarMagazine) {
                                        case 1:
                                            proprietate.chirie = proprietate.chirieCandAi1Magazin;
                                            break;
                                        case 2:
                                            proprietate.chirie = proprietate.chirieCandAi2Magazine;
                                            break;
                                        case 3:
                                            proprietate.chirie = proprietate.chirieCandAi3Magazine;
                                            break;
                                        case 4:
                                            proprietate.chirie = proprietate.chirieCandAi4Magazine;
                                            proprietate.seMaiPotConstruiMagazine = false;
                                            bCumparaMagazin.setVisible(false);
                                            break;
                                    }
                                    proprietate.setLabelChirie(proprietate.chirie);

                                } else {
                                    labelNuAiBani.setText("Nu ai bani suficienti");
                                }
                            }
                        };
                        bCumparaMagazin.addActionListener(actionListenerButonCumparaMagazin);
                    } //Daca avem deja 4 magazine,putem construi supermarketul
                    else if (proprietate.seMaiPotConstruiMagazine == false && proprietate.seMaiPoateConstruiSupermarket) {
                        bCumparaMagazin.setVisible(false);
                        bCumparaSupermarket.setVisible(true);
                        actionListenerButonCumparaSupermarket = new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                if (player1.bugetPlayer >= proprietate.pretSupernarket) {
                                    player1.bugetPlayer -= proprietate.pretSupernarket;
                                    proprietate.chirie = proprietate.chirieCandAiSupermarket;
                                    proprietate.numarMagazine++;
                                    proprietate.setLabelChirie(proprietate.chirie);
                                    afiseazaBuget();
                                    proprietate.seMaiPoateConstruiSupermarket = false;
                                    bCumparaSupermarket.setVisible(false);
                                } else {
                                    labelNuAiBani.setText("Nu ai bani suficienti");
                                }
                            }
                        };
                        bCumparaSupermarket.addActionListener(actionListenerButonCumparaSupermarket);
                    }
                }

            }
        } else if (player == 2) { //Daca player2 pica pe proprietate:
            if (proprietate.proprietar == 2) { //Daca proprietatea este deja a ta
                bCumpara.setVisible(false);
                if ( //DACA PE POZITIA IN CARE ESTI AI CUMPARATE TOATE PROPRIETATILE DE ACEEASI CULOARE
                        (proprietate.idProprietate == 1 && player2.proprietatiPlayer.proprietati_1_3 == 2)
                        || (proprietate.idProprietate == 3 && player2.proprietatiPlayer.proprietati_1_3 == 2)
                        || (proprietate.idProprietate == 6 && player2.proprietatiPlayer.proprietati_6_8_9 == 3)
                        || (proprietate.idProprietate == 8 && player2.proprietatiPlayer.proprietati_6_8_9 == 3)
                        || (proprietate.idProprietate == 9 && player2.proprietatiPlayer.proprietati_6_8_9 == 3)
                        || (proprietate.idProprietate == 11 && player2.proprietatiPlayer.proprietati_11_13_14 == 3)
                        || (proprietate.idProprietate == 13 && player2.proprietatiPlayer.proprietati_11_13_14 == 3)
                        || (proprietate.idProprietate == 14 && player2.proprietatiPlayer.proprietati_11_13_14 == 3)
                        || (proprietate.idProprietate == 16 && player2.proprietatiPlayer.proprietati_16_18_19 == 3)
                        || (proprietate.idProprietate == 18 && player2.proprietatiPlayer.proprietati_16_18_19 == 3)
                        || (proprietate.idProprietate == 19 && player2.proprietatiPlayer.proprietati_16_18_19 == 3)
                        || (proprietate.idProprietate == 21 && player2.proprietatiPlayer.proprietati_21_22_24 == 3)
                        || (proprietate.idProprietate == 22 && player2.proprietatiPlayer.proprietati_21_22_24 == 3)
                        || (proprietate.idProprietate == 24 && player2.proprietatiPlayer.proprietati_21_22_24 == 3)
                        || (proprietate.idProprietate == 26 && player2.proprietatiPlayer.proprietati_26_28_29 == 3)
                        || (proprietate.idProprietate == 28 && player2.proprietatiPlayer.proprietati_26_28_29 == 3)
                        || (proprietate.idProprietate == 29 && player2.proprietatiPlayer.proprietati_26_28_29 == 3)
                        || (proprietate.idProprietate == 31 && player2.proprietatiPlayer.proprietati_31_32_34 == 3)
                        || (proprietate.idProprietate == 32 && player2.proprietatiPlayer.proprietati_31_32_34 == 3)
                        || (proprietate.idProprietate == 34 && player2.proprietatiPlayer.proprietati_31_32_34 == 3)
                        || (proprietate.idProprietate == 37 && player2.proprietatiPlayer.proprietati_37_39 == 2)
                        || (proprietate.idProprietate == 39 && player2.proprietatiPlayer.proprietati_37_39 == 2)) {

                    //Daca nu s a atins numarul maxim de magazine
                    if (proprietate.numarMagazine < 4) {
                        bCumparaMagazin.setVisible(true);
                        actionListenerButonCumparaMagazin = new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                if (player2.bugetPlayer >= proprietate.pretMagazin) {
                                    proprietate.numarMagazine++;
                                    player2.bugetPlayer -= proprietate.pretMagazin;
                                    afiseazaBuget();
                                    switch (proprietate.numarMagazine) {
                                        case 1:
                                            proprietate.chirie = proprietate.chirieCandAi1Magazin;
                                            break;
                                        case 2:
                                            proprietate.chirie = proprietate.chirieCandAi2Magazine;
                                            break;
                                        case 3:
                                            proprietate.chirie = proprietate.chirieCandAi3Magazine;
                                            break;
                                        case 4:
                                            proprietate.chirie = proprietate.chirieCandAi4Magazine;
                                            proprietate.seMaiPotConstruiMagazine = false;
                                            bCumparaMagazin.setVisible(false);
                                            break;
                                    }
                                    proprietate.setLabelChirie(proprietate.chirie);
                                } else {
                                    labelNuAiBani.setText("Nu ai bani suficienti");
                                }
                            }
                        };
                        bCumparaMagazin.addActionListener(actionListenerButonCumparaMagazin);
                    } //Daca avem deja 4 magazine,putem construi supermarketul
                    else if (!proprietate.seMaiPotConstruiMagazine && proprietate.seMaiPoateConstruiSupermarket) {
                        bCumparaMagazin.setVisible(false);
                        bCumparaSupermarket.setVisible(true);
                        actionListenerButonCumparaSupermarket = new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                if (player2.bugetPlayer >= proprietate.pretSupernarket) {
                                    player2.bugetPlayer -= proprietate.pretSupernarket;
                                    afiseazaBuget();
                                    proprietate.chirie = proprietate.chirieCandAiSupermarket;
                                    proprietate.setLabelChirie(proprietate.chirie);
                                    proprietate.numarMagazine++;
                                    proprietate.seMaiPoateConstruiSupermarket = false;
                                    bCumparaSupermarket.setVisible(false);
                                } else {
                                    labelNuAiBani.setText("Nu ai bani suficienti");
                                }
                            }
                        };
                        bCumparaSupermarket.addActionListener(actionListenerButonCumparaSupermarket);
                    }
                }
            }
        }
    }

    public void proprietateaAdversarului(Proprietate proprietate, int player) {

        if (player == 1) {//Daca player 1 pica
//Iar proprietatea apartine adversarului,
            if (proprietate.proprietar == 2) {
                player1.bugetPlayer -= proprietate.chirie;
                player2.bugetPlayer += proprietate.chirie;
                bCumpara.setVisible(false);
                bCumparaMagazin.setVisible(false);
                bCumparaSupermarket.setVisible(false);
            }
        } else if (player == 2) {//Daca player 1 pica
//Iar proprietatea apartine adversarului,
            if (proprietate.proprietar == 1) {
                player2.bugetPlayer -= proprietate.chirie;
                player1.bugetPlayer += proprietate.chirie;
                bCumpara.setVisible(false);
                bCumparaMagazin.setVisible(false);
                bCumparaSupermarket.setVisible(false);
            }
        }
    }

    //In cazul metrourilor:
    public void metroulNuEsteCumparat(Train metrou, int player) {
        if (player == 1) {
            panelAfisare.add(metrou);
            if (metrou.proprietar == 0) { //In caz ca nu are proprietar,apare optiunea de a o cumpara
                bCumpara.setVisible(true);
                actionListenerButon = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        metrou.cumparaStatia(1);
                        player1.listaDomeniiPlayer.add(metrou);
                        player1.bugetPlayer -= 200;
                        player1.numarMetrouriCumparate++;
                        bCumpara.setVisible(false);
                        switch (metrou.idMetrou) {
                            case 5:
                                b5.setVisible(true);
                                break;
                            case 15:
                                b15.setVisible(true);
                                break;
                            case 25:
                                b25.setVisible(true);
                                break;
                            case 35:
                                b35.setVisible(true);
                                break;
                        }

                    }
                };
                bCumpara.addActionListener(actionListenerButon);
            }
        } else if (player == 2) {
            panelAfisare.add(metrou);
            if (metrou.proprietar == 0) { //In caz ca nu are proprietar,apare optiunea de a o cumpara
                bCumpara.setVisible(true);
                actionListenerButon = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        metrou.cumparaStatia(2);
                        player2.listaDomeniiPlayer.add(metrou);
                        player2.numarMetrouriCumparate++;
                        bCumpara.setVisible(false);
                        player2.bugetPlayer -= 200;
                        switch (metrou.idMetrou) {
                            case 5:
                                b5_2.setVisible(true);
                                break;
                            case 15:
                                b15_2.setVisible(true);
                                break;
                            case 25:
                                b25_2.setVisible(true);
                                break;
                            case 35:
                                b35_2.setVisible(true);
                                break;
                        }
                    }
                };
                bCumpara.addActionListener(actionListenerButon);
            }
        }
    }

    public void metroulEsteCumparatDeTine(Train metrou, int player) {
        if (player == 1) {
            if (metrou.proprietar == 1) {
                bCumpara.setVisible(false);
            }
        } else if (player == 2) {
            if (metrou.proprietar == 2) {
                bCumpara.setVisible(false);
            }
        }
    }

    public void metroulAdversarului(Train metrou, int player) {
        if (player == 1) {
            if (metrou.proprietar == 2) {
                int plata = 25;
                if (player1.numarMetrouriCumparate == 2) {
                    plata *= 2;
                }
                if (player1.numarMetrouriCumparate == 3) {
                    plata *= 4;
                }
                if (player1.numarMetrouriCumparate == 4) {
                    plata *= 8;
                }
                player2.bugetPlayer += plata;
                player1.bugetPlayer -= plata;
                afiseazaBuget();
            }
        } else if (player == 2) {
            if (metrou.proprietar == 1) {
                int plata = 25;
                if (player2.numarMetrouriCumparate == 2) {
                    plata = 50;
                }
                if (player2.numarMetrouriCumparate == 3) {
                    plata = 100;
                }
                if (player2.numarMetrouriCumparate == 4) {
                    plata = 200;
                }
                player1.bugetPlayer += plata;
                player2.bugetPlayer -= plata;
            }
        }
    }

    //In cazul Fabricilor
    public void fabricaNuEsteCumparata(Fabrica fabrica, int player) {
        panelAfisare.add(fabrica);
        if (player == 1) {
            if (fabrica.proprietar == 0) { //In caz ca nu are proprietar,apare optiunea de a o cumpara
                bCumpara.setVisible(true);
                actionListenerButon = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        fabrica.cumparaFabrica(1);
                        player1.listaDomeniiPlayer.add(fabrica);
                        player1.numarDeFabriciCumparate++;
                        player1.bugetPlayer -= 150;
                        b12.setVisible(true);
                    }

                };
                bCumpara.addActionListener(actionListenerButon);
            }
        } else if (player == 2) {
            if (fabrica.proprietar == 0) { //In caz ca nu are proprietar,apare optiunea de a o cumpara
                bCumpara.setVisible(true);
                actionListenerButon = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        fabrica.cumparaFabrica(2);
                        player2.listaDomeniiPlayer.add(fabrica);
                        player2.numarDeFabriciCumparate++;
                        player2.bugetPlayer -= 150;
                        b12_2.setVisible(true);
                    }

                };
                bCumpara.addActionListener(actionListenerButon);
            }
        }

    }

    public void fabricaCumparataDeTine(Fabrica fabrica, int player) {
        if (player == 1 && fabrica.proprietar == 1) {
            bCumpara.setVisible(false);
        } else if (player == 2 && fabrica.proprietar == 2) {
            bCumpara.setVisible(false);
        }
    }

    public void fabricaCumparataDeAdversar(Fabrica fabrica, int player) {
        //Daca adversarul pica pe fabrica ta si detii o singura fabrica,vei primi 
        //de 5 ori valoarea zarului.Daca detii 2 fabrici,vei primi valoarea de 10 ori
        int sumaPlatita = zar1 + zar2;
        if (player == 1) {
            if (fabrica.proprietar == 2) {
                if (player2.numarDeFabriciCumparate == 2) {
                    player1.bugetPlayer -= sumaPlatita * 10;
                    player2.bugetPlayer += sumaPlatita * 10;
                } else if (player2.numarDeFabriciCumparate == 1) {
                    player1.bugetPlayer -= sumaPlatita * 5;
                    player2.bugetPlayer += sumaPlatita * 5;
                }

            }
        } else if (player == 2) {
            if (fabrica.proprietar == 1) {
                if (player1.numarDeFabriciCumparate == 2) {
                    player1.bugetPlayer += sumaPlatita * 10;
                    player2.bugetPlayer -= sumaPlatita * 10;
                } else if (player1.numarDeFabriciCumparate == 1) {
                    player1.bugetPlayer += sumaPlatita * 5;
                    player2.bugetPlayer -= sumaPlatita * 5;
                }

            }

        }
    }

    //Metode-Ce se intampla in cazul in care jcatorii trec prin start
    public void dacaPlayer1TrecePrinStart() {
        if (player1.pozitieNouaPlayer > 39 && player1.pozitiePlayer == 39) {
            player1.pozitiePlayer = 0;
            ascundePioniiPlayer1();
            poz0.setIcon(iconPion);
            player1.bugetPlayer += 200;
            player1.pozitieNouaPlayer = player1.pozitieNouaPlayer - 40;
            afiseazaBuget();
        }
    }

    public void dacaPlayer2TrecePrinStart() {
        if (player2.pozitieNouaPlayer > 39 && player2.pozitiePlayer == 39) {
            player2.pozitiePlayer = 0;
            ascundePioniiPlayer2();
            pozitieP2_0.setIcon(iconPion2);
            player2.bugetPlayer += 200;
            player2.pozitieNouaPlayer = player2.pozitieNouaPlayer - 40;
            afiseazaBuget();
        }
    }

    //Metodele folosite cand jucatorii pica pe una din proprietati:
    //Se verifica toate cele trei cazuri din metodele de mai sus:
    //Daca proprietatea este necumparata,in posesia ta,sau a adversarului
    public void player1PicaPe(Proprietate proprietate) {
        proprietateaNuEsteCumparata(proprietate, 1);
        proprietateaEsteCumparataDeTine(proprietate, 1);
        proprietateaAdversarului(proprietate, 1);
    }

    public void player2PicaPe(Proprietate proprietate) {
        proprietateaNuEsteCumparata(proprietate, 2);
        proprietateaEsteCumparataDeTine(proprietate, 2);
        proprietateaAdversarului(proprietate, 2);
    }

    //Metodele folosite cand jucatorii pica pe una din statiile de metrou
    //Se verifica toate cele trei cazuri din metodele de mai sus:
    //Daca statia de metrou este necumparata,in posesia ta,sau a adversarului
    public void player1PicaPeStatiaDeMetrou(Train metrou) {
        metroulNuEsteCumparat(metrou, 1);
        metroulEsteCumparatDeTine(metrou, 1);
        metroulAdversarului(metrou, 1);
        afiseazaBuget();
    }

    public void player2PicaPeStatiaDeMetrou(Train metrou) {
        metroulNuEsteCumparat(metrou, 2);
        metroulEsteCumparatDeTine(metrou, 2);
        metroulAdversarului(metrou, 2);
        afiseazaBuget();
    }

    //Metodele folosite cand jucatorii pica pe una din cele 2 fabrici
    //Se verifica toate cele trei cazuri din metodele de mai sus:
    //Daca fabrica este necumparata,in posesia ta,sau a adversarului
    public void player1PicaPeFabrica(Fabrica fabrica) {
        fabricaNuEsteCumparata(fabrica, 1);
        fabricaCumparataDeTine(fabrica, 1);
        fabricaCumparataDeAdversar(fabrica, 1);
    }

    public void player2PicaPeFabrica(Fabrica fabrica) {
        fabricaNuEsteCumparata(fabrica, 2);
        fabricaCumparataDeTine(fabrica, 2);
        fabricaCumparataDeAdversar(fabrica, 2);
    }

    //Metode:ce se intampla cand jucatorii pica pe chance/chest
    public void player1PicaPeChance() {
        trageCarteChance();
        switch (carteChanceAleasa) {
            case 0:
                player1.pozitiePlayer = 0;
                player1.pozitieNouaPlayer = 0;
                player1.bugetPlayer += 200;
                ascundePioniiPlayer1();
                poz0.setIcon(iconPion);
                break;
            case 1:
                player1.pozitiePlayer = 37;
                player1.pozitieNouaPlayer = 37;
                ascundePioniiPlayer1();
                poz37.setIcon(iconPion);
                player1PicaPe(Dorobanti);
                panelAfisare.revalidate();
                panelAfisare.repaint();
                break;
            case 2:
                player1.bugetPlayer -= 150;
                break;
            case 3:
                player1.pozitiePlayer = 10;
                player1.pozitieNouaPlayer = 10;
                player1.asteptarePlayer = 2;
                ascundePioniiPlayer1();
                poz10.setIcon(iconPion);
                break;
            case 4:
                player1.bugetPlayer += 100;
                player1.bugetPlayer -= 100;
                break;
            case 5:
                if (player1.pozitieNouaPlayer == 7) {
                    player1.pozitiePlayer = 15;
                    player1.pozitieNouaPlayer = 15;
                    ascundePioniiPlayer1();
                    poz15.setIcon(iconPion);
                    player1PicaPeStatiaDeMetrou(metrou2);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                } else if (player1.pozitieNouaPlayer == 23) {
                    player1.pozitiePlayer = 25;
                    player1.pozitieNouaPlayer = 25;
                    ascundePioniiPlayer1();
                    poz25.setIcon(iconPion);
                    player1PicaPeStatiaDeMetrou(metrou3);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                } else if (player1.pozitieNouaPlayer == 36) {
                    player1.pozitiePlayer = 5;
                    player1.pozitieNouaPlayer = 5;
                    player1.bugetPlayer += 200;
                    ascundePioniiPlayer1();
                    poz5.setIcon(iconPion);
                    player1PicaPeStatiaDeMetrou(metrou1);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                }
                break;
            case 6:
                player2.bugetPlayer -= 150;
                break;
            case 7:
                player1.bugetPlayer -= 200;
                break;
            case 8:
                player1.bugetPlayer += 100;
                player2.bugetPlayer -= 100;
                break;
            case 9:
                player1.pozitiePlayer = 32;
                player1.pozitieNouaPlayer = 32;
                ascundePioniiPlayer1();
                poz32.setIcon(iconPion);
                player1PicaPe(AfiPalace);
                panelAfisare.revalidate();
                panelAfisare.repaint();
                break;
        }
    }

    public void player1PicaPeChest() {
        trageCarteChest();
        switch (carteChestAleasa) {
            case 0:
                player1.pozitiePlayer = 0;
                player1.pozitieNouaPlayer = 0;
                player1.bugetPlayer += 200;
                ascundePioniiPlayer1();
                poz0.setIcon(iconPion);
                break;
            case 1:
                player1.pozitiePlayer = 37;
                player1.pozitieNouaPlayer = 37;
                ascundePioniiPlayer1();
                poz37.setIcon(iconPion);
                player1PicaPe(Dorobanti);
                panelAfisare.revalidate();
                panelAfisare.repaint();
                break;
            case 2:
                player1.bugetPlayer -= 150;
                break;
            case 3:
                player1.pozitiePlayer = 10;
                player1.pozitieNouaPlayer = 10;
                ascundePioniiPlayer1();
                player1.asteptarePlayer = 2;
                poz10.setIcon(iconPion);
                break;
            case 4:
                player1.bugetPlayer += 100;
                player2.bugetPlayer -= 100;
                break;
            case 5:
                if (player1.pozitieNouaPlayer == 2) {
                    player1.pozitiePlayer = 5;
                    player1.pozitieNouaPlayer = 5;
                    ascundePioniiPlayer1();
                    poz15.setIcon(iconPion);
                    player1PicaPeStatiaDeMetrou(metrou1);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                } else if (player1.pozitieNouaPlayer == 17) {
                    player1.pozitiePlayer = 25;
                    player1.pozitieNouaPlayer = 25;
                    ascundePioniiPlayer1();
                    poz25.setIcon(iconPion);
                    player1PicaPeStatiaDeMetrou(metrou3);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                } else if (player1.pozitieNouaPlayer == 33) {
                    player1.pozitiePlayer = 35;
                    player1.pozitieNouaPlayer = 35;
                    player1.bugetPlayer += 200;
                    ascundePioniiPlayer1();
                    poz35.setIcon(iconPion);
                    player1PicaPeStatiaDeMetrou(metrou4);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                }
                break;
            case 6:
                player2.bugetPlayer -= 150;
                break;
            case 7:
                player1.bugetPlayer -= 200;
                break;
            case 8:
                player1.bugetPlayer += 100;
                player2.bugetPlayer -= 100;
                break;
            case 9:
                player1.pozitiePlayer = 32;
                player1.pozitieNouaPlayer = 32;
                player1PicaPe(AfiPalace);
                ascundePioniiPlayer1();
                poz32.setIcon(iconPion);
                break;
        }
    }

    public void player2PicaPeChance() {
        trageCarteChance();
        switch (carteChanceAleasa) {
            case 0:
                player2.pozitiePlayer = 0;
                player2.pozitieNouaPlayer = 0;
                player2.bugetPlayer += 200;
                ascundePioniiPlayer2();
                pozitieP2_0.setIcon(iconPion2);
                break;
            case 1:
                player2.pozitiePlayer = 37;
                player2.pozitieNouaPlayer = 37;
                ascundePioniiPlayer2();
                pozitieP2_37.setIcon(iconPion2);
                player2PicaPe(Dorobanti);
                panelAfisare.revalidate();
                panelAfisare.repaint();
                break;
            case 2:
                player2.bugetPlayer -= 150;
                break;
            case 3:
                player2.pozitiePlayer = 10;
                player2.pozitieNouaPlayer = 10;
                player2.asteptarePlayer = 2;
                ascundePioniiPlayer2();
                pozInchisoare.setIcon(iconPion2);
                break;
            case 4:
                player2.bugetPlayer += 100;
                player1.bugetPlayer -= 100;
                break;
            case 5:
                if (player2.pozitieNouaPlayer == 7) {
                    player2.pozitiePlayer = 15;
                    player2.pozitieNouaPlayer = 15;
                    ascundePioniiPlayer2();
                    pozitieP2_15.setIcon(iconPion2);
                    player2PicaPeStatiaDeMetrou(metrou2);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                } else if (player2.pozitieNouaPlayer == 23) {
                    player2.pozitiePlayer = 25;
                    player2.pozitieNouaPlayer = 25;
                    ascundePioniiPlayer2();
                    pozitieP2_25.setIcon(iconPion2);
                    player2PicaPeStatiaDeMetrou(metrou3);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                } else if (player2.pozitieNouaPlayer == 36) {
                    player2.pozitiePlayer = 5;
                    player2.pozitieNouaPlayer = 5;
                    ascundePioniiPlayer2();
                    pozitieP2_5.setIcon(iconPion2);
                    player2.bugetPlayer += 200;
                    player2PicaPeStatiaDeMetrou(metrou1);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                }
                break;
            case 6:
                player1.bugetPlayer -= 150;
                break;
            case 7:
                player2.bugetPlayer -= 200;
                break;
            case 8:
                player2.bugetPlayer += 100;
                player1.bugetPlayer -= 100;
                break;
            case 9:
                player2.pozitiePlayer = 32;
                player2.pozitieNouaPlayer = 32;
                ascundePioniiPlayer2();
                pozitieP2_32.setIcon(iconPion2);
                player2PicaPe(AfiPalace);
                panelAfisare.revalidate();
                panelAfisare.repaint();
                break;
        }
    }

    public void player2PicaPeChest() {
        trageCarteChest();
        switch (carteChestAleasa) {
            case 0:
                player2.pozitiePlayer = 0;
                player2.pozitieNouaPlayer = 0;
                player2.bugetPlayer += 200;
                ascundePioniiPlayer2();
                poz0.setIcon(iconPion2);
                break;
            case 1:
                player2.pozitiePlayer = 37;
                player2.pozitieNouaPlayer = 37;
                ascundePioniiPlayer2();
                poz37.setIcon(iconPion2);
                player2PicaPe(Dorobanti);
                panelAfisare.revalidate();
                panelAfisare.repaint();
                break;
            case 2:
                player2.bugetPlayer -= 150;
                break;
            case 3:
                player2.pozitiePlayer = 10;
                player2.pozitieNouaPlayer = 10;
                ascundePioniiPlayer2();
                player2.asteptarePlayer = 2;
                pozInchisoare.setIcon(iconPion2);
                break;
            case 4:
                player2.bugetPlayer += 100;
                player1.bugetPlayer -= 100;
                break;
            case 5:
                if (player2.pozitieNouaPlayer == 2) {
                    player2.pozitiePlayer = 5;
                    player2.pozitieNouaPlayer = 5;
                    ascundePioniiPlayer2();
                    poz5.setIcon(iconPion2);
                    player2PicaPeStatiaDeMetrou(metrou1);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                } else if (player2.pozitieNouaPlayer == 17) {
                    player2.pozitiePlayer = 25;
                    player2.pozitieNouaPlayer = 25;
                    ascundePioniiPlayer2();
                    poz25.setIcon(iconPion2);
                    player2PicaPeStatiaDeMetrou(metrou3);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                } else if (player2.pozitieNouaPlayer == 33) {
                    player2.pozitiePlayer = 35;
                    player2.pozitieNouaPlayer = 35;
                    ascundePioniiPlayer2();
                    poz35.setIcon(iconPion2);
                    player2PicaPeStatiaDeMetrou(metrou4);
                    panelAfisare.revalidate();
                    panelAfisare.repaint();
                }
                break;
            case 6:
                player1.bugetPlayer -= 150;
                break;
            case 7:
                player2.bugetPlayer -= 200;
                break;
            case 8:
                player2.bugetPlayer += 100;
                player1.bugetPlayer -= 100;
                break;
            case 9:
                player2.pozitiePlayer = 32;
                player2.pozitieNouaPlayer = 32;
                ascundePioniiPlayer2();
                poz32.setIcon(iconPion2);
                player2PicaPe(AfiPalace);
                panelAfisare.revalidate();
                panelAfisare.repaint();
                break;
        }
    }

    //Metode:ce se intampla daca playerii pica in inchisoare
    private void dacaPlayer1PicaInInchisoare() {
        if (player1.pozitieNouaPlayer == 30) { //inchisoare
            player1.pozitiePlayer = 10;
            player1.asteptarePlayer = 2;
            player1.pozitieNouaPlayer = 10;
            ascundePioniiPlayer1();
            pozInchisoare.setIcon(iconPion);
        }
    }

    public void dacaPlayer2PicaInInchisoare() {
        if (player2.pozitieNouaPlayer == 30) { //inchisoare
            player2.pozitiePlayer = 10;
            player2.pozitieNouaPlayer = 10;
            player2.asteptarePlayer = 2;
            ascundePioniiPlayer2();
            pozitieP2_Inchisoare.setIcon(iconPion2);
        }
    }

    //Metoda de pornire a zarurilor la apasarea butonului
    private void daCuZarul() {
        butonZaruri.setVisible(false);
        if (zar1 != zar2) {
            turn++;
        }
        timerZaruri.start();
    }

    //Metode folosite pentru extragerea cartilor Chance si Chest
    private void trageCarteChance() {
        carteChanceAleasa = (int) (Math.random() * listaChance.size());
        System.out.println("Cartea chance aleasa:" + carteChanceAleasa);
        System.out.println("Pozitie player1:" + player1.pozitiePlayer);
        System.out.println("PozitiePlayer2:" + player2.pozitiePlayer);
        carteChanceTrasa = listaChance.get(carteChanceAleasa);
        switch (carteChanceAleasa) {
            case 0:
                carteChanceTrasa.afisareText("Sari direct la START.Primesti 200");
                break;
            case 1:
                carteChanceTrasa.afisareText("Avanseaza pana la Dorobanti");
                break;
            case 2:
                carteChanceTrasa.afisareText("Ai intarziat cu impozitele!Platesti 150!");
                break;
            case 3:
                carteChanceTrasa.afisareText("Du-te la inchisoare");
                break;
            case 4:
                carteChanceTrasa.afisareText("Colecteaza 100$ de la adversar");
                break;
            case 5:
                carteChanceTrasa.afisareText("Avanseaza pana la prima Gara.");
                break;
            case 6:
                carteChanceTrasa.afisareText("Oponentului tau i s-a furat 150$");
                break;
            case 7:
                carteChanceTrasa.afisareText("Ti s-au furat 200$");
                break;
            case 8:
                carteChanceTrasa.afisareText("Adversarul tau ti-a oferit 100$");
                break;
            case 9:
                carteChanceTrasa.afisareText("Sari direct la mall Afi");
                break;
        }
        panelChance.setVisible(true);
        panelChance.add(carteChanceTrasa);
    }

    private void trageCarteChest() {
        carteChestAleasa = (int) (Math.random() * listaChest.size());
        carteChestTrasa = listaChest.get(carteChestAleasa);
        System.out.println("Cartea chest aleasa:" + carteChestAleasa);
        System.out.println("Pozitie player1:" + player1.pozitiePlayer);
        System.out.println("PozitiePlayer2:" + player2.pozitiePlayer);
        switch (carteChestAleasa) {
            case 0:
                carteChestTrasa.afisareText("Sari direct la START.Primesti 200");
                break;
            case 1:
                carteChestTrasa.afisareText("Avanseaza pana la Dorobanti");
                break;
            case 2:
                carteChestTrasa.afisareText("Ai intarziat cu impozitele!Platesti 150!");
                break;
            case 3:
                carteChestTrasa.afisareText("Du-te la inchisoare");
                break;
            case 4:
                carteChestTrasa.afisareText("Colecteaza 100$ de la adversar");
                break;
            case 5:
                carteChestTrasa.afisareText("Avanseaza pana la prima Gara.");
                break;
            case 6:
                carteChestTrasa.afisareText("Oponentului tau i s-a furat 150$");
                break;
            case 7:
                carteChestTrasa.afisareText("Ti s-au furat 200$");
                break;
            case 8:
                carteChestTrasa.afisareText("Adversarul tau ti-a oferit 100$");
                break;
            case 9:
                carteChestTrasa.afisareText("Sari direct la mall Afi");
                break;
        }
        panelChest.setVisible(true);
        panelChest.add(carteChestTrasa);
    }

    //Afisarea bugetului pe ecran si deciderea castigatorului
    public void afiseazaBuget() {
        labelBuget.setText(String.valueOf(player1.bugetPlayer));
        labelBugetPlayer2.setText(String.valueOf(player2.bugetPlayer));
        if (player1.bugetPlayer <= 0) {
            panelStart.setVisible(true);
            labelWinner.setText("Winner:Player 2");
        } else if (player2.bugetPlayer <= 0) {
            panelStart.setVisible(true);
            labelWinner.setText("Winner:Player 1");
        }
    }

    //Setter:Trade
    public void setTrade(Trade t) {
        this.trade = t;
    }

    //Constructor
    public Map() {
        initComponents();
        panelChance.setVisible(false);
        panelChest.setVisible(false);
        butonZaruri.setVisible(false);
        bIncheieTura.setVisible(false);
        bEndGame.setVisible(false);
        butonTrade.setVisible(false);
        bCumpara.setVisible(false);
        bCumparaMagazin.setVisible(false);
        bCumparaSupermarket.setVisible(false);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        for (int i = 0; i < 10; i++) {
            listaChance.put(i, new Chance());
        }
        for (int i = 0; i < 10; i++) {
            listaChest.put(i, new Chest());
        }
        ascundeToateButoaneleProprietatilor();
        adaugaToateDomeniileInListe();
        listaPlayeri.add(player1);
        listaPlayeri.add(player2);
        Image backgroundInitial = backgroundStart.getImage();
        Image imagineNoua = backgroundInitial.getScaledInstance(1400, 750, Image.SCALE_SMOOTH);
        labelBackgroundStart.setIcon(new ImageIcon(imagineNoua));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelStart = new javax.swing.JPanel();
        bStart = new javax.swing.JButton();
        labelWinner = new javax.swing.JLabel();
        bInfo = new javax.swing.JButton();
        labelBackgroundStart = new javax.swing.JLabel();
        poz0 = new javax.swing.JLabel();
        poz1 = new javax.swing.JLabel();
        poz2 = new javax.swing.JLabel();
        poz3 = new javax.swing.JLabel();
        poz4 = new javax.swing.JLabel();
        poz5 = new javax.swing.JLabel();
        poz6 = new javax.swing.JLabel();
        poz7 = new javax.swing.JLabel();
        poz8 = new javax.swing.JLabel();
        poz9 = new javax.swing.JLabel();
        poz10 = new javax.swing.JLabel();
        poz11 = new javax.swing.JLabel();
        poz12 = new javax.swing.JLabel();
        poz13 = new javax.swing.JLabel();
        poz14 = new javax.swing.JLabel();
        poz15 = new javax.swing.JLabel();
        poz16 = new javax.swing.JLabel();
        poz17 = new javax.swing.JLabel();
        poz18 = new javax.swing.JLabel();
        poz19 = new javax.swing.JLabel();
        poz20 = new javax.swing.JLabel();
        poz21 = new javax.swing.JLabel();
        poz22 = new javax.swing.JLabel();
        poz23 = new javax.swing.JLabel();
        poz24 = new javax.swing.JLabel();
        poz25 = new javax.swing.JLabel();
        poz26 = new javax.swing.JLabel();
        poz27 = new javax.swing.JLabel();
        poz28 = new javax.swing.JLabel();
        poz29 = new javax.swing.JLabel();
        poz30 = new javax.swing.JLabel();
        poz31 = new javax.swing.JLabel();
        poz32 = new javax.swing.JLabel();
        poz33 = new javax.swing.JLabel();
        poz34 = new javax.swing.JLabel();
        poz35 = new javax.swing.JLabel();
        poz36 = new javax.swing.JLabel();
        poz37 = new javax.swing.JLabel();
        poz38 = new javax.swing.JLabel();
        poz39 = new javax.swing.JLabel();
        pozInchisoare = new javax.swing.JLabel();
        pozitieP2_0 = new javax.swing.JLabel();
        pozitieP2_1 = new javax.swing.JLabel();
        pozitieP2_2 = new javax.swing.JLabel();
        pozitieP2_3 = new javax.swing.JLabel();
        pozitieP2_4 = new javax.swing.JLabel();
        pozitieP2_5 = new javax.swing.JLabel();
        pozitieP2_6 = new javax.swing.JLabel();
        pozitieP2_7 = new javax.swing.JLabel();
        pozitieP2_8 = new javax.swing.JLabel();
        pozitieP2_9 = new javax.swing.JLabel();
        pozitieP2_10 = new javax.swing.JLabel();
        pozitieP2_11 = new javax.swing.JLabel();
        pozitieP2_12 = new javax.swing.JLabel();
        pozitieP2_13 = new javax.swing.JLabel();
        pozitieP2_14 = new javax.swing.JLabel();
        pozitieP2_15 = new javax.swing.JLabel();
        pozitieP2_16 = new javax.swing.JLabel();
        pozitieP2_17 = new javax.swing.JLabel();
        pozitieP2_18 = new javax.swing.JLabel();
        pozitieP2_19 = new javax.swing.JLabel();
        pozitieP2_20 = new javax.swing.JLabel();
        pozitieP2_21 = new javax.swing.JLabel();
        pozitieP2_22 = new javax.swing.JLabel();
        pozitieP2_23 = new javax.swing.JLabel();
        pozitieP2_24 = new javax.swing.JLabel();
        pozitieP2_25 = new javax.swing.JLabel();
        pozitieP2_26 = new javax.swing.JLabel();
        pozitieP2_27 = new javax.swing.JLabel();
        pozitieP2_28 = new javax.swing.JLabel();
        pozitieP2_29 = new javax.swing.JLabel();
        pozitieP2_30 = new javax.swing.JLabel();
        pozitieP2_31 = new javax.swing.JLabel();
        pozitieP2_32 = new javax.swing.JLabel();
        pozitieP2_33 = new javax.swing.JLabel();
        pozitieP2_34 = new javax.swing.JLabel();
        pozitieP2_35 = new javax.swing.JLabel();
        pozitieP2_36 = new javax.swing.JLabel();
        pozitieP2_37 = new javax.swing.JLabel();
        pozitieP2_38 = new javax.swing.JLabel();
        pozitieP2_39 = new javax.swing.JLabel();
        pozitieP2_Inchisoare = new javax.swing.JLabel();
        labelTaxa1 = new javax.swing.JLabel();
        labelTaxa2 = new javax.swing.JLabel();
        labelElectric = new javax.swing.JLabel();
        labelApa = new javax.swing.JLabel();
        panelChest = new javax.swing.JPanel();
        panelChance = new javax.swing.JPanel();
        background = new javax.swing.JLabel();
        butonZaruri = new javax.swing.JButton();
        labelZar = new javax.swing.JLabel();
        labelBuget = new javax.swing.JLabel();
        labelBugetPlayer2 = new javax.swing.JLabel();
        labelR = new javax.swing.JLabel();
        labelRand = new javax.swing.JLabel();
        bIncheieTura = new javax.swing.JButton();
        labelZar1 = new javax.swing.JLabel();
        labelZar2 = new javax.swing.JLabel();
        labelBP1 = new javax.swing.JLabel();
        labelBP2 = new javax.swing.JLabel();
        panelAfisare = new javax.swing.JPanel();
        bCumpara = new javax.swing.JButton();
        panelBackground = new javax.swing.JPanel();
        panelProprietati = new javax.swing.JPanel();
        b27 = new javax.swing.JButton();
        b12 = new javax.swing.JButton();
        b15 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b35 = new javax.swing.JButton();
        b25 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b16 = new javax.swing.JButton();
        b18 = new javax.swing.JButton();
        b19 = new javax.swing.JButton();
        b11 = new javax.swing.JButton();
        b13 = new javax.swing.JButton();
        b14 = new javax.swing.JButton();
        b26 = new javax.swing.JButton();
        b28 = new javax.swing.JButton();
        b29 = new javax.swing.JButton();
        b31 = new javax.swing.JButton();
        b32 = new javax.swing.JButton();
        b34 = new javax.swing.JButton();
        b21 = new javax.swing.JButton();
        b22 = new javax.swing.JButton();
        b24 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b39 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        b37 = new javax.swing.JButton();
        panelProprietati1 = new javax.swing.JPanel();
        b27_2 = new javax.swing.JButton();
        b12_2 = new javax.swing.JButton();
        b15_2 = new javax.swing.JButton();
        b5_2 = new javax.swing.JButton();
        b35_2 = new javax.swing.JButton();
        b25_2 = new javax.swing.JButton();
        b6_2 = new javax.swing.JButton();
        b8_2 = new javax.swing.JButton();
        b9_2 = new javax.swing.JButton();
        b16_2 = new javax.swing.JButton();
        b18_2 = new javax.swing.JButton();
        b19_2 = new javax.swing.JButton();
        b11_2 = new javax.swing.JButton();
        b13_2 = new javax.swing.JButton();
        b14_2 = new javax.swing.JButton();
        b26_2 = new javax.swing.JButton();
        b28_2 = new javax.swing.JButton();
        b29_2 = new javax.swing.JButton();
        b31_2 = new javax.swing.JButton();
        b32_2 = new javax.swing.JButton();
        b34_2 = new javax.swing.JButton();
        b21_2 = new javax.swing.JButton();
        b22_2 = new javax.swing.JButton();
        b24_2 = new javax.swing.JButton();
        b3_2 = new javax.swing.JButton();
        b1_2 = new javax.swing.JButton();
        b37_2 = new javax.swing.JButton();
        b39_2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bCumparaMagazin = new javax.swing.JButton();
        bCumparaSupermarket = new javax.swing.JButton();
        labelNuAiBani = new javax.swing.JLabel();
        butonTrade = new javax.swing.JButton();
        bEndGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelStart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bStart.setText("Start!");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });
        panelStart.add(bStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 610, 220, 102));

        labelWinner.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        labelWinner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWinner.setText("Dumitrescu Tudor Andrei");
        panelStart.add(labelWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1368, 78));

        bInfo.setText("Info");
        bInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInfoActionPerformed(evt);
            }
        });
        panelStart.add(bInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 550, 220, 50));
        panelStart.add(labelBackgroundStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 5, 1380, 750));

        getContentPane().add(panelStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, -1));

        poz0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardgame/Zaruri/pion.png"))); // NOI18N
        getContentPane().add(poz0, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 650, 30, 50));
        getContentPane().add(poz1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 680, 30, 50));
        getContentPane().add(poz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 680, 30, 50));
        getContentPane().add(poz3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 680, 30, 50));
        getContentPane().add(poz4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 680, 30, 50));
        getContentPane().add(poz5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 630, 30, 50));
        getContentPane().add(poz6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 690, 30, 50));
        getContentPane().add(poz7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 620, 30, 50));
        getContentPane().add(poz8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 690, 30, 50));
        getContentPane().add(poz9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 690, 30, 50));
        getContentPane().add(poz10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 30, 50));
        getContentPane().add(poz11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 30, 50));
        getContentPane().add(poz12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 30, 50));
        getContentPane().add(poz13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 30, 50));
        getContentPane().add(poz14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 30, 50));
        getContentPane().add(poz15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 30, 50));
        getContentPane().add(poz16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 30, 50));
        getContentPane().add(poz17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 30, 50));
        getContentPane().add(poz18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 30, 50));
        getContentPane().add(poz19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 30, 50));
        getContentPane().add(poz20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 50));
        getContentPane().add(poz21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 30, 50));
        getContentPane().add(poz22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 30, 50));
        getContentPane().add(poz23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 30, 50));
        getContentPane().add(poz24, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 30, 50));
        getContentPane().add(poz25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 30, 50));
        getContentPane().add(poz26, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 40, 50));
        getContentPane().add(poz27, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 30, 50));
        getContentPane().add(poz28, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 30, 50));
        getContentPane().add(poz29, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 30, 50));
        getContentPane().add(poz30, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 30, 50));
        getContentPane().add(poz31, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 30, 50));
        getContentPane().add(poz32, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 30, 50));
        getContentPane().add(poz33, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 30, 50));
        getContentPane().add(poz34, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 30, 50));
        getContentPane().add(poz35, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 30, 50));
        getContentPane().add(poz36, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 30, 50));
        getContentPane().add(poz37, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 30, 50));
        getContentPane().add(poz38, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, 30, 50));
        getContentPane().add(poz39, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, 30, 50));
        getContentPane().add(pozInchisoare, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 30, 50));

        pozitieP2_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardgame/Zaruri/PionNegru.png"))); // NOI18N
        getContentPane().add(pozitieP2_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 680, 40, 50));
        getContentPane().add(pozitieP2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 690, 40, 50));
        getContentPane().add(pozitieP2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 690, 40, 50));
        getContentPane().add(pozitieP2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 690, 40, 50));
        getContentPane().add(pozitieP2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 690, 40, 50));
        getContentPane().add(pozitieP2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 690, 40, 50));
        getContentPane().add(pozitieP2_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 690, 40, 50));
        getContentPane().add(pozitieP2_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 40, 50));
        getContentPane().add(pozitieP2_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 690, 40, 50));
        getContentPane().add(pozitieP2_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 690, 40, 50));
        getContentPane().add(pozitieP2_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 690, 40, 50));
        getContentPane().add(pozitieP2_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 40, 50));
        getContentPane().add(pozitieP2_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 40, 50));
        getContentPane().add(pozitieP2_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 40, 50));
        getContentPane().add(pozitieP2_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 40, 50));
        getContentPane().add(pozitieP2_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 40, 50));
        getContentPane().add(pozitieP2_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 40, 50));
        getContentPane().add(pozitieP2_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 40, 50));
        getContentPane().add(pozitieP2_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 40, 50));
        getContentPane().add(pozitieP2_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 40, 50));
        getContentPane().add(pozitieP2_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 40, 50));
        getContentPane().add(pozitieP2_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 40, 50));
        getContentPane().add(pozitieP2_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 40, 50));
        getContentPane().add(pozitieP2_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 40, 50));
        getContentPane().add(pozitieP2_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 40, 50));
        getContentPane().add(pozitieP2_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 40, 50));
        getContentPane().add(pozitieP2_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 40, 50));
        getContentPane().add(pozitieP2_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 40, 50));
        getContentPane().add(pozitieP2_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 40, 50));
        getContentPane().add(pozitieP2_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 40, 50));
        getContentPane().add(pozitieP2_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 40, 50));
        getContentPane().add(pozitieP2_31, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 40, 50));
        getContentPane().add(pozitieP2_32, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 40, 50));
        getContentPane().add(pozitieP2_33, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 40, 50));
        getContentPane().add(pozitieP2_34, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, 40, 50));
        getContentPane().add(pozitieP2_35, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 40, 50));
        getContentPane().add(pozitieP2_36, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 40, 50));
        getContentPane().add(pozitieP2_37, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, 40, 50));
        getContentPane().add(pozitieP2_38, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 530, 40, 50));
        getContentPane().add(pozitieP2_39, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, 40, 50));
        getContentPane().add(pozitieP2_Inchisoare, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 40, 50));

        labelTaxa1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelTaxa1.setForeground(new java.awt.Color(0, 0, 0));
        labelTaxa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelTaxa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 590, 210, 20));

        labelTaxa2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelTaxa2.setForeground(new java.awt.Color(0, 0, 0));
        labelTaxa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelTaxa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, 170, 30));

        labelElectric.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(labelElectric, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, 20, 30));

        labelApa.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(labelApa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 20, 30));
        getContentPane().add(panelChest, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 320, 360));
        getContentPane().add(panelChance, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 300, 370));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardgame/Zaruri/map.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        butonZaruri.setText("Da cu zarurile");
        butonZaruri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonZaruriActionPerformed(evt);
            }
        });
        getContentPane().add(butonZaruri, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, -1, -1));

        labelZar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(labelZar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, 100, 30));

        labelBuget.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelBuget.setText("2500");
        getContentPane().add(labelBuget, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 680, -1, -1));

        labelBugetPlayer2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelBugetPlayer2.setText("2500");
        getContentPane().add(labelBugetPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 710, -1, -1));

        labelR.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelR.setText("Rand:");
        getContentPane().add(labelR, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        labelRand.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelRand.setText("Player 1");
        getContentPane().add(labelRand, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, -1, -1));

        bIncheieTura.setText("Incheie Tura");
        bIncheieTura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIncheieTuraActionPerformed(evt);
            }
        });
        getContentPane().add(bIncheieTura, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 650, -1, -1));
        getContentPane().add(labelZar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 70, 70));
        getContentPane().add(labelZar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 100, 70, 70));

        labelBP1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelBP1.setText("Buget Player1:");
        getContentPane().add(labelBP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 680, -1, -1));

        labelBP2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelBP2.setText("Buget Player2:");
        getContentPane().add(labelBP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 710, -1, 20));

        panelAfisare.setBackground(new java.awt.Color(255, 255, 255));
        panelAfisare.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(panelAfisare, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, 340, 400));

        bCumpara.setText("Cumpara");
        bCumpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCumparaActionPerformed(evt);
            }
        });
        getContentPane().add(bCumpara, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 610, -1, -1));
        getContentPane().add(panelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 360, 600));

        panelProprietati.setBackground(new java.awt.Color(255, 204, 255));
        panelProprietati.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b27.setBackground(new java.awt.Color(102, 102, 102));
        b27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b27ActionPerformed(evt);
            }
        });
        panelProprietati.add(b27, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 49, 31, 20));

        b12.setBackground(new java.awt.Color(102, 102, 102));
        b12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b12ActionPerformed(evt);
            }
        });
        panelProprietati.add(b12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 49, 31, 20));

        b15.setBackground(new java.awt.Color(0, 0, 0));
        b15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b15ActionPerformed(evt);
            }
        });
        panelProprietati.add(b15, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 74, 31, 20));

        b5.setBackground(new java.awt.Color(0, 0, 0));
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });
        panelProprietati.add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 74, 31, 20));

        b35.setBackground(new java.awt.Color(0, 0, 0));
        b35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b35ActionPerformed(evt);
            }
        });
        panelProprietati.add(b35, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 74, 31, 20));

        b25.setBackground(new java.awt.Color(0, 0, 0));
        b25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b25ActionPerformed(evt);
            }
        });
        panelProprietati.add(b25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 74, 31, 20));

        b6.setBackground(new java.awt.Color(102, 204, 255));
        b6.setForeground(new java.awt.Color(255, 255, 255));
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });
        panelProprietati.add(b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 99, 40, 20));

        b8.setBackground(new java.awt.Color(102, 204, 255));
        b8.setForeground(new java.awt.Color(255, 255, 255));
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });
        panelProprietati.add(b8, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 99, 40, 20));

        b9.setBackground(new java.awt.Color(102, 204, 255));
        b9.setForeground(new java.awt.Color(255, 255, 255));
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });
        panelProprietati.add(b9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 99, 40, 20));

        b16.setBackground(new java.awt.Color(255, 51, 0));
        b16.setForeground(new java.awt.Color(255, 255, 255));
        b16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b16ActionPerformed(evt);
            }
        });
        panelProprietati.add(b16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 124, 40, 20));

        b18.setBackground(new java.awt.Color(255, 51, 0));
        b18.setForeground(new java.awt.Color(255, 255, 255));
        b18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b18ActionPerformed(evt);
            }
        });
        panelProprietati.add(b18, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 124, 40, 20));

        b19.setBackground(new java.awt.Color(255, 51, 0));
        b19.setForeground(new java.awt.Color(255, 255, 255));
        b19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b19ActionPerformed(evt);
            }
        });
        panelProprietati.add(b19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 124, 40, 20));

        b11.setBackground(new java.awt.Color(204, 0, 204));
        b11.setForeground(new java.awt.Color(255, 255, 255));
        b11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b11ActionPerformed(evt);
            }
        });
        panelProprietati.add(b11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 149, 40, 20));

        b13.setBackground(new java.awt.Color(204, 0, 204));
        b13.setForeground(new java.awt.Color(255, 255, 255));
        b13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b13ActionPerformed(evt);
            }
        });
        panelProprietati.add(b13, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 149, 40, 20));

        b14.setBackground(new java.awt.Color(204, 0, 204));
        b14.setForeground(new java.awt.Color(255, 255, 255));
        b14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b14ActionPerformed(evt);
            }
        });
        panelProprietati.add(b14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 149, 40, 20));

        b26.setBackground(new java.awt.Color(255, 255, 51));
        b26.setForeground(new java.awt.Color(255, 255, 255));
        b26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b26ActionPerformed(evt);
            }
        });
        panelProprietati.add(b26, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 199, 40, 20));

        b28.setBackground(new java.awt.Color(255, 255, 51));
        b28.setForeground(new java.awt.Color(255, 255, 255));
        b28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b28ActionPerformed(evt);
            }
        });
        panelProprietati.add(b28, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 199, 40, 20));

        b29.setBackground(new java.awt.Color(255, 255, 51));
        b29.setForeground(new java.awt.Color(255, 255, 255));
        b29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b29ActionPerformed(evt);
            }
        });
        panelProprietati.add(b29, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 199, 40, 20));

        b31.setBackground(new java.awt.Color(0, 153, 51));
        b31.setForeground(new java.awt.Color(255, 255, 255));
        b31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b31ActionPerformed(evt);
            }
        });
        panelProprietati.add(b31, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 224, 40, 20));

        b32.setBackground(new java.awt.Color(0, 153, 51));
        b32.setForeground(new java.awt.Color(255, 255, 255));
        b32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b32ActionPerformed(evt);
            }
        });
        panelProprietati.add(b32, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 224, 40, 20));

        b34.setBackground(new java.awt.Color(0, 153, 51));
        b34.setForeground(new java.awt.Color(255, 255, 255));
        b34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b34ActionPerformed(evt);
            }
        });
        panelProprietati.add(b34, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 224, 40, 20));

        b21.setBackground(new java.awt.Color(255, 0, 0));
        b21.setForeground(new java.awt.Color(255, 255, 255));
        b21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b21ActionPerformed(evt);
            }
        });
        panelProprietati.add(b21, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 174, 40, 20));

        b22.setBackground(new java.awt.Color(255, 0, 0));
        b22.setForeground(new java.awt.Color(255, 255, 255));
        b22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b22ActionPerformed(evt);
            }
        });
        panelProprietati.add(b22, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 174, 40, 20));

        b24.setBackground(new java.awt.Color(255, 0, 0));
        b24.setForeground(new java.awt.Color(255, 255, 255));
        b24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b24ActionPerformed(evt);
            }
        });
        panelProprietati.add(b24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 174, 40, 20));

        b3.setBackground(new java.awt.Color(51, 0, 0));
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        panelProprietati.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 249, 40, 20));

        b1.setBackground(new java.awt.Color(51, 0, 0));
        b1.setForeground(new java.awt.Color(255, 255, 255));
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        panelProprietati.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 249, 40, 20));

        b39.setBackground(new java.awt.Color(0, 102, 204));
        b39.setForeground(new java.awt.Color(255, 255, 255));
        b39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b39ActionPerformed(evt);
            }
        });
        panelProprietati.add(b39, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 274, 40, 20));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Proprietati Player 1");
        panelProprietati.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 18, -1, -1));

        b37.setBackground(new java.awt.Color(0, 102, 204));
        b37.setForeground(new java.awt.Color(255, 255, 255));
        b37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b37ActionPerformed(evt);
            }
        });
        panelProprietati.add(b37, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 274, 40, 20));

        getContentPane().add(panelProprietati, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 50, 200, 310));

        panelProprietati1.setBackground(new java.awt.Color(255, 204, 255));
        panelProprietati1.setForeground(new java.awt.Color(102, 102, 102));
        panelProprietati1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b27_2.setBackground(new java.awt.Color(102, 102, 102));
        b27_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b27_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b27_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 49, 31, 20));

        b12_2.setBackground(new java.awt.Color(102, 102, 102));
        b12_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b12_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 49, 31, 20));

        b15_2.setBackground(new java.awt.Color(0, 0, 0));
        b15_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b15_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b15_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 74, 31, 20));

        b5_2.setBackground(new java.awt.Color(0, 0, 0));
        b5_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 74, 31, 20));

        b35_2.setBackground(new java.awt.Color(0, 0, 0));
        b35_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b35_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b35_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 74, 31, 20));

        b25_2.setBackground(new java.awt.Color(0, 0, 0));
        b25_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b25_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b25_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 74, 31, 20));

        b6_2.setBackground(new java.awt.Color(102, 204, 255));
        b6_2.setForeground(new java.awt.Color(255, 255, 255));
        b6_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 99, 40, 20));

        b8_2.setBackground(new java.awt.Color(102, 204, 255));
        b8_2.setForeground(new java.awt.Color(255, 255, 255));
        b8_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 99, 40, 20));

        b9_2.setBackground(new java.awt.Color(102, 204, 255));
        b9_2.setForeground(new java.awt.Color(255, 255, 255));
        b9_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 99, 40, 20));

        b16_2.setBackground(new java.awt.Color(255, 51, 0));
        b16_2.setForeground(new java.awt.Color(255, 255, 255));
        b16_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b16_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b16_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 124, 40, 20));

        b18_2.setBackground(new java.awt.Color(255, 51, 0));
        b18_2.setForeground(new java.awt.Color(255, 255, 255));
        b18_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b18_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b18_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 124, 40, 20));

        b19_2.setBackground(new java.awt.Color(255, 51, 0));
        b19_2.setForeground(new java.awt.Color(255, 255, 255));
        b19_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b19_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b19_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 124, 40, 20));

        b11_2.setBackground(new java.awt.Color(204, 0, 204));
        b11_2.setForeground(new java.awt.Color(255, 255, 255));
        b11_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b11_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b11_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 149, 40, 20));

        b13_2.setBackground(new java.awt.Color(204, 0, 204));
        b13_2.setForeground(new java.awt.Color(255, 255, 255));
        b13_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b13_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b13_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 149, 40, 20));

        b14_2.setBackground(new java.awt.Color(204, 0, 204));
        b14_2.setForeground(new java.awt.Color(255, 255, 255));
        b14_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b14_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b14_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 149, 40, 20));

        b26_2.setBackground(new java.awt.Color(255, 255, 51));
        b26_2.setForeground(new java.awt.Color(255, 255, 255));
        b26_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b26_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b26_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 199, 40, 20));

        b28_2.setBackground(new java.awt.Color(255, 255, 51));
        b28_2.setForeground(new java.awt.Color(255, 255, 255));
        b28_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b28_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b28_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 199, 40, 20));

        b29_2.setBackground(new java.awt.Color(255, 255, 51));
        b29_2.setForeground(new java.awt.Color(255, 255, 255));
        b29_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b29_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b29_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 199, 40, 20));

        b31_2.setBackground(new java.awt.Color(0, 153, 51));
        b31_2.setForeground(new java.awt.Color(255, 255, 255));
        b31_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b31_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b31_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 224, 40, 20));

        b32_2.setBackground(new java.awt.Color(0, 153, 51));
        b32_2.setForeground(new java.awt.Color(255, 255, 255));
        b32_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b32_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b32_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 224, 40, 20));

        b34_2.setBackground(new java.awt.Color(0, 153, 51));
        b34_2.setForeground(new java.awt.Color(255, 255, 255));
        b34_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b34_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b34_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 224, 40, 20));

        b21_2.setBackground(new java.awt.Color(255, 0, 0));
        b21_2.setForeground(new java.awt.Color(255, 255, 255));
        b21_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b21_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b21_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 174, 40, 20));

        b22_2.setBackground(new java.awt.Color(255, 0, 0));
        b22_2.setForeground(new java.awt.Color(255, 255, 255));
        b22_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b22_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b22_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 174, 40, 20));

        b24_2.setBackground(new java.awt.Color(255, 0, 0));
        b24_2.setForeground(new java.awt.Color(255, 255, 255));
        b24_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b24_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b24_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 174, 40, 20));

        b3_2.setBackground(new java.awt.Color(51, 0, 0));
        b3_2.setForeground(new java.awt.Color(255, 255, 255));
        b3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 249, 40, 20));

        b1_2.setBackground(new java.awt.Color(51, 0, 0));
        b1_2.setForeground(new java.awt.Color(255, 255, 255));
        b1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 249, 40, 20));

        b37_2.setBackground(new java.awt.Color(0, 102, 204));
        b37_2.setForeground(new java.awt.Color(255, 255, 255));
        b37_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b37_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b37_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 274, 40, 20));

        b39_2.setBackground(new java.awt.Color(0, 102, 204));
        b39_2.setForeground(new java.awt.Color(255, 255, 255));
        b39_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b39_2ActionPerformed(evt);
            }
        });
        panelProprietati1.add(b39_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 274, 40, 20));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Proprietati Player 2");
        panelProprietati1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 18, -1, -1));

        getContentPane().add(panelProprietati1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 400, 200, 310));

        bCumparaMagazin.setText("Buy Magazin");
        bCumparaMagazin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCumparaMagazinActionPerformed(evt);
            }
        });
        getContentPane().add(bCumparaMagazin, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, -1, -1));

        bCumparaSupermarket.setText("Cumpara Supermarket");
        bCumparaSupermarket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCumparaSupermarketActionPerformed(evt);
            }
        });
        getContentPane().add(bCumparaSupermarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 610, -1, -1));

        labelNuAiBani.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        getContentPane().add(labelNuAiBani, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 650, 190, 20));

        butonTrade.setText("Trade");
        butonTrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonTradeActionPerformed(evt);
            }
        });
        getContentPane().add(butonTrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 370, -1, -1));

        bEndGame.setText("End Game");
        bEndGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEndGameActionPerformed(evt);
            }
        });
        getContentPane().add(bEndGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Buton:Arunca cu zarurile
    private void butonZaruriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonZaruriActionPerformed
        bIncheieTura.setVisible(true);
        bCumpara.removeActionListener(actionListenerButon);
        panelChance.setVisible(false);
        panelChest.setVisible(false);
        bCumpara.setVisible(false);
        daCuZarul();
        pozitiePionPeMapa();
        pozitiePionPeMapaPlayer2();
        panelAfisare.removeAll();
        panelAfisare.revalidate();
        panelAfisare.repaint();

    }//GEN-LAST:event_butonZaruriActionPerformed

    //Buton:Incheierea turei
    private void bIncheieTuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIncheieTuraActionPerformed
        bCumpara.removeActionListener(actionListenerButon);
        bCumpara.setVisible(false);
        bCumparaMagazin.setVisible(false);
        bCumparaSupermarket.setVisible(false);
        panelChance.setVisible(false);
        panelChest.setVisible(false);
        butonZaruri.setVisible(true);
        panelChance.removeAll();
        panelChest.removeAll();
        panelAfisare.removeAll();
        labelZar1.setIcon(null);
        labelZar2.setIcon(null);
        labelZar.setText("");
        labelNuAiBani.setText("");
        labelTaxa1.setText("");
        labelTaxa2.setText("");
        panelAfisare.setBackground(Color.white);
        if (turn % 2 != 0 && player2.asteptarePlayer <= 0) {
            labelRand.setText("Player 2");

        } else if (turn % 2 == 0 && player1.asteptarePlayer <= 0) {
            labelRand.setText("Player 1");
        }

        panelAfisare.revalidate();
        panelAfisare.repaint();
    }//GEN-LAST:event_bIncheieTuraActionPerformed

    //Metoda:ascunderea butoanelor proprietatilor fiecarui player
    public void ascundeToateButoaneleProprietatilor() {
        b5.setVisible(false);
        b15.setVisible(false);
        b25.setVisible(false);
        b35.setVisible(false);
        b12.setVisible(false);
        b27.setVisible(false);
        b5_2.setVisible(false);
        b15_2.setVisible(false);
        b25_2.setVisible(false);
        b35_2.setVisible(false);
        b12_2.setVisible(false);
        b27_2.setVisible(false);

        b1.setVisible(false);
        b3.setVisible(false);
        b6.setVisible(false);
        b8.setVisible(false);
        b9.setVisible(false);
        b11.setVisible(false);
        b13.setVisible(false);
        b14.setVisible(false);
        b16.setVisible(false);
        b18.setVisible(false);
        b19.setVisible(false);
        b21.setVisible(false);
        b22.setVisible(false);
        b24.setVisible(false);
        b26.setVisible(false);
        b28.setVisible(false);
        b29.setVisible(false);
        b31.setVisible(false);
        b32.setVisible(false);
        b34.setVisible(false);
        b37.setVisible(false);
        b39.setVisible(false);
        b1_2.setVisible(false);
        b3_2.setVisible(false);
        b6_2.setVisible(false);
        b8_2.setVisible(false);
        b9_2.setVisible(false);
        b11_2.setVisible(false);
        b13_2.setVisible(false);
        b14_2.setVisible(false);
        b16_2.setVisible(false);
        b18_2.setVisible(false);
        b19_2.setVisible(false);
        b21_2.setVisible(false);
        b22_2.setVisible(false);
        b24_2.setVisible(false);
        b26_2.setVisible(false);
        b28_2.setVisible(false);
        b29_2.setVisible(false);
        b31_2.setVisible(false);
        b32_2.setVisible(false);
        b34_2.setVisible(false);
        b37_2.setVisible(false);
        b39_2.setVisible(false);
    }

    //Metode pentru adaugarea domeniilor in pannelul de afisare:
    public void adaugaFabricaInPanel(Fabrica f) {
        panelAfisare.removeAll();
        panelAfisare.add(f);
        panelAfisare.revalidate();
        panelAfisare.repaint();
    }
    public void adaugaMetrouInPanel(Train t) {
        panelAfisare.removeAll();
        panelAfisare.add(t);
        panelAfisare.revalidate();
        panelAfisare.repaint();
    }
    public void adaugaProprietateInPanel(Proprietate p) {
        panelAfisare.removeAll();
        panelAfisare.add(p);
        panelAfisare.revalidate();
        panelAfisare.repaint();
    }
    
    //Metode pentru afisarea domeniilor detinute de cei doi jucatori la apasarea butonului
    private void b12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b12ActionPerformed
        adaugaFabricaInPanel(fabricaElectrica);
    }//GEN-LAST:event_b12ActionPerformed
    private void b12_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b12_2ActionPerformed
        adaugaFabricaInPanel(fabricaElectrica);
    }//GEN-LAST:event_b12_2ActionPerformed
    private void b27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b27ActionPerformed
        adaugaFabricaInPanel(fabricaApa);
    }//GEN-LAST:event_b27ActionPerformed
    private void b27_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b27_2ActionPerformed
        adaugaFabricaInPanel(fabricaApa);
    }//GEN-LAST:event_b27_2ActionPerformed
    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        adaugaMetrouInPanel(metrou1);
    }//GEN-LAST:event_b5ActionPerformed
    private void b5_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5_2ActionPerformed
        adaugaMetrouInPanel(metrou1);
    }//GEN-LAST:event_b5_2ActionPerformed
    private void b15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b15ActionPerformed
        adaugaMetrouInPanel(metrou2);
    }//GEN-LAST:event_b15ActionPerformed
    private void b15_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b15_2ActionPerformed
        adaugaMetrouInPanel(metrou2);
    }//GEN-LAST:event_b15_2ActionPerformed
    private void b25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b25ActionPerformed
        adaugaMetrouInPanel(metrou3);
    }//GEN-LAST:event_b25ActionPerformed
    private void b35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b35ActionPerformed
        adaugaMetrouInPanel(metrou4);
    }//GEN-LAST:event_b35ActionPerformed
    private void b25_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b25_2ActionPerformed
        adaugaMetrouInPanel(metrou3);
    }//GEN-LAST:event_b25_2ActionPerformed
    private void b35_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b35_2ActionPerformed
        adaugaMetrouInPanel(metrou4);
    }//GEN-LAST:event_b35_2ActionPerformed
    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        adaugaProprietateInPanel(Rahova);
    }//GEN-LAST:event_b1ActionPerformed
    private void bCumparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCumparaActionPerformed
    }//GEN-LAST:event_bCumparaActionPerformed
    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        adaugaProprietateInPanel(Ferentari);
    }//GEN-LAST:event_b3ActionPerformed
    private void b1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1_2ActionPerformed
        adaugaProprietateInPanel(Rahova);
    }//GEN-LAST:event_b1_2ActionPerformed
    private void b3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3_2ActionPerformed
        adaugaProprietateInPanel(Ferentari);
    }//GEN-LAST:event_b3_2ActionPerformed
    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        adaugaProprietateInPanel(Titan);
    }//GEN-LAST:event_b6ActionPerformed
    private void b6_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6_2ActionPerformed
        adaugaProprietateInPanel(Titan);
    }//GEN-LAST:event_b6_2ActionPerformed
    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        adaugaProprietateInPanel(Vitan);
    }//GEN-LAST:event_b8ActionPerformed
    private void b8_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8_2ActionPerformed
        adaugaProprietateInPanel(Vitan);
    }//GEN-LAST:event_b8_2ActionPerformed
    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        adaugaProprietateInPanel(StefanCelMare);
    }//GEN-LAST:event_b9ActionPerformed
    private void b9_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9_2ActionPerformed
        adaugaProprietateInPanel(StefanCelMare);
    }//GEN-LAST:event_b9_2ActionPerformed
    private void b11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b11ActionPerformed
        adaugaProprietateInPanel(Izvor);
    }//GEN-LAST:event_b11ActionPerformed
    private void b11_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b11_2ActionPerformed
        adaugaProprietateInPanel(Izvor);
    }//GEN-LAST:event_b11_2ActionPerformed
    private void b13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b13ActionPerformed
        adaugaProprietateInPanel(MegaMall);
    }//GEN-LAST:event_b13ActionPerformed
    private void b13_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b13_2ActionPerformed
        adaugaProprietateInPanel(MegaMall);
    }//GEN-LAST:event_b13_2ActionPerformed
    private void b14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b14ActionPerformed
        adaugaProprietateInPanel(LibertyCenter);
    }//GEN-LAST:event_b14ActionPerformed
    private void b14_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b14_2ActionPerformed
        adaugaProprietateInPanel(LibertyCenter);
    }//GEN-LAST:event_b14_2ActionPerformed
    private void b16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b16ActionPerformed
        adaugaProprietateInPanel(Militari);
    }//GEN-LAST:event_b16ActionPerformed
    private void b16_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b16_2ActionPerformed
        adaugaProprietateInPanel(Militari);
    }//GEN-LAST:event_b16_2ActionPerformed
    private void b18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b18ActionPerformed
        adaugaProprietateInPanel(DrumuTaberei);
    }//GEN-LAST:event_b18ActionPerformed
    private void b18_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b18_2ActionPerformed
        adaugaProprietateInPanel(DrumuTaberei);
    }//GEN-LAST:event_b18_2ActionPerformed
    private void b19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b19ActionPerformed
        adaugaProprietateInPanel(TreispeSeptembrie);
    }//GEN-LAST:event_b19ActionPerformed
    private void b19_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b19_2ActionPerformed
        adaugaProprietateInPanel(TreispeSeptembrie);
    }//GEN-LAST:event_b19_2ActionPerformed
    private void b21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b21ActionPerformed
        adaugaProprietateInPanel(Cotroceni);
    }//GEN-LAST:event_b21ActionPerformed
    private void b21_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b21_2ActionPerformed
        adaugaProprietateInPanel(Cotroceni);
    }//GEN-LAST:event_b21_2ActionPerformed
    private void b22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b22ActionPerformed
        adaugaProprietateInPanel(OraselulCopiilor);
    }//GEN-LAST:event_b22ActionPerformed
    private void b22_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b22_2ActionPerformed
        adaugaProprietateInPanel(OraselulCopiilor);
    }//GEN-LAST:event_b22_2ActionPerformed
    private void b24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b24ActionPerformed
        adaugaProprietateInPanel(Cismigiu);
    }//GEN-LAST:event_b24ActionPerformed
    private void b24_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b24_2ActionPerformed
        adaugaProprietateInPanel(Cismigiu);
    }//GEN-LAST:event_b24_2ActionPerformed
    private void b26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b26ActionPerformed
        adaugaProprietateInPanel(PiataUnirii);
    }//GEN-LAST:event_b26ActionPerformed
    private void b28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b28ActionPerformed
        adaugaProprietateInPanel(Berceni);
    }//GEN-LAST:event_b28ActionPerformed
    private void b29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b29ActionPerformed
        adaugaProprietateInPanel(Baneasa);
    }//GEN-LAST:event_b29ActionPerformed
    private void b26_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b26_2ActionPerformed
        adaugaProprietateInPanel(PiataUnirii);
    }//GEN-LAST:event_b26_2ActionPerformed
    private void b28_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b28_2ActionPerformed
        adaugaProprietateInPanel(Berceni);
    }//GEN-LAST:event_b28_2ActionPerformed
    private void b29_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b29_2ActionPerformed
        adaugaProprietateInPanel(Baneasa);
    }//GEN-LAST:event_b29_2ActionPerformed
    private void b31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b31ActionPerformed
        adaugaProprietateInPanel(ParkLake);
    }//GEN-LAST:event_b31ActionPerformed
    private void b31_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b31_2ActionPerformed
        adaugaProprietateInPanel(ParkLake);
    }//GEN-LAST:event_b31_2ActionPerformed
    private void b32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b32ActionPerformed
        adaugaProprietateInPanel(AfiPalace);
    }//GEN-LAST:event_b32ActionPerformed
    private void b32_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b32_2ActionPerformed
        adaugaProprietateInPanel(AfiPalace);
    }//GEN-LAST:event_b32_2ActionPerformed
    private void b34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b34ActionPerformed
        adaugaProprietateInPanel(Herastrau);
    }//GEN-LAST:event_b34ActionPerformed
    private void b34_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b34_2ActionPerformed
        adaugaProprietateInPanel(Herastrau);
    }//GEN-LAST:event_b34_2ActionPerformed
    private void b37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b37ActionPerformed
        adaugaProprietateInPanel(Dorobanti);
    }//GEN-LAST:event_b37ActionPerformed
    private void b39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b39ActionPerformed
        adaugaProprietateInPanel(CentruVechi);
    }//GEN-LAST:event_b39ActionPerformed
    private void b37_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b37_2ActionPerformed
        adaugaProprietateInPanel(Dorobanti);
    }//GEN-LAST:event_b37_2ActionPerformed
    private void b39_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b39_2ActionPerformed
        adaugaProprietateInPanel(CentruVechi);
    }//GEN-LAST:event_b39_2ActionPerformed
    private void bCumparaMagazinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCumparaMagazinActionPerformed
    }//GEN-LAST:event_bCumparaMagazinActionPerformed
    private void bCumparaSupermarketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCumparaSupermarketActionPerformed
    }//GEN-LAST:event_bCumparaSupermarketActionPerformed

    //Afisarea ferestrei de Trade
    private void butonTradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonTradeActionPerformed
        this.trade.setVisible(true);
        trade.actualizeazaModelele();
        trade.player1ReadyForTrade = false;
        trade.player2ReadyForTrade = false;
    }//GEN-LAST:event_butonTradeActionPerformed

    //Butonul de start game
    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        butonTrade.setVisible(true);
        butonZaruri.setVisible(true);
        bEndGame.setVisible(true);
        panelStart.setVisible(false);


    }//GEN-LAST:event_bStartActionPerformed

    //Butonul de end game
    private void bEndGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEndGameActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to end?", "Are you sure?", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            panelStart.setVisible(true);
            bStart.setText("Replay");
            if (player1.bugetPlayer > player2.bugetPlayer) {
                labelWinner.setText("Winner : Player 1");
            } else if (player2.bugetPlayer > player1.bugetPlayer) {
                labelWinner.setText("Winner : Player 2");
            } else if (player1.bugetPlayer == player2.bugetPlayer) {
                labelWinner.setText("Remiza");
            }
            resetGame();
            bEndGame.setVisible(false);
            butonZaruri.setVisible(false);
            bIncheieTura.setVisible(false);
            bEndGame.setVisible(false);
            bCumpara.setVisible(false);
            bCumparaMagazin.setVisible(false);
            bCumparaSupermarket.setVisible(false);
            labelZar.setText("");
            labelZar1.setIcon(null);
            labelZar2.setIcon(null);
            panelAfisare.removeAll();
            panelAfisare.revalidate();
            panelAfisare.repaint();
        }
    }//GEN-LAST:event_bEndGameActionPerformed

    //Butonul info
    private void bInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInfoActionPerformed
        Info info = new Info();
        info.setVisible(true);
        info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_bInfoActionPerformed

    //Metode folosite in trade pentru trecerea butoanelor domeniilor de la un player la celalalt
    //Pentru proprietati
    public void schimbaB1(int i) {
        if (i == 1) {
            System.out.println("Aici ar trbeui sa se schimbe imaginile 1");
            b1.setVisible(false);
            b1_2.setVisible(true);
        } else if (i == 2) {
            b1_2.setVisible(false);
            b1.setVisible(true);
        }
    }

    public void schimbaB3(int i) {
        if (i == 1) {
            System.out.println("Aici ar trbeui sa se schimbe imaginile 3");
            b3.setVisible(false);
            b3_2.setVisible(true);
        } else if (i == 2) {
            b3_2.setVisible(false);
            b3.setVisible(true);
        }
    }

    public void schimbaB6(int i) {
        if (i == 1) {
            System.out.println("Aici ar trbeui sa se schimbe imaginile 6");
            b6.setVisible(false);
            b6_2.setVisible(true);
        } else if (i == 2) {
            b6_2.setVisible(false);
            b6.setVisible(true);
        }
    }

    public void schimbaB8(int i) {
        if (i == 1) {
            System.out.println("Aici ar trbeui sa se schimbe imaginile 8");
            b8.setVisible(false);
            b8_2.setVisible(true);
        } else if (i == 2) {
            b8_2.setVisible(false);
            b8.setVisible(true);
        }
    }

    public void schimbaB9(int i) {
        if (i == 1) {
            System.out.println("Aici ar trbeui sa se schimbe imaginile 9");
            b9.setVisible(false);
            b9_2.setVisible(true);
        } else if (i == 2) {
            b9_2.setVisible(false);
            b9.setVisible(true);
        }
    }

    public void schimbaB11(int i) {
        if (i == 1) {
            System.out.println("Aici ar trbeui sa se schimbe imaginile 11");
            b11.setVisible(false);
            b11_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b11_2.setVisible(false);
            b11.setVisible(true);
        }
    }

    public void schimbaB13(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b13.setVisible(false);
            b13_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b13_2.setVisible(false);
            b13.setVisible(true);
        }
    }

    public void schimbaB14(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b14.setVisible(false);
            b14_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b14_2.setVisible(false);
            b14.setVisible(true);
        }
    }

    public void schimbaB16(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b16.setVisible(false);
            b16_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b16_2.setVisible(false);
            b16.setVisible(true);
        }
    }

    public void schimbaB18(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b18.setVisible(false);
            b18_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b18_2.setVisible(false);
            b18.setVisible(true);
        }
    }

    public void schimbaB19(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b19.setVisible(false);
            b19_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b19_2.setVisible(false);
            b19.setVisible(true);
        }
    }

    public void schimbaB21(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b21.setVisible(false);
            b21_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b21_2.setVisible(false);
            b21.setVisible(true);
        }
    }

    public void schimbaB22(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b22.setVisible(false);
            b22_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b22_2.setVisible(false);
            b22.setVisible(true);
        }
    }

    public void schimbaB24(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b24.setVisible(false);
            b24_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b24_2.setVisible(false);
            b24.setVisible(true);
        }
    }

    public void schimbaB26(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b26.setVisible(false);
            b26_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b26_2.setVisible(false);
            b26.setVisible(true);
        }
    }

    public void schimbaB28(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b28.setVisible(false);
            b28_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b28_2.setVisible(false);
            b28.setVisible(true);
        }
    }

    public void schimbaB29(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b29.setVisible(false);
            b29_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b29_2.setVisible(false);
            b29.setVisible(true);
        }
    }

    public void schimbaB31(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b31.setVisible(false);
            b31_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b31_2.setVisible(false);
            b31.setVisible(true);
        }
    }

    public void schimbaB32(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b32.setVisible(false);
            b32_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b32_2.setVisible(false);
            b32.setVisible(true);
        }
    }

    public void schimbaB34(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b34.setVisible(false);
            b34_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b34_2.setVisible(false);
            b34.setVisible(true);
        }
    }

    public void schimbaB37(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b37.setVisible(false);
            b37_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b37_2.setVisible(false);
            b37.setVisible(true);
        }
    }

    public void schimbaB39(int i) {
        if (i == 1) {
            System.out.println("aaaaa");
            b39.setVisible(false);
            b39_2.setVisible(true);
        } else if (i == 2) {
            System.out.println("aaaaa");
            b39_2.setVisible(false);
            b39.setVisible(true);
        }
    }

    //Pentru metrouri
    public void schimbaMetrou5(int i) {
        if (i == 1) {
            b5.setVisible(false);
            b5_2.setVisible(true);
        } else if (i == 2) {
            b5_2.setVisible(false);
            b5.setVisible(true);
        }
    }

    public void schimbaMetrou15(int i) {
        if (i == 1) {
            b15.setVisible(false);
            b15_2.setVisible(true);
        } else if (i == 2) {
            b15_2.setVisible(false);
            b15.setVisible(true);
        }
    }

    public void schimbaMetrou25(int i) {
        if (i == 1) {
            b25.setVisible(false);
            b25_2.setVisible(true);
        } else if (i == 2) {
            b25_2.setVisible(false);
            b25.setVisible(true);
        }
    }

    public void schimbaMetrou35(int i) {
        if (i == 1) {
            b35.setVisible(false);
            b35_2.setVisible(true);
        } else if (i == 2) {
            b35_2.setVisible(false);
            b35.setVisible(true);
        }
    }

    //Pentru fabrici
    public void schimbaFabricaElectrica(int i) {
        if (i == 1) {
            b12.setVisible(false);
            b12_2.setVisible(true);
        } else if (i == 2) {
            b12_2.setVisible(false);
            b12.setVisible(true);
        }
    }

    public void schimbaFabricaApa(int i) {
        if (i == 1) {
            b27.setVisible(false);
            b27_2.setVisible(true);
        } else if (i == 2) {
            b27_2.setVisible(false);
            b27.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b11;
    private javax.swing.JButton b11_2;
    private javax.swing.JButton b12;
    private javax.swing.JButton b12_2;
    private javax.swing.JButton b13;
    private javax.swing.JButton b13_2;
    private javax.swing.JButton b14;
    private javax.swing.JButton b14_2;
    private javax.swing.JButton b15;
    private javax.swing.JButton b15_2;
    private javax.swing.JButton b16;
    private javax.swing.JButton b16_2;
    private javax.swing.JButton b18;
    private javax.swing.JButton b18_2;
    private javax.swing.JButton b19;
    private javax.swing.JButton b19_2;
    private javax.swing.JButton b1_2;
    private javax.swing.JButton b21;
    private javax.swing.JButton b21_2;
    private javax.swing.JButton b22;
    private javax.swing.JButton b22_2;
    private javax.swing.JButton b24;
    private javax.swing.JButton b24_2;
    private javax.swing.JButton b25;
    private javax.swing.JButton b25_2;
    private javax.swing.JButton b26;
    private javax.swing.JButton b26_2;
    private javax.swing.JButton b27;
    private javax.swing.JButton b27_2;
    private javax.swing.JButton b28;
    private javax.swing.JButton b28_2;
    private javax.swing.JButton b29;
    private javax.swing.JButton b29_2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b31;
    private javax.swing.JButton b31_2;
    private javax.swing.JButton b32;
    private javax.swing.JButton b32_2;
    private javax.swing.JButton b34;
    private javax.swing.JButton b34_2;
    private javax.swing.JButton b35;
    private javax.swing.JButton b35_2;
    private javax.swing.JButton b37;
    private javax.swing.JButton b37_2;
    private javax.swing.JButton b39;
    private javax.swing.JButton b39_2;
    private javax.swing.JButton b3_2;
    private javax.swing.JButton b5;
    private javax.swing.JButton b5_2;
    private javax.swing.JButton b6;
    private javax.swing.JButton b6_2;
    private javax.swing.JButton b8;
    private javax.swing.JButton b8_2;
    private javax.swing.JButton b9;
    private javax.swing.JButton b9_2;
    private javax.swing.JButton bCumpara;
    private javax.swing.JButton bCumparaMagazin;
    private javax.swing.JButton bCumparaSupermarket;
    private javax.swing.JButton bEndGame;
    private javax.swing.JButton bIncheieTura;
    private javax.swing.JButton bInfo;
    private javax.swing.JButton bStart;
    private javax.swing.JLabel background;
    private javax.swing.JButton butonTrade;
    private javax.swing.JButton butonZaruri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelApa;
    private javax.swing.JLabel labelBP1;
    private javax.swing.JLabel labelBP2;
    private javax.swing.JLabel labelBackgroundStart;
    private javax.swing.JLabel labelBuget;
    private javax.swing.JLabel labelBugetPlayer2;
    private javax.swing.JLabel labelElectric;
    private javax.swing.JLabel labelNuAiBani;
    private javax.swing.JLabel labelR;
    private javax.swing.JLabel labelRand;
    private javax.swing.JLabel labelTaxa1;
    private javax.swing.JLabel labelTaxa2;
    private javax.swing.JLabel labelWinner;
    private javax.swing.JLabel labelZar;
    private javax.swing.JLabel labelZar1;
    private javax.swing.JLabel labelZar2;
    private javax.swing.JPanel panelAfisare;
    private javax.swing.JPanel panelBackground;
    private javax.swing.JPanel panelChance;
    private javax.swing.JPanel panelChest;
    private javax.swing.JPanel panelProprietati;
    private javax.swing.JPanel panelProprietati1;
    private javax.swing.JPanel panelStart;
    private javax.swing.JLabel poz0;
    private javax.swing.JLabel poz1;
    private javax.swing.JLabel poz10;
    private javax.swing.JLabel poz11;
    private javax.swing.JLabel poz12;
    private javax.swing.JLabel poz13;
    private javax.swing.JLabel poz14;
    private javax.swing.JLabel poz15;
    private javax.swing.JLabel poz16;
    private javax.swing.JLabel poz17;
    private javax.swing.JLabel poz18;
    private javax.swing.JLabel poz19;
    private javax.swing.JLabel poz2;
    private javax.swing.JLabel poz20;
    private javax.swing.JLabel poz21;
    private javax.swing.JLabel poz22;
    private javax.swing.JLabel poz23;
    private javax.swing.JLabel poz24;
    private javax.swing.JLabel poz25;
    private javax.swing.JLabel poz26;
    private javax.swing.JLabel poz27;
    private javax.swing.JLabel poz28;
    private javax.swing.JLabel poz29;
    private javax.swing.JLabel poz3;
    private javax.swing.JLabel poz30;
    private javax.swing.JLabel poz31;
    private javax.swing.JLabel poz32;
    private javax.swing.JLabel poz33;
    private javax.swing.JLabel poz34;
    private javax.swing.JLabel poz35;
    private javax.swing.JLabel poz36;
    private javax.swing.JLabel poz37;
    private javax.swing.JLabel poz38;
    private javax.swing.JLabel poz39;
    private javax.swing.JLabel poz4;
    private javax.swing.JLabel poz5;
    private javax.swing.JLabel poz6;
    private javax.swing.JLabel poz7;
    private javax.swing.JLabel poz8;
    private javax.swing.JLabel poz9;
    private javax.swing.JLabel pozInchisoare;
    private javax.swing.JLabel pozitieP2_0;
    private javax.swing.JLabel pozitieP2_1;
    private javax.swing.JLabel pozitieP2_10;
    private javax.swing.JLabel pozitieP2_11;
    private javax.swing.JLabel pozitieP2_12;
    private javax.swing.JLabel pozitieP2_13;
    private javax.swing.JLabel pozitieP2_14;
    private javax.swing.JLabel pozitieP2_15;
    private javax.swing.JLabel pozitieP2_16;
    private javax.swing.JLabel pozitieP2_17;
    private javax.swing.JLabel pozitieP2_18;
    private javax.swing.JLabel pozitieP2_19;
    private javax.swing.JLabel pozitieP2_2;
    private javax.swing.JLabel pozitieP2_20;
    private javax.swing.JLabel pozitieP2_21;
    private javax.swing.JLabel pozitieP2_22;
    private javax.swing.JLabel pozitieP2_23;
    private javax.swing.JLabel pozitieP2_24;
    private javax.swing.JLabel pozitieP2_25;
    private javax.swing.JLabel pozitieP2_26;
    private javax.swing.JLabel pozitieP2_27;
    private javax.swing.JLabel pozitieP2_28;
    private javax.swing.JLabel pozitieP2_29;
    private javax.swing.JLabel pozitieP2_3;
    private javax.swing.JLabel pozitieP2_30;
    private javax.swing.JLabel pozitieP2_31;
    private javax.swing.JLabel pozitieP2_32;
    private javax.swing.JLabel pozitieP2_33;
    private javax.swing.JLabel pozitieP2_34;
    private javax.swing.JLabel pozitieP2_35;
    private javax.swing.JLabel pozitieP2_36;
    private javax.swing.JLabel pozitieP2_37;
    private javax.swing.JLabel pozitieP2_38;
    private javax.swing.JLabel pozitieP2_39;
    private javax.swing.JLabel pozitieP2_4;
    private javax.swing.JLabel pozitieP2_5;
    private javax.swing.JLabel pozitieP2_6;
    private javax.swing.JLabel pozitieP2_7;
    private javax.swing.JLabel pozitieP2_8;
    private javax.swing.JLabel pozitieP2_9;
    private javax.swing.JLabel pozitieP2_Inchisoare;
    // End of variables declaration//GEN-END:variables
}
