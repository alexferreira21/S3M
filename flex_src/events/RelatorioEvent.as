package events
{
	import entity.TipoMercadoria;
	
	import flash.events.Event;
	
	public class RelatorioEvent extends Event
	{
		
		public static const GERAR_RELATORIO: String = "gerarRelatorio";
		
		public var tipoMercadoria: TipoMercadoria;
		public var dataInicial: Date;
		public var dataFinal: Date;
		
		public function RelatorioEvent(type:String, tm: TipoMercadoria, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.tipoMercadoria = tm;
		}
	}
}