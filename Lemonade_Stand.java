/*
 * Jerry Hou
 * This program sets construct the lemonade stand graphically.
 * It has some user interactions to change the background.
 */

import doodlepad.*;
public class Lemonade_Stand { // start of the class
	
	// Here are some variables, they will going to change according to user interactions
	String mode = "day";
	RoundRect change_background;
	RoundRect change_mode;
	Rectangle background;
	Rectangle ground;
	Oval sun;
	
	public int num_lemon = 10;
	public int num_suger = 10;
	public int num_ice = 10;
	public int num_cup = 10;
	public String game_mode = "Start Game";
	public RoundRect sugar_box;
	public RoundRect cup_box;
	public RoundRect lemon_box;
	public RoundRect ice_box;
	Text sugar_text;
	
	
	public Lemonade_Stand() { // The Constructor: Graphically sets the scence
		
		// Sets the back ground and the grass
		background = new Rectangle(0, 0, 600, 480);
		background.setFillColor(0, 191, 255);
		ground = new Rectangle(0, 480, 600, 120);
		ground.setFillColor(34, 139, 34);
		
		// Sets the physical stand
		int stand_x = 100;
		int stand_width = 400;
		int stand_top_height = 60;
		int stand_top_y = 220;
		Rectangle r1 = new Rectangle(stand_x, stand_top_y, stand_width, stand_top_height);
		Rectangle r2 = new Rectangle(stand_x + 50, stand_top_y + stand_top_height, 60, 150);
		Rectangle r3 = new Rectangle(stand_x + stand_width - 110, stand_top_y + stand_top_height, 60, 150);
		Rectangle r4 = new Rectangle(stand_x, stand_top_y + stand_top_height + 150, stand_width, 130);
		r1.setFillColor(139, 69, 19);
		r2.setFillColor(139, 69, 19);
		r3.setFillColor(139, 69, 19);
		r4.setFillColor(139, 69, 19);
		sun = new Oval(500, -40, 150, 150);
		sun.setFillColor(250,250,0);
		
		// Sets the cup
		double[] cup_x = new double[] {240, 280, 272, 248};
        double[] cup_y = new double[] {375, 375, 430, 430};
        Polygon cup = new Polygon(cup_x, cup_y);
        cup.setFillColor(255, 0, 0);
        
        // Sets the change backgound bottom
        change_background = new RoundRect(120, 80, 170, 80, 30, 30);
        Text corlor_change_1 = new Text("Backgound Color", 128, 95, 20);
        Text corlor_change_2 = new Text("      Change", 135, 125, 20);
        change_background.setMousePressedHandler(this::onPressed); // Call onPressed method if the change backgound bottom is pressed
        
        //Sets the change mode bottom
        change_mode = new RoundRect(300, 80, 80, 80, 30, 30);
        Text change_mode_1 = new Text(" Mode", 310, 95, 20);
        Text change_mode_2 = new Text("Change", 305, 125, 20);
        change_mode.setMousePressedHandler(this::onPressed2); // Call onPressed2 method if the change mode bottom is pressed
        
        // Sets materials
        sugar_box = new RoundRect(120, 440, 80, 40, 30, 30);
        sugar_text = new Text("Sugar: " + num_suger, 131, 452, 15);
        RoundRect cup_box = new RoundRect(120, 500, 80, 40, 30, 30);
        Text cup_text = new Text("Cup: " + num_cup, 133, 512, 15);
        RoundRect lemon_box = new RoundRect(200, 440, 80, 40, 30, 30);
        Text lemon_text = new Text("Lemon: " + num_lemon, 208, 452, 15);
        RoundRect ice_box = new RoundRect(200, 500, 80, 40, 30, 30);
        Text ice_text = new Text("Ice: " + num_ice, 211, 512, 15);
        
        // start a mode
        System.out.println(game_mode);
        RoundRect game_box = new RoundRect(300, 480, 120, 40, 30, 30);
        Text game_text = new Text(game_mode, 311, 491, 15);
        
        sugar_box.setMousePressedHandler(this::add_sugar);
        
        game_box.setMousePressedHandler(this::game_mode_change);
	} // end of the Consturctor
	
	private void onPressed(Shape shp, double x, double y, int button) { // Start of the onPressed method
		// generate random colors for background
		background.setFillColor(Math.random() * 255, Math.random() * 255, Math.random() * 255);
		ground.setFillColor(Math.random() * 255, Math.random() * 255, Math.random() * 255);
    } // end of the onPressed method
    
    private void onPressed2(Shape shp, double x, double y, int button) { // Start of the onPressed2
		// This method changes the mode
		if (mode.equals("night")) { // if the current mode is night mode, change to day mode
			background.setFillColor(0, 191, 255);
			ground.setFillColor(34, 139, 34);
			sun.setFillColor(250,250,0);
			mode = "day";
		} else if (mode.equals("day")) { // if the current mode is day mode, change to noon mode
			background.setFillColor(255, 212, 0);
			ground.setFillColor(128, 128, 0);
			sun.setFillColor(250,0,0);
			mode = "noon";
		} else { // if the current mode is day mode, change to night mode
			background.setFillColor(0, 0, 0);
			ground.setFillColor(0, 45, 0);
			sun.setFillColor(255, 255, 255);
			mode = "night";
		}
    } // end of the onPressed2
    
    private void game_mode_change(Shape shp, double x, double y, int button) {
		if (game_mode.equals("Start Game")) {
			game_mode = "Buy";
			sugar_box.setMousePressedHandler(this::add_sugar);
		} else if (game_mode.equals("Buy")) {
			game_mode = "sell";
		}
	}
	
	private void add_sugar(Shape shp, double x, double y, int button) {
		System.out.println(num_suger);
		Text sugar_text = new Text("Sugar: " + num_suger, 131, 452, 15);
		num_suger ++;
	}
    
    public static void main(String[] args) { // where the code runs
		Lemonade_Stand stand = new Lemonade_Stand(); // construct Lemonade_Stand
    } // end of public static void main
} // end of the class
