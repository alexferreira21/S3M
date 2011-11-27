package events
{
	
	import entity.Segmento;
	
	import flash.events.Event;
	
	public class SegmentoEvent extends Event
	{
		public static const ADICIONAR_SEGMENTO: String = "adicionarSegmento";
		
		public var segmento: Segmento;
		
		public function SegmentoEvent(type:String, segmento: Segmento, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.segmento = segmento;
			super(type, bubbles, cancelable);
		}
	}
}