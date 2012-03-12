package dto
{
	import entity.UF;
	
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="dto.RelatorioDTO")]
	public class RelatorioDTO
	{
				
		public var uf: UF;
		public var destinos: ArrayCollection;
	}
}