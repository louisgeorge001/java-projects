package controllerdao;

public class praccontroller {
public static void main(String[]args)
{
	String str = "00000010";
	int convstr = Integer.parseInt(str);
	convstr++;
	String convstrletter = Integer.toString(convstr);
	String formatted = ("00000000" + convstrletter).substring(convstrletter.length());
	System.out.println(formatted);
	
	String udis = "section-00000000";
	String word = "";
	String word2 = "";
	int loop = 0;		
	while(!(udis.charAt(loop)+"").equals("-"))
	{
		word+=udis.charAt(loop);
		loop++;
	}
	loop++;
	word2 = udis.substring(loop,udis.length());
	System.out.println(word);
	System.out.println(word2);

}
}
