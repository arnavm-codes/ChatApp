package chatting.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Server extends JFrame implements ActionListener
{
    Server()
    {
        setLayout(null);

        // green panel at top
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(7,94,84));
        panel_1.setBounds(0,0,450,70);
        add(panel_1);

/***************************************************************************************************************************/

    // all icons

        // back button icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5,25,25,25);
        panel_1.setLayout(null);
        panel_1.add(back);

        // closes window when back button pressed
        back.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) 
            {
                System.exit(0);
            }
        });


        // profile pic
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/noProfile1.png"));
        Image i5 = i4.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(15,1,70,70);
        panel_1.setLayout(null);
        panel_1.add(profile);


        // video icon
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300,23,30,30);
        panel_1.setLayout(null);
        panel_1.add(video);


        // phone icon
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(350,23,30,30);
        panel_1.setLayout(null);
        panel_1.add(phone);


        // 3 dots icon
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(11,22,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel dots = new JLabel(i15);
        dots.setBounds(400,23,10,25);
        panel_1.setLayout(null);
        panel_1.add(dots);

/***************************************************************************************************************************/
    // chatter name and status labels

        JLabel name = new JLabel("Manoj");
        name.setBounds(110, 16, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        panel_1.add(name);

        JLabel status = new JLabel("Active now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        panel_1.add(status);

/***************************************************************************************************************************/

        // text box panel
        JPanel panel2 = new JPanel();
        panel2.setBounds(5, 75, 440, 570);
        add(panel2);

/***************************************************************************************************************************/

        JTextField text = new JTextField();
        text.setBounds(5,655,310,40);
        add(text);



        // frame (window)
        setSize(450, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,50);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public static void main(String[] arg)
    {
        new Server();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {}
}
