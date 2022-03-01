package J_action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import J_svc.RequestWriteProService;
import vo.ActionForward;
import J_vo.BloodReBean;
import action.Action;

public class RequestWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//bloodrequest에 값 저장		
		ActionForward forward=null;
		BloodReBean bloodReBean = null;
		String realFolder="";
		String saveFolder="/upload";
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);   		
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		bloodReBean = new BloodReBean();
		bloodReBean.setID(multi.getParameter("id"));
		bloodReBean.setRe_locate(multi.getParameter("locate"));
		bloodReBean.setRe_content(multi.getParameter("content"));
		bloodReBean.setRe_date(multi.getParameter("date"));
		bloodReBean.setRe_count(Integer.parseInt(multi.getParameter("count")));
		bloodReBean.setRe_btype(multi.getParameter("btype"));
		bloodReBean.setRe_blood(multi.getParameter("blood"));
		bloodReBean.setRe_rh(multi.getParameter("rh"));
		bloodReBean.setRe_status(multi.getParameter("status"));
		bloodReBean.setRe_image(
				multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
//bloodtest테이블 업데이트
//		UpdateBean updateBean = null;
//		updateBean = new UpdateBean();
//		updateBean.setBc_id(request.getParameter("ID"));
//		updateBean.setBc_status(request.getParameter("status"));
//		updateBean.setBc_btype(request.getParameter("btype"));
//		updateBean.setBc_rh(request.getParameter("rh"));
//		updateBean.setBc_blood(request.getParameter("blood"));
		
//서비스로 넘겨주는 부분
		System.out.println(bloodReBean.getID());
		RequestWriteProService bloodWriteProService = new RequestWriteProService();
		boolean isWriteSuccess = bloodWriteProService.insertCount(bloodReBean);
		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.jsp");

		}

		return forward;
		
	}  	
	
}