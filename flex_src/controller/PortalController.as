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
	
	import model.BaseModel;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.managers.CursorManager;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import mygoogle.MarkerPortal;
	
	public class PortalController
	{
		
		private var portalService: RemoteObject = new RemoteObject("portalService");
		
		[Bindable]
		public var portais: ArrayCollection = BaseModel.getInstance().portais;
		
		private var _portalEmEdicao: Portal;
		private var _ufDataProvider: ArrayCollection;
		
		public var geocoder: ClientGeocoder;
		private var sucessoGeocoderRetornoView: Function;
		private var falhaGeocoderRetornoView: Function;
		
		
		

		
		public function PortalController()
		{
			
			var ufDataProviderToken: AsyncToken = portalService.getUFDataProvider();
			ufDataProviderToken.addResponder(new Responder(getUFDataProviderResult, getUFDataProviderFault));
		}
		
		private function getUFDataProviderResult(event: ResultEvent):void
		{
			_ufDataProvider = ArrayCollection(event.result);
		}
		
		private function getUFDataProviderFault(event: FaultEvent):void
		{
			Alert.show(event.fault.message);
		}
		
		[Bindable]
		public function get portalEmEdicao():Portal
		{
			return _portalEmEdicao;
		}
		
		public function set portalEmEdicao(value:Portal):void
		{
			_portalEmEdicao = value;
		}
		
		public function get ufDataProvider():ArrayCollection
		{
			return _ufDataProvider;
		}
		
		public function salvarPortal():void
		{
			var salvarPortalToken: AsyncToken; 
			
			salvarPortalToken = portalService.salvarPortal(portalEmEdicao);
			salvarPortalToken.addResponder(new Responder(salvarPortalResult, salvarPortalFault));
		}
		
		private function salvarPortalResult(event : ResultEvent) : void 
		{
			var portalRetornado: Portal = Portal(event.result);
			var encontrou: Boolean = false;
			
			for each (var itemPortal:Portal in portais)
			{
				if(itemPortal.idPortal == portalRetornado.idPortal)
				{
					var index :int = portais.getItemIndex(itemPortal);
					portais[index] = portalRetornado;
					encontrou = true;
					break;
				}
			}
			
			if (!encontrou)
			{
				portais.addItem(portalRetornado);
			}
		}
		
		
		private function salvarPortalFault(event : FaultEvent) : void {
			
			Alert.show(event.fault.message);
			
		}
		
		public function novoPortalEdicao():Portal
		{
			portalEmEdicao = new Portal();
			return portalEmEdicao;
		}
		
		public function geocodificar(str:String, sucessoFunction:Function, falhaFunction:Function):void
		{
			if(geocoder == null)
			{
				geocoder =  new ClientGeocoder();
			}
			geocoder.addEventListener(GeocodingEvent.GEOCODING_SUCCESS,sucessoGeocode);				
			geocoder.addEventListener(GeocodingEvent.GEOCODING_FAILURE,falhaGeocode);
			
			sucessoGeocoderRetornoView = sucessoFunction;
			falhaGeocoderRetornoView = falhaFunction;
			
			geocoder.geocode(str);
		}
		
		protected function sucessoGeocode(event:GeocodingEvent):void
		{
			var municipioGeocodificado:Municipio = new Municipio();
			var placemark:Placemark = Placemark(event.response.placemarks[0]);
			
			if(placemark.addressDetails.hasOwnProperty("Country"))
			{
				var country:Object = placemark.addressDetails.Country;
				if(country.hasOwnProperty("AdministrativeArea"))
				{
					var administrativeArea:Object = country.AdministrativeArea;
					var uf:UF = new UF();
					uf.sigla = administrativeArea.AdministrativeAreaName;
					municipioGeocodificado.uf = uf;
					portalEmEdicao.municipio = municipioGeocodificado;
					if(administrativeArea.hasOwnProperty("Locality"))
					{
						var locality:Object = administrativeArea.Locality;
						municipioGeocodificado.nome = locality.LocalityName;
						portalEmEdicao.municipio = municipioGeocodificado;
					}
				}
			}
			
			var buscarUFToken: AsyncToken; 
			
			buscarUFToken = portalService.buscarUF(portalEmEdicao.municipio.uf);
			buscarUFToken.addResponder(new mx.rpc.Responder(sucessoGeocoderRetornoView, falhaGeocoderRetornoView)); 
		}
		
		
		
		
		protected function falhaGeocode(event:GeocodingEvent):void
		{
			Alert.show("Erro ao geocodificar localização");
		}
		
		
		public function carregarPortais(callbackSucesso:Function, callbackFalha:Function):void
		{
			var portalService: RemoteObject = new RemoteObject("portalService");
			var token: AsyncToken; 
			
			CursorManager.setBusyCursor();
			
			token = portalService.carregarPortais();
			token.addResponder(new mx.rpc.Responder(callbackSucesso, callbackFalha));
			
		}
		
		
		public function get equipamentosDataProvider():ArrayCollection //PARA O COMBOBOX DO STATUS DE EQUIPAMENTO
		{
			var array:ArrayCollection = new ArrayCollection();
			array.addItem(StatusEquipamentoEnum.OPERANTE);
			array.addItem(StatusEquipamentoEnum.INOPERANTE);
			
			return array;
		}
		
		public function removerPortal(portal:Portal, callbackSucces: Function, callbackFault: Function):void
		{
			var removerPortalToken: AsyncToken; 
			
			removerPortalToken = portalService.removerPortal(portal);
			removerPortalToken.addResponder(new Responder(callbackSucces, callbackFault));
		}
		
		
		
	}
}