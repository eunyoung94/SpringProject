package com.koreait.petshop.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.model.product.service.TopCategoryService;



//���θ� �̿�� ���������� ����� ī�װ� �޴� ���
public class GlobalDataAspect {
	@Autowired
	private TopCategoryService topCategoryService;
	public Object getGlobalData(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		HttpServletRequest request = null;

		// �Ű������κ��� ��û��ü�����ϱ�
		for (Object arg : joinPoint.getArgs()) {
			if (arg instanceof HttpServletRequest) {
				request = (HttpServletRequest) arg;
			}
		}
		String uri = request.getRequestURI(); // Ŭ���̾�Ʈ�� ��û URI ��Ʈ�� ����
		// topList�� �����ؾ� �ϴ°��� �׷��� ���� ��츦 ����� ó��, �Ʒ��� ���ܽ�ų �׸�� ���������! 
		if (uri.equals("/shop/member/login") ||
			uri.equals("/shop/member/regist")||
			uri.equals("/admin")||
			uri.equals("/admin/product/regist")||
			uri.equals("/admin/product/excel/registform")
			) {// Ŭ���̾�Ʈ�� ��û�� topList�� �ʿ�� �ϴ� ��� : /shop/member/login,																// /shop/member/regist
			result = joinPoint.proceed(); // ���� ȣ���Ϸ� �ߴ� �޼��� ȣ������! go ahead!
		} else {// �ʿ��Ѱ��
				// topList��������
			List topList = topCategoryService.selectAll();
			Object returnObj = joinPoint.proceed();// ��Ʈ�ѷ��κ��� ���;���, ���� ȣ���Ϸ��ߴ� �޼��� ȣ��
			ModelAndView mav = null;
			if (returnObj instanceof ModelAndView) {
				mav = (ModelAndView) returnObj;
				mav.addObject("topList", topList);
				result = mav;
			}
		}
		return result;
	}
}
