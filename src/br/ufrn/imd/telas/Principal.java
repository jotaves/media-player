/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.telas;

import br.ufrn.imd.daos.MusicasDao;
import br.ufrn.imd.daos.PlaylistsDao;
import br.ufrn.imd.musica.Musica;
import br.ufrn.imd.musica.Playlist;
import br.ufrn.imd.musica.Tocador;
import br.ufrn.imd.users.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Classe que implementa a interface da tela principal.
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class Principal extends javax.swing.JFrame {

    private Usuario usuario; //Usuario atual.
    private String caminho;
    private Thread thMusica;// thread que toca uma música.
    private Thread thPlaylist; // thread que toca uma playlist
    private int estado; //0-parado, 1-pausado, 2-tocando
    private DefaultListModel listModel;
    private DefaultListModel listModelpl;
    private DefaultListModel listModelMusicaspl;
    private static MusicasDao bm; // Banco de músicas.
    private static PlaylistsDao bpl; // Bando de playlists.

    /**
     * Cria um novo form Principal, inicializa suas variaveis, carrega os dados
     * necessarios e define os estados dos botões.
     *
     * @throws java.io.IOException
     */
    public Principal(Usuario usuario) throws IOException {
        initComponents();
        this.usuario = usuario;
        this.estado = 0;

        btnParar.setEnabled(false);
        btnPausar.setEnabled(false);
        btnPlay.setEnabled(false);
        btnProx.setEnabled(false);
        BtnAnt.setEnabled(false);

        lblNomeUsuario.setText("Usuário: " + this.usuario.getNome());

        listModel = new DefaultListModel();
        ListaMusicas.setModel(listModel);
        ListaMusicas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        listModelpl = new DefaultListModel();
        ListaPlaylist.setModel(listModelpl);
        ListaPlaylist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        listModelMusicaspl = new DefaultListModel();
        ListaMusPlaylist.setModel(listModelMusicaspl);
        ListaMusPlaylist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        bm = MusicasDao.getInstance();

        lerMusicas();

        if (usuario.ePremium()) {
            lblPremium.setText("Usuário Premium");
            bpl = PlaylistsDao.getInstance();
            listModelpl.clear();
            bpl.carregarPlaylist(usuario);
            lerPlaylists();
        } else {
            lblPremium.setText("");
            btnGerenciar.setEnabled(false);
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

        jFrame1 = new javax.swing.JFrame();
        btnPlay = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaMusicas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaPlaylist = new javax.swing.JList<>();
        playlist = new javax.swing.JLabel();
        btnPausar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaMusPlaylist = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        lblNomeUsuario = new javax.swing.JLabel();
        lblPremium = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        btnGerenciar = new javax.swing.JToggleButton();
        BtnAnt = new javax.swing.JToggleButton();
        btnProx = new javax.swing.JToggleButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MediaPlayer");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(200, 200, 200));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        btnPlay.setBackground(java.awt.Color.lightGray);
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/imd/telas/play-button.png"))); // NOI18N
        btnPlay.setBorderPainted(false);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/imd/telas/stop.png"))); // NOI18N
        btnParar.setBorderPainted(false);
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
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

        playlist.setText("Playlist");

        btnPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/imd/telas/pause-button.png"))); // NOI18N
        btnPausar.setBorderPainted(false);
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(ListaMusPlaylist);

        jLabel2.setText("Músicas");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel1.setText("Músicas na playlist");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblNomeUsuario.setText("jLabel3");

        lblPremium.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblPremium.setForeground(new java.awt.Color(235, 195, 0));
        lblPremium.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPremium.setText("Usuario Premium");

        btnGerenciar.setText("Gerenciar PlayLists");
        btnGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarActionPerformed(evt);
            }
        });

        BtnAnt.setBackground(java.awt.Color.lightGray);
        BtnAnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/imd/telas/fast-forward-arrows (outra cópia).png"))); // NOI18N
        BtnAnt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BtnAnt.setBorderPainted(false);
        BtnAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAntActionPerformed(evt);
            }
        });

        btnProx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/imd/telas/fast-forward-arrows (cópia).png"))); // NOI18N
        btnProx.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnProx.setBorderPainted(false);
        btnProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 82, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAbrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(btnGerenciar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(playlist, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAnt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPremium))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProx, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeUsuario)
                    .addComponent(lblPremium))
                .addGap(21, 21, 21)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPlay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BtnAnt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnParar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnProx, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPausar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playlist)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnLimpar)
                    .addComponent(btnGerenciar)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
     * Toca uma música ou as músicas de uma playlist selecionada.
     *
     * @param evt
     */
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        if (estado == 1) {
            if (thMusica != null && thMusica.isAlive()) {
                this.thMusica.resume();
            }

            if (thPlaylist != null && thPlaylist.isAlive()) {
                btnProx.setEnabled(true);
                BtnAnt.setEnabled(true);
            }
        } else if (estado == 0) {
            if (thPlaylist != null) {
                thPlaylist.stop();
                thPlaylist = null;
            }
            Tocador p1;
            if (!ListaPlaylist.isSelectionEmpty()) {
                this.thPlaylist = new Thread(
                        new Runnable() {
                    public void run() {
                        int index = ListaPlaylist.getSelectedIndex();
                        Playlist atual = (Playlist) listModelpl.getElementAt(index);
                        int size = atual.getMusicas().size();
                        for (int i = ListaMusPlaylist.getSelectedIndex(); i < size; i = ((i + 1) % size)) {
                            String caminho = atual.getMusicas().get(i).getCaminho();
                            ListaMusPlaylist.setSelectedIndex(i);
                            try {
                                Tocador p2 = new Tocador(caminho);
                                thMusica = new Thread(p2);
                                thMusica.start();
                                while (thMusica.isAlive());
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                });
                this.thPlaylist.start();
            } else {
                try {
                    p1 = new Tocador(this.caminho);
                    this.thMusica = new Thread(p1);
                    this.thMusica.start();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        this.estado = 2;
        btnParar.setEnabled(true);
        btnPausar.setEnabled(true);
        btnPlay.setEnabled(false);

        if (thPlaylist != null && thPlaylist.isAlive()) {
            btnProx.setEnabled(true);
            BtnAnt.setEnabled(true);
        } else {
            btnProx.setEnabled(false);
            BtnAnt.setEnabled(false);
        }
        new Thread(
                new Runnable() {
            public void run() {
                while (true) {
                    if (thMusica != null && !thMusica.isAlive() && thPlaylist == null && estado != 0) {
                        estado = 0;
                        btnParar.setEnabled(false);
                        btnPausar.setEnabled(false);
                        btnPlay.setEnabled(true);
                        break;
                    } else if (thMusica != null && !thMusica.isAlive() && estado == 0) {
                        break;
                    }
                }
            }

        }).start();
    }//GEN-LAST:event_btnPlayActionPerformed
    /**
     * Faz com que a música que está sendo executada pare.
     *
     * @param evt
     */
    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        if (estado != 0) {
            if (thMusica != null && thMusica.isAlive()) {
                this.thMusica.stop();

                if (thPlaylist != null && thPlaylist.isAlive()) {
                    this.thPlaylist.stop();
                }
            } else {
                this.thPlaylist.stop();
                this.thMusica.stop();
            }

            this.estado = 0;
            btnParar.setEnabled(false);
            btnPlay.setEnabled(true);
            btnPausar.setEnabled(false);
        }
    }//GEN-LAST:event_btnPararActionPerformed
    /**
     * Faz com que a música que está tocando no momento seja pausada.
     *
     * @param evt
     */
    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed
        if (this.estado != 1) {
            if (thMusica != null && thMusica.isAlive()) {
                this.thMusica.suspend();

                if (thPlaylist != null && thPlaylist.isAlive()) {
                    this.thPlaylist.suspend();
                }
            } else {
                this.thMusica.suspend();
                this.thPlaylist.suspend();
            }

            this.estado = 1;
            btnPlay.setEnabled(true);
            btnParar.setEnabled(true);
            btnPausar.setEnabled(false);
        }
    }//GEN-LAST:event_btnPausarActionPerformed
    /**
     * Abre um JFaleChooser para seleciomar um arqruivo ou um diretorio contendo
     * arquivos do tipo ".mp3".
     *
     * @param evt
     */
    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquvos MP3", "mp3");
        JFileChooser arquivo = new JFileChooser();
        arquivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        arquivo.setAcceptAllFileFilterUsed(false);
        arquivo.addChoosableFileFilter(filtro);

        int r = arquivo.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            if (arquivo.getSelectedFile().isFile()) {//ARQUIVO MP3
                Musica m = new Musica(arquivo.getSelectedFile().getAbsolutePath());
                if (!isOnList(m)) {
                    listModel.addElement(m);
                    bm.adicionar(arquivo.getSelectedFile().getAbsolutePath());
                }
                bm.adicionar(arquivo.getSelectedFile().getAbsolutePath());
            } else {    //DIRETORIO
                // Filtrar arquivos .mp3 de dentro do diretório.
                File[] arquivosDir = arquivo.getSelectedFile().listFiles();

                for (File musicaArq : arquivosDir) {
                    if (musicaArq.getAbsolutePath().endsWith(".mp3")) {
                        Musica m = new Musica(musicaArq.getAbsolutePath());
                        if (!isOnList(m)) {
                            listModel.addElement(m);
                        }
                    }
                }
                try {
                    bm.adicionarDiretorio(arquivo.getSelectedFile().getAbsolutePath());

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            ListaMusicas.setModel(listModel);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed
    /**
     * Limpa JList de músicas da Playlist e ativa o botão de play.
     *
     * @param evt
     */
    private void ListaMusicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMusicasMouseClicked
        ListaPlaylist.clearSelection();
        listModelMusicaspl.clear();
        ListaMusPlaylist.setModel(listModelMusicaspl);

        int index = ListaMusicas.getSelectedIndex();
        Musica musica = (Musica) listModel.getElementAt(index);
        this.caminho = musica.getCaminho();
        if (estado == 0) {
            btnPlay.setEnabled(true);
        }
    }//GEN-LAST:event_ListaMusicasMouseClicked
    /**
     * Apaga as musicas previamente carregar no sistema.
     *
     * @param evt
     */
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        FileWriter writer;
        try {

            writer = new FileWriter("bancos/musicas.txt", false);
            writer.write("");
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        try {
            writer = new FileWriter("bancos/diretorio.txt", false);
            writer.write("");
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        MusicasDao b;
        try {
            b = MusicasDao.getInstance();
            b.removerTudo();

        } catch (IOException ex) {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        listModel.clear();
        ListaMusicas.setModel(listModel);

        // Atualizar visualização na tela.
    }//GEN-LAST:event_btnLimparActionPerformed
    /**
     * Faz com que o usuário saia da sessão.
     *
     * @param evt
     */
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
        Login l;
        try {
            l = new Login();
            l.setVisible(true);
            //BancoMusicas b = BancoMusicas.getInstance();
            //b.removerMusicas();

        } catch (IOException ex) {
            Logger.getLogger(Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (thMusica != null && thMusica.isAlive()) {
            thMusica.stop();
        }
        if (thPlaylist != null && thPlaylist.isAlive()) {
            thPlaylist.stop();
        }
    }//GEN-LAST:event_btnSairActionPerformed
    /**
     * Abre uma nova janela para para o gerenciamento de palylists.
     *
     * @param evt
     */
    private void btnGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarActionPerformed
        AdmPlaylist p;
        try {
            if (thMusica != null && thMusica.isAlive()) {
                thMusica.stop();
            }
            if (thPlaylist != null && thPlaylist.isAlive()) {
                thPlaylist.stop();
            }
            p = new AdmPlaylist(this.usuario);
            p.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disable();
        this.setVisible(false);
    }//GEN-LAST:event_btnGerenciarActionPerformed
    /**
     * Faz com que quando uma Playlist é selecionada, as musicas dela apareçam
     * na Jlist correspondes as músicas de uma Playlost.
     *
     * @param evt
     */
    private void ListaPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaPlaylistMouseClicked
        ListaMusicas.clearSelection();

        int index = ListaPlaylist.getSelectedIndex();
        if (index != -1) {
            Playlist playlist = (Playlist) listModelpl.getElementAt(index);
            listModelMusicaspl.clear();
            for (Musica m : playlist.getMusicas()) {
                listModelMusicaspl.addElement(m);
            }
            ListaMusPlaylist.setModel(listModelMusicaspl);
            ListaMusPlaylist.setSelectedIndex(0);
            if (estado == 0) {
                btnPlay.setEnabled(true);
            }
        }
    }//GEN-LAST:event_ListaPlaylistMouseClicked
    /**
     * Faz com que a próxima música da playlist seja tocada.
     *
     * @param evt
     */
    private void btnProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxActionPerformed
        int index = ListaMusPlaylist.getSelectedIndex();
        int a = listModelMusicaspl.getSize();
        ListaMusPlaylist.setSelectedIndex((++index) % a);

        thMusica.stop();
        thPlaylist.stop();
        this.estado = 0;

        btnPlay.setEnabled(false);
        btnPausar.setEnabled(true);
        btnParar.setEnabled(true);
        btnProx.setEnabled(true);
        BtnAnt.setEnabled(true);

        btnPlayActionPerformed(evt);
    }//GEN-LAST:event_btnProxActionPerformed
    /**
     * Faz com que a música anterior da Playlist seja tocada.
     *
     * @param evt
     */
    private void BtnAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAntActionPerformed
        int index = ListaMusPlaylist.getSelectedIndex();
        ListaMusPlaylist.setSelectedIndex(--index);

        thPlaylist.stop();
        thMusica.stop();
        this.estado = 0;

        btnPlay.setEnabled(false);
        btnPausar.setEnabled(true);
        btnParar.setEnabled(true);
        btnProx.setEnabled(true);
        BtnAnt.setEnabled(true);

        btnPlayActionPerformed(evt);
    }//GEN-LAST:event_BtnAntActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[], Usuario usuario) {
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
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal(usuario).setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private boolean isOnList(Musica m) {
        for (int i = 0; i < listModel.getSize(); i++) {
            if (m.getNome().equals(((Musica) listModel.getElementAt(i)).getNome()) && m.getCaminho().equals(((Musica) listModel.getElementAt(i)).getCaminho())) {
                return true;
            }
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnAnt;
    private javax.swing.JList<String> ListaMusPlaylist;
    private javax.swing.JList<String> ListaMusicas;
    private javax.swing.JList<String> ListaPlaylist;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JToggleButton btnGerenciar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnPausar;
    private javax.swing.JButton btnPlay;
    private javax.swing.JToggleButton btnProx;
    private javax.swing.JButton btnSair;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblPremium;
    private javax.swing.JLabel playlist;
    // End of variables declaration//GEN-END:variables
/**
     * Lê as músicas e diretorios presentes nos arquivos ".txt" e as carrega no
     * programa.
     *
     * @throws IOException
     */
    private void lerMusicas() throws IOException {
        ArrayList<String> m = bm.getListMusicas();
        for (String nome : m) {
            Musica mus = new Musica(nome);
            if (!jaExiste(mus)) {
                listModel.addElement(mus);
            }
        }

        ArrayList<String> d = bm.getListDiretorio();
        for (String nome : d) {
            File arquivo = new File(nome);
            File[] arquivosDir = arquivo.listFiles();
            if (arquivosDir != null) {
                for (File musicaArq : arquivosDir) {
                    if (musicaArq.getAbsolutePath().endsWith(".mp3")) {
                        Musica mus = new Musica(musicaArq.getAbsolutePath());
                        if (!jaExiste(mus)) {
                            listModel.addElement(mus);
                        }
                    }
                }
            }
        }
        ListaMusicas.setModel(listModel);
    }

    /**
     * Lê as Playlists presentes nos arquivos ".txt" e as carrega no programa.
     */
    private void lerPlaylists() {
        ArrayList<Playlist> playlists = bpl.getPlaylists();
        for (Playlist p : playlists) {
            if (!listModel.contains(p)) {
                listModelpl.addElement(p);
            }
        }
        ListaPlaylist.setModel(listModelpl);
    }

    /**
     * Verifica se uma música já está presente no Modelo da JList de musicas.
     *
     * @param mus musica que deseja ser verificada.
     * @return true se a musica já estiver o modelo ou false se não estiver.
     */
    public boolean jaExiste(Musica mus) {
        for (int i = 0; i < listModel.size(); i++) {
            if (mus.getNome().equals(((Musica) listModel.getElementAt(i)).getNome())) {
                return true;
            }
        }
        return false;
    }
}
