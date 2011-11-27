package events
{
	import entity.Equipamento;
	
	import flash.events.Event;

	public class EquipamentoEvent extends Event
	{
		public static const ADICIONAR_EQUIPAMENTO: String = "adicionarEquipamento";
		
		public var equipamento: Equipamento;
		
		public function EquipamentoEvent(type:String, equipamento: Equipamento, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.equipamento = equipamento;
			super(type, bubbles, cancelable);
		}
	}
}