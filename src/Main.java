import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        ArrayList<Cadastro> listaUsuarios = new ArrayList<>();
        while (opcao != 4) {
            System.out.println("_".repeat(40));

            System.out.println("""
                             BEM VINDO AO DEVPLACE
                    1 - Cadastro de usuário
                    2 - Consulta usuário
                    3 - Apagar usuário
                    4 - Sair
                    """);
            System.out.println("_".repeat(40));

            System.out.print("Digite: ");
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Digite apenas números!");
                sc.nextLine();
                continue;
            }


            if (opcao == 1){
                System.out.print("Digite seu nome de usuário: ");
                String nomeUsuario = sc.nextLine();

                System.out.print("Digite seu email: ");
                String emailUsuario = sc.nextLine().toLowerCase();

                System.out.print("Digite seu CPF: ");
                String cpfUsuario = sc.nextLine();
                boolean cpfExiste = false;

                for (Cadastro usuario : listaUsuarios) {
                    if (usuario.getCpf().equals(cpfUsuario)){
                        cpfExiste = true;
                        break;
                    }
                }
                if (cpfExiste){
                    System.out.println("CPF já cadastrado!");
                } else {
                    System.out.println("USUÁRIO CADASTRADO!");

                    Cadastro usuario = new Cadastro(nomeUsuario, emailUsuario, cpfUsuario);
                    listaUsuarios.add(usuario);
                }
            } else if (opcao == 2) {

                if (listaUsuarios.isEmpty()){
                    System.out.println("Nenhum usuário cadastrado.");
                } else {
                    System.out.println("\nUSUÁRIOS CADASTRADOS:");
                    System.out.println("_".repeat(40));
                    int contador = 1;

                    for (Cadastro usuario : listaUsuarios) {
                        System.out.println("Usuário " + contador);
                        System.out.println(usuario);
                        System.out.println("-".repeat(40));
                        contador++;
                    }
                }

            } else if (opcao == 3) {
                System.out.print("Informe o CPF do usuário: ");
                String cpfUsuario = sc.nextLine();
                boolean cpfExiste = false;

                for (Cadastro usuario : listaUsuarios) {
                    if (usuario.getCpf().equals(cpfUsuario)){
                        System.out.println(usuario.getNome() + " foi removido!");
                        listaUsuarios.remove(usuario);
                        cpfExiste = true;
                        break;
                    }
                }
                if (!cpfExiste){
                    System.out.println("Usuário não encontrado!");
                }



            } else if (opcao != 4) {
                System.out.println("DIGITO INVALIDO!");
            }
        }
        System.out.println("PROGRAMA ENCERRADO!");
    }
}
