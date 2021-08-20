package programa;


import classes.Menu;

import java.io.IOException;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws Exception {
        
        int opcao = 0;

        Scanner in = new Scanner (System.in);
        
        Menu menu = new Menu();
        
    do {
        
        Menu.menu();
        
        opcao = in.nextInt();
        in.nextLine();


        if (opcao == 1) {
            menu.opcao1();            
            voltarMenu(in);

        }else if(opcao == 2){
            menu.opcao2();
             
        }else if (opcao == 3){
            menu.opcao3();
            
        }else if (opcao == 4){
            menu.opcao4();
        
        }else if (opcao == 5) {
            menu.opcao5();
            
        }else if (opcao !=0){
            System.out.println("Opção inválida!");
            Thread.sleep(1000);
                
        }   
    
    } while (opcao != 0);  

    in.close();
}


private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}
