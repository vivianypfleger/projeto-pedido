package br.senai.sc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Categoria;
import br.senai.sc.domain.Cidade;
import br.senai.sc.domain.Estado;
import br.senai.sc.domain.Produto;
import br.senai.sc.repositories.CategoriaRepository;
import br.senai.sc.repositories.CidadeRepository;
import br.senai.sc.repositories.EstadoRepository;
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

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia");
		Cidade c2 = new Cidade(null, "São Paulo");
		Cidade c3 = new Cidade(null, "Campinas");
		
		p1.getCategorias().add(cat1);
		cat1.getProdutos().add(p1);

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

	}

}
