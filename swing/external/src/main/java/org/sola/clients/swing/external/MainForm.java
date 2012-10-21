/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.clients.swing.external;

import java.awt.event.WindowEvent;
import org.sola.clients.beans.security.SecurityBean;

/**
 *
 * @author McDowell
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        // Run post initialization tasks, only when form is opned.
        this.addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                postInit();
            }
        });
    }

    /**
     * Runs post initialization tasks.
     */
    private void postInit() {
        lblUserName.setText(SecurityBean.getCurrentUser().getUserName());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbarMain = new javax.swing.JToolBar();
        btnMyInfo = new javax.swing.JButton();
        btnRequests = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        pnlStatusBar = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        taskPanel1 = new org.sola.clients.swing.common.tasks.TaskPanel();
        pnlMain = new org.sola.clients.swing.ui.MainContentPanel();
        mainMenu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();
        menuMyInfo = new javax.swing.JMenuItem();
        menuRequests = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuHelpTopics = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/sola/clients/swing/external/Bundle"); // NOI18N
        setTitle(bundle.getString("MainForm.title")); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 400));

        toolbarMain.setFloatable(false);
        toolbarMain.setRollover(true);

        btnMyInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        btnMyInfo.setText(bundle.getString("MainForm.btnMyInfo.text")); // NOI18N
        btnMyInfo.setFocusable(false);
        btnMyInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbarMain.add(btnMyInfo);

        btnRequests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnRequests.setText(bundle.getString("MainForm.btnRequests.text")); // NOI18N
        btnRequests.setFocusable(false);
        btnRequests.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbarMain.add(btnRequests);

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/help.png"))); // NOI18N
        btnHelp.setText(bundle.getString("MainForm.btnHelp.text")); // NOI18N
        btnHelp.setFocusable(false);
        btnHelp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbarMain.add(btnHelp);

        pnlStatusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlStatusBar.setPreferredSize(new java.awt.Dimension(100, 25));

        lblUser.setText(bundle.getString("MainForm.lblUser.text")); // NOI18N

        lblUserName.setText(bundle.getString("MainForm.lblUserName.text")); // NOI18N

        javax.swing.GroupLayout pnlStatusBarLayout = new javax.swing.GroupLayout(pnlStatusBar);
        pnlStatusBar.setLayout(pnlStatusBarLayout);
        pnlStatusBarLayout.setHorizontalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusBarLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(taskPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStatusBarLayout.setVerticalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(taskPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlStatusBarLayout.createSequentialGroup()
                .addGroup(pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuFile.setText(bundle.getString("MainForm.menuFile.text")); // NOI18N

        menuExit.setText(bundle.getString("MainForm.menuExit.text")); // NOI18N
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFile.add(menuExit);

        mainMenu.add(menuFile);

        menuView.setText(bundle.getString("MainForm.menuView.text")); // NOI18N

        menuMyInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        menuMyInfo.setText(bundle.getString("MainForm.menuMyInfo.text")); // NOI18N
        menuView.add(menuMyInfo);

        menuRequests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        menuRequests.setText(bundle.getString("MainForm.menuRequests.text")); // NOI18N
        menuView.add(menuRequests);

        mainMenu.add(menuView);

        menuHelp.setText(bundle.getString("MainForm.menuHelp.text")); // NOI18N

        menuHelpTopics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/help.png"))); // NOI18N
        menuHelpTopics.setText(bundle.getString("MainForm.menuHelpTopics.text")); // NOI18N
        menuHelp.add(menuHelpTopics);

        menuAbout.setText(bundle.getString("MainForm.menuAbout.text")); // NOI18N
        menuHelp.add(menuAbout);

        mainMenu.add(menuHelp);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbarMain, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnMyInfo;
    private javax.swing.JButton btnRequests;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JMenuItem menuAbout;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuHelpTopics;
    private javax.swing.JMenuItem menuMyInfo;
    private javax.swing.JMenuItem menuRequests;
    private javax.swing.JMenu menuView;
    private org.sola.clients.swing.ui.MainContentPanel pnlMain;
    private javax.swing.JPanel pnlStatusBar;
    private org.sola.clients.swing.common.tasks.TaskPanel taskPanel1;
    private javax.swing.JToolBar toolbarMain;
    // End of variables declaration//GEN-END:variables
}
