package com.smalldot.service.soft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smalldot.service.soft.bo.SearchSoftBo;
import com.smalldot.service.soft.bo.SoftBo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SoftService {
     SoftBo save(SoftBo bo);

    Page list(SearchSoftBo soft);

    String upload(MultipartFile file) throws IOException;


    String delete(String id);
}
