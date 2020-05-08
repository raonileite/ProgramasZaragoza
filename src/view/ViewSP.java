/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.DAOFormaPagamento;
import DAO.DAOFornecedor;
import DAO.DAOLoja;
import DAO.DAOUsuario;
import controller.ControllerFormaPagamento;
import controller.ControllerFornecedor;
import controller.ControllerLoja;
import controller.ControllerRelatorioLoja;
import controller.ControllerSolicitacaoPagamento;
import controller.Controllersploj;
import java.awt.List;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelFormaPagamento;
import model.ModelFornecedor;
import model.ModelLoja;
import model.ModelSolicitacaoPagamento;
import model.Modelsploj;
import net.sf.jasperreports.engine.JRException;
import util.ConexaoSQLite;
import util.ZaraDatas;

/**
 *
 * @author ti.raoni
 */
public class ViewSP extends javax.swing.JInternalFrame {
    ConexaoSQLite conectar = new ConexaoSQLite();
    
    ControllerLoja controllerLoja = new ControllerLoja();
    ModelLoja modelLoja = new ModelLoja();
    ArrayList<ModelLoja> listaModelLoja = new ArrayList<>();
    
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    ModelFornecedor modelFornecedor = new ModelFornecedor();
    ArrayList<ModelFornecedor> listaModelFornecedor = new ArrayList<>();
    
    ControllerFormaPagamento controllerFormaPagamento = new ControllerFormaPagamento();
    ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
    ArrayList<ModelFormaPagamento> listaModelFormaPagamento = new ArrayList<>();
    
    ControllerSolicitacaoPagamento controllerSolicitacaoPagamento = new ControllerSolicitacaoPagamento();
    ModelSolicitacaoPagamento modelSolicitacaoPagamento = new ModelSolicitacaoPagamento();
    ArrayList<ModelSolicitacaoPagamento> listaModelSolicitacaoPagamento = new ArrayList<>();
    ZaraDatas zaraDatas = new ZaraDatas();
    
    Controllersploj controllerSpLoj = new Controllersploj();
    Modelsploj modelSpLoj = new Modelsploj();
    ArrayList<Modelsploj> listaModelsploj = new ArrayList<>();
    
