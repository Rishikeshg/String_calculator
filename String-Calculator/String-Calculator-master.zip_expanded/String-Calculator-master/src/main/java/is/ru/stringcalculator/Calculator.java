package is.ru.stringcalculator;


/*
Main calss

Calculator....
*/

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else{
			String delimiter = ",";
			if(text.matches("//(.*)\n(.*)")){
				delimiter = Character.toString(text.charAt(2));
				text = text.substring(4);
			}
			
			String numList[] = splitNumbers(text, delimiter + "|\n");
			return sum(numList); 
		}
	}

// This function will calculate the sum of all numbers.

	private static int sum(String[] numbers){
 	    int total = 0;
 	    String negString = "";

        for(String number : numbers){
        	if(toInteger(number) < 0){
        		if(negString.equals(""))
        			negString = number;
        		else
        			negString += ("," + number);
        	}
        	if(toInteger(number) < 1000)
		    	total += toInteger(number);
		}
		
		
//  if values are negative this function will return Exception 
		if(!negString.equals("")){
			throw new IllegalArgumentException("Negatives not allowed: " + negString);
		}

		return total;
    }


//This function will convert String into Integer
	private static int toInteger(String number){
		return Integer.parseInt(number);
	}

//This function will split the String based on divider(splitter type)
	private static String[] splitNumbers(String numbers, String divider){
	    return numbers.split(divider);
	}
	
	}