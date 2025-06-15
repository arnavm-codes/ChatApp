package chatting.application;

import javax.swing.*;

public class Server extends JFrame
{
    Server()
    {
        setSize(450, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,50);
    }

    public static void main(String[] arg)
    {
        new Server();
    }
}
