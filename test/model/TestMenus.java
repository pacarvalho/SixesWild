package model;

import views.Application;
import junit.framework.TestCase;

public class TestMenus extends TestCase {
	/** Main menu */
	Application app;
	
	/** Game under test*/
	SixesWild model;
	/** Board used during test */
	Board board;
	
		
	protected void setUp() throws Exception {
		super.setUp();
		Application app = new Application(); 
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		app = null;
	}
	
	public void testMenus(){
		//System.
		//assertFalse(app.getGameSelectorPanel()==null);
		
	}

}
