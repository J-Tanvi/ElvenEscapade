//Name: Tanvi Jain
//Date: May 18, 2022
//Purpose: Final Project

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
public class SokobanGame extends Applet implements ActionListener
{
    Panel p_card;  //to hold all of the screens
    Panel card1, card2, card3, card4, card5;
    CardLayout cdLayout = new CardLayout ();

    //timer code
    int minutesPassed = 0;
    Timer timer = new Timer ();
    TimerTask task = new TimerTask ()
    {
	public void run ()
	{
	    minutesPassed++;
	    showStatus ("Your Play Time in minutes is: " + minutesPassed);
	}
    }


    ;

    //textfield
    JTextField input;

    //grid
    int row = 8;
    int col = 8;

    int progress = 0;
    JLabel title;
    int level = 1;
    //stores the current level
    int x = 3;
    int y = 2;
    JLabel a[] = new JLabel [row * col];

    char ground[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'g', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'g', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'g', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'g', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char top[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'b', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'b', 'n', 'n', 'w'},
	    {'w', 'n', 'b', 'n', 'b', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};
    //stores levels 1-5
    int x1 = 3;
    int y1 = 2;

    char ground1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'g', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'g', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'g', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'g', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char top1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'b', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'b', 'n', 'n', 'w'},
	    {'w', 'n', 'b', 'n', 'b', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    int x2 = 5;
    int y2 = 1;

    char ground2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', },
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'g', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'g', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'g', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char top2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'b', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'b', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'b', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    int x3 = 1;
    int y3 = 5;

    char ground3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'g', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'g', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'w', 'w', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'w', 'g', 'n', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char top3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'b', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'b', 'b', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'w', 'w', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'w', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    int x4 = 6;
    int y4 = 5;

    char ground4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'g', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char top4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'b', 'n', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    int x5 = 6;
    int y5 = 2;

    char ground5[] [] = {
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'w', 'g', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'w', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'g', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'w', 'w', 'n', 'n', 'w'},
	    {'w', 'g', 'n', 'w', 'n', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char top5[] [] = {
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'w', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'n', 'n', 'b', 'w'},
	    {'w', 'n', 'n', 'w', 'w', 'n', 'n', 'w'},
	    {'w', 'n', 'n', 'n', 'w', 'b', 'n', 'w'},
	    {'w', 'n', 'n', 'w', 'w', 'n', 'n', 'w'},
	    {'w', 'b', 'n', 'w', 'n', 'n', 'n', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    //displays date
    public void date ()
    {
	Date now = new Date ();
	DateFormat df = DateFormat.getDateInstance ();
	df.setTimeZone (TimeZone.getTimeZone ("Canada/Toronto"));
	String s = df.format (now);
	JOptionPane.showMessageDialog (null, "Today is " + s,
		"Date", JOptionPane.INFORMATION_MESSAGE);
    }


    //sets up all the screens
    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	date ();
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	resize (512, 670);
	setLayout (new BorderLayout ());
	menu ();
	add ("Center", p_card);
    }


    //adds a menu for users
    public void menu ()
    {
	JMenuBar menuBar = new JMenuBar ();
	JMenu menu;
	JMenuItem menuItem;

	menu = new JMenu ("File");
	menuBar.add (menu);
	menuItem = new JMenuItem ("Date");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("date");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Reset Level");
	menuItem.setActionCommand ("reset");
	menuItem.addActionListener (this);
	menu.add (menuItem);
	menuItem = new JMenuItem ("Exit");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("Close");
	menu.add (menuItem);

	menu = new JMenu ("Navigate");
	menuBar.add (menu);
	menuItem = new JMenuItem ("Opening");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("1");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Intructions");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("2");
	menu.add (menuItem);
	menuItem = new JMenuItem ("Play");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("3");
	menu.add (menuItem);

	menuItem = new JMenuItem ("Help");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("5");
	menu.add (menuItem);
	add ("North", menuBar);
    }


    //title screen
    public void screen1 ()
    {
	card1 = new Panel ();
	JButton titleImage = new JButton (createImageIcon ("Title screen.jpg"));
	titleImage.setBackground (new Color (25, 25, 25));
	titleImage.setActionCommand ("2");
	titleImage.addActionListener (this);
	card1.add (titleImage);
	p_card.add ("1", card1);
    }


    //instructions screen
    public void screen2 ()
    {
	card2 = new Panel ();
	JButton ins = new JButton (createImageIcon ("instuctions.jpg"));
	ins.setBackground (new Color (25, 25, 25));
	ins.setActionCommand ("3");
	ins.addActionListener (this);
	card2.add (ins);
	p_card.add ("2", card2);
    }


    //game screen
    public void screen3 ()
    {
	card3 = new Panel ();
	card3.setBackground (new Color (49, 147, 55));
	title = new JLabel ("                        Level 1                        ");
	title.setFont (new Font ("Broadway", Font.BOLD, 30));

	//Set up grid
	Panel p = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move] = new JLabel (createImageIcon (ground [i] [j] + "" + top [i] [j] + ".png"));
		a [move].setPreferredSize (new Dimension (64, 64));
		p.add (a [move]);
		move++;
	    }
	}

