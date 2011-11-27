package events
{
	import entity.FluxoAlternativo;
	
	import flash.events.Event;
	
	public class FluxoAlternativoEvent extends Event
	{
		public static const ADICIONAR_FLUXO_ALTERNATIVO: String = "adicionarFluxoAlternativo";
		
		public var fluxoAlternativo: FluxoAlternativo;
		
		public function FluxoAlternativoEvent(type:String, fluxoAlternativo: FluxoAlternativo, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.fluxoAlternativo = fluxoAlternativo;
			super(type, bubbles, cancelable);
		}
	}
}
