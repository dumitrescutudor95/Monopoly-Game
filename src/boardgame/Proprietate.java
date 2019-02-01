package boardgame;

import java.awt.Color;

public class Proprietate extends javax.swing.JPanel {

    public int idProprietate;
    public String nume;
    public boolean cumparata = false;
    public int proprietar = 0;
    public int pretCumparare;

    public int chirie;
    public int chirieInitiala;
    public int chirieCandAi1Magazin;
    public int chirieCandAi2Magazine;
    public int chirieCandAi3Magazine;
    public int chirieCandAi4Magazine;
    public int chirieCandAiSupermarket;

    public int numarMagazine = 0;
    public int pretMagazin;
    public int pretSupernarket;
    public boolean seMaiPotConstruiMagazine = true;
    public boolean seMaiPoateConstruiSupermarket = true;

    public void cumparaProprietate(int i) {
        cumparata = true;
        proprietar = i;
        if (i == 1) {
            labelPretProprietar.setText("Player 1");
        } else if (i == 2) {
            labelPretProprietar.setText("Player 2");
        }
    }

    public void setLabelPretProprietar(String s){
     labelPretProprietar.setText(s);
}
    public void setLabelChirie(int chirie){
     labelChirie.setText(String.valueOf(chirie));
    }
    public Proprietate(
            int idProprietate,
            String numeProprietate,
            Color culoareLabel,
            int chirie, //Cat trebuie sa plateasca adversarul daca pica aici
            int pretMagazin1, //Cat trebuie sa plateasca adversarul daca pica aici si avem 1 magazin
            int pretMagazin2, //Cat trebuie sa plateasca adversarul daca pica aici si avem 2 magazine
            int pretMagazin3, //Cat trebuie sa plateasca adversarul daca pica aici si avem 3 magazine
            int pretMagazin4, //Cat trebuie sa plateasca adversarul daca pica aici si avem 4 magazine 
            int supermarketChirie, //Cat trebuie sa plateasca adversarul daca pica aici si avem supermarket
            int magazineleCosta, //Cat costa sa punem un magazin pe aceasta proprietate
            int supermarketulCosta, //Cat costa sa punem un supermarket pe aceasta proprietate
            int pret //Cat costa sa cunoaram aceasta proprietate
    ) 
    {
        initComponents();
       
       
        this.idProprietate = idProprietate;
        this.nume=numeProprietate;
        this.chirie = chirie;
        chirieInitiala=chirie;
        this.pretMagazin = magazineleCosta;
        this.pretCumparare = pret;
        pretSupernarket = supermarketulCosta;
        chirieCandAi1Magazin = pretMagazin1;
        chirieCandAi2Magazine = pretMagazin2;
        chirieCandAi3Magazine = pretMagazin3;
        chirieCandAi4Magazine = pretMagazin4;
        chirieCandAiSupermarket = supermarketChirie;

        labelNumeProprietate.setText(numeProprietate);
        panelCuloareProprietate.setBackground(culoareLabel);
        labelChirie.setText(String.valueOf(chirie + "$"));
        labelMagazin1.setText(String.valueOf(pretMagazin1));
        labelMagazin2.setText(String.valueOf(pretMagazin2));
        labelMagazin3.setText(String.valueOf(pretMagazin3));
        labelMagazin4.setText(String.valueOf(pretMagazin4));
        labelSupermarket.setText(String.valueOf(supermarketChirie));
        labelPretMagazin.setText(String.valueOf(magazineleCosta));
        labelPretSupermarket.setText(String.valueOf(supermarketulCosta));
        labelPretProprietar.setText("Pret: " + String.valueOf(pret));
    }

    
    
    @Override
    public String toString() {
        return this.nume;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelChirie = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelMagazin1 = new javax.swing.JLabel();
        labelMagazin2 = new javax.swing.JLabel();
        labelMagazin3 = new javax.swing.JLabel();
        labelMagazin4 = new javax.swing.JLabel();
        labelPretProprietar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelPretMagazin = new javax.swing.JLabel();
        labelPretSupermarket = new javax.swing.JLabel();
        panelCuloareProprietate = new javax.swing.JPanel();
        labelNumeProprietate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        labelSupermarket = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 204, 102));
        setForeground(new java.awt.Color(0, 153, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Proprietate");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Chiria:");

        labelChirie.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelChirie.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("1 MAGAZIN");

        jLabel4.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("2 MAGAZINE");

        jLabel5.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("3 MAGAZINE");

        jLabel6.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setText("4 MAGAZINE");

        labelMagazin1.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        labelMagazin1.setForeground(new java.awt.Color(0, 153, 51));

        labelMagazin2.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        labelMagazin2.setForeground(new java.awt.Color(0, 153, 51));

        labelMagazin3.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        labelMagazin3.setForeground(new java.awt.Color(0, 153, 51));

        labelMagazin4.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        labelMagazin4.setForeground(new java.awt.Color(0, 153, 51));

        labelPretProprietar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelPretProprietar.setForeground(new java.awt.Color(0, 0, 0));
        labelPretProprietar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Pret magazin");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Pret supermarket");

        labelPretMagazin.setForeground(new java.awt.Color(0, 0, 0));
        labelPretMagazin.setText("labelPretMagazin");

        labelPretSupermarket.setForeground(new java.awt.Color(0, 0, 0));
        labelPretSupermarket.setText("labelPretSupermarket");

        labelNumeProprietate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelNumeProprietate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelCuloareProprietateLayout = new javax.swing.GroupLayout(panelCuloareProprietate);
        panelCuloareProprietate.setLayout(panelCuloareProprietateLayout);
        panelCuloareProprietateLayout.setHorizontalGroup(
            panelCuloareProprietateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuloareProprietateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNumeProprietate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCuloareProprietateLayout.setVerticalGroup(
            panelCuloareProprietateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuloareProprietateLayout.createSequentialGroup()
                .addComponent(labelNumeProprietate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        jLabel7.setBackground(new java.awt.Color(255, 0, 51));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SUPERMARKET");

        labelSupermarket.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelSupermarket.setForeground(new java.awt.Color(0, 0, 0));
        labelSupermarket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelSupermarket, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSupermarket, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMagazin4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMagazin3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMagazin1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMagazin2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(panelCuloareProprietate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(labelPretProprietar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelChirie, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPretMagazin)
                    .addComponent(labelPretSupermarket))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(panelCuloareProprietate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelChirie, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(labelMagazin1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(labelMagazin2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(labelMagazin3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(labelMagazin4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(labelPretMagazin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(labelPretSupermarket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPretProprietar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelChirie;
    private javax.swing.JLabel labelMagazin1;
    private javax.swing.JLabel labelMagazin2;
    private javax.swing.JLabel labelMagazin3;
    private javax.swing.JLabel labelMagazin4;
    private javax.swing.JLabel labelNumeProprietate;
    private javax.swing.JLabel labelPretMagazin;
    private javax.swing.JLabel labelPretProprietar;
    private javax.swing.JLabel labelPretSupermarket;
    private javax.swing.JLabel labelSupermarket;
    private javax.swing.JPanel panelCuloareProprietate;
    // End of variables declaration//GEN-END:variables
}
