package main
{
	import com.google.maps.LatLng;
	
	import flash.events.Event;
	
	public class MarkerPortalEvent extends Event
	{
		
		public static const ANTENA_SELECIONADA:String = "antenaSelecionada"
		public static const ANTENA_DESSELECIONADA:String = "antenaDesselecionada"
			
			
		public var latLng:LatLng;
		
		public function MarkerPortalEvent(type:String, latLng:LatLng, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.latLng = latLng;
			super(type, bubbles, cancelable);
		}
	}
}