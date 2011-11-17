package entity
{
	import com.google.maps.interfaces.IPolyline;
	import com.google.maps.overlays.EncodedPolylineData;
	import com.google.maps.overlays.PolygonOptions;
	import com.google.maps.overlays.Polyline;
	import com.google.maps.overlays.PolylineOptions;
	import com.google.maps.styles.StrokeStyle;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.utils.ObjectUtil;
	import mx.validators.EmailValidator;

	[RemoteClass(alias="entity.Estrada")]
	public class Estrada
	{
		
		private static const IDENT_NAME_PROPERTY:String = "=pn:";
		private static const IDENT_VALUE_PROPERTY:String = "=pv:";
		
		private var _idEstrada:Number;
		private var _nome:String;
		private var _numeroSegmentos: int;
		private var _ufs : ArrayCollection;
		private var _segmentos: ArrayCollection;
		
		private var _encodedPolylineString: String;

		private var _corEstrada: Number;
		private var _polylineData: EncodedPolylineData;		
		private var _polyline: IPolyline;
		
		
		public function Estrada()
		{
		}
		
		
		public function dataToString():String
		{
			var objectString:String = "";
			var infoClass:Object = ObjectUtil.getClassInfo(polylineData);
			var arrProperties:Array = infoClass.properties as Array;
			for each(var qName:QName in arrProperties)
			{
				var nameProperty:String = qName.localName;
				var valueProperty:String = polylineData[nameProperty].toString();
				
				objectString += IDENT_NAME_PROPERTY+nameProperty+IDENT_VALUE_PROPERTY+valueProperty;
			}
			
			return objectString;
		}
		
		public function stringToData():void
		{
			var novaPolylineData = new EncodedPolylineData(null,null,null,null);
			var arrStringProperty:Array = encodedPolylineString.split(IDENT_NAME_PROPERTY);
			for each(var propertyString:String in arrStringProperty)
			{
				if(propertyString != "")
				{
					var arrProperty:Array = propertyString.split(IDENT_VALUE_PROPERTY);
					var nameProperty:String = arrProperty[0];
					var valueProperty:String = arrProperty[1];
					
					if (nameProperty == 'zoomFactor' || nameProperty == 'numLevels')
					{
						novaPolylineData[nameProperty] = parseInt(valueProperty);
					}
					else
					{
						novaPolylineData[nameProperty] = valueProperty;
					}
				}
			}
			polylineData = novaPolylineData;
			polyline = Polyline.fromEncoded(polylineData);
			
			var strokeStyle: StrokeStyle = new StrokeStyle();
			strokeStyle.color = corEstrada;
			strokeStyle.thickness = 4;
			strokeStyle.alpha = 1;
			
			var polylineOptions = new PolylineOptions();
			polylineOptions.strokeStyle = strokeStyle;
			polyline.setOptions(polylineOptions);			
			
		}
		
		public function setPolylineOptions(options: PolylineOptions):void
		{
			polyline.setOptions(options);
			corEstrada = Number(options.strokeStyle.color);
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
		

		public function get encodedPolylineString():String
		{
			return _encodedPolylineString;
		}

		public function set encodedPolylineString(value:String):void
		{
			_encodedPolylineString = value;
		}

		public function get polylineData():EncodedPolylineData
		{
			return _polylineData;
		}

		public function set polylineData(value:EncodedPolylineData):void
		{
			_polylineData = value;
			encodedPolylineString = dataToString();
			polyline = Polyline.fromEncoded(polylineData);
		}

		public function get polyline():IPolyline
		{
			return _polyline;
		}

		public function set polyline(value:IPolyline):void
		{
			_polyline = value;
		}

		public function get corEstrada():Number
		{
			return _corEstrada;
		}

		public function set corEstrada(value:Number):void
		{
			_corEstrada = value;
		}


	}
}