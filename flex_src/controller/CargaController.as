package controller
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class CargaController extends Controller
	{
		public function CargaController()
		{
			super('cargaService');
		}
		
		public function carregarTiposMercadorias(callbackSucesso:Function): void
		{
			var cargaToken: AsyncToken; 
			
			cargaToken = service.carregarTipoMercadoria();
			cargaToken.addResponder(new Responder(callbackSucesso, defaultFault));
		}
		
		
	
	}
}