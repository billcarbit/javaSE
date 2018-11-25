package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        String[] arr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        System.out.println("今天是：" + arr[calendar.get(calendar.DAY_OF_WEEK) - 1]); //1.数组下标从0开始；2.老外的第一天是从星期日开始的

        SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
        String time3 = format3.format(Calendar.getInstance().getTime());
        calendar.getTime();
        System.out.println(time3);


        //获取默认选中的日期的年月日星期的值，并赋值

        String yearStr = calendar.get(Calendar.YEAR) + "";//获取年份
        int month = calendar.get(Calendar.MONTH) + 1;//获取月份
        String monthStr = month < 10 ? "0" + month : month + "";
        int day = calendar.get(Calendar.DATE);//获取日
        String dayStr = day < 10 ? "0" + day : day + "";
        int week = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println("yearStr=" + yearStr + ",monthStr=" + monthStr + ",dayStr=" + dayStr + ",week=" + week);


        parseDateToYearMonthDayWeek(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse("2018-11-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        System.out.println("After setting Time:  " + sdf.format(calendar.getTime()));
        int getFirstDayOfWeek = calendar.getFirstDayOfWeek();
        System.out.println("getFirstDayOfWeek=" + getFirstDayOfWeek);


        int first = calendar.getActualMinimum(calendar.DAY_OF_MONTH);    //获取本月最小天数
        int last = calendar.getActualMaximum(calendar.DAY_OF_MONTH);    //获取本月最大天数
        int getWeeksInWeekYear = calendar.getWeeksInWeekYear();
        int getWeekYear = calendar.getWeekYear();
        System.out.println("first=" + first + ",last=" + last + ",getWeeksInWeekYear=" + getWeeksInWeekYear + ",getWeekYear=" + getWeekYear);

    }

    private static void getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;//获取月份

    }


    /**
     * 解析日期，获取年月日星期
     */
    private static void parseDateToYearMonthDayWeek(Date date) {

        //获取默认选中的日期的年月日星期的值，并赋值
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(date);//设置当前日期

        String yearStr = calendar.get(Calendar.YEAR) + "";//获取年份
        int month = calendar.get(Calendar.MONTH) + 1;//获取月份
        String monthStr = month < 10 ? "0" + month : month + "";
        int day = calendar.get(Calendar.DATE);//获取日
        String dayStr = day < 10 ? "0" + day : day + "";
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        String weekStr = "";
        /*星期日:Calendar.SUNDAY=1
         *星期一:Calendar.MONDAY=2
         *星期二:Calendar.TUESDAY=3
         *星期三:Calendar.WEDNESDAY=4
         *星期四:Calendar.THURSDAY=5
         *星期五:Calendar.FRIDAY=6
         *星期六:Calendar.SATURDAY=7 */
        switch (week) {
            case 1:
                weekStr = "周日";
                break;
            case 2:
                weekStr = "周一";
                break;
            case 3:
                weekStr = "周二";
                break;
            case 4:
                weekStr = "周三";
                break;
            case 5:
                weekStr = "周四";
                break;
            case 6:
                weekStr = "周五";
                break;
            case 7:
                weekStr = "周六";
                break;
            default:
                break;
        }

        System.out.println(yearStr + "年" + monthStr + "月" + dayStr + "日" + "  " + weekStr);
    }


}
