package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.GibuWriteService;
import vo.GibuBean;
import vo.StockBean;
import vo.ActionForward;
import vo.CardBean;

public class GibuWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		
	
//-------------------------------- 기부신청테이블에 저장할 값 처리 --------------------------------
		GibuBean gibuBean = null;
		String realFolder = "";
		String saveFolder = "/upload";
		int fileSize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest		
		(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		gibuBean = new GibuBean();
		gibuBean.setId(multi.getParameter("id"));
		gibuBean.setDo_coment(multi.getParameter("coment"));
		gibuBean.setDo_status(multi.getParameter("gibu_status"));
		
		
		
//-------------------------------- 재고테이블에 저장할 값 처리 --------------------------------			
		StockBean stockBean = null;
		stockBean = new StockBean();
		stockBean.setBc_btype(multi.getParameter("btype"));
		stockBean.setBc_blood(multi.getParameter("blood"));
		stockBean.setBc_RH(multi.getParameter("rh"));
		stockBean.setBc_status(multi.getParameter("bc_status"));
		


//-------------------------------- 증서번호 테이블에 저장할 값 처리 --------------------------------		
		Enumeration files = multi.getFileNames();
		ArrayList<CardBean> list = new ArrayList<>();
		
	
		int i=0;
		while(files.hasMoreElements()) {
			String file = (String)files.nextElement();


			CardBean cb = new CardBean();
			
			cb.setCard(multi.getParameter("cnum"+i));
			cb.setFilename(multi.getFilesystemName(file));
			cb.setOrigfilename(multi.getOriginalFileName("fileName"+i));
			i++;
			list.add(cb);
			
		}
		System.out.println((multi.getParameter("cnum0")));
		
//-------------------------------- 서비스로 넘겨주는 부분 --------------------------------	
		GibuWriteService gibuWriteService = new GibuWriteService();
		boolean isWriteSuccess = gibuWriteService.registGibu(gibuBean,stockBean,list);
	
		if(!isWriteSuccess) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 실패')");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.jsp");
		}
		return forward;
	}

}
