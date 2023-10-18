import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programa gerador de Hash!");
        System.out.println("Digite o tamanho da Hash:");
        int tamVetor = scanner.nextInt();
        System.out.println("Digite o número máximo de elementos:");
        int max = scanner.nextInt();
        System.out.println("O fator de carga é: " + (float) max / (float) tamVetor);

        HashSondagemLinear alunohashSondagemLinear = new HashSondagemLinear(tamVetor, max);
        HashEncadeamento alunohashEncadeamento = new HashEncadeamento(tamVetor, max);

        int opcao;
        long numeroBuscas; // Alteração no tipo de dado para long

        do {
            System.out.println("Digite 0 para sair do programa!");
            System.out.println("Digite 1 para inserir um aluno na Hash!");
            System.out.println("Digite 2 para remover um aluno da Hash!");
            System.out.println("Digite 3 para buscar um aluno na Hash!");
            System.out.println("Digite 4 para imprimir a Hash com Sondagem Linear!");
            System.out.println("Digite 5 para imprimir a Hash com Encadeamento!");

            opcao = scanner.nextInt();
            int ra;
            String nome;
            Aluno aluno;

            switch (opcao) {
                case 1:
                    System.out.println("Digite o RA do aluno:");
                    ra = scanner.nextInt();
                    System.out.println("Digite o nome do aluno:");
                    nome = scanner.next();
                    aluno = new Aluno(ra, nome);
                    alunohashSondagemLinear.inserir(aluno);
                    alunohashEncadeamento.inserir(aluno);
                    break;
                case 2:
                    System.out.println("Digite o RA do aluno a ser removido:");
                    ra = scanner.nextInt();
                    aluno = new Aluno(ra, "");
                    boolean removidoSondagemLinear = alunohashSondagemLinear.deletar(aluno);
                    boolean removidoEncadeamento = alunohashEncadeamento.deletar(aluno);
                    if (removidoSondagemLinear || removidoEncadeamento) {
                        System.out.println("Aluno removido com sucesso!");
                    } else {
                        System.out.println("Aluno não encontrado na Hash!");
                    }
                    break;
                case 3:
                    System.out.println("Digite o RA do aluno a ser buscado:");
                    ra = scanner.nextInt();
                    ArrayList<Aluno> alunosEncontradosSondagemLinear = alunohashSondagemLinear.buscar(ra);
                    ArrayList<Aluno> alunosEncontradosEncadeamento = alunohashEncadeamento.buscar(ra);
                    imprimirResultados("Sondagem Linear", alunosEncontradosSondagemLinear);
                    imprimirResultados("Encadeamento", alunosEncontradosEncadeamento);
                    break;
                case 4:
                    System.out.println("Tabela Hash com Sondagem Linear:");
                    alunohashSondagemLinear.imprimir();
                    break;
                case 5:
                    System.out.println("Tabela Hash com Encadeamento:");
                    alunohashEncadeamento.imprimir();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void imprimirResultados(String tipo, ArrayList<Aluno> alunos) {
        System.out.println("Resultados para Hash com " + tipo + ":");
        if (alunos.isEmpty()) {
            System.out.println("Aluno não encontrado!");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("RA: " + aluno.getRa() + ", Nome: " + aluno.getNome());
            }
        }
    }

}
