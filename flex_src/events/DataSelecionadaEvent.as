package events
{
	
	import flash.events.Event;
	
	public class DataSelecionadaEvent extends Event
	{
		public static const DATA_ALTERADA: String = "dataAlterada";
		
		public var dataSelecionada: Date;
		
		public function DataSelecionadaEvent(type:String, dataSelecionada: Date, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.dataSelecionada = dataSelecionada;
			super(type, bubbles, cancelable);
		}
	}
}
