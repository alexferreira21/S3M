package entity
{
	public class TipoMercadoria
	{
		public var idTipoMercadoria: Number;
		public var descricao: String;
		public var fatorPeso: Number;
		
		[Transient]
		public var isSelected: Boolean;
	}
}