/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javareporte;

import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Administrador
 */
public class Alumnos extends javax.swing.JFrame {

    /**
     * Creates new form Alumnos
     */
    public Alumnos() {
        initComponents();
        mostrar();
        setLocationRelativeTo(null);
        setTitle("Matriculacion");
        setVisible(true); 
        SobreEscribirButton.setVisible(false);
    }
    
    private static final String path ="jdbc:mysql://localhost:3306/clase";
    private static  final String usuario="root";
    private static final String password ="";
    private static Connection connection;
    
    
     public boolean connection(){

        try {
            connection = DriverManager.getConnection(path, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        System.out.print("funciona");
        return true;
    }
     
    public boolean ingresar(String matricula, String nombre, String sexo, String email, boolean activo) {
        connection();
         String sql = "INSERT INTO alumno (Matricula, Nombre, Sexo, Email, Activo) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setString(1, matricula);
            sentencia.setString(2, nombre);
            sentencia.setString(3, sexo);
            sentencia.setString(4, email);
            sentencia.setBoolean(5, activo);

            sentencia.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
     
    public boolean eliminar(int id) {
         connection();
         AlmunosTabla.getSelectedRow();
        
        
        String sql = "DELETE FROM alumno WHERE Id = ?";
        try {
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setInt(1, id);

            int filasAfectadas = sentencia.executeUpdate();

            if (filasAfectadas > 0) {
                // Se eliminó correctamente
                return true;
            } else {
                // No se encontró el registro con el ID especificado
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
     
    public void mostrar(){
        connection();
        String sql = "select * from alumno";
        Statement st;
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Matricula");
        model.addColumn("Nombre");
        model.addColumn("Sexo");
        model.addColumn("Email");
        model.addColumn("Activo");
        AlmunosTabla.setModel(model);
        String[] datos = new String[6];
        try{
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                model.addRow(datos);
                
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error" + e.toString());
            
        }        
    }
    public boolean modificarAlumno(int id,String nuevaMatricula, String nuevoNombre, String nuevoSexo, String nuevoEmail, boolean nuevoActivo) {
        connection();
        String sql = "UPDATE alumno SET Matricula=?, Nombre=?, Sexo=?, Email=?, Activo=? WHERE Id=?";

        try {
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setInt(1, id);
            sentencia.setString(2, nuevaMatricula);
            sentencia.setString(3, nuevoNombre);
            sentencia.setString(4, nuevoSexo);
            sentencia.setString(5, nuevoEmail);
            sentencia.setBoolean(6, nuevoActivo);
           

            int filasAfectadas = sentencia.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String obtenerResultadoSexoRadioButton() {
        if(HombreRadioButton.isSelected()){
           return "Masculino";   
        }else if (MujerRadioButton.isSelected()){
            return "Femenino";               
        }
        return null;
        
    }
    
    public Boolean obtenerResultadoSIoNORadioButton() {
        if(SiRadioButton.isSelected()){
           return true;   
        }else if (NoRadioButton.isSelected()){
            return false;               
        }
        return null;
        
    }
    
    public boolean borrarAlumnoPorId(int id) {
        connection();
        String sql = "DELETE FROM alumno WHERE Id = ?";

        try {
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setInt(1, id);

            int filasAfectadas = sentencia.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } 
        
        

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AlmunosTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MatriculaTextField = new javax.swing.JTextField();
        NombreTextField = new javax.swing.JTextField();
        HombreRadioButton = new javax.swing.JRadioButton();
        MujerRadioButton = new javax.swing.JRadioButton();
        CorreoTextField = new javax.swing.JTextField();
        GuardarButton = new javax.swing.JButton();
        ModificarButton = new javax.swing.JButton();
        EliminarButton = new javax.swing.JButton();
        LimpiarButton = new javax.swing.JButton();
        ReporteButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        SiRadioButton = new javax.swing.JRadioButton();
        NoRadioButton = new javax.swing.JRadioButton();
        SobreEscribirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AlmunosTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(AlmunosTabla);

        jLabel1.setText("Datos alumno");

        jLabel2.setText("CodMatricula");

        jLabel3.setText("Nombre");

        jLabel5.setText("Sexo");

        jLabel6.setText("Correo");

        MatriculaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatriculaTextFieldActionPerformed(evt);
            }
        });

        buttonGroup1.add(HombreRadioButton);
        HombreRadioButton.setSelected(true);
        HombreRadioButton.setText("Hombre");

        buttonGroup1.add(MujerRadioButton);
        MujerRadioButton.setText("Mujer");

        GuardarButton.setText("Guardar");
        GuardarButton.setPreferredSize(new java.awt.Dimension(80, 20));
        GuardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarButtonActionPerformed(evt);
            }
        });

        ModificarButton.setText("Modificar");
        ModificarButton.setPreferredSize(new java.awt.Dimension(80, 20));
        ModificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarButtonActionPerformed(evt);
            }
        });

