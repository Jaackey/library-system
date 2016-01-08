/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.main;

import business.DB4O.DB4OUtil;
import business.library.Library;
import business.organization.Organization;
import business.system.LibSystem;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Jackey
 */
public class MainJFrame extends javax.swing.JFrame {

    private LibSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private final String sysname = "LibrarySystem";
    
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        setSize(1000, 800);
        system = dB4OUtil.retrieveSystem(sysname);
        
        ImageIcon icon = new ImageIcon("pic/titlepic.JPG");
        icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),
        icon.getIconHeight(), Image.SCALE_DEFAULT));
        //System.out.println(icon.getIconHeight() + "" + icon.getIconWidth());
        jlpic.setBounds(0, 0, 850, 700);
        jlpic.setHorizontalAlignment(0);
        jlpic.setIcon(icon);
        
        setLoginIcon("pic/loginBtnPic.JPG", loginBtn);
        setLogoutIcon("pic/logoutBtnPic.JPG", logoutBtn);
        setRegisterIcon("pic/registerBtnPic.JPG", registerBtn);
    }

    public void setLoginIcon(String file, JButton iconButton) {
        ImageIcon icon = new ImageIcon(file);
        iconButton.setBounds(0, 0, 120, 30);
        Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
                        iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
        iconButton.setIcon(icon);
        iconButton.setBackground(new Color(255,255,255));
        iconButton.setBorder(null);
        
    }
    
    public void setLogoutIcon(String file, JButton iconButton) {
        ImageIcon icon = new ImageIcon(file);
        iconButton.setBounds(0, 0, 130, 30);
        Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
                        iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
        iconButton.setIcon(icon);
        iconButton.setBackground(new Color(255,255,255));
        iconButton.setBorder(null);
        
    }
    
    public void setRegisterIcon(String file, JButton iconButton) {
        ImageIcon icon = new ImageIcon(file);
        iconButton.setBounds(0, 0, 130, 30);
        Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
                        iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
        iconButton.setIcon(icon);
        iconButton.setBackground(new Color(255,255,255));
        iconButton.setBorder(null);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        navigate = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        registerBtn = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        titleJPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jlpic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(150);

        jLabel1.setText("User Name:");

        jLabel2.setText("Password:");

        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navigateLayout = new javax.swing.GroupLayout(navigate);
        navigate.setLayout(navigateLayout);
        navigateLayout.setHorizontalGroup(
            navigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigateLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(navigateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navigateLayout.createSequentialGroup()
                        .addGroup(navigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameText)
                            .addComponent(passwordText)
                            .addGroup(navigateLayout.createSequentialGroup()
                                .addGroup(navigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigateLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(navigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14))))
        );
        navigateLayout.setVerticalGroup(
            navigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigateLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(loginBtn)
                .addGap(18, 18, 18)
                .addComponent(logoutBtn)
                .addGap(18, 18, 18)
                .addComponent(registerBtn)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(navigate);

        container.setLayout(new java.awt.CardLayout());

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        titleLabel.setText("Welcome to Library System");

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titleJPanelLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(titleLabel))
                    .addGroup(titleJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlpic)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlpic)
                .addContainerGap(492, Short.MAX_VALUE))
        );

        container.add(titleJPanel, "card2");

        jSplitPane1.setRightComponent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        
        String userName = nameText.getText();
        char[] passwordCharArray = passwordText.getPassword();
        String password = String.valueOf(passwordCharArray);
        
        UserAccount userAccount = system.getUserAccountCatalog().authenticateUser(userName, password);
        Library inlibrary = null;
        Organization inorganization = null;
        
        if (userAccount == null){
            userAccount = system.getOrganizationCatalog().getOrganizationList().get(0).getUserAccountCatalog().authenticateUser(userName, password);
        }
        
        if (userAccount == null) {
            for (Library library : system.getLibraryList()) {
                userAccount = library.getUserAccountCatalog().authenticateUser(userName, password);
                if (userAccount == null) {
                    for (Organization organization : library.getOrganizationCatalog().getOrganizationList()) {
                        userAccount = organization.getUserAccountCatalog().authenticateUser(userName, password);
                        if (userAccount != null) {
                            inlibrary = library;
                            inorganization = organization;
                            break;
                        }
                        if (inorganization != null) {
                        break;
                        }
                    }
                } else {
                    inlibrary = library;
                    break;
                }
                if (inlibrary != null) {
                break;
                }
            }
        }
        
        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid Credentails!");
            return;
        } else {
            CardLayout layout = (CardLayout) container.getLayout();
            container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inorganization, inlibrary, system));
            layout.next(container);
        }
        loginBtn.setEnabled(false);
        logoutBtn.setEnabled(true);
        nameText.setEnabled(false);
        passwordText.setEnabled(false);
        registerBtn.setEnabled(false);
    }//GEN-LAST:event_loginBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        logoutBtn.setEnabled(false);
        nameText.setEnabled(true);
        passwordText.setEnabled(true);
        loginBtn.setEnabled(true);
        registerBtn.setEnabled(true);

        nameText.setText("");
        passwordText.setText("");

        container.removeAll();
        JPanel blankJP = new JPanel();
        container.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        RegisterJPanel rjp = new RegisterJPanel(container, system);
        container.add("RegisterJPanel", rjp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_registerBtnActionPerformed

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
                /*if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/
                //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel jlpic;
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTextField nameText;
    private javax.swing.JPanel navigate;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton registerBtn;
    private javax.swing.JPanel titleJPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
