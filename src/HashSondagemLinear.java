import java.util.ArrayList;

public class HashSondagemLinear {
    private int maxItens;
    private int maxPosicoes;
    private int quantItens = 0;
    private ListaAlunos[] estrutura;

    public HashSondagemLinear(int tamVetor, int max) {
        this.maxItens = max;
        this.maxPosicoes = tamVetor;
        this.estrutura = new ListaAlunos[tamVetor];
        for (int i = 0; i < tamVetor; i++) {
            estrutura[i] = new ListaAlunos();
        }
    }

    public void inserir(Aluno aluno) {
        int local = aluno.getRa() % this.maxPosicoes;
        while (!estrutura[local].estaVazia()) {
            local = (local + 1) % this.maxPosicoes;
        }
        estrutura[local].adicionarAluno(aluno);
        quantItens++;
    }

    public Aluno deletar(int ra) {
        int local = ra % this.maxPosicoes;
        int tentativas = 0;
        while (tentativas < this.maxPosicoes) {
            if (!estrutura[local].estaVazia()) {
                ArrayList<Aluno> alunosNaPosicao = estrutura[local].getAlunos();
                for (int i = 0; i < alunosNaPosicao.size(); i++) {
                    if (alunosNaPosicao.get(i).getRa() == ra) {
                        Aluno alunoRemovido = alunosNaPosicao.get(i);
                        estrutura[local].removerAluno(alunoRemovido);
                        quantItens--;
                        return alunoRemovido;
                    }
                }
            }
            local = (local + 1) % this.maxPosicoes;
            tentativas++;
        }
        return null;
    }



    public ArrayList<Aluno> buscar(int ra) {
        ArrayList<Aluno> alunosEncontrados = new ArrayList<>();
        int local = ra % this.maxPosicoes;
        for (int i = 0; i < this.maxPosicoes; i++) {
            for (Aluno aluno : estrutura[local].getAlunos()) {
                if (aluno.getRa() == ra) {
                    alunosEncontrados.add(aluno);
                }
            }
            local = (local + 1) % this.maxPosicoes;
        }
        return alunosEncontrados;
    }

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
    public long buscarTempo(int ra) {
        long startTime = System.currentTimeMillis();
        ArrayList<Aluno> alunosEncontrados = buscar(ra);
        long endTime = System.currentTimeMillis();
        if (!alunosEncontrados.isEmpty()) {
            return endTime - startTime;
        }
        return -1;
    }
}
