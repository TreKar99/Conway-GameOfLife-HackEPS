// Librerias gráficas
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;


public class Interfaz {
        public static final int MEDIDA_CELULA = 15; //Definimos la medida del cubo de la celula en pantalla
        
        static int cuenta = 0;          // Cuenta auxiliar que pone la variable jugar en true/false
        static boolean jugar = false;   // Booleano que indica si estamos jugando o no

        public static final Color AZUL_TURQUESA = new Color(8,238,238); // Definimos color con rgb


        public static void continuar() {
            cuenta++;

        if(cuenta % 2 != 0) {
            jugar = false;
        }
        else {
            jugar = true;
        }
        }

        public static void dibujarCelulas(int[][] array, Graphics graphic) {
            
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if(array[i][j] == 0) {
                        graphic.setColor(AZUL_TURQUESA);
                    }
                    else if(array[i][j] == 1) {
                        graphic.setColor(Color.BLACK);
                    }
                    else if(array[i][j] == 2) {
                        graphic.setColor(Color.BLUE);
                    }
                    graphic.fillRect(i * MEDIDA_CELULA, j * MEDIDA_CELULA, MEDIDA_CELULA, MEDIDA_CELULA);
                }
            }
        }

        public static void printingOut(int[][] array)  throws InterruptedException {
            jugar = true;

            JFrame ventana = new JFrame("HackEPS - Conway's Game of Life");    // Creamos ventana que incorporará el juego
        
            ventana.setSize(628,705);                                  //Ponemos las medidas
            ventana.setLocationRelativeTo(null);                                  // Centramos la ventana
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel juego = new JPanel();                                             // Componentes de juego 
            juego.setPreferredSize(new Dimension(400, 400));
            JButton button = new JButton("Continua / Para");
            button.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) {
                    continuar();
                }

            });

            
            ventana.add(juego);
            ventana.add(button, BorderLayout.SOUTH);

            ventana.setVisible(true);

            while(true) {       
                //Printea
                while(jugar) {
                    Thread.sleep(50);
                    Graphics graphic = juego.getGraphics();
                    dibujarCelulas(array, graphic);
                    //Thread.sleep(209);
                    
                    //continuar();
                    JuegoDeConway.reglas(array);
                                 
                }
                Thread.sleep(1);  
                
            
            }
        }
    
}