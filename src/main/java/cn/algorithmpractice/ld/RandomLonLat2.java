//package cn.algorithmpractice.ld;
//
//import java.util.Random;
//
//public class RandomLonLat2 {
//
//    /**
//
//     * 随机跑到位置
//
//     * @param row 跑的范围的横坐标
//
//     * @param col 跑的范围的纵坐标
//
//     */
//
//    public void createPosition(int row,int col){
//
//        int [][] burrows = new int[row][col];
//
//        Random creatNum = new Random();
//
////横坐标
//
//        int rowIndex;
//
////纵坐标
//
//        int colIndex;
//
//        boolean index = false;
//
//        while(!index){
//
//            rowIndex = creatNum.nextInt(row);
//
//            colIndex = creatNum.nextInt(col);
//
//            int sum = 0;
//
//            if(burrows[rowIndex][colIndex] != 0){
//
//                for(int m = 0;m
//
//                for(int n = 0;
//
//                if(burrows[m][n] == 0){
//
//                    sum = ++sum;
//
//                    rowIndex = m;
//
//                    colIndex = n;
//
//                    break;
//
//                }
//
//                index = true;
//
//            }
//
//            if(sum !=0){
//
//                index = false;
//
//                break;
//
//            }
//
//        }
//
//    }
//
//    burrows[rowIndex][colIndex] = 1;
//
//System.out.println("row:"+rowIndex+" ,col:"+colIndex);
//
//}
//
//}
//
//public static void main(String [] args){
//
//        new RandomLonLat2().createPosition(4, 4);
//
//        }
//
//        }
//        }