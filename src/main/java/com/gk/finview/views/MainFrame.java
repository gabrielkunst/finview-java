/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.com.gk.finview.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

import main.java.com.gk.finview.controllers.*;
import main.java.com.gk.finview.factories.*;
import main.java.com.gk.finview.lib.DB;
import main.java.com.gk.finview.models.*;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;


public class MainFrame extends javax.swing.JFrame {
    private User loggedUser;
    private Category selectedCategory;
    private Transaction selectedTransaction;

    public MainFrame() {
        initComponents();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
        LoginView.setVisible(true);
        RegisterView.setVisible(false);
        TransactionsView.setVisible(false);
        CategoriesView.setVisible(false);
        
        MenuTools.setVisible(false);
        MenuLogout.setVisible(false);   
       
        LoginView.requestFocus();   
    }

    private void DoLogin(User user) {
        this.loggedUser = user;

        LoginView.setVisible(false);
        RegisterView.setVisible(false);
        CategoriesView.setVisible(false);
        TransactionsView.setVisible(true);

        MenuRegister.setVisible(false);
        MenuLogin.setVisible(false);
        MenuTools.setVisible(true);
        MenuLogout.setVisible(true);
        
        loadTransactionsTable();
        loadTransactionsPaymentMethods();
        loadTransactionsCategories();
        loadTransactionsTypes();
        loadCategoriesTable();
    }

    private void DoLogout() {
        TransactionsView.setVisible(false);
        RegisterView.setVisible(false);
        CategoriesView.setVisible(false);
        LoginView.setVisible(true);

        MenuTools.setVisible(false);
        MenuLogout.setVisible(false);
        MenuRegister.setVisible(true);
        MenuLogin.setVisible(true);

        LoginView.requestFocus();

        this.loggedUser = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPane = new javax.swing.JDesktopPane();
        RegisterView = new javax.swing.JInternalFrame();
        RegisterViewPanel = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        RegisterNameInput = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        RegisterEmailInput = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        RegisterCPFInput = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        RegisterPasswordInput = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        RegisterZipcodeInput = new javax.swing.JFormattedTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        RegisterStreetInput = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        RegisterNeighborhoodInput = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        RegisterCityInput = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        RegisterStateInput = new javax.swing.JTextField();
        RegisterSubmitBtn = new javax.swing.JButton();
        LoginView = new javax.swing.JInternalFrame();
        LoginViewPanel = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        LoginEmailInput = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        LoginPasswordInput = new javax.swing.JPasswordField();
        LoginSubmitBtn = new javax.swing.JButton();
        TransactionsView = new javax.swing.JInternalFrame();
        TransactionsViewPanel = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TransactionsTransactionNameInput = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TransactionsTransactionAmountInput = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        TransactionsTransactionMethodSelect = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TransactionsTransactionDescriptionInput = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        TransactionsTransactionTypeSelect = new javax.swing.JComboBox<>();
        jPanel25 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        TransactionsTransactionCategorySelect = new javax.swing.JComboBox<>();
        TransactionResetBtn = new javax.swing.JButton();
        TransactionSubmitBtn = new javax.swing.JButton();
        TransactionDeleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TransactionsTable = new javax.swing.JTable();
        CategoriesView = new javax.swing.JInternalFrame();
        CategoriesViewPanel = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        categoryNameInput = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        categoryColorInput = new javax.swing.JTextField();
        CategoryCancelBtn = new javax.swing.JButton();
        CategorySubmitBtn = new javax.swing.JButton();
        categoryDeleteBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CategoriesTable = new javax.swing.JTable();
        Menu = new javax.swing.JMenuBar();
        MenuRegister = new javax.swing.JMenu();
        MenuLogin = new javax.swing.JMenu();
        MenuTools = new javax.swing.JMenu();
        MenuTools1 = new javax.swing.JMenuItem();
        MenuTools2 = new javax.swing.JMenuItem();
        MenuLogout = new javax.swing.JMenu();
        MenuExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Gastos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        DesktopPane.setPreferredSize(new java.awt.Dimension(1920, 1080));

        RegisterView.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        RegisterView.setTitle("Cadastro");
        RegisterView.setVisible(true);

        jPanel3.setLayout(new java.awt.GridLayout(5, 1));

        jLabel5.setText("Nome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterNameInput))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel1);

        jLabel6.setText("Email");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterEmailInput, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4);

        jLabel7.setText("CPF");

        try {
            RegisterCPFInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterCPFInput, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RegisterCPFInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel5);

        jLabel8.setText("Senha");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterPasswordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel6);

