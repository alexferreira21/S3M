package util
{
	import flash.display.Sprite;
	
	import mx.controls.Alert;
	
	public class AlertUtil
	{
		
		[Embed(source='assets/iconErro.png')]
		private static var errorIcon:Class;
		
		public static function criarJanelaConfirmacao(texto: String, titulo: String, parent: Sprite, callback: Function):void
		{
			Alert.yesLabel = "Sim";
			Alert.noLabel = "Não";
			Alert.show(texto, titulo,3,parent,callback);
		}
		
		public static function criarJanelaErro(texto: String, titulo: String, parent: Sprite):void 
		{
			Alert.show(texto, titulo, 4, parent, null, errorIcon);
		}
		
	}
}