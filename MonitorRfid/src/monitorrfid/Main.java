/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorrfid;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class Main extends javax.swing.JFrame {

    public void setTxtConsole(String txt) {
        //this.txtConsole.append(txt);
        this.txtConsole.setText(txt);
    }

    public void regra(String port) throws ParseException {
        SerialTest serial = new SerialTest();
        serial.initialize(port);
    }

    public void botaoIniciarServico() throws ParseException {

        String port = cmbPortas.getSelectedItem().toString();
        if (port == null) {
            JOptionPane.showMessageDialog(null, "Nenhuma porta conectada!");
        } else {
            if (!port.equals("Selecione a porta ttyUsbx desejada")) {
                regra(port);
            } else {
                JOptionPane.showMessageDialog(null, "Escolha um item válido");
            }
        }
    }

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAtivarComunicacao = new javax.swing.JButton();
        cmbPortas = new javax.swing.JComboBox<>();
        btnFecharComunicacao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 14)); // NOI18N
        jLabel2.setText("Painel Principal");

        btnAtivarComunicacao.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 13)); // NOI18N
        btnAtivarComunicacao.setText("Ativar Comunicação");
        btnAtivarComunicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtivarComunicacaoActionPerformed(evt);
            }
        });

        cmbPortas.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 13)); // NOI18N
        cmbPortas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a porta ttyUsbx desejada", "/dev/ttyUSB0", "/dev/ttyUSB1" }));

        btnFecharComunicacao.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 13)); // NOI18N
        btnFecharComunicacao.setText("Fechar Comunicação");
        btnFecharComunicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharComunicacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPortas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 261, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAtivarComunicacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFecharComunicacao)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtivarComunicacao)
                    .addComponent(btnFecharComunicacao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtConsole.setEditable(false);
        txtConsole.setBackground(new java.awt.Color(92, 255, 0));
        txtConsole.setColumns(20);
        txtConsole.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 14)); // NOI18N
        txtConsole.setRows(5);
        jScrollPane1.setViewportView(txtConsole);

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 14)); // NOI18N
        jLabel3.setText("Display");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtivarComunicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtivarComunicacaoActionPerformed
        try {
            botaoIniciarServico();
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAtivarComunicacaoActionPerformed

    private void btnFecharComunicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharComunicacaoActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnFecharComunicacaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtivarComunicacao;
    private javax.swing.JButton btnFecharComunicacao;
    private javax.swing.JComboBox<String> cmbPortas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtConsole;
    // End of variables declaration//GEN-END:variables
}
