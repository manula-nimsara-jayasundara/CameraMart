/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Window.Type;
import gui.EmployeeRegistration;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemTray;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.MySQL;
import java.sql.ResultSet;
import raven.toast.ui.ToastNotificationPanel;
import java.util.TimerTask;
import javax.swing.*;
import raven.toast.ToastClientProperties;

/**
 *
 * @author Manula
 */
public class LogIn extends javax.swing.JFrame {

    public static String employeeName;

    ToastNotificationPanel toastNotificationPanel = new ToastNotificationPanel();

    public static String getEmployeeName() {
        return employeeName;
    }

    public static void setEmployeeName(String employeeName) {
        LogIn.employeeName = employeeName;
    }

    public static String employeeEmail;

    public static String getEmployeeEmail() {
        return employeeEmail;
    }

    public static void setEmployeeEmail(String employeeEmail) {
        LogIn.employeeEmail = employeeEmail;
    }

    public static String employeeJob;

    public static String setEmployeeJob() {
        return employeeJob;
    }

//    public class Toast extends JWindow {
//
//        private int duration;
//
//        public Toast(String message, int duration) {
//            this.duration = duration;
//
//            // Create a panel to hold the toast message
//            JPanel panel = new JPanel() {
//                @Override
//                protected void paintComponent(Graphics g) {
//
//                    JLabel label = new JLabel(toastNotificationPanel.getKey(), toastNotificationPanel.getDefaultIcon(), JLabel.CENTER);
//                    label.setVerticalTextPosition(JLabel.BOTTOM);
//                    label.setForeground(toastNotificationPanel.getDefaultColor());
//                    label.setHorizontalTextPosition(JLabel.CENTER);
//                    label.putClientProperty(FlatClientProperties.STYLE, ""
//                            + "font:$Notifications.font;"
//                            + "iconTextGap:0");
//                    toastNotificationPanel.putClientProperty(ToastClientProperties.TOAST_ICON, label);
//                    
//                    
//                    //                    super.paintComponent(g);
//                    //                    // Set a rounded background with semi-transparent color
//                                        g.setColor(new Color(255, 0, 0, 130)); // (R, G, B, Alpha)
//                                        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); // Rounded corners
//                    //
//                    //                    // Add shadow effect
//                                        g.setColor(new Color(255, 0, 0, 100)); // Shadow color
//                                        g.fillRoundRect(5, 5, getWidth(), getHeight(), 10, 10); // Shadow position
//                }
//            };
//
//            // Customize the panel appearance
//            panel.setLayout(new BorderLayout()); // Set layout to BorderLayout
//            panel.setBackground(new Color(255, 0, 0, 0)); // Transparent panel background
//            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding for the text
//
//            // Create the label for the toast message
////        JLabel label = new JLabel(message);
//            JLabel label = new JLabel(toastNotificationPanel.getKey(), toastNotificationPanel.getDefaultIcon(), JLabel.CENTER);
//
//            label.setForeground(Color.WHITE); // Set text color to white
//            label.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Modern font
//            label.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
//            panel.add(label, BorderLayout.CENTER); // Add label to panel
//
//            // Add panel to toast window
//            getContentPane().add(panel);
//            setSize(350, 80); // Set toast size
//            setLocationRelativeTo(null); // Center the toast on screen
//        }
//
//        public void showToast() {
//            setVisible(true); // show the toast
//
//            // Timer to hide the toast after the duration
//            Timer timer = new Timer(duration, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    setVisible(false); // hide the toast
//                    dispose(); // close the window
//                }
//            });
//            timer.setRepeats(false); // ensure the timer only runs once
//            timer.start(); // start the timer
//        }
//    }
    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
        init();
        icon();
    }

    public void icon() {
        ImageIcon logo = new ImageIcon("C:\\Users\\Manula\\Documents\\NetBeansProjects\\Camera_Mart\\src\\images\\camera.png");
//        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("camera.png"));
        this.setIconImage(logo.getImage());
    }

    public void init() {
        jButton1.putClientProperty(FlatClientProperties.STYLE, "arc:999");
        jButton1.setForeground(Color.WHITE);
        jButton2.putClientProperty(FlatClientProperties.STYLE, "arc:999");
//        jButton2.setFont(Color);
        emailField.putClientProperty(FlatClientProperties.STYLE, "arc:999");
        passwordField.putClientProperty(FlatClientProperties.STYLE, "arc:999");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel1 = new lk.CM.cameraMart.component.RoundedPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        roundedPanel2 = new lk.CM.cameraMart.component.RoundedPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Log In");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        roundedPanel1.setPreferredSize(new java.awt.Dimension(300, 100));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Log In");

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel3.setText("Password");

        emailField.setPreferredSize(new java.awt.Dimension(68, 25));

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton1.setText("Log In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Create an Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        passwordField.setPreferredSize(new java.awt.Dimension(68, 25));

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        getContentPane().add(roundedPanel1, java.awt.BorderLayout.LINE_START);

        roundedPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Ravie", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/camera.png"))); // NOI18N
        jLabel11.setText("Camera Mart");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginImg1.png"))); // NOI18N

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel2Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(roundedPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        EmployeeRegistration er = new EmployeeRegistration();
        er.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = emailField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your email", "Warning", JOptionPane.WARNING_MESSAGE);
//            Toast.showToastMessage("Please Enter Your Email", 2000);

//            Toast toast = new Toast("Please Enter Your Email", 2000);
//            toast.showToast();
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {

            JOptionPane.showMessageDialog(this, "Invalid email", "Warning", JOptionPane.WARNING_MESSAGE);
//            Toast.showToastMessage("Invalid Email", 2000);
//            Toast toast = new Toast("Invalid Email", 2000);
//            toast.showToast();

        } else if (password.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please enter your password", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee` INNER JOIN `employee_type` ON "
                        + "`employee`.`employee_type_id`=`employee_type`.`id`"
                        + " WHERE `email` = '" + email + "' AND `password`='" + password + "'");

                if (resultSet.next()) {

                    String fName = resultSet.getString("first_name");
                    String lName = resultSet.getString("last_name");
                    String empName = fName + " " + lName;
                    employeeJob = resultSet.getString("employee_type.name");

                    Home home = new Home(email, fName, lName);
                    home.setVisible(true);
                    this.dispose();

                    setEmployeeEmail(email);
                    setEmployeeName(empName);

                } else {

                    JOptionPane.showMessageDialog(this, "Invalid email or password", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField passwordField;
    private lk.CM.cameraMart.component.RoundedPanel roundedPanel1;
    private lk.CM.cameraMart.component.RoundedPanel roundedPanel2;
    // End of variables declaration//GEN-END:variables
}