        jLabel9.setText("CEP");

        try {
            RegisterZipcodeInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterZipcodeInput, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterZipcodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel7);

        jLabel10.setText("Endereço");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterStreetInput, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterStreetInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel8);

        jLabel11.setText("Bairro");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterNeighborhoodInput, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterNeighborhoodInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel9);

        jLabel12.setText("Cidade");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterCityInput, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterCityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel10);

        jLabel15.setText("UF");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterStateInput, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterStateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel13);

        RegisterSubmitBtn.setText("Registrar");
        RegisterSubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterSubmitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RegisterSubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(RegisterSubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RegisterViewPanelLayout = new javax.swing.GroupLayout(RegisterViewPanel);
        RegisterViewPanel.setLayout(RegisterViewPanelLayout);
        RegisterViewPanelLayout.setHorizontalGroup(
            RegisterViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterViewPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        RegisterViewPanelLayout.setVerticalGroup(
            RegisterViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterViewPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout RegisterViewLayout = new javax.swing.GroupLayout(RegisterView.getContentPane());
        RegisterView.getContentPane().setLayout(RegisterViewLayout);
        RegisterViewLayout.setHorizontalGroup(
            RegisterViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
            .addGroup(RegisterViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RegisterViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(RegisterViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        RegisterViewLayout.setVerticalGroup(
            RegisterViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
            .addGroup(RegisterViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RegisterViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(RegisterViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        LoginView.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        LoginView.setTitle("Entrar");
        LoginView.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LoginView.setVisible(true);

        jPanel11.setLayout(new java.awt.GridLayout(2, 1));

        jLabel14.setText("Email");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoginEmailInput, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.add(jPanel12);

        jLabel17.setText("Senha");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoginPasswordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.add(jPanel19);

        LoginSubmitBtn.setText("Entrar");
        LoginSubmitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginSubmitBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LoginSubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(LoginSubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LoginViewPanelLayout = new javax.swing.GroupLayout(LoginViewPanel);
        LoginViewPanel.setLayout(LoginViewPanelLayout);
        LoginViewPanelLayout.setHorizontalGroup(
            LoginViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginViewPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        LoginViewPanelLayout.setVerticalGroup(
            LoginViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginViewPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout LoginViewLayout = new javax.swing.GroupLayout(LoginView.getContentPane());
        LoginView.getContentPane().setLayout(LoginViewLayout);
        LoginViewLayout.setHorizontalGroup(
            LoginViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
            .addGroup(LoginViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LoginViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LoginViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        LoginViewLayout.setVerticalGroup(
            LoginViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
            .addGroup(LoginViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LoginViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LoginViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        TransactionsView.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        TransactionsView.setTitle("Transações");
        TransactionsView.setVisible(true);

        jPanel2.setLayout(new java.awt.GridLayout(2, 0, 12, 12));

        jLabel1.setText("Nome da transação");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(TransactionsTransactionNameInput))
                .addGap(0, 0, 0))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransactionsTransactionNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.add(jPanel20);

        jPanel21.setLayout(new java.awt.GridLayout(1, 0, 12, 12));

        jLabel4.setText("Valor");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TransactionsTransactionAmountInput, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransactionsTransactionAmountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel21.add(jPanel26);

        jLabel18.setText("Pagamento");

        TransactionsTransactionMethodSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crédito", "Débito" }));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TransactionsTransactionMethodSelect, 0, 229, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TransactionsTransactionMethodSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel21.add(jPanel27);

        jPanel2.add(jPanel21);

        jLabel3.setText("Descrição");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(TransactionsTransactionDescriptionInput))
                .addGap(0, 0, 0))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransactionsTransactionDescriptionInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.add(jPanel22);

        jPanel23.setLayout(new java.awt.GridLayout(1, 0, 12, 12));

        jLabel13.setText("Tipo");

        TransactionsTransactionTypeSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saida" }));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TransactionsTransactionTypeSelect, 0, 229, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TransactionsTransactionTypeSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel23.add(jPanel24);

        jLabel16.setText("Categoria");

        TransactionsTransactionCategorySelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimentação", "Saúde" }));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TransactionsTransactionCategorySelect, 0, 229, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TransactionsTransactionCategorySelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel23.add(jPanel25);

        jPanel2.add(jPanel23);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        TransactionResetBtn.setText("Limpar");
        TransactionResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionResetBtnActionPerformed(evt);
            }
        });

        TransactionSubmitBtn.setText("Salvar");
        TransactionSubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionSubmitBtnActionPerformed(evt);
            }
        });

        TransactionDeleteBtn.setText("Excluir");
        TransactionDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionDeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TransactionSubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(TransactionResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(TransactionDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TransactionResetBtn)
                        .addComponent(TransactionSubmitBtn))
                    .addComponent(TransactionDeleteBtn))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        TransactionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Valor", "Pagamento", "Tipo", "Categoria", "Criado em"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TransactionsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransactionsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TransactionsTable);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout TransactionsViewPanelLayout = new javax.swing.GroupLayout(TransactionsViewPanel);
        TransactionsViewPanel.setLayout(TransactionsViewPanelLayout);
        TransactionsViewPanelLayout.setHorizontalGroup(
            TransactionsViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionsViewPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        TransactionsViewPanelLayout.setVerticalGroup(
            TransactionsViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionsViewPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout TransactionsViewLayout = new javax.swing.GroupLayout(TransactionsView.getContentPane());
        TransactionsView.getContentPane().setLayout(TransactionsViewLayout);
        TransactionsViewLayout.setHorizontalGroup(
            TransactionsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1059, Short.MAX_VALUE)
            .addGroup(TransactionsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TransactionsViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TransactionsViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        TransactionsViewLayout.setVerticalGroup(
            TransactionsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
            .addGroup(TransactionsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TransactionsViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TransactionsViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        CategoriesView.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        CategoriesView.setTitle("Categorias");
        CategoriesView.setVisible(true);

        jPanel39.setLayout(new java.awt.GridLayout(1, 0, 12, 12));

        jLabel2.setText("Nome da categoria");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(categoryNameInput))
                .addGap(0, 0, 0))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel39.add(jPanel40);

        jPanel41.setLayout(new java.awt.GridLayout(1, 0, 12, 12));

        jLabel22.setText("Cor");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(categoryColorInput, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryColorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel41.add(jPanel42);

        jPanel39.add(jPanel41);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        CategoryCancelBtn.setText("Cancelar");
        CategoryCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryCancelBtnActionPerformed(evt);
            }
        });

        CategorySubmitBtn.setText("Salvar");
        CategorySubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorySubmitBtnActionPerformed(evt);
            }
        });

        categoryDeleteBtn.setText("Excluir");
        categoryDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryDeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CategorySubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(CategoryCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(categoryDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CategoryCancelBtn)
                        .addComponent(CategorySubmitBtn))
                    .addComponent(categoryDeleteBtn))
                .addContainerGap())
        );

        CategoriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Cor", "Criado em"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CategoriesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoriesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CategoriesTable);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout CategoriesViewPanelLayout = new javax.swing.GroupLayout(CategoriesViewPanel);
        CategoriesViewPanel.setLayout(CategoriesViewPanelLayout);
        CategoriesViewPanelLayout.setHorizontalGroup(
            CategoriesViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoriesViewPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        CategoriesViewPanelLayout.setVerticalGroup(
            CategoriesViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoriesViewPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CategoriesViewLayout = new javax.swing.GroupLayout(CategoriesView.getContentPane());
        CategoriesView.getContentPane().setLayout(CategoriesViewLayout);
        CategoriesViewLayout.setHorizontalGroup(
            CategoriesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
            .addGroup(CategoriesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CategoriesViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CategoriesViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        CategoriesViewLayout.setVerticalGroup(
            CategoriesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(CategoriesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CategoriesViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CategoriesViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        DesktopPane.setLayer(RegisterView, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(LoginView, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(TransactionsView, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(CategoriesView, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneLayout.createSequentialGroup()
                .addContainerGap(595, Short.MAX_VALUE)
                .addComponent(RegisterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(596, Short.MAX_VALUE))
            .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopPaneLayout.createSequentialGroup()
                    .addContainerGap(677, Short.MAX_VALUE)
                    .addComponent(LoginView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(677, Short.MAX_VALUE)))
            .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DesktopPaneLayout.createSequentialGroup()
                    .addContainerGap(424, Short.MAX_VALUE)
                    .addComponent(TransactionsView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(425, Short.MAX_VALUE)))
            .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopPaneLayout.createSequentialGroup()
                    .addContainerGap(602, Short.MAX_VALUE)
                    .addComponent(CategoriesView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(603, Short.MAX_VALUE)))
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopPaneLayout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(RegisterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
            .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopPaneLayout.createSequentialGroup()
                    .addContainerGap(374, Short.MAX_VALUE)
                    .addComponent(LoginView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(375, Short.MAX_VALUE)))
            .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DesktopPaneLayout.createSequentialGroup()
                    .addContainerGap(217, Short.MAX_VALUE)
                    .addComponent(TransactionsView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(217, Short.MAX_VALUE)))
            .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopPaneLayout.createSequentialGroup()
                    .addContainerGap(245, Short.MAX_VALUE)
                    .addComponent(CategoriesView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(245, Short.MAX_VALUE)))
        );

        getContentPane().add(DesktopPane);

        MenuRegister.setText("Cadastrar");
        MenuRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuRegisterMouseClicked(evt);
            }
        });
        Menu.add(MenuRegister);

        MenuLogin.setText("Entrar");
        MenuLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuLoginMouseClicked(evt);
            }
        });
        Menu.add(MenuLogin);

        MenuTools.setText("Ferramentas");

        MenuTools1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MenuTools1.setText("Transações");
        MenuTools1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTools1ActionPerformed(evt);
            }
        });
        MenuTools.add(MenuTools1);

        MenuTools2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MenuTools2.setText("Categorias");
        MenuTools2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTools2ActionPerformed(evt);
            }
        });
        MenuTools.add(MenuTools2);

        Menu.add(MenuTools);

        MenuLogout.setText("Trocar Usuário");
        MenuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuLogoutMouseClicked(evt);
            }
        });
        Menu.add(MenuLogout);

        MenuExit.setText("Fechar");
        MenuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuExitMouseClicked(evt);
            }
        });
        Menu.add(MenuExit);

        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuExitMouseClicked
        int input = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja sair?");

        if (input != 0) {
            return;
        }

        System.exit(0);
    }//GEN-LAST:event_MenuExitMouseClicked

    private boolean validateEmail(String email) {
        String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void LoginSubmitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginSubmitBtnMouseClicked
        try {
            String email = LoginEmailInput.getText().trim();
            String password = LoginPasswordInput.getText().trim();

            if (email.isEmpty() || password.isEmpty()) {
                throw new RuntimeException("Ops! Email e senha são campos obrigatórios.");
            }
            
            if (!validateEmail(email)) {
                throw new RuntimeException("Ops! Email inválido.");
            }
            
            Connection connection = DB.getConnection();
            
            UserController userController = UserControllerFactory.createUserController(connection);
            User userWithSameEmail = userController.getUserByEmail(email);
            
            String passwordHash = password;
                        
            if (!passwordHash.equals(userWithSameEmail.getPasswordHash())) {
                throw new RuntimeException("Ops! Credenciais inválidas.");
            }   
                        
            JOptionPane.showMessageDialog(null, "Login feito com sucesso.");
            this.DoLogin(userWithSameEmail);

            LoginPasswordInput.setText("");
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }//GEN-LAST:event_LoginSubmitBtnMouseClicked

    private void MenuRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuRegisterMouseClicked
        LoginView.setVisible(false);
        RegisterView.setVisible(true);

        RegisterView.requestFocus();

        LoginPasswordInput.setText("");
        LoginEmailInput.setText("");
    }//GEN-LAST:event_MenuRegisterMouseClicked

    private void MenuLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuLoginMouseClicked
        LoginView.setVisible(true);
        RegisterView.setVisible(false);

        LoginView.requestFocus();

        RegisterNameInput.setText("");
        RegisterEmailInput.setText("");
        RegisterCPFInput.setText("");
        RegisterZipcodeInput.setText("");
        RegisterStreetInput.setText("");
        RegisterNeighborhoodInput.setText("");
        RegisterPasswordInput.setText("");
        RegisterCityInput.setText("");
        RegisterStateInput.setText("");
    }//GEN-LAST:event_MenuLoginMouseClicked

    private void MenuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuLogoutMouseClicked
        this.DoLogout();
    }//GEN-LAST:event_MenuLogoutMouseClicked

    private void MenuTools2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTools2ActionPerformed
        clearCategoryForm();

        CategoriesView.setVisible(true);
        TransactionsView.setVisible(false);

        CategoriesView.requestFocus();

        loadCategoriesTable();
    }//GEN-LAST:event_MenuTools2ActionPerformed

    private void MenuTools1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTools1ActionPerformed
        clearTransactionForm();

        CategoriesView.setVisible(false);
        TransactionsView.setVisible(true);

        TransactionsView.requestFocus();

        loadTransactionsTable();
        loadTransactionsCategories();
    }//GEN-LAST:event_MenuTools1ActionPerformed

    private void RegisterSubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterSubmitBtnActionPerformed
            try {
                String name = RegisterNameInput.getText().trim();
                String email = RegisterEmailInput.getText().trim();
                String cpf = RegisterCPFInput.getText().trim();
                String zipcode = RegisterZipcodeInput.getText().trim();
                String street = RegisterStreetInput.getText().trim();
                String neighborhood = RegisterNeighborhoodInput.getText().trim();
                String city = RegisterCityInput.getText().trim();
                String state = RegisterStateInput.getText().trim();
                String password = RegisterPasswordInput.getText().trim();
                
                if (name.isEmpty() || email.isEmpty() || cpf.isEmpty() || zipcode.isEmpty() || street.isEmpty() || neighborhood.isEmpty() || city.isEmpty() || state.isEmpty() || password.isEmpty()) {
                    throw new RuntimeException("Ops! Todos os campos são obrigatórios.");
                }
                
                if (!validateEmail(email)) {
                    throw new RuntimeException("Ops! Email inválido.");
                }
                
                if (password.length() < 6) {
                    throw new RuntimeException("Ops! A senhha precisa ter no mínimo 6 caracteres");
                }

                Connection connection = DB.getConnection();
                UserController userController = UserControllerFactory.createUserController(connection);
                AddressController addressController = AddressControllerFactory.createAddressController(connection);

                User newUser = new User();
                Address newAddress = new Address();

                newAddress.setNeighborhood(neighborhood);
                newAddress.setZipcode(zipcode);
                newAddress.setCity(city);
                newAddress.setStreet(street);
                newAddress.setState(state);

                newUser.setName(name);
                newUser.setCpf(cpf);
                newUser.setEmail(email);
                newUser.setRoleId(2);
                newUser.setPasswordHash(password);

                Address createdAddress = addressController.createAddress(newAddress);
                newUser.setAddressId(createdAddress.getId());
                
                User createdUser = userController.createUser(newUser);

                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.");
                this.DoLogin(createdUser);

                RegisterNameInput.setText("");
                RegisterEmailInput.setText("");
                RegisterCPFInput.setText("");
                RegisterZipcodeInput.setText("");
                RegisterStreetInput.setText("");
                RegisterNeighborhoodInput.setText("");
                RegisterPasswordInput.setText("");
                RegisterCityInput.setText("");
                RegisterStateInput.setText("");
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
    }//GEN-LAST:event_RegisterSubmitBtnActionPerformed

    private void loadTransactionsCategories() {
        try {
            Connection connection = DB.getConnection();
            CategoryController categoryController = CategoryControllerFactory.createCategoryController(connection);

            List<Category> categories = categoryController.getBaseCategories(loggedUser.getId());

            DefaultComboBoxModel model = (DefaultComboBoxModel) TransactionsTransactionCategorySelect.getModel();

            model.removeAllElements();

            for (Category category : categories) {
                model.addElement(category.getName());
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }

    private void loadTransactionsTypes() {
        try {
            Connection connection = DB.getConnection();
            TransactionTypeController transactionTypeController = TransactionTypeControllerFactory.createTransactionTypeController(connection);

            List<TransactionType> transactionTypes = transactionTypeController.getTransactionTypes();

            DefaultComboBoxModel model = (DefaultComboBoxModel) TransactionsTransactionTypeSelect.getModel();

            model.removeAllElements();

            for (TransactionType transactionType : transactionTypes) {
                model.addElement(transactionType.getName());
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }

    private void loadTransactionsTable() {
        try {
            Connection connection = DB.getConnection();
            TransactionController transactionController = TransactionControllerFactory.createTransactionController(connection);

            List<Transaction> transactions = transactionController.getTransactionsByUserId(loggedUser.getId());

            DefaultTableModel model = (DefaultTableModel) TransactionsTable.getModel();

            while (model.getRowCount() > 0) {
                model.getDataVector().removeAllElements();
            }

            for (Transaction transaction : transactions) {
                Vector row = new Vector();
                row.add(transaction.getId());
                row.add(transaction.getName());
                row.add(transaction.getAmount());
                row.add(transaction.getPaymentMethodId());
                row.add(transaction.getTransactionTypeId());
                row.add(transaction.getCategoryId());
                row.add(transaction.getCreatedAt().toString());
               
                model.addRow(row);
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }

    private void loadTransactionsPaymentMethods() {
        try {
            Connection connection = DB.getConnection();
            PaymentMethodController paymentMethodController = PaymentMethodControllerFactory.createPaymentMethodController(connection);

            List<PaymentMethod> paymentMethods = paymentMethodController.getPaymentMethods();

            DefaultComboBoxModel model = (DefaultComboBoxModel) TransactionsTransactionMethodSelect.getModel();

            model.removeAllElements();

            for (PaymentMethod paymentMethod : paymentMethods) {
                model.addElement(paymentMethod.getName());
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    private void TransactionSubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionSubmitBtnActionPerformed
        try {
            String name = TransactionsTransactionNameInput.getText().trim();
            String description = TransactionsTransactionDescriptionInput.getText().trim();
            String amount = TransactionsTransactionAmountInput.getText().trim();
            int paymentMethodId = TransactionsTransactionMethodSelect.getSelectedIndex() + 1;
            int paymentTypeId = TransactionsTransactionTypeSelect.getSelectedIndex() + 1;
           
            
            if (name.isEmpty() || amount.isEmpty()) {
                throw new RuntimeException("Ops! Nome da transação e o valor são obrigatórios.");
            }
            
            Transaction transaction = new Transaction();

            
            try {
                Double amountAsDouble = Double.parseDouble(amount);
                transaction.setAmount(amountAsDouble);
            } catch (NumberFormatException error) {
                throw new RuntimeException("Ops! O valor não é um número válido.");
            }
            
            
            transaction.setAmount(Float.parseFloat(amount));
            transaction.setName(name);
            transaction.setDescription(description.isEmpty() ? null : description);
            transaction.setCategoryId(2);
            transaction.setCreatedBy(loggedUser.getId());
            transaction.setPaidAt(new Date());
            transaction.setPaymentMethodId(paymentMethodId);
            transaction.setTransactionTypeId(paymentTypeId);
            
            Connection connection = DB.getConnection();
            TransactionController transactionController = TransactionControllerFactory.createTransactionController(connection);
            
            if (this.selectedTransaction != null) {
                transaction.setId(this.selectedTransaction.getId());
                transactionController.updateTransaction(transaction);
            } else {
                transactionController.createTransaction(transaction);
            }

            this.clearTransactionForm();
            loadTransactionsTable();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }//GEN-LAST:event_TransactionSubmitBtnActionPerformed

    private void loadCategoriesTable() {
      try {
            Connection connection = DB.getConnection();
            CategoryController categoryController = CategoryControllerFactory.createCategoryController(connection);

            List<Category> categories = categoryController.getCategoriesByUserId(loggedUser.getId());
            
            DefaultTableModel model = (DefaultTableModel) CategoriesTable.getModel();

            while (model.getRowCount() > 0) {
                model.getDataVector().removeAllElements();
            }

            for (Category category : categories) {
                Vector row = new Vector();
                row.add(category.getId());
                row.add(category.getName());
                row.add(category.getColor().isEmpty() ? "Sem cor" : category.getColor());
                row.add(category.getCreatedAt().toString());
               
                model.addRow(row);
            }
  
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    private void CategorySubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorySubmitBtnActionPerformed
        try {
            String categoryName = categoryNameInput.getText().trim();
            String categoryColor = categoryColorInput.getText().trim();

            if (categoryName.isEmpty()) {
                throw new RuntimeException("Ops! Nome da categoria é obrigatório.");
            }

            Category category = new Category();
            category.setName(categoryName);
            category.setColor(categoryColor);
            category.setCreatedBy(loggedUser.getId());
            
            Connection connection = DB.getConnection();
            CategoryController categoryController = CategoryControllerFactory.createCategoryController(connection);

            if (this.selectedCategory != null) {
                category.setId(this.selectedCategory.getId());
                categoryController.updateCategory(category);
            } else {
                categoryController.createCategory(category);
            }

            this.clearCategoryForm();
            loadCategoriesTable();
        } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }//GEN-LAST:event_CategorySubmitBtnActionPerformed

    private void clearCategoryForm() {
        categoryNameInput.setText("");
        categoryColorInput.setText("");

        this.selectedCategory = null;
    }


    private void CategoryCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryCancelBtnActionPerformed
        this.clearCategoryForm();
    }//GEN-LAST:event_CategoryCancelBtnActionPerformed

    private void clearTransactionForm() {
        TransactionsTransactionNameInput.setText("");
        TransactionsTransactionDescriptionInput.setText("");
        TransactionsTransactionAmountInput.setText("");
        TransactionsTransactionCategorySelect.setSelectedIndex(0);
        TransactionsTransactionMethodSelect.setSelectedIndex(0);
        TransactionsTransactionTypeSelect.setSelectedIndex(0);

        this.selectedTransaction = null;
    }


    private void TransactionResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionResetBtnActionPerformed
        this.clearTransactionForm();
    }//GEN-LAST:event_TransactionResetBtnActionPerformed

    private void TransactionDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionDeleteBtnActionPerformed
        try {
            if (this.selectedTransaction == null) {
                throw new RuntimeException("Ops! Selecione uma transação para excluir.");
            }

            Connection connection = DB.getConnection();
            TransactionController transactionController = TransactionControllerFactory.createTransactionController(connection);
            transactionController.deleteTransactionById(this.selectedTransaction.getId());

            this.clearTransactionForm();
            loadTransactionsTable();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }//GEN-LAST:event_TransactionDeleteBtnActionPerformed

    private void categoryDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryDeleteBtnActionPerformed
        try {
            if (this.selectedCategory == null) {
                throw new RuntimeException("Ops! Selecione uma categoria para excluir.");
            }

            Connection connection = DB.getConnection();
            CategoryController categoryController = CategoryControllerFactory.createCategoryController(connection);
            categoryController.deleteCategoryById(this.selectedCategory.getId());

            this.clearCategoryForm();
            loadCategoriesTable();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }//GEN-LAST:event_categoryDeleteBtnActionPerformed

    private void CategoriesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoriesTableMouseClicked
        int selectedRow =  CategoriesTable.getSelectedRow();

        if (selectedRow == -1) {
            return;
        }

        DefaultTableModel model = (DefaultTableModel) CategoriesTable.getModel();

        int categoryId = (int) model.getValueAt(selectedRow, 0);
        String categoryName = (String) model.getValueAt(selectedRow, 1);
        String categoryColor = (String) model.getValueAt(selectedRow, 2);

        if (categoryColor.equals("Sem cor")) {
            categoryColor = "";
        }

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        category.setColor(categoryColor);
        category.setCreatedBy(loggedUser.getId());

        this.selectedCategory = category;

        System.out.println("Selected category: " + this.selectedCategory);

        categoryNameInput.setText(categoryName);
        categoryColorInput.setText(categoryColor);
    }//GEN-LAST:event_CategoriesTableMouseClicked

    private void TransactionsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionsTableMouseClicked
        int selectedRow = TransactionsTable.getSelectedRow();
        
        if (selectedRow == -1) {
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) TransactionsTable.getModel();
        
        int transactionId = (int) model.getValueAt(selectedRow, 0);
        String transactionName = (String) model.getValueAt(selectedRow, 1);
        Double transactionAmount = (Double) model.getValueAt(selectedRow, 2);
        int transactionPaymentMethodId = (int) model.getValueAt(selectedRow, 3);
        int transactionTypeId = (int) model.getValueAt(selectedRow, 4);
        int transactionCategoryId = (int) model.getValueAt(selectedRow, 5);

        Transaction transaction = new Transaction();
        transaction.setId(transactionId);
        transaction.setName(transactionName);
        transaction.setAmount(transactionAmount);
        transaction.setPaymentMethodId(transactionPaymentMethodId);
        transaction.setTransactionTypeId(transactionTypeId);
        transaction.setCategoryId(transactionCategoryId);

        this.selectedTransaction = transaction;

        TransactionsTransactionNameInput.setText(transactionName);
        TransactionsTransactionAmountInput.setText(transactionAmount.toString());
        TransactionsTransactionMethodSelect.setSelectedIndex(transactionPaymentMethodId - 1);
        TransactionsTransactionTypeSelect.setSelectedIndex(transactionTypeId - 1);
        TransactionsTransactionCategorySelect.setSelectedIndex(transactionCategoryId - 1);
    }//GEN-LAST:event_TransactionsTableMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CategoriesTable;
    private javax.swing.JInternalFrame CategoriesView;
    private javax.swing.JPanel CategoriesViewPanel;
    private javax.swing.JButton CategoryCancelBtn;
    private javax.swing.JButton CategorySubmitBtn;
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JTextField LoginEmailInput;
    private javax.swing.JPasswordField LoginPasswordInput;
    private javax.swing.JButton LoginSubmitBtn;
    private javax.swing.JInternalFrame LoginView;
    private javax.swing.JPanel LoginViewPanel;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu MenuExit;
    private javax.swing.JMenu MenuLogin;
    private javax.swing.JMenu MenuLogout;
    private javax.swing.JMenu MenuRegister;
    private javax.swing.JMenu MenuTools;
    private javax.swing.JMenuItem MenuTools1;
    private javax.swing.JMenuItem MenuTools2;
    private javax.swing.JFormattedTextField RegisterCPFInput;
    private javax.swing.JTextField RegisterCityInput;
    private javax.swing.JTextField RegisterEmailInput;
    private javax.swing.JTextField RegisterNameInput;
    private javax.swing.JTextField RegisterNeighborhoodInput;
    private javax.swing.JPasswordField RegisterPasswordInput;
    private javax.swing.JTextField RegisterStateInput;
    private javax.swing.JTextField RegisterStreetInput;
    private javax.swing.JButton RegisterSubmitBtn;
    private javax.swing.JInternalFrame RegisterView;
    private javax.swing.JPanel RegisterViewPanel;
    private javax.swing.JFormattedTextField RegisterZipcodeInput;
    private javax.swing.JButton TransactionDeleteBtn;
    private javax.swing.JButton TransactionResetBtn;
    private javax.swing.JButton TransactionSubmitBtn;
    private javax.swing.JTable TransactionsTable;
    private javax.swing.JTextField TransactionsTransactionAmountInput;
    private javax.swing.JComboBox<String> TransactionsTransactionCategorySelect;
    private javax.swing.JTextField TransactionsTransactionDescriptionInput;
    private javax.swing.JComboBox<String> TransactionsTransactionMethodSelect;
    private javax.swing.JTextField TransactionsTransactionNameInput;
    private javax.swing.JComboBox<String> TransactionsTransactionTypeSelect;
    private javax.swing.JInternalFrame TransactionsView;
    private javax.swing.JPanel TransactionsViewPanel;
    private javax.swing.JTextField categoryColorInput;
    private javax.swing.JButton categoryDeleteBtn;
    private javax.swing.JTextField categoryNameInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
