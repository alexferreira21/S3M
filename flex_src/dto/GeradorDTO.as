package dto
{
	import entity.Estrada;
	import entity.Segmento;
	
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="dto.GeradorDTO")]
	public class GeradorDTO
	{
		public var dataInicial: Date; 
		public var dataFinal: Date;
		
		public var horaInicial: int;
		public var minutoInicial: int;
		
		public var horaFinal: int;
		public var minutoFinal: int;
		
		public var estrada: Estrada;
		
		public var segmentoInicial: Segmento;
		public var segmentoFinal: Segmento;
		
		public var fluxosEntrada: ArrayCollection;
		public var fluxosSaida: ArrayCollection;
		
		public var qtdCaminhoes: int;
		public var qtdOutrosVeiculos: int;
		
		public var velocidadeInicial: int;
		public var velocidadeFinal: int;
		
		public var sentido: String;
		
		public var tiposCarga: ArrayCollection;
		
	}
}