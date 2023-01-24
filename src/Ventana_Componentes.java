import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ventana_Componentes {
    private JLabel JLabel_Ejemplo_Imagen_Texto;
    private JPanel Panel_Principal;
    private JProgressBar JProgressBar_Ejemplo;
    private JPanel Jpanel_Ejemplo;
    private JScrollPane JScrollPane_Ejemplo;
    private JLabel JLabel_Ejemplo_Solo_Texto;
    private JLabel JLabel_Ejemplo_Solo_Imagen;
    private JButton iniciarButton;
    private JPanel JLabel_Ejemplos;
    private JPanel JScrollPane;
    private JPanel JProgressBar;
    private JLabel Imagen_Dentro;
    private JCheckBox JLabelCheckBox;
    private JCheckBox JScrollPaneCheckBox;
    private JCheckBox JProgressBarCheckBox;

    public Ventana_Componentes(){
        JProgressBar_Ejemplo.setStringPainted(true);
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JProgressBar_Ejemplo.setString("Cargando Programa...");
                Thread hilo=new Thread(){
                    @Override
                    public void run(){
                        for(int i=1;i<=100;i++){
                            try {
                                sleep(100);
                                JProgressBar_Ejemplo.setValue(i);

                                if (i == 25){
                                    JLabel_Ejemplo_Solo_Texto.setText("Escuela Politécnica Nacional");

                                    JLabel_Ejemplo_Imagen_Texto.setText("¡Hola amigos de la EPN!");
                                    JLabel_Ejemplo_Imagen_Texto.setIcon(new ImageIcon("img.png"));

                                    JLabel_Ejemplo_Solo_Imagen.setText("");
                                    JLabel_Ejemplo_Solo_Imagen.setIcon(new ImageIcon("img_1.png"));

                                    JLabelCheckBox.setSelected(true);
                                } else if (i == 50) {
                                    Imagen_Dentro.setText("");
                                    Imagen_Dentro.setIcon(new ImageIcon("img_2.png"));
                                    JScrollPaneCheckBox.setSelected(true);

                                } else if (i == 100) {
                                    JProgressBar_Ejemplo.setString("Programa Terminado");
                                    JProgressBarCheckBox.setSelected(true);
                                }

                            } catch (InterruptedException ex) {
                                Logger.getLogger(Ventana_Componentes.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                };
                hilo.start();

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame =new JFrame("Ventana_Componentes");
        frame.setContentPane(new Ventana_Componentes().Panel_Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.pack();
        frame.setVisible(true);

    }
}
