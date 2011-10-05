package core
{
	
	import com.google.maps.LatLng;
	import com.google.maps.MapMouseEvent;
	import com.google.maps.overlays.Marker;
	import com.google.maps.overlays.MarkerOptions;
	
	import entity.Equipamento;
	import entity.Portal;
	
	import flash.geom.Point;
	import flash.sampler.NewObjectSample;
	
	import mx.collections.ArrayCollection;
	
	import spark.components.IconPlacement;
	
	public class MarkerPortal extends Marker
	{
		
		[Embed('assets/antena.png')]
		protected var iconeNormal:Class;
		
		[Embed ('assets/antenaSelecionada.png')]
		protected var iconeSelecionado:Class;
		
		private var _portal:Portal;
		
		private var _options:MarkerOptions = new MarkerOptions();
		private var _isSelected:Boolean = false;
		
		public function MarkerPortal(latLng:LatLng)
		{		
			_options.icon = new iconeNormal();
			_options.iconAlignment = MarkerOptions.ALIGN_VERTICAL_CENTER;
			_options.iconOffset = new Point(-20, -5);
			
			_portal = new Portal();
			_portal.latitude = latLng.lat();
			_portal.longitude = latLng.lng();
			super(latLng, _options);
			
			addEventListener(MapMouseEvent.CLICK,selectAntena);
		}
		
		private function selectAntena(event: MapMouseEvent):void
		{
			var eventObj:AntenaEvent;
			
			if(_isSelected)
			{ 
				_options.icon = new iconeNormal(); 
				this.setOptions(_options);
				_isSelected = false

				eventObj = new AntenaEvent(AntenaEvent.ANTENA_DESSELECIONADA,this.getLatLng());
				dispatchEvent(eventObj);
			}
			else
			{
				_options.icon = new iconeSelecionado(); 
				this.setOptions(_options);
				_isSelected = true;
				
				eventObj = new AntenaEvent(AntenaEvent.ANTENA_SELECIONADA,this.getLatLng());
				dispatchEvent(eventObj);
			}
			
		}
		
		public function get lat():Number
		{
			return this.getLatLng().lat();
		}
		
		public function get lng():Number
		{
			return this.getLatLng().lng();
		}

		public function get portal():Portal
		{
			return _portal;
		}
		
	}
}