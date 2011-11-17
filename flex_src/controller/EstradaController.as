package controller
{
	import entity.Estrada;
	
	import model.BaseModel;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.managers.CursorManager;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class EstradaController
	{
		
		[Bindable]
		public var estradas: ArrayCollection = BaseModel.getInstance().estradas;
		private var estradaService: RemoteObject = new RemoteObject("estradaService");
		
		public function EstradaController()
		{
		}
		
		public function salvarEstrada(estrada: Estrada):void
		{
			var salvarEstradaToken: AsyncToken; 
			
			salvarEstradaToken = estradaService.salvarEstrada(estrada);
			salvarEstradaToken.addResponder(new Responder(salvarEstradaResult, salvarEstradaFault));
		}
		
		private function salvarEstradaResult(event : ResultEvent) : void 
		{
			Alert.show("Beleuza!");			
		}
		
		private function salvarEstradaFault(event : FaultEvent) : void {
			
			Alert.show(event.fault.message);
			
		}
		
		public function carregarEstradas(callbackSucesso:Function, callbackFalha:Function):void
		{
			var token: AsyncToken; 
			
			CursorManager.setBusyCursor();
			
			token = estradaService.carregarEstradas();
			token.addResponder(new mx.rpc.Responder(callbackSucesso, callbackFalha));
			
		}
		
		
		
	}
}