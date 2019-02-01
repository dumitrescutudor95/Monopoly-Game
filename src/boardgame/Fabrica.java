package boardgame;

import javax.swing.ImageIcon;

public class Fabrica extends javax.swing.JPanel {

    public String nume;
    public boolean cumparata = false;
    public int proprietar = 0;
    public int idFabrica;

    public Fabrica(int id, String nume, ImageIcon img) {
        initComponents();
        this.idFabrica = id;
        this.nume = nume;
        this.labelTipulFabricii.setText(nume);
        labelImagine.setIcon(img);

    }

    public void setLabelPretProprietar(String s) {
        labelPretProprietar.setText(s);
    }

    //Metoda folosita pentru cumpararea fabricii
    public void cumparaFabrica(int i) {
        cumparata = true;
        proprietar = i;
        if (i == 1) {
            labelPretProprietar.setText("Player 1");
        } else if (i == 2) {
            labelPretProprietar.setText("Player 2");
        }
    }

    @Override
    public String toString() {
        return this.nume;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelTipulFabricii = new javax.swing.JLabel();
        labelImagine = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelPretProprietar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Fabrica");

        labelTipulFabricii.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelTipulFabricii.setForeground(new java.awt.Color(0, 0, 0));
        labelTipulFabricii.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Daca proprietarul are o singura unitate,ia chiria de 5 ori zarul");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Daca are 2 proprietati,ia chiria de  10 ori zarul.");

        labelPretProprietar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelPretProprietar.setForeground(new java.awt.Color(0, 0, 0));
        labelPretProprietar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPretProprietar.setText("Pret: 150$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelImagine, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipulFabricii, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelPretProprietar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTipulFabricii, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelImagine, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPretProprietar)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelImagine;
    private javax.swing.JLabel labelPretProprietar;
    private javax.swing.JLabel labelTipulFabricii;
    // End of variables declaration//GEN-END:variables
}
