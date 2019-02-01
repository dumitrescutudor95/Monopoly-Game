package boardgame;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class Trade extends javax.swing.JFrame {

    public Map map;

    public boolean player1ReadyForTrade = false;
    public boolean player2ReadyForTrade = false;

    boolean locked = false;

    //Modelele listelor proprietatilor celor 2 jucatori
    DefaultListModel model1 = new DefaultListModel();
    DefaultListModel model2 = new DefaultListModel();

    ImageIcon checkImage = new ImageIcon(this.getClass().getResource("Zaruri//check.png"));

    Timer tradeChecker = new Timer();

    //Timertask folosit pentru activarea negotului.
    TimerTask verifica = new TimerTask() {
        public void run() {
            int baniOferitiDePlayer1;
            int baniOferitiDePlayer2;
            //Daca ambii jucatori au acceptat,codul se va executa
            if (player1ReadyForTrade & player2ReadyForTrade) {
                //Transferul banilor de la un jucator la celalalt
                if (baniOferitiPlayer1.getText().equals("")) {
                    baniOferitiDePlayer1 = 0;
                } else {
                    baniOferitiDePlayer1 = Integer.parseInt(baniOferitiPlayer1.getText());
                }
                if (baniOferitiPlayer2.getText().equals("")) {
                    baniOferitiDePlayer2 = 0;
                } else {
                    baniOferitiDePlayer2 = Integer.parseInt(baniOferitiPlayer2.getText());
                }

                map.player1.bugetPlayer += baniOferitiDePlayer2;
                map.player1.bugetPlayer -= baniOferitiDePlayer1;
                map.player2.bugetPlayer += baniOferitiDePlayer1;
                map.player2.bugetPlayer -= baniOferitiDePlayer2;

                map.afiseazaBuget(); //Refresh buget labels

                //Se determina domeniul pus la vanzare de jucatori.
                String ceOferaPlayer1 = domeniuOferitPlayer1.getText();
                String ceOferaPlayer2 = domeniuOferitPlayer2.getText();
//Daca acest domeniu face parte din lista domeniilor player1
                for (Object o : map.player1.listaDomeniiPlayer) {
                    //Daca ce ofera jucatorul1 se regaseste in aceasta lista
                    if (o.toString().equals(ceOferaPlayer1)) {
                        
                       //Se parcurg listele fiecarui domeniu,iar domeniul oferit trece
                       //In posesia celuilalt jucator
                       
                        for (Fabrica f : map.listaFabrici) {
                            if (f.toString().equals(o.toString())) {
                                map.player2.listaDomeniiPlayer.add(f);
                                f.proprietar = 2;
                                f.setLabelPretProprietar("Player 2");
                                switch (f.idFabrica) {
                                    case 12:
                                        map.schimbaFabricaElectrica(1);
                                        break;
                                    case 27:
                                        map.schimbaFabricaApa(1);
                                        break;

                                }
                            }
                        }
                        for (Train t : map.listaMetrouri) {
                            if (t.toString().equals(o.toString())) {
                                map.player2.listaDomeniiPlayer.add(t);
                                t.proprietar = 2;
                                t.setLabelPretProprietar("Player 2");
                                switch (t.idMetrou) {
                                    case 5:
                                        map.schimbaMetrou5(1);
                                        break;
                                    case 15:
                                        map.schimbaMetrou15(1);
                                        break;
                                    case 25:
                                        map.schimbaMetrou25(1);
                                        break;
                                    case 35:
                                        map.schimbaMetrou35(1);
                                        break;
                                }
                            }
                        }
                        for (Proprietate p : map.listaProprietati) {
                            if (p.toString().equals(o.toString())) {
                                map.player2.listaDomeniiPlayer.add(p);
                                p.proprietar = 2;
                                p.setLabelPretProprietar("Player 2");
                                switch (p.idProprietate) {
                                    case 1:
                                        map.schimbaB1(1);
                                        map.player1.proprietatiPlayer.proprietati_1_3--;
                                        map.player2.proprietatiPlayer.proprietati_1_3++;
                                        break;
                                    case 3:
                                        map.schimbaB3(1);
                                        map.player1.proprietatiPlayer.proprietati_1_3--;
                                        map.player2.proprietatiPlayer.proprietati_1_3++;
                                        break;
                                    case 6:
                                        map.schimbaB6(1);
                                        map.player1.proprietatiPlayer.proprietati_6_8_9--;
                                        map.player2.proprietatiPlayer.proprietati_6_8_9++;
                                        break;
                                    case 8:
                                        map.schimbaB8(1);
                                        map.player1.proprietatiPlayer.proprietati_6_8_9--;
                                        map.player2.proprietatiPlayer.proprietati_6_8_9++;
                                        break;
                                    case 9:
                                        map.schimbaB9(1);
                                        map.player1.proprietatiPlayer.proprietati_6_8_9--;
                                        map.player2.proprietatiPlayer.proprietati_6_8_9++;
                                        break;
                                    case 11:
                                        map.schimbaB11(1);
                                        map.player1.proprietatiPlayer.proprietati_11_13_14--;
                                        map.player2.proprietatiPlayer.proprietati_11_13_14++;
                                        break;
                                    case 13:
                                        map.schimbaB13(1);
                                        map.player1.proprietatiPlayer.proprietati_11_13_14--;
                                        map.player2.proprietatiPlayer.proprietati_11_13_14++;
                                        break;
                                    case 14:
                                        map.schimbaB14(1);
                                        map.player1.proprietatiPlayer.proprietati_11_13_14--;
                                        map.player2.proprietatiPlayer.proprietati_11_13_14++;
                                        break;
                                    case 16:
                                        map.schimbaB16(1);
                                        map.player1.proprietatiPlayer.proprietati_16_18_19--;
                                        map.player2.proprietatiPlayer.proprietati_16_18_19++;
                                        break;
                                    case 18:
                                        map.schimbaB18(1);
                                        map.player1.proprietatiPlayer.proprietati_16_18_19--;
                                        map.player2.proprietatiPlayer.proprietati_16_18_19++;
                                        break;
                                    case 19:
                                        map.schimbaB19(1);
                                        map.player1.proprietatiPlayer.proprietati_16_18_19--;
                                        map.player2.proprietatiPlayer.proprietati_16_18_19++;
                                        break;
                                    case 21:
                                        map.schimbaB21(1);
                                        map.player1.proprietatiPlayer.proprietati_21_22_24--;
                                        map.player2.proprietatiPlayer.proprietati_21_22_24++;
                                        break;
                                    case 22:
                                        map.schimbaB22(1);
                                        map.player1.proprietatiPlayer.proprietati_21_22_24--;
                                        map.player2.proprietatiPlayer.proprietati_21_22_24++;
                                        break;
                                    case 24:
                                        map.schimbaB24(1);
                                        map.player1.proprietatiPlayer.proprietati_21_22_24--;
                                        map.player2.proprietatiPlayer.proprietati_21_22_24++;
                                        break;
                                    case 26:
                                        map.schimbaB26(1);
                                        map.player1.proprietatiPlayer.proprietati_26_28_29--;
                                        map.player2.proprietatiPlayer.proprietati_26_28_29++;
                                        break;
                                    case 28:
                                        map.schimbaB28(1);
                                        map.player1.proprietatiPlayer.proprietati_26_28_29--;
                                        map.player2.proprietatiPlayer.proprietati_26_28_29++;
                                        break;
                                    case 29:
                                        map.schimbaB29(1);
                                        map.player1.proprietatiPlayer.proprietati_26_28_29--;
                                        map.player2.proprietatiPlayer.proprietati_26_28_29++;
                                        break;
                                    case 31:
                                        map.schimbaB31(1);
                                        map.player1.proprietatiPlayer.proprietati_31_32_34--;
                                        map.player2.proprietatiPlayer.proprietati_31_32_34++;
                                        break;
                                    case 32:
                                        map.schimbaB32(1);
                                        map.player1.proprietatiPlayer.proprietati_31_32_34--;
                                        map.player2.proprietatiPlayer.proprietati_31_32_34++;
                                        break;
                                    case 34:
                                        map.schimbaB34(1);
                                        map.player1.proprietatiPlayer.proprietati_31_32_34--;
                                        map.player2.proprietatiPlayer.proprietati_31_32_34++;
                                        break;
                                    case 37:
                                        map.schimbaB37(1);
                                        map.player1.proprietatiPlayer.proprietati_37_39--;
                                        map.player2.proprietatiPlayer.proprietati_37_39++;
                                        break;
                                    case 39:
                                        map.schimbaB39(1);
                                        map.player1.proprietatiPlayer.proprietati_37_39--;
                                        map.player2.proprietatiPlayer.proprietati_37_39++;
                                        break;
                                }
                            }
                        }
                        // se adauga in 2
                        map.player1.listaDomeniiPlayer.remove(o);
                    }
                }
                //Lafel si pentru player2
                for (Object o : map.player2.listaDomeniiPlayer) {
                    if (o.toString().equals(ceOferaPlayer2)) {
                           
                       //Se parcurg listele fiecarui domeniu,iar domeniul oferit trece
                       //In posesia celuilalt jucator
                       
                        for (Fabrica f : map.listaFabrici) {
                            if (f.toString().equals(o.toString())) {
                                map.player1.listaDomeniiPlayer.add(f);
                                f.proprietar = 1;
                                f.setLabelPretProprietar("Player 1");
                                switch (f.idFabrica) {
                                    case 12:
                                        map.schimbaFabricaElectrica(2);
                                        break;
                                    case 27:
                                        map.schimbaFabricaApa(2);
                                        break;

                                }
                            }
                        }
                        for (Train t : map.listaMetrouri) {
                            if (t.toString().equals(o.toString())) {
                                map.player1.listaDomeniiPlayer.add(t);
                                t.proprietar = 1;
                                t.setLabelPretProprietar("Player 1");
                                switch (t.idMetrou) {
                                    case 5:
                                        map.schimbaMetrou5(2);
                                        break;
                                    case 15:
                                        map.schimbaMetrou15(2);
                                        break;
                                    case 25:
                                        map.schimbaMetrou25(2);
                                        break;
                                    case 35:
                                        map.schimbaMetrou35(2);
                                        break;

                                }
                            }
                        }
                        for (Proprietate p : map.listaProprietati) {
                            if (p.toString().equals(o.toString())) {
                                map.player1.listaDomeniiPlayer.add(p);
                                p.proprietar = 1;
                                p.setLabelPretProprietar("Player 1");
                                switch (p.idProprietate) {
                                    case 1:
                                        map.schimbaB1(2);
                                        map.player1.proprietatiPlayer.proprietati_1_3++;
                                        map.player2.proprietatiPlayer.proprietati_1_3--;
                                        break;
                                    case 3:
                                        map.schimbaB3(2);
                                        map.player1.proprietatiPlayer.proprietati_1_3++;
                                        map.player2.proprietatiPlayer.proprietati_1_3--;
                                        break;
                                    case 6:
                                        map.schimbaB6(2);
                                        map.player1.proprietatiPlayer.proprietati_6_8_9++;
                                        map.player2.proprietatiPlayer.proprietati_6_8_9--;
                                        break;
                                    case 8:
                                        map.schimbaB8(2);
                                        map.player1.proprietatiPlayer.proprietati_6_8_9++;
                                        map.player2.proprietatiPlayer.proprietati_6_8_9--;
                                        break;
                                    case 9:
                                        map.schimbaB9(2);
                                        map.player1.proprietatiPlayer.proprietati_6_8_9++;
                                        map.player2.proprietatiPlayer.proprietati_6_8_9--;
                                        break;
                                    case 11:
                                        map.schimbaB11(2);
                                        map.player1.proprietatiPlayer.proprietati_11_13_14++;
                                        map.player2.proprietatiPlayer.proprietati_11_13_14--;
                                        break;
                                    case 13:
                                        map.schimbaB13(2);
                                        map.player1.proprietatiPlayer.proprietati_11_13_14++;
                                        map.player2.proprietatiPlayer.proprietati_11_13_14--;
                                        break;
                                    case 14:
                                        map.schimbaB14(2);
                                        map.player1.proprietatiPlayer.proprietati_11_13_14++;
                                        map.player2.proprietatiPlayer.proprietati_11_13_14--;
                                        break;
                                    case 16:
                                        map.schimbaB16(2);
                                        map.player1.proprietatiPlayer.proprietati_16_18_19++;
                                        map.player2.proprietatiPlayer.proprietati_16_18_19--;
                                        break;
                                    case 18:
                                        map.schimbaB18(2);
                                        map.player1.proprietatiPlayer.proprietati_16_18_19++;
                                        map.player2.proprietatiPlayer.proprietati_16_18_19--;
                                        break;
                                    case 19:
                                        map.schimbaB19(2);
                                        map.player1.proprietatiPlayer.proprietati_16_18_19++;
                                        map.player2.proprietatiPlayer.proprietati_16_18_19--;
                                        break;
                                    case 21:
                                        map.schimbaB21(2);
                                        map.player1.proprietatiPlayer.proprietati_21_22_24++;
                                        map.player2.proprietatiPlayer.proprietati_21_22_24--;
                                        break;
                                    case 22:
                                        map.schimbaB22(2);
                                        map.player1.proprietatiPlayer.proprietati_21_22_24++;
                                        map.player2.proprietatiPlayer.proprietati_21_22_24--;
                                        break;
                                    case 24:
                                        map.schimbaB24(2);
                                        map.player1.proprietatiPlayer.proprietati_21_22_24++;
                                        map.player2.proprietatiPlayer.proprietati_21_22_24--;
                                        break;
                                    case 26:
                                        map.schimbaB26(2);
                                        map.player1.proprietatiPlayer.proprietati_26_28_29++;
                                        map.player2.proprietatiPlayer.proprietati_26_28_29--;
                                        break;
                                    case 28:
                                        map.schimbaB28(2);
                                        map.player1.proprietatiPlayer.proprietati_26_28_29++;
                                        map.player2.proprietatiPlayer.proprietati_26_28_29--;
                                        break;
                                    case 29:
                                        map.schimbaB29(2);
                                        map.player1.proprietatiPlayer.proprietati_26_28_29++;
                                        map.player2.proprietatiPlayer.proprietati_26_28_29--;
                                        break;
                                    case 31:
                                        map.schimbaB31(2);
                                        map.player1.proprietatiPlayer.proprietati_31_32_34++;
                                        map.player2.proprietatiPlayer.proprietati_31_32_34--;
                                        break;
                                    case 32:
                                        map.schimbaB32(2);
                                        map.player1.proprietatiPlayer.proprietati_31_32_34++;
                                        map.player2.proprietatiPlayer.proprietati_31_32_34--;
                                        break;
                                    case 34:
                                        map.schimbaB34(2);
                                        map.player1.proprietatiPlayer.proprietati_31_32_34++;
                                        map.player2.proprietatiPlayer.proprietati_31_32_34--;
                                        break;
                                    case 37:
                                        map.schimbaB37(2);
                                        map.player1.proprietatiPlayer.proprietati_37_39++;
                                        map.player2.proprietatiPlayer.proprietati_37_39--;
                                        break;
                                    case 39:
                                        map.schimbaB39(2);
                                        map.player1.proprietatiPlayer.proprietati_37_39++;
                                        map.player2.proprietatiPlayer.proprietati_37_39--;
                                        break;
                                }
                            }
                        }
                        //se adauga in 1
                        map.player2.listaDomeniiPlayer.remove(o);

                        domeniuOferitPlayer1.setText("");
                        domeniuOferitPlayer2.setText("");
                    }
                }

               //odata ce negotul s-a efectuat,facem Refresh datelor
                player1ReadyForTrade = false;
                player1ReadyForTrade = false;
                iconReady1.setIcon(null);
                iconReady2.setIcon(null);
                labelSuma.setText("");
                labelSuma2.setText("");
                baniOferitiPlayer1.setText("");
                baniOferitiPlayer2.setText("");
                domeniuOferitPlayer1.setText("");
                domeniuOferitPlayer2.setText("");
                setVisible(false);
            }

        }
    };

    public Trade(Map m) {
        initComponents();
        this.map = m;
        tabel1.setModel(model1);
        tabel2.setModel(model2);
        tradeChecker.schedule(verifica, 500, 1000);
    }

    //Repunerea in modele a celor doua liste de proprietati
    public void actualizeazaModelele() {
        model1.removeAllElements();
        model2.removeAllElements();
        for (Object o : map.player1.listaDomeniiPlayer) {
            model1.addElement(o);
        }
        for (Object o : map.player2.listaDomeniiPlayer) {
            model2.addElement(o);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelSuma = new javax.swing.JTextField();
        labelSuma2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        baniOferitiPlayer1 = new javax.swing.JLabel();
        domeniuOferitPlayer1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        baniOferitiPlayer2 = new javax.swing.JLabel();
        domeniuOferitPlayer2 = new javax.swing.JLabel();
        bInapoi = new javax.swing.JButton();
        iconReady2 = new javax.swing.JLabel();
        iconReady1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabel1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabel1);

        tabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabel2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabel2);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Suma:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Suma:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Player 1");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Player 2");

        labelSuma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                labelSumaKeyReleased(evt);
            }
        });

        labelSuma2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                labelSuma2KeyReleased(evt);
            }
        });

        jButton1.setText("Accepta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Accepta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Player 1 ofera:");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Player 2 ofera:");

        baniOferitiPlayer1.setForeground(new java.awt.Color(0, 0, 0));
        baniOferitiPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        domeniuOferitPlayer1.setForeground(new java.awt.Color(0, 0, 0));
        domeniuOferitPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(baniOferitiPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
            .addComponent(domeniuOferitPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(baniOferitiPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(domeniuOferitPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        baniOferitiPlayer2.setForeground(new java.awt.Color(0, 0, 0));
        baniOferitiPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        domeniuOferitPlayer2.setForeground(new java.awt.Color(0, 0, 0));
        domeniuOferitPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(baniOferitiPlayer2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(domeniuOferitPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(baniOferitiPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(domeniuOferitPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(24, 24, 24))
        );

        bInapoi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bInapoi.setText("Inapoi");
        bInapoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInapoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton1))
                    .addComponent(iconReady1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bInapoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(jButton2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelSuma2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(iconReady2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(labelSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(labelSuma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(bInapoi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconReady1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconReady2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Buton:Player 1 accepta negotul
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        iconReady1.setIcon(checkImage);
        player1ReadyForTrade = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel1MouseReleased
      //Se va putea transmite de la un jucator la altul numai un singur domeniu per negot
        if (!locked) {
            int index = tabel1.getSelectedIndex();
            Object temp = map.player1.listaDomeniiPlayer.get(index);
            domeniuOferitPlayer1.setText(temp.toString());
        }
        locked = true;
    }//GEN-LAST:event_tabel1MouseReleased

    private void tabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel2MouseReleased
      //Se va putea transmite de la un jucator la altul numai un singur domeniu per negot
        if (!locked) {
            int index = tabel2.getSelectedIndex();
            Object temp = map.player2.listaDomeniiPlayer.get(index);
            domeniuOferitPlayer2.setText(temp.toString());
        }
        locked = true;

    }//GEN-LAST:event_tabel2MouseReleased

    //Buton back
    private void bInapoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInapoiActionPerformed
        locked = false;
        this.setVisible(false);
        baniOferitiPlayer2.setText("");
        baniOferitiPlayer1.setText("");
        domeniuOferitPlayer1.setText("");
        domeniuOferitPlayer2.setText("");
        labelSuma.setText("");
        labelSuma2.setText("");
        iconReady1.setIcon(null);
        iconReady2.setIcon(null);
        player1ReadyForTrade = false;
        player2ReadyForTrade = false;
    }//GEN-LAST:event_bInapoiActionPerformed

    private void labelSumaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_labelSumaKeyReleased
        baniOferitiPlayer1.setText(labelSuma.getText());
    }//GEN-LAST:event_labelSumaKeyReleased

    private void labelSuma2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_labelSuma2KeyReleased
        baniOferitiPlayer2.setText(labelSuma2.getText());
    }//GEN-LAST:event_labelSuma2KeyReleased

    //Buton:Player 2 accepta negotul
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        iconReady2.setIcon(checkImage);
        player2ReadyForTrade = true;
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bInapoi;
    private javax.swing.JLabel baniOferitiPlayer1;
    private javax.swing.JLabel baniOferitiPlayer2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel domeniuOferitPlayer1;
    private javax.swing.JLabel domeniuOferitPlayer2;
    private javax.swing.JLabel iconReady1;
    private javax.swing.JLabel iconReady2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField labelSuma;
    private javax.swing.JTextField labelSuma2;
    private javax.swing.JList<String> tabel1;
    private javax.swing.JList<String> tabel2;
    // End of variables declaration//GEN-END:variables
}
