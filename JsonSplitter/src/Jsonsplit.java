import org.json.simple.JSONObject;

public class Jsonsplit {
	 public int compareAddress(String unformat_address) { // using regex to compare pattern
		 
	        int flag;
	        
	        if (unformat_address.matches("([\u00e4\u00f6\u00fc\u00c4\u00d6\u00dc\u00dfa-zA-Z\\s\\d]+)[\\s]([Nn][o]?[\\.]?\\s.*)")) {
	        	
	        	flag = 1;
	        	
	        } else if(unformat_address.matches("([\u00e4\u00f6\u00fc\u00c4\u00d6\u00dc\u00dfa-zA-Z ](.*)[ ]([\\d]+)([a-zA-Z]*))")) {
	        	
	        	flag = 2;
	        	
	        } else if(unformat_address.matches("(([\\d]+)[\\s](.*))")) {
	        	
	        	flag = 3;	
	        	
	        } else if(unformat_address.matches("([\\d]+)[,]?[\\s](.*)")) {
	        	
	        	flag = 4;	
	        	
	        } else if(unformat_address.matches("[\\u00e4\\u00f6\\u00fc\\u00c4\\u00d6\\u00dc\\u00dfa-zA-Z ](.*)[ ]([\\d]+)([a-zA-Z]*)[ ]([a-zA-Z]*)")) {
	        	
	        	flag = 5;
	        	
		    } else {
		    	
	        	flag = 0;	
	        	
		    }
	        
	        return flag;
	        
	    }
	
    public JSONObject splitAddress(String unformat_address,int flag) { // splitting string by finding out suitable split according to regex
    	
    	String [] components;
    	JSONObject object_json = new JSONObject();
    	
    	if (flag==1) {
    		
    		object_json.put("housenumber", unformat_address.split("(?=([Nn][o]))")[1].trim());
    		object_json.put("street", unformat_address.split("(?=([Nn][o]))")[0].trim());
    		
    	} else if (flag==2) {
    		
    		if (unformat_address.indexOf(',')!=-1) {
    			
    		object_json.put("housenumber", unformat_address.split("([,])")[1].trim());
    		object_json.put("street", unformat_address.split("([,])")[0].trim());
    		
    		} else {
    			
        		object_json.put("housenumber", unformat_address.split(unformat_address.substring(0, unformat_address.lastIndexOf(" ")))[1].trim());
        		object_json.put("street", unformat_address.substring(0, unformat_address.lastIndexOf(" ")).trim());
        		
    		}
    	} else if (flag==3) {
    		
    		object_json.put("housenumber", unformat_address.split(" ", 2)[0].trim());
    		object_json.put("street", unformat_address.split(" ", 2)[1].trim());
    		
    	} else if (flag==4) {
    		
    		object_json.put("housenumber", unformat_address.split("([,])")[0].trim());
    		object_json.put("street", unformat_address.split("([,])")[1].trim());
    		
    	} else if (flag==5) {
    		
    		object_json.put("housenumber", unformat_address.split(" ")[unformat_address.split(" ").length-2]+" "+unformat_address.split(" ")[unformat_address.split(" ").length-1].trim());
    		object_json.put("street", unformat_address.split(unformat_address.split(" ")[unformat_address.split(" ").length-2]+" "+unformat_address.split(" ")[unformat_address.split(" ").length-1])[0].trim());
    		
    	} else {
    		
    		object_json.put("housenumber", "Not present as format of string is out of the given cases");
    		object_json.put("street", "Not present as format of string is out of the given cases");
    		
    	}
    	
    	return object_json;

    }

	public static void main(String[] args) {
		String[] s_pass = { "Winterallee 3", "Musterstrasse 45", "Blaufeldweg 123B","Am Bächle 23", "Auf der Vogelwiese 23 b", "4, rue de la revolution","200 Broadway Av", "Calle Aduana, 29","Calle 39 No 1540"  };
		Jsonsplit object_jsonsplit = new Jsonsplit();
		for(int j=0;j<s_pass.length;j++) {
			
			System.out.println(s_pass[j]);	
		    int i = object_jsonsplit.compareAddress(s_pass[j]);
		    System.out.println(object_jsonsplit.splitAddress(s_pass[j],i));
		    
		}
		
	}

}
