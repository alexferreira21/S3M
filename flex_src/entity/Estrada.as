package entity
{
	import com.google.maps.interfaces.IPolyline;
	import com.google.maps.overlays.EncodedPolylineData;
	import com.google.maps.overlays.Polyline;
	import com.google.maps.overlays.PolylineOptions;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;

	[RemoteClass(alias="entity.Estrada")]
	public class Estrada
	{
		
		
		private var _idEstrada:Number;
		private var _nome:String;
		private var _numeroSegmentos: int;
		private var _ufs : ArrayCollection;
		private var _segmentos: ArrayCollection;
		
		
		private var _polylineData:EncodedPolylineData;
		private var _encodedPolylineString: String;
		private var _corEstrada: String;
		
		private var _polyline: Polyline;
		
		
		
		public function Estrada()
		{
		}
		
		
		public function setPolylineDataComOptions(polyData: EncodedPolylineData, options: PolylineOptions):void
		{
			polylineData = polyData;
			Alert.show("Levels = " + polyData.levels + " NumLevels = " + polyData.numLevels + " Points = " + polyData.points + " ZoomFactor = " + polyData.zoomFactor);
			polyline = Polyline.fromEncoded(polylineData,options);
			corEstrada = options.strokeStyle.color.toString();
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

		
		public function get polylineData():EncodedPolylineData
		{
			return _polylineData;
		}

		public function set polylineData(value:EncodedPolylineData):void
		{
			_polylineData = value;
		}
		
		
		public function get polyline():Polyline
		{
			return _polyline;
		}
		
		public function set polyline(value:Polyline):void
		{
			_polyline = value;
		}

		public function get corEstrada():String
		{
			return _corEstrada;
		}

		public function set corEstrada(value:String):void
		{
			_corEstrada = value;
		}


	}
}