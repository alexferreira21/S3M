package entity
{
	public class Segmento
	{
		
		private var _idSegmento: int;
		private var _nome: String;
		private var _km: int;
		private var _portalOrigem: Portal;
		private var _portalDestino: Portal;
		private var _estrada: Estrada;
		
		
		
		public function Segmento()
		{
		}

		public function get idSegmento():int
		{
			return _idSegmento;
		}

		public function set idSegmento(value:int):void
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

		public function get km():int
		{
			return _km;
		}

		public function set km(value:int):void
		{
			_km = value;
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


	}
}