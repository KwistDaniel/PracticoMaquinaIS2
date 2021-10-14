/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BusinessObject_Manager.BusinessObjectConVenCF;
import BusinessObject_Manager.BusinessObjectEnvio;
import BusinessObject_Manager.BusinessObjectMercancia;
import BusinessObject_Manager.BusinessObjectRenglon;
import BusinessObject_Manager.BusinessObjectVenta;
import DAO.DAOClienteF;
import DAO.DAOConectVenCF;
import DAO.DAOConectVenCJ;
import DAO.DAOEnvio;
import DAO.DAOMercancia;
import DAO.DAORenglon;
import DAO.DAOVenta;
import GUI.PruebasAndTemplates.*;
import GUI.*;
import Objects.ClienteF;
import Objects.ClienteJ;
import Objects.ConectVenCF;
import Objects.ConectVenCJ;
import Objects.Direccion;
import Objects.Envio;
import Objects.Mercancia;
import Objects.Renglon;
import Objects.Vendedor;
import Objects.Venta;
import Utils.Validates;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kwist
 */
public class FinAltaVenta extends javax.swing.JFrame {
    ArrayList<Mercancia> mercancias,restar;
    ClienteF clientef;
    ClienteJ clientej;
    int tipocliente,flagfecha=0;
    Vendedor vendedor;
    Direccion direccionenvio;
    ArrayList<Integer> descuentos;
    String fechenv = "";
    String horaenv = "";
    String HH = "",HM = "";
    /**
     * Creates new form Menu
     */
    public FinAltaVenta() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);     
    }
    
    public FinAltaVenta(ClienteF cfaux, ClienteJ cjaux, ArrayList<Mercancia> aux, Vendedor vaux,int tcliente,Direccion daux,ArrayList<Integer> descaux,ArrayList<Mercancia> restaaux){
        vendedor = new Vendedor(vaux);
        tipocliente = tcliente;
        if (tipocliente == 1){
            clientef = new ClienteF(cfaux);
        }
        else{
            clientej = new ClienteJ(cjaux);
        }
        mercancias = new ArrayList<Mercancia>(aux);
        restar = new ArrayList<Mercancia>(restaaux);
        direccionenvio = new Direccion(daux);
        descuentos = new ArrayList<Integer>(descaux);
        
        
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        BMostrarCliente.getRootPane().requestFocus();
        TFFechaEnv.setEnabled(false);
        
        BAgDir.setEnabled(true);
        BElegirFecha.setEnabled(true);
        TFHH.setEnabled(true);
        TFHM.setEnabled(true);
        jCheckBox1.setSelected(true);
    }

    public FinAltaVenta(ClienteF cfaux, ClienteJ cjaux, ArrayList<Mercancia> aux, Vendedor vaux,int tcliente,ArrayList<Integer> descaux,ArrayList<Mercancia> restaaux){
        vendedor = new Vendedor(vaux);
        tipocliente = tcliente;
        if (tipocliente == 1){
            clientef = new ClienteF(cfaux);
        }
        else{
            clientej = new ClienteJ(cjaux);
        }
        mercancias = new ArrayList<Mercancia>(aux);
        restar = new ArrayList<Mercancia>(restaaux);
        descuentos = new ArrayList<Integer>(descaux);
        
        
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        BMostrarCliente.getRootPane().requestFocus();
        TFFechaEnv.setEditable(false);
        BAgDir.setEnabled(false);
        BElegirFecha.setEnabled(false);
        TFHH.setEnabled(false);
        TFHM.setEnabled(false);
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
        BMostrarDir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        BVolver = new javax.swing.JButton();
        BElegirFecha = new javax.swing.JButton();
        TFHH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFFechaEnv = new javax.swing.JTextField();
        TFHM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        BAgDir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

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
        BMostrarCliente.setText("Ver Cliente");
        BMostrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMostrarClienteActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BMostrarDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BCargaVenta)
                    .addComponent(BMostrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(BMostrarCliente)
                .addGap(18, 18, 18)
                .addComponent(BMostrarDir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
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

        BElegirFecha.setBackground(new java.awt.Color(210, 4, 45));
        BElegirFecha.setForeground(new java.awt.Color(250, 250, 250));
        BElegirFecha.setText("Elegir Fecha");
        BElegirFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BElegirFechaActionPerformed(evt);
            }
        });

        TFHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFHHActionPerformed(evt);
            }
        });

        jLabel2.setText("Hora: ");

        jLabel3.setText("Fecha: ");

        TFFechaEnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFFechaEnvActionPerformed(evt);
            }
        });

        jLabel4.setText(":");

        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        BAgDir.setBackground(new java.awt.Color(210, 4, 45));
        BAgDir.setForeground(new java.awt.Color(250, 250, 250));
        BAgDir.setText("Agregar Direccion");
        BAgDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgDirActionPerformed(evt);
            }
        });

        jLabel5.setText("Cargar Envio:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(286, Short.MAX_VALUE)
                        .addComponent(BVolver))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BElegirFecha)
                                    .addComponent(BAgDir)
                                    .addComponent(TFFechaEnv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(TFHH, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TFHM, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BAgDir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BElegirFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFFechaEnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TFHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(TFHM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        SeleccionarTipoCliente stc = new SeleccionarTipoCliente(mercancias,vendedor,descuentos,restar);
        stc.setVisible(true);
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
        //1- CREO EL ENVIO (Necesita la direccion) *falta fecha y hora*
        //2- CREO LA VENTA
        //3- CARGO CADA RENGLON DE VENTA
        //4- CREO EL CONETOR DE VENTA CON EL CLIENTE
        //5- UPDATE A MERCANCIA
        
        //RECUPERAR EXITOS DE LOS DAO
        
        /*Consigo  Hora*/
        HH = TFHH.getText();
        HM = TFHM.getText();
        
        int a = Validates.validateIsNumber((String) HH);
        if(Validates.validateHora(HH,HM) == 1){
            horaenv = HH + ":" + HM;
        }
        
        
        
        
        
        
        /**INICIO* Actualizo tabla de Envio*/ //1
        Envio envio = new Envio(BusinessObjectEnvio.nuevoEnvio());
        envio.setId_dir(direccionenvio.getIdDir());
        envio.setFecha(fechenv);
        envio.setHora(horaenv);
        envio.setEstado(0);
        BusinessObjectEnvio.cargarEnvio(envio);
        /**FIN* Actualizo tabla de Envio*/

        /**INICIO* Actualizo tabla de Venta*/ //2
        Venta venta = new Venta(BusinessObjectVenta.nuevaVenta());
        venta.setDNI_V(vendedor.getDni());
        venta.setSexo_V(vendedor.getSexo());
        double pTotal = 0,pFinal = 0; //VER ESTO
        for (int i = 0;i<mercancias.size();i++){
            pTotal = pTotal + mercancias.get(i).getPrecio_u() * mercancias.get(i).getCantidad();
            
            pFinal = pFinal + (((100 - descuentos.get(i)) * (mercancias.get(i).getPrecio_u() * mercancias.get(i).getCantidad()))/100);
        }
        venta.setP_Total(pTotal);
        venta.setP_Final(pFinal);
        venta.setCOD_ENVIO(envio.getCod());
        
        BusinessObjectVenta.cargarVenta(venta);
        /**FIN* Actualizo tabla de Venta*/

        /**INICIO*Actualizo tabla de Renglones*/ //3
        for(int j=0; j<mercancias.size();j++){
            Renglon renglon = new Renglon(BusinessObjectRenglon.nuevoRenglon());
            renglon.setCOD_Venta(venta.getCOD_VENTA());
            renglon.setCOD_Mercancia(mercancias.get(j).getCod());
            renglon.setCantidad(mercancias.get(j).getCantidad());
            renglon.setPrecio_U(mercancias.get(j).getPrecio_u());
            renglon.setDescuento(descuentos.get(j));
            System.out.println("Cantidad :" + renglon.getCantidad());
            double ptot = mercancias.get(j).getCantidad() * mercancias.get(j).getPrecio_u();
            double pfif = (((100 - descuentos.get(j)) * (ptot))/100);

            renglon.setPrecio_F(pfif);
            BusinessObjectRenglon.cargarRenglon(renglon);
        }
        /**FIN* Actualizo tabla de Renglones*/
        
        /**INICIO* Actualizo tabla de CONVCLIENTE*/
        if (tipocliente == 1){
            ConectVenCF cvcf = new ConectVenCF();
            
            cvcf.setCOD_VENTA(venta.getCOD_VENTA());
            cvcf.setDNI(clientef.getDni());
            cvcf.setSexo(clientef.getSexo());
            BusinessObjectConVenCF.cargarConectVenCF(cvcf);
        }
        else{ // NO IMPLEMENTADO
            ConectVenCJ cvcj = new ConectVenCJ();
            //BusinessObject<ConectVenCJ> bOConectVenCJ = new DAOConectVenCJ();
            cvcj.setCOD_VENTA(venta.getCOD_VENTA());
            cvcj.setCUIT(clientej.getCUIT());
            //bOConectVenCJ.create(cvcj);
        }
        /**FIN* Actualizo tabla de CONVCLIENTE*/

        /**INICIO* Actualizo tabla Mercancias*/ //5
        
        for(int i = 0; i<restar.size();i++){
            BusinessObjectMercancia.modificarMercancia(restar.get(i));
        }
        /**FIN* Actualizo tabla Mercancias*/    

        
        dispose();
        MainMenu mm = new MainMenu(vendedor);
        mm.setVisible(true);
    }//GEN-LAST:event_BCargaVentaActionPerformed

    private void BElegirFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BElegirFechaActionPerformed
        JDateChooser jd = new JDateChooser();
        String message = "Elija la fecha de envio:\n";
        Object[] params = {message,jd};
        JOptionPane.showConfirmDialog(null,params,"Fecha de Envio", JOptionPane.PLAIN_MESSAGE);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fechenv=sdf.format(((JDateChooser)params[1]).getDate());
        System.out.println("AAAA FECHA ELEGIDA: " + fechenv);
        
        TFFechaEnv.setText(fechenv);
    }//GEN-LAST:event_BElegirFechaActionPerformed

    private void TFFechaEnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFFechaEnvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFFechaEnvActionPerformed

    private void TFHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFHHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFHHActionPerformed

    private void BAgDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgDirActionPerformed
        dispose();
        SeleccionarDireccionEnvio sde = new SeleccionarDireccionEnvio(clientef,clientej,mercancias,vendedor,tipocliente,descuentos,restar);
        sde.setVisible(true);
    }//GEN-LAST:event_BAgDirActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            BAgDir.setEnabled(true);
            BElegirFecha.setEnabled(true);
            TFHH.setEnabled(true);
            TFHM.setEnabled(true);
        }
        if(evt.getStateChange() == ItemEvent.DESELECTED){
            BAgDir.setEnabled(false);
            BElegirFecha.setEnabled(false);
            TFHH.setEnabled(false);
            TFHM.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void BMostrarDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMostrarDirActionPerformed
        JOptionPane.showMessageDialog(null, direccionenvio.toString());
    }//GEN-LAST:event_BMostrarDirActionPerformed

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
    private javax.swing.JButton BAgDir;
    private javax.swing.JButton BCargaVenta;
    private javax.swing.JButton BElegirFecha;
    private javax.swing.JButton BMostrarCliente;
    private javax.swing.JButton BMostrarDir;
    private javax.swing.JButton BVolver;
    private javax.swing.JTextField TFFechaEnv;
    private javax.swing.JTextField TFHH;
    private javax.swing.JTextField TFHM;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
