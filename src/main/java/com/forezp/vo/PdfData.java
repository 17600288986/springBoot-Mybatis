package com.forezp.vo;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description: pdf数据实体
 * @Param:
 * @Return:
 * @Author: Jiangsy
 * @Date: 2019/9/19
**/
@Data
public class PdfData implements Serializable{
    private JSONArray classNum;
    private String saveUrl;//pdf保存路径
    private Map<String,String> dataMap;//柱状图等相关数值
    private String ldtUrl;//雷达图路径
    private String zztUrl;//柱状图路径
    private String convertJsPath;//phantomjs转echars的js路径
    private String dataPath;//生成echars报表的options存储的位置
    private String phantomjsPath;//phantomjs的路径
    private String logoPath;//logo路径

    public PdfData() {

    }

    public PdfData(JSONArray classNum,String saveUrl, Map<String, String> dataMap, String ldtUrl, String zztUrl, String convertJsPath, String dataPath, String phantomjsPath,String logoPath) {
        this.classNum=classNum;
        this.saveUrl = saveUrl;
        this.dataMap = dataMap;
        this.ldtUrl = ldtUrl;
        this.zztUrl = zztUrl;
        this.convertJsPath = convertJsPath;
        this.dataPath = dataPath;
        this.phantomjsPath = phantomjsPath;
        this.logoPath = logoPath;

    }
}
