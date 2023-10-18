import java.util.ArrayList;

public class HashEncadeamento {
    private int maxItens;
    private int maxPosicoes;
    private int quantItens = 0;
    private ListaAlunos[] estrutura;

    public HashEncadeamento(int tamVetor, int max) {
        this.maxItens = max;
        this.maxPosicoes = tamVetor;
        this.estrutura = new ListaAlunos[tamVetor];
        for (int i = 0; i < tamVetor; i++) {
            estrutura[i] = new ListaAlunos();
        }
    }

    public void inserir(Aluno aluno) {
        int local = aluno.getRa() % this.maxPosicoes;
        estrutura[local].adicionarAluno(aluno);
        quantItens++;
    }

    public boolean deletar(Aluno aluno) {
        int local = aluno.getRa() % this.maxPosicoes;
        if (!estrutura[local].estaVazia()) {
            ArrayList<Aluno> alunosNaPosicao = estrutura[local].getAlunos();
            for (int i = 0; i < alunosNaPosicao.size(); i++) {
                if (alunosNaPosicao.get(i).getRa() == aluno.getRa()) {
                    estrutura[local].removerAluno(alunosNaPosicao.get(i));
                    quantItens--;
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Aluno> buscar(int ra) {
        int local = ra % this.maxPosicoes;
        return estrutura[local].getAlunos();
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
}
