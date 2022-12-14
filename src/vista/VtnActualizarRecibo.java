package vista;

import control.logica.Control;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Diaz
 */
public class VtnActualizarRecibo extends javax.swing.JFrame {

    // SINGLETON - variable para control de instnacia de clase
    private static VtnActualizarRecibo instancia;


    // SINGLETON - Control de solo una instancia de clase
    public static VtnActualizarRecibo getInstancia() {
        if (instancia == null) {
            instancia = new VtnActualizarRecibo();
        }
        return instancia;
    }
    
    private VtnActualizarRecibo() {
        setVisible(false);
        setResizable(false);
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnActualizarRecibo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cBoxCodPago = new javax.swing.JComboBox<>();
        cBoxCodPago1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(172, 49, 43));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualizar Estado Recibo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel3.setName(""); // NOI18N

        btnActualizarRecibo.setText("Actualizar Recibo");

        jLabel1.setText("ID Pago:");

        cBoxCodPago1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Estado Recibo -", "true", "false" }));
        cBoxCodPago1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxCodPago1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Estado:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cBoxCodPago, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cBoxCodPago1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnActualizarRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cBoxCodPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cBoxCodPago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizarRecibo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cBoxCodPago1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxCodPago1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxCodPago1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarRecibo;
    public javax.swing.JComboBox<String> cBoxCodPago;
    public javax.swing.JComboBox<String> cBoxCodPago1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo para generacion de ventanas emergentes, cada veentana depende una
     * clave que indica que ventana debe de ejecutarse
     *
     * @param claveVentanaEmergente
     */
    public static void mostrarJOptionPane(int claveVentanaEmergente) {
        // muestra ventanas dependiendo de la ocasion
        switch (claveVentanaEmergente) {
            case 0:
                JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo properties.", "Incapacidad de Carga", 2);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta de la Base de Datos.", "Consulta de Base de Datos Incompleta", 2);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Actualmente no existen registros de animales en la base de datos, por favor\n seleccione un archivo properties para cargar registros.", "Sin Registros", 2);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "No hay mas animales en la lista.", "Limite alcanzado", 2);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "No se pudo relizar el registro(s) de el(los) animal(es).", "Registro Incompleto", 2);
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "No ha ingresado todos los datos, intente nuevamente.", "Ingreso Incompleto", 2);
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Se inserto registro(s) satisfactoriamente a la base de datos.", "Ingreso Completo", 2);
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el animal", "Eliminacion no realizada", 2);
                break;
            case 8:
                JOptionPane.showMessageDialog(null, "Se elimino satisfactoriamente el animal", "Eliminacion realizada", 2);
                break;
            case 9:
                JOptionPane.showMessageDialog(null, "No se pudo modificar el animal", "Modificacion fallida", 2);
                break;
            case 10:
                JOptionPane.showMessageDialog(null, "Se modifico el animal", "Modificacion exitosa", 2);
                break;
            case 11:
                JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo aleatorio", "Guardado Incompleto", 2);
                break;
        }

    }

}
