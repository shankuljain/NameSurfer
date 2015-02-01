/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener{

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	
	public NameSurferGraph() {
		entries = new ArrayList<NameSurferEntry>();
		addComponentListener(this);
	}
	
	private void drawBackground(){
		int width = getWidth()/NDECADES;
		int height = getHeight();
		
		for(int i=0;i<NDECADES;i++){
			add(new GLine(i*width,0,i*width,height));
			GLabel label = new GLabel(""+(START_DECADE+i*10)+"");
			add(label,i*width,height-GRAPH_MARGIN_SIZE+label.getAscent());
		}
		add(new GLine(0,GRAPH_MARGIN_SIZE,getWidth(),GRAPH_MARGIN_SIZE));
		add(new GLine(0,height-GRAPH_MARGIN_SIZE,getWidth(),height-GRAPH_MARGIN_SIZE));
		
	}
	
	private void drawGraphForEntry(NameSurferEntry entry){
		Color color = getColor();
		int[] rank = entry.getRank();
		int width = getWidth()/NDECADES;
		double height = getHeight()-2*GRAPH_MARGIN_SIZE;
		
		for(int i=0;i<NDECADES-1;i++){
			
			int x1 = i*width;
			int x2 = (i+1)*width;
			
			double y1 = (rank[i]*(height/MAX_RANK))+GRAPH_MARGIN_SIZE;
			double y2 = (rank[i+1]*(height/MAX_RANK))+GRAPH_MARGIN_SIZE;
			
			String rankString;
			
			if(rank[i+1] == 0){
				y2 = height+GRAPH_MARGIN_SIZE;
			}
			
			if(rank[i] == 0){
				rankString = "*";
				y1 = height+GRAPH_MARGIN_SIZE;
				
			}else{
				rankString = String.valueOf(rank[i]);
			}
			
			GLine line = new GLine(x1,y1,x2,y2);
			line.setColor(color);
			add(line);
			
			GLabel label = new GLabel(entry.getName()+" "+ rankString);
			label.setColor(color);
			add(label,x1,y1);
			
			if(i==9){
				if(rank[i+1] == 0){
					rankString = "*";
					y2 = height+GRAPH_MARGIN_SIZE;
					
				}else{
					rankString = String.valueOf(rank[i+1]);
				}
				
				GLabel lastLabel = new GLabel(entry.getName()+" "+ rankString);
				lastLabel.setColor(color);
				add(lastLabel,x2,y2);
			}

		}
		
		
	}
	
	private Color getColor(){
		Color color = Color.black;
		switch(count%4){
		 	case 0 : color = Color.RED;
		 			 break;
		 	case 1 : color = Color.blue;
		 			 break;
		 	case 2 : color = Color.MAGENTA;
		 			 break;
		 	case 3 : color = Color.orange;
		 			 break;
		 	
		}
		return color;
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		count = 0;
		entries.clear();
		update();
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		if(entry!=null && !entries.contains(entry)){
			count++;
			entries.add(entry);
			drawGraphForEntry(entry);
		}
	}
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	 public void update() {
		count = 0;
		removeAll();
		drawBackground();
		for(int i=0;i<entries.size();i++){
			count++;
			drawGraphForEntry(entries.get(i));
		}
	}
	
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	private ArrayList<NameSurferEntry> entries;
	private int count = 0;
}
