/**
 *
 * Name     Yael Hernandez
 * Course:  CSC231 Computer Science and Programming II
 * Lab:     Number 1
 * File:    Welcome.java
 *
 */

// Import Core Java packages
import java.awt.*;
import java.awt.event.*;

public class Welcome extends Frame {

	// Constants and variables used in the program
	static final int WIDTH = 600;                // frame width
	static final int HEIGHT = 350;               // frame height
	static final int EXTRA_SMALL = 8;            // extra small font size
	static final int SMALL_SIZE = 16;            // small font size
	static final int MEDIUM_SIZE = 20;           // medium font size
	static final int LARGE_SIZE = 24;            // large font size
	static final int EXTRA_LARGE = 40;           // extra large font size
	static final int BOLD_FONT = Font.BOLD;              // bold font size
	static final int ITALIC_FONT = Font.ITALIC;          // italic font size
	static final String COLOR_NAMES[] = {"Red", "Blue", "Green", "Black", "Yellow"};
	static final Color COLORS[] = {Color.RED, Color.BLUE, Color.GREEN, Color.BLACK, Color.YELLOW};
	static final String INITIAL_FACE = Font.DIALOG;      // initial typeface
	static final int INITIAL_STYLE = Font.PLAIN;         // initial type style
	static final int INITIAL_SIZE = LARGE_SIZE;          // initial type size

	String typeFace = INITIAL_FACE;     // current typeface
	int typeStyle = INITIAL_STYLE;      // current type style
	int typeSize = INITIAL_SIZE;        // current type size

	Label text;                            // display text
	Checkbox plain;                        // checkbox for plain style
	Checkbox bold;                         // checkbox for bold style
	Checkbox italic;                       // checkbox for italic style
	Checkbox extraSmall;                   // checkbox for extra small font
	Checkbox small;                        // checkbox for small font
	Checkbox medium;                       // checkbox for medium font
	Checkbox large;                        // checkbox for large font
	Checkbox extraLarge;                   // checkbox for extra large font
	Choice colorChoice;                    // choice box for text color
	Button resetButton;                    // button to reset font and color
	Button exitButton;                     // button to exit the program 

    /**
     * Constructor
     */
	public Welcome() {
	    setTitle("Welcome");             // set frame title

        // create text
	    text = new Label("Welcome to the World of Java!");
          text.setAlignment(Label.CENTER);
	    text.setFont(new Font(typeFace, typeStyle, typeSize));
	    text.setForeground(COLORS[0]);
	    add(text, BorderLayout.CENTER);

	    Panel controlPanel = new Panel();
	    controlPanel.setLayout(new GridLayout(0, 1));
	    add(controlPanel, BorderLayout.SOUTH);

        // create choice box
        Panel panel = new Panel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        controlPanel.add(panel);
        Label label = new Label("Select a text color");
        panel.add(label);
        colorChoice = new Choice();
        colorChoice.add(COLOR_NAMES[0]);
        colorChoice.add(COLOR_NAMES[1]);
        colorChoice.add(COLOR_NAMES[2]);
        colorChoice.add(COLOR_NAMES[3]);
        colorChoice.add(COLOR_NAMES[4]);
        panel.add(colorChoice);
        colorChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
	            text.setForeground(COLORS[colorChoice.getSelectedIndex()]);
            }
        });

        // create radio buttons
	    panel = new Panel();
	    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	    controlPanel.add(panel);
	    label = new Label("Select a type size");
	    panel.add(label);
	    CheckboxGroup sizeGroup = new CheckboxGroup();
	    extraSmall = new Checkbox("Extra Small", sizeGroup, false);
	    panel.add(extraSmall);
	    extraSmall.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent event) {
	            if(extraSmall.getState()) {
	                typeSize = EXTRA_SMALL;
	                fontChange(typeFace, typeStyle, typeSize);
	            }
	        }
	    });
	    small = new Checkbox("Small", sizeGroup, false);
	    panel.add(small);
	    small.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent event) {
	            if(small.getState()) {
	                typeSize = SMALL_SIZE;
	                fontChange(typeFace, typeStyle, typeSize);
	            }
	        }
	    });
	    medium = new Checkbox("Medium", sizeGroup, false);
	    panel.add(medium);
	    medium.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent event) {
	            if(medium.getState()) {
	                typeSize = MEDIUM_SIZE;
	                fontChange(typeFace, typeStyle, typeSize);
	            }
	        }
	    });
	    large = new Checkbox("Large", sizeGroup, true);
	    panel.add(large);
	    large.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent event) {
	            if(large.getState()) {
	                typeSize = LARGE_SIZE;
	                fontChange(typeFace, typeStyle, typeSize);
	            }
	        }
	    });
	    extraLarge = new Checkbox("Extra Large", sizeGroup, false);
	    panel.add(extraLarge);
	    extraLarge.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent event) {
	            if(extraLarge.getState()) {
	                typeSize = EXTRA_LARGE;
	                fontChange(typeFace, typeStyle, typeSize);
	            }
	        }
	    });
	    
	    // create style buttons
        panel = new Panel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        controlPanel.add(panel);
        label = new Label("Select a type style");
        panel.add(label);
        plain = new Checkbox("Plain", sizeGroup, false);
	    panel.add(plain);
	    plain.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent event) {
	            if(plain.getState()) {
	                typeStyle = INITIAL_STYLE;
	                fontChange(typeFace, typeStyle, typeSize);
	            }
	        }
	    });
        bold = new Checkbox("Bold", sizeGroup, false);
	    panel.add(bold);
	    bold.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent event) {
	            if(bold.getState()) {
	                typeStyle = BOLD_FONT;
	                fontChange(typeFace, typeStyle, typeSize);
	            }
	        }
	    });
        italic = new Checkbox("Italic", sizeGroup, false);
	    panel.add(italic);
	    italic.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent event) {
	            if(italic.getState()) {
	                typeStyle = ITALIC_FONT;
	                fontChange(typeFace, typeStyle, typeSize);
	            }
	        }
	    });

        // create reset button
        panel = new Panel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        controlPanel.add(panel);
		resetButton = new Button("Reset");
		panel.add(resetButton);
		resetButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        large.setState(true);           // reset radio button
		        colorChoice.select(0);          // reset color choice box
	            text.setForeground(COLORS[0]);  // reset text color
	            typeSize = INITIAL_SIZE;        // reset type size
	            typeStyle = INITIAL_STYLE;      // reset type style
	            fontChange(typeFace, typeStyle, typeSize);      // reset text font
	        }
	    });
		
		// create exit button
		exitButton = new Button("Exit");
		panel.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);	
			}
			
		});
		
	} // end of constructor

    /**
     *  Method to change the text font
     */
    private void fontChange(String typeFace, int typeStyle, int typeSize) {
        Font font = new Font(typeFace, typeStyle, typeSize);
	    text.setFont(font);
    }

    /**
     * the main method
     */
    public static void main(String[] argv) {
        // Create frame
        Welcome welcome = new Welcome();
	    welcome.setBackground(Color.LIGHT_GRAY);
        welcome.setSize(WIDTH, HEIGHT);
        welcome.setLocation(150, 100);

        // add window closing listener
        welcome.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });

        // Show the frame
        welcome.setVisible(true);
    }
}
