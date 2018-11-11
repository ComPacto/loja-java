
package projloja;


public class Cliente {
   private String nome;
   private long cpf;
   private int codigo;
   Endereco objEndereco;

    public Cliente() {
        this.objEndereco= new Endereco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "\n"
                + "Nome: " + nome + "\n"
                + "CPF: " + cpf + "\n"
                + "Código: " + codigo + "\n"
                + "Endereco: " + objEndereco;
    }
    
    
   
}
