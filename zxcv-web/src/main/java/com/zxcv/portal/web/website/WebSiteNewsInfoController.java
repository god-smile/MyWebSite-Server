package com.zxcv.portal.web.website;

import cn.hutool.http.HttpUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.SiteNewsInfoService;
import com.zxcv.api.commom.service.site.SiteVisitLogService;
import com.zxcv.api.commom.service.site.dto.SiteNewsInfoDTO;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteVisitLogReq;
import com.zxcv.api.commom.service.site.param.query.QuerySiteNewsInfoReq;
import com.zxcv.commom.utils.IPUtil;
import com.zxcv.portal.common.BaseController;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 新闻表 前端控制器
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteNewsInfoController.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Api(value = "新闻表管理", description = "新闻表管理")
@RestController
@RequestMapping("/webSiteNewsInfo")
public class WebSiteNewsInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(WebSiteNewsInfoController.class);

	@Autowired
	private SiteNewsInfoService siteNewsInfoService;
    @Autowired
    private SiteVisitLogService siteVisitLogService;
	@ApiOperation("查询新闻表对象，增加阅读量")
	@PostMapping("/selectWebSiteNewsInfo")
	public BizResultVO<SiteNewsInfoDTO> selectWebSiteNewsInfo(HttpServletRequest httpServletRequest, @RequestBody QuerySiteNewsInfoReq req)
			throws UnsupportedEncodingException
	{
		logger.info("begin查询新闻表对象controller,入参={}", JSONObject.toJSON(req));

		req.setEntrance(1);

		BizResult<SiteNewsInfoDTO> result = siteNewsInfoService.selectWebSiteNewsInfo(req);
		logger.info("end查询新闻表对象controller,结果={}", JSONObject.toJSON(result));

		//加载文件信息
		if(result.getData() != null && !StringUtils.isBlank(result.getData().getContent())){
			String content = HttpUtil.downloadString(result.getData().getContent(),"UTF-8");
			if(StringUtils.isNotEmpty(content)){
				logger.info("开始解析远程文本内容:"+result.getData().getContent());
				content = URLDecoder.decode(content,"UTF-8");
				result.getData().setContent(content);
			}
		}
        if(result.getData() != null && result.getData().getNewsNo() != null){//保存访问日志
            SaveAndModifySiteVisitLogReq logRequest = new SaveAndModifySiteVisitLogReq();
            logRequest.setItemNo(result.getData().getNewsNo());
            logRequest.setItemType(0);
            logRequest.setProjectNo(result.getData().getProjectNo());
            logRequest.setCreateEmpId(IPUtil.getRemoteIP(httpServletRequest));
            logRequest.setRequestIp(IPUtil.getRemoteIP(httpServletRequest));
            logRequest.setUserAgent(IPUtil.getRemoteUserAgent(httpServletRequest));
            siteVisitLogService.saveSiteVisitLog(logRequest);
        }

		return new BizResultVO<SiteNewsInfoDTO>(result);
	}

	@ApiOperation("分页-新闻表对象")
	@PostMapping("/queryWebSiteNewsInfoForPage")
	public BizResultVO<PageBean<SiteNewsInfoDTO>> queryWebSiteNewsInfoForPage(@RequestBody QuerySiteNewsInfoReq req) {
		logger.info("begin分页-查询新闻表controller,入参={}", JSONObject.toJSON(req));

		req.setEntrance(1);

		BizResult<PageBean<SiteNewsInfoDTO>> result = siteNewsInfoService.querySiteNewsInfoForPage(req);
		logger.info("end分页查询新闻表controller,结果...");
		return new BizResultVO<PageBean<SiteNewsInfoDTO>>(result);
	}
}

