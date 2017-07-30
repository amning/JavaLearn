package com.resume.utils;

/**
 * Created by 王宁 on 2017/7/29.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.resume.model.Basic;
import com.resume.model.Educational;
import com.resume.model.Work;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

    public class WordGenerator {
        private Configuration configuration = null;

        public WordGenerator() {
            configuration = new Configuration();
            //设置编码格式
            configuration.setDefaultEncoding("UTF-8");
        }

        // 3个参数分别是：基础信息、教育信息和工作经历，通过数据库查找所得
        public void createDoc(List<Basic> basic, List<Educational> educational,
                              List<Work> work) {
            String modelName = "muban.ftl";//模板路径
            String exportFilePath = "outFile.doc";//文件导出路径，为doc格式
            Template t = null;
            // 1、导入模板
            configuration.setClassForTemplateLoading(this.getClass(), "/com/resume/modelPath");

            try {
                // modelName为要装载的模板，是ftl格式
                t = configuration.getTemplate(modelName,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 2、打包数据--每次导出的word文件模板不同，打包数据的方法要单独写
            Map<String, Object> dataMap = new HashMap<String, Object>();
            getData(basic,educational,work,dataMap);

            // 3、导出文件
            // 输出文档路径及名称
            File outFile = new File(exportFilePath);
            Writer out = null;
            try {
                //输出文件
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            try {
                t.process(dataMap, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //把数据打包成map;dataMap里存放的数据Key值要与模板中的参数相对应
        private void getData(List<Basic> basic_info, List<Educational> educational_info,
                             List<Work> work_info, Map<String, Object> dataMap) {
            dataMap.put("Name", basic_info.get(0).getName());//说明：模板文件中有${Name}与之对应，下同
            dataMap.put("Age", basic_info.get(0).getAge());
            dataMap.put("Gender", basic_info.get(0).getGender());
            dataMap.put("School", basic_info.get(0).getSchool());
            dataMap.put("Address", basic_info.get(0).getAddress());
            dataMap.put("Introduce", basic_info.get(0).getIntroduce());
            dataMap.put("Email", basic_info.get(0).getEmail());
            dataMap.put("Tel", basic_info.get(0).getTel());
            dataMap.put("educational_info", educational_info);
            dataMap.put("work_info", work_info);
            //由于word中包含两个table，table1对应教育信息，table2对应工作经历
            List<Educational> _table1 = new ArrayList<Educational>();
            //循环将所有信息放入Educational_info的list中
            for (int i = 0; i < educational_info.size(); i++) {
                Educational _t1 = new Educational();
                _t1.setSchool(educational_info.get(i).getSchool());
                _t1.setEducation(educational_info.get(i).getEducation());
                _t1.setGraduation(educational_info.get(i).getGraduation());
                _t1.setMajor(educational_info.get(i).getMajor());
                _table1.add(_t1);

            }
            //将list放入dataMap
            dataMap.put("table1", _table1);
            //table2过程同table1
            List<Work> _table2 = new ArrayList<Work>();
            for (int i = 0; i < work_info.size(); i++) {
                Work _t2 = new Work();
                _t2.setCompany(work_info.get(i).getCompany());
                _t2.setDeparture(work_info.get(i).getDeparture());
                _t2.setDuty(work_info.get(i).getDuty());
                _t2.setPosition(work_info.get(i).getPosition());
                _table2.add(_t2);

            }
            dataMap.put("table2", _table2);
        }


    }

