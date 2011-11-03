package mygoogle.events
{
	import com.google.maps.interfaces.IDirections;
	
	import flash.events.Event;
	
	public class RotaEvent extends Event
	{
		
		public static const SUCESSO_ROTA:String = "sucessoRota";
		
		public var direction: IDirections;
		
		public function RotaEvent(type:String, direction: IDirections, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.direction = direction;
			super(type, bubbles, cancelable);
		}
	}
}