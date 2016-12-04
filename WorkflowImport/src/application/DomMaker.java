package application;
import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;

import javafx.stage.FileChooser;

public class DomMaker {
	public static void main(String[] args) {

	}
	
	public static void childrenParse(String fileName){
		  SAXBuilder builder = new SAXBuilder();
		  File file = new File(fileName);
		  try {

			Document document = (Document) builder.build(file);
		    Element rootNode = document.getRootElement();
			
		    List list = rootNode.getChildren();
			
			for(Iterator iterator = list.iterator(); iterator.hasNext();){	
				
				Element myElement = (Element) iterator.next();
				List <Element> grandchildren = myElement.getChildren();
			
				System.out.println("\n\nsubroot node : " + myElement.getName());
				for (int i = 0; i < grandchildren.size(); i++) {
					Element node = (Element) grandchildren.get(i);
					String myString = node.getName();
					System.out.println("---------------");
					System.out.println(myString);
				    if(myString.equals("UserType")){
						if(node.getChildren("id").size() != 0)	System.out.println(" id : " + node.getChildText("id"));
				    	if(node.getChildren("name").size() != 0) System.out.println("name : " + node.getChildText("name"));
				    }
				    if(myString.equals("Start") || myString.equals("State") || myString.equals("End")){
						if(node.getChildren("id").size() != 0)	System.out.println("id : " + node.getChildText("id"));
				    	if(node.getChildren("name").size() != 0) System.out.println("name : " + node.getChildText("name"));
				    	if(node.getChildren("type").size() != 0) System.out.println("type : " + node.getChildText("type"));
				    }
				    if(myString.equals("Form")){
						if(node.getChildren("id").size() != 0)	System.out.println("id : " + node.getChildText("id"));
				    	if(node.getChildren("name").size() != 0) System.out.println("name : " + node.getChildText("name"));
				    	if(node.getChildren("FormField").size() != 0) System.out.println("FormField : " + node.getChildText("FormField"));
				    }
				    if(myString.equals("FlowEvent") || myString.equals("ParallelBranch")){
						if(node.getChildren("id").size() != 0)	System.out.println("id : " + node.getChildText("id"));
				    	if(node.getChildren("origin").size() != 0) System.out.println("origin : " + node.getChildText("origin"));
				    	if(node.getChildren("dest").size() != 0) System.out.println("dest : " + node.getChildText("dest"));
				    	if(node.getChildren("dest1").size() != 0) System.out.println("dest1 : " + node.getChildText("dest1"));
				    	if(node.getChildren("dest2").size() != 0) System.out.println("dest2 : " + node.getChildText("dest2"));
				    	if(node.getChildren("form").size() != 0) System.out.println("form : " + node.getChildText("form"));
				    	if(node.getChildren("form1").size() != 0) System.out.println("form1 : " + node.getChildText("form1"));
				    	if(node.getChildren("form2").size() != 0) System.out.println("form2 : " + node.getChildText("form2"));
				    }
				   
				}
		    }
		  
			//Here is where you should call checks
			CheckLogic.allChecks(rootNode);	
				
			
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
	}
}
