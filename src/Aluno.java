// Classe que representa um objeto Aluno com atributos RA e nome.
public class Aluno {
    private int ra; // Atributo para armazenar o Registro Acadêmico (RA) do aluno.
    private String nome; // Atributo para armazenar o nome do aluno.

    // Construtor da classe Aluno. Inicializa os atributos RA e nome do aluno.
    public Aluno(int ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    // Método para obter o RA do aluno.
    public int getRa() {
        return ra;
    }

    // Método para obter o nome do aluno.
    public String getNome() {
        return nome;
    }
}
