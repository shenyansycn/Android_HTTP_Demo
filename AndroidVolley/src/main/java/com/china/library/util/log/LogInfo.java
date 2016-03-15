//package com.china.library.util.log;
//
//import android.util.Log;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//import com.google.gson.JsonSyntaxException;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
///**
// * 日志类
// *
// * @author shenyan
// */
//public class LogInfo {
//    private static final String TAG = "TAG";
//    private static final String DEBUGINFO = "DebugInfo : ";
//    public static boolean ENABLE_DEBUG = false;
//    private static int maxLogSize = 1000;
//
//    public static void out(String Tag, Object object) {
//        if (ENABLE_DEBUG) {
//            String text = object.toString();
//            for (int i = 0; i <= text.length() / maxLogSize; i++) {
//                int start = i * maxLogSize;
//                int end = (i + 1) * maxLogSize;
//                end = end > text.length() ? text.length() : end;
//                Log.i(Tag, DEBUGINFO + Tag + " " + text.substring(start, end));
//            }
//        }
//    }
//
//    public static void outEmptyLine() {
//        if (ENABLE_DEBUG) {
//            Log.i("", "");
//        }
//    }
//
//    public static void outJson(Object object) {
//        if (ENABLE_DEBUG) {
//            try {
//                Gson gson = new GsonBuilder().setPrettyPrinting().create();
//                JsonParser jp = new JsonParser();
//                JsonElement je = jp.parse(object.toString());
//                String prettyJsonString = gson.toJson(je);
//                out(prettyJsonString);
//            } catch (JsonSyntaxException e) {
//                LogInfo.printException(e);
//                out("json string = " + object.toString());
//            }
//        }
//    }
//
//    /**
//     * 打印调试信息
//     *
//     * @param object 调试信息内容
//     */
//    public static void out(Object object) {
//        if (ENABLE_DEBUG) {
//            String text = object.toString();
//            for (int i = 0; i <= text.length() / maxLogSize; i++) {
//                int start = i * maxLogSize;
//                int end = (i + 1) * maxLogSize;
//                end = end > text.length() ? text.length() : end;
//                Log.i(TAG, DEBUGINFO + text.substring(start, end));
//            }
//        }
//    }
//
//    public static void printException(Exception e) {
//        if (ENABLE_DEBUG) {
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            PrintStream stream = new PrintStream(baos);
//            e.printStackTrace(stream);
//            stream.flush();
//            LogInfo.out("net error = " + new String(baos.toByteArray()));
//        }
//    }
//}
