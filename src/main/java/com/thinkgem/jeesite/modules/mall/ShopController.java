package com.thinkgem.jeesite.modules.mall;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.cms.entity.Site;
import com.thinkgem.jeesite.modules.cms.service.SiteService;

@Controller
@RequestMapping(value = "${adminPath}/mall/shop")
public class ShopController {

	@Autowired
	private SiteService siteService;

	@RequestMapping(value = { "list", "" })
	public String list(Site site, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Site> page = siteService.findPage(new Page<Site>(request, response), site);
		model.addAttribute("page", page);
		return "modules/mall/shop";
	}

}
