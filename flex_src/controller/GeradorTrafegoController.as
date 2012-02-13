package controller
{
	import dto.GeradorDTO;
	
	import flash.sampler.NewObjectSample;
	
	import mx.controls.Alert;
	import mx.managers.CursorManager;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class GeradorTrafegoController
	{
		private var geradorService: RemoteObject = new RemoteObject("geradorService");
		private var responder: Responder;
		
		
		public function GeradorTrafegoController(callbackSucesso:Function)
		{
			this.responder = new Responder(callbackSucesso,defaultFault);
		}
		
		public function gerarTrafego(geradorDTO: GeradorDTO): void
		{
			var geradorToken: AsyncToken; 
			
			geradorToken = geradorService.gerarTrafego(geradorDTO);
			geradorToken.addResponder(responder);
		}
		
		public function defaultFault(event: FaultEvent):void
		{
			CursorManager.removeBusyCursor();
			Alert.show(event.fault.message);	
		}
	}
}