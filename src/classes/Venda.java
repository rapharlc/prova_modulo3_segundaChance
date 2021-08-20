package classes;
import java.util.InputMismatchException;

public class Venda {

    private String dataDaVenda;
    private Produto produtoVendido;
    private int quantidadeVendida;


    public String getDataDaVenda() {
        return dataDaVenda;
    }
    public void setDataDaVenda(String dataDaVenda) {
        if (dataDaVenda.matches("\\d{2}/\\d{2}/\\d{4}")){
            this.dataDaVenda = dataDaVenda;
        }else {
            throw new InputMismatchException("A data deve ter o formato XX/YY/ZZZZ");
        }
        
    }
    public Produto getProdutoVendido() {
        return produtoVendido;
    }
    public void setProdutoVendido(Produto produtoVendido) {
        this.produtoVendido = produtoVendido;
    }
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    public Venda(String dataDaVenda, Produto produtoVendido, int quantidadeVendida) {
        this.dataDaVenda = dataDaVenda;
        this.produtoVendido = produtoVendido;
        this.quantidadeVendida = quantidadeVendida;
    }
    public Venda (){

    }
    


    

    

    
}
