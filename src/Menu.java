import java.util.Scanner;

public class Menu {

    public void showMenu(){
        System.out.println("Bienvenido al juego othello.");
        Scanner sc = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println("Puede escojer una opciòn");
            System.out.println("1. Iniciar juego\n2. Reglas\n3. Autor\n4. Salir");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    new Table();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("José Raúl Sierra Lòpez");
                    System.out.println("Carnet: 22003703");
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
            }
        } while (op != 4);
    }
}
