package controller
{
	
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;

	public class GraficosController extends Controller
	{
		
		public function GraficosController(callbackSucesso:Function)
		{
			super('graficosService')
			this.responder = new Responder(callbackSucesso,defaultFault); 
		}
		
		
		public function graficoValorPorMes(idEstrada: Number, dataInicial: Date, dataFinal: Date):void
		{
			var graficoToken: AsyncToken; 
			
			graficoToken = service.graficoValorPorMes(idEstrada, dataInicial, dataFinal);
			graficoToken.addResponder(responder);
		}
		
		
		public function graficoTiposDeVeiculos(idEstrada: Number, dataInicial: Date, dataFinal: Date):void
		{
			var graficoToken: AsyncToken; 
			
			graficoToken = service.graficoTiposDeVeiculos(idEstrada, dataInicial, dataFinal);
			graficoToken.addResponder(responder);
		}
		
		public function graficoPesoPorSemana(idEstrada: Number, dataInicial: Date, dataFinal: Date):void
		{
			var graficoToken: AsyncToken; 
			
			graficoToken = service.graficoPesoPorSemana(idEstrada, dataInicial, dataFinal);
			graficoToken.addResponder(responder);
		}
		
		public function graficoTipoDeCargaPorSemana(idEstrada: Number, diaSemana: int, dataInicial: Date, dataFinal: Date):void
		{
			var graficoToken: AsyncToken; 
			
			graficoToken = service.graficoTipoDeCargaPorSemana(idEstrada, 0, dataInicial, dataFinal);
			graficoToken.addResponder(responder);
		}
		
	}
}