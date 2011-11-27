package entity
{
	[RemoteClass(alias="entity.Equipamento")]
	public class Equipamento
	{
		private var _idEquipamento:Number;
		private var _nome:String;
		private var _sentido:String;
		private var _portal:Portal;
		

		public function get idEquipamento():Number
		{
			return _idEquipamento;
		}

		public function set idEquipamento(value:Number):void
		{
			_idEquipamento = value;
		}

		public function get nome():String
		{
			return _nome;
		}

		public function set nome(value:String):void
		{
			_nome = value;
		}

		public function get sentido():String
		{
			return _sentido;
		}

		public function set sentido(value:String):void
		{
			_sentido = value;
		}
		

		public function get portal():Portal
		{
			return _portal;
		}

		public function set portal(value:Portal):void
		{
			_portal = value;
		}

	}
}