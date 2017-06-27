package service;

import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.Date;

/**
 * Created by 王宁 on 2017/5/3.
 */
public class RecordService {
    RecordDAO rcdao = new RecordDAO();
    public void add(int spend, Category c,String comment,Date d){//消费金额，消费分类，备注和日期

        Record r = new Record();
        r.spend = spend;
        r.date = d;
        r.comment  =comment;
        r.cid = c.id;
        rcdao.add(r);

    }
}
