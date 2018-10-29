package main;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import util.DbUtil;

public class QuizGameGui extends javax.swing.JFrame {

  
    public QuizGameGui() {
        initComponents();

    }
    private static final Connection CONNECTION = null;
    private static String Question;
    private static String AnswerA;
    private static String AnswerB;
    private static String AnswerC;
    private static String AnswerD;
    private static String Correct;
    private static int QuestionCounter = 1;
    private static int NextQuestion = 0;
    private int Points = 0;
    private static Statement statement;
    private static ResultSet resultSet;
    private ArrayList<Integer> listOfQuestions;

    private static void selectQuestionCategory(Connection connection, int NextQuestion, String category) throws SQLException {
        connection = DbUtil.connectToDataBase();
        statement = connection.createStatement();

        String query = "SELECT Pytanie, OdpA,OdpB, OdpC,OdpD,Poprawna from " + category + " where ID =" + NextQuestion + "";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

            Question = resultSet.getString("Pytanie");
            AnswerA = resultSet.getString("OdpA");
            AnswerB = resultSet.getString("odpB");
            AnswerC = resultSet.getString("OdpC");
            AnswerD = resultSet.getString("OdpD");
            Correct = resultSet.getString("Poprawna");

        }
        DbUtil.closeConnection(connection, statement, resultSet);
    }

    private void clickOnStartButton() {
        listOfQuestions = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            listOfQuestions.add(i);
        }
        Collections.shuffle(listOfQuestions);

        try {
            selectQuestionCategory(CONNECTION, listOfQuestions.get(NextQuestion), "Easy");
        } catch (SQLException ex) {
            Logger.getLogger(QuizGameGui.class.getName()).log(Level.SEVERE, null, ex);
        }

        setEnabledAnswerFields();

        labelQuestion.setText(Question);

        labelAnswerA.setText(AnswerA);

        labelAnswerB.setText(AnswerB);

        labelAnswerC.setText(AnswerC);

        labelAnswerD.setText(AnswerD);

        labelQuestionsCounter.setText(String.valueOf(QuestionCounter));
        buttonStart.setEnabled(false);
        labelPoints.setText("0");
        Points = 0;
        buttonHelp1.setEnabled(true);
    }

    private void clickOnButtonNext() {
        NextQuestion += 1;
        int next = listOfQuestions.get(NextQuestion);

        if (QuestionCounter < 2) {
            try {
                selectQuestionCategory(CONNECTION, next, "Easy");
            } catch (SQLException ex) {
                Logger.getLogger(QuizGameGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (QuestionCounter >= 2 && QuestionCounter < 6) {
            try {
                selectQuestionCategory(CONNECTION, next, "Medium");
            } catch (SQLException ex) {
                Logger.getLogger(QuizGameGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (QuestionCounter >= 6) {
            try {
                selectQuestionCategory(CONNECTION, next, "Hard");
            } catch (SQLException ex) {
                Logger.getLogger(QuizGameGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        labelQuestion.setText(Question);
        clearColor();
        setColorFontWhite();
        labelAnswerA.setText(AnswerA);

        labelAnswerB.setText(AnswerB);

        labelAnswerC.setText(AnswerC);

        labelAnswerD.setText(AnswerD);
        buttonNext.setEnabled(false);

        radioButtonAnswerA.setSelected(false);
        radioButtonAnswerB.setSelected(false);
        radioButtonAnswerC.setSelected(false);
        RadioButtonAnswerD.setSelected(false);
        rbE.setSelected(true);
        setEnabledAnswerFields();

        QuestionCounter = QuestionCounter + 1;
        labelQuestionsCounter.setText(String.valueOf(QuestionCounter));
    }

    private void clickOnButtonHelp() {
        if (labelAnswerA.getText().equals(Correct)) {
            labelAnswerC.setText("");
            radioButtonAnswerC.setEnabled(false);
            labelAnswerD.setText("");
            RadioButtonAnswerD.setEnabled(false);

        } else if (labelAnswerB.getText().equals(Correct)) {
            labelAnswerA.setText("");
            radioButtonAnswerA.setEnabled(false);
            labelAnswerC.setText("");
            radioButtonAnswerC.setEnabled(false);
        } else if (labelAnswerC.getText().equals(Correct)) {
            labelAnswerB.setText("");
            radioButtonAnswerB.setEnabled(false);
            labelAnswerA.setText("");
            radioButtonAnswerA.setEnabled(false);
        } else if (labelAnswerD.getText().equals(Correct)) {
            labelAnswerC.setText("");
            radioButtonAnswerC.setEnabled(false);
            labelAnswerA.setText("");
            radioButtonAnswerA.setEnabled(false);
        }

        buttonHelp1.setEnabled(false);
    }

    private void clickOnButtonBack() throws HeadlessException {
        int a = JOptionPane.showConfirmDialog(this, "Czy napewno chcesz przerwać grę i wrócić do głównego Menu?", "Uwaga", JOptionPane.YES_NO_CANCEL_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            new MainMenu().setVisible(true);
            this.dispose();
        } else {
        }
    }

    private void choseAnswerA() {
        if (radioButtonAnswerA.isSelected()) {
            clearColor();
            labelAnswerA.setBackground(Color.ORANGE);
            labelAnswerA.setForeground(Color.WHITE);

            buttonCheck.setEnabled(true);
        }
    }

    private void chooseAnswerB() {
        if (radioButtonAnswerB.isSelected()) {
            clearColor();
            labelAnswerB.setBackground(Color.ORANGE);
            labelAnswerB.setForeground(Color.WHITE);

            buttonCheck.setEnabled(true);
        }
    }

    private void chooseAnswerC() {
        if (radioButtonAnswerC.isSelected()) {
            clearColor();
            labelAnswerC.setBackground(Color.ORANGE);
            labelAnswerC.setForeground(Color.WHITE);

            buttonCheck.setEnabled(true);
        }
    }

    private void chooseAnswerD() {
        if (RadioButtonAnswerD.isSelected()) {
            clearColor();
            labelAnswerD.setBackground(Color.ORANGE);
            labelAnswerD.setForeground(Color.WHITE);

            buttonCheck.setEnabled(true);
        }
    }

    private void clearColor() {
        labelAnswerA.setBackground(Color.BLACK);
        labelAnswerB.setBackground(Color.BLACK);
        labelAnswerC.setBackground(Color.BLACK);
        labelAnswerD.setBackground(Color.BLACK);

    }

    private void setColorFontWhite() {
        labelAnswerA.setForeground(Color.WHITE);
        labelAnswerB.setForeground(Color.WHITE);
        labelAnswerC.setForeground(Color.WHITE);
        labelAnswerD.setForeground(Color.WHITE);
    }

    private void setDisabledAnswerFields() {
        radioButtonAnswerA.setEnabled(false);
        radioButtonAnswerB.setEnabled(false);
        radioButtonAnswerC.setEnabled(false);
        RadioButtonAnswerD.setEnabled(false);
    }

    private void clearLabels() {
        labelQuestion.setText("");
        labelAnswerA.setText("");
        labelAnswerB.setText("");
        labelAnswerC.setText("");
        labelAnswerD.setText("");
    }

    private void setEnabledAnswerFields() {
        radioButtonAnswerA.setEnabled(true);
        radioButtonAnswerB.setEnabled(true);
        radioButtonAnswerC.setEnabled(true);
        RadioButtonAnswerD.setEnabled(true);
    }

    private void exitProgram() throws HeadlessException, SQLException {
        int exit = JOptionPane.showConfirmDialog(rootPane, "Czy napewno chcesz wyjść?", "Notatnik", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            this.dispose();

        } else if (exit == JOptionPane.NO_OPTION) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelAnswerA = new javax.swing.JTextField();
        labelAnswerC = new javax.swing.JTextField();
        labelAnswerB = new javax.swing.JTextField();
        labelAnswerD = new javax.swing.JTextField();
        buttonStart = new javax.swing.JButton();
        buttonCheck = new javax.swing.JButton();
        radioButtonAnswerA = new javax.swing.JRadioButton();
        radioButtonAnswerB = new javax.swing.JRadioButton();
        radioButtonAnswerC = new javax.swing.JRadioButton();
        RadioButtonAnswerD = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        labelQuestionsCounter = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelPoints = new javax.swing.JLabel();
        buttonNext = new javax.swing.JButton();
        rbE = new javax.swing.JRadioButton();
        labelQuestion = new javax.swing.JTextField();
        buttonHelp1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ButtonBackMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 430));
        setPreferredSize(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(1, 31, 101));
        jPanel1.setLayout(null);

        labelAnswerA.setEditable(false);
        labelAnswerA.setBackground(new java.awt.Color(0, 0, 0));
        labelAnswerA.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelAnswerA.setForeground(new java.awt.Color(255, 255, 255));
        labelAnswerA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        labelAnswerA.setDragEnabled(true);
        jPanel1.add(labelAnswerA);
        labelAnswerA.setBounds(70, 200, 160, 30);

        labelAnswerC.setEditable(false);
        labelAnswerC.setBackground(new java.awt.Color(0, 0, 0));
        labelAnswerC.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelAnswerC.setForeground(new java.awt.Color(255, 255, 255));
        labelAnswerC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        labelAnswerC.setDragEnabled(true);
        jPanel1.add(labelAnswerC);
        labelAnswerC.setBounds(320, 200, 150, 30);

        labelAnswerB.setEditable(false);
        labelAnswerB.setBackground(new java.awt.Color(0, 0, 0));
        labelAnswerB.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelAnswerB.setForeground(new java.awt.Color(255, 255, 255));
        labelAnswerB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        labelAnswerB.setDragEnabled(true);
        jPanel1.add(labelAnswerB);
        labelAnswerB.setBounds(70, 250, 160, 30);

        labelAnswerD.setEditable(false);
        labelAnswerD.setBackground(new java.awt.Color(0, 0, 0));
        labelAnswerD.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelAnswerD.setForeground(new java.awt.Color(255, 255, 255));
        labelAnswerD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        labelAnswerD.setDragEnabled(true);
        jPanel1.add(labelAnswerD);
        labelAnswerD.setBounds(320, 250, 150, 30);

        buttonStart.setBackground(new java.awt.Color(153, 153, 153));
        buttonStart.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        buttonStart.setForeground(new java.awt.Color(0, 0, 0));
        buttonStart.setText("Start");
        buttonStart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });
        jPanel1.add(buttonStart);
        buttonStart.setBounds(210, 10, 100, 30);

        buttonCheck.setBackground(new java.awt.Color(153, 153, 153));
        buttonCheck.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        buttonCheck.setForeground(new java.awt.Color(0, 0, 0));
        buttonCheck.setText("Sprawdź");
        buttonCheck.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonCheck.setEnabled(false);
        buttonCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCheckActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCheck);
        buttonCheck.setBounds(200, 290, 100, 40);

        buttonGroup1.add(radioButtonAnswerA);
        radioButtonAnswerA.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        radioButtonAnswerA.setForeground(new java.awt.Color(255, 255, 255));
        radioButtonAnswerA.setText("A ");
        radioButtonAnswerA.setEnabled(false);
        radioButtonAnswerA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonAnswerAActionPerformed(evt);
            }
        });
        jPanel1.add(radioButtonAnswerA);
        radioButtonAnswerA.setBounds(20, 200, 50, 30);

        buttonGroup1.add(radioButtonAnswerB);
        radioButtonAnswerB.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        radioButtonAnswerB.setForeground(new java.awt.Color(255, 255, 255));
        radioButtonAnswerB.setText("B");
        radioButtonAnswerB.setEnabled(false);
        radioButtonAnswerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonAnswerBActionPerformed(evt);
            }
        });
        jPanel1.add(radioButtonAnswerB);
        radioButtonAnswerB.setBounds(20, 250, 50, 30);

        buttonGroup1.add(radioButtonAnswerC);
        radioButtonAnswerC.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        radioButtonAnswerC.setForeground(new java.awt.Color(255, 255, 255));
        radioButtonAnswerC.setText("C");
        radioButtonAnswerC.setEnabled(false);
        radioButtonAnswerC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonAnswerCActionPerformed(evt);
            }
        });
        jPanel1.add(radioButtonAnswerC);
        radioButtonAnswerC.setBounds(270, 200, 50, 30);

        buttonGroup1.add(RadioButtonAnswerD);
        RadioButtonAnswerD.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        RadioButtonAnswerD.setForeground(new java.awt.Color(255, 255, 255));
        RadioButtonAnswerD.setText("D");
        RadioButtonAnswerD.setEnabled(false);
        RadioButtonAnswerD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonAnswerDActionPerformed(evt);
            }
        });
        jPanel1.add(RadioButtonAnswerD);
        RadioButtonAnswerD.setBounds(270, 250, 50, 30);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pytanie:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(420, 0, 60, 30);

        labelQuestionsCounter.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        labelQuestionsCounter.setForeground(new java.awt.Color(255, 255, 255));
        labelQuestionsCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labelQuestionsCounter);
        labelQuestionsCounter.setBounds(480, 0, 20, 30);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("/10");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(500, 0, 30, 30);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Punkty:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 20, 70, 30);

        labelPoints.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        labelPoints.setForeground(new java.awt.Color(255, 255, 51));
        labelPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labelPoints);
        labelPoints.setBounds(90, 20, 50, 30);

        buttonNext.setBackground(new java.awt.Color(153, 153, 153));
        buttonNext.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        buttonNext.setForeground(new java.awt.Color(0, 0, 0));
        buttonNext.setText("Następne Pytanie");
        buttonNext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttonNext.setEnabled(false);
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });
        jPanel1.add(buttonNext);
        buttonNext.setBounds(360, 340, 150, 40);

        rbE.setBackground(new java.awt.Color(0, 0, 102));
        buttonGroup1.add(rbE);
        rbE.setForeground(new java.awt.Color(0, 0, 102));
        rbE.setBorder(null);
        rbE.setContentAreaFilled(false);
        rbE.setFocusable(false);
        jPanel1.add(rbE);
        rbE.setBounds(30, 300, 30, 30);
        rbE.setVisible(false);

        labelQuestion.setEditable(false);
        labelQuestion.setBackground(new java.awt.Color(0, 0, 0));
        labelQuestion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelQuestion.setForeground(new java.awt.Color(255, 255, 255));
        labelQuestion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(labelQuestion);
        labelQuestion.setBounds(20, 80, 450, 90);

        buttonHelp1.setIcon(new javax.swing.ImageIcon("C:\\Users\\GRZEŚ\\Documents\\NetBeansProjects\\Quiz\\lifesaver-icon.png")); // NOI18N
        buttonHelp1.setToolTipText("Koło ratunkowe 50/50 - odrzuca losowo dwie niepoprawne odpowiedzi.");
        buttonHelp1.setBorder(null);
        buttonHelp1.setBorderPainted(false);
        buttonHelp1.setContentAreaFilled(false);
        buttonHelp1.setEnabled(false);
        buttonHelp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHelp1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonHelp1);
        buttonHelp1.setBounds(470, 80, 50, 40);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 150, 50);

        ButtonBackMenu.setBackground(new java.awt.Color(153, 153, 153));
        ButtonBackMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        ButtonBackMenu.setForeground(new java.awt.Color(0, 0, 0));
        ButtonBackMenu.setText("Powrót do Menu");
        ButtonBackMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonBackMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackMenuActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonBackMenu);
        ButtonBackMenu.setBounds(20, 334, 140, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed

        clickOnStartButton();

    }//GEN-LAST:event_buttonStartActionPerformed


    private void radioButtonAnswerAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonAnswerAActionPerformed
        choseAnswerA();

    }//GEN-LAST:event_radioButtonAnswerAActionPerformed


    private void radioButtonAnswerBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonAnswerBActionPerformed
        chooseAnswerB();
    }//GEN-LAST:event_radioButtonAnswerBActionPerformed


    private void radioButtonAnswerCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonAnswerCActionPerformed
        chooseAnswerC();

    }//GEN-LAST:event_radioButtonAnswerCActionPerformed


    private void RadioButtonAnswerDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonAnswerDActionPerformed
        chooseAnswerD();
    }//GEN-LAST:event_RadioButtonAnswerDActionPerformed


    private void buttonCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCheckActionPerformed
        clickOnButtonCheck();
    }

    private void clickOnButtonCheck() throws HeadlessException {
        buttonNext.setEnabled(true);

        if (radioButtonAnswerA.isSelected()) {
            if (labelAnswerA.getText().equals(Correct)) {
                labelAnswerA.setBackground(Color.GREEN);
                Points = Points + 1;
                labelPoints.setText(String.valueOf(Points));
            } else {
                labelAnswerA.setBackground(Color.RED);

                if (labelAnswerB.getText().equals(Correct)) {
                    labelAnswerB.setBackground(Color.GREEN);

                } else if (labelAnswerC.getText().equals(Correct)) {
                    labelAnswerC.setBackground(Color.GREEN);

                } else if (labelAnswerD.getText().equals(Correct)) {
                    labelAnswerD.setBackground(Color.GREEN);

                }

            }
        } else if (radioButtonAnswerB.isSelected()) {
            if (labelAnswerB.getText().equals(Correct)) {

                labelAnswerB.setBackground(Color.GREEN);
                Points = Points + 1;
                labelPoints.setText(String.valueOf(Points));

            } else {
                labelAnswerB.setBackground(Color.RED);

                if (labelAnswerA.getText().equals(Correct)) {
                    labelAnswerA.setBackground(Color.GREEN);

                } else if (labelAnswerC.getText().equals(Correct)) {
                    labelAnswerC.setBackground(Color.GREEN);

                } else if (labelAnswerD.getText().equals(Correct)) {
                    labelAnswerD.setBackground(Color.GREEN);

                }
            }
        } else if (radioButtonAnswerC.isSelected()) {
            if (labelAnswerC.getText().equals(Correct)) {
                labelAnswerC.setBackground(Color.GREEN);
                Points = Points + 1;
                labelPoints.setText(String.valueOf(Points));
            } else {
                labelAnswerC.setBackground(Color.RED);

            }
            if (labelAnswerA.getText().equals(Correct)) {
                labelAnswerA.setBackground(Color.GREEN);

            } else if (labelAnswerB.getText().equals(Correct)) {
                labelAnswerB.setBackground(Color.GREEN);

            } else if (labelAnswerD.getText().equals(Correct)) {
                labelAnswerD.setBackground(Color.GREEN);

            }
        } else if (RadioButtonAnswerD.isSelected()) {
            if (labelAnswerD.getText().equals(Correct)) {
                labelAnswerD.setBackground(Color.GREEN);
                Points = Points + 1;
                labelPoints.setText(String.valueOf(Points));
            } else {
                labelAnswerD.setBackground(Color.RED);

            }
            if (labelAnswerA.getText().equals(Correct)) {
                labelAnswerA.setBackground(Color.GREEN);

            } else if (labelAnswerB.getText().equals(Correct)) {
                labelAnswerB.setBackground(Color.GREEN);

            } else if (labelAnswerC.getText().equals(Correct)) {
                labelAnswerC.setBackground(Color.GREEN);

            }
        }

        if (QuestionCounter == 10) {
            JOptionPane.showMessageDialog(null, "Twój wynik wynosi " + Points + " punktów /10 ", "Koniec testu", JOptionPane.INFORMATION_MESSAGE);
            labelPoints.setText("");
            labelQuestionsCounter.setText("");
            buttonStart.setEnabled(true);
            buttonCheck.setEnabled(false);
            clearColor();
            setColorFontWhite();
            clearLabels();
            setDisabledAnswerFields();
            rbE.isSelected();
            QuestionCounter = 1;
            NextQuestion = 0;
            buttonNext.setEnabled(false);
            new MainMenu().setVisible(true);
            this.dispose();

    }//GEN-LAST:event_buttonCheckActionPerformed

        setDisabledAnswerFields();

        buttonCheck.setEnabled(false);

        if (buttonNext.isEnabled()) {
            buttonNext.setEnabled(true);
        } else {
            buttonNext.setEnabled(false);
        }
    }


    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        clickOnButtonNext();

    }//GEN-LAST:event_buttonNextActionPerformed


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            exitProgram();
        } catch (HeadlessException | SQLException ex) {
            Logger.getLogger(QuizGameGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void buttonHelp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHelp1ActionPerformed
        clickOnButtonHelp();
    }//GEN-LAST:event_buttonHelp1ActionPerformed


    private void ButtonBackMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackMenuActionPerformed
        clickOnButtonBack();
    }//GEN-LAST:event_ButtonBackMenuActionPerformed

    public static void main(String args[]) throws SQLException {
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
            java.util.logging.Logger.getLogger(QuizGameGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizGameGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizGameGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizGameGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new QuizGameGui().setVisible(false);
            new MainMenu().setVisible(true);

        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBackMenu;
    private javax.swing.JRadioButton RadioButtonAnswerD;
    private javax.swing.JButton buttonCheck;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonHelp1;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField labelAnswerA;
    private javax.swing.JTextField labelAnswerB;
    private javax.swing.JTextField labelAnswerC;
    private javax.swing.JTextField labelAnswerD;
    private javax.swing.JLabel labelPoints;
    private javax.swing.JTextField labelQuestion;
    private javax.swing.JLabel labelQuestionsCounter;
    private javax.swing.JRadioButton radioButtonAnswerA;
    private javax.swing.JRadioButton radioButtonAnswerB;
    private javax.swing.JRadioButton radioButtonAnswerC;
    private javax.swing.JRadioButton rbE;
    // End of variables declaration//GEN-END:variables
}
