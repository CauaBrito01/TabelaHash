import java.util.ArrayList;

public class ListaAlunos {
    private ArrayList<Aluno> alunos;

    public ListaAlunos() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public boolean estaVazia() {
        return alunos.isEmpty();
    }
}
