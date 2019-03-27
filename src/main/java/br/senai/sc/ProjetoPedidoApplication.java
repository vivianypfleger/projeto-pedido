package br.senai.sc;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Categoria;
import br.senai.sc.domain.Cidade;
import br.senai.sc.domain.Cliente;
import br.senai.sc.domain.Endereco;
import br.senai.sc.domain.Estado;
import br.senai.sc.domain.ItemPedido;
import br.senai.sc.domain.Pedido;
import br.senai.sc.domain.Produto;
import br.senai.sc.domain.enums.TipoCliente;
import br.senai.sc.repositories.CategoriaRepository;
import br.senai.sc.repositories.CidadeRepository;
import br.senai.sc.repositories.ClienteRepository;
import br.senai.sc.repositories.EnderecoRepository;
import br.senai.sc.repositories.EstadoRepository;
import br.senai.sc.repositories.ItemPedidoRepository;
import br.senai.sc.repositories.PedidoRepository;
import br.senai.sc.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoPedidoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPedidoApplication.class, args);
	}

	@Autowired
	private CategoriaRepository RepoCat;

	@Autowired
	private ProdutoRepository RepoProd;

	@Autowired
	private EstadoRepository RepoEsta;
	
	@Autowired
	private CidadeRepository RepoCidade;
	
	@Autowired
	private EnderecoRepository RepoEndereco;
	
	@Autowired
	private ClienteRepository RepoCliente;
	
	@Autowired
	private PedidoRepository RepoPedido;
	
	@Autowired
	private ItemPedidoRepository RepoItemPedido;
	

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas",est2);
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", c2);
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAJURIDICA);
				
		
		p1.getCategorias().add(cat1);
		cat1.getProdutos().add(p1);
				
		est1.getCidades().add(c1);
		est2.getCidades().add(c2);
		est2.getCidades().add(c3);
		
		cli1.getEnderecos().add(e1);
		cli1.getEnderecos().add(e2);
		cli1.getTelefones().add("(48) 99999-8888");
		cli1.getTelefones().add("(48) 99999-1111");
		
		RepoCat.save(cat1);
		RepoCat.save(cat2);
		
		RepoProd.save(p1);
		RepoProd.save(p2);
		RepoProd.save(p3);
		
		RepoEsta.save(est1);
		RepoEsta.save(est2);
			
		RepoCidade.save(c1);
		RepoCidade.save(c2);
		RepoCidade.save(c3);
		
		RepoCliente.save(cli1);
		
		RepoEndereco.save(e1);
		RepoEndereco.save(e2);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"), cli1, e1);
		
		ItemPedido item1 = new ItemPedido(ped1, p1, 0.0, 1, 1000.0);
		
		RepoPedido.save(ped1);
		RepoItemPedido.save(item1);

	}

}
