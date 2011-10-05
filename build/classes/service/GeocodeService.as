package service
{
	import com.google.maps.LatLng;
	import com.google.maps.services.ClientGeocoder;
	import com.google.maps.services.GeocodingEvent;
	import com.google.maps.services.Placemark;
	
	import entidades.Municipio;
	import entidades.Portal;
	import entidades.Uf;
	
	import mx.controls.Alert;

	public class GeocodeService
	{
		static var instance:GeocodeService = null;
		private var _geocoder:ClientGeocoder = new ClientGeocoder();
		
		private var solicitacaoAtual:LatLng;
		
		public function getInstance():GeocodeService
		{
			if(instance == null) 
			{
				return new GeocodeService;
			}
			else
			{
				return instance;
			}
		}
		
		public function obterMunicipio(latLng:LatLng):Municipio
		{
			_geocoder.addEventListener(GeocodingEvent.GEOCODING_SUCCESS,sucessoGeocode);				
			_geocoder.addEventListener(GeocodingEvent.GEOCODING_FAILURE,falhaGeocode);
			
			_geocoder.reverseGeocode(latLng);
		}
		
		protected function sucessoGeocode(event:GeocodingEvent):void
		{
			var municipioGeocodificado:Municipio = new Municipio(null);
			var placemark:Placemark = Placemark(event.response.placemarks[0]);
			
			
			if(placemark.addressDetails.hasOwnProperty("Country"))
			{
				var country:Object = placemark.addressDetails.Country;
				if(country.hasOwnProperty("AdministrativeArea"))
				{
					var administrativeArea:Object = country.AdministrativeArea;
					municipioGeocodificado.uf = new Uf(administrativeArea.AdministrativeAreaName);
					if(administrativeArea.hasOwnProperty("Locality"))
					{
						var locality:Object = administrativeArea.Locality;
						municipioGeocodificado.nome = locality.LocalityName;
					}
				}
			}
		}
		
		protected function falhaGeocode(event:GeocodingEvent):void
		{
			Alert.show("Erro ao geocodificar localização");
		}
		
		
		
		
		
	}
}