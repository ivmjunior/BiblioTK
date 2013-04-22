/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotk.gui;

import br.com.bibliotk.models.Database;
import br.com.bibliotk.models.Helper;
import br.com.bibliotk.models.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivanilson
 */
public class GerenciarUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form GerenciarUsuarios
     */
    public GerenciarUsuarios() {
        initComponents();
        this.insertTestData();
        this.updateTable();
    }
    
    private void insertTestData() {
        if(Database.getUsuarios().isEmpty()) {
            for (int i = 0; i < 5; i++) {
                try{
                    Usuario u = new Usuario(
                        "Rafael Garcia",
                        "192391239",
                        Helper.toDate("17/10/1990"),
                        "Masculino",
                        "rafbgarcia@gmail.com",
                        "123132",
                        "1231237",
                        "RUA",
                        123,
                        "TIROL",
                        "PERTO",
                        "RN",
                        "Natal"
                    );
                    Database.addUsuario(u);
                }catch(Exception e) {}
                
            }
        }
    }
    
    private void updateTable() {
        DefaultTableModel tTabela;
        tTabela = (DefaultTableModel) tblUsuarios.getModel();
        tTabela.setNumRows(0);
 
        int length = Database.getUsuarios().size();
 
        for (int linha = 0; linha < length; linha++)
        {
            Usuario u = Database.getUsuarios().get(linha);
 
            tTabela.addRow(new Object[]{1});
 
            tblUsuarios.setValueAt(u.getId(), linha, 0);
            tblUsuarios.setValueAt(u.getNome(), linha, 1);
            tblUsuarios.setValueAt(u.getCpf(), linha, 2);
            tblUsuarios.setValueAt(Helper.formatDate(u.getDataNascimento()), linha, 3);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Gerenciar Usuários - BiblioTK");

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Data de Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(jButton1))
                .addContainerGap())
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
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int row = tblUsuarios.getSelectedRow();
        if(row >= 0) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir este usuário?");
            if(resposta == JOptionPane.YES_OPTION) {
                Database.excluirUsuario(row);
                this.updateTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para excluir!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
