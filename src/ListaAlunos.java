import java.util.ArrayList;  // Importa a classe ArrayList do pacote java.util.

// Classe que representa uma lista de alunos.
public class ListaAlunos {
    private ArrayList<Aluno> alunos;  // Declaração de um ArrayList para armazenar objetos da classe Aluno.

    // Construtor da classe ListaAlunos. Inicializa a lista de alunos como um novo ArrayList.
    public ListaAlunos() {
        this.alunos = new ArrayList<>();
    }

    // Método para adicionar um aluno à lista.
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);  // Adiciona o objeto Aluno à lista de alunos.
    }

    // Método para obter a lista de alunos.
    public ArrayList<Aluno> getAlunos() {
        return alunos;  // Retorna a lista de alunos.
    }

    // Método para remover um aluno da lista.
    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);  // Remove o objeto Aluno da lista de alunos.
    }

    // Método para verificar se a lista de alunos está vazia.
    public boolean estaVazia() {
        return alunos.isEmpty();  // Retorna true se a lista estiver vazia, false caso contrário.
    }
}
