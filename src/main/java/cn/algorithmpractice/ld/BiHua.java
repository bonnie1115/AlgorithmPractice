package cn.algorithmpractice.ld;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

import java.util.ArrayList;
import java.util.List;

//20220214 记得引入httpclient的依赖包
/**
 * 获取中文笔画顺序及笔数
 * @author 杨红杰
 * @date 2019/10/24 14:46
 */
public class BiHua {

    public static void main(String[] args) throws Exception {
       //String str = "测试在字体上方书写丢笔情况请大家书写时字体写在题干上方";//共123画
        String str="我这是一行干扰";
        System.out.println(str);
        List<Integer> strokes = new ArrayList<Integer>();
        String storke =null;
        for (int i = 0; i < str.length(); i++) {
            System.out.println(getBiShunAndBiShu(str.substring(i, i + 1)));
            //System.out.println(str.charAt(7));
            storke =  getBiShunAndBiShu(str.substring(i, i + 1));
            storke =  subDesignatedString(storke,"共","画");
            strokes.add(Integer.parseInt(storke));
        }
        System.out.println("每个字笔画数组:"+strokes);
        Integer sum=0;
        for (int i=0;i<strokes.size();i++){
            sum = sum+ strokes.get(i);
        }
        System.out.println("总笔画数:"+sum);
    }
        /*String  str ="题字共15画；题字的笔顺：竖,横折,横,横,横,竖,横,撇,捺,横,撇,竖,横折,撇,点";
        System.out.println(subDesignatedString(str,"共","画"));*/








/**
 * 截取字符串str中指定字符 strStart、strEnd之间的字符串
 *
 * @param str
 * @param strStart
 * @param strEnd
 * @return
 */


   public static String subDesignatedString(String str, String strStart, String strEnd) {

    /* 找出指定的2个字符在 该字符串里面的 位置 */
    int strStartIndex = str.indexOf(strStart);
    int strEndIndex = str.indexOf(strEnd);

    /* index 为负数 即表示该字符串中 没有该字符 */
    if (strStartIndex < 0) {
        return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
    }
    if (strEndIndex < 0) {
        return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
    }
    /* 开始截取 */
    String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
    return result;


}
    //截取
    public static String getBiShunAndBiShu(String str) throws Exception {
        HttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(10);
        connectionManager.getParams().setConnectionTimeout(300000000);
        connectionManager.getParams().setSoTimeout(300000000);
        HttpClient client = new HttpClient(connectionManager);
        GetMethod method = new GetMethod("http://bishun.shufaji.com/" + cnToUnicode(str) + ".html");
        client.executeMethod(method);
        String returnJson = new String(method.getResponseBody(), "utf-8");
        int idx1 = returnJson.indexOf("<div id=\"hzcanvas\">");
        if (idx1 != -1) {
            idx1 += 19;
            int idx2 = returnJson.indexOf("</div>", idx1);
            returnJson = returnJson.substring(idx1, idx2 == -1 ? returnJson.length() : idx2);
        }
        return returnJson;
    }

    /**
     * 中文转Unicode
     *
     * @param cn
     * @return
     */
    private static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "0x" + Integer.toString(chars[i], 16);
        }
        return returnStr;
    }
}