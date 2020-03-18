package com.forezp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.jpa.internal.schemagen.ScriptTargetOutputToFile;
import org.junit.Test;

import java.io.OutputStream;
import java.util.*;

//数据结构以及算法
public class Demo {

    @Test
    public void test1() {
        //创建一个原始的11*11的原始二维数组
        //0表示没有棋子，1表示黑棋子，2表示蓝棋子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //先遍历二维数组，得到非0数组的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);


        //将一个二维数组转为稀疏数组稀疏数组赋值
        //给
        int inx[][] = new int[sum + 1][3];
        inx[0][0] = 11;
        inx[0][1] = 11;
        inx[0][2] = sum;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    chessArr1[sum][0] = i;
                    chessArr1[sum][1] = j;
                    chessArr1[sum][2] = chessArr1[i][j];
                }
            }
        }

    }

    @Test
    public void test2() {
        List list1 = new ArrayList();
        String a = "[\"010000\",\"020002\",\"010003\"]";
        String substring = a.substring(1, a.length() - 1);
        System.out.println(substring);
//        List<String> roleIdList = JSONObject.parseArray(substring,  String.class);
//        System.out.println(roleIdList);
        String[] split = substring.split(",");
        List<String> list = Arrays.asList(split);
        for (String s : list) {
            String substring1 = s.substring(1, 3);
            list1.add(substring1);
        }
        Set<String> set = new HashSet<>(list1);
        System.out.println(set);
        String roles = JSON.toJSONString(set);
        String substring1 = roles.substring(1, roles.length() - 1);
        System.out.println(substring1);
    }

    @Test
    public void test3() {
        List<Object> list = new ArrayList<>();
        String a = "1,2,3";
        String[] split = a.split("\n");
        List<String> list1 = Arrays.asList(split);
        System.out.println(list1);
        String[] split1 = a.split(",");
        System.out.println(split1);

    }


}
