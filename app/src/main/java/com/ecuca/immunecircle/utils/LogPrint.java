package com.ecuca.immunecircle.utils;

import android.util.Log;

/**
 * Created by tangli on 2016/2/23.
 * <p/>
 * 日志输出级别控制工具类
 */
public class LogPrint {


    /**
     * 日志输出级别NONE
     */
    public static final int LEVEL_NONE = 0;
    /**
     * 日志输出级别V
     */
    public static final int LEVEL_VERBOSE = 1;
    /**
     * 日志输出级别D
     */
    public static final int LEVEL_DEBUG = 2;
    /**
     * 日志输出级别I
     */
    public static final int LEVEL_INFO = 3;
    /**
     * 日志输出级别W
     */
    public static final int LEVEL_WARN = 4;
    /**
     * 日志输出级别E
     */
    public static final int LEVEL_ERROR = 5;

    /**
     * 日志输出时的TAG
     */
    public  static String mTag = "immune_circle";

    /**
     * 限定log最大长度
     */
    private static int LOG_MAXLENGTH = 2000;

    /**
     * The constant mDebuggable.
     */
/*
        是否允许输出log
        用于控制日志输出的级别！
        通常，程序项目完成时，可通过设置该等级，用于控制日志是否还要再输出。。。

        设置为LEVEL_NONE，表示不输出任何日志
        设置为LEVEL_ERROR，表示输出全部日志
    */
    public static int mDebuggable = LEVEL_ERROR;


    /**
     * 以级别为 d 的形式输出LOG
     *
     * @param msg the msg
     */
    public static void v(String msg) {
        if (mDebuggable >= LEVEL_VERBOSE) {
            Log.v(mTag, msg);
        }
    }

    /**
     * 以级别为 d 的形式输出LOG
     *
     * @param msg the msg
     */
    public static void d(String msg) {

        if (mDebuggable >= LEVEL_DEBUG) {

            Log.d(mTag, msg);

        }

    }


    /**
     * 以级别为 i 的形式输出LOG
     *
     * @param msg the msg
     */
    public static void i(String msg) {

        if (mDebuggable >= LEVEL_INFO) {

            Log.i(mTag, msg);

        }

    }


    /**
     * 以级别为 w 的形式输出LOG
     *
     * @param msg the msg
     */
    public static void w(String msg) {

        if (mDebuggable >= LEVEL_WARN) {

            Log.w(mTag, msg);

        }

    }


    /**
     * 以级别为 w 的形式输出Throwable
     *
     * @param tr the tr
     */
    public static void w(Throwable tr) {

        if (mDebuggable >= LEVEL_WARN) {

            Log.w(mTag, "", tr);

        }

    }


    /**
     * 以级别为 w 的形式输出LOG信息和Throwable
     *
     * @param msg the msg
     * @param tr  the tr
     */
    public static void w(String msg, Throwable tr) {

        if (mDebuggable >= LEVEL_WARN && null != msg) {

            Log.w(mTag, msg, tr);

        }

    }


    /**
     * 以级别为 e 的形式输出LOG
     *
     * @param msg the msg
     */
    public static void e(String msg) {

        if (mDebuggable >= LEVEL_ERROR) {

            Log.e(mTag, msg);

        }

    }


    /**
     * 以级别为 e 的形式输出Throwable
     *
     * @param tr the tr
     */
    public static void e(Throwable tr) {

        if (mDebuggable >= LEVEL_ERROR) {

            Log.e(mTag, "", tr);

        }

    }


    /**
     * 以级别为 e 的形式输出LOG信息和Throwable
     *
     * @param msg the msg
     * @param tr  the tr
     */
    public static void e(String msg, Throwable tr) {

        if (mDebuggable >= LEVEL_ERROR && null != msg) {

            Log.e(mTag, msg, tr);

        }

    }


    /**
     * 分段输出长数据
     *
     * @param msg the msg
     */
    public static void allData_D_Mode(String msg) {
        if (mDebuggable >= LEVEL_DEBUG) {
            int strLength = msg.length();
            int start = 0;
            int end = LOG_MAXLENGTH;
            Log.d(mTag, "<--------");
            for (int i = 0; i < 100; i++) {
                if (strLength > end) {
                    Log.d(mTag, msg.substring(start, end));
                    start = end;
                    end = end + LOG_MAXLENGTH;
                } else {
                    Log.d(mTag, msg.substring(start, strLength));
                    break;
                }
            }
            Log.d(mTag, "-------->");
        }
    }


}



