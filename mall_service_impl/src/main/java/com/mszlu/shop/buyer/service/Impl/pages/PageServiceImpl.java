package com.mszlu.shop.buyer.service.Impl.pages;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Enums;
import com.mszlu.shop.buyer.mapper.PageTemplateMapper;
import com.mszlu.shop.buyer.mapper.TemplateDetailMapper;
import com.mszlu.shop.buyer.service.PageService;
import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.model.buyer.enums.StatusEnum;
import com.mszlu.shop.model.buyer.pojo.PageTemplate;
import com.mszlu.shop.model.buyer.pojo.TemplateDetail;
import com.mszlu.shop.model.buyer.vo.pages.*;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@DubboService(version = "1.0.0",interfaceClass = PageService.class)
public class PageServiceImpl implements PageService {

    @Resource
    private PageTemplateMapper pageTemplateMapper;

    @Resource
    private TemplateDetailMapper templateDetailMapper;

    @Override
    public Result findPageTemplate(Integer clientType, int pageType) {
        LambdaQueryWrapper<PageTemplate> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PageTemplate::getClientType,clientType)
                .eq(PageTemplate::getPageType,pageType)
                .eq(PageTemplate::getStatus, StatusEnum.NORMAL.getCode());
        queryWrapper.last("limit 1");
        PageTemplate pageTemplate = pageTemplateMapper.selectOne(queryWrapper);
        if (pageTemplate.getPageType() == null) {
            return Result.fail(-999,"模板不存在");
        }
        Long id = pageTemplate.getId();
        LambdaQueryWrapper<TemplateDetail> detailQueryWrapper = new LambdaQueryWrapper<>();
        detailQueryWrapper.eq(TemplateDetail::getTemplateId,id)
                .eq(TemplateDetail::getStatus,StatusEnum.NORMAL.getCode());
        List<TemplateDetail> templateDetailList = templateDetailMapper.selectList(detailQueryWrapper);
        Map map = new LinkedHashMap();
        for (TemplateDetail templateDetail : templateDetailList) {
            if (templateDetail.getTemplateType().equals("carousel")) {
                String templateData = templateDetail.getTemplateData();

                String templateType = templateDetail.getTemplateType();
                if ("topAdvert".equals(templateType)){
                    TopAdvert topAdvert = JSON.parseObject(templateData, TopAdvert.class);
//                pageTemplateVo.setPageData(topAdvert);
                    map.put(templateDetail.getTemplateType(),topAdvert);
                }
                if ("navBar".equals(templateType)){
                    NavBar navBar = JSON.parseObject(templateData,NavBar.class);
                    map.put(templateDetail.getTemplateType(),navBar);
//                pageTemplateVo.setPageData(navBar);
                }
                if ("carousel".equals(templateType)){
                    Carousel carousel = JSON.parseObject(templateData,Carousel.class);
                    map.put(templateDetail.getTemplateType(),carousel);
                }
                if ("discountAdvert".equals(templateType)){
                    DiscountAdvert discountAdvert = JSON.parseObject(templateData, DiscountAdvert.class);
                    map.put(templateDetail.getTemplateType(),discountAdvert);
                }
                if ("recommend".equals(templateType)){
                    PageRecommend pageRecommend = JSON.parseObject(templateData,PageRecommend.class);
                    map.put(templateDetail.getTemplateType(),pageRecommend);
                }
                if ("newGoodsSort".equals(templateType)){
                    NewGoodsSort newGoodsSort = JSON.parseObject(templateData,NewGoodsSort.class);
                    map.put(templateDetail.getTemplateType(),newGoodsSort);
                }
                if ("firstAdvert".equals(templateType)){
                    FirstAdvert firstAdvert = JSON.parseObject(templateData,FirstAdvert.class);
                    map.put(templateDetail.getTemplateType(),firstAdvert);
                }
                if ("notEnough".equals(templateType)){
                    NotEnough notEnough = JSON.parseObject(templateData,NotEnough.class);
                    map.put(templateDetail.getTemplateType(),notEnough);
                }
            }
        }
        return Result.success(map);
    }
}
