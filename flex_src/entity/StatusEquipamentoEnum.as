package entity
{
	import flash.sampler.NewObjectSample;
	
	import mx.collections.ArrayCollection;

	public class StatusEquipamentoEnum
	{
		
		public static const OPERANTE:StatusEquipamentoEnum = new StatusEquipamentoEnum(0,"OPERANTE");
		public static const INOPERANTE:StatusEquipamentoEnum = new StatusEquipamentoEnum(1,"INOPERANTE");
		
		private var _valor:Number;
		private var _status:String;
		
		
		public function StatusEquipamentoEnum(valor:Number, status:String)
		{
			_valor = valor;
			_status = status;
		}
		
		
	}
}