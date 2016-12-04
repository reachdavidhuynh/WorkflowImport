package application;

import org.jdom2.Element;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;
import org.w3c.dom.Document;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.util.*;
import org.jdom2.input.SAXBuilder;


public final class CheckLogic {
	/*
	  public  static int popup(String aString) {
	        final JFrame parent = new JFrame();
	        JButton button = new JButton();
	        button.setText(aString);
	        parent.add(button);
	        parent.pack();
	        parent.setVisible(true);
	        parent.setLocationRelativeTo(null);
	        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	        int w = parent.getSize().width;
	        int h = parent.getSize().height;
	        int x = (dim.width-w)/2;
	        int y = (dim.height-h)/2;
	        parent.setLocation(x, y);
	       
	        return 0;
	    }*/
	
	public static String [] allChecks(Element root){
			String[] ret = new String[10];
			ret[0] = check1(root);
			ret[1] = check2(root);
			return ret;
		}
		
		
		
	//Check1: This check makes sure only one start, only one end state
	public static String check1(Element myRoot){
		List list = myRoot.getChildren(); 
		ListIterator iterator = list.listIterator();
		while(iterator.hasNext()){	
			Element myElement = (Element) iterator.next();
			if(myElement.getName() == "allstates"){
				break; 
			}
		}	
		Element targetElement = (Element) iterator.previous();
		List <Element> grandchildren = targetElement.getChildren();
		int startCount = 0; 
		int endCount = 0; 
		Iterator anIterator = grandchildren.iterator();
		while(anIterator.hasNext()){	
			Element myElement = (Element) anIterator.next();
			System.out.println(myElement.getName());
			if(myElement.getName() == "Start") startCount ++; 
			if(myElement.getName() == "End") endCount++;
		}	
		if (startCount != 1){
			return "ErrorCheck1: Something is wrong with your start states"; 
		}
		if (endCount != 1){
			return "ErrorCheck1: Something is wrong with your end states";
		}
		
		return "ErrorCheck1: Passed";
	}
	//Check2: This check
	public static String check2(Element myRoot){{
			List list = myRoot.getChildren(); 
			ListIterator iterator = list.listIterator();
			while(iterator.hasNext()){	
				Element myElement = (Element) iterator.next();
				if(myElement.getName() == "allflows"){
					break; 
				}
			}	
			Element targetElement = (Element) iterator.previous();
			List <Element> grandchildren = targetElement.getChildren();
			Iterator anIterator = grandchildren.iterator();
			String [] origin = new String[grandchildren.size()];
			String [] dest = new String[grandchildren.size()];
			int count = 0; 
			while(anIterator.hasNext()){	
				Element myElement = (Element) anIterator.next();
				System.out.println(myElement.getName());
				origin[count] = myElement.getChildText("origin");
				dest[count] = myElement.getChildText("dest");
				count++; 
			}	
			Iterator tempIterator = grandchildren.iterator(); 
			boolean duplicateFlag = false; 
			for(int i = 0; i<grandchildren.size(); i++){
				for(int j = i+1; j<grandchildren.size(); j++){ 
					System.out.println(origin[i] + "," + origin[j]);
					System.out.println("-----");
					if(origin[i].equals(origin[j])){
						System.out.println("Match");
						if(dest[i].equals(dest[j])){
							duplicateFlag = true;
							System.out.println("origin[i]" + origin[i] + "dest[i]" + dest[i] + "origin[j]" + origin[j] + "dest[j]" + dest[j]);
						}
					}
			}
			}
		if(duplicateFlag == true) return "ErrorCheck2: A connection is duplicated in file";
		else return "ErrorCheck2: Passed";
	}
	}//Check3: This check
	public static int check3(Element myRoot){
		return 0;
	}//Check4: This check
	public static int check4(Element myRoot){
		return 0;
	}//Check5: This check
	public static int check5(Element myRoot){
		return 0;
	}//Check6: This check
	public static int check6(Element myRoot){
		return 0;
	}//Check7: This check
	public static int check7(Element myRoot){
		return 0;
	}//Check8: This check
	public static int check8(Element myRoot){
		return 0;
	}//Check9: This check
	public static int check9(Element myRoot){
		return 0;
	}
	//Check10: This check
	public static int check10(Element myRoot){
		return 0;	
	}
	

}


