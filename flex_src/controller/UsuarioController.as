package controller
{
	import entity.Usuario;
	
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;

	public class UsuarioController extends Controller
	{
		public function UsuarioController(callbackSucesso:Function = null)
		{
			super('usuarioService')
			setResultFunction(callbackSucesso); 
		}
		
		
		public function login(login: String, senha: String):void
		{
			var loginToken: AsyncToken; 
			
			loginToken = service.login(login, senha);
			loginToken.addResponder(responder);
		}
		
		public function listarUsuarios(): void
		{
			var usuarioToken: AsyncToken;
			
			usuarioToken = service.listarUsuarios();
			usuarioToken.addResponder(responder);
		}
		
		public function savarUsuario(usuario: Usuario):void
		{
			var usuarioToken: AsyncToken;
			
			usuarioToken = service.salvarUsuario(usuario);
			usuarioToken.addResponder(responder);
		}
		
		public function removerusuario(usuario: Usuario):void
		{
			var usuarioToken: AsyncToken;
			
			usuarioToken = service.removerUsuario(usuario);
			usuarioToken.addResponder(responder);
		}
	}
}