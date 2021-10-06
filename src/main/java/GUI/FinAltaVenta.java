/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.BusinessObject;
import DAO.DAOClienteF;
import DAO.DAOMercancia;
import GUI.PruebasAndTemplates.*;
import GUI.*;
import Objects.ClienteF;
import Objects.ClienteJ;
import Objects.Direccion;
import Objects.Mercancia;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kwist
 */
public class FinAltaVenta extends javax.swing.JFrame {
    ArrayList<Mercancia> mercancias;
    ClienteF clientef;
    ClienteJ clientej;
    int prioridad,tipocliente;
    Direccion direccionenvio;
    /**
     * Creates new form Menu
     */
    public FinAltaVenta() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);     
    }
    
    public FinAltaVenta(ClienteF cfaux, ClienteJ cjaux, ArrayList<Mercancia> aux, int priority,int tcliente,Direccion daux){
        prioridad = priority;
        tipocliente = tcliente;
        if (tipocliente == 1){
            clientef = new ClienteF(cfaux);
        }
        else{
            clientej = new ClienteJ(cjaux);
        }
        mercancias = new ArrayList<Mercancia>(aux);
        direccionenvio = new Direccion(daux);
        
        
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null); 
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
        jPanel3 = new javax.swing.JPanel();
        BCargaVenta = new javax.swing.JButton();
        BMostrarCliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        BVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(210, 4, 45));

        jPanel2.setBackground(new java.awt.Color(245, 245, 220));

        jPanel3.setBackground(new java.awt.Color(245, 245, 220));

        BCargaVenta.setBackground(new java.awt.Color(210, 4, 45));
        BCargaVenta.setForeground(new java.awt.Color(250, 250, 250));
        BCargaVenta.setText("Cargar Venta");
        BCargaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCargaVentaActionPerformed(evt);
            }
        });

        BMostrarCliente.setBackground(new java.awt.Color(210, 4, 45));
        BMostrarCliente.setForeground(new java.awt.Color(250, 250, 250));
        BMostrarCliente.setText("Cliente");
        BMostrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMostrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BMostrarCliente)
                    .addComponent(BCargaVenta))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(BMostrarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addComponent(BCargaVenta)
                .addGap(90, 90, 90))
        );

        jPanel4.setBackground(new java.awt.Color(245, 245, 220));
        jPanel4.setPreferredSize(new java.awt.Dimension(364, 34));

        BVolver.setBackground(new java.awt.Color(210, 4, 45));
        BVolver.setForeground(new java.awt.Color(250, 250, 250));
        BVolver.setText("Volver");
        BVolver.setActionCommand("Exit");
        BVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
                .addComponent(BVolver)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BVolver)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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
        dispose();
        SeleccionarEnvio se = new SeleccionarEnvio(clientef,clientej,mercancias,prioridad,tipocliente);
        se.setVisible(true);
    }//GEN-LAST:event_BVolverActionPerformed

    private void BMostrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMostrarClienteActionPerformed
        if(tipocliente == 1){
            JOptionPane.showMessageDialog(null, clientef.toString());
        }
        else{
            //not supported yet
        }
    }//GEN-LAST:event_BMostrarClienteActionPerformed

    private void BCargaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCargaVentaActionPerformed
        //aca updateo las tablas
        if (tipocliente == 10){
            //1- CREO EL ENVIO (Necesita la direccion) *falta*
            //2- CREO LA VENTA *Faltan los datos de vendedor, de ultima en vez de pasar prioridad por todos lados, paso un vendedor*
            //3- CREO EL CONETOR DE VENTA CON EL CLIENTE *falta*
            //4- UPDATE A MERCANCIA *listo*
            //BusinessObject<??> businessObject?? = new DAO??();
            //creo la venta de clientes, esto seria un create para el DAO ConectVenCF
            //BusinessObject<??> businessObject?? = new DAO??();
            //creo el envio al cliente
        }
        else{
            //aca lo mismo de arriba pero con clientej
            //BusinessObject<??> businessObject?? = new DAO??();
            //BusinessObject<??> businessObject?? = new DAO??();
        }
            
        BusinessObject<Mercancia> businessObjectM = new DAOMercancia();
        for(int i = 0; i<mercancias.size();i++){//updateo la tabla de mercancias para actualizar la cantidad
            businessObjectM.update(mercancias.get(i));
        }
            
        
        
        dispose();
        MainMenu mm = new MainMenu(prioridad);
        mm.setVisible(true);
    }//GEN-LAST:event_BCargaVentaActionPerformed

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
            java.util.logging.Logger.getLogger(FinAltaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinAltaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinAltaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinAltaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FinAltaVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCargaVenta;
    private javax.swing.JButton BMostrarCliente;
    private javax.swing.JButton BVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
