package util
{
	import flash.display.Sprite;
	
	import mx.controls.Alert;

	public class AlertUtil
	{
		public function AlertUtil()
		{
		}
		
		public static function criarJanelaConfirmacao(texto: String, titulo: String, parent: Sprite, callback: Function):void
		{
				Alert.yesLabel = "Sim";
				Alert.noLabel = "Não";
				Alert.show(texto, titulo,3,parent,callback);
		}
		
	}
}