
package multiplicationgame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import java.util.Random;

// Created by: f4briici0.
        
public class GUI3 extends javax.swing.JFrame {
    
    public static Random rand = new Random();
    
    int init;
    int level;
    int result, n1, n2;
    boolean alive = true;
    ArrayList<Integer> numbers = new ArrayList<>();
    
    int sec;
    int secs;
    int mil = 999;
    int acertou = 0;
    int errou = 0;
    int nvMin, nvMax;
    
    void sleep(int time){
        try{Thread.currentThread().sleep(time);} catch (Exception e) {System.out.println(e);}
    }
    
    public void run(int level){
        if (level == 1){nvMin = 2; nvMax = 5;}
        if (level == 2){nvMin = 6; nvMax = 9;}
        if (level == 3){nvMin = 2; nvMax = 9;}
        
        n1 = rand.nextInt((nvMax - nvMin) + 1) + nvMin;
        
        
        n2 = rand.nextInt((9 - 2) + 1) + 2;
        
        if (numbers.size() == 8){numbers.clear();}
        
        while (true) {if(numbers.contains(n2) == true){n2 = rand.nextInt((9 - 2) + 1) + 2;} else {break;}}
        
        numbers.add(n2);
        result = n1 * n2;
        
        v1.setText(Integer.toString(n1));
        v2.setText(Integer.toString(n2));
        
    }
    
    void check(){
        new Thread(){
            public void run(){
                while (true){
                    try{Thread.currentThread().sleep(100);} catch (Exception e) {System.out.println(e);};
                    
                    if (alive == false){
                        user.setEnabled(false);
                        send.setEnabled(false);
                        
                        if (acertou < 10){
                            txtacertou.setText("    0" + Integer.toString(acertou));
                        } else{
                            txtacertou.setText("     " + Integer.toString(acertou));
                        }
                        
                        if (errou < 10){
                            txterrou.setText("    0" + Integer.toString(errou));
                        } else{
                            txterrou.setText("    " + Integer.toString(errou));
                        }
                        
                        dialogBox.setVisible(true);
                        
                        break;
                    }
                }
            }
        }.start();
    }

    
    void timer(int level){
        switch (level){
            case 1:
                sec = 10;
                secs = 10;
                break;
            case 2:
                sec = 5;
                secs = 5;
                break;
            case 3:
                sec = 3;
                secs = 3;
                break;
        }
        
        new Thread(){
            String secF; String milF;
            public void run(){
                for (int i = 0; i < secs + 1; i++){
                    for (int c = 0; c < 999; c++){
                        mil--;

                        if (mil == 0){
                            if (sec > 0){
                                sec--;
                            }
    
                            if (sec != -1){
                              mil = 999;  
                            }  
                        }
                        
                        if (mil < 100){milF = "0" + Integer.toString(mil);} else {milF = Integer.toString(mil);}
                        if (sec < 10){secF = "0" + Integer.toString(sec);} else {secF = Integer.toString(sec);}
                        cronometro.setText(String.format("%s:%s", secF, milF));
                        
                        try{Thread.currentThread().sleep(2);} catch (Exception e) {System.out.println(e);}
                    }
                }
                
                cronometro.setText("00:000");
                alive = false;
            }
        }.start();
    }
    
    public GUI3(){
        initComponents();
    }
    
