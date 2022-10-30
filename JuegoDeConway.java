import java.util.Scanner;

public class JuegoDeConway {

    public static void main(String[] args)  throws InterruptedException {

        int [][] matriz = new int [41][41];      // Matriz de juego 40x40
        

        inicializarMapa(matriz);
        
        // Mapas de partida



        mapaGiroInfinito(matriz);

        Interfaz.printingOut(matriz);

    }

    public static void reglas(int[][] matriz) {
        int[][] matrizJuego = new int[matriz.length][matriz.length];

        for(int y = 1; y < matriz.length - 1; y++) {
            for(int x = 1; x < matriz.length - 1; x++) {
                int vecinos = vecinosContador(matriz, x, y);
                if(matriz[x][y] == 1) {
                    if((vecinos < 2) || (vecinos > 3)) {
                        matrizJuego[x][y] = 0;
                    }
                    if((vecinos == 2) || (vecinos == 3)) {
                        matrizJuego[x][y] = 1;
                    }
                }
                else if(matriz[x][y] == 0){
                    if(vecinos == 3) {
                        matrizJuego[x][y] = 1;
                    }
                    else {
                        matrizJuego[x][y] = 0;
                    }
                }
            }
        }

        for(int i = 1; i < matriz.length - 1; i++){
            for(int j = 1; j < matriz.length - 1; j++) {
                matriz[i][j] = matrizJuego[i][j];
            }
        }

    }

    public static int vecinosContador(int[][] matriz, int x, int y) {
        int vecinos = 0;
        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++) {
                if(matriz[i][j] == 1) {
                    vecinos = vecinos + 1;
                }
            }
        }

        if(matriz[x][y] == 1) {
            vecinos = vecinos - 1;
        }
        return vecinos;
    }

    public static void mapaGiroInfinito(int [][] matriz){
        matriz[14][14]=1;
        matriz[15][12]=1;
        matriz[15][13]=1;
        matriz[15][15]=1;
        matriz[16][13]=1;
        matriz[17][12]=1;
        matriz[17][13]=1;

        matriz[14][17]=1;
        matriz[14][19]=1;
        matriz[15][17]=1;
        matriz[15][18]=1;
        matriz[15][19]=1;
        matriz[16][20]=1;
        matriz[17][19]=1;

        matriz[19][13]=1;
        matriz[20][12]=1;
        matriz[21][13]=1;
        matriz[21][14]=1;
        matriz[21][15]=1;
        matriz[22][13]=1;
        matriz[22][15]=1;

        matriz[19][19]=1;
        matriz[19][20]=1;
        matriz[20][19]=1;
        matriz[21][17]=1;
        matriz[21][19]=1;
        matriz[21][20]=1;
        matriz[22][18]=1;
    }

    public static void inicializarMapa(int [][] matriz){
        // Hacemos los bordes
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                    matriz[i][j] = 2;
            }
        }

        // Ponemos las celulas todas a muertas
        for(int i = 1; i < matriz.length - 1; i++){
            for(int j = 1; j < matriz.length - 1; j++){
                matriz[i][j] = 0;
            }
        }
    }
}
