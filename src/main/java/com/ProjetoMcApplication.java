package com;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.models.Categoria;
import com.models.Cidade;
import com.models.Estado;
import com.models.Produtos;
import com.repository.CategoriaRepository;
import com.repository.CidadeRepository;
import com.repository.EstadoRepository;
import com.repository.ProdutoRepository;


//Interface CommandLineRunner - usa para executar comandos quando do SpringApplication.run

@SpringBootApplication
public class ProjetoMcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//I - instancias da categorias e produtos.
		Categoria cat1= new Categoria (null, "Categoria 1 - informatica1");
		Categoria cat2= new Categoria (null, "Categoria 2 - escritorio1");
		
		Produtos p1 = new Produtos(null, "Computador1", 2000.00);
		Produtos p2 = new Produtos(null, "Impressora1", 1000.00);
		Produtos p3 = new Produtos(null, "Mouse1", 100.00);
		
		//associar os 3 produtos a categoria 1.
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));		
		//associar os 3 produtos a categoria 2.
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		//p1 somente cat 1 
		//p2 - cat 1,2
		//p3 - cat 1.
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//salvar
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		//II - instancias das cidades e estados de acordo com UML.
		
		//associacoes cidades e estados.
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "SP");
				
		Cidade cidade1 = new Cidade(null, "Uberlandia", estado1);
		Cidade cidade2 = new Cidade(null, "SP", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);
		
		//insercao lista as cidades aos seus estados.		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		//salvar Estados depois Cidade.
		estadoRepository.save(Arrays.asList(estado1, estado2));
		cidadeRepository.save(Arrays.asList(cidade1, cidade2, cidade3));
		
		
	}
	

}	
	
	

