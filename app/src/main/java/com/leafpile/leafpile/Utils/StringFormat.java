package com.leafpile.leafpile.Utils;

import java.util.Calendar;

/**
 * Created by sake on 19/11/17.
 */

public class StringFormat {
    public static String price(int price) {
        return "Rp. " + price + ",-";
    }
    public static String qty(double qty) {
        return "Kuantitas: " + qty;
    }
    public static String date(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR);
    }
    public static String transactionDate(Calendar calendar) {
        return "Tanggal Transaksi: " + date(calendar);
    }
}
