import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
 
public class fenetre extends JFrame {
	mypanel pan = new mypanel();   
	JButton bouton = new JButton("Mon premier bouton");
	
	public static void main(String[] args){
		fenetre fen= new fenetre();
		}
	
	
	  public fenetre(){
		    this.setTitle("Animation");
		    this.setSize(600, 300);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		   
		    

		    JPanel b3 = new JPanel();
		    //Idem pour cette ligne
		    b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
		    b3.add(new JButton("Bouton 4"));
		    b3.add(new JButton("Bouton 5"));
		    b3.add(new JButton("Bouton 6"));

		    JPanel b4 = new JPanel();
		    //On positionne maintenant ces trois lignes en colonne
		    b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
		    b4.add(b3);
		    this.getContentPane().setLayout(new BorderLayout());
		    this.getContentPane().add(b4, BorderLayout.SOUTH);
		    this.setVisible(true);
		  }  

}

