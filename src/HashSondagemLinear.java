import java.util.ArrayList;  // Importa a classe ArrayList do pacote java.util.

// Classe que representa uma tabela hash com sondagem linear para armazenar alunos.
public class HashSondagemLinear {
    private int maxItens;  // Número máximo de elementos na tabela hash.
    private int maxPosicoes;  // Tamanho da tabela hash.
    private int quantItens = 0;  // Contador de itens na tabela hash.
    private ListaAlunos[] estrutura;  // Estrutura de dados para armazenar os alunos usando sondagem linear.

    // Construtor da classe HashSondagemLinear. Inicializa os atributos e a estrutura de dados.
    public HashSondagemLinear(int tamVetor, int max) {
        this.maxItens = max;
        this.maxPosicoes = tamVetor;
        this.estrutura = new ListaAlunos[tamVetor];
        for (int i = 0; i < tamVetor; i++) {
            estrutura[i] = new ListaAlunos();
        }
    }

    // Método para inserir um aluno na tabela hash usando sondagem linear.
    public void inserir(Aluno aluno) {
        int local = aluno.getRa() % this.maxPosicoes;
        while (!estrutura[local].estaVazia()) {
            local = (local + 1) % this.maxPosicoes;  // Avança linearmente até encontrar uma posição vazia.
        }
        estrutura[local].adicionarAluno(aluno);  // Adiciona o aluno na posição calculada.
        quantItens++;
    }

    // Método para remover um aluno da tabela hash usando sondagem linear.
    public Aluno deletar(int ra) {
        int local = ra % this.maxPosicoes;
        int tentativas = 0;
        while (tentativas < this.maxPosicoes) {
            if (!estrutura[local].estaVazia()) {
                ArrayList<Aluno> alunosNaPosicao = estrutura[local].getAlunos();
                for (int i = 0; i < alunosNaPosicao.size(); i++) {
                    if (alunosNaPosicao.get(i).getRa() == ra) {
                        Aluno alunoRemovido = alunosNaPosicao.get(i);
                        estrutura[local].removerAluno(alunoRemovido);  // Remove o aluno na posição calculada.
                        quantItens--;
                        return alunoRemovido;
                    }
                }
            }
            local = (local + 1) % this.maxPosicoes;  // Avança linearmente para a próxima posição.
            tentativas++;
        }
        return null;  // Retorna null se o aluno não for encontrado após as tentativas.
    }

    // Método para buscar alunos na tabela hash usando sondagem linear.
    public ArrayList<Aluno> buscar(int ra) {
        ArrayList<Aluno> alunosEncontrados = new ArrayList<>();
        int local = ra % this.maxPosicoes;
        for (int i = 0; i < this.maxPosicoes; i++) {
            for (Aluno aluno : estrutura[local].getAlunos()) {
                if (aluno.getRa() == ra) {
                    alunosEncontrados.add(aluno);  // Adiciona o aluno à lista de alunos encontrados.
                }
            }
            local = (local + 1) % this.maxPosicoes;  // Avança linearmente para a próxima posição.
        }
        return alunosEncontrados;
    }

    // Método para imprimir a tabela hash com sondagem linear.
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

    // Método para calcular o tempo de busca de um aluno na tabela hash com sondagem linear.
    public long buscarTempo(int ra) {
        long startTime = System.currentTimeMillis();  // Registra o tempo de início.
        ArrayList<Aluno> alunosEncontrados = buscar(ra);  // Realiza a busca.
        long endTime = System.currentTimeMillis();  // Registra o tempo de término.
        if (!alunosEncontrados.isEmpty()) {
            return endTime - startTime;  // Retorna o tempo de busca se o aluno for encontrado.
        }
        return -1;  // Retorna -1 se o aluno não for encontrado.
    }
}
