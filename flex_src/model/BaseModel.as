package model
{
	import mx.collections.ArrayCollection;

	public class BaseModel
	{
		private static var instance:BaseModel;
		
		[Bindable]
		private var _portais: ArrayCollection = new ArrayCollection();
		
		[Bindable]
		private var _markers: ArrayCollection = new ArrayCollection();
		
		[Bindable]
		private var _estradas: ArrayCollection = new ArrayCollection();
	
		public static function getInstance() : BaseModel {  
			if (instance == null)  
				instance = new BaseModel( new SingletonEnforcer );  
			return instance;  
		}

		public function BaseModel(enforcer:SingletonEnforcer)
		{
			if (enforcer == null)  
				throw new Error("Só pode haver uma instância de Singleton");
		}
		
		public function get portais():ArrayCollection
		{
			return _portais;
		}

		public function set portais(value:ArrayCollection):void
		{
			_portais = value;
		}

		
		public function get markers():ArrayCollection
		{
			return _markers;
		}

		public function set markers(value:ArrayCollection):void
		{
			_markers = value;
		}

		public function get estradas():ArrayCollection
		{
			return _estradas;
		}

		public function set estradas(value:ArrayCollection):void
		{
			_estradas = value;
		}


	}
	
}
	//Para bloquear o acesso ao constructor.
	internal class SingletonEnforcer {} 	