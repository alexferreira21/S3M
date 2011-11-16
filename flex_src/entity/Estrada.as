package entity
{
	import com.google.maps.interfaces.IPolyline;
	
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="entity.Estrada")]
	public class Estrada
	{
		
		
		private var _idEstrada:Number;
		private var _nome:String;
		private var _numeroSegmentos: int;
		private var _ufs : ArrayCollection;
		private var _segmentos: ArrayCollection;
		
		
		private var _polyline:IPolyline;
		
		
		
		public function Estrada()
		{
		}
		
		
		[Bindable]
		public function get idEstrada():Number
		{
			return _idEstrada;
		}

		public function set idEstrada(value:Number):void
		{
			_idEstrada = value;
		}

		[Bindable]
		public function get nome():String
		{
			return _nome;
		}

		public function set nome(value:String):void
		{
			_nome = value;
		}

		[Bindable]
		public function get numeroSegmentos():int
		{
			return _numeroSegmentos;
		}

		public function set numeroSegmentos(value:int):void
		{
			_numeroSegmentos = value;
		}

		[Bindable]
		public function get ufs():ArrayCollection
		{
			return _ufs;
		}

		public function set ufs(value:ArrayCollection):void
		{
			_ufs = value;
		}

		[Bindable]
		public function get segmentos():ArrayCollection
		{
			return _segmentos;
		}

		public function set segmentos(value:ArrayCollection):void
		{
			_segmentos = value;
		}

		
		public function get polyline():IPolyline
		{
			return _polyline;
		}

		public function set polyline(value:IPolyline):void
		{
			_polyline = value;
		}


	}
}