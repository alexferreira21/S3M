package component
{
	import flash.events.Event;
	
	import mx.controls.NumericStepper;
	import mx.core.mx_internal;
	import mx.events.FlexEvent;
	
	use namespace mx_internal;
	/**
	 * Added support to format time values.
	 */ 
	public class TimePickerNumericStepper extends NumericStepper
	{
		public function TimePickerNumericStepper()
		{
		}
		
		/**
		 *  @private
		 */
		override protected function createChildren():void
		{
			super.createChildren();
			onValueCommit(null)
			inputField.addEventListener(FlexEvent.VALUE_COMMIT,onValueCommit);
		}
		
		protected function onValueCommit(event:Event):void
		{
			if(value<10 && inputField.text.length==1){
				inputField.text = "0" + inputField.text;
			}   
		}
		
		
	}
}
