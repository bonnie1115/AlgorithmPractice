package cn.algorithmpractice.ld;

import java.math.BigDecimal;
import java.util.Random;

public class RandomLonLat {
    public String randomLonLat(double MinLon,double MaxLon,double MinLat,double MaxLat){
        Random random = new Random();
        BigDecimal db =new BigDecimal(Math.random()*(MaxLon - MinLon)+MinLon);
        String lon = db.setScale(6,BigDecimal.ROUND_HALF_UP).toString();//小数后6位
        db = new BigDecimal(Math.random()*(MaxLat - MinLat)+MaxLat);
        String lat = db.setScale(6,BigDecimal.ROUND_HALF_UP).toString();

        return lat+"  "+lon;

    }

    public static void main(String[] args) {
        RandomLonLat randomLonLat = new RandomLonLat();
        for(int i=0; i<=1000;i++){
            System.out.println(randomLonLat.randomLonLat(112.27392, 112.87392, 23.12657, 23.92657));
        }

    }

}