	a [x * col + y].setIcon (createImageIcon (ground [x] [y] + "down.png"));

	JButton up = new JButton ("Up");
	up.setActionCommand ("up");
	up.addActionListener (this);
	up.setBackground (new Color (109, 161, 114));
	up.setFont (new Font ("Broadway", Font.PLAIN, 15));
	JButton down = new JButton ("Down");
	down.setActionCommand ("down");
	down.addActionListener (this);
	down.setBackground (new Color (109, 161, 114));
	down.setFont (new Font ("Broadway", Font.PLAIN, 15));
	JButton right = new JButton ("Right");
	right.setActionCommand ("right");
	right.addActionListener (this);
	right.setBackground (new Color (109, 161, 114));
	right.setFont (new Font ("Broadway", Font.PLAIN, 15));
	JButton left = new JButton ("Left");
	left.setActionCommand ("left");
	left.addActionListener (this);
	left.setBackground (new Color (109, 161, 114));
	left.setFont (new Font ("Broadway", Font.PLAIN, 15));

	card3.add (title);
	card3.add (p);

	Panel dir = new Panel (new GridLayout (2, 3));
	JLabel filler = new JLabel ("");
	JLabel filler2 = new JLabel ("");
	JLabel filler3 = new JLabel ("");

	dir.add (filler);
	dir.add (up);
	dir.add (filler2);

	dir.add (left);
	dir.add (down);
	dir.add (right);
	card3.add (dir);


