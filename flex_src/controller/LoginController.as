package controller
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;

	public class LoginController extends Controller
	{
		public function LoginController(callbackSucesso:Function)
		{
			super('loginService')
			this.responder = new Responder(callbackSucesso,defaultFault); 
		}
		
		
		public function login(login: String, senha: String):void
		{
			var loginToke: AsyncToken; 
			
			loginToke = service.login(login, senha);
			loginToke.addResponder(responder);
		}
	}
}