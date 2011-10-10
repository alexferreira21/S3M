package util
{
	import entity.UF;
	import mx.collections.ArrayCollection;

	public class UFUtil
	{
		
		public static function getDataProvider():ArrayCollection
		{
			var dp:ArrayCollection;
			
			var ufRJ:UF = new UF();
			ufRJ.sigla = "RJ";
			ufRJ.nome = "Rio de Janeiro";
			dp.addItem(ufRJ);
			
			var ufSP:UF = new UF();
			ufSP.sigla = "SP";
			ufSP.nome = "São Paulo";
			dp.addItem(ufSP);
			
			return dp;
		}
		
		
	}
	
}