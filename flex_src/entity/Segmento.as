package entity
{
	[RemoteClass(alias="entity.Segmento")]
	public class Segmento
	{
		
		private var _idSegmento: Number;
		private var _nome: String;
		private var _kmInicial: int;
		private var _kmFinal: int;
		private var _portalOrigem: Portal;
		private var _portalDestino: Portal;
		private var _estrada: Estrada;
		
		
		
		public function Segmento()
		{
		}

		public function get idSegmento():Number
		{
			return _idSegmento;
		}

		public function set idSegmento(value:Number):void
		{
			_idSegmento = value;
		}

		public function get nome():String
		{
			return _nome;
		}

		public function set nome(value:String):void
		{
			_nome = value;
		}

		public function get portalOrigem():Portal
		{
			return _portalOrigem;
		}

		public function set portalOrigem(value:Portal):void
		{
			_portalOrigem = value;
		}

		public function get portalDestino():Portal
		{
			return _portalDestino;
		}

		public function set portalDestino(value:Portal):void
		{
			_portalDestino = value;
		}

		public function get estrada():Estrada
		{
			return _estrada;
		}

		public function set estrada(value:Estrada):void
		{
			_estrada = value;
		}

		public function get kmInicial():int
		{
			return _kmInicial;
		}

		public function set kmInicial(value:int):void
		{
			_kmInicial = value;
		}

		public function get kmFinal():int
		{
			return _kmFinal;
		}

		public function set kmFinal(value:int):void
		{
			_kmFinal = value;
		}


	}
}