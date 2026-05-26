public class Cadastro {

    private String nome;
    private String email;
    private String cpf;

    public Cadastro(String nome, String email, String cpf) {

        this.nome = nome;
        this.email = email;
        this.cpf = cpf;

    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nEmail: " + email +
                "\nCPF: " + cpf;
    }

    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
}