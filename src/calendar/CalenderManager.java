package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalenderManager {


    public final static int ITEM_COUNT = 7 * 5;

    public List<DayItem> mPreMonthDayList = new ArrayList();//当前日历页面中，上月日期列表
    public List<DayItem> mCurrMonthDayList = new ArrayList();//当前日历页面中，当月日期列表
    public List<DayItem> mLastMonthDayList = new ArrayList();//当前日历页面中，下月日期列表


    public List<DayItem> combineAll() {
        List list = new ArrayList();
        list.addAll(mPreMonthDayList);
        list.addAll(mCurrMonthDayList);
        list.addAll(mLastMonthDayList);
        return list;
    }

    /**
     * 获得当前年
     *
     * @return
     */
    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }


    /**
     * 获得当前月
     *
     * @return
     */
    public int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /**
     * 获得当前日
     *
     * @return
     */
    public int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DATE);
    }


    /**
     * 获取给定日期的当月最大天数
     *
     * @param date
     * @return
     */
    public int getMaxDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int max = calendar.getActualMaximum(calendar.DAY_OF_MONTH);    //获取本月最大天数
        return max;
    }


    /**
     * 根据日期获取星期
     *
     * @param date
     * @return
     */
    public String getWeekByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return new Week().getWeekName(calendar.get(calendar.DAY_OF_WEEK) - 1);
    }

    /**
     * 获得上月在本月的日历天数，从星期天开始计算，30,31,1，那么结果就是2
     *
     * @return
     */
    public int getPreMonthThisWeekDayCount(Calendar calendar, Date date) {
        Date firstDayOfMonthDate = getFirstDayOfMonth(date);
        calendar.setTime(firstDayOfMonthDate);
        return calendar.get(calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 获取一个月的第一天
     *
     * @param date
     * @return
     */
    public Date getFirstDayOfMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String dateStr = sdf.format(date);
        String firstDayOfMonth = dateStr + "-01";
        Date firstDayOfMonthDate = null;
        try {
            firstDayOfMonthDate = sdf.parse(firstDayOfMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return firstDayOfMonthDate;
    }


    public Date getLastDayOfMonth(Date date) {
        SimpleDateFormat sdfYM = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfYM.format(date);
        String lastDayOfMonth = dateStr + "-" + getMaxDayOfMonth(date);
        Date resultDate = null;
        try {
            resultDate = sdfYMD.parse(lastDayOfMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }


    /**
     * 获得上月在星期天的日期
     *
     * @param date
     * @return
     */
    public Date getPreMonthAtSundayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        Date firstDayOfMonthDate = getFirstDayOfMonth(date);
        calendar.setTime(firstDayOfMonthDate);
        int amount = calendar.get(calendar.DAY_OF_WEEK) - 1;
        calendar.add(Calendar.DATE, -amount);
        return calendar.getTime();
    }

    /**
     * 创建当月日历中，上一个月的日期
     *
     * @param date
     */
    public void createPreMonthDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getFirstDayOfMonth(date));//设置为当月第一天的日期
        int amount = calendar.get(calendar.DAY_OF_WEEK) - 1;
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        DayItem dayItem;
        for (int i = 0; i < amount; i++) {
            calendar = Calendar.getInstance();
            calendar.setTime(getFirstDayOfMonth(date));//设置为当月第一天的日期
            calendar.add(Calendar.DATE, i - amount);
            Date preMonthDate = calendar.getTime();
            String result = sdf.format(preMonthDate);
            dayItem = new DayItem();
            dayItem.setText(String.valueOf(Integer.parseInt(result)));
            mPreMonthDayList.add(dayItem);
        }
    }

    /**
     * 创建当月日历中，下一个月的日期
     *
     * @param date
     */
    public void createLastMonthDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getLastDayOfMonth(date));//设置为当月第一天的日期
        System.out.println(new Week().getSatRangeAmount(getWeekByDate(calendar.getTime())));
        int amount = new Week().getSatRangeAmount(getWeekByDate(calendar.getTime()));
        DayItem dayItem = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        for (int i = 0; i < amount; i++) {
            calendar = Calendar.getInstance();
            calendar.setTime(getLastDayOfMonth(date));//设置为当月第一天的日期
            calendar.add(Calendar.DATE, i + 1);
            Date preMonthDate = calendar.getTime();
            String result = sdf.format(preMonthDate);
            dayItem = new DayItem();
            dayItem.setText(String.valueOf(Integer.parseInt(result)));
            mLastMonthDayList.add(dayItem);
        }
    }

    public void createCurrMonthDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int amount = calendar.getActualMaximum(calendar.DAY_OF_MONTH);//获取本月最大天数
        DayItem dayItem = null;
        for (int i = 0; i < amount; i++) {
            dayItem = new DayItem();
            dayItem.setText(String.valueOf(i + 1));
            mCurrMonthDayList.add(dayItem);
        }
    }


    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse("2018-11-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CalenderManager calenderManager = new CalenderManager();
        calenderManager.createCurrMonthDate(date);
        calenderManager.createLastMonthDate(date);
        calenderManager.createPreMonthDate(date);

        List<DayItem> dayItemList = calenderManager.combineAll();
        System.out.println(dayItemList.size());
    }
}
