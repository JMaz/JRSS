package project4;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import lists.LinkedUnorderedList;



/**
 * <p>Title: Project 4- Project4App</p>
 *
 * <p>Description: Project4App class - pulls a feed the web,
 * converts the xml data to a string, separates key fields and stores
 * them in objects, puts the objects in an undorderedList, instantiates
 * a gui object 
 *
 * @author Jan Masztal
 */
public class Project4App{
	public static void main(String[] args) throws Exception{
		
		LinkedUnorderedList<Item> myList = new LinkedUnorderedList<Item>();
		
		//pulling feed from web and storing it in a string
		URL feed = new URL("http://feeds.nytimes.com/nyt/rss/Technology");
		Scanner inputFeed = new Scanner(new InputStreamReader(feed.openStream()));
		String inputLine = "";

		while (inputFeed.hasNext())
		{
			inputLine = inputFeed.nextLine();
		}//end while
		inputFeed.close();

		
		//Cutting out the excess information
		//at the beginning of the string
		int start;
		start = inputLine.indexOf("rel=\"standout\" />");
		inputLine = inputLine.substring(start);

		
		//pulling important fields, creating an Item object
		//and storing the items in an LinkedUnordereList
		Scanner inputString = new Scanner(inputLine);
	
		while(inputString.hasNext()){
			String title = null;
			String link = null;
			String description = null;

			int startTitle;
			int endTitle;
			int startLink;
			int endLink;
			int startDescription;
			int cutDescription;
			int endDescription = 0;

			Item newItem = null;

			if(inputLine.indexOf("<title>")!= -1){
				startTitle = inputLine.indexOf("<title>");
				endTitle = inputLine.indexOf("</title>");
				title = inputLine.substring(startTitle+7,endTitle);

				startLink = inputLine.indexOf("<link>");
				endLink = inputLine.indexOf("</link>");
				link = inputLine.substring(startLink+6,endLink-24);

				startDescription = inputLine.indexOf("<description>");
				cutDescription = inputLine.indexOf("&lt");
				endDescription = inputLine.indexOf("</description>");
				description = inputLine.substring(startDescription+13,cutDescription);
				newItem = new Item(title,link,description);
				inputLine = inputLine.substring(endDescription+13);
			}else
				break;
			myList.addToRear(newItem);			
		}//end while
		inputString.close();
	
		
		//instantiates new gui 
		Main see = new Main(myList);


	}//end main
}//end class
