package GUILayer;

import DAOClasses.*;
import java.util.Arrays;
import supermarktmanager.*;
import java.util.List;

public class Main extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private DAOContainer container;

    public Main() {
        container = new DAOContainer();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supermarktmanager");

        jLabel1.setText("Manage hier uw supermarkt");

        DAOContainer.session.beginTransaction();
        List<Product> producten = DAOContainer.product.getAllProducts();
        List<Container> containers = DAOContainer.container.getAllContainers();
        
        List<Kassiere> kassieren = DAOContainer.kassiere.getAllKassieres();
        List<Slager> slagers = DAOContainer.slager.getAllSlagers();
        List<Bakker> bakkers = DAOContainer.bakker.getAllBakkers();
        List<VakkenVuller> vakkenvullers = DAOContainer.vakkenvuller.getAllVakkenVullers();
        
        List<ProductHistory> history = DAOContainer.history.getAllProductHistories();
        DAOContainer.session.getTransaction().commit();

        List llist = producten;
        List<Object> objlist = (List<Object>) llist;
        FetchTabel f = new FetchTabel();

        System.out.println(Arrays.toString(f.Fetch(objlist)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                f.Fetch(objlist),
                new String[]{
            "Productnummer", "Merk", "Naam", "Prijs", "Reknummer"
        }));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Producten", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
                new String[]{
            "Title 1", "Title 2", "Title 3", "Title 4"
        }));
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("tab2", jScrollPane2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
            {"Waarde", 1, 2, 3},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
                new String[]{
            "Title 1", "Title 2", "Title 3", "Title 4"
        }));
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane1.addTab("tab3", jScrollPane3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
                new String[]{
            "Title 1", "Title 2", "Title 3", "Title 4"
        }));
        jScrollPane4.setViewportView(jTable4);

        jTabbedPane1.addTab("tab4", jScrollPane4);

        jButton2.setText("Opslaan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap()));

        pack();
    }

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
