/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.exe;

import br.com.SisBanco.beans.Conta;
import br.com.SisBanco.beans.ContaCorrente;
import br.com.SisBanco.dao.ContaDAO;
import br.com.SisBanco.view.JFPrincipal;
import java.text.ParseException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Vinicius
 */
public class JFLogin extends javax.swing.JFrame {

    /**
     * Creates new form JFLogin
     */
    public JFLogin() {
        initComponents();
    }
    
    protected void login(){
        try {
        Conta c = new ContaCorrente();  
        c.setNumeroAgencia(ftAgenciaLogin.getText());
        c.setNumeroConta(ftContaLogin.getText());           
        String senha = new String(pfSenhaLogin.getPassword()).trim();                
        c.setSenha(senha);
        
            new ContaDAO().logar(ftAgenciaLogin.getText(), ftContaLogin.getText(),String.valueOf(pfSenhaLogin.getPassword()));           
        } catch (Exception ex) {
            showMessageDialog(this, "Login não cadastrado!" + ex.getMessage(),"Erro",ERROR_MESSAGE);
        }                
    }
    
    protected void limparCampos(){
        ftAgenciaLogin.setText("");
        ftContaLogin.setText("");
        pfSenhaLogin.setText("");        
        ftAgenciaLogin.requestFocus();
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlLogoSisBanco = new javax.swing.JLabel();
        jlNomeSisBanco = new javax.swing.JLabel();
        jlAgenciaLogin = new javax.swing.JLabel();
        try {
            MaskFormatter fmtNumero = new MaskFormatter("####-#");
            fmtNumero.setPlaceholderCharacter('_');
            ftAgenciaLogin = new javax.swing.JFormattedTextField(fmtNumero);
            jlContaLogin = new javax.swing.JLabel();
            try{
                MaskFormatter fmtConta = new MaskFormatter("#####-##");
                fmtConta.setPlaceholderCharacter('_');
                ftContaLogin = new javax.swing.JFormattedTextField(fmtConta);
                jlSenhaLogin = new javax.swing.JLabel();
                pfSenhaLogin = new javax.swing.JPasswordField();
                btConfirmar = new javax.swing.JButton();
                btLimpar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Login SisBanco");
                setLocation(new java.awt.Point(500, 100));
                setResizable(false);

                jlLogoSisBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SisBanco/L_SisBanco.jpg"))); // NOI18N

                jlNomeSisBanco.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
                jlNomeSisBanco.setForeground(new java.awt.Color(102, 102, 255));
                jlNomeSisBanco.setText("SisBanco");
                jlNomeSisBanco.setToolTipText("");

                jlAgenciaLogin.setText(" Conta:");

            }catch(ParseException pe){}
            ftAgenciaLogin.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ftAgenciaLoginActionPerformed(evt);
                }
            });

            jlContaLogin.setText(" Senha:");

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "O erro é na conta para depósito", "Erro", 0);
        }
        ftContaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftContaLoginActionPerformed(evt);
            }
        });

        jlSenhaLogin.setText(" Agência:");

        pfSenhaLogin.setEchoChar('*');
        pfSenhaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfSenhaLoginActionPerformed(evt);
            }
        });

        btConfirmar.setBackground(new java.awt.Color(204, 204, 204));
        btConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btConfirmar.setForeground(new java.awt.Color(0, 204, 51));
        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SisBanco/L_Ok.jpg"))); // NOI18N
        btConfirmar.setMnemonic('C');
        btConfirmar.setText("Confirmar");
        btConfirmar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btConfirmarMouseExited(evt);
            }
        });
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
        btConfirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btConfirmarKeyReleased(evt);
            }
        });

        btLimpar.setBackground(new java.awt.Color(204, 204, 204));
        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btLimpar.setForeground(new java.awt.Color(255, 51, 51));
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SisBanco/L_Limpar.png"))); // NOI18N
        btLimpar.setMnemonic('L');
        btLimpar.setText("Limpar");
        btLimpar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btLimpar.setMaximumSize(new java.awt.Dimension(93, 33));
        btLimpar.setMinimumSize(new java.awt.Dimension(93, 33));
        btLimpar.setPreferredSize(new java.awt.Dimension(93, 33));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlAgenciaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ftContaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(ftAgenciaLogin)
                                .addComponent(jlContaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlSenhaLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pfSenhaLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jlLogoSisBanco))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jlNomeSisBanco)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlLogoSisBanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNomeSisBanco)
                .addGap(40, 40, 40)
                .addComponent(jlSenhaLogin)
                .addGap(0, 0, 0)
                .addComponent(ftAgenciaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlAgenciaLogin)
                .addGap(0, 0, 0)
                .addComponent(ftContaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlContaLogin)
                .addGap(0, 0, 0)
                .addComponent(pfSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ftAgenciaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftAgenciaLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftAgenciaLoginActionPerformed

    private void ftContaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftContaLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftContaLoginActionPerformed

    private void pfSenhaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfSenhaLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfSenhaLoginActionPerformed

    private void btConfirmarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btConfirmarMouseExited

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
       Conta c = new ContaCorrente();
        try{
            ContaDAO cd = new ContaDAO();
            boolean opcao = cd.logar(ftAgenciaLogin.getText(), ftContaLogin.getText(),String.valueOf(pfSenhaLogin.getPassword()));
            if(opcao == true && evt.getSource() == btConfirmar){
                login();  
                this.dispose();
                new JFPrincipal().setVisible(true);                
            }
            else{
                JOptionPane.showMessageDialog(this, "Login inválido!", "Erro", 0);               
            }
        }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Problema no acesso!" + ex.getMessage(), "Erro", 0);
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btConfirmarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btConfirmarKeyReleased
        Conta c = new ContaCorrente();
        try{
            ContaDAO cd = new ContaDAO();
            boolean opcao = cd.logar(ftAgenciaLogin.getText(), ftContaLogin.getText(),String.valueOf(pfSenhaLogin.getPassword()));
            if(opcao == true && evt.getKeyCode() == 10){
                login();  
                this.dispose();
                new JFPrincipal().setVisible(true);                
            }
            else{
                JOptionPane.showMessageDialog(this, "Login inválido!", "Erro", 0);
                return;
            }
        }catch(Exception ex){}         
        
    }//GEN-LAST:event_btConfirmarKeyReleased

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        if(evt.getSource() == btLimpar)
            limparCampos();
    }//GEN-LAST:event_btLimparActionPerformed

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
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new JFLogin().setVisible(true);
                    new JFPrincipal().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JFormattedTextField ftAgenciaLogin;
    private javax.swing.JFormattedTextField ftContaLogin;
    private javax.swing.JLabel jlAgenciaLogin;
    private javax.swing.JLabel jlContaLogin;
    private javax.swing.JLabel jlLogoSisBanco;
    private javax.swing.JLabel jlNomeSisBanco;
    private javax.swing.JLabel jlSenhaLogin;
    private javax.swing.JPasswordField pfSenhaLogin;
    // End of variables declaration//GEN-END:variables
}