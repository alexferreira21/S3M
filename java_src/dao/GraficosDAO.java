package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.HibernateUtil;

public class GraficosDAO {

	private Session session = HibernateUtil.getInstance().getSession();
	private SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");

	@SuppressWarnings("unchecked")
	public List<Object[]> graficoValorPorMes(Long idEstrada, Date dataInicio, Date dataFim){

		Query query = 
				session.createSQLQuery("SELECT mes, valor " +
						"FROM " +
						"( " +
						"SELECT DATE_FORMAT(registro.timestamp,\"%m\") AS mes, carga.valor AS valor, tm.fatorPeso AS fator_peso " +
						"FROM tb_registro registro " +
						"INNER JOIN tb_cte cte ON cte.id = registro.idCTE " +
						"INNER JOIN tb_carga_predominante carga ON carga.id = cte.idCargaPredominante " +
						"INNER JOIN tb_tipo_mercadoria tm ON tm.idTipoMercadoria = carga.idTipoMercadoria " +
						"INNER JOIN tb_equipamento eqp ON eqp.idEquipamento = registro.idEquipamento " +
						"INNER JOIN tb_portal portal ON portal.idPortal = eqp.idPortal " +
						"INNER JOIN tb_segmento seg ON seg.portalOrigem_idPortal = portal.idPortal " +
						"INNER JOIN tb_estrada estrada ON estrada.idEstrada = seg.idEstrada " +
						"WHERE estrada.idEstrada = " + idEstrada + " AND registro.timestamp BETWEEN '" + formatter.format(dataInicio) + "' AND '" + formatter.format(dataFim) +"' "+
						"GROUP BY mes, valor " +
						"ORDER BY mes) sq " +
						"GROUP BY mes " +
						"ORDER BY mes ASC ");

		List<Object[]> retorno = query.list();
		return retorno;
	}


	@SuppressWarnings("unchecked")
	public List<Object[]> graficoTiposDeVeiculos(Long idEstrada, Date dataInicio, Date dataFim){
		Query query = 
				session.createSQLQuery
				("SELECT et.descricao AS descricao, COUNT(idVeiculo) * 100 AS total "+
						"FROM tb_registro r "+
						"	INNER JOIN tb_veiculo v ON r.idVeiculo = v.id "+
						"	INNER JOIN tb_especie_tipo et ON et.id = v.idEspecie_Tipo "+
						"	INNER JOIN ( "+
						"		SELECT DISTINCT COUNT(idVeiculo) AS total "+
						"		FROM tb_registro r  "+
						"			INNER JOIN tb_equipamento eqp ON eqp.idEquipamento = r.idEquipamento "+
						"			INNER JOIN tb_portal p ON p.idPortal = eqp.idPortal "+
						"			INNER JOIN tb_segmento seg ON seg.portalOrigem_idPortal = p.idPortal "+
						"			INNER JOIN tb_estrada e ON e.idEstrada = seg.idEstrada "+
						"		WHERE e.idEstrada = 3 AND TIMESTAMP BETWEEN '" + formatter.format(dataInicio) + "' AND '" + formatter.format(dataFim) +"') sq  "+
						"	ON 1 = 1 "+
						"	INNER JOIN tb_equipamento eqp ON eqp.idEquipamento = r.idEquipamento "+
						"	INNER JOIN tb_portal p ON p.idPortal = eqp.idPortal "+
						"	INNER JOIN tb_segmento seg ON seg.portalOrigem_idPortal = p.idPortal "+
						"	INNER JOIN tb_estrada e ON e.idEstrada = seg.idEstrada "+
						"WHERE e.idEstrada = " + idEstrada + " AND TIMESTAMP BETWEEN '" + formatter.format(dataInicio) + "' AND '" + formatter.format(dataFim) +"' "+
						"GROUP BY descricao ");


		List<Object[]> retorno = query.list();
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> graficoPesoPorSemana(Long idEstrada, Date dataInicio, Date dataFim){
		Query query = 
				session.createSQLQuery
				("SELECT dia, sum(qtd) * fator_peso as peso "+
						"FROM  "+
						"( "+
						"	SELECT DATE_FORMAT(registro.timestamp,\"%w\") AS dia, tm.descricao AS descricao, carga.quantidade as qtd, tm.fatorPeso as fator_peso "+
						"	FROM tb_registro registro "+
						"		INNER JOIN tb_cte cte ON cte.id = registro.idCTE "+
						"		INNER JOIN tb_carga_predominante carga ON carga.id = cte.idCargaPredominante "+
						"		INNER JOIN tb_tipo_mercadoria tm ON tm.idTipoMercadoria = carga.idTipoMercadoria "+
						"		 "+
						"		INNER JOIN tb_equipamento eqp ON eqp.idEquipamento = registro.idEquipamento "+
						"		INNER JOIN tb_portal p ON p.idPortal = eqp.idPortal "+
						"		INNER JOIN tb_segmento seg ON seg.portalOrigem_idPortal = p.idPortal "+
						"		INNER JOIN tb_estrada e ON e.idEstrada = seg.idEstrada "+
						"	WHERE e.idEstrada = " + idEstrada + " AND TIMESTAMP BETWEEN '" + formatter.format(dataInicio) + "' AND '" + formatter.format(dataFim) +"' "+
						"	GROUP BY dia, descricao "+
						"	ORDER BY dia) sq "+
						"GROUP BY dia");

		List<Object[]> retorno = query.list();
		return retorno;
	}


	@SuppressWarnings("unchecked")
	public List<Object[]> graficoTipoDeCargaPorSemana(Long idEstrada, Integer diaSemana, Date dataInicio, Date dataFim){
		Query query = 
				session.createSQLQuery
				("SELECT distinct tm.descricao, SUM(carga.quantidade)  "+
						" FROM tb_registro registro "+
						" INNER JOIN tb_cte cte ON cte.id = registro.idCTE "+
						" INNER JOIN tb_carga_predominante carga ON carga.id = cte.idCargaPredominante "+
						" INNER JOIN tb_tipo_mercadoria tm ON tm.idTipoMercadoria = carga.idTipoMercadoria "+
						" "+
						" INNER JOIN tb_equipamento eqp ON eqp.idEquipamento = registro.idEquipamento "+
						" INNER JOIN tb_portal p ON p.idPortal = eqp.idPortal "+
						" INNER JOIN tb_segmento seg ON seg.portalOrigem_idPortal = p.idPortal "+
						" INNER JOIN tb_estrada e ON e.idEstrada = seg.idEstrada "+
						//" WHERE DATE_FORMAT(registro.timestamp,\"%w\") = " + diaSemana + " and e.idEstrada = " + idEstrada + " " +
						" WHERE e.idEstrada = " + idEstrada + " " +
						"   AND TIMESTAMP BETWEEN '" + formatter.format(dataInicio) + "' AND '" + formatter.format(dataFim) +"' "+
						" GROUP BY tm.descricao");
		
		List<Object[]> retorno = query.list();
		return retorno;
	}

}
