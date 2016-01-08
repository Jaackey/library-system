/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.reader;

import business.book.Book;
import business.library.Library;
import business.qrcode.MyQRCodeImage;
import business.runnable.PopularBookRunnable;
import business.system.LibSystem;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import jp.sourceforge.qrcode.QRCodeDecoder;

/**
 *
 * @author Jackey
 */
public class ReaderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private LibSystem system;
    
    /**
     * Creates new form ReaderJPanel
     */
    public ReaderJPanel() {
        initComponents();
    }

    public ReaderJPanel(JPanel userProcessContainer, UserAccount account, LibSystem system) {
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.system = system;
        initComponents();
        nameText.setText(account.getPerson().getName());
        populatePopular();
        populateCombo();
        creditText.setText(String.valueOf(account.getPerson().getCredit()));
        System.out.println("-------Credit: " + account.getPerson().getCredit());
        if(account.getPerson().isIsVip()){
            vipText.setText("VIP");
            vipText.setForeground(Color.red);
        }
    }

    public void populatePopular(){
        PopularBookRunnable pbr = new PopularBookRunnable(system);
        Thread t1 = new Thread(pbr);
        t1.start();
        try {
                t1.join();
            } catch (InterruptedException ex) {
                System.out.println("JOIN ERROR");
        }
        //System.out.println("~~~+++~~~" + system.getPopularBookList());
        DefaultTableModel model = (DefaultTableModel) bookTable.getModel();       
        model.setRowCount(0);
        for(Book book : system.getPopularBookList()){
            //System.out.println("~~~~~~~" + book.getName());
                Object[] row = new Object[6];
                row[0] = book;
                row[1] = book.getAuthor();
                row[2] = book.getPress();
                row[3] = book.getDate();
                row[4] = book.getLibrary();
                row[5] = book.getPopularity();
                model.addRow(row);
        }
    }
    
    public void populateCombo(){
        searchCombo.removeAllItems();
        searchCombo.addItem("Name");
        searchCombo.addItem("Author");
        searchCombo.addItem("Press");
    }
    
    public void searchName(String name){
        DefaultTableModel model = (DefaultTableModel) bookTable.getModel();       
        model.setRowCount(0);
        for(Library library : system.getLibraryList()){
            for(Book book : library.getBookCatalog().getBookList()){
                int a = book.getName().indexOf(name);
                if(a >= 0){
                    Object[] row = new Object[6];
                    row[0] = book;
                    row[1] = book.getAuthor();
                    row[2] = book.getPress();
                    row[3] = book.getDate();
                    row[4] = library;
                    row[5] = book.getPopularity();
                    model.addRow(row);
                }
            }
        }
    }
    
    public void searchAuthor(String author){
        DefaultTableModel model = (DefaultTableModel) bookTable.getModel();       
        model.setRowCount(0);
        for(Library library : system.getLibraryList()){
            for(Book book : library.getBookCatalog().getBookList()){
                int a = book.getAuthor().indexOf(author);
                if(a >= 0){
                    Object[] row = new Object[6];
                    row[0] = book;
                    row[1] = book.getAuthor();
                    row[2] = book.getPress();
                    row[3] = book.getDate();
                    row[4] = library;
                    row[5] = book.getPopularity();
                    model.addRow(row);
                }
            }
        }
    }
    
    public void searchPress(String press){
        DefaultTableModel model = (DefaultTableModel) bookTable.getModel();       
        model.setRowCount(0);
        for(Library library : system.getLibraryList()){
            for(Book book : library.getBookCatalog().getBookList()){
                int a = book.getPress().indexOf(press);
                if(a >= 0){
                    Object[] row = new Object[6];
                    row[0] = book;
                    row[1] = book.getAuthor();
                    row[2] = book.getPress();
                    row[3] = book.getDate();
                    row[4] = library;
                    row[5] = book.getPopularity();
                    model.addRow(row);
                }
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        profileBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        tableTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchCombo = new javax.swing.JComboBox();
        searchText = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        viewBookBtn = new javax.swing.JButton();
        recordBtn = new javax.swing.JButton();
        vipText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        creditText = new javax.swing.JTextField();
        findQRBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Hello,");

        nameText.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        nameText.setEnabled(false);

        profileBtn.setText("Edit Profile");
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Name", "Author", "Press", "Publish Date", "Library", "Lent Times"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(bookTable);

        tableTitle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        tableTitle.setText("Popular Books:");

        jLabel3.setText("Search Book with:");

        searchCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        viewBookBtn.setText("View This Book");
        viewBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBookBtnActionPerformed(evt);
            }
        });

        recordBtn.setText("View My Record");
        recordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordBtnActionPerformed(evt);
            }
        });

        vipText.setText("not VIP");

        jLabel2.setText("Credit:");

        creditText.setEnabled(false);

        findQRBtn.setText("Search With QR Code");
        findQRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findQRBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profileBtn)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creditText, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vipText)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tableTitle)
                        .addGap(18, 18, 18)
                        .addComponent(findQRBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(recordBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewBookBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profileBtn)
                    .addComponent(vipText)
                    .addComponent(jLabel2)
                    .addComponent(creditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tableTitle)
                    .addComponent(recordBtn)
                    .addComponent(findQRBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(viewBookBtn))
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        // TODO add your handling code here:
        EditProfileJPanel epjp = new EditProfileJPanel(userProcessContainer, account, system);
        userProcessContainer.add("EditProfileJPanel", epjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_profileBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        String searchBy = (String)searchCombo.getSelectedItem();
        String searchFor = searchText.getText();
        if(searchBy.equals("Name")){
            searchName(searchFor);
        }
        if(searchBy.equals("Author")){
            searchAuthor(searchFor);
        }
        if(searchBy.equals("Press")){
            searchPress(searchFor);
        }
        tableTitle.setText("Search Result");
    }//GEN-LAST:event_searchBtnActionPerformed

    private void viewBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBookBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = bookTable.getSelectedRow();
        if(selectedRow >= 0){
            Book book = (Book)bookTable.getValueAt(selectedRow, 0);
            Library library = (Library)bookTable.getValueAt(selectedRow, 4);
            ViewBookJPanel vbjp = new ViewBookJPanel(userProcessContainer, system, library, book);
            userProcessContainer.add("ViewBookJPanel", vbjp);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select a Book!");
            return;
        }
    }//GEN-LAST:event_viewBookBtnActionPerformed

    private void recordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordBtnActionPerformed
        // TODO add your handling code here:
        ViewRecordJPanel vrjp = new ViewRecordJPanel(userProcessContainer, system, account);
        userProcessContainer.add("ViewRecordJPanel", vrjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_recordBtnActionPerformed

    private void findQRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findQRBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser fd = new JFileChooser();
	fd.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	fd.showOpenDialog(null);
	File f = fd.getSelectedFile();
	if(f != null){
            QRCodeDecoder decoder = new QRCodeDecoder();
            BufferedImage image = null;
            try {
                image = ImageIO.read(f);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            String decodedData = new String(decoder.decode(new MyQRCodeImage(image)));
            System.out.println(decodedData);
            decodedData = decodedData.replace("Book Name: ", "");
            //System.out.println("+++" + decodedData);
            int a = decodedData.indexOf("Author: ");
            //System.out.println("+++" + a);
            decodedData = decodedData.substring(0, a);
            //System.out.println("+++" + decodedData);
            Pattern p = Pattern.compile("\\n");
            Matcher m = p.matcher(decodedData);
            decodedData = m.replaceAll("");
            searchName(decodedData);
            tableTitle.setText("Search Result");
        }
    }//GEN-LAST:event_findQRBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookTable;
    private javax.swing.JTextField creditText;
    private javax.swing.JButton findQRBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton profileBtn;
    private javax.swing.JButton recordBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JComboBox searchCombo;
    private javax.swing.JTextField searchText;
    private javax.swing.JLabel tableTitle;
    private javax.swing.JButton viewBookBtn;
    private javax.swing.JLabel vipText;
    // End of variables declaration//GEN-END:variables
}
