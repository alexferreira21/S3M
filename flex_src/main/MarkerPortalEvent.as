package main
{
	
	import flash.events.Event;
	
	import mygoogle.MarkerPortal;
	
	public class MarkerPortalEvent extends Event
	{
		
		public static const PORTAL_CLICK:String = "portalClick"
		public static const PORTAL_SELECIONADO:String = "portalSelecionado"
		public static const PORTAL_DESSELECIONADO:String = "portalDesselecionado"
			
		public var markerPortal:MarkerPortal;
			
			
		public function MarkerPortalEvent(type:String, markerPortal:MarkerPortal, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.markerPortal = markerPortal;
			super(type, bubbles, cancelable);
		}
	}
}