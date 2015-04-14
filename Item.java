package project4;


/**
 * <p>Title: Item Class</p>
 *
 * <p>Description: An Item object will store an title,description, and link. 
 * Accessors, mutators, and a toString are defined as well as an equals 
 * method which overrides the equals method defined in the Object class.</p>
 *
 * @author Jan Masztal
 */
public class Item {

	private String title;
	private String description;
	private String link;

	/**
	 * parameterized constructor --
	 * initializes title, link, and description to the user-specified values.
	 * @param t to be stored in title
	 * @param l to be stored in link
	 * @param d to be stored in description
	 */
	public Item(String t, String l, String d)
	{
		title = t;
		link = l;
		description = d;

	}//end parameterized constructor



	/**
	 * getTitle - returns the reference stored in title
	 * @return a reference to the title stored in the item
	 */
	public String getTitle(){
		return title;
	}//end getTitle


	/**
	 * setItem - stores a new value in title
	 * @param t the string reference to be stored in the item
	 */
	public void setTitle(String t){
		title= t;
	}//end setTitle


	/**
	 * getDescription - returns the reference stored in description
	 * @return a reference to the description stored in the item
	 */
	public String getDescription(){
		return description;
	}//ends getDescription


	/**
	 * setDescription- stores a new value in description
	 * @param d the string reference to be stored in the description
	 */
	public void setDescription(String d){
		description = d;
	}//end setDescription

	/**
	 * getLink - returns the reference stored in link
	 * @return a reference to the link stored in the item
	 */
	public String getLink(){
		return link;
	}//end getLink


	/**
	 * setLink - stores a new value in link
	 * @param l the string reference to be stored in the link
	 */
	public void setLink(String l){
		link= l;
	}//end setLink




	/**
	 * equals method --
	 * determines if two Items have the same title,description,or link.
	 * @param otherItem is a reference to a Item object
	 * @return true if the otherItem is found in the calling Item
	 */
	public boolean equals(Object otherItem)
	{

		if (((Item)otherItem).title != null && this.title.toLowerCase().indexOf(((Item)otherItem).title.toLowerCase())!=-1)
			return true;
		else if(((Item)otherItem).description != null && this.description.toLowerCase().indexOf(((Item)otherItem).description.toLowerCase())!=-1)
			return true;
		else if(((Item)otherItem).link != null && this.link.toLowerCase().indexOf(((Item)otherItem).link.toLowerCase())!=-1)
			return true;
		else
			return false;
	}//end equals


	/**
	 * toString method --
	 * creates and returns a String representing the state of the Item.
	 * @return a String containing the current values of title, link, and description
	 */
	public String toString(){
		String temp ="";

		temp = "Title: "+title+ "\n"+"Description: " +description +"\n" +"link: "+link+"\n";
		return temp;

	}//end toString
}//end class