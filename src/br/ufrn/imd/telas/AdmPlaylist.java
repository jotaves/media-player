/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.telas;

import br.ufrn.imd.controle.BancoMusicas;
import br.ufrn.imd.controle.BancoPlaylist;
import br.ufrn.imd.musica.Musica;
import br.ufrn.imd.musica.Playlist;
import br.ufrn.imd.users.Usuario;
import br.ufrn.imd.users.UsuarioPremium;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author pedroarthur-mf
 */
public class AdmPlaylist extends javax.swing.JFrame {

    private Usuario usuario;
    private BancoMusicas bm;
    private BancoPlaylist bpl;
    private DefaultListModel listModel;
    private DefaultListModel listModelpl;
    private DefaultListModel listModelMusicaspl;

    /**
     * Creates new form AdmPlaylist
     */
    public AdmPlaylist(Usuario usuario) throws IOException {
        initComponents();

        this.usuario = usuario;
        listModel = new DefaultListModel();
        ListaMusicas.setModel(listModel);
        ListaMusicas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        listModelpl = new DefaultListModel();
        ListaPlaylist.setModel(listModelpl);
        ListaPlaylist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        listModelMusicaspl = new DefaultListModel();
        ListaMusPlaylist.setModel(listModelMusicaspl);
        ListaMusPlaylist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        bm = BancoMusicas.getInstance();
        lerMusicas();

        bpl = BancoPlaylist.getInstance();
        bpl.carregarPlaylist(usuario);
        lerPlaylists();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdicionarMs = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaMusicas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaPlaylist = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaMusPlaylist = new javax.swing.JList<>();
        btnAdicionarPL = new javax.swing.JButton();
        txtNovaPlaylist = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        playlist = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        btnApagarPl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnAdicionarMs.setText("Adicionar ->");
        btnAdicionarMs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarMsActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        ListaMusicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMusicasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaMusicas);

        ListaPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaPlaylistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListaPlaylist);

        ListaMusPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMusPlaylistMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ListaMusPlaylist);

        btnAdicionarPL.setText("Adicionar");
        btnAdicionarPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPLActionPerformed(evt);
            }
        });

        txtNovaPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNovaPlaylistActionPerformed(evt);
            }
        });

        jLabel2.setText("Músicas");

        playlist.setText("Playlist");

        jLabel1.setText("Músicas na playlist");

        jLabel3.setText("Adicione nova play list");

        jToggleButton1.setText("Excluir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        btnApagarPl.setText("Apagar Playlist");
        btnApagarPl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarPlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNovaPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarPL)
                        .addGap(175, 175, 175))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(346, 346, 346))))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnApagarPl)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAdicionarMs)
                                        .addGap(12, 12, 12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(161, 161, 161)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playlist, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playlist)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnAdicionarMs))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(btnApagarPl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNovaPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarPL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOK)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ListaMusicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMusicasMouseClicked
