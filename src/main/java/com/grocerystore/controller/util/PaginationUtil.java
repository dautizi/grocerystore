package com.grocerystore.controller.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grocerystore.util.Constraint;

public class PaginationUtil {
	
	protected static final Logger logger = LoggerFactory.getLogger(PaginationUtil.class);
	
	public static final int LIMIT = 20;
	public static final String PAGE = "page";
		
	public static Integer getPage(HttpServletRequest request) {
		Integer page = 1;
		String pageParam = request.getParameter(Constraint.PARAM_PAGE);
		if (!StringUtils.isEmpty(pageParam)) {
			try {
				page = Integer.parseInt(pageParam);
			} catch (NumberFormatException e) {
				logger.error("Page error. " + page + " is not an int.");
			}
		}
		return page;
	}
	
	public static int getOffset(int limit, int page) {
		int offset = 0;
		if (page > 0) {
			page = page - 1;
			offset = page * limit;
		}
		return offset;
	}
	
	public static int getOffset(int limit, HttpServletRequest request) {
		int offset = 0;
		int page = getPage(request);
		if (page > 0) {
			offset = page * limit;
		}
		return offset;
	}

}
