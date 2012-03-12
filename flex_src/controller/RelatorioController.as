package controller
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;

	public class RelatorioController extends Controller
	{
		
		public function RelatorioController(callbackSucesso:Function)
		{
			super('relatorioService')
			this.responder = new Responder(callbackSucesso,defaultFault); 
		}
		
		
		public function destinosPorUFeTipoMercadoria(idTipoMercadoria: Number, dataInicio: Date, dataFim: Date):void
		{
			var relatorioToken: AsyncToken; 
			
			relatorioToken = service. destinosPorUFeTipoMercadoria(idTipoMercadoria, dataInicio, dataFim);
			relatorioToken.addResponder(responder);
		}
		
		
	}
}