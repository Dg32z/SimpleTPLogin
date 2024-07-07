package org.network.dg32z.logintp.util.color;

import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;
import org.network.dg32z.logintp.PluginLoader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@UtilityClass
public class ColorUtil {

    public String translateHexCodes(String message) { //from https://github.com/GrimAnticheat/Grim/blob/2.0/src/main/java/ac/grim/grimac/utils/anticheat/MessageUtil.java
        final String hexPattern = "#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{8})";
        Matcher matcher = Pattern.compile(hexPattern).matcher(message);
        StringBuffer sb = new StringBuffer(message.length());
        while (matcher.find()) {
            String hex = matcher.group(1);
            ChatColor color = ChatColor.of("#" + hex);
            matcher.appendReplacement(sb, color.toString());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String colorMessage(String Message) {
        if (PluginLoader.INSTANCE.getServerUtil().is1_16orAbove()) {
            Message = translateHexCodes(Message);
        }
        return ChatColor.translateAlternateColorCodes('&', Message);
    }
}
