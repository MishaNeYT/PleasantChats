package ru.mishaneyt.chats.utils;

public class UtilsConfig {

    public static String NOPERM;
    public static String ERROR;
    public static String RELOAD;
    public static String PLAYER;

    public static String CHAT_FORMAT;
    public static String CHAT_PERMISSION;
    public static String CHAT_NOPERM;

    public static String DONATECHAT_FORMAT;
    public static String DONATECHAT_USE;
    public static String DONATECHAT_DISABLE;
    public static String DONATECHAT_PERMISSION;
    public static String DONATECHAT_NOPERM;

    public static String ADMINCHAT_FORMAT;
    public static String ADMINCHAT_USE;
    public static String ADMINCHAT_DISABLE;
    public static String ADMINCHAT_PERMISSION;
    public static String ADMINCHAT_NOPERM;

    public static String MSG_SEND;
    public static String MSG_TO;
    public static String MSG_USE;
    public static String MSG_OFFLINE;
    public static String MSG_SENDYOU;
    public static String MSG_PERMISSION;

    public static void onConfig() {
        NOPERM = UtilsManager.getStringColor("Messages.NoPerm");
        ERROR = UtilsManager.getStringColor("Messages.Error");
        RELOAD = UtilsManager.getStringColor("Messages.Reload");
        PLAYER = UtilsManager.getStringColor("Messages.Player");

        CHAT_FORMAT = UtilsManager.getStringColor("DefaultChat.Format");
        CHAT_PERMISSION = UtilsManager.getString("Permission.DefaultChat");
        CHAT_NOPERM = UtilsManager.getStringColor("DefaultChat.NoPerm");

        DONATECHAT_FORMAT = UtilsManager.getStringColor("DonateChat.Format");
        DONATECHAT_USE = UtilsManager.getStringColor("Messages.DonateChat.Use");
        DONATECHAT_DISABLE = UtilsManager.getStringColor("DonateChat.Disable");
        DONATECHAT_PERMISSION = UtilsManager.getString("Permission.DonateChat");
        DONATECHAT_NOPERM = UtilsManager.getStringColor("Messages.DonateChat.NoPerm");

        ADMINCHAT_FORMAT = UtilsManager.getStringColor("AdminChat.Format");
        ADMINCHAT_USE = UtilsManager.getStringColor("Messages.AdminChat.Use");
        ADMINCHAT_DISABLE = UtilsManager.getStringColor("AdminChat.Disable");
        ADMINCHAT_PERMISSION = UtilsManager.getString("Permission.AdminChat");
        ADMINCHAT_NOPERM = UtilsManager.getStringColor("Messages.AdminChat.NoPerm");

        MSG_SEND = UtilsManager.getStringColor("MsgChat.Send");
        MSG_TO = UtilsManager.getStringColor("MsgChat.To");
        MSG_USE = UtilsManager.getStringColor("Messages.MsgChat.Use");
        MSG_OFFLINE = UtilsManager.getStringColor("Messages.MsgChat.Offline");
        MSG_SENDYOU = UtilsManager.getStringColor("Messages.MsgChat.SendYou");
        MSG_PERMISSION = UtilsManager.getString("Permission.MsgChat");
    }
}