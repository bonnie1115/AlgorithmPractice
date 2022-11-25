package cn.algorithmpractice.ld;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Average<str> {
    public static List<String> readFile2() throws IOException {

        //String encoding = "GBK";
        //1.读取本地txt文件 2.计算平均值
        File file = new File("D:\\file\\0216-002-failrates.txt");
        List<String> listString = new ArrayList<String>();
        FileReader fr = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fr);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String splitArray[] = line.split("    ");
            System.out.println("splitArray得值为***********"+splitArray);
            int[] scores = new int[splitArray.length];
            for (int i =0;i<splitArray.length;i++){
                scores[i]=Integer.parseInt(splitArray[i]); //??多位小数

            }
            System.out.println("scores得值为******"+scores);

            listString.add(line);
        }
        bufferedReader.close();
        return listString;
    }

    //调试通过
    public static List<String> readFile3() throws IOException {
        File file = new File("D:\\file\\0216-002-failrates.txt");
        List<String> listString = new ArrayList<String>();
        FileReader fr = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fr);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String splitArray[] = line.split("         ");
            System.out.println("splitArray得值为***********"+splitArray);
            List<Double> failRates = new ArrayList<Double>();
            String failRate=null;
            String failNum =null;
            for (String split :splitArray){
               failRate =split.substring(split.lastIndexOf("：")+1); //得到类似12.09 的字符串类型
                System.out.println(failRate);
                failNum=failRate.replace("%","");   //去掉百分号
                //System.out.println("failNum****"+failNum);
                failRates.add(Double.valueOf(failNum)/100);
                //System.out.println(failNum);//拿到每一只识别率,但是需要转换成
                //System.out.println(Double.valueOf(split.substring(split.lastIndexOf("：")+1).replace("%",""))/100);
            }
            listString.add(line);
            Double sum=0.0;
            System.out.println("共统计笔："+failRates.size());
            for(int i=0;i<failRates.size();i++ ){
                sum = sum + failRates.get(i);

            }
            System.out.println(sum);

            Double average = sum/failRates.size();
            System.out.println("average的值为*****"+average);

        }
        bufferedReader.close();
        return listString;


    }


    /*public void test(){
        //String path ="E:\\test\\2.0\\ss\\210101002032";
        String path ="笔：BP2-0E5-03D-XU: 采集点数: 7610 识别失败点数: 376 识别失败率：4.94%";
        //先获取最后一个  \ 所在的位置
        int index1 = path.lastIndexOf("：");
        //然后获取从最后一个\所在索引+1开始 至 字符串末尾的字符
        String ss1 = path.substring(index1+1);
        System.out.println("截取最后一个 / 之后的字符串"+ss1);
    }
    public void test2(){
        //百分比字符串转化成浮点类型
        String s = "70%";
        Double i=Double.valueOf(s.replace("%",""))/100;
        System.out.println("转化之后的百分数是:"+i);
    }
    public void test3(){
        //String类型的数组,转换成可计算类型的数组,如Double等
        String s = "70%";
        Double i=Double.valueOf(s.replace("%",""))/100;
        System.out.println("转化之后的百分数是:"+i);
    }*/

    public static void main(String[] args) throws IOException {
        Average average =new Average();
        average.readFile3();

    }
}
