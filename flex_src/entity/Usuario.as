package entity
{
	[RemoteClass(alias="entity.Usuario")]
	[Bindable]
	public class Usuario
	{
		
		public var id: Number;
		public var login: String;
		public var senha: String;
		public var nome: String;
		
		public var perfil: Perfil;
		
	}
}