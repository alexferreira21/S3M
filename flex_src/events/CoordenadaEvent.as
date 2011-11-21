package events
{
	import com.google.maps.LatLng;
	
	import flash.events.Event;
	
	public class CoordenadaEvent extends Event
	{
	
		public static const NOVA_COORDENADA: String = "novaCoordenada";
		
		public var latLng: LatLng;
		
		public function CoordenadaEvent(type:String, latLng: LatLng, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.latLng = latLng;
			super(type, bubbles, cancelable);
		}
	}
}