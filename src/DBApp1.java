
//Test
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class DBApp1 {


    static String printSimpleDateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();
        System.out.println(formatter.format(currentTime));
        return formatter.format(currentTime);// 2012.04.14 - 21:34:07
    }

    public static void main(String[] args) throws Exception {

        GregorianCalendar now = new GregorianCalendar();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG);
        String tagValue2 = "2024-09-25 10:00:00.000000000";

        tagValue2 = String.valueOf(Timestamp.valueOf( tagValue2));
        tagValue2 = printSimpleDateFormat();



        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/HausHalt", "x810we", "soswind22");

        String insertQuery = "INSERT INTO Medien (idMedien,Datum,ZStand) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
            pstmt.setInt(1, 1);
            pstmt.setTimestamp(2, Timestamp.valueOf(tagValue2));
            pstmt.setInt(3, 50000);
            pstmt.executeUpdate();
        }

    }


}



