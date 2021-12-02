package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI_Presentacion extends JFrame {
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones;
    private JPanel panelDatos;
    private Titulos titulo;
    private JLabel labelImagen;
    private Escucha escucha;
    private JTextArea textoExpectativas;

    public GUI_Presentacion() {
        initGUI();
        this.setTitle("Mi Presentacion");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        escucha = new Escucha();
        titulo = new Titulos("Hola soy Johan, oprime los botones . . .", Color.BLACK);
        this.add(titulo, BorderLayout.PAGE_START);

        panelBotones = new JPanel();
        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco más de mi . . .", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Calibri", Font.PLAIN, 20), Color.BLACK));

        this.add(panelDatos, BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addActionListener(escucha);
        miHobby = new JButton("Este es mi hobby");
        miHobby.addActionListener(escucha);
        misExpectativas = new JButton("Creo que . . .");
        misExpectativas.addActionListener(escucha);

        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(10, 12);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    private class Escucha implements ActionListener {
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            panelDatos.removeAll();
            //JOptionPane.showMessageDialog(null,"Oprimiste Boton");
            if (e.getSource() == miFoto) {
                image = new ImageIcon(getClass().getResource("/recursos/Yo.jpeg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            } else {
                if (e.getSource() == miHobby) {
                    image = new ImageIcon(getClass().getResource("/recursos/Hobbie.jpeg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                } else {
                    textoExpectativas.setText("Mi nombre es Johan Loaiza soy estudiante de la universidad de univalle\nen mí tiempo libre me gusta jugar videojuegos, y compartir con amigos mientras juego\ntambién soy competitivo en los juegos\n" +
                            "También me gusta ver anime y leer manga de dichos animes");
                    textoExpectativas.setFont(new Font("cotton_butter", Font.BOLD, 18));
                    textoExpectativas.setBackground(null);
                    panelDatos.add(textoExpectativas);
                }
            }
            revalidate();
            repaint();
        }
    }
}
