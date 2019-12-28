import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MyPanel extends JPanel implements ActionListener {
    JButton button = new JButton("Button");
    JTabbedPane tabPane = new JTabbedPane();

    public MyPanel(){
        JTextField tf1,tf2,tf3;
        JButton b1,b2;
        JPanel panel1 = new JPanel();
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
        panel1.add(tf1);panel1.add(tf2);panel1.add(tf3);panel1.add(b1);
        panel1.setSize(300,300);
        panel1.setVisible(true);
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        tabPane.add("Ogrenci Ekle", panel1);
        tabPane.add("Hoca Ekle", panel2);
        tabPane.add("Ders Ekle", panel3);

        tabPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        setLayout(new BorderLayout());
        add(tabPane, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

    }
    @Override
    public void actionPerformed(ActionEvent e){


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new MyPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.setSize(300, 300);
                frame.setVisible(true);
            }
        });
    }


}