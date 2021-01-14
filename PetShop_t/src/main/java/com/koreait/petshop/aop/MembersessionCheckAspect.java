package com.koreait.petshop.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koreait.petshop.exception.LoginRequiredException;

/*
 ������ �α����� �ʿ��� ���� ���θ� ó���ϱ� ���� �ڵ�� ��Ʈ�ѷ��� ���� �ʰ�, ���� �� ��ü�� ����ȭ���� aop�� �����ߴ�
 */
public class MembersessionCheckAspect {
	private static final Logger logger = LoggerFactory.getLogger(MembersessionCheckAspect.class);

	public Object sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		Object target = joinPoint.getTarget();// ���� ȣ���Ϸ��� �ߴ� ��ü
		logger.debug("����ȣ���Ϸ�����ü" + target);
		joinPoint.getSignature();

		String methodName = joinPoint.getSignature().getName();
		logger.debug("���� ȣ���Ϸ��ߴ� �޼����" + methodName);
		Object[] args = joinPoint.getArgs();// ����ȣ���Ϸ��ߴ� �޼����� �Ű�����
		for (Object arg : args) {
			logger.debug("�Ű���������" + arg);
		}
		// ���� ȣ���Ϸ��ߴ� �޼��带 ��� ȣ��

		// ������ ��� ���ؼ��� HttpServletRequest�� �ʿ��ϴ�
		HttpServletRequest request = null;
		for (Object arg : args) {
			logger.debug("�Ű���������", arg);
			if (arg instanceof HttpServletRequest) {// request��ü���
				request = (HttpServletRequest) arg;
			}
		}
		// ������ ���ٸ�? ���ܸ� �߻���Ŵ -->exceptionHandler�� ���ļ� Ŭ���̾�Ʈ���� ������ ����ó��
		// 2. �������ִٸ� ? �״�� ���� ȣ���Ϸ��ߴ� �޼��带 ����
		HttpSession session=null;
		session=request.getSession();
		Object result=null;
		if(session.getAttribute("member")==null){
			throw new LoginRequiredException("�α����� �ʿ��� �����Դϴ�");
		}else {
			result = joinPoint.proceed();// ���⼭ ���� �߻��ϹǷ�.. ����ó����������, �׳� throws			
		}
		// ���� ��û�� �帧�� �״�� ����

		// �𵨿���
		return result;
	}
}
