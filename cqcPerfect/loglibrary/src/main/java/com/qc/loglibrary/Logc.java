package com.qc.loglibrary;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * PackageName: com.qc.loglibrary
 * ClassName: Logc
 * Author: cuiqingchao
 * CreateDate: 2018/6/7 19:05
 * Description:
 *
 * -----------------------------------Version Info----------------------------------------------
 * Version: V0.1    UpdateUser: cuiqingchao    UpdateDate: 2018/6/7 19:05   UpdateRemark:
 *
 *
 * ---------------------------------------------------------------------------------------------
 */
public class Logc {
    private static boolean isDebug = true;
    private static String TAG = "cuiqingchao";
    private static final int JSON_INDENT = 2;


    public static void init(boolean debug, String tag) {
        Logc.isDebug = debug;
        Logc.TAG = tag;
    }

    public static void e(String msg, Object... params) {
        e(null, msg, params);
    }

    public static void e(String tag, String msg, Object[] params) {
        if (!isDebug) return;
        LogText.e(getFinalTag(tag), String.format(msg, params));
    }

    public static void d(String msg, Object... params) {
        d(null, msg, params);
    }

    public static void d(String tag, String msg, Object[] params) {
        if (!isDebug) return;
        LogText.d(getFinalTag(tag), String.format(msg, params));
    }


    public static void jsonD(String json) {
        jsonD(null, json);
    }

    public static void jsonD(String tag, String json) {
        if (!isDebug) return;
        LogText.d(getFinalTag(tag), getPrettyJson(json));
    }

    public static void jsonE(String json) {
        jsonE(null, json);
    }

    public static void jsonE(String tag, String json) {
        if (!isDebug) return;
        LogText.e(getFinalTag(tag), getPrettyJson(json));
    }

    private static String getPrettyJson(String jsonStr) {
        try {
            jsonStr = jsonStr.trim();
            if (jsonStr.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(jsonStr);
                return jsonObject.toString(JSON_INDENT);
            }
            if (jsonStr.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(jsonStr);
                return jsonArray.toString(JSON_INDENT);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Invalid Json, Please Check: " + jsonStr;
    }


    private static String getFinalTag(String tag) {
        if (!TextUtils.isEmpty(tag)) {
            return tag;
        }
        return TAG;
    }

    private static class LogText {
        private static final String DOUBLE_DIVIDER = "════════════════════════════════════════════\n";
        private static final String SINGLE_DIVIDER = "────────────────────────────────────────────\n";

        private String mTag;

        public LogText(String tag) {
            mTag = tag;
        }


        public static void e(String tag, String content) {
            LogText logText = new LogText(tag);
            logText.setup(content);
        }

        public static void d(String tag, String content) {
            LogText logText = new LogText(tag);
            logText.setup(content);
        }

        public void setup(String content) {
            setUpHeader();
            setUpContent(content);
            setUpFooter();

        }

        private void setUpHeader() {
            Log.e(mTag, SINGLE_DIVIDER);
        }

        private void setUpFooter() {
            Log.e(mTag, DOUBLE_DIVIDER);
        }

        public void setUpContent(String content) {
            StackTraceElement targetStackTraceElement = getTargetStackTraceElement();
            Log.e(mTag, "(" + targetStackTraceElement.getFileName() + ":"
                    + targetStackTraceElement.getLineNumber() + ")");
            Log.e(mTag, content);
        }

        private StackTraceElement getTargetStackTraceElement() {
            // find the target invoked method
            StackTraceElement targetStackTrace = null;
            boolean shouldTrace = false;
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                boolean isLogMethod = stackTraceElement.getClassName().equals(Logc.class.getName());
                if (shouldTrace && !isLogMethod) {
                    targetStackTrace = stackTraceElement;
                    break;
                }
                shouldTrace = isLogMethod;
            }
            return targetStackTrace;
        }
    }


}
