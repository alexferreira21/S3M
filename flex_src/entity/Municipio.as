package entity
{
	[RemoteClass(alias="entity.Municipio")]
	public class Municipio
	{
		private var _idMunicipio:Number;
		private var _uf:UF;
		private var _nome:String;
		
		public function Municipio()
		{
		}
				
		
		
		public function get idMunicipio():Number
		{
			return _idMunicipio;
		}
		public function set idMunicipio(value:Number):void
		{
			_idMunicipio = value;
		}


		public function toString():String	
		{
			return this.nome;
		}
		
		[Bindable]
		public function get uf():UF
		{
			return _uf;
		}

		public function set uf(value:UF):void
		{
			_uf = value;
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

	}
}