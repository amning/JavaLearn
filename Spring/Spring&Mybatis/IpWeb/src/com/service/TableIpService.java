package com.service;

import com.dao.ITableIpDao;
import com.entity.TableIp;
import com.page.PageParam;
import javafx.scene.control.Tab;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王宁 on 2017/7/25.
 */
@Service("tableIpService")
public class TableIpService {
    @Resource
    private ITableIpDao dao;
    public int getRowCount(){
      return dao.getRowCount();
    }

    public PageParam getIpListByPage(PageParam pageParam) {
        int currPage = pageParam.getCurrPage();
        int offset=(currPage-1)*PageParam.pageSize;
        int size = PageParam.pageSize;
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("offset",offset);
        params.put("size",size);

        List<TableIp> ipList = dao.selectByParams(params);
        pageParam.setData(ipList);
        return pageParam;
    }
}
