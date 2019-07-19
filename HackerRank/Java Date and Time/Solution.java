
import java.util.Scanner;
import java.util.Calendar;

public class Solution{

    public static String getDay(String day, String month, String year){
        Calendar rightNow = Calendar.getInstance();
        rightNow.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
        int intDay  = rightNow.get(Calendar.DAY_OF_WEEK)-1;
        String strDay = "";
        switch (intDay){
            case 0:
                strDay = "SUNDAY";
                break;
            case 1:
                strDay = "MONDAY";
                break;
            case 2:
                strDay = "TUESDAY";
                break;
            case 3:
                strDay = "WEDNESDAY";
                break;
            case 4:
                strDay = "THURSDAY";
                break;
            case 5:
                strDay = "FRIDAY";
                break;
            case 6:
                strDay = "SATURDAY";
                break;
            default:
                strDay = "SUNDAY";
                break;
        }

        if(Integer.parseInt(year) > 2000 && Integer.parseInt(year) < 3000)
            return strDay;
        else
            return "";
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }
}
