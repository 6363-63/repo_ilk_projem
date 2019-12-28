
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class TextFieldExample implements ActionListener {


    JTextField tf1,tf2,tf3;
    JButton b1,b2;

    TextFieldExample(){
        JFrame frm= new JFrame();
        JPanel f = new JPanel();
        tf1=new JTextField("Ogrencinin adi ");
        tf1.setBounds(50,50,150,20);
        tf2=new JTextField("Ogrencinin Yaşı");
        tf2.setBounds(100,150,150,20);
        tf3=new JTextField("Sonuc : ");
        tf3.setBounds(150,50,150,20);
        tf3.setEditable(false);
        b1=new JButton("Ekle");
        b1.setBounds(50,200,100,50);

        b1.addActionListener(this);
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(b1);
        f.setSize(300,300);
        f.setVisible(true);
        frm.add(f);
        frm.setSize(400,400);
        frm.setLayout(null);
        frm.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s1=tf1.getText();
        String s2=tf2.getText();


        Ogrenci o = new Ogrenci(Integer.parseInt(s2),s1,155);
        System.out.println(Kisi.Kisiler.get(0).toString());
        System.out.println(s1+s2);




        tf3.setText("Eklendi..");
    }
    public static void main(String[] args) {
        new TextFieldExample();
    }
}