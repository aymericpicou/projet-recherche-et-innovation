import javax.swing.JFrame; 
public class fen extends JFrame {
	private static final long serialVersionUID = 7526472295622776147L;
	mypanel pan = new mypanel();   
	public static void main(String[] args)throws Exception{
		new fen();//initialisation de la fenetre -> Jpanel -> parse -> les articles
		}
	
	
	  public  fen() throws Exception {
		  this.setTitle("NY times RSS reader");
		    this.setSize(1000, 420);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		    this.setContentPane(pan); 
		    this.setVisible(true);
		  }  

}
