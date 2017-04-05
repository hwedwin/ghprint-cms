package com.ghprint.cms.services;

import com.ghprint.cms.model.stock.TMaterialCost;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */
public interface MaterialCostService {
        /*
        * 增加一条收入支出记录
        * */
        public  Integer  additems(TMaterialCost materialCost);
        /*
        * 删除同一种材料收支记录
        * */
        public  Integer delitems(Integer stockid);
        /*
        * 获取某种材料某段时间收支记录
        * */
        public List<TMaterialCost> selectitems(Integer stockid , Date StartDate , Date EndDate);
        /*
        * 重置某种材料收支记录
        * */
        public  Integer  updateitemset(Integer stockid );
        /*
        * 某种材料最新总库存数目
        * */
        public  Integer selectsum(Integer stockid);

}
