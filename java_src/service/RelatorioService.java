package service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.bcel.generic.NEW;

import dao.RelatorioDAO;
import dto.DuplaValores;
import dto.RelatorioDTO;
import dto.UfInfo;
import entity.UF;


public class RelatorioService {

	PortalService portalService = new PortalService();
	RelatorioDAO relatorioDAO = new RelatorioDAO();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public List<RelatorioDTO> destinosPorUFeTipoMercadoria(Long idTipoMercadoria, Date dataInicio, Date dataFim){

		List<UF> ufs= portalService.getUFDataProvider();
		List<RelatorioDTO> retornoService = new ArrayList<RelatorioDTO>();


		for (UF ufItem : ufs)
		{
			List<Object[]> retornoDAO = relatorioDAO.destinosPorUFeTipoMercadoria(idTipoMercadoria, ufItem.getIdUF(), dataInicio, dataFim); 

			if(retornoDAO != null && retornoDAO.size() > 0)
			{
				RelatorioDTO dto = new RelatorioDTO();
				dto.setUf(ufItem);
				List<UfInfo> destinos = new ArrayList<UfInfo>();
				
				for(Object[] obj : retornoDAO)
				{
					UfInfo ufInfo = new UfInfo();

					ufInfo.setSigla((String)obj[0]);
					BigInteger bigVeiculos = (BigInteger)obj[1];
					ufInfo.setVeiculos(bigVeiculos.intValue());
					ufInfo.setQtd((Double)obj[2]);
					ufInfo.setValor((Double)obj[3]);
					
					destinos.add(ufInfo);
				}
				dto.setDestinos(destinos);
				retornoService.add(dto);
			}
		}

		return retornoService;

	}

}
