package application;

public class WorkflowManager {

	
	/**
	 *  Parse the XML file, get a Document object and create a Workflow instance from the Document
	 * @param filePath
	 * @return
	 */
	public Workflow instantiate(String filePath){
		return null;
	}
	
	
	/**
	 * 
	 * Move token to the next state(s) when a transition is made
	 * call notify to email the appropriate users
	 * @param t
	 */
	public void transition(Token t){
		return null;
	}
	
	/**
	 * 	Check if the token can be moved to the next state
	 * @param t
	 * @return
	 */
	public boolean checkTransSrc(Token t){
		return null;
	}
	
	/**
	 * Check if the destination state is ready to accept the token
	 * @param t
	 * @return
	 */
	public boolean checkTransDest(Token t){
		return null;
	}
	
	/**
	 * Invoke java method provided by wf programmer
	 * @param t
	 * @return
	 */
	public boolean invokeProgrammerMethod(Token t, String pckage, String class, String method){
		
	}
	
	/**
	 * Send an email notification to the user types specified in the XML file by the workflow programmer
	 * The notify function can extend further to create a notification system on the user interface. 
	 * This will be done as time permits.
	 * @return
	 */
	public void notifyUser(){
		return;
	}
	
	/**
	 * Terminates an ongoing workflow instance and removes all the tokens associated with that workflow instance
	 * @param workflowInstanceID
	 */
	public void endWorkflow(String workflowInstanceID){
		return;
	}

}
