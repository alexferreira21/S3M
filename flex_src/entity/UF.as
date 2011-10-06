package entity
{
	[RemoteClass(alias="entity.UF")]
	public class UF
	{
		private var _idUF:Number;
		private var _nome:String;
		private var _sigla:String;
		
		public function UF()
		{
		}
		
		public function get idUF():Number
		{
			return _idUF;
		}
		public function set idUF(value:Number):void
		{
			_idUF = value;
		}


		public function toString():String	
		{
			return this._sigla;
		}
		
		public function get nome():String
		{
			return _nome;
		}

		public function set nome(value:String):void
		{
			_nome = value;
		}

		public function get sigla():String
		{
			return _sigla;
		}

		public function set sigla(value:String):void
		{
			_sigla = value;
		}


	}
}