    /**
     * Creates new form ViewSP
     */
    public ViewSP() throws SQLException {
        initComponents();
        preencherFornecedor();
        preencherForma();
        preencherFormaPagamento();
        preencherLoja();
        somarLojasSelecionadas();
        preencherCodigoLoja();
        preencherCodigoFornecedor();
        carregarPesquisa();
        carregarTabelaSP();
        
        
        /*int linha = jtPesquisarSP.getSelectedRow();

        try{
            int codigoSP = (int) jtPesquisarSP.getValueAt(linha, 0);
            //setar dados do banco
            modelSolicitacaoPagamento = controllerSolicitacaoPagamento.getSolicitacaoPagamentoController(codigoSP);
            //setar na interface
            this.jtfPkSp.setText(String.valueOf(modelSolicitacaoPagamento.getIdSP()));
            

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro ao encontrar SP","Erro", JOptionPane.ERROR_MESSAGE);
        }
        /*chama o preencher tabela loja
        carregarLoja();
        */
        /*chama o preenchedor do jList
        preencherLoja();
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jbAddLoja = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtfCodigoSP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfNota = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jcbFornecedor = new componentes.UJComboBox();
        jLabel1 = new javax.swing.JLabel();
        jcbPagamento = new componentes.UJComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLoja = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtaObservacoes = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaHistorico = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jftfValor = new javax.swing.JFormattedTextField();
        jbSalvar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtCadastroSP = new javax.swing.JTable();
        jdcData = new com.toedter.calendar.JDateChooser();
        jtfCodigoFornecedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbLoja = new componentes.UJComboBox();
        jLabel8 = new javax.swing.JLabel();
        jtfLoja = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jlTotalLojas = new javax.swing.JLabel();
        jbLimparTabelaLoja = new javax.swing.JButton();
        jbRemoveLoja = new javax.swing.JButton();
        jtfPagamento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtPesquisarSP = new javax.swing.JTable();
        jtfPkSp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jbPesquisar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Solicitação de Pagamento");

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAddLoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/mais-32.png"))); // NOI18N
        jbAddLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddLojaActionPerformed(evt);
            }
        });
        jPanel4.add(jbAddLoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 40, 40));

        jLabel9.setText("Código da SP:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jtfCodigoSP.setEditable(false);
        jtfCodigoSP.setEnabled(false);
        jPanel4.add(jtfCodigoSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, -1));

        jLabel10.setText("Número da Nota:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, -1));

        jtfNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNotaActionPerformed(evt);
            }
        });
        jPanel4.add(jtfNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 100, -1));

        jLabel11.setText("Data de Vencimento:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 140, -1));

        jcbFornecedor.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbFornecedorPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel4.add(jcbFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 140, -1));

        jLabel1.setText("Fornecedor:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        jcbPagamento.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbPagamentoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel4.add(jcbPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 140, -1));

        jLabel2.setText("Forma de Pagamento:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        jtLoja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lojas", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtLoja);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 150));

        jLabel3.setText("Historico:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        jLabel4.setText("Observações:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        jtaObservacoes.setColumns(20);
        jtaObservacoes.setRows(5);
        jScrollPane4.setViewportView(jtaObservacoes);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 233, 400, 50));

        jtaHistorico.setColumns(20);
        jtaHistorico.setRows(5);
        jScrollPane3.setViewportView(jtaHistorico);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 400, 60));

        jLabel5.setText("Valor da Nota:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));
        jPanel4.add(jftfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 140, 30));

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/salvar-32.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });
        jPanel4.add(jbSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 790, 40));

        jtCadastroSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código da SP", "Número da Nota", "Fornecedor", "Forma de Pagamento", "Valor da Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jtCadastroSP);
        if (jtCadastroSP.getColumnModel().getColumnCount() > 0) {
            jtCadastroSP.getColumnModel().getColumn(0).setMinWidth(80);
            jtCadastroSP.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtCadastroSP.getColumnModel().getColumn(0).setMaxWidth(80);
            jtCadastroSP.getColumnModel().getColumn(1).setMinWidth(80);
            jtCadastroSP.getColumnModel().getColumn(1).setPreferredWidth(80);
            jtCadastroSP.getColumnModel().getColumn(1).setMaxWidth(80);
            jtCadastroSP.getColumnModel().getColumn(4).setMinWidth(100);
            jtCadastroSP.getColumnModel().getColumn(4).setPreferredWidth(100);
            jtCadastroSP.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 790, 110));

        jdcData.setDateFormatString("yyyy/MM/dd");
        jPanel4.add(jdcData, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 150, -1));

        jtfCodigoFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCodigoFornecedorFocusLost(evt);
            }
        });
        jPanel4.add(jtfCodigoFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 140, -1));

        jLabel7.setText("Código do Fornecedor:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jcbLoja.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbLojaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel4.add(jcbLoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 90, -1));

        jLabel8.setText("Lojas:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jtfLoja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfLojaFocusLost(evt);
            }
        });
        jPanel4.add(jtfLoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 50, -1));

        jLabel12.setText("Total de Lojas:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jlTotalLojas.setText("jLabel13");
        jPanel4.add(jlTotalLojas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        jbLimparTabelaLoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/limpar-32.png"))); // NOI18N
        jbLimparTabelaLoja.setText("Limpar");
        jbLimparTabelaLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparTabelaLojaActionPerformed(evt);
            }
        });
        jPanel4.add(jbLimparTabelaLoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 110, -1));

        jbRemoveLoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/menos-32.png"))); // NOI18N
        jbRemoveLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoveLojaActionPerformed(evt);
            }
        });
        jPanel4.add(jbRemoveLoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 40, 40));

        jtfPagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfPagamentoFocusLost(evt);
            }
        });
        jPanel4.add(jtfPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 140, -1));

        jLabel13.setText("Código Forma de Pagamento:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jTabbedPane2.addTab("Cadastro da SP", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtPesquisarSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código da SP", "Número da Nota", "Fornecedor", "Forma de Pagamento", "Valor da Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jtPesquisarSP);
        if (jtPesquisarSP.getColumnModel().getColumnCount() > 0) {
            jtPesquisarSP.getColumnModel().getColumn(0).setMinWidth(80);
            jtPesquisarSP.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtPesquisarSP.getColumnModel().getColumn(0).setMaxWidth(80);
            jtPesquisarSP.getColumnModel().getColumn(1).setMinWidth(80);
            jtPesquisarSP.getColumnModel().getColumn(1).setPreferredWidth(80);
            jtPesquisarSP.getColumnModel().getColumn(1).setMaxWidth(80);
            jtPesquisarSP.getColumnModel().getColumn(4).setMinWidth(100);
            jtPesquisarSP.getColumnModel().getColumn(4).setPreferredWidth(100);
            jtPesquisarSP.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 790, 370));
        jPanel5.add(jtfPkSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, -1));

        jLabel6.setText("Código da SP:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/pesquisar-32.png"))); // NOI18N
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });
        jPanel5.add(jbPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 120, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/imprimir-32.png"))); // NOI18N
        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jTabbedPane2.addTab("Pesquisar SP", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    //adicionar lojas a tabela de lojas selecionadas
    private void jbAddLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddLojaActionPerformed
       if(jcbLoja.getSelectedItem().equals(true)){
           JOptionPane.showMessageDialog(null, "Favor selecionar uma loja");
       }else{
           try {
               modelLoja = controllerLoja.retornarLojaController(Integer.parseInt(jtfLoja.getText()));
               DefaultTableModel modelo = (DefaultTableModel) jtLoja.getModel();
               int cont = 0;
               for (int i = 0; i < cont; i++){
                   modelo.setNumRows(0);
               }
               modelo.addRow(new Object[]{
                   modelLoja.getLojId(),
                   modelLoja.getLojSigla()
               });
               somarLojasSelecionadas();
               
           } catch (SQLException ex) {
               Logger.getLogger(ViewSP.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_jbAddLojaActionPerformed

    //perder focu do fornecedor
    private void jtfCodigoFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCodigoFornecedorFocusLost
        try {
            modelFornecedor = controllerFornecedor.retornarFornecedorController(Integer.parseInt(jtfCodigoFornecedor.getText()));
            jcbFornecedor.setSelectedItem(modelFornecedor.getForFornecedor());
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewSP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jtfCodigoFornecedorFocusLost
    
    //preenche no jtf o codigo pra nao iniciar vazio
    private void preencherCodigoLoja(){
        modelLoja = controllerLoja.retornarLojaController(jcbLoja.getSelectedItem().toString());
        jtfLoja.setText(String.valueOf(modelLoja.getLojId()));
    }
     //preenche no jtf o codigo pra nao iniciar vazio
    private void preencherFormaPagamento() throws SQLException{
        modelFormaPagamento = controllerFormaPagamento.retornarFormaPagamentoController(jcbPagamento.getSelectedItem().toString());
        jtfPagamento.setText(String.valueOf(modelFormaPagamento.getPagId()));
    }
    
    
    //preenche no jtf o codigo pra nao iniciar vazio
    private void preencherCodigoFornecedor(){
        modelFornecedor = controllerFornecedor.retornarFornecedorController(jcbFornecedor.getSelectedItem().toString());
        jtfCodigoFornecedor.setText(String.valueOf(modelFornecedor.getForId()));
    }
    //retorna para o jft o q escolheu no jcb
    private void jcbFornecedorPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbFornecedorPopupMenuWillBecomeInvisible
        if(jcbFornecedor.isPopupVisible()){
            preencherCodigoFornecedor();
        }
    }//GEN-LAST:event_jcbFornecedorPopupMenuWillBecomeInvisible
    
    //retorna para o jft o q escolheu no jcb
    private void jcbLojaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbLojaPopupMenuWillBecomeInvisible
        if(jcbLoja.isPopupVisible()){
            preencherCodigoLoja();
        }
    }//GEN-LAST:event_jcbLojaPopupMenuWillBecomeInvisible
    
    //perder o focu da loja
    private void jtfLojaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfLojaFocusLost
        try {
            modelLoja = controllerLoja.retornarLojaController(Integer.parseInt(jtfLoja.getText()));
            jcbLoja.setSelectedItem(modelLoja.getLojSigla());
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfLojaFocusLost

    private void jbLimparTabelaLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparTabelaLojaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtLoja.getModel();
        modelo.setNumRows(0);
        somarLojasSelecionadas();
    }//GEN-LAST:event_jbLimparTabelaLojaActionPerformed

    private void jbRemoveLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveLojaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel)jtLoja.getModel();
        if (jtLoja.getSelectedRow() >= 0){
            modelo.removeRow(jtLoja.getSelectedRow());
            jtLoja.setModel(modelo);
            somarLojasSelecionadas();
        }else{
            JOptionPane.showMessageDialog(null, "Favor selecionar uma loja");
        }
    }//GEN-LAST:event_jbRemoveLojaActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
      
      listaModelsploj = new ArrayList<>();
      modelSolicitacaoPagamento = new ModelSolicitacaoPagamento();
      // modelSolicitacaoPagamento.setIdSP(Integer.valueOf(jtfCodigoSP.getText()));
      modelSolicitacaoPagamento.setSpNota(Integer.valueOf(jtfNota.getText()));
       int codigoSP = 0;
        /*pegar data do sistema
       try {
            modelSolicitacaoPagamento.setSpData(zaraDatas.converterData((Date) new java.sql.Date(System.currentTimeMillis())));
        } catch (ParseException ex) {
            Logger.getLogger(ViewSP.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
       //pegar a data do jcalendar
       long data = jdcData.getDate().getTime();
       modelSolicitacaoPagamento.setSpData(new java.sql.Date (data));
       
       modelSolicitacaoPagamento.setIdFornecedor(Integer.valueOf(jtfCodigoFornecedor.getText()));
       
       modelSolicitacaoPagamento.setIdForma(Integer.valueOf(jtfPagamento.getText()));
       modelSolicitacaoPagamento.setSpHistorico(jtaHistorico.getText());
       modelSolicitacaoPagamento.setSpObservacoes(jtaObservacoes.getText());
       modelSolicitacaoPagamento.setSpValor(Double.valueOf(jftfValor.getText()));
       
       //salva o codigo da sp
       codigoSP = controllerSolicitacaoPagamento.salvarSolicitacaoPagamentoController(modelSolicitacaoPagamento);
       //>0 pq retorna inteiro
       if (codigoSP > 0){
       //cadastrou usuario
       //limparFormulario();
       JOptionPane.showMessageDialog(this, "SP cadastrado com sucesso "+codigoSP, "Atenção", JOptionPane.INFORMATION_MESSAGE);
       //carregarUsuario();     
       }else{
       //nao cadastrou    
       JOptionPane.showMessageDialog(this, "Erro ao cadastrar SP","Erro", JOptionPane.ERROR_MESSAGE);
       }
       int cont = jtLoja.getRowCount();
       System.out.println(cont);
       for (int i = 0; i < cont; i++){
           modelSpLoj = new Modelsploj();
           modelSpLoj.setIdLoja((int) jtLoja.getValueAt(i, 0));
           modelSpLoj.setIdSP(codigoSP);
           listaModelsploj.add(modelSpLoj);
           }
        try {
            //salvar as lojas da sp
            if(controllerSpLoj.salvarsplojController(listaModelsploj)){
                carregarPesquisa();
                //JOptionPane.showMessageDialog(this, "loja cadastrada com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar loja","Erro", JOptionPane.ERROR_MESSAGE);
            }} catch (SQLException ex) {
            Logger.getLogger(ViewSP.class.getName()).log(Level.SEVERE, null, ex);
        }
       carregarTabelaSP();
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jtfNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNotaActionPerformed

    private void jcbPagamentoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPagamentoPopupMenuWillBecomeInvisible
        if(jcbPagamento.isPopupVisible()){
            try {
                preencherFormaPagamento();
            } catch (SQLException ex) {
                Logger.getLogger(ViewSP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jcbPagamentoPopupMenuWillBecomeInvisible

    private void jtfPagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPagamentoFocusLost
        try {
            modelFormaPagamento = controllerFormaPagamento.retornarFormaPagamentoController(Integer.parseInt(jtfPagamento.getText()));
            jcbPagamento.setSelectedItem(modelFormaPagamento.getPagForma());
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfPagamentoFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ControllerRelatorioLoja controllerRelatorioLoja = new ControllerRelatorioLoja();
        try {
            modelSolicitacaoPagamento.setIdSP(Integer.valueOf(jtfPkSp.getText()));
            int pk = modelSolicitacaoPagamento.getIdSP();
            System.out.println(pk);
            controllerRelatorioLoja.relatorioSP(pk);
        } catch (JRException ex) {
            Logger.getLogger(ViewLoja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewLoja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewLoja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
       carregarPesquisa();
        DefaultTableModel modelo = (DefaultTableModel) this.jtPesquisarSP.getModel();
        final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
        this.jtPesquisarSP.setRowSorter(classificador);
        String pesquisa = jtfPkSp.getText();
        classificador.setRowFilter(RowFilter.regexFilter(pesquisa, 0));
    }//GEN-LAST:event_jbPesquisarActionPerformed
    
    public void preencherFornecedor() throws SQLException{
        listaModelFornecedor = controllerFornecedor.retornarListaFornecedorController();
        jcbFornecedor.removeAllItems();
        for (int i = 0; i < listaModelFornecedor.size(); i++){
            jcbFornecedor.addItem(listaModelFornecedor.get(i).getForFornecedor());
        }
    }
    
    public void preencherLoja() throws SQLException{
        listaModelLoja = controllerLoja.retornarListaLojaController();
        jcbLoja.removeAllItems();
        for (int i = 0; i < listaModelLoja.size(); i++){
            jcbLoja.addItem(listaModelLoja.get(i).getLojSigla());
        }
    }
    public void preencherForma() throws SQLException{
        listaModelFormaPagamento = controllerFormaPagamento.retornarListaFormaPagamentoController();
        jcbPagamento.removeAllItems();
        for (int i = 0; i < listaModelFormaPagamento.size(); i++){
            jcbPagamento.addItem(listaModelFormaPagamento.get(i).getPagForma());
        }
    }
    
    private void somarLojasSelecionadas(){
        int cont = jtLoja.getRowCount();
        jlTotalLojas.setText(String.valueOf(cont));
    }
    
    private boolean verificarLoja(){
        DefaultTableModel modelo = (DefaultTableModel) jtLoja.getModel();
               int cont = 0;
               for (int i = 0; i < cont; i++){
                   modelo.setNumRows(0);
               }
               
        
        return true;
    }
    private void carregarPesquisa(){
        listaModelSolicitacaoPagamento = controllerSolicitacaoPagamento.getListaSolicitacaoPagamentoController();
        DefaultTableModel modelo = (DefaultTableModel) jtPesquisarSP.getModel();
        modelo.setNumRows(0);
        //inserindo
        int cont = listaModelSolicitacaoPagamento.size();
        for(int i=0; i < cont; i++){
            modelo.addRow(new Object[]{
                listaModelSolicitacaoPagamento.get(i).getIdSP(),
                listaModelSolicitacaoPagamento.get(i).getSpNota(),
                //listaModelSolicitacaoPagamento.get(i).getSpData(),
                listaModelSolicitacaoPagamento.get(i).getSpFornecedor(),
                listaModelSolicitacaoPagamento.get(i).getSpForma(),
                listaModelSolicitacaoPagamento.get(i).getSpValor()
            });
        }
    }
        private void carregarTabelaSP(){
        listaModelSolicitacaoPagamento = controllerSolicitacaoPagamento.getListaSolicitacaoPagamentoController();
        DefaultTableModel modelo = (DefaultTableModel) jtCadastroSP.getModel();
        modelo.setNumRows(0);
        //inserindo
        int cont = listaModelSolicitacaoPagamento.size();
        for(int i=0; i < cont; i++){
            modelo.addRow(new Object[]{
                listaModelSolicitacaoPagamento.get(i).getIdSP(),
                listaModelSolicitacaoPagamento.get(i).getSpNota(),
                //listaModelSolicitacaoPagamento.get(i).getSpData(),
                listaModelSolicitacaoPagamento.get(i).getSpFornecedor(),
                listaModelSolicitacaoPagamento.get(i).getSpForma(),
                listaModelSolicitacaoPagamento.get(i).getSpValor()
            });
        }
    }
    
   
    
    
    
    /*carregar loja em uma tabela
    private void carregarLoja(){
        listaModelLoja = controllerLoja.retornarListaLojaController();
        DefaultTableModel modelo = (DefaultTableModel) jtLojasDisponiveis.getModel();
        modelo.setNumRows(0);
        //inserindo
        int cont = listaModelLoja.size();
        for(int i=0; i < cont; i++){
            modelo.addRow(new Object[]{
                listaModelLoja.get(i).getLojSigla(),
                });
        }
    }*/
   
    
    /*preencher um jList
    public void preencherLoja(){
        listaModelLoja = controllerLoja.retornarListaLojaController();
        DefaultListModel model = new DefaultListModel();
       jlLoja.removeAll();
        for(int i = 0; i < listaModelLoja.size(); i++){
            model.addElement(listaModelLoja.get(i).getLojSigla());
            jlLoja.setModel(model);
        }
    }*/
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton jbAddLoja;
    private javax.swing.JButton jbLimparTabelaLoja;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbRemoveLoja;
    private javax.swing.JButton jbSalvar;
    private componentes.UJComboBox jcbFornecedor;
    private componentes.UJComboBox jcbLoja;
    private componentes.UJComboBox jcbPagamento;
    private com.toedter.calendar.JDateChooser jdcData;
    private javax.swing.JFormattedTextField jftfValor;
    private javax.swing.JLabel jlTotalLojas;
    private javax.swing.JTable jtCadastroSP;
    private javax.swing.JTable jtLoja;
    private javax.swing.JTable jtPesquisarSP;
    private javax.swing.JTextArea jtaHistorico;
    private javax.swing.JTextArea jtaObservacoes;
    private javax.swing.JTextField jtfCodigoFornecedor;
    private javax.swing.JTextField jtfCodigoSP;
    private javax.swing.JTextField jtfLoja;
    private javax.swing.JTextField jtfNota;
    private javax.swing.JTextField jtfPagamento;
    private javax.swing.JTextField jtfPkSp;
    // End of variables declaration//GEN-END:variables
}
