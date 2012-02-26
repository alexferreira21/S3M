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

	public class GeradorTrafegoController extends Controller
	{
		
		public function GeradorTrafegoController(callbackSucesso:Function)
		{
			super('geradorService');
			this.responder = new Responder(callbackSucesso,defaultFault);
		}
		
		public function gerarTrafego(geradorDTO: GeradorDTO): void
		{
			var geradorToken: AsyncToken; 
			
			geradorToken = service.gerarTrafego(geradorDTO);
			geradorToken.addResponder(responder);
		}
		
	}
}