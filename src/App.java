import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> nomes = new ArrayList<String>();
    private static ArrayList<Integer> senhas = new ArrayList<Integer>();

    public static void main(String[] args) {
        while (true) { 
            System.out.printf("""
                    Escolha uma opção:
                    1 - Gerar uma senha;
                    2 - Portal admninitrativo;
                    3 - Sair;
                    """);
            int escolhaMenu = sc.nextInt();
            sc.nextLine();

            switch (escolhaMenu) {
                case 1:
                    GerarTitulo("Gerar senha de chamada");
                    GerarSenha();
                    break;

                case 2:
                    GerarTitulo("Portal admninitrativo");
                    break;

                case 3:
                    System.out.println("Obrigado por usar o programa!");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    public static void GerarTitulo(String titulo) {
        System.out.println("\n==================== " + titulo + " ====================\n");
    }

    public static void GerarSenha() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        nomes.add(nome); 

        Random random = new Random();
        int senhaGerada = 1000 + random.nextInt(9000);
        senhas.add(senhaGerada); 

        GerarTitulo("Senha gerada com sucesso!");
        System.out.println("Nome: " + nome);
        System.out.println("Senha: " + senhaGerada);
        System.out.println(" ");
    }

    public static void ConsultarSenhas() {
        GerarTitulo("Lista de senhas geradas:");
        
        if (nomes.isEmpty()) {
            System.out.println("Nenhuma senha foi gerada ainda.");
        } else {
            for (int i = 0; i < nomes.size(); i++) {
                System.out.println("Cliente #" + (i + 1));
                System.out.println("Nome: " + nomes.get(i));
                System.out.println("Senha: " + senhas.get(i));
                System.out.println("-----------------------");
            }
            System.out.println(" ");
        }
    }
}
