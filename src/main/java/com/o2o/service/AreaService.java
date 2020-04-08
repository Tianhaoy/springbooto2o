package com.o2o.service;

import com.o2o.dto.AreaExecution;
import com.o2o.entity.Area;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/10/24 22:50
 */
public interface AreaService {
    public static final String AREALISTKEY = "arealist";

    /**
     * 获取区域列表，优先从缓存获取
     *
     * @return
     */
    List<Area> getAreaList();

    /**
     * 增加区域信息
     *
     * @param area
     * @return
     */
    AreaExecution addArea(Area area);

    /**
     * 修改区域信息
     *
     * @param area
     * @return
     */
    AreaExecution modifyArea(Area area);
}
