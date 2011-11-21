package entity
{
	public class FluxoAuxiliar
	{
		
		private var _idFluxoAuxiliar: Number;
		private var _portal: Portal;
		private var _tipo: Number;
		private var _estrada: Estrada;
		
		

		public function FluxoAuxiliar()
		{
		}
		
		
		public function get idFluxoAuxiliar():Number
		{
			return _idFluxoAuxiliar;
		}

		public function set idFluxoAuxiliar(value:Number):void
		{
			_idFluxoAuxiliar = value;
		}

		public function get portal():Portal
		{
			return _portal;
		}

		public function set portal(value:Portal):void
		{
			_portal = value;
		}

		public function get tipo():Number
		{
			return _tipo;
		}

		public function set tipo(value:Number):void
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


	}
}