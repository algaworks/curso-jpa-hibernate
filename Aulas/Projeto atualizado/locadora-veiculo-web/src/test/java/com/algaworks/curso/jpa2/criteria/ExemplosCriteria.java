package com.algaworks.curso.jpa2.criteria;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class ExemplosCriteria {

	private static EntityManagerFactory factory;
	
	private EntityManager manager;
	
	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}
	
	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		this.manager.close();
	}
	
	@Test
	public void consultaModeloFiltrandoFabricante() {
		
		/*List<String> modelos = manager.createQuery("select mc.descricao "
				+ "from ModeloCarro mc where mc.fabricante.nome = 'Chevrolet 2'",
	    		 String.class).getResultList();
	    				
		for (String modelo : modelos) {
			System.out.println(modelo);	
		}*/
	}
	
	@Test
	public void projecoes() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.select(carro.<String>get("placa"));
		
		TypedQuery<String> query = manager.createQuery(criteriaQuery);
		List<String> placas = query.getResultList();
		
		for (String placa : placas) {
			System.out.println(placa);
		}
	}
	
	@Test
	public void funcoesDeAgregacao() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<BigDecimal> criteriaQuery = builder.createQuery(BigDecimal.class);
		
		Root<Aluguel> aluguel = criteriaQuery.from(Aluguel.class);
		criteriaQuery.select(builder.sum(aluguel.<BigDecimal>get("valorTotal")));
		
		TypedQuery<BigDecimal> query = manager.createQuery(criteriaQuery);
		BigDecimal total = query.getSingleResult();
		
		System.out.println("Soma de todos os alugueis: " + total);
	}
	
	@Test
	public void resultadoComplexo() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.multiselect(carro.get("placa"), carro.get("valorDiaria"));
		
		TypedQuery<Object[]> query = manager.createQuery(criteriaQuery);
		List<Object[]> resultado = query.getResultList();
		
		for (Object[] valores : resultado) {
			System.out.println(valores[0] + " - " + valores[1]);
		}
	}
	
	@Test
	public void resultadoTupla() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = builder.createTupleQuery();
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.multiselect(carro.get("placa").alias("placaCarro")
						, carro.get("valorDiaria").alias("valorCarro"));
		
		TypedQuery<Tuple> query = manager.createQuery(criteriaQuery);
		List<Tuple> resultado = query.getResultList();
		
		for (Tuple tupla : resultado) {
			System.out.println(tupla.get("placaCarro") + " - " + tupla.get("valorCarro"));
		}
	}
	
	@Test
	public void resultadoConstrutores() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<PrecoCarro> criteriaQuery = builder.createQuery(PrecoCarro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.select(builder.construct(PrecoCarro.class, 
						carro.get("placa"), carro.get("valorDiaria")));
		
		TypedQuery<PrecoCarro> query = manager.createQuery(criteriaQuery);
		List<PrecoCarro> resultado = query.getResultList();
		
		for (PrecoCarro precoCarro : resultado) {
			System.out.println(precoCarro.getPlaca() + " - " + precoCarro.getValor());
		}
	}
	
	@Test
	public void exemploFuncao() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Predicate predicate = builder.equal(builder.upper(carro.<String>get("cor")), 
									"prata".toUpperCase());
		
		criteriaQuery.select(carro);
		criteriaQuery.where(predicate);
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getCor());
		}
	}
	
	@Test
	public void exemploOrdenacao() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Order order = builder.desc(carro.get("valorDiaria"));
		
		criteriaQuery.select(carro);
		criteriaQuery.orderBy(order);
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getValorDiaria());
		}
	}
	
	@Test
	public void exemploJoinEFetch() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Join<Carro, ModeloCarro> modelo = (Join) carro.fetch("modelo");
		
		criteriaQuery.select(carro);
		criteriaQuery.where(builder.equal(modelo.get("descricao"), "Fit"));
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca());
		}
	}
	
	@Test
	public void mediaDasDiariasDosCarros() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Double> criteriaQuery = builder.createQuery(Double.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.select(builder.avg(carro.<Double>get("valorDiaria")));
		
		TypedQuery<Double> query = manager.createQuery(criteriaQuery);
		Double total = query.getSingleResult();
		
		System.out.println("Média da diária: " + total);
	}
	
	@Test
	public void carrosComValoresAcimaDaMedia() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		Subquery<Double> subquery = criteriaQuery.subquery(Double.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Root<Carro> carroSub = subquery.from(Carro.class);
		
		subquery.select(builder.avg(carroSub.<Double>get("valorDiaria")));
		
		criteriaQuery.select(carro);
		criteriaQuery.where(builder.greaterThanOrEqualTo(carro.<Double>get("valorDiaria"), subquery));
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getValorDiaria());
		}
		
	}
	
	@Test
	public void testeAlexandre() {
		//Query query = this.manager.createNativeQuery("select c.placa, m.descricao from Carro c, ModeloCarro m where c.codigo_modelo = m.codigo");
		//List<CarModelTemp> resultado = query.getResultList();
		
		Query query = this.manager.createNativeQuery("select * from Carro", Carro.class);
		List<Carro> carros = query.getResultList();
		for (Carro c : carros) {
			System.out.println(c.getPlaca());
			System.out.println(c.getModelo().getDescricao());
		}
	}
	
	
}










