/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.view;

import br.com.SisBanco.accessories.ApModeloGrade;
import br.com.SisBanco.beans.Agencia;
import br.com.SisBanco.beans.Cliente;
import br.com.SisBanco.beans.Conta;
import br.com.SisBanco.beans.ContaCorrente;
import br.com.SisBanco.beans.ContaPoupanca;
import br.com.SisBanco.dao.AgenciaDAO;
import br.com.SisBanco.dao.ClienteDAO;
import br.com.SisBanco.dao.ContaCorrenteDAO;
import br.com.SisBanco.dao.ContaDAO;
import br.com.SisBanco.dao.ContaPoupancaDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Vinicius
 */
public class IFConta extends JInternalFrame implements ChangeListener {

    public IFConta(){
        initComponents();
        atualizarGrade();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTipoConta = new javax.swing.ButtonGroup();
        tpAbas = new javax.swing.JTabbedPane();
        spDados = new javax.swing.JScrollPane();
        tbDados = new javax.swing.JTable();
        pnCadastro = new javax.swing.JPanel();
        jlTipoConta = new javax.swing.JLabel();
        rbCorrente = new javax.swing.JRadioButton();
        rbPoupanca = new javax.swing.JRadioButton();
        jlCpf = new javax.swing.JLabel();
        coCpf = new javax.swing.JComboBox<Cliente>();
        coNumeroAgencia = new javax.swing.JComboBox<Agencia>();
        jlNumeroAgencia = new javax.swing.JLabel();
        jlNumeroConta = new javax.swing.JLabel();
        try{
            MaskFormatter fmtConta = new MaskFormatter("#####-##");
            fmtConta.setPlaceholderCharacter('_');
            ftNumeroConta = new javax.swing.JFormattedTextField(fmtConta);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "O erro é na Conta", "Erro", 0);
        }
        jlSaldo = new javax.swing.JLabel();
        ftSaldo = new javax.swing.JFormattedTextField();
        jlVariacao = new javax.swing.JLabel();
        ftVariacao = new javax.swing.JFormattedTextField(new Double(0));
        jlChequeEspecial = new javax.swing.JLabel();
        ftChequeEspecial = new javax.swing.JFormattedTextField();
        btSalvar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jlSenha = new javax.swing.JLabel();
        pfSenha = new javax.swing.JPasswordField();
        jlConfirmacaoSenha = new javax.swing.JLabel();
        pfConfirmacaoSenha = new javax.swing.JPasswordField();

        setClosable(true);
        setForeground(new java.awt.Color(0, 0, 0));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Contas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        tpAbas.addChangeListener(this);

        tbDados.addMouseListener(new MouseHandler());
        tbDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbDados.setToolTipText("Clique para Selecionar");
        tbDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbDados.setFocusable(false);
        tbDados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spDados.setViewportView(tbDados);

        tpAbas.addTab("Seleção", spDados);

        jlTipoConta.setText("                   Tipo de Conta:");

