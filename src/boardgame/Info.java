package boardgame;

public class Info extends javax.swing.JFrame {

    public Info() {
        initComponents();
        infoText.setText("Acesta este un proiect personal:Board game Monopoly\n"
                + "\n"
                + "  Scopul acestui joc este de a il lasa pe oponent fara nici un ban,prin achizitionarea proprietatilor,\n"
                + "metrourilor si a fabricilor.La inceputul jocului,fiecare jucator va avea 2500$.\n"
                + " Daca oponentul pica pe o proprietate cumparata de tine,va trebui sa iti plateasca chiria locatiei.\n"
                + " Fiecare proprietate va avea propria chirie,care va creste ulterior in functie de numarul\n"
                + "magazinelor si de supermarketul locatiei respective.\n"
                + " In momentul in care jucatorul detine toate 3 proprietatile de aceeasi culoare,acesta poate incepe \n"
                + "construirea magazinelor.\n"
                + " O proprietate poate avea maxim 4 magazine.Dupa achizitionarea celor 4 magazine,este posibila\n"
                + " cumpararea unui supermarket. \n"
                + " Daca jucatorul detine o singura statie de metrou si adversarul pica pe ea,jucatorul va colecta de\n"
                + "la oponent 25 de dolari.daca jucatorul detine 2 statii,va primi 50$. 3->100$. 4->200$.\n"
                + " Daca jucatorul detine o singura fabrica si oponentul pica pe ea,jucatorul va primi de 5 ori valoarea \n"
                + "zarului in conditiile in care detine doar o fabrica,iar daca o detine si pe cea de-a doua,va primi de 10.\n"
                + " Daca jucatorul da dublu cu zarurile,va mai da inca o data.\n"
                + " La fiecare trecere prin START,jucatorul va primi 200$ de la banca.\n"
                + " Daca jucatorul pica in inchisoare,va astepta 3 ture.\n"
                + " Jocul prezinta optiunea de Trade,in care jucatorii pot vinde si cumpara intre ei elementele deja \n"
                + "detinute si banii.\n"
                  + "Daca jucatorul pica pe cartile Chance sau Chest,va trage o carte,care va avea diverse efecte.\n"
                + "In momentul in care bugetul adversarului este gol,jocul se termina.");
        infoText.setEditable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        infoText = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        infoText.setColumns(20);
        infoText.setRows(5);
        jScrollPane1.setViewportView(infoText);

        jButton1.setText("Inapoi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea infoText;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
