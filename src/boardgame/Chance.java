
package boardgame;

public class Chance extends javax.swing.JPanel {

    public Chance() {
        initComponents();
    }
public void afisareText(String s){
    labelText.setText(s);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setText("Chance");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 114, -1, -1));

        labelText.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        add(labelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 298, 296, 65));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardgame/Zaruri/chance.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 0, 192, 276));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelText;
    // End of variables declaration//GEN-END:variables
}
