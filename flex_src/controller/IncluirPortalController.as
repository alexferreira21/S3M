package controller
{
	import com.google.maps.LatLng;
	import com.google.maps.MapMouseEvent;
	import com.google.maps.services.ClientGeocoder;
	import com.google.maps.services.GeocodingEvent;
	import com.google.maps.services.Placemark;
	
	import entity.Municipio;
	import entity.Portal;
	import entity.StatusEquipamentoEnum;
	import entity.UF;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import mygoogle.MarkerPortal;
	
	public class IncluirPortalController
	{
		
		[Bindable]
		public var portais:ArrayCollection = new ArrayCollection();
		
		private var _portalEmEdicao:Portal;
		
		
		
		[Bindable]
		public function get portalEmEdicao():Portal
		{
			return _portalEmEdicao;
		}
		
		public function set portalEmEdicao(value:Portal):void
		{
			_portalEmEdicao = value;
		}
		
		public function salvarPortal():void
		{
			portais.addItem(portalEmEdicao);//
			
			var portalService: RemoteObject = new RemoteObject("portalService");
			var token: AsyncToken; 
			
			token = portalService.salvarPortal(portalEmEdicao);
			token.addResponder(new mx.rpc.Responder(handleResult, handleFault));
		}
		
		private function handleResult(event : ResultEvent) : void {
			
			Alert.show("Deu Certo!");
			
		}
		
		private function handleFault(event : FaultEvent) : void {
			
			Alert.show(event.fault.message);
			
		}
		
		public function novoPortalEdicao():Portal
		{
			portalEmEdicao = new Portal();
			return portalEmEdicao;
		}
		
		
		protected function enviarAoBackEnd():void
		{
			
		}
		
		
		
		
		public function get equipamentosDataProvider():ArrayCollection //PARA O COMBOBOX DO STATUS DE EQUIPAMENTO
		{
			var array:ArrayCollection = new ArrayCollection();
			array.addItem(StatusEquipamentoEnum.OPERANTE);
			array.addItem(StatusEquipamentoEnum.INOPERANTE);
			
			return array;
		}
		
		
	}
}