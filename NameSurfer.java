/*
 * File: NameSurfer.java
 * Author : Shankul Jain
 * ---------------------
 * This program represents the popularity of baby names in the form of
 * graph.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants{
	
/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	
	public void init() {
		
		database = new NameSurferDataBase(NAMES_DATA_FILE);
		
		tf = new JTextField(10);
		tf.setActionCommand("Graph");
		tf.addActionListener(this);
		
	    add(new JLabel("Name "),SOUTH);
	    add(tf,SOUTH);
	    add(new JButton("Graph"),SOUTH);
	    add(new JButton("Clear"),SOUTH);
	    
	    graph = new NameSurferGraph();
	    add(graph);
	    
	    addActionListeners();
	}
	
/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Graph")){
			
			/* converting input in format stored in database */
			String entry = tf.getText().toLowerCase();
			entry = Character.toUpperCase(entry.charAt(0)) + entry.substring(1);
			
			graph.addEntry(database.findEntry(entry));
			tf.setText("");
		}else{
			graph.clear();
		}
	}
	
	private JTextField tf;
	private NameSurferGraph graph;
	private NameSurferDataBase database;
}
