package com.smalldot.service.soft.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smalldot.dao.entity.TSoftCategory;
import com.smalldot.dao.entity.TSoftData;
import com.smalldot.dao.entity.TSoftImg;
import com.smalldot.dao.service.ITSoftCategoryService;
import com.smalldot.dao.service.ITSoftDataService;
import com.smalldot.dao.service.ITSoftImgService;
import com.smalldot.dao.util.IdUtil;
import com.smalldot.service.soft.bo.SearchSoftBo;
import com.smalldot.service.soft.bo.SoftBo;
import com.smalldot.service.soft.bo.SoftCategoryBo;
import com.smalldot.service.soft.bo.SoftImgBo;
import com.smalldot.service.soft.config.SystemConfig;
import com.smalldot.service.soft.service.SoftService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.smalldot.service.soft.consts.SoftConsts.USER_NAME;

@Service
public class SoftServiceImpl implements SoftService {
    @Autowired
    private ITSoftDataService softDataService;
    @Autowired
    private ITSoftImgService imgService;
    @Autowired
    private SystemConfig systemConfig;
    @Autowired
    private ITSoftCategoryService categoryService;

    @Override
    public SoftBo save(SoftBo bo) {
        String softId = StringUtils.isNotBlank(bo.getId())?bo.getId():IdUtil.nextId();
        TSoftData softData = new TSoftData();
        softData.setRevision(softId);
        softData.setCreatedBy(USER_NAME);
        softData.setCreatedTime(LocalDateTime.now());
        softData.setUpdatedBy(USER_NAME);
        softData.setUpdatedTime(LocalDateTime.now());
        softData.setId(softId);
        softData.setSoftName(bo.getSoftName());
        softData.setSoftDesc(bo.getSoftDesc());
        softData.setWebsite(bo.getWebsite());
        softData.setUrl(bo.getUrl());
        softData.setIcon(bo.getIcon());
        softData.setCategoryId(bo.getCategoryId());
        if(StringUtils.isNotBlank(bo.getId())){
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id",softId);
            softDataService.update(softData,queryWrapper);
        }else{
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("soft_name", bo.getSoftName());
            queryWrapper.eq("website", bo.getWebsite());
            int count = softDataService.count(queryWrapper);
            if (count == 0) {
                softDataService.save(softData);
            }
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("soft_id",softId);
        imgService.remove(queryWrapper);
        List<SoftImgBo> imgs = bo.getImgs();
        if (CollectionUtils.isNotEmpty(imgs)) {
            imgs.stream().forEach(i -> {
                TSoftImg img = new TSoftImg();
                img.setRevision(IdUtil.nextId());
                img.setCreatedBy(USER_NAME);
                img.setCreatedTime(LocalDateTime.now());
                img.setUpdatedBy(USER_NAME);
                img.setUpdatedTime(LocalDateTime.now());
                img.setId(IdUtil.nextId());
                img.setImgUrl(i.getImgUrl());
                img.setSoftId(softId);
                img.setImgDesc(i.getImgDesc());
                imgService.save(img);
            });
        }
        return bo;
    }

    @Override
    public Page list(SearchSoftBo soft) {
        Page params = new Page();
        params.setSize(soft.getPageSize());
        params.setCurrent(soft.getPageNumber());
        QueryWrapper query = new QueryWrapper();
        query.orderByDesc("CREATED_TIME");
        query.orderByDesc("id");
        if (StringUtils.isNotBlank(soft.getKeyword())) {
            query.like("soft_name", "%" + soft.getKeyword() + "%");
            query.or();
            query.like("soft_desc", "%" + soft.getKeyword() + "%");
        }

        Page<TSoftData> page = softDataService.page(params, query);
        BeanUtils.copyProperties(page, params);
        params.setRecords(page.getRecords().stream().map(i -> {
            SoftBo bo = new SoftBo();
            BeanUtils.copyProperties(i, bo);
            bo.setImgs(queryImgsById(i.getId()));
            bo.setCategory(queryCategory(i.getCategoryId()));
            if (StringUtils.isEmpty(bo.getIcon()) && CollectionUtils.isNotEmpty(bo.getImgs())) {
                bo.setIcon(bo.getImgs().get(0).getImgUrl());
            }
            return bo;
        }).collect(Collectors.toList()));
        return params;
    }

    private SoftCategoryBo queryCategory(String categoryId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", categoryId);
        TSoftCategory category = categoryService.getOne(wrapper);
        SoftCategoryBo bo = new SoftCategoryBo();
        if (category != null) {
            BeanUtils.copyProperties(category, bo);
        }
        return bo;
    }

    private List<SoftImgBo> queryImgsById(String id) {
        QueryWrapper<TSoftImg> wrapper = new QueryWrapper();
        wrapper.eq("soft_id", id);
        List<TSoftImg> list = imgService.list(wrapper);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.stream().map(img -> {
                SoftImgBo bo = new SoftImgBo();
                BeanUtils.copyProperties(img, bo);
                return bo;
            }).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public String upload(MultipartFile file) throws IOException {
        if (file == null) {
            return "";
        }
        String fileName = file.getOriginalFilename();
        File tmp = new File(systemConfig.getFilePath() + File.separator + fileName);
        file.transferTo(tmp);
        return systemConfig.getLocalUrl() + fileName;
    }


    @Override
    public String delete(String id) {
        QueryWrapper tWrapper = new QueryWrapper();
        tWrapper.eq("soft_id", id);
        imgService.remove(tWrapper);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        softDataService.remove(queryWrapper);
        return id;
    }
}
