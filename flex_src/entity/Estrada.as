package entity
{
	import mx.collections.ArrayCollection;

	public class Estrada
	{
		
		
		private var _idEstrada:Number;
		private var _nome:String;
		private var _numeroSegmentos: int;
		private var _uf : ArrayCollection;
		private var _segmento: ArrayCollection;
		
		
		
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
		public function get uf():ArrayCollection
		{
			return _uf;
		}

		public function set uf(value:ArrayCollection):void
		{
			_uf = value;
		}

		[Bindable]
		public function get segmento():ArrayCollection
		{
			return _segmento;
		}

		public function set segmento(value:ArrayCollection):void
		{
			_segmento = value;
		}


	}
}