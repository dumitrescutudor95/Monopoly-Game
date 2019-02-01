package boardgame;

public class Chest extends javax.swing.JPanel {

    public Chest() {
        initComponents();
    }

    public void afisareText(String s) {
        labelText.setText(s);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImageChest = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 204, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelImageChest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardgame/Zaruri/treasure.png"))); // NOI18N
        add(labelImageChest, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setText("Chest");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        labelText.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        add(labelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 320, 90));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelImageChest;
    private javax.swing.JLabel labelText;
    // End of variables declaration//GEN-END:variables
}
