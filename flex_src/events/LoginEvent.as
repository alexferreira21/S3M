package events
{
	import flash.events.Event;
	
	public class LoginEvent extends Event
	{
		
		public static const LOGIN: String = "login";
		
		public var login: String;
		public var senha: String;
		
		public function LoginEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
	}
}