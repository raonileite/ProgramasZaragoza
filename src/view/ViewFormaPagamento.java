/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerFormaPagamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelFormaPagamento;

/**
 *
 * @author ti.raoni
 */
public class ViewFormaPagamento extends javax.swing.JInternalFrame {
    ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
    ControllerFormaPagamento controllerFormaPagamento = new ControllerFormaPagamento();
    ArrayList<ModelFormaPagamento> listaModelFormaPagamento = new ArrayList<>();
    String salvarAlterar = "salvar";
    /**
     * Creates new form ViewFormaPagamento
     */
    public ViewFormaPagamento() {
        initComponents();
        carregarFormaPagamento();
        habilitarDesabilitarCampos(true);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfForma = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtForma = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Formas de Pagamento");

        jLabel1.setText("Código");

        jLabel2.setText("Forma de Pagamento");

        jtfCodigo.setEditable(false);
        jtfCodigo.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/salvar-32.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtForma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Forma de Pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtForma);
        if (jtForma.getColumnModel().getColumnCount() > 0) {
            jtForma.getColumnModel().getColumn(0).setMinWidth(50);
            jtForma.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtForma.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/limpar-32.png"))); // NOI18N
        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/excluir-32.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/alterar-32.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfForma))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jbExcluir)
                    .addComponent(jbAlterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (salvarAlterar.equals("salvar")){
            this.salvarFormaPagamento();
        }else if (salvarAlterar.equals("alterar")){
            this.alterarFormaPagamento();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       limparFormulario();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = jtForma.getSelectedRow();
        int codigoUsuario = (int) jtForma.getValueAt(linha, 0);

        try {
            if(controllerFormaPagamento.excluirFormaPagamentoController(codigoUsuario)){
                JOptionPane.showMessageDialog(this, "Fornecedor excluído com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                carregarFormaPagamento();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao excluir Fornecedor","Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewUser.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao excluir Fornecedor","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        salvarAlterar = "alterar";
        int linha = jtForma.getSelectedRow();

        try{
            int codigoFornecedor = (int) jtForma.getValueAt(linha, 0);
            //setar dados do banco
            modelFormaPagamento = controllerFormaPagamento.retornarFormaPagamentoController(codigoFornecedor);
            //setar na interface
            this.jtfCodigo.setText(String.valueOf(modelFormaPagamento.getPagId()));
            this.jtfForma.setText(modelFormaPagamento.getPagForma());

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro ao encontrar Fornecedor","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void limparFormulario(){
        jtfCodigo.setText("");
        jtfForma.setText("");
        }
    
    private void habilitarDesabilitarCampos (boolean condicao){
        jtfForma.setEnabled(condicao);
    }
    
    private void carregarFormaPagamento(){
        listaModelFormaPagamento = controllerFormaPagamento.retornarListaFormaPagamentoController();
        DefaultTableModel modelo = (DefaultTableModel) jtForma.getModel();
        modelo.setNumRows(0);
        //inserindo
        int cont = listaModelFormaPagamento.size();
        for(int i=0; i < cont; i++){
            modelo.addRow(new Object[]{
                listaModelFormaPagamento.get(i).getPagId(),
                listaModelFormaPagamento.get(i).getPagForma()
            });
        }
        
    }
    
    private void salvarFormaPagamento (){
       modelFormaPagamento = new ModelFormaPagamento();
       modelFormaPagamento.setPagForma(jtfForma.getText());
       if (controllerFormaPagamento.salvarFormaPagamentoController(modelFormaPagamento)){
       //cadastrou usuario
       limparFormulario();
       JOptionPane.showMessageDialog(this, "Forma de Pagamento cadastrada com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
       carregarFormaPagamento();     
       }else{
       //nao cadastrou    
       JOptionPane.showMessageDialog(this, "Erro ao cadastrar Forma de Pagamento","Erro", JOptionPane.ERROR_MESSAGE);
       
       }
    }
    
    private void alterarFormaPagamento (){
        
       modelFormaPagamento = new ModelFormaPagamento();
       modelFormaPagamento.setPagId(Integer.valueOf(jtfCodigo.getText()));
       modelFormaPagamento.setPagForma(jtfForma.getText());
       if (controllerFormaPagamento.alterarFormaPagamentoController(modelFormaPagamento)){
       //cadastrou usuario
       limparFormulario();
       JOptionPane.showMessageDialog(this, "Forma de Pagamento alterada com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
       carregarFormaPagamento();     
       }else{
       //nao cadastrou    
       JOptionPane.showMessageDialog(this, "Erro ao alterar Forma de Pagamento","Erro", JOptionPane.ERROR_MESSAGE);
       
       }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JTable jtForma;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfForma;
    // End of variables declaration//GEN-END:variables
}
