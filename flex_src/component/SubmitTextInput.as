package component
{
	import flash.events.KeyboardEvent;
	import flash.ui.Keyboard;
	import flash.ui.KeyboardType;
	
	import spark.components.TextInput;
	
	public class SubmitTextInput extends TextInput
	{
		public var submitFunction: Function;
		
		public function SubmitTextInput()
		{
			this.addEventListener(KeyboardEvent.KEY_UP,keyHandler);
			super();
		}
		
		private function keyHandler(event: KeyboardEvent):void
		{
			if(event.keyCode == Keyboard.ENTER)
			{
				if(submitFunction != null)
				{
					submitFunction.call();
				}
			}
			
		}
		
	}
}