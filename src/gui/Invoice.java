/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import model.invoice_item;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MySQL;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manula
 */
public class Invoice extends javax.swing.JFrame {

    HashMap<String, String> paymentMethodsMap = new HashMap<>();
    HashMap<String, invoice_item> invoiceItemMap = new HashMap<>();
    private Object payMeth;
    private Vector<?> rowData;

    /**
     * Creates new form Invoice
     */
    public Invoice() {
        initComponents();
        emName.setText(LogIn.getEmployeeName());

        invId();
        loadPaymentMeths();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    double total = 0;
    double totI = 0;

    
    public void loadInvoiceItems() {
        DefaultTableModel modal = (DefaultTableModel) jTable1.getModel();
        modal.setRowCount(0);

        try {
            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM ``");

            while (resultSet.next()) {
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invId() {
        String invGenId = String.valueOf(System.currentTimeMillis());
        String invExt = "CM_IN";
        String invoiceId = invExt + invGenId;
        inIdLable.setText(invoiceId);
    }

    public JLabel getStkLable() {
        return stkLable;
    }

    public JLabel getBrLable() {
        return brLable;
    }

    public JTextField getSellPField() {
        return sellPFild;
    }

    public JLabel getPName() {
        return pName;
    }

    public JLabel getPID() {
        return proIdLable;
    }

    public void loadPaymentMeths() {
        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `payment_method`");

            Vector<String> vector = new Vector<>();
            while (resultSet.next()) {
                vector.add(resultSet.getString("payment_method"));
                paymentMethodsMap.put(resultSet.getString("payment_method"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            pMCombo.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadInvoiceItems() {
        DefaultTableModel modal = (DefaultTableModel) jTable1.getModel();
        modal.setRowCount(0);

        total = 0;
        String invoice_id = inIdLable.getText();

        for (invoice_item invoiceItem : invoiceItemMap.values()) {
            Vector vector = new Vector();
            vector.add(invoice_id);
            vector.add(getPID());
            vector.add(invoiceItem.getProName());
            vector.add(invoiceItem.getSellPrice());
            vector.add(invoiceItem.getQty());

            double itemTotal = Double.parseDouble(invoiceItem.getQty()) * invoiceItem.getSellPrice();
            total += itemTotal;
            vector.add(String.valueOf(itemTotal));
        }
    }

    private double discount = 0;
    private double payment = 0;
    private String paymentMethod = "Select";
    private double balance = 0;
//    int qty = 0;

    private void calculate() {

        //settings
        if (discField.getText().isEmpty()) {
            discount = 0;
        } else {
            discount = Double.parseDouble(discField.getText());
        }

        if (payField.getText().isEmpty()) {
            payment = 0;
            JOptionPane.showMessageDialog(this, "Payment Field is Empty! Please Check...", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            payment = Double.parseDouble(payField.getText());
        }

        total = Double.parseDouble(totField.getText());

        paymentMethod = String.valueOf(pMCombo.getSelectedItem());
        //settings

        total -= discount;

        if (total < 0) {

            JOptionPane.showMessageDialog(this, "Total Field is Empty! Please Check...", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

        }

        if (paymentMethod.equals("Cash")) {
            //cash
            payField.setEditable(true);
            balance = payment - total;

            if (balance < 0) {
                payBill.setEnabled(false);
                payField.setEnabled(true);
            } else {
                payBill.setEnabled(true);
            }

        } else {
            //card
            payField.setEnabled(false);
            payment = total;
            balance = 0;
            payField.setText(String.valueOf(payment));
            payField.setEditable(false);
            payBill.setEnabled(true);
            balField.setEnabled(false);
        }

        balField.setText(String.valueOf(balance));

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inIdLable = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        stkLable = new javax.swing.JLabel();
        seleStock = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        qtyField = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        brLable = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sellPFild = new javax.swing.JFormattedTextField();
        pName = new javax.swing.JLabel();
        addInvoice = new javax.swing.JButton();
        cusMobField = new javax.swing.JTextField();
        proIdLable = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pMCombo = new javax.swing.JComboBox<>();
        balField = new javax.swing.JFormattedTextField();
        totField = new javax.swing.JFormattedTextField();
        discField = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        payField = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        payBill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Ravie", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/camera.png"))); // NOI18N
        jLabel2.setText("Camera Mart");

        jLabel3.setFont(new java.awt.Font("Stencil", 2, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/invoice2.png"))); // NOI18N
        jLabel3.setText("INVOICE");

        jLabel4.setFont(new java.awt.Font("Quicksand", 1, 17)); // NOI18N
        jLabel4.setText("Employee Name");

        emName.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        emName.setText("Emp Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emName)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emName))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel1.setText("Invoice ID");

        inIdLable.setText(".................................");

        jLabel6.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel6.setText("Customer");

        jLabel8.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel8.setText("Stock");

        stkLable.setText(".............................................");

        seleStock.setBackground(new java.awt.Color(0, 102, 204));
        seleStock.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        seleStock.setForeground(new java.awt.Color(255, 255, 255));
        seleStock.setText("Select a Stock");
        seleStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleStockActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel9.setText("Quantity");

        qtyField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        qtyField.setText("0");
        qtyField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qtyFieldKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel10.setText("Brand");

        brLable.setText(".................................");

        jLabel11.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel11.setText("Selling Price");

        sellPFild.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.00"))));
        sellPFild.setText("0.00");

        pName.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        pName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pName.setText("Product Name");

        addInvoice.setBackground(new java.awt.Color(0, 153, 0));
        addInvoice.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        addInvoice.setForeground(new java.awt.Color(255, 255, 255));
        addInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bills_8319022.png"))); // NOI18N
        addInvoice.setText("Add to Invoice");
        addInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInvoiceActionPerformed(evt);
            }
        });

        cusMobField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cusMobFieldKeyPressed(evt);
            }
        });

        proIdLable.setFont(new java.awt.Font("Quicksand", 1, 12)); // NOI18N
        proIdLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        proIdLable.setText("Product ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sellPFild))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(43, 43, 43)
                        .addComponent(brLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cusMobField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(inIdLable, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stkLable, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seleStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27)
                        .addComponent(qtyField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(proIdLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inIdLable)
                    .addComponent(jLabel9)
                    .addComponent(qtyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(stkLable))
                        .addGap(30, 30, 30)
                        .addComponent(seleStock)
                        .addGap(30, 30, 30)
                        .addComponent(pName))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cusMobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(brLable)
                            .addComponent(jLabel10))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(sellPFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(proIdLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addInvoice))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Product ID", "Product", "Price", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Quicksand", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setText("ITEMS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLabel15.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel15.setText("Payment meth.");

        pMCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pMCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pMComboItemStateChanged(evt);
            }
        });

        balField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        balField.setText("0.00");

        totField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.00"))));
        totField.setText("0.00");

        discField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        discField.setText("0.00");
        discField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discFieldKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel13.setText("Total");

        jLabel14.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel14.setText("Discount");

        payField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.00"))));
        payField.setText("0.00");
        payField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                payFieldKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel16.setText("Payment");

        jLabel17.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel17.setText("Balence");

        payBill.setBackground(new java.awt.Color(255, 255, 0));
        payBill.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        payBill.setForeground(new java.awt.Color(0, 0, 0));
        payBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pay_7989062.png"))); // NOI18N
        payBill.setText("Pay Bill");
        payBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13))
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totField)
                            .addComponent(discField)
                            .addComponent(balField)
                            .addComponent(payField)
                            .addComponent(pMCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(payBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(discField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(pMCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(payField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(balField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(payBill)
                        .addGap(12, 12, 12))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cusMobFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cusMobFieldKeyPressed


    }//GEN-LAST:event_cusMobFieldKeyPressed

    private void seleStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleStockActionPerformed
        Stock stock = new Stock();
        stock.setVisible(true);
        stock.setInvoice(this);
    }//GEN-LAST:event_seleStockActionPerformed

    private void addInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInvoiceActionPerformed

        String qty = (qtyField.getText());
        String customer = cusMobField.getText();
        String stock = stkLable.getText();
        String brand = brLable.getText();
        String price = sellPFild.getText();
        String proName = pName.getText();

        String empEmail = LogIn.getEmployeeEmail();
        String invoice_id = inIdLable.getText();

        String payMeth = String.valueOf(pMCombo.getSelectedItem());

        invoice_item invoice_item = new invoice_item();
        invoice_item.setQty(String.valueOf(qty));
        invoice_item.setCustomer(customer);
        invoice_item.setStockId(stock);
        invoice_item.setBrand(brand);
        invoice_item.setSellPrice(Double.parseDouble(price));
        invoice_item.setProName(proName);

        if (invoice_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please contact your Developers! Because Invoice Id is not generate well.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (qty == null) {
            JOptionPane.showMessageDialog(this, "Please enter Quantity!.", "Warning", JOptionPane.WARNING_MESSAGE);
//        } else if (customer.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please enter Customer's Mobile Number!.", "Warning", JOptionPane.WARNING_MESSAGE);
//        } else if (!customer.matches("^07[01245678]{1}[0-9]{7}$")) {
//            JOptionPane.showMessageDialog(this, "Invalid Mobile Number!.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (stock.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please contact your Developers! Because Stock Id is not generate well.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (brand.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please contact your Developers! Because Brand Name is missing.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please contact your Developers! Because Price is missing.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (proName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please contact your Developers! Because Product Name is missing.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            totI = Double.parseDouble(qty) * Double.parseDouble(price);

            total = total + (totI);
            totField.setText(String.valueOf(total));
            String date_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            resetIn();
            loadInvoiceItems();

            if (invoiceItemMap.get(invoice_id) == null) {
                invoiceItemMap.put(invoice_id, invoice_item);

                resetIn();
                loadInvoiceItems();
            }

            try {

            } catch (Exception e) {
                e.printStackTrace();
            }

//            try {
//
//                MySQL.executeIUD("INSERT INTO `invoice` "
//                        + "(`invo`,`date_time`,`payment_method_id`,`customer_mobile`)"
//                        + " VALUES ('" + invoice_id + "',"
//                        + "'" + date_time + "','" + paymentMethodsMap.get(payMeth) + "','" + customer + "')");
//
//                MySQL.executeIUD("INSERT INTO `invoice_item` (`qty`,`stock_id`,`invoice_invo`) "
//                        + "VALUES ('" + qty + "','" + stock + "','" + invoice_id + "')");
//
//                resetIn();
//                loadInvoiceItems();
//
////                if (jTable1.getRowCount() > 0) {
////                    DefaultTableModel model = (DefaultTableModel) jTable1.();
////                    model.setRowCount(0);
////                    loadInvoiceItems();
////                } else {
////                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }


    }//GEN-LAST:event_addInvoiceActionPerformed


    private void payBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBillActionPerformed
        String invoice_id = inIdLable.getText();

        if (total == 0) {
            JOptionPane.showMessageDialog(this, "Please Add invoice first!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (invoice_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please contact your developers!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (discount > 0) {
                total = total - discount;
                balance = payment - total;

                try {

                    MySQL.executeIUD("UPDATE `invoice` SET `paid_amount`='" + payment + "',`discount`='" + discount + "' "
                            + "WHERE `invo`='" + invoice_id + "'");
                    JOptionPane.showMessageDialog(this, "Paid!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    resetP();
                    resetIn();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                balance = payment - total;
                try {

                    MySQL.executeIUD("UPDATE `invoice` SET `paid_amount`='" + payment + "',`discount`='" + discount + "' "
                            + "WHERE `invo`='" + invoice_id + "'");
                    JOptionPane.showMessageDialog(this, "Paid!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    resetP();
                    resetIn();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }//GEN-LAST:event_payBillActionPerformed

    private void payFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payFieldKeyReleased
//        double discount = Double.parseDouble(discField.getText());
//        double payment = Double.parseDouble(payField.getText());
//        double balence = 0;
//        String invoice_id = inIdLable.getText();
//
//        total = total - discount;
//        balence = payment - total;

        calculate();


    }//GEN-LAST:event_payFieldKeyReleased

    private void discFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discFieldKeyReleased
        calculate();
    }//GEN-LAST:event_discFieldKeyReleased

    private void pMComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pMComboItemStateChanged
        calculate();
    }//GEN-LAST:event_pMComboItemStateChanged

    private void qtyFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyFieldKeyPressed
        qtyField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cusMobField.grabFocus();
            }

        });


    }//GEN-LAST:event_qtyFieldKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInvoice;
    private javax.swing.JFormattedTextField balField;
    private javax.swing.JLabel brLable;
    private javax.swing.JTextField cusMobField;
    private javax.swing.JFormattedTextField discField;
    private javax.swing.JLabel emName;
    private javax.swing.JLabel inIdLable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> pMCombo;
    private javax.swing.JLabel pName;
    private javax.swing.JButton payBill;
    private javax.swing.JFormattedTextField payField;
    private javax.swing.JLabel proIdLable;
    private javax.swing.JFormattedTextField qtyField;
    private javax.swing.JButton seleStock;
    private javax.swing.JFormattedTextField sellPFild;
    private javax.swing.JLabel stkLable;
    private javax.swing.JFormattedTextField totField;
    // End of variables declaration//GEN-END:variables

    private void resetIn() {
        qtyField.setText("0");
        cusMobField.setText("");
        stkLable.setText(".............................................");
        brLable.setText(".................................");
        sellPFild.setText("");
        pName.setText("Product Name");
        qtyField.grabFocus();
    }

    private void resetP() {
        totField.setText("0.00");
        discField.setText("0.00");
        pMCombo.setSelectedItem("Cash");
        payField.setText("0.00");
        balField.setText("0.00");
    }
}
