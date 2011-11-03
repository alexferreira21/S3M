package mygoogle
{
	
	import com.google.maps.LatLng;
	import com.google.maps.MapMouseEvent;
	import com.google.maps.overlays.Marker;
	import com.google.maps.overlays.MarkerOptions;
	
	import entity.Equipamento;
	import entity.Portal;
	
	import flash.geom.Point;
	import flash.sampler.NewObjectSample;
	
	import main.MarkerPortalEvent;
	
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
		
		public function MarkerPortal(portal:Portal)
		{		
			_options.icon = new iconeNormal();
			_options.iconAlignment = MarkerOptions.ALIGN_VERTICAL_CENTER;
			_options.iconOffset = new Point(-20, -5);
			
			_portal = portal;
			super(portal.latLng, _options);
			
			addEventListener(MapMouseEvent.CLICK,selecionarPortal);
		}
		
		public function selecionarPortal(event: MapMouseEvent):void //REVER ESSE MÉTODO
		{
			var eventObj:MarkerPortalEvent;
			   
			eventObj = new MarkerPortalEvent(MarkerPortalEvent.PORTAL_CLICK,this);
			dispatchEvent(eventObj);
		}
		
		
		public function get isSelected():Boolean
		{
			return _isSelected;
		}

		public function set isSelected(value:Boolean):void
		{
			_isSelected = value;
			
			var eventObj:MarkerPortalEvent;
			
			if(value)
			{
				_options.icon = new iconeSelecionado(); 
				this.setOptions(_options);
			}
			else
			{
				_options.icon = new iconeNormal(); 
				this.setOptions(_options);
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