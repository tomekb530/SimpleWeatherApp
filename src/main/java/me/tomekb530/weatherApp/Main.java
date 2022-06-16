package me.tomekb530.weatherApp;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    private JTabbedPane tabs;
    private JPanel mondayTab;
    private JPanel tuesdayTab;
    private JPanel wednesdayTab;
    private JPanel thursdayTab;
    private JPanel fridayTab;
    private JPanel sundayTab;
    private JPanel saturdayTab;
    private JPanel main;
    private JButton refreshButton;
    private JTextField locationEdit;
    private JLabel statusLabel;
    private JLabel locationLabel;

    public JPanel[] tabsArray = {mondayTab, tuesdayTab, wednesdayTab, thursdayTab, fridayTab, sundayTab, saturdayTab};
    LocationHandler locationHandler = new LocationHandler();
    WeatherHandler weatherHandler = new WeatherHandler();
    public void loadData(int index){
        statusLabel.setText("Status: Ładowanie danych...");
        int day = LocalDate.now().getDayOfWeek().getValue();
        LocalDate date = LocalDate.now().minusDays(day - index - 1);
        WeatherDayData weatherDayData;
        try {
            if (day <= index + 1) {
                weatherDayData = weatherHandler.getForecastWeather(locationEdit.getText(), date);
            } else {
                weatherDayData = weatherHandler.getHistoryWeather(locationEdit.getText(), date);
            }
            tabsArray[index].removeAll();
            tabsArray[index].setLayout(new GridBagLayout());
            //table
            String [][] data = new String[weatherDayData.hours.length][7];
            for (int i = 0; i < weatherDayData.hours.length; i++) {
                data[i][0] = weatherDayData.hours[i].date.substring(11, 16);
                data[i][1] = weatherDayData.hours[i].condition;
                data[i][2] = weatherDayData.hours[i].temp_c + "°C";
                data[i][3] = weatherDayData.hours[i].wind_kph + " km/h";
                data[i][4] = weatherDayData.hours[i].humidity + "%";
                data[i][5] = weatherDayData.hours[i].cloud + "%";
                data[i][6] = weatherDayData.hours[i].chance_of_rain + "%";
            }
            JTable table = new JTable(data, new String[]{"Godzina", "Opis", "Temperatura", "Wiatr", "Wilgotnosc", "Zachmurzenie", "Szansa na deszcz"});
            table.setEnabled(false);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(700, 400));
            tabsArray[index].add(scrollPane);
            statusLabel.setText("Status: Gotowe ("+locationEdit.getText()+")");

        } catch (IOException e1) {
            statusLabel.setText("Status: Nie udało się pobrać danych");
        }
    }
    public Main() throws IOException {


        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                loadData(tabs.getSelectedIndex());
            }
        });

        try {
            locationEdit.setText(locationHandler.getLocation());
            WeatherDayData data = weatherHandler.getCurrentWeather(locationHandler.getLocation());
        } catch (IOException e) {
            statusLabel.setText("Status: Nie udało się pobrać danych");
        }
        //get current day of the week
        int day = LocalDate.now().getDayOfWeek().getValue();
        //set tab to current day
        tabs.setSelectedIndex(day - 1);
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                loadData(tabs.getSelectedIndex());
            }
        });
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        JFrame frame = new JFrame("Pogoda");
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        try {
            frame.setContentPane(new Main().main);
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
