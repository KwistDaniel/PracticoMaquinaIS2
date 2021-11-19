/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import BusinessObject_Manager.BusinessObjectDireccion;
import BusinessObject_Manager.BusinessObjectEnvio;
import GUI.*;
import Objects.ClienteF;
import Objects.ClienteJ;
import Objects.Direccion;
import Objects.Envio;
import Objects.Mercancia;
import Objects.Vendedor;
import Utils.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author kwist
 */
public class ListarEnvios extends javax.swing.JFrame {
    Vendedor vendedor;
    ArrayList<Envio> envios;
    /**
     * Creates new form Menu
     */
    private final JTable tabla;
    DefaultTableModel tm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return column == 1;
            }
        };
    JScrollPane scrollPane = new JScrollPane();
    
    public ListarEnvios(ArrayList<Envio> aux,Vendedor vaux) {
        vendedor = new Vendedor(vaux);
        envios = new ArrayList<Envio>(aux);
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //BModif.getRootPane().requestFocus(); no se que obda esto
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        
        Object[][] objects = Envio.getDataVector(BusinessObjectEnvio.listarEnvios());
        Object[] headers = Envio.getHeaders();
        tm.setDataVector(objects, headers);
        
        /**Elimino los envios a dir 1, ya que estos son envios que no estan dados de alta todavia
         * La direccion con ID 1 es una direccion reservada para poder mantener las relaciones en la base de datos
         * al crear una venta para la cual no se le da de alta un envio.
        */
        for (int i=0; i < tm.getRowCount(); i++){
            if((int) tm.getValueAt(i, 1) == 1){
                tm.removeRow(i);
                i--;
            }
        }
        for (int i=0; i < tm.getRowCount(); i++){
            if((int) tm.getValueAt(i, 4) == 1){
                tm.setValueAt("Entregado", i, 4);
            }
            else{
                tm.setValueAt("Sin Entregar", i, 4);
            }
        }
        
        tabla = new JTable(tm);
        tabla.setFocusable(false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);
        //Creo los botones
        tabla.getColumn("Codigo de Direccion").setCellRenderer(new ButtonRenderer());
        tabla.getColumn("Codigo de Direccion").setCellEditor(new ButtonEditor(new JCheckBox(),new BusinessObjectDireccion(),true));
        
        
        tabla.setAutoCreateRowSorter(true);//para los filtros, tutorial de oracle
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabla.getModel());//para los filtros, tutorial de oracle
        tabla.setRowSorter(sorter);//para los filtros, tutorial de oracle
        scrollPane = new JScrollPane(tabla);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(20);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
                
        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
        
        scrollPane.setPreferredSize(new Dimension(665,450));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        add(scrollPane, gridBagConstraints);
        
        
        jPanel6.setLayout(new BorderLayout());
        jPanel6.add(scrollPane, BorderLayout.CENTER);
        
        
        
        
        /**
         * Filtro de la tabla
         */
        //GridLayout para agregar los textfields
        jPanel4.setLayout(new GridLayout(1,1,0,0)); 
        
        //Textfields
        JTextField filtro = new JTextField();
        //Configuro las dimensiones
        filtro.setPreferredSize(new Dimension(tabla.getColumnModel().getColumn(0).getWidth() + tabla.getColumnModel().getColumn(1).getWidth() + tabla.getColumnModel().getColumn(2).getWidth() + tabla.getColumnModel().getColumn(3).getWidth() + tabla.getColumnModel().getColumn(4).getWidth(),22));
        
        /**
         * Listener para filtrar
         */
        filtro.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String str = filtro.getText();
                if(str.trim().length() == 0){
                    sorter.setRowFilter(null);
                }
                else{
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String str = filtro.getText();
                if(str.trim().length() == 0){
                    sorter.setRowFilter(null);
                }
                else{
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        

        //Los agrego al panel
        jPanel4.add(filtro);
    }

    private ListarEnvios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class ButtonRenderer extends JButton implements TableCellRenderer{
        public ButtonRenderer(){
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            if(isSelected){
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            }
            else{
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.backgound"));
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }
    
    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private String label2;
        private boolean isPushed;
        private boolean isLabel2;
        private BusinessObjectDireccion boDir;

        public ButtonEditor(JCheckBox checkBox, BusinessObjectDireccion businessObject, boolean isLabel2) {
            super(checkBox);
            this.boDir = businessObject;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });

            this.isLabel2 = isLabel2;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            if (isLabel2) {
                label2 = (value == null) ? "" : table.getValueAt(row, column + 1).toString();
            }

            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {

            String[] ids;

            if (isLabel2) {
                ids = new String[]{label, label2};
            } else {
                ids = new String[]{label};
            }

            if (isPushed) {
                Object object = boDir.readDir(ids[0]);
                dispose();
                ListarEnvios le = new ListarEnvios(new ArrayList<Envio>(),vendedor);
                le.setVisible(true);
                Utils.popUpMSG(object.toString(), "Direccion de Envio");
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BVolver = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        BModif = new javax.swing.JButton();
        BConfEnv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(210, 4, 45));

        jPanel2.setBackground(new java.awt.Color(245, 245, 220));

        jPanel4.setBackground(new java.awt.Color(245, 245, 220));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(245, 245, 220));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1075, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(245, 245, 220));

        BVolver.setBackground(new java.awt.Color(210, 4, 45));
        BVolver.setForeground(new java.awt.Color(250, 250, 250));
        BVolver.setText("Volver");
        BVolver.setActionCommand("Exit");
        BVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVolverActionPerformed(evt);
            }
        });

        BBorrar.setBackground(new java.awt.Color(210, 4, 45));
        BBorrar.setForeground(new java.awt.Color(250, 250, 250));
        BBorrar.setText("Eliminar Seleccionado");
        BBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBorrarActionPerformed(evt);
            }
        });

        BModif.setBackground(new java.awt.Color(210, 4, 45));
        BModif.setForeground(new java.awt.Color(250, 250, 250));
        BModif.setText("Modificar Seleccionado");
        BModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModifActionPerformed(evt);
            }
        });

        BConfEnv.setBackground(new java.awt.Color(210, 4, 45));
        BConfEnv.setForeground(new java.awt.Color(250, 250, 250));
        BConfEnv.setText("Actualizar Estado de Envio");
        BConfEnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConfEnvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BModif)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BBorrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BConfEnv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BVolver)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BModif)
                    .addComponent(BBorrar)
                    .addComponent(BConfEnv)
                    .addComponent(BVolver))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
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

    private void BVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVolverActionPerformed
        dispose();
        MVentas mv = new MVentas(vendedor);
        mv.setVisible(true);
    }//GEN-LAST:event_BVolverActionPerformed

    private void BModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModifActionPerformed
        
        try{
            
            int estadoentrega = 0;
            Object[] aux = tm.getDataVector().elementAt(tabla.getSelectedRow()).toArray();
            if(((String)aux[4]).equals("Entregado")){
                estadoentrega = 1;
            }
            Envio aux1 = new Envio();
            aux1.setCod((int) aux[0]);
            aux1.setId_dir((int) aux[1]);
            aux1.setFecha((String) aux[2]);
            aux1.setHora((String) aux[3]);
            aux1.setEstado(estadoentrega);
            
            dispose();
            ModificarEnvio me = new ModificarEnvio(aux1,vendedor);
            me.setVisible(true);
        }
        catch(Exception e){
            Utils.popUpMSG(Utils.ENVIONOSEL, Utils.ERROR);
        }
        
        
    }//GEN-LAST:event_BModifActionPerformed

    private void BConfEnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConfEnvActionPerformed
        try{
            Object[] aux = tm.getDataVector().elementAt(tabla.getSelectedRow()).toArray();
            if(((String) aux[4]).equals("Entregado")){
                Utils.popUpMSG(Utils.ENVIOYAENT, Utils.ERROR);
            }
            else{
                BusinessObjectEnvio boEnvio = new BusinessObjectEnvio();
                Envio aux1 = new Envio();
                aux1.setCod((int) aux[0]);
                aux1.setId_dir((int) aux[1]);
                aux1.setFecha((String) aux[2]);
                aux1.setHora((String) aux[3]);
                aux1.setEstado(1);
                if(boEnvio.actualizarEstado(aux1) == 1){
                    Utils.popUpMSG(Utils.ENVIOESTACT, Utils.EXITO);
                }
                else{
                    Utils.popUpMSG(Utils.ENVIONOESTACT, Utils.ERROR);
                }
                dispose();
                ListarEnvios le = new ListarEnvios(new ArrayList<Envio>(),vendedor);
                le.setVisible(true);
            }
        }
        catch(Exception e){
            Utils.popUpMSG(Utils.ENVIONOSEL, Utils.ERROR);
        }
    }//GEN-LAST:event_BConfEnvActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        try{
            int estadoentrega = 0;
            Object[] aux = tm.getDataVector().elementAt(tabla.getSelectedRow()).toArray();
            if(((String) aux[4]).equals("Entregado")){
                estadoentrega = 1;
            }
            
            Envio envioaux = new Envio((int) aux[0],(int) aux[1],estadoentrega,(String) aux[2],(String) aux[3]);
            BusinessObjectDireccion bod = new BusinessObjectDireccion();
            Direccion diraux = bod.readDir(String.valueOf(envioaux.getId_dir()));
            String estado = new String("Sin Entregar");
            if(envioaux.getEstado() == 1){
                estado = "Entregado";
            }
            String saux = new String("Codigo: " + envioaux.getCod() + "\nDireccion: " + diraux.getCalleDir() + " " + diraux.getNumDir() + "\nFecha: " + envioaux.getFecha() + "\nHora: " + envioaux.getHora() + "\nEstado de Entrega: " + estado);
            int seleccion = Utils.popUpYNOp(saux,"Eliminar Envio");
            if(seleccion == JOptionPane.YES_OPTION){
                BusinessObjectEnvio boe = new BusinessObjectEnvio();
                if(boe.eliminarEnvio(envioaux) == 1){
                    Utils.popUpMSG(Utils.ENVIOELIM, Utils.EXITO);
                    dispose();
                    ListarEnvios le = new ListarEnvios(new ArrayList<Envio>(),vendedor);
                    le.setVisible(true);
                }
                else{
                    Utils.popUpMSG(Utils.ENVIONOELIM, Utils.ERROR);
                }
            }
            else{
                Utils.popUpMSG(Utils.OPCANCEL, Utils.ERROR);
            }
        }
        catch(Exception e){
            Utils.popUpMSG(Utils.ENVIONOSEL, Utils.ERROR);
        }
        
    }//GEN-LAST:event_BBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(ListarEnvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarEnvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarEnvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarEnvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarEnvios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBorrar;
    private javax.swing.JButton BConfEnv;
    private javax.swing.JButton BModif;
    private javax.swing.JButton BVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
