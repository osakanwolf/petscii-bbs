package eu.sblendorio.bbs.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.defaultString;

public class HtmlUtils {

    private static Pattern p = Pattern.compile("(?is)<pre[^>]*>(([^\n]+)\n?|\n)(.*?)</pre[^>]*>");
    private static String replacePreTags(String s) {
        Matcher m = p.matcher(s);
        while (m.find()) {
            s = m.replaceAll("<br>$1<pre>$3</pre>").replace("<pre></pre>", "<br>");
            m = p.matcher(s);
        }
        return s;
    }

    public static String htmlClean(String s) {
        final String result = replacePreTags(defaultString(s))
                .replace("&#8211;", "-")
                .replace("&#8212;", "-")
                .replace("&#8230;", "...")
                .replace("&#8220;", "\"")
                .replace("&#8221;", "\"")
                .replace("&#8216;", "'")
                .replace("&#8217;", "'")
                .replace("\r", "")
                .replace("©","(C)")
                .replace("\n", " ")
                .replaceAll("…", "...")
                .replaceAll("–", "-")
                .replaceAll("<br( [^>]*)?>", "\n")
                .replaceAll("<p( [^>]*)?>", "\n")
                .replaceAll("<div( [^>]*)?>", "\n")
                .replaceAll("<li( [^>]*)?>", "\n* ")
                .replaceAll("<h[1-6]( [^>]*)?>", "\n\n")
                .replaceAll("</h[1-6]( [^>]*)?>", "\n")
                .replaceAll("<[^>]*>", "")
                .replaceAll("([àá]|&agrave;?|&aacute;?)", "a'")
                .replaceAll("([ÀÁ]|&Agrave;?|&Aacute;?)", "A'")
                .replaceAll("([èé]|&egrave;?|&eacute;?)", "e'")
                .replaceAll("([ÈÉ]|&Egrave;?|&Eacute;?)", "E'")
                .replaceAll("([ìí]|&igrave;?|&iacute;?)", "i'")
                .replaceAll("([ÌÍ]|&Igrave;?|&Iacute;?)", "I'")
                .replaceAll("([òó]|&ograve;?|&oacute;?)", "o'")
                .replaceAll("([ÒÓ]|&Ograve;?|&Oacute;?)", "O'")
                .replaceAll("([ùú]|&ugrave;?|&uacute;?)", "u'")
                .replaceAll("([ÙÚ]|&Ugrave;?|&Uacute;?)", "U'")
                .replaceAll("(&nbsp;?)", " ")
                .replace("&#39;", "'")
                .replace("&#039;", "'")
                .replaceAll("(’|‘|°|&rsquo;|&rsquor;|&lsquo;|&lsquor;|&sbquo;)", "'")
                .replaceAll("(“|”|&quot;|«|»)", "\"")
                .replaceAll("&amp;?", "&")
                .replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<")
                .replace("&#038;", "&")
                .replace("&#38;", "&")
                .replaceAll("\n(\\s*\n)+", "\n\n")
                .replaceAll("^(\n|\r|\\s)*", "")
                ;
        return result;
    }

}
