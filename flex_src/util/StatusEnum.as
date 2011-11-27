package util
{
	import mx.controls.dataGridClasses.DataGridColumn;

	public class StatusEnum
	{
		public static const OPERANTE:String = "OPERANTE";
		public static const INOPERANTE:String = "INOPERANTE";
		
		
		
		public static function traduzir(value:String):String
		{
			if (value == OPERANTE)
				return "Operante";
			
			if (value == INOPERANTE)
				return "Inoperante";
			
			return "";
		}
		
		public static function statusLabelFunction(data:Object):String
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
		
		public static function statusDataGridLabelFunction(item:Object,column:DataGridColumn):String
		{
			return traduzir(item[column.dataField]);
		}
	}
}