package testes;

import static junit.framework.Assert.*;
import java.util.List;
import org.junit.Test;

import service.CargaService;
import entity.TipoMercadoria;

public class TipoMercadoriaTest {

	private CargaService service = new CargaService();
	
	@Test
	public void test() {
		List<TipoMercadoria> lista =  service.carregarTipoMercadoria();
		assertNotNull(lista);
	}

}
