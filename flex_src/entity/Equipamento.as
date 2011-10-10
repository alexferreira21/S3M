package entity
{
	[RemoteClass(alias="entity.Equipamento")]
	public class Equipamento
	{
		private var _idEquipamento:Number;
		private var _nome:String;
		private var _ordem:Number;
		private var _status:Number = 0;
		private var _portal:Portal;
		
		public function Equipamento(ordem:Number, status:Number)
		{
			this._ordem = ordem;
			this._status = status;
		}
		


		

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

		public function get ordem():Number
		{
			return _ordem;
		}

		public function set ordem(value:Number):void
		{
			_ordem = value;
		}
		

		public function get status():Number
		{
			return _status;
		}

		public function set status(value:Number):void
		{
			_status = value;
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