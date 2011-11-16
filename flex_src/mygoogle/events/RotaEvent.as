package mygoogle.events
{
	import com.google.maps.interfaces.IDirections;
	
	import entity.Segmento;
	
	import flash.events.Event;
	
	public class RotaEvent extends Event
	{
		
		public static const SUCESSO_ROTA:String = "sucessoRota";
		
		public var direction: IDirections;
		public var segmento:Segmento;
		
		public function RotaEvent(type:String, direction: IDirections, segmento: Segmento, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.segmento = segmento;
			this.direction = direction;
			super(type, bubbles, cancelable);
		}
	}
}