    public GUI3(int a1) {
      initComponents();
      level = a1;
      levelLabel.setText("NÍVEL: " + Integer.toString(level));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogBox = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        pontuacao = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        txtacertou = new javax.swing.JTextField();
        txterrou = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        levelLabel = new javax.swing.JLabel();
        v1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        v2 = new javax.swing.JLabel();
        cronometro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        log = new javax.swing.JTextPane();

        dialogBox.setLocation(new java.awt.Point(0, 0));
        dialogBox.setResizable(false);
        dialogBox.setSize(new java.awt.Dimension(210, 210));
        dialogBox.setLocationRelativeTo(null);

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));
        jPanel2.setForeground(new java.awt.Color(204, 255, 51));

        pontuacao.setFont(new java.awt.Font("Gotham Black", 0, 24)); // NOI18N
        pontuacao.setForeground(new java.awt.Color(255, 255, 255));
        pontuacao.setText("PONTUAÇÃO");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        jTextField1.setText("      ERROU");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        jTextField2.setText("    ACERTOU");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        txtacertou.setEditable(false);
        txtacertou.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        txtacertou.setForeground(new java.awt.Color(51, 102, 0));
        txtacertou.setText("     12");
        txtacertou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtacertouActionPerformed(evt);
            }
        });

        txterrou.setEditable(false);
        txterrou.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        txterrou.setForeground(new java.awt.Color(255, 51, 51));
        txterrou.setText("    04");
        txterrou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txterrouActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txterrou, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pontuacao)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtacertou, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(pontuacao)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtacertou, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txterrou, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogBoxLayout = new javax.swing.GroupLayout(dialogBox.getContentPane());
        dialogBox.getContentPane().setLayout(dialogBoxLayout);
        dialogBoxLayout.setHorizontalGroup(
            dialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogBoxLayout.setVerticalGroup(
            dialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));

        levelLabel.setFont(new java.awt.Font("Gotham Black", 0, 24)); // NOI18N
        levelLabel.setForeground(new java.awt.Color(255, 255, 255));
        levelLabel.setText("NÍVEL: ");

        v1.setFont(new java.awt.Font("Gotham", 0, 36)); // NOI18N
        v1.setForeground(new java.awt.Color(255, 255, 0));
        v1.setText("0");

        jLabel3.setBackground(new java.awt.Color(255, 204, 102));
        jLabel3.setFont(new java.awt.Font("Gotham", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("x");

        v2.setFont(new java.awt.Font("Gotham", 0, 36)); // NOI18N
        v2.setForeground(new java.awt.Color(255, 255, 0));
        v2.setText("0");

        cronometro.setBackground(new java.awt.Color(51, 51, 51));
        cronometro.setFont(new java.awt.Font("Gotham", 0, 24)); // NOI18N
        cronometro.setForeground(new java.awt.Color(255, 255, 255));
        cronometro.setText("00:000");
        cronometro.setBorderPainted(false);
        cronometro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cronometro.setDefaultCapable(false);
        cronometro.setEnabled(false);
        cronometro.setFocusPainted(false);
        cronometro.setFocusable(false);
        cronometro.setRequestFocusEnabled(false);
        cronometro.setVerifyInputWhenFocusTarget(false);

        jLabel5.setBackground(new java.awt.Color(255, 204, 102));
        jLabel5.setFont(new java.awt.Font("Gotham", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("=");

        user.setFont(new java.awt.Font("Gotham", 0, 18)); // NOI18N
        user.setForeground(new java.awt.Color(0, 0, 0));
        user.setBorder(BorderFactory.createEmptyBorder(5, 13, 4, 5));
        user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userKeyTyped(evt);
            }
        });

        send.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        send.setForeground(new java.awt.Color(0, 0, 0));
        send.setText("COMEÇAR");
        send.setFocusable(false);
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        log.setEditable(false);
        log.setBackground(new java.awt.Color(51, 51, 51));
        log.setBorder(BorderFactory.createEmptyBorder(8, 13, 14, 15));
        log.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        log.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(send, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(v1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(v2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(levelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cronometro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(log, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(levelLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cronometro)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(v1)
                                .addComponent(jLabel3)
                                .addComponent(v2)
                                .addComponent(jLabel5))
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userKeyTyped
        if (user.getText().length() >= 3){evt.consume();} 
    }//GEN-LAST:event_userKeyTyped

    private void userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (init == 0){
                
                load1();
            } else{
                load2();
            }
        }
    }//GEN-LAST:event_userKeyPressed

    void load1(){
        send.setText("ENVIAR");
        cronometro.setEnabled(true);
        user.setEnabled(true);
        user.requestFocus();  
        init = 1;
        run(level);
        
        timer(level);
        check();  
    }
    
    void load2(){
        if (user.getText().strip() != ""){
            if (Integer.parseInt(user.getText().strip()) == result){
                log.setText(log.getText() + "\n" + String.format("ACERTOU - %s", user.getText()));
                acertou++;
            } else {
                log.setText(log.getText() + "\n" + String.format("ERROU - %s", user.getText()));
                errou++;
                }
            }

        run(level);
        user.setText("");
    }
    
    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        if (init == 0){
            load1();
        } else{
            load2();
        }
    }//GEN-LAST:event_sendActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void txtacertouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtacertouActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtacertouActionPerformed

    private void txterrouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txterrouActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txterrouActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cronometro;
    private javax.swing.JFrame dialogBox;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public javax.swing.JLabel levelLabel;
    private javax.swing.JTextPane log;
    private javax.swing.JLabel pontuacao;
    private javax.swing.JButton send;
    private javax.swing.JTextField txtacertou;
    private javax.swing.JTextField txterrou;
    private javax.swing.JTextField user;
    private javax.swing.JLabel v1;
    private javax.swing.JLabel v2;
    // End of variables declaration//GEN-END:variables

}