//        int index = ListaMusicas.getSelectedIndex();
//        Musica musica = (Musica) listModel.getElementAt(index);
//        this.caminho = musica.getCaminho();
//        if (estado == 0) {
//            btnPlay.setEnabled(true);
//        }
    }//GEN-LAST:event_ListaMusicasMouseClicked

    private void btnAdicionarMsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarMsActionPerformed
        int indexMu = ListaMusicas.getSelectedIndex();
        int indexPl = ListaPlaylist.getSelectedIndex();
        if (indexPl != -1 && indexMu != -1) {

            Playlist p = (Playlist) listModelpl.getElementAt(indexPl);
            Musica m = (Musica) listModel.getElementAt(indexMu);
            try {
                p.AdicionarMusica(m.getCaminho());
            } catch (IOException ex) {
                Logger.getLogger(AdmPlaylist.class.getName()).log(Level.SEVERE, null, ex);
            }
            listModelMusicaspl.addElement(m);
            ListaMusPlaylist.setModel(listModelMusicaspl);

        }
    }//GEN-LAST:event_btnAdicionarMsActionPerformed

    private void btnAdicionarPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPLActionPerformed
        Playlist p;
        if (txtNovaPlaylist.getText().equals("")) {
            try {
                p = new Playlist(txtNovaPlaylist.getText(), (UsuarioPremium) this.usuario);
                if (bpl.adicionarPlaylist(p)) {
                    listModelpl.addElement(p);
                }
            } catch (IOException ex) {
                Logger.getLogger(AdmPlaylist.class.getName()).log(Level.SEVERE, null, ex);
            }
            ListaPlaylist.setModel(listModelpl);
            txtNovaPlaylist.setText("");
        }
    }//GEN-LAST:event_btnAdicionarPLActionPerformed

    private void txtNovaPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNovaPlaylistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNovaPlaylistActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        try {
            Principal p = new Principal(this.usuario);
            p.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AdmPlaylist.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);

    }//GEN-LAST:event_btnOKActionPerformed

    private void ListaPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaPlaylistMouseClicked
        int index = ListaPlaylist.getSelectedIndex();
        Playlist playlist = (Playlist) listModelpl.getElementAt(index);
        listModelMusicaspl.clear();
        for (Musica m : playlist.getMusicas()) {
            listModelMusicaspl.addElement(m);
        }
        ListaMusPlaylist.setModel(listModelMusicaspl);
        ListaMusPlaylist.setSelectedIndex(0);

    }//GEN-LAST:event_ListaPlaylistMouseClicked

    private void btnApagarPlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarPlActionPerformed
        int index = ListaPlaylist.getSelectedIndex();
        if (index != -1) {
            Playlist playlist = (Playlist) listModelpl.getElementAt(index);
            bpl.removerPlaylist(playlist);
            listModelpl.remove(index);
        }
    }//GEN-LAST:event_btnApagarPlActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        int indexPL = ListaPlaylist.getSelectedIndex();
        int indexMu = ListaMusPlaylist.getSelectedIndex();
        if (indexPL != -1 && indexMu != -1) {
            Playlist playlist = (Playlist) listModelpl.getElementAt(indexPL);
            Musica m = (Musica) listModelMusicaspl.getElementAt(indexMu);
            listModelMusicaspl.remove(indexMu);
            try {
//                System.out.println("Deletar: " + m.getCaminho());
                playlist.removerMusica(m);
            } catch (IOException ex) {
                Logger.getLogger(AdmPlaylist.class.getName()).log(Level.SEVERE, null, ex);
            }
            ListaMusPlaylist.setModel(listModelMusicaspl);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void ListaMusPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMusPlaylistMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaMusPlaylistMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[], Usuario u) {
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
            java.util.logging.Logger.getLogger(AdmPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdmPlaylist(u).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(AdmPlaylist.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaMusPlaylist;
    private javax.swing.JList<String> ListaMusicas;
    private javax.swing.JList<String> ListaPlaylist;
    private javax.swing.JButton btnAdicionarMs;
    private javax.swing.JButton btnAdicionarPL;
    private javax.swing.JButton btnApagarPl;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel playlist;
    private javax.swing.JTextField txtNovaPlaylist;
    // End of variables declaration//GEN-END:variables

    private void lerMusicas() throws IOException {
        ArrayList<String> d = bm.getListDiretorio();
        for (String nome : d) {
            File arquivo = new File(nome);
            File[] arquivosDir = arquivo.listFiles();
            for (File musicaArq : arquivosDir) {
                if (musicaArq.getAbsolutePath().endsWith(".mp3")) {
                    Musica mus = new Musica(musicaArq.getAbsolutePath());
                    if (!listModel.contains(mus)) {
                        listModel.addElement(new Musica(musicaArq.getAbsolutePath()));
                    }
                }
            }
        }
        ArrayList<String> m = bm.getListMusicas();
        for (String nome : m) {
            Musica mus = new Musica(nome);
            if (!listModel.contains(mus)) {
                listModel.addElement(new Musica(nome));
            }
        }
        ListaMusicas.setModel(listModel);

    }

    private void lerPlaylists() {
        ArrayList<Playlist> playlists = bpl.getPlaylists();
        for (Playlist p : playlists) {
            listModelpl.addElement(p);
        }
        ListaPlaylist.setModel(listModelpl);
    }

}
