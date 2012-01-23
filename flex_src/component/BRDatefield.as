package component
{
	import mx.controls.DateField;
	
	public class BRDatefield extends DateField
	{
		
		public function BRDatefield()
		{
			super();
			
			this.monthNames = ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro',
				'Outubro','Novembro','Dezembro'];
			
			this.dayNames = ['D','S','T','Q','Q','S','S'];
			
			this.formatString = "DD/MM/YYYY";
		}
	}
}