        EliminarButton.setText("Eliminar");
        EliminarButton.setPreferredSize(new java.awt.Dimension(80, 20));
        EliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarButtonActionPerformed(evt);
            }
        });

        LimpiarButton.setText("Limpiar");
        LimpiarButton.setPreferredSize(new java.awt.Dimension(80, 20));

        ReporteButton.setText("Reporte");
        ReporteButton.setPreferredSize(new java.awt.Dimension(80, 20));
        ReporteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReporteButtonMouseClicked(evt);
            }
        });

        jLabel4.setText("Activo");

        buttonGroup2.add(SiRadioButton);
        SiRadioButton.setSelected(true);
        SiRadioButton.setText("Si");

        buttonGroup2.add(NoRadioButton);
        NoRadioButton.setText("No");

        SobreEscribirButton.setText("SobreEscribir");
        SobreEscribirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SobreEscribirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NombreTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(MatriculaTextField)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(101, 101, 101)
                                .addComponent(HombreRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MujerRadioButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(GuardarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(EliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModificarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SiRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(NoRadioButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CorreoTextField)
                                .addGap(232, 232, 232)
                                .addComponent(ReporteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LimpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(447, 447, 447)
                                .addComponent(SobreEscribirButton)))))
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(SobreEscribirButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MatriculaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HombreRadioButton)
                        .addComponent(MujerRadioButton)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(CorreoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LimpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ReporteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SiRadioButton)
                    .addComponent(NoRadioButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MatriculaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatriculaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MatriculaTextFieldActionPerformed

    private void ModificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarButtonActionPerformed
        SobreEscribirButton.setVisible(true);
        MatriculaTextField.setText((String)AlmunosTabla.getValueAt(AlmunosTabla.getSelectedRow(),1));
         NombreTextField.setText((String)AlmunosTabla.getValueAt(AlmunosTabla.getSelectedRow(),2));
         CorreoTextField.setText((String)AlmunosTabla.getValueAt(AlmunosTabla.getSelectedRow(),4));
    }//GEN-LAST:event_ModificarButtonActionPerformed

    private void ReporteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReporteButtonMouseClicked
       connection();
        String report="C:\\Users\\Administrador\\Documents\\NetBeansProjects\\JavaReporte\\src\\javareporte\\report1.jrxml";
       JasperReport jr;
       try{
           jr= JasperCompileManager.compileReport(report);
           JasperPrint jp= JasperFillManager.fillReport(jr,null,connection);
           JasperViewer.viewReport(jp);
               
           } catch (JRException ex) {
               Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
           }
       
           
       
    }//GEN-LAST:event_ReporteButtonMouseClicked

    private void GuardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarButtonActionPerformed
        ingresar(MatriculaTextField.getText(),NombreTextField.getText(), obtenerResultadoSexoRadioButton(), CorreoTextField.getText(),obtenerResultadoSIoNORadioButton());
        mostrar();
    }//GEN-LAST:event_GuardarButtonActionPerformed

    private void SobreEscribirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SobreEscribirButtonActionPerformed
         modificarAlumno(0,MatriculaTextField.getText(),NombreTextField.getText(),obtenerResultadoSexoRadioButton(), CorreoTextField.getText(), obtenerResultadoSIoNORadioButton());
         SobreEscribirButton.setVisible(false);
         mostrar();
    }//GEN-LAST:event_SobreEscribirButtonActionPerformed

    private void EliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarButtonActionPerformed
      borrarAlumnoPorId((int) AlmunosTabla.getValueAt(AlmunosTabla.getSelectedRow(),0));
      mostrar();
    }//GEN-LAST:event_EliminarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AlmunosTabla;
    private javax.swing.JTextField CorreoTextField;
    private javax.swing.JButton EliminarButton;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JRadioButton HombreRadioButton;
    private javax.swing.JButton LimpiarButton;
    private javax.swing.JTextField MatriculaTextField;
    private javax.swing.JButton ModificarButton;
    private javax.swing.JRadioButton MujerRadioButton;
    private javax.swing.JRadioButton NoRadioButton;
    private javax.swing.JTextField NombreTextField;
    private javax.swing.JButton ReporteButton;
    private javax.swing.JRadioButton SiRadioButton;
    private javax.swing.JButton SobreEscribirButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
