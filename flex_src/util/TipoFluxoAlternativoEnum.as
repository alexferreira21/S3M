package util
{
	import mx.controls.dataGridClasses.DataGridColumn;

	public class TipoFluxoAlternativoEnum
	{
		
		public function TipoFluxoAlternativoEnum()
		{
		}
		
		public static const ENTRADA:String = "ENTRADA";
		public static const SAIDA:String = "SAIDA";
		public static const ENTRADA_SAIDA:String = "ENTRADA_SAIDA";
		
			
		
		public static function traduzir(value:String):String
		{
			if (value == ENTRADA)
				return "Entrada";
			
			if (value == SAIDA)
				return "Saida";
			
			if (value == ENTRADA_SAIDA)
				return "Entrada/Saida";
			
			
			return "";
		}
		
		public static function fluxoAlternativoLabelFunction(data:Object):String
		{
			if(data!=null)
			{
				return TipoFluxoAlternativoEnum.traduzir(data.toString());
			}
			else
			{
				return null; 
			}
		}
		
		public static function fluxoAlternativoDataGridLabelFunction(item:Object,column:DataGridColumn):String
		{
			return traduzir(item[column.dataField]);
		}
		
	}
}