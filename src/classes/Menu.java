package classes;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Menu {
        int opcao = 0;
        Scanner in = new Scanner (System.in);
        List <Produto> produtos = new ArrayList<>();
        List <Venda> vendas= new ArrayList<>();
        List <Venda> vendasRealizadas = new ArrayList<>();

    //metodo voltarMenu
    
    

    //menu principal
    public static void menu(){
        System.out.println("**** MENU ****");
        System.out.println("1 - Incluir Produto ");
        System.out.println("2 - Consultar produto ");
        System.out.println("3 - Listagem de produtos ");
        System.out.println("4 - Vendas por período ");
        System.out.println("5 - Realizar venda ");
        System.out.println("0 - Sair ");
        System.out.println("Opção: ");

    }

    //menu opcoes

    public void opcao1() {
        Produto produto = new Produto();
            do{
                try{
                    System.out.println("Informe o código do produto: ");
                    produto.setCodigo(in.nextLine());
                }catch(InputMismatchException ex){
                    System.out.println(ex.getMessage() + "Tente novamente");
                }
            } while(produto.getCodigo() == null || produto.getCodigo().equals(""));    
            System.out.println("Informe o nome do produto: ");
            produto.setNome(in.nextLine());
            System.out.println("Informe o valor do produto: ");
            produto.setValor(in.nextDouble());
            do{
                try{
                 System.out.println("Informe a quantidade desse produto: ");
                 produto.setQuantidadeEmEstoque(in.nextInt());
                } catch(InputMismatchException ex){
                    System.out.println(ex.getMessage());
                }
                    
            }while (produto.getQuantidadeEmEstoque() == 0);
            produtos.add(produto);
        
    }

    public void opcao2() throws InterruptedException, IOException{
        String codigoDoProdutoEncontrado = null;
            String nomeDoProdutoEncontrado = null;
            double valorDoProdutoEncontrado = 0;
            int quantidadeEmEstoqueDoPe = 0;
            int produtoEncontrado = 0;
            System.out.println("Informe o código do produto: ");
            String produtoBuscado = in.nextLine();
                for (Produto produto2 : produtos) {
                    if (produtoBuscado.equals(produto2.getCodigo())){
                        codigoDoProdutoEncontrado = produto2.getCodigo();
                        nomeDoProdutoEncontrado = produto2.getNome();
                        valorDoProdutoEncontrado = produto2.getValor();
                        quantidadeEmEstoqueDoPe = produto2.getQuantidadeEmEstoque();
                        
                        produtoEncontrado = 1;
                    } 
                }
            if (produtoEncontrado == 0){
                System.out.println("Produto não encontrado!");
                voltarMenu(in);
            }else if (produtoEncontrado == 1){
                
                    System.out.println("\n*** PRODUTO ENCONTRADO ***\n");
                    System.out.println("================================");
                    System.out.printf("Código do Produto: %s\n", codigoDoProdutoEncontrado );
                    System.out.printf("Nome do Produto: %s\n", nomeDoProdutoEncontrado);
                    System.out.printf("Valor: R$ %s\n", valorDoProdutoEncontrado);
                    System.out.printf("Quantidade em estoque: %d\n", quantidadeEmEstoqueDoPe);
    }
    
}

    public void opcao3() throws InterruptedException, IOException{
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados");
            voltarMenu(in);
            
        } else {
            Produto produto1 = produtos.get(0);
            double valorMedio = 0;
            double numeroDeProdutos = 0;
            double maiorValor = 0; 
            double menorValor = 0;
            double somaDeValores = 0; 
            System.out.println("");
            System.out.println("*** LISTA DE PRODUTOS ***");
            System.out.println("===========================");
            maiorValor = produto1.getValor();
            menorValor = produto1.getValor();
            somaDeValores = 0;
            for (Produto produto : produtos) {
                System.out.printf("Código: %s\n",produto.getCodigo());
                System.out.printf("Nome: %s\n",produto.getNome());
                System.out.printf("Valor unitário: %s\n",produto.getValor());
                System.out.printf("Quantidade em estoque: %d\n",produto.getQuantidadeEmEstoque());  
                if (produto.getValor() > maiorValor){
                    maiorValor = produto.getValor();
                }else if (produto.getValor() < menorValor){
                    menorValor = produto.getValor();
                }
                numeroDeProdutos = numeroDeProdutos + 1;
                somaDeValores = somaDeValores + produto.getValor();
                Thread.sleep(500);
            }
            valorMedio = (somaDeValores/numeroDeProdutos);
            System.out.println("*** VALORES ***");
            System.out.printf("Maior preço: R$ %s - Menor preço: R$ %s - Valor médio: R$ %s\n ", maiorValor, menorValor, valorMedio);
        }
    }

    public void opcao4() throws InterruptedException, IOException{
            if (vendas.isEmpty()){
                System.out.println("Não há vendas registradas!");
                voltarMenu(in);
                
            }
            double valorMedioDasVendas = 0;
            double quantidadeDeProdutosVendidosNoPeriodo = 0;
            double somaDoValorDasVendas = 0;
            boolean vendaEncontada = false;
            System.out.println("Informe o período que deseja consultar: ");
            String dataConsultada = in.nextLine();
            for (Venda venda : vendas) {
                if (dataConsultada.equals(venda.getDataDaVenda())){
                 vendasRealizadas.add(venda);  
                 vendaEncontada = true;  
                 quantidadeDeProdutosVendidosNoPeriodo = quantidadeDeProdutosVendidosNoPeriodo + 1;
                }
            
            }
            if (vendaEncontada = false){
                System.out.println("Não há vendas nesse período");
                Thread.sleep(2000);
                voltarMenu(in);
            }else if (vendaEncontada = true){
                System.out.println("");
                System.out.println("*** RELATÓRIO DE VENDAS ***");
                System.out.printf("Período consultado: %s\n", dataConsultada);
                System.out.println("====================================");
                Thread.sleep(1000);
                for (int i=0; i < vendasRealizadas.size(); i++){
                    somaDoValorDasVendas = somaDoValorDasVendas + (vendasRealizadas.get(i).getQuantidadeVendida() * vendasRealizadas.get(i).getProdutoVendido().getValor());
                    System.out.println("");
                    System.out.printf("Data da venda: %s\n", vendasRealizadas.get(i).getDataDaVenda());
                    System.out.printf("Nome do produto: %s\n", vendasRealizadas.get(i).getProdutoVendido().getNome());
                    System.out.printf("Valor unitário: R$ %s\n", vendasRealizadas.get(i).getProdutoVendido().getValor());
                    System.out.println("Valor total da venda: R$ " + (vendasRealizadas.get(i).getQuantidadeVendida() * vendasRealizadas.get(i).getProdutoVendido().getValor()) );
                    Thread.sleep(1000);
                }
                valorMedioDasVendas = somaDoValorDasVendas/quantidadeDeProdutosVendidosNoPeriodo;
                System.out.println("=======================================");
                System.out.println("VALOR MÉDIO DAS VENDAS DO PERÍODO");
                System.out.printf("Valor médio: R$ %s\n", valorMedioDasVendas);
                System.out.println("Pressione ENTER para continuar");
                vendasRealizadas.removeAll(vendas);
                in.nextLine();
            }
     }   
        
        public void opcao5() throws InterruptedException, IOException{
            if (produtos.isEmpty()){
                System.out.println("Você precisa ter produtos cadastrados para realizar uma venda!");
                voltarMenu(in);
                
            }
            Venda venda1 = new Venda();
            do{
                try{
            System.out.println("Informe a data: XX/YY/ZZZZ");
            venda1.setDataDaVenda(in.nextLine());
                }catch(InputMismatchException ex){
                    System.out.println(ex.getMessage() + " Tente Novamente");
                }
            } while (venda1.getDataDaVenda() == null);
            System.out.println("Informe o código do produto: ");
            String codigoDoProduto = in.nextLine();
            System.out.println("Informe a quantidade que deseja vender: ");
            int quantidadeVendida = in.nextInt();
            int vendaRealizadaComSucesso = 0;
            for (Produto produto : produtos) {
                if (codigoDoProduto.equals(produto.getCodigo())){
                    Produto produtoVendido = produto;
                    if (quantidadeVendida > produtoVendido.getQuantidadeEmEstoque()){
                        do{
                        System.out.println("Não há quantidade suficiente em estoque!");
                        System.out.println("Informe a quantidade que deseja vender: ");
                        quantidadeVendida = in.nextInt();
                        } while (quantidadeVendida > produtoVendido.getQuantidadeEmEstoque());
                    }
                Venda venda = new Venda(venda1.getDataDaVenda(), produtoVendido, quantidadeVendida);  
                vendas.add(venda);  
                vendaRealizadaComSucesso = 1;
                produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque()-quantidadeVendida);
                System.out.println("Venda realizada com sucesso!");
                Thread.sleep(2000);
                voltarMenu(in);
                
                } 
                
         
            }
            if (vendaRealizadaComSucesso == 0){
                    
                    System.out.println("Produto não encontrado!");
                    Thread.sleep(2000);
                    voltarMenu(in);
            }    
        }
    
    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
    System.out.println("\nPressione ENTER para voltar ao menu.");
    in.nextLine();

    if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    else
        System.out.print("\033[H\033[2J");

    System.out.flush();
    }   
}
