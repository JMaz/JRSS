package project4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



import lists.LinkedUnorderedList;



/**
 * <p>Title: Project 4 - Main</p>
 *
 * <p>Description: Main class - displays the graphical user interface
 * of the feed reader.
 *
 * @author Jan Masztal
 */
public class Main extends JFrame implements ActionListener {


	/**
	 * Main constructor -- gets called when an object of the Main class is
	 * instantiated -- provides space for the number of feeds "objects" in the
	 * LinkedUnorderedList, displays the objects in a popup frame.
	 * @param an LinkedUnorderedList to pull objects from
	 	 */
	public Main(LinkedUnorderedList list){
		super("Masztal Feed Reader");
		
		final LinkedUnorderedList<Item> myList = new LinkedUnorderedList<Item>();
		LinkedUnorderedList<Item> myTempList= list;
		JPanel mainPanel;
		JButton button;
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(myTempList.size(), 1));



		//adds buttons to mainPanel and assigns button attributes.
		int feedCounter = 0;

		for(int i = 0; i < myTempList.size();i++)
		{
			Item buttonItem = myTempList.removeFirst();
			final Item temp = buttonItem;

			feedCounter++;
			myList.addToRear(buttonItem);
			button = new JButton(feedCounter+ ": "+buttonItem.getTitle());

			//sets up button activity
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent j) {
					JFrame popUp = new JFrame(temp.getTitle());
					popUp.setSize(1200,100);

					JPanel popUpPanel = new JPanel();
					JLabel description = new JLabel(temp.getDescription());
					JLabel link = new JLabel(temp.getLink());

					//sets up  web button activity
					JButton web = new JButton("Go to website!");
					web.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent j) {

							java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

							try {
								java.net.URI uri = new java.net.URI( temp.getLink());
								desktop.browse( uri );
							}//end try
							catch ( Exception e ) {
								System.err.println( e.getMessage() );
							}//end catch

						}//end  web actionPerformer
					});//end web actionListener

					//adds components to panel
					popUpPanel.add(description);
					popUpPanel.add(link);
					popUpPanel.add(web);
					popUp.add(popUpPanel);
					popUp.setVisible(true);
				}//end action end performer			
			});//end button actionListener

			mainPanel.add(button);
		}//end for loop



		//creates a scrollBar for program
		JScrollPane scrollBar=new JScrollPane(mainPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		add(scrollBar,BorderLayout.CENTER);



		//sets up menu for search and delete
		//sets up actions for menu options
		JMenuBar mb = new JMenuBar();
		JMenu search = new JMenu("Search");
		JMenu delete = new JMenu("Delete");

		JMenuItem title = new JMenuItem("Title");
		JMenuItem description = new JMenuItem("Description");
		JMenuItem link = new JMenuItem("Link");

		JMenuItem delete1 = new JMenuItem("Delete");


		
		//sets up title button activity
		title.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent j) {
				String title = JOptionPane.showInputDialog(null,
						"Enter Title To Search!");

				Item temp = new Item(title,null,null);
				String feedFound = myList.search(temp);

				JOptionPane.showMessageDialog(null,"Check Feed/s: "+feedFound);

			}//end actionPerformer
		});//end actionListener



		//sets up description button activity
		description.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent j) {
				String description = JOptionPane.showInputDialog(null,
						"Enter Description To Search!");

				Item temp = new Item(null,null,description);
				String feedFound = myList.search(temp);

				JOptionPane.showMessageDialog(null,"Check Feed "+feedFound);
			}//end actionPerformer
		});//end actionListener



		//sets up link button activity
		link.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent j) {
				String link = JOptionPane.showInputDialog(null,
						"Enter Complete Link To Search!");

				Item temp = new Item(null,link,null);
				String feedFound = myList.search(temp);

				JOptionPane.showMessageDialog(null,"Check Feed "+feedFound);
			}//end actionPerformer
		});//end actionListener



		//sets up delete button activity
		delete1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent j) {

				JOptionPane.showMessageDialog(null,"If you're going to delete one, why not delete them all!!!");
				deleteMethod();
			}//end actionPerformer
		});//end actionListener



		//adds components to panels and sets up 
		//sets up JFrame attributes
		mb.add(search);
		mb.add(delete);
		search.add(title);
		search.add(description);
		search.add(link);
		delete.add(delete1);
		setJMenuBar(mb);


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);	
		pack();
		setVisible(true);
	}//end main


	/**
	 * private method
	 * deleteMethod - closes the program
	 */
	public void deleteMethod() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}//end deleteMethod



	@Override
	public void actionPerformed(ActionEvent arg0) {
	}//end actionPerformer implementation
}//end class