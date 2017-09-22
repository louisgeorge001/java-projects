package Sample.Model;

import java.util.ArrayList;

public class MVCFactory {
ArrayList<Whatsit> whatsit; 
ArrayList<Widget> widget; 
private int widgetresourcecount;
private int whatsitresourcecount;
	private MVCFactory()
	{
		whatsit= new ArrayList<>();
		widget= new ArrayList<>();
		widgetresourcecount = 30;
		whatsitresourcecount = 40;
		
	}
}
