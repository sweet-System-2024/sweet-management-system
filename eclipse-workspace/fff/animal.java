package fff;
mport java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.file.Files;

public class ManchesterEncoding extends JComponent implements ActionListener {
    private String data = "";
    private int graphWidth;

    private JLabel binaryLabel, dataLabel;
    private JButton btnFile, btnBinary;
    private JTextField txtBinary;
    private JScrollPane graphScroll, dataScroll;
    private JPanel userInput1, userInput2, userTotal, userData, graphPanel;
    private JFrame mainFrame;

    private Font font = new Font("Segoe UI", Font.PLAIN, 12);
    private Font font2 = new Font("Segoe UI", Font.BOLD, 18);

    ManchesterEncoding() {
        // Set "Windows" Look and Feel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }

        btnFile = new JButton("Read Data From File and Generate a Manchester Encoded Signal");
        btnFile.setFont(font);
        btnFile.addActionListener(this);

        userInput1 = new JPanel();
        userInput1.setFont(font);
        userInput1.setLayout(new GridBagLayout());
        userInput1.add(btnFile);

        binaryLabel = new JLabel("Enter Binary Data");
        binaryLabel.setFont(font);

        txtBinary = new JTextField();
        txtBinary.setFont(font);
        txtBinary.setColumns(15);

        btnBinary = new JButton("Generate a Manchester Encoded Signal");
        btnBinary.setFont(font);
        btnBinary.addActionListener(this);

        JPanel extra = new JPanel();
        extra.setLayout(new FlowLayout());
        extra.setFont(font);
        extra.add(binaryLabel);
        extra.add(new JSeparator());
        extra.add(txtBinary);
        extra.add(new JSeparator());
        extra.add(btnBinary);

        userInput2 = new JPanel();
        userInput2.setLayout(new GridLayout(3, 1));
        userInput2.setFont(font);
        userInput2.add(new JSeparator());
        userInput2.add(extra);

        userTotal = new JPanel();
        userTotal.setLayout(new GridLayout(2, 1));
        userTotal.setFont(font);
        userTotal.add(userInput1);
        userTotal.add(userInput2);

        dataLabel = new JLabel();
        dataLabel.setFont(font2);
        dataLabel.setForeground(Color.blue);

        userData = new JPanel();
        userData.setFont(font);
        userData.setLayout(new FlowLayout());

        dataScroll = new JScrollPane(userData);
        dataScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        dataScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        graphPanel = new JPanel();
        graphPanel.setLayout(new BorderLayout());

        mainFrame = new JFrame("Manchester Encoding");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout((new GridLayout(3, 1)));
        mainFrame.add(userTotal);
        mainFrame.add(dataScroll);
        mainFrame.setSize(1200, 800);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public void getStringData() {
        JFileChooser choice = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Documents (*.txt)", "txt");
        choice.setFileFilter(filter);
        choice.setDialogTitle("Select a file to send");
        int option = choice.showOpenDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = choice.getSelectedFile();
            byte[] fileData;
            try {
                fileData = Files.readAllBytes(file.toPath());
                FileInputStream in = new FileInputStream(file);
                in.read(fileData);
                in.close();
            }

            catch (IOException e) {
                JOptionPane.showMessageDialog(this, "File Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            dataLabel.setText("<html><br><br>Data From File: <br>");

            data = "";
            for (byte b : fileData) {
                dataLabel.setText(dataLabel.getText() + (char) b);
                data += getBits(b);
            }

            dataLabel.setText(dataLabel.getText() + "<br><br>Data in Binary:<br>" + data + "</html>");

            addArea();
            userData.add(dataLabel);
            addArea();
            drawGraph();
        }
    }

    public String getBits(byte b) {
        String result = "";
        for (int i = 0; i < 8; i++)
            result += (b & (1 << i)) == 0 ? "0" : "1";

        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFile) {
            if (graphPanel.isShowing())
                removeGraph();

            getStringData();
        }

        else if (e.getSource() == btnBinary) {
            if (graphPanel.isShowing())
                removeGraph();

            if (txtBinary.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Empty Fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            data = "";
            for (int i = 0; i < txtBinary.getText().length(); i++) {
                if (txtBinary.getText().charAt(i) != '0' && txtBinary.getText().charAt(i) != '1') {
                    JOptionPane.showMessageDialog(this, "Invalid Binary Data!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                else
                    data += txtBinary.getText().charAt(i) - 48;
            }

            dataLabel.setText("<html><br><br><br>Data in Binary:<br>" + data + "</html>");
            addArea();
            userData.add(dataLabel);
            addArea();
            drawGraph();
        }

    }

    public void addArea() {
        JTextArea area1 = new JTextArea();
        area1.setBackground(new Color(0xF0F0F0));
        area1.setEditable(false);
        JTextArea area2 = new JTextArea();
        area2.setBackground(new Color(0xF0F0F0));
        area2.setEditable(false);
        JTextArea area3 = new JTextArea();
        area3.setBackground(new Color(0xF0F0F0));
        area3.setEditable(false);
        JTextArea area4 = new JTextArea();
        area4.setBackground(new Color(0xF0F0F0));
        area4.setEditable(false);
        userData.add(area1);
        userData.add(area2);
        userData.add(area3);
        userData.add(area4);
    }

    public void removeGraph() {
        userData.removeAll();
        mainFrame.remove(userData);
        mainFrame.remove(graphPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void drawGraph() {
        graphWidth = (data.length() * 80);

        graphScroll = new JScrollPane(new GetGraph());
        graphScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        graphScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        graphPanel = new JPanel();
        graphPanel.setLayout(new BorderLayout());
        graphPanel.add(graphScroll, BorderLayout.CENTER);
        
        mainFrame.add(graphPanel);
        mainFrame.revalidate();
        mainFrame.repaint();

    }

    public class GetGraph extends JPanel {

        GetGraph() {
            this.setPreferredSize(new Dimension(graphWidth, 300));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setFont(new Font("Segoe UI", Font.BOLD, 20));
            g.drawString("Manchester Encoded Signal:", 10, 30);

            int period = 80;            
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == '1') {
                    g.setColor(Color.blue);
                    g.drawString(data.charAt(i) + "", i * period + 35, 80);
                    g.drawLine(i * period, 200, i * period + 40, 200);
                    g.drawLine(i * period + 40, 200, i * period + 40, 120);
                    g.drawLine(i * period + 40, 120, i * period + 80, 120);
                }

                else if (data.charAt(i) == '0') {
                    g.setColor(Color.red);
                    g.drawString(data.charAt(i) + "", i * period + 35, 80);
                    g.drawLine(i * period, 120, i * period + 40, 120);
                    g.drawLine(i * period + 40, 120, i * period + 40, 200);
                    g.drawLine(i * period + 40, 200, i * period + 80, 200);
                }

                g.setColor(Color.black);
                if (i + 1 < data.length())
                    if (data.charAt(i) == data.charAt(i + 1))
                        g.drawLine(i * period + 80, 200, i * period + 80, 120);
                        
                g.drawLine(0, 160, graphWidth, 160);
            }
        }
    }

   
}
java.io}