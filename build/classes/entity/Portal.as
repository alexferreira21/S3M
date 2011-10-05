package entity
{
	import com.google.maps.LatLng;
	
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="entity.Portal")]
	public class Portal
	{
		
		private var _idPortal:Number;
		private var _nome:String;
		private var _latitude:Number = 0;
		private var _longitude:Number = 0;
		private var _altitude:Number = 0;
		private var _municipio:Municipio;
		private var _equipamento:ArrayCollection;
		
		
		
		

		public function get latLng():LatLng
		{
			if(!isNaN(_latitude) && !isNaN(longitude))
			{
				return new LatLng(latitude,longitude);
			}
			else
			{
				return null;
			}
		}
		

		
		public function get idPortal():Number
		{
			return _idPortal;
		}

		public function set idPortal(value:Number):void
		{
			_idPortal = value;
		}
		public function get nome():String
		{
			return _nome;
		}

		public function set nome(value:String):void
		{
			_nome = value;
		}

		public function get latitude():Number
		{
			return _latitude;
		}

		public function set latitude(value:Number):void
		{
			_latitude = value;
		}

		public function get longitude():Number
		{
			return _longitude;
		}

		public function set longitude(value:Number):void
		{
			_longitude = value;
		}

		public function get altitude():Number
		{
			return _altitude;
		}

		public function set altitude(value:Number):void
		{
			_altitude = value;
		}

		public function get municipio():Municipio
		{
			return _municipio;
		}

		public function set municipio(value:Municipio):void
		{
			_municipio = value;
		}

		public function get equipamento():ArrayCollection
		{
			return _equipamento;
		}

		public function set equipamento(value:ArrayCollection):void
		{
			_equipamento = value;
		}


	}
}