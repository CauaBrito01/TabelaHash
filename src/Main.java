import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Cria um objeto Scanner para ler a entrada do usuário.
        System.out.println("Programa gerador de Hash!");
        System.out.println("Digite o tamanho da Hash:");
        int tamVetor = scanner.nextInt();  // Solicita ao usuário que insira o tamanho da tabela hash.
        System.out.println("Digite o número máximo de elementos:");
        int max = scanner.nextInt();  // Solicita ao usuário que insira o número máximo de elementos na tabela hash.
        System.out.println("O fator de carga é: " + (float) max / (float) tamVetor);

        // Cria instâncias das classes HashSondagemLinear e HashEncadeamento.
        HashSondagemLinear alunohashSondagemLinear = new HashSondagemLinear(tamVetor, max);
        HashEncadeamento alunohashEncadeamento = new HashEncadeamento(tamVetor, max);

        int opcao;  // Variável para armazenar a escolha do usuário.
        do {
            // Exibe as opções do menu.
            System.out.println("Digite 0 para sair do programa!");
            System.out.println("Digite 1 para inserir um aluno na Hash!");
            System.out.println("Digite 2 para remover um aluno da Hash!");
            System.out.println("Digite 3 para buscar um aluno na Hash!");
            System.out.println("Digite 4 para imprimir a Hash com Sondagem Linear!");
            System.out.println("Digite 5 para imprimir a Hash com Encadeamento!");
            System.out.println("Digite 6 para realizar um teste de eficiência na busca!");

            opcao = scanner.nextInt();
            int ra;
            String nome;
            Aluno aluno;

            switch (opcao) {
                case 1:
                    // Adiciona um aluno na tabela hash usando os métodos de sondagem linear e encadeamento.
                    System.out.println("Digite o RA do aluno:");
                    ra = scanner.nextInt();
                    System.out.println("Digite o nome do aluno:");
                    nome = scanner.next();
                    aluno = new Aluno(ra, nome);
                    alunohashSondagemLinear.inserir(aluno);
                    alunohashEncadeamento.inserir(aluno);
                    break;
                case 2:
                    // Remove um aluno da tabela hash usando os métodos de sondagem linear e encadeamento.
                    System.out.println("Digite o RA do aluno a ser removido:");
                    ra = scanner.nextInt();
                    Aluno alunoRemovidoSondagemLinear = alunohashSondagemLinear.deletar(ra);
                    Aluno alunoRemovidoEncadeamento = alunohashEncadeamento.deletar(ra);
                    if (alunoRemovidoSondagemLinear != null) {
                        System.out.println("Aluno removido com sucesso (Sondagem Linear): RA " +
                                alunoRemovidoSondagemLinear.getRa() + ", Nome " + alunoRemovidoSondagemLinear.getNome());
                    } else {
                        System.out.println("Aluno não encontrado na Hash (Sondagem Linear)!");
                    }
                    if (alunoRemovidoEncadeamento != null) {
                        System.out.println("Aluno removido com sucesso (Encadeamento): RA " +
                                alunoRemovidoEncadeamento.getRa() + ", Nome " + alunoRemovidoEncadeamento.getNome());
                    } else {
                        System.out.println("Aluno não encontrado na Hash (Encadeamento)!");
                    }
                    break;
                case 3:
                    // Busca um aluno na tabela hash usando os métodos de sondagem linear e encadeamento.
                    System.out.println("Digite o RA do aluno a ser buscado:");
                    ra = scanner.nextInt();
                    ArrayList<Aluno> alunosEncontradosSondagemLinear = alunohashSondagemLinear.buscar(ra);
                    ArrayList<Aluno> alunosEncontradosEncadeamento = alunohashEncadeamento.buscar(ra);
                    imprimirResultados("Sondagem Linear", alunosEncontradosSondagemLinear);
                    imprimirResultados("Encadeamento", alunosEncontradosEncadeamento);
                    break;
                case 4:
                    // Imprime a tabela hash usando o método de sondagem linear.
                    System.out.println("Tabela Hash com Sondagem Linear:");
                    alunohashSondagemLinear.imprimir();
                    break;
                case 5:
                    // Imprime a tabela hash usando o método de encadeamento.
                    System.out.println("Tabela Hash com Encadeamento:");
                    alunohashEncadeamento.imprimir();
                    break;
                case 6:
                    // Realiza um teste de eficiência na busca de um aluno na tabela hash.
                    System.out.println("Digite o RA do aluno para o teste de eficiência:");
                    ra = scanner.nextInt();

                    long tempoSondagemLinear = alunohashSondagemLinear.buscarTempo(ra);
                    long tempoEncadeamento = alunohashEncadeamento.buscarTempo(ra);

                    if (tempoSondagemLinear != -1) {
                        System.out.println("Tempo de busca com Sondagem Linear: " + tempoSondagemLinear + "ms");
                    } else {
                        System.out.println("Aluno não encontrado com Sondagem Linear.");
                    }

                    if (tempoEncadeamento != -1) {
                        System.out.println("Tempo de busca com Encadeamento: " + tempoEncadeamento + "ms");
                    } else {
                        System.out.println("Aluno não encontrado com Encadeamento.");
                    }
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

    // Método para imprimir os resultados da busca na tabela hash.
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
