package GUILayer;

import Entity.VakkenVuller;
import Entity.Product;
import Entity.Container;
import Entity.Slager;
import Entity.Kassiere;
import Entity.ProductHistory;
import Entity.Locatie;
import Entity.Bakker;
import ServiceLayer.*;
import java.util.List;

public class Main extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;

    public Main() {
        StaticContainer.getInstance();
        initComponents();
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            System.out.println((String) info.getName());
        }

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if (colIndex != 0) {
                    return true;
                }
                return false;
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if (colIndex != 0) {
                    return true;
                }
                return false;
            }
        };
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if (colIndex != 0) {
                    return true;
                }
                return false;
            }
        };
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if (colIndex != 0) {
                    return true;
                }
                return false;
            }
        };
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if (colIndex != 0) {
                    return true;
                }
                return false;
            }
        };

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supermarktmanager");

        jLabel1.setText("Manage hier uw supermarkt");

        ProductService pserv = (ProductService) StaticContainer.getService("ProductService");
        List<Product> producten = pserv.getAllProducts();

        ContainerService cserv = (ContainerService) StaticContainer.getService("ContainerService");
        List<Container> containers = cserv.getAllContainers();

        KassiereService kserv = (KassiereService) StaticContainer.getService("KassiereService");
        List<Kassiere> kassieren = kserv.getAllKassieres();

        SlagerService sserv = (SlagerService) StaticContainer.getService("SlagerService");
        List<Slager> slagers = sserv.getAllSlagers();

        BakkerService bserv = (BakkerService) StaticContainer.getService("BakkerService");
        List<Bakker> bakkers = bserv.getAllBakkers();

        VakkenVullerService vserv = (VakkenVullerService) StaticContainer.getService("VakkenVullerService");
        List<VakkenVuller> vakkenvullers = vserv.getAllVakkenVullers();

        ProductHistoryService phserv = (ProductHistoryService) StaticContainer.getService("ProductHistoryService");
        List<ProductHistory> history = phserv.getAllProductHistories();

        LocatieService lserv = (LocatieService) StaticContainer.getService("LocatieService");
        List<Locatie> locatie = lserv.getAllLocaties();
        
        //Product P = new Product();
        //Product P2 = new Product();
        //Locatie L = lserv.getLocatieById(new Long(1));
        //Container C = cserv.getContainerById(new Long(1));
        //C.addProduct(P);
        //C.addProduct(P2);
        //cserv.assignToLocation(C, L);
        
        IFetchTable fetchTable = new FetchTableProduct();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                fetchTable.Fetch(producten),
                new String[]{
            "Productnummer", "Merk", "Naam", "Prijs", "Reknummer"
        }));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Producten", jScrollPane1);

        fetchTable = new FetchTableContainer();
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                fetchTable.Fetch(containers),
                new String[]{
            "Id", "Locatie", "Type"
        }));
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Containers", jScrollPane2);

        fetchTable = new FetchTableProductHistory();
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                fetchTable.Fetch(history),
                new String[]{
            "Id", "Aantal", "Datum Begin", "Datum Eind", "Prijs", "Product Id"
        }));
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane1.addTab("Geschiedenis", jScrollPane3);

        fetchTable = new FetchTablePersoon();
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
                fetchTable.Fetch(vakkenvullers),
                new String[]{
            "Id", "Type", "Naam"
        }));
        jScrollPane4.setViewportView(jTable4);

        jTabbedPane1.addTab("Personeel", jScrollPane4);

        fetchTable = new FetchTableLocatie();
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
                fetchTable.Fetch(locatie),
                new String[]{
            "Id", "Type", "Locatie Id"
        }));
        jScrollPane5.setViewportView(jTable5);

        jTabbedPane1.addTab("Locatie", jScrollPane5);

        jButton1.setText("Opslaan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap()));

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Tab: " + jTabbedPane1.getSelectedIndex());
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
