import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Graphics;
public class mypanel extends JPanel{
	
	int numart;
	
	parse par=new parse();
	article[] art=par.getLinks("xjzijao");
	
	
	private JLabel l1=new JLabel();
	private JLabel l2=new JLabel();
	private JLabel l3=new JLabel();
	private JLabel l4=new JLabel();
	private JLabel l5=new JLabel();
	private JLabel l6=new JLabel();
	private JLabel l7=new JLabel();
	private JLabel l8=new JLabel();
	private JButton bq=new JButton("quitter");
	private JPanel p2=new JPanel();
	
	
	public mypanel() throws Exception{
		numart=1;
		
	}
	public article[] getart()
	{
		return this.art;
	}
	public void paintComponent(Graphics g){
	    JButton b=new JButton("precedent");
	    JButton b2=new JButton("suivant");
	    
	    this.updatepanel();
	    
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
	    bq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bqActionPerformed(evt);
            }
        });
	    
	    JPanel p1=new JPanel();
	    p1.setLayout(new BorderLayout());
	    p1.add(b,BorderLayout.WEST);
	    p1.add(b2,BorderLayout.EAST);
	    
	    
	    
	    this.setLayout(new BorderLayout());
	    this.add(p1,BorderLayout.NORTH);
	    this.add(p2,BorderLayout.SOUTH);
	    
	    
	  } 
private void bActionPerformed(java.awt.event.ActionEvent evt) {  
    	
    	if(numart>1){
    		numart--;
    		this.updatepanel();
    	}
    	
    }
private void b2ActionPerformed(java.awt.event.ActionEvent evt) {  
	
	if(numart<(art.length-2)){
		numart++;
		this.updatepanel();
	}
}
private void bqActionPerformed(java.awt.event.ActionEvent evt) {  
	System.exit(0);
}
private void updatepanel()
{
	l1.setText("titre du channel :");
	l2.setText(art[0].gettitre());
	l3.setText("Titre de l'article n°" + numart + " :");
	l4.setText(art[numart].gettitre());
	l5.setText("date de publication :");
	l6.setText(art[numart].getdate());
	l7.setText("description :");
	l8.setText(art[numart].getdescription());
    p2.setLayout(new GridLayout(9, 1));
    p2.add(l1);
    p2.add(l2);
    p2.add(l3);
    p2.add(l4);
    p2.add(l5);
    p2.add(l6);
    p2.add(l7);
    p2.add(l8);
    p2.add(bq);

	}
}
