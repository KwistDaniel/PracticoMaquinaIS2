/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject_Manager.BusinessObjectMercancia;
import BusinessObject_Manager.BusinessObjectVenta;
import DAO.DAOMercancia;
import GUI.*;
import Objects.Mercancia;
import Objects.Vendedor;
import Utils.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author kwist
 */

public class SeleccionarMercancia extends javax.swing.JFrame {
    ArrayList<Mercancia> mercancias,restar;
    Vendedor vendedor;
    boolean venta_presupuesto,controlfiltro = true,limpiar = false;
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
    
    public SeleccionarMercancia(ArrayList<Mercancia> aux,Vendedor vaux,ArrayList<Mercancia> restaaux, boolean venta_presupuesto) {
        vendedor = new Vendedor(vaux);
        mercancias = new ArrayList<Mercancia>(aux);
        restar = new ArrayList<Mercancia>(restaaux);
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.venta_presupuesto = venta_presupuesto;
        BSeleccionar.getRootPane().requestFocus();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        
        
        
        ArrayList<Integer> codaelim = new ArrayList<Integer>();
        ArrayList<Integer> partaelim = new ArrayList<Integer>();
        for(int i=0; i < mercancias.size();i++){
            codaelim.add((Integer)mercancias.get(i).getCod());
            partaelim.add((Integer)mercancias.get(i).getPartida());
        }
        ArrayList<Mercancia> mercaux = new ArrayList<Mercancia>(BusinessObjectVenta.listarMercancias());
        int mercsize = mercaux.size();
        int codaelimsize = codaelim.size();
        for (int i=0;i<mercsize;i++){
            for(int j = 0; j < codaelimsize ; j++){
                if((int)mercaux.get(i).getCod() == codaelim.get(j)){
                    if((int)mercaux.get(i).getPartida() == partaelim.get(j)){
                        mercaux.remove(i);
                        codaelim.remove(j);
                        partaelim.remove(j);
                        codaelimsize = codaelim.size();
                        mercsize = mercaux.size();
                        i=0;
                        j=0;
                    }
                }   
            }
        }
        mercsize = mercaux.size();
        codaelimsize = codaelim.size();
        for (int i=0;i<mercsize;i++){
            for(int j = 0; j < codaelimsize ; j++){
                if((int)mercaux.get(i).getCod() == codaelim.get(j)){
                    if((int)mercaux.get(i).getPartida() == partaelim.get(j)){
                        mercaux.remove(i);
                        codaelim.remove(j);
                        partaelim.remove(j);
                        codaelimsize = codaelim.size();
                        mercsize = mercaux.size();
                        i=0;
                        j=0;
                    }
                }   
            }
        }
        
        
        Object[][] objects = Mercancia.getDataVector(mercaux);
        Object[] headers = Mercancia.getHeaders();
        tm.setDataVector(objects, headers);
        
        /*int rows = tm.getRowCount(),cantaverif = mercancias.size();
        for (int i=0; i < rows; i++){
            for (int j=0; j < cantaverif; j++){
                if(((int)tm.getValueAt(i, 0) == codaelim.get(j)) && ((int) tm.getValueAt(i, 11) == partaelim.get(j))){
                    tm.removeRow(i);
                    rows--;
                    cantaverif--;
                }
            }
        }
        */

        
        tabla = new JTable(tm);
        tabla.setFocusable(false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);
        
        tabla.setAutoCreateRowSorter(true);//para los filtros, tutorial de oracle
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabla.getModel());//para los filtros, tutorial de oracle
        tabla.setRowSorter(sorter);//para los filtros, tutorial de oracle
        JScrollPane scrollPane = new JScrollPane(tabla);
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
        
        
        jPanel5.setLayout(new BorderLayout());
        jPanel5.add(scrollPane, BorderLayout.CENTER);
        
        /**
         * Filtro de la tabla
         */
        //GridLayout para agregar los textfields
        jPanel4.setLayout(new GridLayout(1,1,0,0)); 
        
