package controller
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class CargaController
	{
		
		private var cargaService: RemoteObject = new RemoteObject("cargaService");
		
		public function carregarTiposMercadorias(callbackSucesso:Function): void
		{
			var salvarEstradaToken: AsyncToken; 
			
			salvarEstradaToken = cargaService.carregarTipoMercadoria();
			salvarEstradaToken.addResponder(new Responder(callbackSucesso, defaultFault));
		}
		
		public function defaultFault(event: FaultEvent):void
		{
			Alert.show(event.fault.message);	
		}
	
	}
}