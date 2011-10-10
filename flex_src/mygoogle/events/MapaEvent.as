package mygoogle.events
{
	import com.google.maps.MapEvent;
	
	
	public class MapaEvent extends MapEvent
	{
		
		public static const MAPA_PRONTO:String = "mapaPronto";
		public static const MAPA_PRE_INICIALIZACAO:String = "mapaPreInicializacao";
		
		public function MapaEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		
	}
}