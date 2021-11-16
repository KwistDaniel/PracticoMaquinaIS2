/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject_Manager.BusinessObjectDireccion;
import BusinessObject_Manager.BusinessObjectEnvio;
import GUI.PruebasAndTemplates.*;
import GUI.*;
import Objects.ClienteF;
import Objects.ClienteJ;
import Objects.Direccion;
import Objects.Envio;
import Objects.ParCliente;
import Objects.Vendedor;
import Utils.Validates;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kwist
 */
public class ModificarEnvio extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    Envio envio;
    Vendedor vendedor;
    String fechenv = "";
    String horaenv = "";
    String HH = "",HM = "";
    Direccion direccionenvio;
    
    public ModificarEnvio(Envio e, Vendedor v) {
        envio = new Envio(e);
        vendedor = new Vendedor(v);
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        TFFechaEnv.setEditable(false);
        direccionenvio = BusinessObjectDireccion.readDir(String.valueOf(e.getId_dir()));
    }
    
    public ModificarEnvio(Envio e, Vendedor v,Direccion d) {
        envio = new Envio(e);
        vendedor = new Vendedor(v);
        direccionenvio = d;
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        TFFechaEnv.setEditable(false);
    }

    private ModificarEnvio() {
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
        BVolver = new javax.swing.JButton();
        TFFechaEnv = new javax.swing.JTextField();
        BSeleccionarFecha = new javax.swing.JButton();
        BSeleccionarDireccion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFHH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TFHM = new javax.swing.JTextField();
        CBEntregado = new javax.swing.JCheckBox();
        BModificar = new javax.swing.JButton();
        BMostrarDir = new javax.swing.JToggleButton();
        lherror = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(210, 4, 45));

        jPanel2.setBackground(new java.awt.Color(245, 245, 220));

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

        BSeleccionarFecha.setBackground(new java.awt.Color(210, 4, 45));
        BSeleccionarFecha.setForeground(new java.awt.Color(250, 250, 250));
        BSeleccionarFecha.setText("Seleccionar Fecha");
        BSeleccionarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSeleccionarFechaActionPerformed(evt);
            }
        });

        BSeleccionarDireccion.setBackground(new java.awt.Color(210, 4, 45));
        BSeleccionarDireccion.setForeground(new java.awt.Color(250, 250, 250));
        BSeleccionarDireccion.setText("Seleccionar Direccion");
        BSeleccionarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSeleccionarDireccionActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha:");

        jLabel3.setText("Hora:");

        TFHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFHHActionPerformed(evt);
            }
        });

        jLabel4.setText(":");

        TFHM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFHMActionPerformed(evt);
            }
        });

        CBEntregado.setText("Envio Entregado");

        BModificar.setBackground(new java.awt.Color(210, 4, 45));
        BModificar.setForeground(new java.awt.Color(250, 250, 250));
        BModificar.setText("Confirmar Cambios");
        BModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModificarActionPerformed(evt);
            }
        });

        BMostrarDir.setBackground(new java.awt.Color(210, 4, 45));
        BMostrarDir.setForeground(new java.awt.Color(250, 250, 250));
        BMostrarDir.setText("Ver Direccion");
        BMostrarDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMostrarDirActionPerformed(evt);
            }
        });

        lherror.setForeground(new java.awt.Color(210, 4, 45));
        lherror.setText("Hora incorrecta");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(BModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(BVolver)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lherror)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CBEntregado)
                                .addComponent(TFFechaEnv)
                                .addComponent(BSeleccionarDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BSeleccionarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(TFHH, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TFHM, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(BMostrarDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(BSeleccionarDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BSeleccionarFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFFechaEnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TFHM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lherror)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBEntregado)
                .addGap(31, 31, 31)
                .addComponent(BMostrarDir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BVolver)
                    .addComponent(BModificar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVolverActionPerformed
        // TODO add your handling code here:
        dispose();
        ListarEnvios le = new ListarEnvios(new ArrayList<Envio>(), vendedor);
        le.setVisible(true);
    }//GEN-LAST:event_BVolverActionPerformed

    private void BModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModificarActionPerformed
        int er1 = 0;
        try{
            HH = TFHH.getText();
            HM = TFHM.getText();

            int a = Validates.validateIsNumber((String) HH);
            if(Validates.validateHora(HH,HM) == 1){
                int hh = Integer.parseInt(HH), hm = Integer.parseInt(HM);
                if(!(hh >= 0 && hh <= 23) && !(hm >= 0 && hm <= 59)){
                    lherror.setVisible(true);
                    er1 = 1;
                }
                else{
                    horaenv = HH + ":" + HM;
                    lherror.setVisible(false);
                }
            }
            if(!(er1 == 1)){
                Envio envioaux = new Envio();
                envioaux.setCod(envio.getCod());
                /*Recupero datos*/
                envioaux.setId_dir(direccionenvio.getIdDir());
                envioaux.setFecha(fechenv);
                envioaux.setHora(horaenv);
                if (CBEntregado.isSelected() == true){
                    envioaux.setEstado(1);
                }
                else{
                    envioaux.setEstado(0);
                }
                String saux = new String("Codigo: " + envioaux.getCod() + "\nDireccion: " + direccionenvio.getCalleDir() + " " + direccionenvio.getNumDir() + "\nFecha: " + envioaux.getFecha() + "\nHora: " + envioaux.getHora() + "\nEstado de Entrega: " + envioaux.getEstado());
                int seleccion = JOptionPane.showConfirmDialog(rootPane,saux, "Confirmar los cambios",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                if(seleccion == JOptionPane.YES_OPTION){
                    BusinessObjectEnvio boe = new BusinessObjectEnvio();
                    if(boe.modificarEnvio(envioaux) == 1){
                        JOptionPane.showMessageDialog(null,"Envio modificado correctamente");
                        dispose();
                        ListarEnvios le = new ListarEnvios(new ArrayList<Envio>(),vendedor);
                        le.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No se pudo modificar el Envio");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"No modifico el envio");
                }
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo modificar el envio");
        }
        
        //ACA PONER COMO PARA LA BAJA, UN JOPTION CON HN SI Y UN NO, Y SI PONE SI MODIFICAR, SI PONE NO NO HACER NADA, YA QUE TIENE BOTON PARA VOLVER
    }//GEN-LAST:event_BModificarActionPerformed

    private void BSeleccionarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSeleccionarFechaActionPerformed
        JDateChooser jd = new JDateChooser();
        String message = "Elija la fecha de envio:\n";
        Object[] params = {message,jd};
        JOptionPane.showConfirmDialog(null,params,"Fecha de Envio", JOptionPane.PLAIN_MESSAGE);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fechenv=sdf.format(((JDateChooser)params[1]).getDate());
        
        TFFechaEnv.setText(fechenv);
    }//GEN-LAST:event_BSeleccionarFechaActionPerformed

    private void BSeleccionarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSeleccionarDireccionActionPerformed
        ClienteF clientef = new ClienteF();
        ClienteJ clientej = new ClienteJ();
        int tipocliente;
        ParCliente pc = new ParCliente();
        pc = BusinessObjectDireccion.recuperarTipoCliente(envio);
        tipocliente = pc.getTipo();
        
        dispose();
        SeleccionarDireccionEnvio sde = new SeleccionarDireccionEnvio(envio,vendedor,tipocliente,pc.getClientef(),pc.getClientej());
        sde.setVisible(true);
    }//GEN-LAST:event_BSeleccionarDireccionActionPerformed

    private void BMostrarDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMostrarDirActionPerformed
        JOptionPane.showMessageDialog(null, direccionenvio.toString());
    }//GEN-LAST:event_BMostrarDirActionPerformed

    private void TFHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFHHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFHHActionPerformed

    private void TFHMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFHMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFHMActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarEnvio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ModificarEnvio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BModificar;
    private javax.swing.JToggleButton BMostrarDir;
    private javax.swing.JButton BSeleccionarDireccion;
    private javax.swing.JButton BSeleccionarFecha;
    private javax.swing.JButton BVolver;
    private javax.swing.JCheckBox CBEntregado;
    private javax.swing.JTextField TFFechaEnv;
    private javax.swing.JTextField TFHH;
    private javax.swing.JTextField TFHM;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lherror;
    // End of variables declaration//GEN-END:variables
}