        bgTipoConta.add(rbCorrente);
        rbCorrente.setSelected(true);
        rbCorrente.setText("Conta Corrente");
        rbCorrente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbCorrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCorrenteActionPerformed(evt);
            }
        });

        bgTipoConta.add(rbPoupanca);
        bgTipoConta.add(rbPoupanca);
        rbPoupanca.setText("Conta Poupança");
        rbPoupanca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbPoupanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPoupancaActionPerformed(evt);
            }
        });

        jlCpf.setText(" Número da Agência:");

        try{
            coCpf.setModel(new javax.swing.DefaultComboBoxModel<Cliente>(new ClienteDAO().carregarCombo()));
            coCpf.setSelectedIndex(-0);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "O erro é no CPF", "Erro", 0);
        }

        try{
            coNumeroAgencia.setModel(new javax.swing.DefaultComboBoxModel<Agencia>(new AgenciaDAO().carregarCombo()));
        }catch(Exception ex){
            showMessageDialog(this,ex.getMessage(),"Erro",ERROR_MESSAGE);
        }

        jlNumeroAgencia.setText(" Número da Conta:");

        jlNumeroConta.setText(" CPF:");

        jlSaldo.setText(" Saldo:");

        ftSaldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftSaldoActionPerformed(evt);
            }
        });

        jlVariacao.setText(" Variação:");

        ftVariacao.setEnabled(false);
        ftVariacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftVariacaoActionPerformed(evt);
            }
        });

        jlChequeEspecial.setText(" Cheque Especial:");

        ftChequeEspecial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftChequeEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftChequeEspecialActionPerformed(evt);
            }
        });

        btSalvar.setBackground(new java.awt.Color(51, 153, 255));
        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(255, 255, 0));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SisBanco/Salvar.png"))); // NOI18N
        btSalvar.setMnemonic('S');
        btSalvar.setText("  Salvar");
        btSalvar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        btSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btSalvarKeyReleased(evt);
            }
        });

        btAlterar.setBackground(new java.awt.Color(51, 153, 255));
        btAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btAlterar.setForeground(new java.awt.Color(255, 255, 0));
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SisBanco/Alterar.png"))); // NOI18N
        btAlterar.setMnemonic('A');
        btAlterar.setText("Alterar");
        btAlterar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setBackground(new java.awt.Color(51, 153, 255));
        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btExcluir.setForeground(new java.awt.Color(255, 51, 51));
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SisBanco/Excluir.png"))); // NOI18N
        btExcluir.setMnemonic('E');
        btExcluir.setText("Excluir");
        btExcluir.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jlSenha.setText(" Senha:");

        pfSenha.setEchoChar('*');
        pfSenha.setMinimumSize(new java.awt.Dimension(6, 8));
        pfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfSenhaActionPerformed(evt);
            }
        });

        jlConfirmacaoSenha.setText(" Confirmação da Senha:");

        pfSenha.setEchoChar('*');
        pfConfirmacaoSenha.setMinimumSize(new java.awt.Dimension(6, 8));
        pfConfirmacaoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfConfirmacaoSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 82, Short.MAX_VALUE))
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jlTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ftVariacao)
                            .addComponent(jlVariacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                .addComponent(rbCorrente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbPoupanca)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coNumeroAgencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftNumeroConta)
                                    .addComponent(jlNumeroAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlChequeEspecial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(jlNumeroConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coCpf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ftSaldo)
                            .addComponent(ftChequeEspecial)))
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pfSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pfConfirmacaoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlConfirmacaoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNumeroConta)
                    .addComponent(jlTipoConta))
                .addGap(0, 0, 0)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbCorrente)
                    .addComponent(rbPoupanca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCpf)
                    .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlSaldo)
                        .addComponent(jlNumeroAgencia)))
                .addGap(0, 0, 0)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coNumeroAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlVariacao)
                    .addComponent(jlChequeEspecial))
                .addGap(0, 0, 0)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftVariacao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftChequeEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlConfirmacaoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfConfirmacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        tpAbas.addTab("Cadastro", pnCadastro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpAbas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpAbas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void atualizarGrade() {
        try {
            ResultSet rs = new ContaDAO().carregarGrade();
            tbDados.setModel(new ApModeloGrade(rs, new String[]{"Número da Agência", "Número da Conta", "CPF", "Tipo da Conta", "Saldo"}));
            tbDados.getColumnModel().getColumn(0).setMaxWidth(180);
            tbDados.getColumnModel().getColumn(1).setMaxWidth(150);
            tbDados.getColumnModel().getColumn(2).setMaxWidth(150);
            tbDados.getColumnModel().getColumn(3).setMaxWidth(100);
            tbDados.getColumnModel().getColumn(4).setMaxWidth(150);            
        } catch (Exception e) {
            showMessageDialog(this, e.getMessage(), "Erro", ERROR_MESSAGE);
        }
    }

    class MouseHandler extends MouseAdapter {

        public void mouseReleased(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            JTable tb = (JTable) e.getSource();
            int lin = tb.getSelectionModel().getMinSelectionIndex();
            String tipoConta = tb.getModel().getValueAt(lin, 0).toString();
            String codigo = tb.getModel().getValueAt(lin, 2).toString();
            
            
            try {
                carregarRegistro(tipoConta, codigo);
                tpAbas.setSelectedComponent(pnCadastro);
                ftNumeroConta.requestFocus();
            } catch (Exception ex) {
                showMessageDialog(IFConta.this, ex.getMessage(), "Erro", ERROR_MESSAGE);
            }
        }
    }

    protected void incluir(){
        if(rbCorrente.isSelected()){
            ContaCorrente cc = new ContaCorrente();  
            cc.setTipoConta("CC");    
            Agencia agencia = (Agencia)coNumeroAgencia.getSelectedItem();
            cc.setNumeroAgencia(agencia.getNumero());
            cc.setNumeroConta(ftNumeroConta.getText());
            Cliente cliente = (Cliente)coCpf.getSelectedItem();
            cc.setCpf(cliente.getCpf());            
            cc.setSaldo(ftSaldo.getText());
            cc.setChequeEspecial(ftChequeEspecial.getText()); 
            String senha = new String(pfSenha.getPassword()).trim();
            String confirmaSenha = new String(pfConfirmacaoSenha.getPassword()).trim();
            if(senha.equalsIgnoreCase(confirmaSenha))
                cc.setSenha(senha);
            else{
                showMessageDialog(this, "Senhas diferentes! Digite novamente.", "Atenção!", 2);
                pfSenha.setFocusable(true);
                return;            
            }
        
            try {
                new ContaCorrenteDAO().cadastrarContaCorrente(cc);            
                atualizarGrade();
                tpAbas.setSelectedIndex(0);
            } catch (Exception ex) {
                showMessageDialog(this, "Erro ao incluir conta! " + ex.getMessage(), "Erro", ERROR_MESSAGE);
            }
        }    
        else if(rbPoupanca.isSelected()){
            ContaPoupanca cp = new ContaPoupanca();
            cp.setTipoConta("CP");
            Agencia agencia = (Agencia)coNumeroAgencia.getSelectedItem();
            cp.setNumeroAgencia(agencia.getNumero());
            cp.setNumeroConta(ftNumeroConta.getText());
            Cliente cliente = (Cliente)coCpf.getSelectedItem();
            cp.setCpf(cliente.getCpf());            
            cp.setSaldo(ftSaldo.getText());        
            cp.setVariacao(ftVariacao.getText());
            String senha = new String(pfSenha.getPassword()).trim();
            String confirmaSenha = new String(pfConfirmacaoSenha.getPassword()).trim();
            if(senha.equalsIgnoreCase(confirmaSenha))
                cp.setSenha(senha);
            else{
                showMessageDialog(this, "Senhas diferentes! Digite novamente.", "Atenção!", 2);
                pfSenha.setFocusable(true);
                return;            
            }

            try {
                new ContaPoupancaDAO().cadastrarContaPoupanca(cp);            
                atualizarGrade();
                tpAbas.setSelectedIndex(0);
            } catch (Exception ex) {
                showMessageDialog(this, "Erro ao incluir conta! " + ex.getMessage(), "Erro", ERROR_MESSAGE);
            }
    }    
}

    protected void alterar(){
        if(rbCorrente.isSelected()){
            ContaCorrente cc = new ContaCorrente();  
            cc.setTipoConta("CC");
            Agencia agencia = (Agencia)coNumeroAgencia.getSelectedItem();
            cc.setNumeroAgencia(agencia.getNumero());
            cc.setNumeroConta(ftNumeroConta.getText());
            Cliente cliente = (Cliente)coCpf.getSelectedItem();
            cc.setCpf(cliente.getCpf());            
            cc.setSaldo(ftSaldo.getText());
            cc.setChequeEspecial(ftChequeEspecial.getText()); 
            String senha = new String(pfSenha.getPassword()).trim();
            String confirmaSenha = new String(pfConfirmacaoSenha.getPassword()).trim();
            if(senha.equalsIgnoreCase(confirmaSenha))
                cc.setSenha(senha);
            else{
                showMessageDialog(this, "Senhas diferentes! Digite novamente.", "Atenção!", 2);
                pfSenha.setFocusable(true);
                return;            
            }
        
            try {
                new ContaCorrenteDAO().alterarContaCorrente(cc);            
                atualizarGrade();
                tpAbas.setSelectedIndex(0);
            } catch (Exception ex) {
                showMessageDialog(this, "Erro ao alterar conta! " + ex.getMessage(), "Erro", ERROR_MESSAGE);
            }
    }    
        else if(rbPoupanca.isSelected()){
            ContaPoupanca cp = new ContaPoupanca();
            cp.setTipoConta("CP");
            Agencia agencia = (Agencia)coNumeroAgencia.getSelectedItem();
            cp.setNumeroAgencia(agencia.getNumero());
            cp.setNumeroConta(ftNumeroConta.getText());
            Cliente cliente = (Cliente)coCpf.getSelectedItem();
            cp.setCpf(cliente.getCpf());            
            cp.setSaldo(ftSaldo.getText());        
            cp.setVariacao(ftVariacao.getText());
            String senha = new String(pfSenha.getPassword()).trim();
            String confirmaSenha = new String(pfConfirmacaoSenha.getPassword()).trim();
            if(senha.equalsIgnoreCase(confirmaSenha))
                cp.setSenha(senha);
            else{
                showMessageDialog(this, "Senhas diferentes! Digite novamente.", "Atenção!", 2);
                pfSenha.setFocusable(true);
                return;            
            }

            try {
                new ContaPoupancaDAO().alterarContaPoupanca(cp);            
                atualizarGrade();
                tpAbas.setSelectedIndex(0);
            } catch (Exception ex) {
                showMessageDialog(this, ex.getMessage(),"Erro",ERROR_MESSAGE);
            }
    }    
}

    protected void excluir() {
        try {
            new ContaDAO().excluirConta(ftNumeroConta.getText());
            ApModeloGrade amg = (ApModeloGrade) tbDados.getModel();
            amg.removeRow(tbDados.getSelectedRow());
            tpAbas.setSelectedIndex(0);
        } catch (Exception ex) {
            showMessageDialog(this, ex.getMessage(), "Erro", ERROR_MESSAGE);
        }
    }

    protected void carregarRegistro(String codigo, String tipoConta) throws Exception {
        if(tipoConta.equalsIgnoreCase("CC")){
            ContaCorrente cc = new ContaCorrenteDAO().consultarContaCorrente(codigo, tipoConta);
            Conta c = new ContaCorrente();               
            String str = cc.getTipoConta();           
            rbCorrente.setSelected(true);
            ftChequeEspecial.setEnabled(true);
            ftVariacao.setEnabled(false); 
            coNumeroAgencia.setSelectedItem(new ContaDAO().consultarConta(c.getNumeroAgencia()));
            coCpf.setSelectedItem(new ContaDAO().consultarConta(c.getCpf()));
            ftNumeroConta.setText(String.valueOf(cc.getNumeroConta()));
            ftSaldo.setText(cc.getSaldoFmt());
            ftChequeEspecial.setText(String.valueOf(cc.getChequeEspecialFmt()));
            pfSenha.setText("************");   
        }
        else{
            ContaPoupanca cp = new ContaPoupancaDAO().consultarContaPoupanca(codigo, tipoConta);
            Conta c = new ContaCorrente();
            String str = cp.getTipoConta();          
            rbPoupanca.setSelected(true);
            ftChequeEspecial.setEnabled(false);
            ftVariacao.setEnabled(true);
            coNumeroAgencia.setSelectedItem(new ContaDAO().consultarConta(c.getNumeroAgencia()));
            coCpf.setSelectedItem(new ContaDAO().consultarConta(c.getCpf()));
            ftNumeroConta.setText(String.valueOf(cp.getNumeroConta()));
            ftSaldo.setText(cp.getSaldoFmt());
            ftVariacao.setText(String.valueOf(cp.getVariacao())); 
            pfSenha.setText("************");   
        }    
    }

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == btSalvar) {
            incluir();
        }
    }//GEN-LAST:event_btSalvarActionPerformed


    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == btAlterar) {
            alterar();
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == btExcluir) {
            int opcao = showOptionDialog(this, "Tem certeza que deseja excluir essa conta?", "Confirme", 0,
                    QUESTION_MESSAGE, null, new String[]{"Sim", "Não"}, "Não");
            switch (opcao) {
                case -1:
                    return;
                case 0:
                    excluir();
                    break;
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    public void stateChanged(javax.swing.event.ChangeEvent evt) {
        // TODO add your handling code here:
        if (tpAbas.getSelectedIndex() != 0) {
            return;
        }
        for (int i = 0; i < pnCadastro.getComponentCount(); i++) {
            if (pnCadastro.getComponent(i) instanceof JComboBox) {
                ((JComboBox) pnCadastro.getComponent(i)).setSelectedIndex(0);            
            }
            if (pnCadastro.getComponent(i) instanceof JTextComponent) {
                ((JTextComponent) pnCadastro.getComponent(i)).setText("");
            }
        }
    }

    private void btSalvarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btSalvarKeyReleased
        // TODO add your handling code here:        
        if (evt.getKeyCode() == 10) {
            incluir();
        }
    }//GEN-LAST:event_btSalvarKeyReleased
    private String tipoConta = "";
    private void rbCorrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCorrenteActionPerformed
        if(rbCorrente.isSelected())            
            tipoConta = "CC";
            ftVariacao.setEnabled(false);
            ftChequeEspecial.setEnabled(true);
    }//GEN-LAST:event_rbCorrenteActionPerformed

    private void rbPoupancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPoupancaActionPerformed
        if(rbPoupanca.isSelected())            
            tipoConta = "CP";
            ftChequeEspecial.setEnabled(false);
            ftVariacao.setEnabled(true);
    }//GEN-LAST:event_rbPoupancaActionPerformed

    private void ftSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftSaldoActionPerformed

    private void ftVariacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftVariacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftVariacaoActionPerformed

    private void ftChequeEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftChequeEspecialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftChequeEspecialActionPerformed

    private void pfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfSenhaActionPerformed

    private void pfConfirmacaoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfConfirmacaoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfConfirmacaoSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTipoConta;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<Cliente> coCpf;
    private javax.swing.JComboBox<Agencia> coNumeroAgencia;
    private javax.swing.JFormattedTextField ftChequeEspecial;
    private javax.swing.JFormattedTextField ftNumeroConta;
    private javax.swing.JFormattedTextField ftSaldo;
    private javax.swing.JFormattedTextField ftVariacao;
    private javax.swing.JLabel jlChequeEspecial;
    private javax.swing.JLabel jlConfirmacaoSenha;
    private javax.swing.JLabel jlCpf;
    private javax.swing.JLabel jlNumeroAgencia;
    private javax.swing.JLabel jlNumeroConta;
    private javax.swing.JLabel jlSaldo;
    private javax.swing.JLabel jlSenha;
    private javax.swing.JLabel jlTipoConta;
    private javax.swing.JLabel jlVariacao;
    private javax.swing.JPasswordField pfConfirmacaoSenha;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JRadioButton rbCorrente;
    private javax.swing.JRadioButton rbPoupanca;
    private javax.swing.JScrollPane spDados;
    private javax.swing.JTable tbDados;
    private javax.swing.JTabbedPane tpAbas;
    // End of variables declaration//GEN-END:variables
}

