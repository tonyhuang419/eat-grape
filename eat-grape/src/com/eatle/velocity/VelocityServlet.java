package com.eatle.velocity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.tools.view.VelocityLayoutServlet;

/**
 * 自定义velocity的错误处理
 * @author liudong
 */
public final class VelocityServlet extends VelocityLayoutServlet
{
	private static final long serialVersionUID = 1L;
	
	private final static Log LOG = LogFactory.getLog(VelocityServlet.class);

	protected void error(HttpServletRequest req, HttpServletResponse res,
			Exception excp) throws ServletException
	{

		Throwable t = excp;
		if (excp instanceof MethodInvocationException)
			t = ((MethodInvocationException) excp).getWrappedThrowable();

		try
		{
			if (t instanceof ResourceNotFoundException)
			{
				LOG.error(t.getMessage() + "(" + req.getRequestURL().toString() + ")");
				if (!res.isCommitted())
					res.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
			else
			{
				StringBuilder log = new StringBuilder(
						"ERROR：Unknown Velocity Error，url=");
				log.append(req.getRequestURL());
				if (req.getQueryString() != null)
				{
					log.append('?');
					log.append(req.getQueryString());
				}
				log.append('(');
				log.append(new Date());
				log.append(')');
				LOG.error(log.toString(), t);
				log = null;
				req.setAttribute("javax.servlet.jsp.jspException", t);
				res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
		catch (IOException e)
		{
			LOG.error("Exception occured in VelocityServlet.error", e);
			throw new ServletException(e);
		}
		catch (IllegalStateException e)
		{
			LOG.error("==============<<IllegalStateException>>==============",
					e.getCause());
			throw new ServletException(e);
		}
		return;
	}

	protected void doRequest(HttpServletRequest req, HttpServletResponse res)
	{

		long runtime = System.currentTimeMillis();
		try
		{
			super.doRequest(req, res);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (req.getAttribute("close_comment") == null)
		{
			Date cur_time = Calendar.getInstance(req.getLocale()).getTime();
			PrintWriter pw;
			try
			{
				pw = res.getWriter();
				pw.print("\r\n<!-- Generated by OsChina.NET (");
				pw.print(cur_time);
				pw.print(") ");
				pw.print(cur_time.getTime() - runtime);
				pw.print("ms -->");
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}