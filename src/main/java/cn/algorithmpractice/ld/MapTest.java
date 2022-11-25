package cn.algorithmpractice.ld;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.mapTest();
    }
    public void mapTest(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("1","test1");
        map.put("2","test2");
        map.put("3","test3");
        map.put("4","test4");

        //Map取值一 通过Map.keySet遍历key和value： 普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        System.out.println("map.keySet()的值"+map.keySet());  //返回包含的键的 Set视图。
        for(String key:map.keySet()){
            System.out.println("key="+key);
            System.out.println("value="+map.get(key));
        }


        //map取值二  通过Map.entrySet使用iterator遍历key和value：
        System.out.println("Map的map.entrySet()"+map.entrySet());
        System.out.println("Map的map.entrySet().iterator()"+map.entrySet().iterator());
        Iterator<Map.Entry<String,String>> it =map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println("key="+entry.getKey());
            System.out.println("value="+entry.getValue());

        }

        //map取值三 推荐，尤其是容量大时 通过Map.entrySet遍历key和value
        System.out.println("通过Map.entrySet遍历key和value");


        for(Map.Entry<String,String> entry :map.entrySet()){
            System.out.println("key="+entry.getKey());
            System.out.println("value="+entry.getValue());
        }

        // 第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }

        // 第五种
        System.out.println("直接通过key获取value");
        String data = map.get("1");
        System.out.println(data);





    }
}