	p_card.add ("3", card3);
    }


    //winning screen
    public void screen4 ()
    {
	card4 = new Panel ();
	JButton title = new JButton (createImageIcon ("winScreen.png"));
	title.setBackground (new Color (25, 25, 25));
	title.setActionCommand ("1");
	title.addActionListener (this);
	card4.add (title);
	p_card.add ("4", card4);
    }


    //help screen
    public void screen5 ()
    {
	card5 = new Panel ();
	card5.setBackground (new Color (162, 188, 53));
	JLabel title = new JLabel (createImageIcon ("help.jpg"));
	//textfield for user input (doesnt really do anything other than allow users to type stuff)
	JLabel enter = new JLabel ("Enter question here: ");
	input = new JTextField (15);
	JButton done = new JButton ("Send");
	done.setBackground (new Color (109, 161, 114));
	done.addActionListener (this);
	done.setActionCommand ("send");
	card5.add (title);
	card5.add (enter);
	card5.add (input);
	card5.add (done);
	p_card.add ("5", card5);
    }


    //redraws the arrays containing each level
    public void redraw ()
    {
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move].setIcon (createImageIcon (ground [i] [j] + "" + top [i] [j] + ".png"));
		move++;
	    }
	}
    }


    //movement code
    public void moveUp ()
    {
	//check for walls
	if (ground [x - 1] [y] == 'w' || (top [x - 2] [y] == 'w' && top [x - 1] [y] == 'b'))
	    showStatus ("There is a fence.");
	//stops user from moving 2 boxs in a row
	else if (top [x - 2] [y] == 'b' && top [x - 1] [y] == 'b')
	    showStatus ("I think not.");
	//moving boxes
	else if (top [x - 1] [y] == 'b')
	{
	    showStatus ("Defy gravity!!");
	    if (ground [x] [y] == 'g')
		a [x * col + y].setIcon (createImageIcon ("gn.png"));
	    else
		a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    x--;
	    a [x * col + y].setIcon (createImageIcon ("nup.png"));
	    a [(x - 1) * col + y].setIcon (createImageIcon ("nb.png"));
	    top [x - 1] [y] = 'b';
	    top [x] [y] = 'n';
	    if (ground [x - 1] [y] == 'g' && top [x - 1] [y] == 'b')
	    {
		showStatus ("Goal!");
		a [(x - 1) * col + y].setIcon (createImageIcon ("gb.png"));
	    }
	}
	//allows users to go over goals
	else if (ground [x - 1] [y] == 'g')
	{
	    showStatus ("I'm not a box :[");
	    a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    x--;
	    a [x * col + y].setIcon (createImageIcon ("gup.png"));
	}
	//moves into a black space
	else
	{
	    showStatus ("Up we go!");
	    if (ground [x] [y] == 'g')
		a [x * col + y].setIcon (createImageIcon ("gn.png"));
	    else
		a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    x--;
	    a [x * col + y].setIcon (createImageIcon ("nup.png"));
	}
	//printArray ("Up: ");



    }


    public void moveDown ()
    {
	//check for walls
	if (ground [x + 1] [y] == 'w' || (top [x + 2] [y] == 'w' && top [x + 1] [y] == 'b'))
	    showStatus ("There is a fence of wood.");
	//stops user from moving 2 boxs in a row
	else if (top [x + 2] [y] == 'b' && top [x + 1] [y] == 'b')
	    showStatus ("You cannot move two boxs at once.");
	//moving boxes
	else if (top [x + 1] [y] == 'b')
	{
	    showStatus ("Wonder what's in here?");
	    if (ground [x] [y] == 'g')
		a [x * col + y].setIcon (createImageIcon ("gn.png"));
	    else
		a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    x++;
	    a [x * col + y].setIcon (createImageIcon ("ndown.png"));
	    a [(x + 1) * col + y].setIcon (createImageIcon ("nb.png"));
	    top [x + 1] [y] = 'b';
	    top [x] [y] = 'n';
	    if (ground [x + 1] [y] == 'g' && top [x + 1] [y] == 'b')
	    {
		showStatus ("Goal!");
		a [(x + 1) * col + y].setIcon (createImageIcon ("gb.png"));
	    }
	}
	//allows users to go over goals
	else if (ground [x + 1] [y] == 'g')
	{
	    showStatus ("*cosplays as a box*");
	    a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    x++;
	    a [x * col + y].setIcon (createImageIcon ("gdown.png"));
	}
	//moves into a black space
	else
	{
	    showStatus ("Shorty get low low low~");
	    if (ground [x] [y] == 'g')
		a [x * col + y].setIcon (createImageIcon ("gn.png"));
	    else
		a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    x++;
	    a [x * col + y].setIcon (createImageIcon ("ndown.png"));
	}
	//printArray ("Down: ");
    }


    public void moveLeft ()
    {
	//check for walls
	if (ground [x] [y - 1] == 'w' || (top [x] [y - 2] == 'w' && top [x] [y - 1] == 'b'))
	    showStatus ("This is a collection of pillars made of cut wood.");
	//stops user from moving 2 boxs in a row
	else if (top [x] [y - 2] == 'b' && top [x] [y - 1] == 'b')
	    showStatus ("Do you lift bro?");
	//moving boxes
	else if (top [x] [y - 1] == 'b')
	{
	    showStatus ("Moving box left!");
	    if (ground [x] [y] == 'g')
		a [x * col + y].setIcon (createImageIcon ("gn.png"));
	    else
		a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    y--;
	    a [x * col + y].setIcon (createImageIcon ("nleft.png"));
	    a [x * col + (y - 1)].setIcon (createImageIcon ("nb.png"));
	    top [x] [y - 1] = 'b';
	    top [x] [y] = 'n';
	    if (ground [x] [y - 1] == 'g' && top [x] [y - 1] == 'b')
	    {
		showStatus ("Goal!");
		a [x * col + (y - 1)].setIcon (createImageIcon ("gb.png"));
	    }
	}
	//allows users to go over goals
	else if (ground [x] [y - 1] == 'g')
	{
	    showStatus ("Move.");
	    a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    y--;
	    a [x * col + y].setIcon (createImageIcon ("gleft.png"));
	}
	//moves into a black space
	else
	{
	    showStatus ("To the left now yall!");
	    if (ground [x] [y] == 'g')
		a [x * col + y].setIcon (createImageIcon ("gn.png"));
	    else
		a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    y--;
	    a [x * col + y].setIcon (createImageIcon ("nleft.png"));
	}
	//printArray ("Left: ");
    }


    public void moveRight ()
    {
	//checks for walls
	if (ground [x] [y + 1] == 'w' || (top [x] [y + 2] == 'w' && top [x] [y + 1] == 'b'))
	    showStatus ("The item before you is a fence. Meaning no go amego.");
	//stops user from moving 2 boxs in a row
	else if (top [x] [y + 2] == 'b' && top [x] [y + 1] == 'b')
	    showStatus ("Girl no.");
	//moves boxes
	else if (top [x] [y + 1] == 'b')
	{
	    showStatus ("PUSHHHH");
	    if (ground [x] [y] == 'g')
		a [x * col + y].setIcon (createImageIcon ("gn.png"));
	    else
		a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    y++;
	    a [x * col + y].setIcon (createImageIcon ("nright.png"));
	    a [x * col + (y + 1)].setIcon (createImageIcon ("nb.png"));
	    top [x] [y + 1] = 'b';
	    top [x] [y] = 'n';
	    if (ground [x] [y + 1] == 'g' && top [x] [y + 1] == 'b')
	    {
		showStatus ("Goal!");
		a [x * col + (y + 1)].setIcon (createImageIcon ("gb.png"));
	    }
	}
	//allows users to go over goals
	else if (ground [x] [y + 1] == 'g')
	{
	    showStatus ("Place boxes here!");
	    a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    y++;
	    a [x * col + y].setIcon (createImageIcon ("gright.png"));
	}
	//moves into a black space
	else
	{
	    showStatus ("Slide to the right!");
	    if (ground [x] [y] == 'g')
		a [x * col + y].setIcon (createImageIcon ("gn.png"));
	    else
		a [x * col + y].setIcon (createImageIcon ("nn.png"));
	    y++;
	    a [x * col + y].setIcon (createImageIcon ("nright.png"));
	}
	//printArray ("Right: ");
    }


    //checks to see if all goals have a box on it
    public boolean levelCheck ()
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (ground [i] [j] == 'g' && top [i] [j] != 'b')
		    return false;
	    }
	}
	progress++;
	return true;
    }


    //checks to see if all levels are complete
    public boolean win ()
    {
	if (progress == 5)
	    return true;
	return false;
    }


    //resets the board for users
    public void reset ()
    {
	showStatus ("Resetting Board!");

	if (level == 1)
	{
	    copyOver (ground, ground1);
	    copyOver (top, top1);
	    x = x1;
	    y = y1;
	}
	else if (level == 2)
	{
	    copyOver (ground, ground2);
	    copyOver (top, top2);
	    x = x2;
	    y = y2;
	}
	else if (level == 3)
	{
	    copyOver (ground, ground3);
	    copyOver (top, top3);
	    x = x3;
	    y = y3;
	}
	else if (level == 4)
	{
	    copyOver (ground, ground4);
	    copyOver (top, top4);
	    x = x4;
	    y = y4;
	}
	else if (level == 5)
	{
	    copyOver (ground, ground5);
	    copyOver (top, top5);
	    x = x5;
	    y = y5;
	}
	redraw ();
	a [x * col + y].setIcon (createImageIcon (ground [x] [y] + "down.png"));
    }


    //switches levels
    public void next ()
    {
	level++;
	title.setText ("                        Level " + level + "                        ");
	if (level == 2)
	{
	    copyOver (ground, ground2);
	    copyOver (top, top2);
	    x = x2;
	    y = y2;
	}
	else if (level == 3)
	{
	    copyOver (ground, ground3);
	    copyOver (top, top3);
	    x = x3;
	    y = y3;
	}
	else if (level == 4)
	{
	    copyOver (ground, ground4);
	    copyOver (top, top4);
	    x = x4;
	    y = y4;
	}
	else if (level == 5)
	{
	    copyOver (ground, ground5);
	    copyOver (top, top5);
	    x = x5;
	    y = y5;
	}
	//add more levels here
	else
	{
	    title.setText ("                        Level 1                        ");
	    copyOver (ground, ground1);
	    copyOver (top, top1);
	    x = x1;
	    y = y1;
	    level = 1;
	}
	redraw ();
	a [x * col + y].setIcon (createImageIcon (ground [x] [y] + "down.png"));
    }


    //replaces the current images with new ones (changes the display of levels for user)
    public void copyOver (char a[] [], char b[] [])
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [i] [j] = b [i] [j];
	    }
	}
    }


    public void actionPerformed (ActionEvent e)
    {
	//for the menu
	if (e.getActionCommand ().equals ("5"))
	    cdLayout.show (p_card, "5");
	else if (e.getActionCommand ().equals ("2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("date"))
	    date ();
	else if (e.getActionCommand ().equals ("reset"))
	    reset ();
	else if (e.getActionCommand ().equals ("send"))
	    JOptionPane.showMessageDialog (null, "Your question has been sent in and will be answered shortly!", "Sent!", JOptionPane.INFORMATION_MESSAGE);
	else if (e.getActionCommand ().equals ("Close"))
	    System.exit (0);
	//for the movement
	else if (e.getActionCommand ().equals ("up"))
	    moveUp ();
	else if (e.getActionCommand ().equals ("down"))
	    moveDown ();
	else if (e.getActionCommand ().equals ("left"))
	    moveLeft ();
	else if (e.getActionCommand ().equals ("right"))
	    moveRight ();
	//displays a pop up when a level is done
	if (levelCheck ())
	{
	    JOptionPane.showMessageDialog (null, "Level " + level + " complete!", "Level Complete!", JOptionPane.INFORMATION_MESSAGE);
	    next ();
	}
	//takes user to the winning screen
	if (win ())
	{
	    cdLayout.show (p_card, "4");
	    JOptionPane.showMessageDialog (null, "Thank you for playing! You have now finsihed all levels! Click to play again or quit!",
		    "Game Over", JOptionPane.INFORMATION_MESSAGE);
	    progress = 0;
	    level = 1;
	    reset ();
	}
    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = SokobanGame.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
}
