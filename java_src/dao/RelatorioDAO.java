package dao;

import hibernate.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class RelatorioDAO {
	
	private Session session = HibernateUtil.getInstance().getSession();
	private SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
	
	@SuppressWarnings("unchecked")
	public List<Object[]> destinosPorUFeTipoMercadoria(Long idTipoMercadoria, Long idUFOrigem, Date dataInicio, Date dataFim){
		
		Query query =
				session.createSQLQuery("select "+
						"uf_destino, count(uf_destino) as veiculos, sum(quantidade * fatorPeso) as peso, sum(valor) as valor "+
						"from ( "+
						"	select r.idVeiculo, timestamp as tempo_inicial, idUF as id_uf_origem, sigla_uf as uf_origem, idTipoMercadoria, TIPO_MERCADORIA, quantidade , valor, fatorPeso, ESTRADA from view_registro r "+
						"	inner join ( "+
						"		select idVeiculo, min(timestamp) as origem from view_registro  "+
						"		group by idVeiculo) sq_min on r.timestamp = sq_min.origem ) sq1 "+
						" "+
						"	inner join ( "+
						" "+
						"		select r.idVeiculo, timestamp as tempo_final, idUF as id_uf_destino, sigla_uf as uf_destino from view_registro r "+
						"		inner join ( "+
						"			select idVeiculo, max(timestamp) as destino from view_registro  "+
						"			group by idVeiculo) sq_max on r.timestamp = sq_max.destino) sq2 on sq2.idVeiculo = sq1.idVeiculo "+
						" "+
						"where id_uf_origem = "+ idUFOrigem +" "+
						"and idTipoMercadoria = "+ idTipoMercadoria +" "+
						"and tempo_inicial between '" + formatter.format(dataInicio) + "' AND '" + formatter.format(dataFim) +"' "+
						"group by uf_destino ");
		
		List<Object[]> retorno = query.list();
		return retorno;
	}
	
	
	
	

}
