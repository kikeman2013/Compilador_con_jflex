package codigo;

import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Maniacorp
 */
public class FrmPrincipal extends javax.swing.JFrame {
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setBackground(Color.blue);                   
        
    }
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) { 
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case Linea: cont++;
                           resultado += "LINEA " + cont + "\n"; break;
                case Comillas: resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n"; break;
                case T_dato: resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n"; break;
                case Cadena: resultado += "  <Cadena>\t\t" + lexer.lexeme + "\n"; break;   
                case Char:   resultado += "  <Caracter>\t\t" + lexer.lexeme + "\n";  break;    
                case If:     resultado += "  <Reservada if>\t" + lexer.lexeme + "\n"; break;
                case Else:   resultado += "  <Reservada else>\t" + lexer.lexeme + "\n"; break;
                case Do:     resultado += "  <Reservada do>\t" + lexer.lexeme + "\n"; break;
                case While:  resultado += "  <Reservada while>\t" + lexer.lexeme + "\n"; break;
                case For:    resultado += "  <Reservada For>\t" + lexer.lexeme + "\n"; break;
                case Igual:  resultado += "  <Operador igual>\t" + lexer.lexeme + "\n"; break;
                case Suma:   resultado += "  <Operador suma>\t" + lexer.lexeme + "\n"; break;
                case Resta:  resultado += "  <Operador resta>\t" + lexer.lexeme + "\n"; break;
                case Multiplicacion: resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n"; break;
                case Division: resultado += "  <Operador division>\t" + lexer.lexeme + "\n"; break;
                case Op_logico: resultado += "  <Operador logico>\t" + lexer.lexeme + "\n"; break;
                case Op_incremento: resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n"; break;
                case Op_relacional: resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n"; break;
                case Op_atribucion:  resultado += "  <Operador atribucion>\t" + lexer.lexeme + "\n"; break;
                case Op_booleano:  resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n"; break;
                case Parentesis_a: resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n"; break;
                case Parentesis_c: resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n"; break;
                case Llave_a: resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n"; break;
                case Llave_c:  resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n"; break;
                case Corchete_a: resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n"; break;
                case Corchete_c: resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n"; break;
                case Main: resultado += "  <Reservada main>\t" + lexer.lexeme + "\n"; break;
                case P_coma: resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n"; break;
                case Identificador: resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n"; break;
                case Numero: resultado += "  <Numero>\t\t" + lexer.lexeme + "\n"; break;
                case Math: resultado += "  <Reservada Math>\t" + lexer.lexeme + "\n"; break;
                case Void:  resultado += "  <Reservada Void>\t" + lexer.lexeme + "\n"; break;
                case Coma: resultado += "  <coma>\t\t" + lexer.lexeme + "\n"; break;
                case Imprimir: resultado += "  <Imprimir>\t\t" + lexer.lexeme + "\n"; break;
                case Ingresar: resultado += "  <Ingresar>\t\t" + lexer.lexeme + "\n"; break;
                case Return: resultado += "  <Reservada Return>\t" + lexer.lexeme + "\n"; break;
                case Mod: resultado += "  <Mod>\n"; break;
                case Break: resultado += "  <Reservada Break>\n"; break;
                case Raiz: resultado += "  <Raiz>\t\t" + lexer.lexeme + "\n"; break;
                case Pow: resultado += "  <Potencia>\t\t" + lexer.lexeme + "\n";  break;
                case ERROR: resultado += "  <Simbolo no definido>\n"; break;
                default: resultado += "  < " + lexer.lexeme + " >\n";  break;
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnAnalizarLex = new javax.swing.JButton();
        btnLimpiarLex = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        btnAnalizarSin = new javax.swing.JButton();
        btnLimpiarSin = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnGenerarExe = new javax.swing.JButton();
        jlblEstado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMnAyuda = new javax.swing.JMenu();
        jMniAcercaDe = new javax.swing.JMenuItem();
        jMnArchivos = new javax.swing.JMenu();
        jMniMUsuario = new javax.swing.JMenuItem();
        jMniMTecnico = new javax.swing.JMenuItem();
        jMniBitacora = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizado Lexico para LyAII 2020");
        setBackground(new java.awt.Color(34, 20, 43));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(34, 20, 43));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Lexico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Goudy Stout", 0, 18), new java.awt.Color(255, 255, 0))); // NOI18N

        btnArchivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abierto_50.png"))); // NOI18N
        btnArchivo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abiertoselect_50.png"))); // NOI18N
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnAnalizarLex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnalizarLex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/analizar_50.png"))); // NOI18N
        btnAnalizarLex.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/analizarselect_50.png"))); // NOI18N
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        btnLimpiarLex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarLex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrador_50.png"))); // NOI18N
        btnLimpiarLex.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borradorselect_50.png"))); // NOI18N
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Goudy Stout", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Salida:");

        jLabel2.setFont(new java.awt.Font("Goudy Stout", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Codigo Fuente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnalizarLex, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarLex, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnalizarLex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarLex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );

        jPanel2.setBackground(new java.awt.Color(34, 20, 43));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Sintactico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Goudy Stout", 0, 18), new java.awt.Color(255, 255, 0))); // NOI18N

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        btnAnalizarSin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnalizarSin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar_50.png"))); // NOI18N
        btnAnalizarSin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarselect_50.png"))); // NOI18N
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        btnLimpiarSin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarSin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar_50.png"))); // NOI18N
        btnLimpiarSin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiarselect_50.png"))); // NOI18N
        btnLimpiarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSinActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salidaselect_50.png"))); // NOI18N
        btnSalir.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salida_50.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGenerarExe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGenerarExe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/generar_50.png"))); // NOI18N
        btnGenerarExe.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/generarselect_50.png"))); // NOI18N
        btnGenerarExe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarExeActionPerformed(evt);
            }
        });

        jlblEstado.setFont(new java.awt.Font("Goudy Stout", 1, 14)); // NOI18N
        jlblEstado.setForeground(new java.awt.Color(255, 255, 0));
        jlblEstado.setText("               ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAnalizarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnGenerarExe, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpiarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAnalizarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jlblEstado))
                    .addComponent(btnGenerarExe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jMnAyuda.setText("Ayuda");

        jMniAcercaDe.setText("Acerca De..");
        jMniAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMniAcercaDeActionPerformed(evt);
            }
        });
        jMnAyuda.add(jMniAcercaDe);

        jMenuBar1.add(jMnAyuda);

        jMnArchivos.setText("Archivos");

        jMniMUsuario.setText("Manual Usuario");
        jMniMUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMniMUsuarioActionPerformed(evt);
            }
        });
        jMnArchivos.add(jMniMUsuario);

        jMniMTecnico.setText("Manual Tecnico");
        jMniMTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMniMTecnicoActionPerformed(evt);
            }
        });
        jMnArchivos.add(jMniMTecnico);

        jMniBitacora.setText("Bitacora");
        jMniBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMniBitacoraActionPerformed(evt);
            }
        });
        jMnArchivos.add(jMniBitacora);

        jMenuBar1.add(jMnArchivos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());     
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } 
        catch (FileNotFoundException ex) { Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex); } 
        catch (IOException ex) { Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
   txtAnalizarLex.setText(null);
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnLimpiarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSinActionPerformed
        txtAnalizarSin.setText(null);
        jlblEstado.setText("");
    }//GEN-LAST:event_btnLimpiarSinActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try { analizarLexico(); } 
        catch (IOException ex) {Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));        
        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado correctamente");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGenerarExeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarExeActionPerformed
        File new_file = new File("./codigo_fuente.cpp");
        BufferedWriter bw = null;
        if(new_file.exists()){
            new_file.delete();
        }
        new_file = new File("./codigo_fuente.cpp");
        try {
            bw = new BufferedWriter(new FileWriter(new_file));
            bw.write("#include <stdio.h> \n   #include <cmath> \n ");
            bw.write(txtResultado.getText());
        } catch (IOException ex) { Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex); }
        finally{
            if(bw != null)
            try { bw.close(); } 
            catch (IOException ex) {Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex); }
        }
        BufferedInputStream bf = null;
        File output = new File("salida.exe");
        if(output.exists())
        output.delete();
        String [] cmd = {"g++","codigo_fuente.cpp","-o","salida"};
        String salida = "";
        try {
            Process proces  = Runtime.getRuntime().exec(cmd);
            InputStream  process_output = proces.getInputStream();
            bf = new BufferedInputStream(process_output);
            int dato = 0;
            char c = ' ';
            salida = "Error al compilar Verificar la sintaxis";
            do{
                dato = bf.read();
                if(dato!= -1){
                    c = (char) dato;
                    salida += String.valueOf(c);
                }
                jlblEstado.setText("Generando Ejecutable.......");
            }while(dato != -1);            
        } catch (IOException ex) {
            txtAnalizarSin.setText(salida);
            jlblEstado.setText("Ejecutable NO Generado");
            System.out.println(ex);
        }
        jlblEstado.setText("Ejecutable Generado!!");
    }//GEN-LAST:event_btnGenerarExeActionPerformed

    private void jMniAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMniAcercaDeActionPerformed
        JOptionPane.showMessageDialog(null, "José Ángel García Arce     NC: 17130786\n Luis Emmanuel Méndez Barrios     NC: 17130804\n Enrique Antonio Belmarez Meraz     NC: 17130765\n"
                                             ,"Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMniAcercaDeActionPerformed

    private void jMniMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMniMUsuarioActionPerformed
     try {
           File path = new File (System.getProperty("user.dir") +"\\src\\manuales\\Manual_Usuario.pdf" );
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
         JOptionPane.showMessageDialog( this , "Error al abrir el PDF de la ayuda" ,"Editor", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_jMniMUsuarioActionPerformed

    private void jMniMTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMniMTecnicoActionPerformed
try {
           File path = new File (System.getProperty("user.dir") +"\\src\\manuales\\Manual_Tecnico.pdf" );
            Desktop.getDesktop().open(path);
        } catch (IOException e) {JOptionPane.showMessageDialog(this , "Error al abrir el PDF de la ayuda" , "Editor", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_jMniMTecnicoActionPerformed

    private void jMniBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMniBitacoraActionPerformed
try {
           File path = new File (System.getProperty("user.dir") +"\\src\\manuales\\Bitacora.pdf" );
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
         JOptionPane.showMessageDialog( this ,"Error al abrir el PDF de la ayuda" , "Editor",JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_jMniBitacoraActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnGenerarExe;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnLimpiarSin;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jMnArchivos;
    private javax.swing.JMenu jMnAyuda;
    private javax.swing.JMenuItem jMniAcercaDe;
    private javax.swing.JMenuItem jMniBitacora;
    private javax.swing.JMenuItem jMniMTecnico;
    private javax.swing.JMenuItem jMniMUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlblEstado;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
