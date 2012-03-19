package servlets;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RelatorioService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import dto.RelatorioDTO;
import flex.messaging.io.ArrayList;

/**
 * 
 * @author root
 * @version
 */

@SuppressWarnings("serial")
public class RelatorioCargas extends HttpServlet {
	
	private static final String FILE_PATH = "C:\\Users\\Alexandre\\Projeto Final\\Workspace\\S3M\\WebContent\\report\\cargasPorUf.jasper";

	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String,Object> parameters = new HashMap<String,Object>();
		
		String idMercadoria = request.getParameter("idTipoMercadoria");
		String ini = request.getParameter("dataInicial");
		String fim = request.getParameter("dataFinal");
		
		RelatorioService service = new RelatorioService();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicial = new Date();
		Date dataFinal = new Date();
		try {
			dataInicial = formatter.parse(ini);
			dataFinal = formatter.parse(fim);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<RelatorioDTO> dados = service.destinosPorUFeTipoMercadoria(Long.parseLong(idMercadoria), dataInicial, dataFinal);
		
		Long totalGeralVeiculos = 0L;
		Double totalGeralPeso = 0.0; 
		Double totalGeralValor = 0.0;

		for(RelatorioDTO item : dados)
		{
			item.setTotalVeiculos();
			totalGeralVeiculos = totalGeralVeiculos + Long.parseLong(item.getTotalVeiculos());
			
			item.setTotalPeso();
			totalGeralPeso = totalGeralPeso + Double.parseDouble(item.getTotalPeso());
			
			item.setTotalValor();
			totalGeralValor = totalGeralValor + Double.parseDouble(item.getTotalValor());
		}
		

		parameters.put("tipoMercadoria", request.getParameter("tipoMercadoria"));
		parameters.put("dtInicial", ini);
		parameters.put("dtFinal", fim);
		parameters.put("totalGeralVeiculos", totalGeralVeiculos);
		parameters.put("totalGeralPeso", totalGeralPeso);
		parameters.put("totalGeralValor", totalGeralValor);
		
		byte[] bytes = null;			
		
		
		JRDataSource jrds = new JRBeanCollectionDataSource(dados);
		
		try {
			bytes = JasperRunManager.runReportToPdf(FILE_PATH,parameters, jrds);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (bytes != null && bytes.length > 0) {
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream = response
					.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		}		
		
	}

}