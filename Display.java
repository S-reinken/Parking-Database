package main;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class Display extends JApplet
{
	private static final long serialVersionUID = 1L;
	ArrayList<ParkingSpace> Spacelist;
	DataStreamer streamer;
	//JTextField search;
	JButton searchbutton;
	JButton savebutton;
	JPanel panel1;
	GridBagConstraints c;
	JComboBox combos;
	JLabel number;
	JLabel namelabel;
	JLabel name2label;
	JLabel car1label;
	JLabel license1label;
	JLabel carowner1label;
	JLabel car2label;
	JLabel carowner2label;
	JLabel license2label;
	JTextField name;
	JTextField name2;
	JTextField car1;
	/*JTextField carcolor;
	JTextField caryear;
	JTextField carmake;
	JTextField carmodel;*/
	JTextField car1owner;
	JTextField license1;
	JTextField car2;
	JTextField car2owner;
	JTextField license2;
	
	public void init()
	{
		JOptionPane.showMessageDialog(null, "Welcome to the Parking Lot Search Engine!\n Run this program by typing in what" +
				" you want to search and press ENTER. \nThen click the dropdown arrow and select an option.  \nPress the button and it will display the results!");
	    setSize(500, 300);
		int maximum = 201;
		Spacelist = new ArrayList<ParkingSpace>(maximum);
		arraymaker();
		combos = new JComboBox();
		combos.setEditable(true);
		combos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CharSequence copy = (CharSequence)("" + combos.getSelectedItem());
				
				
				for (int a=0; a<201; a++)//Loop for making the combo-box Options 
				{
					if (Spacelist.get(a).assignment1.contains(copy) == true) combos.addItem(Spacelist.get(a).assignment1);
					else if (Spacelist.get(a).assignment2.contains(copy) == true) combos.addItem(Spacelist.get(a).assignment2);
					else if (("" + Spacelist.get(a).spacenumber).contains(copy) == true) combos.addItem("" + Spacelist.get(a).spacenumber);
					else if (Spacelist.get(a).getOwner1().contains(copy) == true) combos.addItem(Spacelist.get(a).getOwner1());
					else if (("" + Spacelist.get(a).getYear1()).contains(copy) == true) combos.addItem(Spacelist.get(a).getYear1());
					else if (Spacelist.get(a).getLicensePlate1().contains(copy) == true) combos.addItem(Spacelist.get(a).getLicensePlate1());
					else if (Spacelist.get(a).getMake1().contains(copy) == true) combos.addItem(Spacelist.get(a).getMake1());
					else if (Spacelist.get(a).getModel1().contains(copy) == true) combos.addItem(Spacelist.get(a).getModel1());
					else if (Spacelist.get(a).getColor1().contains(copy) == true) combos.addItem(Spacelist.get(a).getColor1());
					else if (Spacelist.get(a).getLicensePlate2().contains(copy) == true) combos.addItem(Spacelist.get(a).getLicensePlate2());
					else if (Spacelist.get(a).getMake2().contains(copy) == true) combos.addItem(Spacelist.get(a).getMake2());
					else if (Spacelist.get(a).getModel2().contains(copy) == true) combos.addItem(Spacelist.get(a).getModel2());
					else if (Spacelist.get(a).getColor2().contains(copy) == true) combos.addItem(Spacelist.get(a).getColor2());
					else if (("" + Spacelist.get(a).getYear2()).contains(copy) == true) combos.addItem(Spacelist.get(a).getYear2());
					else if (Spacelist.get(a).getOwner2().contains(copy) == true) combos.addItem(Spacelist.get(a).getOwner2());
				}
				for (int c=0; c<combos.getItemCount(); c++)
				{
					
					if (combos.getItemAt(c).toString().contains(copy) == false)
					{
						System.out.println("Tick." + c);
						System.out.println(combos.getItemAt(c));
						combos.removeItemAt(c);
					}	
					//if (c == combos.getItemCount() - 1) combos.removeItemAt(c);
				}
				
			}
		});
		searchbutton = new JButton("Display Results");
		savebutton = new JButton("Save Changes");
	    streamer = new DataStreamer();
	    panel1 = new JPanel();
	    panel1.setSize(getMaximumSize());
	    panel1.setLayout(new GridBagLayout());//Setting the layout
	    c = new GridBagConstraints();
	    add(panel1);
	    panel1.add(combos, c);
	    c.gridx = 1;
	    //c.gridwidth = 4;
	    panel1.add(searchbutton, c);
	    c.gridy = 7;
	    //panel1.add(savebutton, c);
	    savebutton.setVisible(false);
	    
	    searchbutton.addActionListener(new ActionListener()//ActionListener for displaying the search results
	    {
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		DisplayResults((String) combos.getSelectedItem());
	    	}
	    });
	    
	    try {
			streamer.activate();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    String xc = "";
	    System.out.println(xc);
		for (int a=0; a<201; a++)//Loop for importing info from the text file
		{
			Spacelist.get(a).activate();
			//System.out.println("" + (a+1) + "-------");
			for (int b=0; b<15; b++)
			{
			try
			{	//System.out.println("Problem");
				Spacelist.get(a).setNumber(a+1);
				if (b==0) xc = streamer.updateListin();
				else if (b==1) Spacelist.get(a).setAssignment1(streamer.updateListin()); //System.out.println(b +"* " + Spacelist.get(a).assignment1);}
				else if (b==2) Spacelist.get(a).setAssignment2(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).assignment2);}
				else if (b==3) Spacelist.get(a).setLicensePlate1(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).getLicensePlate());}
				else if (b==4) Spacelist.get(a).setOwner1(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).getOwner());}
				else if (b==5) Spacelist.get(a).setColor1(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).getColor());}
				else if (b==6) Spacelist.get(a).setYear1(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).getYear());}
				else if (b==7) Spacelist.get(a).setMake1(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).getMake());}
				else if (b==8) Spacelist.get(a).setModel1(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).getModel());}
				else if (b==9) Spacelist.get(a).setLicensePlate2(streamer.updateListin());
				else if (b==10) Spacelist.get(a).setOwner2(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).getOwner());}
				else if (b==11) Spacelist.get(a).setColor2(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).getColor());}
				else if (b==12) Spacelist.get(a).setYear2(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).getYear());}
				else if (b==13) Spacelist.get(a).setMake2(streamer.updateListin());//System.out.println(b+"* " + Spacelist.get(a).getMake());}
				else if (b==14) Spacelist.get(a).setModel2(streamer.updateListin());
				
			}
			catch (IOException e)//Need this
			{
			    System.out.println("Problemx");
				e.printStackTrace();
			}		
			}
		}
		initialize();//Layout the rest of the window.
	}
	
	private void arraymaker()//Annoying class used for making the parking spaces in the Spacelist arraylist.
	{
		ParkingSpace space1 = new ParkingSpace();
		ParkingSpace space2 = new ParkingSpace();
		ParkingSpace space3 = new ParkingSpace();
		ParkingSpace space4 = new ParkingSpace();
		ParkingSpace space5 = new ParkingSpace();
		ParkingSpace space6 = new ParkingSpace();
		ParkingSpace space7 = new ParkingSpace();
		ParkingSpace space8 = new ParkingSpace();
		ParkingSpace space9 = new ParkingSpace();
		ParkingSpace space10 = new ParkingSpace();
		ParkingSpace space11 = new ParkingSpace();
		ParkingSpace space12 = new ParkingSpace();
		ParkingSpace space13 = new ParkingSpace();
		ParkingSpace space14 = new ParkingSpace();
		ParkingSpace space15 = new ParkingSpace();
		ParkingSpace space16 = new ParkingSpace();
		ParkingSpace space17 = new ParkingSpace();
		ParkingSpace space18 = new ParkingSpace();
		ParkingSpace space19 = new ParkingSpace();
		ParkingSpace space20 = new ParkingSpace();
		ParkingSpace space21 = new ParkingSpace();
		ParkingSpace space22 = new ParkingSpace();
		ParkingSpace space23 = new ParkingSpace();
		ParkingSpace space24 = new ParkingSpace();
		ParkingSpace space25 = new ParkingSpace();
		ParkingSpace space26 = new ParkingSpace();
		ParkingSpace space27 = new ParkingSpace();
		ParkingSpace space28 = new ParkingSpace();
		ParkingSpace space29 = new ParkingSpace();
		ParkingSpace space30 = new ParkingSpace();
		ParkingSpace space31 = new ParkingSpace();
		ParkingSpace space32 = new ParkingSpace();
		ParkingSpace space33 = new ParkingSpace();
		ParkingSpace space34 = new ParkingSpace();
		ParkingSpace space35 = new ParkingSpace();
		ParkingSpace space36 = new ParkingSpace();
		ParkingSpace space37 = new ParkingSpace();
		ParkingSpace space38 = new ParkingSpace();
		ParkingSpace space39 = new ParkingSpace();
		ParkingSpace space40 = new ParkingSpace();
		ParkingSpace space41 = new ParkingSpace();
		ParkingSpace space42 = new ParkingSpace();
		ParkingSpace space43 = new ParkingSpace();
		ParkingSpace space44 = new ParkingSpace();
		ParkingSpace space45 = new ParkingSpace();
		ParkingSpace space46 = new ParkingSpace();
		ParkingSpace space47 = new ParkingSpace();
		ParkingSpace space48 = new ParkingSpace();
		ParkingSpace space49 = new ParkingSpace();
		ParkingSpace space50 = new ParkingSpace();
		ParkingSpace space51 = new ParkingSpace();
		ParkingSpace space52 = new ParkingSpace();
		ParkingSpace space53 = new ParkingSpace();
		ParkingSpace space54 = new ParkingSpace();
		ParkingSpace space55 = new ParkingSpace();
		ParkingSpace space56 = new ParkingSpace();
		ParkingSpace space57 = new ParkingSpace();
		ParkingSpace space58 = new ParkingSpace();
		ParkingSpace space59 = new ParkingSpace();
		ParkingSpace space60 = new ParkingSpace();
		ParkingSpace space61 = new ParkingSpace();
		ParkingSpace space62 = new ParkingSpace();
		ParkingSpace space63 = new ParkingSpace();
		ParkingSpace space64 = new ParkingSpace();
		ParkingSpace space65 = new ParkingSpace();
		ParkingSpace space66 = new ParkingSpace();
		ParkingSpace space67 = new ParkingSpace();
		ParkingSpace space68 = new ParkingSpace();
		ParkingSpace space69 = new ParkingSpace();
		ParkingSpace space70 = new ParkingSpace();
		ParkingSpace space71 = new ParkingSpace();
		ParkingSpace space72 = new ParkingSpace();
		ParkingSpace space73 = new ParkingSpace();
		ParkingSpace space74 = new ParkingSpace();
		ParkingSpace space75 = new ParkingSpace();
		ParkingSpace space76 = new ParkingSpace();
		ParkingSpace space77 = new ParkingSpace();
		ParkingSpace space78 = new ParkingSpace();
		ParkingSpace space79 = new ParkingSpace();
		ParkingSpace space80 = new ParkingSpace();
		ParkingSpace space81 = new ParkingSpace();
		ParkingSpace space82 = new ParkingSpace();
		ParkingSpace space83 = new ParkingSpace();
		ParkingSpace space84 = new ParkingSpace();
		ParkingSpace space85 = new ParkingSpace();
		ParkingSpace space86 = new ParkingSpace();
		ParkingSpace space87 = new ParkingSpace();
		ParkingSpace space88 = new ParkingSpace();
		ParkingSpace space89 = new ParkingSpace();
		ParkingSpace space90 = new ParkingSpace();
		ParkingSpace space91 = new ParkingSpace();
		ParkingSpace space92 = new ParkingSpace();
		ParkingSpace space93 = new ParkingSpace();
		ParkingSpace space94 = new ParkingSpace();
		ParkingSpace space95 = new ParkingSpace();
		ParkingSpace space96 = new ParkingSpace();
		ParkingSpace space97 = new ParkingSpace();
		ParkingSpace space98 = new ParkingSpace();
		ParkingSpace space99 = new ParkingSpace();
		ParkingSpace space100 = new ParkingSpace();
		ParkingSpace space101 = new ParkingSpace();
		ParkingSpace space102 = new ParkingSpace();
		ParkingSpace space103 = new ParkingSpace();
		ParkingSpace space104 = new ParkingSpace();
		ParkingSpace space105 = new ParkingSpace();
		ParkingSpace space106 = new ParkingSpace();
		ParkingSpace space107 = new ParkingSpace();
		ParkingSpace space108 = new ParkingSpace();
		ParkingSpace space109 = new ParkingSpace();
		ParkingSpace space110 = new ParkingSpace();
		ParkingSpace space111 = new ParkingSpace();
		ParkingSpace space112 = new ParkingSpace();
		ParkingSpace space113 = new ParkingSpace();
		ParkingSpace space114 = new ParkingSpace();
		ParkingSpace space115 = new ParkingSpace();
		ParkingSpace space116 = new ParkingSpace();
		ParkingSpace space117 = new ParkingSpace();
		ParkingSpace space118 = new ParkingSpace();
		ParkingSpace space119 = new ParkingSpace();
		ParkingSpace space120 = new ParkingSpace();
		ParkingSpace space121 = new ParkingSpace();
		ParkingSpace space122 = new ParkingSpace();
		ParkingSpace space123 = new ParkingSpace();
		ParkingSpace space124 = new ParkingSpace();
		ParkingSpace space125 = new ParkingSpace();
		ParkingSpace space126 = new ParkingSpace();
		ParkingSpace space127 = new ParkingSpace();
		ParkingSpace space128 = new ParkingSpace();
		ParkingSpace space129 = new ParkingSpace();
		ParkingSpace space130 = new ParkingSpace();
		ParkingSpace space131 = new ParkingSpace();
		ParkingSpace space132 = new ParkingSpace();
		ParkingSpace space133 = new ParkingSpace();
		ParkingSpace space134 = new ParkingSpace();
		ParkingSpace space135 = new ParkingSpace();
		ParkingSpace space136 = new ParkingSpace();
		ParkingSpace space137 = new ParkingSpace();
		ParkingSpace space138 = new ParkingSpace();
		ParkingSpace space139 = new ParkingSpace();
		ParkingSpace space140 = new ParkingSpace();
		ParkingSpace space141 = new ParkingSpace();
		ParkingSpace space142 = new ParkingSpace();
		ParkingSpace space143 = new ParkingSpace();
		ParkingSpace space144 = new ParkingSpace();
		ParkingSpace space145 = new ParkingSpace();
		ParkingSpace space146 = new ParkingSpace();
		ParkingSpace space147 = new ParkingSpace();
		ParkingSpace space148 = new ParkingSpace();
		ParkingSpace space149 = new ParkingSpace();
		ParkingSpace space150 = new ParkingSpace();
		ParkingSpace space151 = new ParkingSpace();
		ParkingSpace space152 = new ParkingSpace();
		ParkingSpace space153 = new ParkingSpace();
		ParkingSpace space154 = new ParkingSpace();
		ParkingSpace space155 = new ParkingSpace();
		ParkingSpace space156 = new ParkingSpace();
		ParkingSpace space157 = new ParkingSpace();
		ParkingSpace space158 = new ParkingSpace();
		ParkingSpace space159 = new ParkingSpace();
		ParkingSpace space160 = new ParkingSpace();
		ParkingSpace space161 = new ParkingSpace();
		ParkingSpace space162 = new ParkingSpace();
		ParkingSpace space163 = new ParkingSpace();
		ParkingSpace space164 = new ParkingSpace();
		ParkingSpace space165 = new ParkingSpace();
		ParkingSpace space166 = new ParkingSpace();
		ParkingSpace space167 = new ParkingSpace();
		ParkingSpace space168 = new ParkingSpace();
		ParkingSpace space169 = new ParkingSpace();
		ParkingSpace space170 = new ParkingSpace();
		ParkingSpace space171 = new ParkingSpace();
		ParkingSpace space172 = new ParkingSpace();
		ParkingSpace space173 = new ParkingSpace();
		ParkingSpace space174 = new ParkingSpace();
		ParkingSpace space175 = new ParkingSpace();
		ParkingSpace space176 = new ParkingSpace();
		ParkingSpace space177 = new ParkingSpace();
		ParkingSpace space178 = new ParkingSpace();
		ParkingSpace space179 = new ParkingSpace();
		ParkingSpace space180 = new ParkingSpace();
		ParkingSpace space181 = new ParkingSpace();
		ParkingSpace space182 = new ParkingSpace();
		ParkingSpace space183 = new ParkingSpace();
		ParkingSpace space184 = new ParkingSpace();
		ParkingSpace space185 = new ParkingSpace();
		ParkingSpace space186 = new ParkingSpace();
		ParkingSpace space187 = new ParkingSpace();
		ParkingSpace space188 = new ParkingSpace();
		ParkingSpace space189 = new ParkingSpace();
		ParkingSpace space190 = new ParkingSpace();
		ParkingSpace space191 = new ParkingSpace();
		ParkingSpace space192 = new ParkingSpace();
		ParkingSpace space193 = new ParkingSpace();
		ParkingSpace space194 = new ParkingSpace();
		ParkingSpace space195 = new ParkingSpace();
		ParkingSpace space196 = new ParkingSpace();
		ParkingSpace space197 = new ParkingSpace();
		ParkingSpace space198 = new ParkingSpace();
		ParkingSpace space199 = new ParkingSpace();
		ParkingSpace space200 = new ParkingSpace();
		ParkingSpace space201 = new ParkingSpace();
		Spacelist.add(space1);
		Spacelist.add(space2);
		Spacelist.add(space3);
		Spacelist.add(space4);
		Spacelist.add(space5);
		Spacelist.add(space6);
		Spacelist.add(space7);
		Spacelist.add(space8);
		Spacelist.add(space9);
		Spacelist.add(space10);
		Spacelist.add(space11);
		Spacelist.add(space12);
		Spacelist.add(space13);
		Spacelist.add(space14);
		Spacelist.add(space15);
		Spacelist.add(space16);
		Spacelist.add(space17);
		Spacelist.add(space18);
		Spacelist.add(space19);
		Spacelist.add(space20);
		Spacelist.add(space21);
		Spacelist.add(space22);
		Spacelist.add(space23);
		Spacelist.add(space24);
		Spacelist.add(space25);
		Spacelist.add(space26);
		Spacelist.add(space27);
		Spacelist.add(space28);
		Spacelist.add(space29);
		Spacelist.add(space30);
		Spacelist.add(space31);
		Spacelist.add(space32);
		Spacelist.add(space33);
		Spacelist.add(space34);
		Spacelist.add(space35);
		Spacelist.add(space36);
		Spacelist.add(space37);
		Spacelist.add(space38);
		Spacelist.add(space39);
		Spacelist.add(space40);
		Spacelist.add(space41);
		Spacelist.add(space42);
		Spacelist.add(space43);
		Spacelist.add(space44);
		Spacelist.add(space45);
		Spacelist.add(space46);
		Spacelist.add(space47);
		Spacelist.add(space48);
		Spacelist.add(space49);
		Spacelist.add(space50);
		Spacelist.add(space51);
		Spacelist.add(space52);
		Spacelist.add(space53);
		Spacelist.add(space54);
		Spacelist.add(space55);
		Spacelist.add(space56);
		Spacelist.add(space57);
		Spacelist.add(space58);
		Spacelist.add(space59);
		Spacelist.add(space60);
		Spacelist.add(space61);
		Spacelist.add(space62);
		Spacelist.add(space63);
		Spacelist.add(space64);
		Spacelist.add(space65);
		Spacelist.add(space66);
		Spacelist.add(space67);
		Spacelist.add(space68);
		Spacelist.add(space69);
		Spacelist.add(space70);
		Spacelist.add(space71);
		Spacelist.add(space72);
		Spacelist.add(space73);
		Spacelist.add(space74);
		Spacelist.add(space75);
		Spacelist.add(space76);
		Spacelist.add(space77);
		Spacelist.add(space78);
		Spacelist.add(space79);
		Spacelist.add(space80);
		Spacelist.add(space81);
		Spacelist.add(space82);
		Spacelist.add(space83);
		Spacelist.add(space84);
		Spacelist.add(space85);
		Spacelist.add(space86);
		Spacelist.add(space87);
		Spacelist.add(space88);
		Spacelist.add(space89);
		Spacelist.add(space90);
		Spacelist.add(space91);
		Spacelist.add(space92);
		Spacelist.add(space93);
		Spacelist.add(space94);
		Spacelist.add(space95);
		Spacelist.add(space96);
		Spacelist.add(space97);
		Spacelist.add(space98);
		Spacelist.add(space99);
		Spacelist.add(space100);
		Spacelist.add(space101);
		Spacelist.add(space102);
		Spacelist.add(space103	);
		Spacelist.add(space104	);
		Spacelist.add(space105	);
		Spacelist.add(space106	);
		Spacelist.add(space107	);
		Spacelist.add(space108	);
		Spacelist.add(space109	);
		Spacelist.add(space110	);
		Spacelist.add(space111	);
		Spacelist.add(space112	);
		Spacelist.add(space113	);
		Spacelist.add(space114	);
		Spacelist.add(space115	);
		Spacelist.add(space116	);
		Spacelist.add(space117	);
		Spacelist.add(space118	);
		Spacelist.add(space119	);
		Spacelist.add(space120	);
		Spacelist.add(space121	);
		Spacelist.add(space122	);
		Spacelist.add(space123	);
		Spacelist.add(space124	);
		Spacelist.add(space125	);
		Spacelist.add(space126	);
		Spacelist.add(space127	);
		Spacelist.add(space128	);
		Spacelist.add(space129	);
		Spacelist.add(space130	);
		Spacelist.add(space131	);
		Spacelist.add(space132	);
		Spacelist.add(space133	);
		Spacelist.add(space134	);
		Spacelist.add(space135	);
		Spacelist.add(space136	);
		Spacelist.add(space137	);
		Spacelist.add(space138	);
		Spacelist.add(space139	);
		Spacelist.add(space140	);
		Spacelist.add(space141	);
		Spacelist.add(space142	);
		Spacelist.add(space143	);
		Spacelist.add(space144	);
		Spacelist.add(space145	);
		Spacelist.add(space146	);
		Spacelist.add(space147	);
		Spacelist.add(space148	);
		Spacelist.add(space149	);
		Spacelist.add(space150	);
		Spacelist.add(space151	);
		Spacelist.add(space152	);
		Spacelist.add(space153	);
		Spacelist.add(space154	);
		Spacelist.add(space155	);
		Spacelist.add(space156	);
		Spacelist.add(space157	);
		Spacelist.add(space158	);
		Spacelist.add(space159	);
		Spacelist.add(space160	);
		Spacelist.add(space161	);
		Spacelist.add(space162	);
		Spacelist.add(space163	);
		Spacelist.add(space164	);
		Spacelist.add(space165	);
		Spacelist.add(space166	);
		Spacelist.add(space167	);
		Spacelist.add(space168	);
		Spacelist.add(space169	);
		Spacelist.add(space170	);
		Spacelist.add(space171	);
		Spacelist.add(space172	);
		Spacelist.add(space173	);
		Spacelist.add(space174	);
		Spacelist.add(space175	);
		Spacelist.add(space176	);
		Spacelist.add(space177	);
		Spacelist.add(space178	);
		Spacelist.add(space179	);
		Spacelist.add(space180	);
		Spacelist.add(space181	);
		Spacelist.add(space182	);
		Spacelist.add(space183	);
		Spacelist.add(space184	);
		Spacelist.add(space185	);
		Spacelist.add(space186	);
		Spacelist.add(space187	);
		Spacelist.add(space188	);
		Spacelist.add(space189	);
		Spacelist.add(space190	);
		Spacelist.add(space191	);
		Spacelist.add(space192	);
		Spacelist.add(space193	);
		Spacelist.add(space194	);
		Spacelist.add(space195	);
		Spacelist.add(space196	);
		Spacelist.add(space197	);
		Spacelist.add(space198	);
		Spacelist.add(space199	);
		Spacelist.add(space200	);
		Spacelist.add(space201	);
	}
	
	private void initialize()//Layin' out the window
	{
		number = new JLabel("");
		namelabel = new JLabel("Assigned Occupant 1:");
		name2label = new JLabel("Assigned Occupant 2:");
		car1label = new JLabel("Car 1 (color,year,make,model):");
		license1label = new JLabel("License Plate (car 1):");
		carowner1label = new JLabel("Owner of Car 1:");
		car2label = new JLabel("Car 2 (color, year, make, model)");
		carowner2label = new JLabel("Owner of Car 2");
		license2label = new JLabel("License Plate (car 2)");
		name = new JTextField(23);
		name2 = new JTextField(23);
		car1 = new JTextField(23);
		car2 = new JTextField(23);
		car2owner = new JTextField(23);
		license2 = new JTextField(23);
		
		/*carcolor = new JTextField(5);
		caryear = new JTextField(5);
		carmake = new JTextField(5);
		carmodel = new JTextField(5);*/
		
		license1 = new JTextField(23);
		car1owner = new JTextField(23);
		c.gridwidth = 1;
		c.gridx=0;
		c.gridy=2;
		panel1.add(namelabel, c);
		c.gridy = 3;
		panel1.add(name2label, c);
		c.gridy = 4;
		panel1.add(car1label, c);
		c.gridy = 5;
		panel1.add(carowner1label, c);
		c.gridy = 6;
		panel1.add(license1label, c);
		c.gridy = 7;
		panel1.add(car2label, c);
		c.gridy = 8;
		panel1.add(carowner2label, c);
		c.gridy = 9;
		panel1.add(license2label, c);
		c.gridx = 1;
	    c.gridy = 4;
	    panel1.add(car1, c);
	    c.gridy = 1;
	    c.gridx = 1;
	    //c.gridwidth = 4;
	    panel1.add(number, c);
	    c.gridy = 2;
	    panel1.add(name, c);
	    c.gridy = 3;
	    panel1.add(name2, c);
	    c.gridy = 5;
	    panel1.add(car1owner, c);
	    c.gridy = 6;
	    panel1.add(license1, c);
	    c.gridy = 7;
	    panel1.add(car2, c);
	    c.gridy = 8;
	    panel1.add(car2owner, c);
	    c.gridy = 9;
	    panel1.add(license2, c);
	    
	}
	
	private void DisplayResults(String s)//Displaying the results of the selection.
	{
		int a;
		for (a=0; a<200; a++)
		{
			if (Spacelist.get(a).getnum().equals(s) == true) break; 
			if (s == Spacelist.get(a).assignment1 || s == Spacelist.get(a).assignment2 || s == Spacelist.get(a).getLicensePlate1() || s == Spacelist.get(a).getColor1() || s == Spacelist.get(a).getOwner1()
					|| s == Spacelist.get(a).getMake1() || s == Spacelist.get(a).getModel1() || s == Spacelist.get(a).getYear1() || s == Spacelist.get(a).getLicensePlate2() || s == Spacelist.get(a).getColor2() || s == Spacelist.get(a).getOwner2()
							|| s == Spacelist.get(a).getMake2() || s == Spacelist.get(a).getModel2() || s == Spacelist.get(a).getYear2()
					) 
				{
				break;
				}
		}
	    number.setText("Parking Space: " + Spacelist.get(a).spacenumber);
	    name.setText("" + Spacelist.get(a).assignment1);
	    name2.setText("" + Spacelist.get(a).assignment2);
	    car1.setText("" + Spacelist.get(a).getColor1() + " " + Spacelist.get(a).getYear1() + " " + Spacelist.get(a).getMake1() + " " + Spacelist.get(a).getModel1());
	    car2.setText("" + Spacelist.get(a).getColor2() + " " + Spacelist.get(a).getYear2() + " " + Spacelist.get(a).getMake2() + " " + Spacelist.get(a).getModel2());
	    /*carcolor.setText("" + Spacelist.get(a).getColor1());
	    caryear.setText(Spacelist.get(a).getYear1());
	    carmake.setText(Spacelist.get(a).getMake1());
	    carmodel.setText(Spacelist.get(a).getModel1());*/
	    car1owner.setText("" + Spacelist.get(a).getOwner1());
	    car2owner.setText("" + Spacelist.get(a).getOwner2());
	    license1.setText("" + Spacelist.get(a).getLicensePlate1());
	    license2.setText("" + Spacelist.get(a).getLicensePlate2());
	    //savebutton.setVisible(true);
	    /*savebutton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				Spacelist.get(b).setAssignment1(name.getText());
				Spacelist.get(b).setAssignment2(name2.getText());
				Spacelist.get(b).setColor1(carcolor.getText());
				Spacelist.get(b).setYear1(caryear.getText());
				Spacelist.get(b).setMake1(carmake.getText());
				Spacelist.get(b).setModel1(carmake.getText());
				Spacelist.get(b).setOwner1(carowner.getText());
				Spacelist.get(b).setLicensePlate1(license.getText());	
			}
	    });*/
	}
	
	/*public void destroy()
	{
		for (int a=0; a<201; a++)
		{
			for (int b=0; b<9; b++)
			{
			try
			{	
				if (b==0) streamer.updateListout("" + a);
				if (b==1) streamer.updateListout(Spacelist.get(a).assignment1);
				if (b==2) streamer.updateListout(Spacelist.get(a).assignment2);
				if (b==3) streamer.updateListout(Spacelist.get(a).getLicensePlate());
				if (b==4) streamer.updateListout(Spacelist.get(a).getOwner());
				if (b==5) streamer.updateListout(Spacelist.get(a).getColor());
				if (b==6) streamer.updateListout(Spacelist.get(a).getYear());
				if (b==7) streamer.updateListout(Spacelist.get(a).getMake());
				if (b==8) streamer.updateListout(Spacelist.get(a).getModel());
			}
			catch (IOException e1)
			{
			    System.out.println("Problemxx");
				e1.printStackTrace();
			}
		}
	}
	}*/
}
