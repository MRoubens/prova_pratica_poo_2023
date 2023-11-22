package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class Utils {
    
    public static void showText(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static String inputText(String title, String message){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    public static Double inputNumber(String title, String message){
        return Double.parseDouble(JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE));
    }

    public static int inputYesOrNoOtpion(String title, String message){
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
    }

    public static boolean isDefined(Object obj){
        return obj != null || obj != "";
    }

    public static String dateFormat(Date date){
        String newDate = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        newDate = simpleDateFormat.format(date);
        return newDate;
    }

    public static Date convertStringToDate(String date) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.parse(date);
    }

    public static int getYearFromDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonthFromDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }
}