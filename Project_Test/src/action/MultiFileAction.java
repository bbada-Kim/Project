package action;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import vo.ActionForward;
import vo.CardBean;


public class MultiFileAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		String realFolder = "";
		String saveFolder = "/upload";
		int fileSize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest		
		(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		String subject = multi.getParameter("subject");
		
	
		Enumeration files = multi.getFileNames();
		
		
		ArrayList<CardBean> list = new ArrayList<>();
	
		
		int i=0;
		while(files.hasMoreElements()) {
			String file = (String)files.nextElement();
			
			
			CardBean fv = new CardBean();
			fv.setCard(multi.getParameter("cnum"+i));
			fv.setFilename(multi.getFilesystemName(file));
			fv.setOrigfilename(multi.getOriginalFileName(file));
			i++;
			list.add(fv);
		}
			
			
		for(CardBean fv : list) {
//			System.out.println(fv.getCard());
//			System.out.println(fv.getOrigfilename());
			System.out.println(fv.getFilename());
		}
			request.setAttribute("name", name);
			request.setAttribute("subject", subject);
			request.setAttribute("fileList", list);
			
			forward = new ActionForward();
			forward.setPath("filetest.jsp");
			
		
		return forward;
	}

}
