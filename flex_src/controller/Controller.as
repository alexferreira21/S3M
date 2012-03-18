package controller
{
	import mx.controls.Alert;
	import mx.managers.CursorManager;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class Controller
	{
		
		protected var service: RemoteObject;
		protected var responder: Responder;
		
		
		public function Controller(service: String)
		{
			this.service = new RemoteObject(service);
		}
		
		protected function setResultFunction(callbackFunction: Function):void
		{
			if(callbackFunction != null)
			{
				this.responder = new Responder(callbackFunction,defaultFault);
			}
			else
			{
				this.responder = new Responder(defaultResult,defaultFault);
			}
		}
		
		public function defaultFault(event: FaultEvent):void
		{
			CursorManager.removeBusyCursor();
			Alert.show(event.fault.message);	
		}
		
		public function defaultResult(event: ResultEvent):void
		{
			CursorManager.removeBusyCursor();
		}
	}
}