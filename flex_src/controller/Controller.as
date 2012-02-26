package controller
{
	import mx.controls.Alert;
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
			Alert.show(event.fault.message);	
		}
	}
}