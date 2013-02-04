import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mypanel extends JPanel{
	private static final long serialVersionUID = 7526472295622776146L;
	int numart;
	
	parse par=new parse();
	article[] art=par.getLinks("http://www.nytimes.com/services/xml/rss/nyt/GlobalHome.xml");//parse du flux du NY times
	
	
	private JLabel l1=new JLabel();
	private JLabel l2=new JLabel();
	private JLabel l3=new JLabel();//déclaration des composants
	private JLabel l4=new JLabel();
	private JLabel l5=new JLabel();
	private JLabel l6=new JLabel();
	private JLabel l7=new JLabel();
	private JLabel l8=new JLabel();
	private JLabel l9=new JLabel();
	private JButton bq=new JButton("quitter");//bouton quitter
	private JPanel p2=new JPanel();
	private JPanel p3=new JPanel();
	private JButton blink=new JButton();//bouton afficher l'article
	
	
	public mypanel() throws Exception{
		numart=1;
		this.initlistener();
	}
	public article[] getart()
	{
		return this.art;
	}
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
	    JButton b=new JButton("precedent");
	    JButton b2=new JButton("suivant");
	    try {
	        Image img = ImageIO.read(new File(".\\src\\index.jpg"));
	       
	        g.drawImage(img, 0, 0, this);//mettre l'image de fond
	      } catch (IOException e) {
	        e.printStackTrace();
	      } 
	    
	    this.updatepanel();//actualiser la partie dynamique dès la premiere execution
	    
	    b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });
	    b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
	    
	    
	    JPanel p1=new JPanel();
	    p1.setOpaque(false);
	    p1.setLayout(new BorderLayout());
	    p1.add(b,BorderLayout.WEST);
	    p1.add(b2,BorderLayout.EAST);
	    
	    
	    
	    this.setLayout(new BorderLayout());
	    this.add(p1,BorderLayout.NORTH);
	    this.add(p2,BorderLayout.SOUTH);
	    
	    
	  } 
	private void initlistener()//initialise les action listener des boutons en bas de la page
	{
blink.addActionListener (new java.awt.event.ActionListener() {
	    	
            public void actionPerformed(java.awt.event.ActionEvent evt){
            	try{
                blinkActionPerformed(evt);
            	}
            	catch(Exception e){
            		e.printStackTrace();
            	}
            }
        });
	   
	    bq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bqActionPerformed(evt);
            }
        });
	}
private void bActionPerformed(java.awt.event.ActionEvent evt) {  //actions à effectuer en cas d'évenement.
    	
    	if(numart>1){
    		numart--;
    		this.updatepanel();//afficher l'article d'avant
    	}
    	
    }
private void b2ActionPerformed(java.awt.event.ActionEvent evt) {  
	
	if(numart<(art.length-2)){
		numart++;
		this.updatepanel();//afficher l'article d'après

	}

}
private void blinkActionPerformed(java.awt.event.ActionEvent evt)throws Exception {  
	Desktop desktop = null;
	java.net.URI url;
	try {
	url = new java.net.URI(art[numart].getlink());
	if (Desktop.isDesktopSupported())
	{
	desktop = Desktop.getDesktop();
	desktop.browse(url);//lien vers l'article avec le navigateur par défaut
	}
	}
	catch (Exception ex) {
	
	} 
}
private void bqActionPerformed(java.awt.event.ActionEvent evt) {  
	System.exit(0);//quitter
}
private void updatepanel()//met à jour la partie dynamique de la page
{
	p2.setOpaque(false);
	p2.setBackground(Color.WHITE);
	p3.setOpaque(false);
	p3.setBackground(Color.WHITE);
	l1.setText("titre du channel :");

	l2.setText(art[0].gettitre());
	
	l3.setText("Titre de l'article n°" + numart + " :");
	l4.setText(art[numart].gettitre());
	
	l5.setText("date de publication :");
	l6.setText(art[numart].getdate());
	
	l7.setText("description :");
	l8.setText(art[numart].getdescription());
	l9.setText(" ");
	blink.setText(" lien vers l'article ");
	
    p3.setLayout(new GridLayout(1, 2));
    p3.add(blink);
    p3.add(bq);
	
    p2.setLayout(new GridLayout(11, 1));
    p2.add(l1);
    p2.add(l2);
    p2.add(l3);
    p2.add(l4);
    p2.add(l5);
    p2.add(l6);
    p2.add(l7);
    p2.add(l8);
    p2.add(l9);
    p2.add(l9);
    p2.add(p3);

	}

}
