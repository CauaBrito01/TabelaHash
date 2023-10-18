import java.util.ArrayList;  // Importa a classe ArrayList do pacote java.util.

// Classe que representa uma tabela hash com encadeamento para armazenar alunos.
public class HashEncadeamento {
    private int maxItens;  // Número máximo de elementos na tabela hash.
    private int maxPosicoes;  // Tamanho da tabela hash.
    private int quantItens = 0;  // Contador de itens na tabela hash.
    private ListaAlunos[] estrutura;  // Estrutura de dados para armazenar os alunos usando o encadeamento.

    // Construtor da classe HashEncadeamento. Inicializa os atributos e a estrutura de dados.
    public HashEncadeamento(int tamVetor, int max) {
        this.maxItens = max;
        this.maxPosicoes = tamVetor;
        this.estrutura = new ListaAlunos[tamVetor];
        for (int i = 0; i < tamVetor; i++) {
            estrutura[i] = new ListaAlunos();
        }
    }

    // Método para inserir um aluno na tabela hash usando encadeamento.
    public void inserir(Aluno aluno) {
        int local = aluno.getRa() % this.maxPosicoes;
        estrutura[local].adicionarAluno(aluno);  // Adiciona o aluno à lista na posição calculada.
        quantItens++;
    }

    // Método para remover um aluno da tabela hash usando encadeamento.
    public Aluno deletar(int ra) {
        int local = ra % this.maxPosicoes;
        if (!estrutura[local].estaVazia()) {
            ArrayList<Aluno> alunosNaPosicao = estrutura[local].getAlunos();
            for (int i = 0; i < alunosNaPosicao.size(); i++) {
                if (alunosNaPosicao.get(i).getRa() == ra) {
                    Aluno alunoRemovido = alunosNaPosicao.get(i);
                    estrutura[local].removerAluno(alunoRemovido);  // Remove o aluno da lista na posição calculada.
                    quantItens--;
                    return alunoRemovido;
                }
            }
        }
        return null;  // Retorna null se o aluno não for encontrado na posição calculada.
    }

    // Método para buscar alunos na tabela hash usando encadeamento.
    public ArrayList<Aluno> buscar(int ra) {
        int local = ra % this.maxPosicoes;
        return estrutura[local].getAlunos();  // Retorna a lista de alunos na posição calculada.
    }

    // Método para imprimir a tabela hash com encadeamento.
    public void imprimir() {
        for (int i = 0; i < this.maxPosicoes; i++) {
            if (!estrutura[i].estaVazia()) {
                System.out.print("Posição " + i + ":");
                for (Aluno aluno : estrutura[i].getAlunos()) {
                    System.out.print(" RA " + aluno.getRa() + ", Nome " + aluno.getNome());
                }
                System.out.println();
            } else {
                System.out.println("Posição " + i + ": Vazia");
            }
        }
    }

    // Método para calcular o tempo de busca de um aluno na tabela hash com encadeamento.
    public long buscarTempo(int ra) {
        long startTime = System.nanoTime();
        ArrayList<Aluno> alunosEncontrados = buscar(ra);
        long endTime = System.nanoTime();
        for (Aluno aluno : alunosEncontrados) {
            if (aluno.getRa() == ra) {
                return endTime - startTime; // Tempo em nanossegundos
            }
        }
        return -1;
    }

}
