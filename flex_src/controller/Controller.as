package controller
{
	import mx.controls.Alert;
	import mx.managers.CursorManager;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class Controller
	{
		
		protected var service: RemoteObject;
		protected var responder: Responder;
		
		
		public function Controller(service: String)
		{
			this.service = new RemoteObject(service);
		}
		
		public function defaultFault(event: FaultEvent):void
		{
			CursorManager.removeBusyCursor();
			Alert.show(event.fault.message);	
		}
	}
}