        //Textfields
        JTextField filtro = new JTextField();
        //Configuro las dimensiones
        filtro.setPreferredSize(new Dimension(tabla.getColumnModel().getColumn(0).getWidth() + tabla.getColumnModel().getColumn(1).getWidth() + tabla.getColumnModel().getColumn(2).getWidth() + tabla.getColumnModel().getColumn(3).getWidth() + tabla.getColumnModel().getColumn(4).getWidth(),22));
        filtro.setText("Filtro");
        /**
         * Listener para filtrar
         */
        filtro.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(controlfiltro){
                    filtro.setText("");
                }
                controlfiltro = false;
            }
        });
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

    private SeleccionarMercancia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BVolver = new javax.swing.JButton();
        BSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(210, 4, 45));

        jPanel2.setBackground(new java.awt.Color(245, 245, 220));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        BSeleccionar.setBackground(new java.awt.Color(210, 4, 45));
        BSeleccionar.setForeground(new java.awt.Color(250, 250, 250));
        BSeleccionar.setText("Agregar Seleccionado");
        BSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BSeleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 846, Short.MAX_VALUE)
                .addComponent(BVolver)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BVolver)
                    .addComponent(BSeleccionar))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
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
        // TODO add your handling code here:
        
        if (venta_presupuesto){
            dispose();
            AltaPresupuesto ap = new AltaPresupuesto (mercancias,vendedor,restar);
        }
        else{
            dispose();
            AltaVenta av = new AltaVenta(mercancias,vendedor,restar);
        }
        
    }//GEN-LAST:event_BVolverActionPerformed

    private void BSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSeleccionarActionPerformed
        String control = Utils.popUpInD(Utils.SELECTAMOUNT, Utils.ADVICE);
        if (control == null){
            Utils.popUpMSG(Utils.WRONGVALUE, Utils.ERROR);
        }
        else{
            try{
                int cant = Integer.parseInt(control);
                ArrayList<Mercancia> mercanciasaux = new ArrayList<Mercancia>(mercancias);
                Object[] aux = tm.getDataVector().elementAt(tabla.convertRowIndexToModel(tabla.getSelectedRow())).toArray();
                if (cant > (int) aux[4] || cant <=0){
                    Utils.popUpMSG(Utils.WRONGVALUE, Utils.ERROR);
                }
                else{
                    Mercancia aux1 = new Mercancia();
                    aux1.setCod((int) aux[0]);
                    aux1.setNombre((String) aux[1]);
                    aux1.setDescripcion((String) aux[2]);
                    aux1.setPrecio_u((double) aux[3]);
                    aux1.setCantidad(cant);
                    aux1.setColor((String) aux[5]);
                    aux1.setCategoria((String) aux[6]);
                    aux1.setCalidad((int) aux[7]);
                    aux1.setAncho((int) aux[8]);
                    aux1.setAlto((int) aux[9]);
                    aux1.setMetcuad((double) aux[10]);
                    aux1.setPartida((int) aux[11]);
                    mercanciasaux.add(aux1);
                    int newcant = ((int)aux[4] - cant);
                    Mercancia aux2 = new Mercancia(aux1.getCod(),aux1.getNombre(),aux1.getCategoria(),aux1.getDescripcion(),newcant,aux1.getPrecio_u(),aux1.getColor(),aux1.getPartida(),aux1.getAncho(),aux1.getAncho(),aux1.getMetcuad(),aux1.getCalidad());
                    restar.add(aux2);
                    dispose();
                    if(this.venta_presupuesto){
                        AltaPresupuesto AP = new AltaPresupuesto(mercanciasaux,vendedor,restar);
                        AP.setVisible(true);
                    }
                    else{
                        AltaVenta AV = new AltaVenta(mercanciasaux,vendedor,restar);
                        AV.setVisible(true);
                    }

                }
            }catch(Exception e){
                Utils.popUpMSG(Utils.WRONGVALUE, Utils.ERROR);
            }
        }
    }//GEN-LAST:event_BSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionarMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionarMercancia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BSeleccionar;
    private javax.swing.JButton BVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
