package com.o2o.service;

import com.o2o.dto.HeadLineExecution;
import com.o2o.dto.ImageHolder;
import com.o2o.entity.HeadLine;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/11/17 15:17
 */
public interface HeadLineService {

    public static final String HLLISTKEY = "headlinelist";
    /**
     * 根据传入的条件返回指定的头条列表
     *
     * @param headLineCondition
     * @return
     * @throws IOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;

    /**
     * 添加头条信息，并存储头条图片
     *
     * @param headLine
     * @param thumbnail
     * @return
     */
    HeadLineExecution addHeadLine(HeadLine headLine, ImageHolder thumbnail);

    /**
     * 修改头条信息
     *
     * @param headLine
     * @param thumbnail
     * @return
     */
    HeadLineExecution modifyHeadLine(HeadLine headLine, ImageHolder thumbnail);

    /**
     * 删除单条头条
     *
     * @param headLineId
     * @return
     */
    HeadLineExecution removeHeadLine(long headLineId);

    /**
     * 批量删除头条
     *
     * @param headLineIdList
     * @return
     */
    HeadLineExecution removeHeadLineList(List<Long> headLineIdList);
}
