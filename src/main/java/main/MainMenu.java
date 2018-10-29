
package main;


public class MainMenu extends javax.swing.JFrame {

 
    public MainMenu() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogRules = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonBackToMenu = new javax.swing.JButton();
        DialogAbout = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        buttonReturnToMenu2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        buttonNdewGame = new javax.swing.JButton();
        buttonRules = new javax.swing.JButton();
        buttonAbout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        DialogRules.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DialogRules.setTitle("Zasady");
        DialogRules.setName("Zasady"); // NOI18N
        DialogRules.setResizable(false);
        DialogRules.setSize(new java.awt.Dimension(450, 350));
        DialogRules.setType(java.awt.Window.Type.POPUP);
        DialogRules.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                DialogRulesWindowClosed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Quiz zawiera 10 pytań z wiedzy ogólnej.\n\nGracz może wykorzystać jedno koło ratunkowe (50/50) które odrzuca losowo dwie błędne odpowiedzi.\n\nCzas bez limitu.\n\nPowodzenia!\n\n");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAlignmentX(3.0F);
        jScrollPane1.setViewportView(jTextArea1);

        buttonBackToMenu.setBackground(new java.awt.Color(0, 0, 0));
        buttonBackToMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        buttonBackToMenu.setForeground(new java.awt.Color(255, 255, 255));
        buttonBackToMenu.setText("Powrót");
        buttonBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackToMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DialogRulesLayout = new javax.swing.GroupLayout(DialogRules.getContentPane());
        DialogRules.getContentPane().setLayout(DialogRulesLayout);
        DialogRulesLayout.setHorizontalGroup(
            DialogRulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogRulesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DialogRulesLayout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(buttonBackToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );
        DialogRulesLayout.setVerticalGroup(
            DialogRulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogRulesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonBackToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DialogAbout.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DialogAbout.setTitle("O Programie");
        DialogAbout.setBackground(new java.awt.Color(0, 0, 102));
        DialogAbout.setIconImage(null);
        DialogAbout.setMinimumSize(new java.awt.Dimension(400, 300));
        DialogAbout.setResizable(false);
        DialogAbout.setSize(new java.awt.Dimension(400, 310));
        DialogAbout.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                DialogAboutWindowClosed(evt);
            }
        });
        DialogAbout.getContentPane().setLayout(null);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(153, 153, 153));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea2.setRows(5);
        jTextArea2.setText("\n\t Quiz z wiedzy ogólnej\n\n\tAutor: Grzegorz Filewicz\n            użyte technologie: Java SE, SQLite\n\n\t   Lublin, 10.04.2018 \n\n\t  ");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(null);
        jScrollPane2.setViewportView(jTextArea2);
        jTextArea2.getAccessibleContext().setAccessibleName("");

        DialogAbout.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 10, 340, 170);

        buttonReturnToMenu2.setBackground(new java.awt.Color(255, 255, 255));
        buttonReturnToMenu2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        buttonReturnToMenu2.setForeground(new java.awt.Color(0, 0, 0));
        buttonReturnToMenu2.setText("Powrót");
        buttonReturnToMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnToMenu2ActionPerformed(evt);
            }
        });
        DialogAbout.getContentPane().add(buttonReturnToMenu2);
        buttonReturnToMenu2.setBounds(160, 230, 104, 45);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(1, 34, 101));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 300));
        jPanel1.setLayout(null);

        buttonNdewGame.setBackground(new java.awt.Color(153, 153, 153));
        buttonNdewGame.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        buttonNdewGame.setForeground(new java.awt.Color(0, 0, 0));
        buttonNdewGame.setText("Nowa Gra");
        buttonNdewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNdewGameActionPerformed(evt);
            }
        });
        jPanel1.add(buttonNdewGame);
        buttonNdewGame.setBounds(170, 110, 130, 37);

        buttonRules.setBackground(new java.awt.Color(153, 153, 153));
        buttonRules.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        buttonRules.setForeground(new java.awt.Color(0, 0, 0));
        buttonRules.setText("Zasady Gry");
        buttonRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRulesActionPerformed(evt);
            }
        });
        jPanel1.add(buttonRules);
        buttonRules.setBounds(170, 170, 130, 37);

        buttonAbout.setBackground(new java.awt.Color(153, 153, 153));
        buttonAbout.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        buttonAbout.setForeground(new java.awt.Color(0, 0, 0));
        buttonAbout.setText("O Programie");
        buttonAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAboutActionPerformed(evt);
            }
        });
        jPanel1.add(buttonAbout);
        buttonAbout.setBounds(170, 230, 130, 37);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUIZ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(160, 30, 130, 50);

        jLabel1.setBackground(new java.awt.Color(1, 34, 101));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 420);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 660, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNdewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNdewGameActionPerformed
        this.dispose();
        new QuizGameGui().setVisible(true);

    }//GEN-LAST:event_buttonNdewGameActionPerformed

    private void buttonRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRulesActionPerformed
        buttonRules.setEnabled(false);
        buttonAbout.setEnabled(false);
        buttonNdewGame.setEnabled(false);
        DialogRules.setVisible(true);
    }//GEN-LAST:event_buttonRulesActionPerformed

    private void buttonBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackToMenuActionPerformed
        buttonRules.setEnabled(true);
        buttonAbout.setEnabled(true);
        buttonNdewGame.setEnabled(true);
        DialogRules.dispose();

    }//GEN-LAST:event_buttonBackToMenuActionPerformed

    private void DialogRulesWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_DialogRulesWindowClosed
        buttonRules.setEnabled(true);
        buttonAbout.setEnabled(true);
        buttonNdewGame.setEnabled(true);
        DialogRules.dispose();
    }//GEN-LAST:event_DialogRulesWindowClosed

    private void buttonReturnToMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnToMenu2ActionPerformed
        buttonRules.setEnabled(true);
        buttonAbout.setEnabled(true);
        buttonNdewGame.setEnabled(true);
        DialogAbout.dispose();
    }//GEN-LAST:event_buttonReturnToMenu2ActionPerformed

    private void DialogAboutWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_DialogAboutWindowClosed
        buttonRules.setEnabled(true);
        buttonAbout.setEnabled(true);
        buttonNdewGame.setEnabled(true);
        DialogRules.dispose();
    }//GEN-LAST:event_DialogAboutWindowClosed

    private void buttonAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAboutActionPerformed
        buttonRules.setEnabled(false);
        buttonAbout.setEnabled(false);
        buttonNdewGame.setEnabled(false);
        DialogAbout.setVisible(true);
    }//GEN-LAST:event_buttonAboutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogAbout;
    private javax.swing.JDialog DialogRules;
    private javax.swing.JButton buttonAbout;
    private javax.swing.JButton buttonBackToMenu;
    private javax.swing.JButton buttonNdewGame;
    private javax.swing.JButton buttonReturnToMenu2;
    private javax.swing.JButton buttonRules;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
