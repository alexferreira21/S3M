package util
{
	import mx.controls.dataGridClasses.DataGridColumn;

	public class SentidoEnum
	{
		public static const POSITIVO:String = "POSITIVO";
		public static const NEGATIVO:String = "NEGATIVO";
		
		
		
		public static function traduzir(value:String):String
		{
			if (value == POSITIVO)
				return "Positivo";
			
			if (value == NEGATIVO)
				return "Negativo";
			
			return "";
		}
		
		public static function sentidoLabelFunction(data:Object):String
		{
			if(data!=null)
			{
				return traduzir(data.toString());
			}
			else
			{
				return null; 
			}
		}
		
		public static function sentidoDataGridLabelFunction(item:Object,column:DataGridColumn):String
		{
			return traduzir(item[column.dataField]);
		}
	}
}