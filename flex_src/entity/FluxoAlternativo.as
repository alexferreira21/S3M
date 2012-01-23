package entity
{
	[RemoteClass(alias="entity.FluxoAlternativo")]
	public class FluxoAlternativo
	{
		
		private var _idFluxoAlternativo: Number;
		private var _portal: Portal;
		private var _tipo: String;
		private var _estrada: Estrada;
		private var _percentual: int;
		
		

		public function FluxoAlternativo()
		{
		}
		
		
		public function get idFluxoAlternativo():Number
		{
			return _idFluxoAlternativo;
		}

		public function set idFluxoAlternativo(value:Number):void
		{
			_idFluxoAlternativo = value;
		}

		[Bindable]
		public function get portal():Portal
		{
			return _portal;
		}

		public function set portal(value:Portal):void
		{
			_portal = value;
		}

		public function get tipo():String
		{
			return _tipo;
		}

		public function set tipo(value:String):void
		{
			_tipo = value;
		}

		public function get estrada():Estrada
		{
			return _estrada;
		}

		public function set estrada(value:Estrada):void
		{
			_estrada = value;
		}

		public function get percentual():int
		{
			return _percentual;
		}

		public function set percentual(value:int):void
		{
			_percentual = value;
		}


	}
}