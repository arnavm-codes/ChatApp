package chatting.application;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

/***************************************************************************************************************************/

public class Client implements ActionListener
{
    // global declarations
    JTextField text;
    static JPanel panel2;
    static Box vertical = Box.createVerticalBox();
    static DataOutputStream d_out;
    static JFrame frame= new JFrame();

    //constructor
    Client()
    {
        frame.setLayout(null);

        // green panel at top
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(7,94,84));
        panel_1.setBounds(0,0,450,70);
        frame.add(panel_1);

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

        JLabel name = new JLabel("Ranvijay");
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
        panel2 = new JPanel();
        panel2.setBounds(5, 75, 440, 570);
        frame.add(panel2);

/***************************************************************************************************************************/
        // text box for writing
        text = new JTextField();
        text.setBounds(5,655,310,40);
        text.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        frame.add(text);

        //send button
        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        send.addActionListener(this);
        frame.add(send);


/***************************************************************************************************************************/

        // frame (window)
        frame.setSize(450, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(800,50);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.WHITE);

        frame.setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String out = text.getText();
        
        JPanel p2 = formatLabel(out);

        panel2.setLayout(new BorderLayout());

        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));

        panel2.add(vertical, BorderLayout.PAGE_START);


        text.setText("");

        frame.repaint();
        frame.invalidate();
        frame.validate();
    }

    public static JPanel formatLabel(String out)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out+ "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37,211,102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));
        
        panel.add(output);

        Calendar calender = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(calender.getTime()));

        panel.add(time);

        return panel;
    }

    public static void main(String[] arg)
    {
        new Client();

        try
        {
            Socket socket = new Socket("127.0.0.1", 6001);

            DataInputStream d_in = new DataInputStream(socket.getInputStream());
            d_out = new DataOutputStream(socket.getOutputStream());

            while(true)
                {
                    panel2.setLayout(new BorderLayout());
                    String message = d_in.readUTF();
                    JPanel panel = formatLabel(message);

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    frame.validate();
                }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

