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
	    }
	
	public static void allChecks(Element root){
		List list = root.getChildren();
	
		
		/* Looping Test Proves We Can Pass myRoot	
			for(Iterator iterator = list.iterator(); iterator.hasNext();){	
				
				Element myElement = (Element) iterator.next();
				List <Element> grandchildren = myElement.getChildren();
			
				System.out.println("\n\n(IN CHECKLOGIC) subroot node : " + myElement.getName());
			}	
		*/	
			check1(root);
			return;
		}
		
		
		
	//Check1: This check
	public static int check1(Element myRoot){
		List list = myRoot.getChildren(); 
		ListIterator iterator = list.listIterator();
		while(iterator.hasNext()){	
			Element myElement = (Element) iterator.next();
			if(myElement.getName() == "allstates"){
				break; 
			}
		}	
		Element targetElement = (Element) iterator.previous();
		System.out.println(targetElement.getName()); 
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
		System.out.println("startcount: " + startCount);
		if (startCount != 1){
			popup("Something is wrong with your start states") ;
			return 0; 
		}
		if (endCount != 1){
			popup("Something is wrong with your end states");
		}
		
		return 0;
	}
	//Check2: This check
	public static int check2(Element myRoot){
		return 0;
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


