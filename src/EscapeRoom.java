import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class EscapeRoom {
    /*
       Bookshelf: The bookcase will begin to open and show a safe. Enter the code (it will be random) to open it to get the key.
       Vent: Opening the vent you will find a lever.
       Door: The key you get from the safe will enter the door, letting you escape. WIN!
       Bed: Will have to pick up bed-sheets to find a screwdriver. It will also have a code random number (5674).

     */
    static JPanel panel;
    static JLabel setting;
    static JButton start, back, bed, bookshelf, vent, door, move, grab, unscrew, pull, enter, book, safe;
    static JTextField code;

    static boolean screwdriver = false;
    static boolean lever = false;
    static int correctCode = 5754;



    public static void main(String[] args) {

        new EscapeRoom();
    }

    public EscapeRoom(){
        JFrame frame = new JFrame("Escape Room");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);

        setting = new JLabel();
        panel = new JPanel();

        start = new JButton("Start");
        back = new JButton("Go Back");
        bed = new JButton("Bed");
        move = new JButton("Move Sheets");
        grab = new JButton("Grab it");
        unscrew = new JButton("Unscrew it");
        bookshelf = new JButton("Bookshelf");
        book = new JButton("Pull book");
        enter = new JButton("Enter Code");
        vent = new JButton("Vent");
        pull = new JButton("Pull");
        door = new JButton("Door");
        safe = new JButton("Safe");






        start.addActionListener(new startListener());
        back.addActionListener(new backListener());
        bed.addActionListener(new bedListener());
        move.addActionListener(new moveListener());
        grab.addActionListener(new grabListener());
        book.addActionListener(new bookListener());
        unscrew.addActionListener(new unscrewVentListener());
        vent.addActionListener(new ventListener());
        pull.addActionListener(new pullLeverListener());
        bookshelf.addActionListener(new bookshelfListener());
        safe.addActionListener(new safeListener());

        panel.add(start);



        frame.add(panel);
        frame.setVisible(true);
    }

    private static class startListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            final String s =  ("You wake up in a room that is filled with a bed, bookshelf, vent, and a door.");
            final String html =  "<html><body style='width: %1spx'>%1s";

            Runnable r = () -> {
                        setting.setText(String.format(html, 250, s));
            };
            SwingUtilities.invokeLater(r);
            panel.remove(start);
            panel.add(setting);
            panel.add(bed);
            panel.add(bookshelf);
            panel.add(vent);
            panel.add(door);
            panel.updateUI();

        }
    }
    private static class backListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            final String s =  ("The room clears up as you still see it with a bed, bookshelf, vent, and a door.");
            final String html =  "<html><body style='width: %1spx'>%1s";

            Runnable r = () -> {
                setting.setText(String.format(html, 250, s));
            };
            SwingUtilities.invokeLater(r);
            panel.remove(back);
            panel.remove(grab);
            panel.remove(move);
            panel.remove(unscrew);
            panel.remove(book);
            panel.remove(pull);
            panel.add(setting);
            panel.add(bed);
            panel.add(bookshelf);
            panel.add(vent);
            panel.add(door);
            panel.updateUI();
        }
    }

    private static class bedListener implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            final String s = ("The bed looks recently cleaned. It glistens white and has smooth sheets, as it seems like it was also recently made up.");
            final String html =  "<html><body style='width: %1spx'>%1s";

            Runnable r = () -> {
                setting.setText(String.format(html, 250, s));
            };
            SwingUtilities.invokeLater(r);

            panel.remove(bed);
            panel.remove(bookshelf);
            panel.remove(vent);
            panel.remove(door);
            panel.add(back);
            panel.add(move);
            panel.updateUI();



        }
    }

    private static class moveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            final String s = ("You moved the bedsheets and see a code that says " + correctCode + " and a screwdriver.");
            final String html =  "<html><body style='width: %1spx'>%1s";

            Runnable r = () -> {
                setting.setText(String.format(html, 250, s));
            };
            SwingUtilities.invokeLater(r);
            panel.remove(move);
            panel.add(grab);
            panel.updateUI();


        }
    }

    private static class grabListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            final String s = ("You grabbed the screwdriver.");
            final String html =  "<html><body style='width: %1spx'>%1s";

            Runnable r = () -> {
                setting.setText(String.format(html, 250, s));
            };
            SwingUtilities.invokeLater(r);
            screwdriver = true;
            panel.remove(grab);
            panel.updateUI();
        }
    }

    private static class ventListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            final String s = ("The vent looks very old and has rusty metallic parts. You notice that it has screws that are needed to take it out.");
            final String html =  "<html><body style='width: %1spx'>%1s";

            Runnable r = () -> {
                setting.setText(String.format(html, 250, s));
            };
            SwingUtilities.invokeLater(r);
            panel.remove(bed);
            panel.remove(vent);
            panel.remove(door);
            panel.remove(bookshelf);
            panel.add(unscrew);
            panel.add(back);
            panel.updateUI();


        }
    }

    private static class unscrewVentListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(screwdriver == true){
                final String s = (" It came out! There's a lever inside.");
                final String html =  "<html><body style='width: %1spx'>%1s";

                Runnable r = () -> {
                    setting.setText(String.format(html, 250, s));
                };
                SwingUtilities.invokeLater(r);
                panel.remove(unscrew);
                panel.add(pull);
                panel.updateUI();
            }else{
                final String s = ("It wont budge.");
                final String html =  "<html><body style='width: %1spx'>%1s";

                Runnable r = () -> {
                    setting.setText(String.format(html, 250, s));
                };
                SwingUtilities.invokeLater(r);
                panel.remove(unscrew);
                panel.updateUI();
            }

        }
    }

    private static class pullLeverListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            final String s = ("You pulled it. You heard a click at the bookcase. It opened!");
            final String html =  "<html><body style='width: %1spx'>%1s";

            Runnable r = () -> {
                setting.setText(String.format(html, 250, s));
            };
            SwingUtilities.invokeLater(r);
            lever = true;
            panel.remove(pull);
            panel.updateUI();
        }
    }


    private static class bookshelfListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            final String s = ("The bookshelf has a multitude of books. Theres a certain book that catches your attention.");
            final String html =  "<html><body style='width: %1spx'>%1s";

            Runnable r = () -> {
                setting.setText(String.format(html, 250, s));
            };
            SwingUtilities.invokeLater(r);
            panel.remove(move);
            panel.remove(bed);
            panel.remove(vent);
            panel.remove(door);
            panel.remove(bookshelf);
            panel.add(book);
            panel.add(back);
            panel.updateUI();


        }
    }

    private static class bookListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(lever == true){
                final String s = ("It opened! Now there is a case with a code.");
                final String html =  "<html><body style='width: %1spx'>%1s";

                Runnable r = () -> {
                    setting.setText(String.format(html, 250, s));
                };
                SwingUtilities.invokeLater(r);
                panel.remove(book);
                panel.add(safe);
                panel.updateUI();
            }else{
                final String s = ("It didnt do anything.");
                final String html =  "<html><body style='width: %1spx'>%1s";

                Runnable r = () -> {
                    setting.setText(String.format(html, 250, s));
                };
                SwingUtilities.invokeLater(r);
                panel.remove(book);
                panel.remove(safe);
                panel.updateUI();
            }
        }
    }

    private static class safeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            final String s = ("It seems like there is a code that needs to be put in.");
            final String html =  "<html><body style='width: %1spx'>%1s";

            Runnable r = () -> {
                setting.setText(String.format(html, 250, s));
            };
            SwingUtilities.invokeLater(r);
            panel.remove(safe);
            code = new JTextField(10);
            panel.add(code);
            code.setBounds(100, 190, 150, 25);
            panel.add(enter);
        }
    }















}
