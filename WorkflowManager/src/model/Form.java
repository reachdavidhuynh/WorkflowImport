package model;

public class Form {

	//An actual form will just be a hashmap. This is just a wrapper class.
    //Key String is fieldname
    //Value related to key is the value user entered for that field
    HashMap<String, String> form;
    //Method to get value given key. Will just use above. 
    String getValue(String Key);
}
