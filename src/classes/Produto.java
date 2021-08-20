package classes;
import java.util.InputMismatchException;

public class Produto {

    private String codigo;
    private String nome;
    private double valor;
    private int quantidadeEmEstoque;


    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.equals("")){
            this.codigo = codigo;
        }else {
            throw new InputMismatchException("O código não pode ser nulo!");    
        }
    }    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque != 0){
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        } else {
            throw new InputMismatchException("Você deve adicionar ao menos 1 unidade em estoque");
        }
    }
    public Produto(String codigo, String nome, double valor, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    public Produto (){

    }
    


    

    

}