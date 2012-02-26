package events
{
	import entity.Estrada;
	
	import flash.events.Event;
	
	public class EstradaSelecionadaEvent extends Event
	{
		public static const ESTRADA_SELECIONADA: String = "estradaSelecionada";
		
		public var estrada: Estrada;
		
		public function EstradaSelecionadaEvent(type:String, estrada: Estrada, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.estrada = estrada;
			super(type, bubbles, cancelable);
		}
	}
}
