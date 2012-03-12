package testes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import org.junit.Test;

import service.RelatorioService;
import dao.RelatorioDAO;
import dto.RelatorioDTO;

public class TesteRelatorios {

	private RelatorioDAO dao = new RelatorioDAO();
	private RelatorioService service = new RelatorioService();

	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void testDestinosPorUFeTipoMercadoriaDAO() throws ParseException {
		Date ini = formatter.parse("01/01/2012");
		Date fim = formatter.parse("01/08/2012");

		dao.destinosPorUFeTipoMercadoria(2L, 25L, ini, fim);
	}

	@Test
	public void testDestinosPorUFeTipoMercadoriaService() throws ParseException {

		Date ini = formatter.parse("01/01/2012");
		Date fim = formatter.parse("01/08/2012");

		service.destinosPorUFeTipoMercadoria(4L, ini, fim);
	}

	@Test
	public void testGerarRelatorio() throws ParseException, FileNotFoundException
	{
		Date ini = formatter.parse("01/01/2012");
		Date fim = formatter.parse("01/08/2012");

	
		final String FILE_PATH = "C:\\Users\\Alexandre\\Projeto Final\\Workspace\\S3M\\WebContent\\report\\cargasPorUf.jasper";
		
		File reportFile = new File(FILE_PATH);
		InputStream inpStream = new FileInputStream(reportFile);	
		JasperPrint print = null;
		HashMap param = new HashMap();
		
		List<RelatorioDTO> dados = service.destinosPorUFeTipoMercadoria(4L, ini, fim);
		
		JRDataSource jrds = new JRBeanCollectionDataSource(dados);	
		try {
			print = JasperFillManager.fillReport(inpStream, param, jrds);
		} catch (JRException e) {
			e.printStackTrace();
		}
		JasperViewer.viewReport(print);

	}



}
