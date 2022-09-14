package com.ici.projectSGSG;

import java.io.File;
import java.io.IOException; 
import java.time.LocalDate; 
import java.util.*; 
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ici.projectSGSG.dao.*;
import com.ici.projectSGSG.dto.*;
@Controller
public class SGSGController {

	private final String temp = "index";
	
	@Autowired
	private SqlSession sqlSession;
	 
	
	//단순 이동

	@RequestMapping(value="/")
	public String root() {
		return "redirect:index";
	}
	@RequestMapping(value="/introduction")
	public String introduction() {
		return "introduction";
	}
	@RequestMapping(value="/account_Signup")
	public String account_Signup() {
		return "accountSignup";
	}
	@RequestMapping(value="/account_Login")
	public String account_login() {
		return "accountLogin";
	}
	@RequestMapping(value="/account_Mypage")
	public String account_Mypage() {
		return "accountMypage";
	}
	@RequestMapping(value = "/Product_Search")     
	public String Product_Search() {
	         
		return "Product_Search";
	}
	@RequestMapping(value = "/Product_Add")   
	public String Product_Add(){
	      
		return "Product_Add"; 
	}
	@RequestMapping(value="/buy")
	public String buy() {
		return "redirect:index";
	}

	
	// ㄴ 여기까지 단순 이동

	//배너생성 코드
	@RequestMapping(value="/index")
	public String index(HttpSession session, Model model) { 
		 
		ArrayList<ProductDto> products = new ArrayList<>();
		ProductEtcDao productEtcDao = sqlSession.getMapper(ProductEtcDao.class);
		 
		
		//세션에 aid 있으면 그 유저 강아지 등록수별로 추가
		if(session.getAttribute("Aid") != null) { 
			int Aid = (int) session.getAttribute("Aid");  
			
			DogDao dogdao = sqlSession.getMapper(DogDao.class);
			
			ArrayList<DogDto> dogs = dogdao.getDogsData(Aid);
			 
			
			if(!dogs.isEmpty()) {

				for(int i =0; i<dogs.size();i++) {
					DogDto dto = dogs.get(i);  
					String birth = dto.getdAge();
					String breeds = dto.getdBreeds();
					int gender = dto.getdGender();

					LocalDate now = LocalDate.now();
					int year = now.getYear();
					int birthyear = Integer.parseInt(birth.substring(0,4));
					int age = year-birthyear;
					
					int size = dogdao.getDogTag(breeds);
					
					int agetag = dogAgeCalculator.calculator(age, size);
					
					products.addAll(productEtcDao.getCustomizedProduct(size, gender, agetag));
				}
			} 
		}
		
		//추가후 부족할때 대비 랜덤상품 추가
		Collections.shuffle(products); 
		products.addAll(productEtcDao.getRandProduct()); 
		
		
		//중복 삭제 
		ArrayList<Integer> delete = new ArrayList<>();
		for(int x=0;x<products.size();x++) {
			int stdPid = products.get(x).getpId();
			for(int y=x+1;y<products.size();y++) {
				int compPid = products.get(y).getpId();
				if(stdPid==compPid) {
					delete.add(y);
				}
			}
		}
		ArrayList<Integer> deleteList = (ArrayList<Integer>) delete.parallelStream().distinct().collect(Collectors.toList());
		Collections.sort(deleteList, Collections.reverseOrder()); 
		for(int i : deleteList) {
			products.remove(i);
		}
		
		
		//테스트할때 데이터없을경우 대비 갯수3개 체크
		if(products.size()>3) { 
			for(int i=0;i<4;i++) {
				String attrId = "product"+(i+1); 
				model.addAttribute(attrId, PtoPl(products.get(i)));
			} 
		}
		return "index";
	}
 
	
	//회원 정보수정
	@RequestMapping(value="/account_Modify")
	public String account_Modify( HttpSession session,Model model) {
		int Aid = (int) session.getAttribute("Aid");

		AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
		AccountDto dto = accountDao.accountQuery(Aid);
		model.addAttribute("Aid", dto.getaId());
		model.addAttribute("Aloginid", dto.getaLoginid()); 
		model.addAttribute("Aname", dto.getaName()); 
		
		return "accountModify";
	}
	
	
	//회원가입후 아이디 중복확인 및 로그인
	@RequestMapping(value="/account_SignupOk", method = RequestMethod.POST)
	public String account_signupOk(HttpServletRequest request, Model model,HttpSession session) {

		String A_LOGINID = request.getParameter("A_LOGINID");
		String A_LOGINPW = request.getParameter("A_LOGINPW");
		String A_NAME = request.getParameter("A_NAME");
		
		if(A_LOGINID.isEmpty() || A_LOGINID.isBlank()) {
			model.addAttribute("Flag",1); 
			model.addAttribute("Flagmsg","아이디를 입력하셔야합니다."); 
			return "failedRedirect";
		}
		if(A_LOGINPW.isEmpty() || A_LOGINPW.isBlank()) {
			model.addAttribute("Flag",1); 
			model.addAttribute("Flagmsg","비밀번호를 입력하셔야합니다."); 
			return "failedRedirect";
		}
		if(A_NAME.isEmpty() || A_NAME.isBlank()) {
			model.addAttribute("Flag",1); 
			model.addAttribute("Flagmsg","이름을 입력하셔야합니다."); 
			return "failedRedirect";
		}
		
		
		AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
		int idcheck = accountDao.accountCheckId(A_LOGINID);
		
		if(idcheck == 0){
			accountDao.accountInsert(A_LOGINID, A_LOGINPW, A_NAME);
			AccountPlainDto dto =accountDao.accountgetInfo(A_LOGINID); 
			session.setAttribute("Aid", dto.getaId());
			session.setAttribute("Aname", dto.getaName());
			session.setAttribute("Aauth", dto.getaAuth());
			model.addAttribute("Flag",0); 
			return "redirect:index";
		}else {
			model.addAttribute("Flag",1); 
			model.addAttribute("Flagmsg","이미 해당 아이디가 있습니다."); 
		}
		return "failedRedirect";
	}

	
	//정보 수정요청으로 세션이름 변경하고, db수정
	@RequestMapping(value="/account_ModifyOk")
	public String account_ModifyOk(HttpServletRequest request, Model model,HttpSession session) {
		AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
		
		int A_ID = Integer.parseInt(request.getParameter("A_ID"));
		String A_LOGINID = request.getParameter("A_LOGINID");
		String A_NAME = request.getParameter("A_NAME");
		String A_ORIGINPW = request.getParameter("A_ORIGINPW");
		String A_NEWPW = request.getParameter("A_NEWPW");
		
		if(A_ORIGINPW.equals(A_NEWPW)) {
			model.addAttribute("Flag",1);
			model.addAttribute("Flagmsg","이전 비밀번호와 똑같습니다."); 
			return "failedRedirect";
		}
		
		int chk = accountDao.accountCheckPw(A_LOGINID, A_ORIGINPW);
		
		if(chk!=0) {
			session.setAttribute("Aname", A_NAME);
			accountDao.accountUpdate(A_ID,A_NEWPW, A_NAME);
			model.addAttribute("Flag",0); 
		}else {
			model.addAttribute("Flag",1); 
			model.addAttribute("Flagmsg","비밀번호가 맞지 않습니다."); 
			
		}
		return "failedRedirect";
	}
	

	//로그인 아이디,비번확인후 인덱스
	@RequestMapping(value = "/account_Login", method = RequestMethod.POST)
	public String account_Login(HttpServletRequest request, Model model,HttpSession session) {

		String A_LOGINID = request.getParameter("A_LOGINID");
		String A_LOGINPW = request.getParameter("A_LOGINPW"); 
		AccountDao accountDao = sqlSession.getMapper(AccountDao.class); 
		
		int chk = accountDao.accountCheckId(A_LOGINID);
		if(chk>0) {
			chk = accountDao.accountCheckPw(A_LOGINID, A_LOGINPW);
			if(chk>0) {
				AccountPlainDto dto =accountDao.accountgetInfo(A_LOGINID);
				session.setAttribute("Aid", dto.getaId());
				session.setAttribute("Aname", dto.getaName());
				session.setAttribute("Aauth", dto.getaAuth());
				model.addAttribute("Flag",0); 
			}else {
				model.addAttribute("Flag",1); 
				model.addAttribute("Flagmsg","비밀번호가 틀렸습니다."); 
			}
		}else {
			model.addAttribute("Flag",1); 
			model.addAttribute("Flagmsg","해당 아이디가 없습니다."); 
		} 
		return "failedRedirect";
	}
	
	//로그아웃후 세션 비우기
	@RequestMapping(value = "/account_Logout")
	public String account_Logout(HttpSession session) {
		
		session.invalidate();//
		
		return "redirect:account_Login";
	}
	
	
	//상품 이름으로 검색
	@RequestMapping(value = "/search_name")
	public String searchName(HttpServletRequest request, Model model) {
		ProductEtcDao productEtcDao = sqlSession.getMapper(ProductEtcDao.class);
		String name = request.getParameter("search"); 
		if(name.equals("")) {
			model.addAttribute("Flag",1); 
			model.addAttribute("Flagmsg","검색어를 입력하셔야합니다."); 
			return "failedRedirect";
		}else {
			
			ArrayList<ProductDto> arr = productEtcDao.searchname(name); 
			model.addAttribute("prolist", pArrToPlArr(arr));
			 
			return "Product_List";	
		}
	}

	
	//모든 맞춤 상품 검색
	@RequestMapping(value = "/searchCustomized")
	public String searchCustomized(HttpSession session, Model model) {
		int Aid =0;

		if(session.getAttribute("Aid") != null) { 
			Aid = (int) session.getAttribute("Aid"); 
		}else {
			return "accountLogin";
		}
		 
		DogDao dogdao = sqlSession.getMapper(DogDao.class);
		ProductEtcDao productEtcDao = sqlSession.getMapper(ProductEtcDao.class);
		
		ArrayList<DogDto> dogs = dogdao.getDogsData(Aid);
		ArrayList<ProductDto> products = new ArrayList<>(); 
		ArrayList<ProductListDto> productlist = new ArrayList<>(); 
		
		
		
		//맞춤상품 검색 강아지 별로 반복
		for(int i =0; i<dogs.size();i++) {
			DogDto dto = dogs.get(i);  
			String birth = dto.getdAge(); 
			String breeds = dto.getdBreeds();
			int gender = dto.getdGender();

			LocalDate now = LocalDate.now();
			int year = now.getYear();
			int birthyear = Integer.parseInt(birth.substring(0,4));
			int age = year-birthyear;
			
			int size = dogdao.getDogTag(breeds);
			
			int agetag = dogAgeCalculator.calculator(age, size);
			
			products.addAll(productEtcDao.getCustomizedProduct(size, gender, agetag));
		}
		
		

		//중복 삭제 
		ArrayList<Integer> delete = new ArrayList<>();
		for(int x=0;x<products.size();x++) {
			int stdPid = products.get(x).getpId();
			for(int y=x+1;y<products.size();y++) {
				int compPid = products.get(y).getpId();
				if(stdPid==compPid) {
					delete.add(y);
				}
			}
		}
		ArrayList<Integer> deleteList = (ArrayList<Integer>) delete.parallelStream().distinct().collect(Collectors.toList());
		Collections.sort(deleteList, Collections.reverseOrder()); 
		for(int i : deleteList) {
			products.remove(i);
		}
		
		
		//dto 변형
		for(int i=0;i<products.size();i++) { 
			productlist.add(PtoPl(products.get(i)));
		}
		
		
		model.addAttribute("prolist", productlist);
		 
		return "Product_List";	  
	}
	
	
	

	@RequestMapping(value="/wishlist")
	public String wishlist(HttpSession session,Model model) {
		int Aid =0;
		if(session.getAttribute("Aid") != null) { 
			Aid = (int) session.getAttribute("Aid"); 
		}else {
			return "accountLogin";
		}
		ProductEtcDao productEtcDao = sqlSession.getMapper(ProductEtcDao.class);
		ArrayList<ProductDto> arr = productEtcDao.getWishList(Aid);
		ArrayList<ProductListDto> listarr = new ArrayList<>();
		
		for(ProductDto dto :arr) {
			ProductListDto ldto = PtoPl(dto);
			int count = productEtcDao.readWish(Aid, dto.getpId());
			ldto.setCount(count);
			listarr.add(ldto);
		} 
		model.addAttribute("prolist", listarr);
		return "wishlist";
	}
	

	@RequestMapping(value="/addWish")
	public String addWish(HttpSession session,Model model,HttpServletRequest request) {
		int aid =0;
		if(session.getAttribute("Aid") != null) { 
			aid = (int) session.getAttribute("Aid"); 
		}else {
			return "accountLogin";
		}
		int pid = Integer.parseInt(request.getParameter("pid"));
		int inputcount = Integer.parseInt(request.getParameter("count"));
		
		
		ProductEtcDao productEtcDao = sqlSession.getMapper(ProductEtcDao.class);
		 
		Integer count = productEtcDao.readWish(aid, pid);
		if(count == null) {
			productEtcDao.createWish(aid, pid, inputcount);
		}else {
			int nc = count+inputcount;
			productEtcDao.updateWish(aid, pid, nc);
		}
		model.addAttribute("Flag",1); 
		model.addAttribute("Flagmsg","상품을 성공적으로 담았습니다."); 
		return "failedRedirect";
	}
	
	@RequestMapping(value="/deleteWish")
	public String deleteWish(HttpSession session,Model model,HttpServletRequest request) {
		int aid = (int) session.getAttribute("Aid");
		int pid = Integer.parseInt(request.getParameter("pId"));
		
		ProductEtcDao productEtcDao = sqlSession.getMapper(ProductEtcDao.class);
		productEtcDao.deleteWish(aid, pid);
		return "redirect:wishlist"; 
	}

	
	@RequestMapping(value="/buyWish")
	public String buyWish(HttpSession session,Model model,HttpServletRequest request) {
		int aid = (int) session.getAttribute("Aid");
		
		ProductEtcDao productEtcDao = sqlSession.getMapper(ProductEtcDao.class);
		productEtcDao.deleteAllWish(aid);
		
		model.addAttribute("Flag",2); 
		model.addAttribute("Flagmsg","상품이 구매되었습니다."); 
		return "failedRedirect";
	}

	
	
	// 김성빈이꺼
	

	//강아지 추가
	@RequestMapping(value = "/DogAdd")
	public String DogAdd(Model model) {

		
		
		ArrayList<DogBreedsDto> AdogBreeds = new ArrayList<>();
		DogBreedsDao dogbreedsDao = sqlSession.getMapper(DogBreedsDao.class);
		
		AdogBreeds = dogbreedsDao.dblistDao();
		
		model.addAttribute("dogbreedslist",AdogBreeds);
		//System.out.println(AdogBreeds.get(0));
		return "dogAdd";
	}
	

	//강아지 추가확인
	@RequestMapping(value = "/DogAddOk")
	public String DogAddOk(HttpSession session,HttpServletRequest request, Model model, @RequestPart MultipartFile uploadFiles) throws IllegalStateException, IOException {
		int iId = saveFile(uploadFiles);
		int Aid = Integer.parseInt(session.getAttribute("Aid").toString()); 


		String dBreeds = request.getParameter("dogBreeds");
		String dName = request.getParameter("dogName");
		int dGender = Integer.parseInt(request.getParameter("dogGender"));
		String dAge = request.getParameter("dogAge");
		
		DogDao dogDao = sqlSession.getMapper(DogDao.class);
		
		dogDao.DogAddDao(Aid, dBreeds, dName, dGender, dAge, iId);
		
		
		return "redirect:index";
	}
	
	
	
	
	//개삭제
	@RequestMapping(value = "/DogDelete")
	public String DogDelete(HttpServletRequest request, Model model) { 
		
		int dId = Integer.parseInt(request.getParameter("dId"));
		
		DogDao dogDao = sqlSession.getMapper(DogDao.class);
		
		dogDao.DogDeleteDao(dId);
		
		return "redirect:DogList";
	}
	
	
	//개 목록
	@RequestMapping(value = "/DogList")
	public String DogList(HttpSession session,HttpServletRequest request, Model model) throws IllegalStateException, IOException {
		 

		if(session.getAttribute("Aid") == null) { 
			return "redirect:account_Login";
		}
		
		int Aid = Integer.parseInt(session.getAttribute("Aid").toString()); 
		
		ArrayList<DogDto> doglist = new ArrayList<>();
		
		DogDao dogDao = sqlSession.getMapper(DogDao.class);
		
		doglist = dogDao.doglistdao(Aid);

		ArrayList<DogListDto> dogarlist = new ArrayList<>();
		
		for(int x=0;x<doglist.size();x++) {
			DogDto olddto = doglist.get(x);
			String url = loadFile(olddto.getiId());
			DogListDto newdto = new DogListDto(olddto.getdId(),olddto.getdBreeds(),olddto.getdName(),olddto.getdGender(),olddto.getdAge(),url);
			dogarlist.add(newdto);
		}
		//int dId, String dBreeds, String dName, int dGender, String dAge, int iUrl
		
		
		model.addAttribute("doglist", dogarlist);
		
		//System.out.println(dogarlist.get(0).getdName());
	
		return "dogList";
	}
	 
	
	
	
	
	
	/// 여끼까지
	
	
	//임정주 코드
	


	   /*상품 등록*/   
	   @RequestMapping(value = "/Product_AddOk", method = RequestMethod.POST)
	   
	   public String Product_AddOk(HttpServletRequest request, Model model, @RequestPart MultipartFile uploadFiles)  throws IllegalStateException, IOException {

	      int iid = saveFile(uploadFiles);
	      String pname = request.getParameter("PNAME");
	      int pprice = Integer.parseInt(request.getParameter("PPRICE"));
	      String pdesc = request.getParameter("PDESC");
	      
	      int dogSize = Integer.parseInt(request.getParameter("dogSize"));
	      int dogGender = Integer.parseInt(request.getParameter("dogGender"));
	      int dogAge =Integer.parseInt(request.getParameter("dogAge"));
	      
	      ProductDao productDao = sqlSession.getMapper(ProductDao.class);      
	      
	      productDao.product_Add(pname, pprice, pdesc, iid);
	      
	      int pid = productDao.product_FindId(pname); 
	      

	      if(pid==0) {
			model.addAttribute("Flag",1); 
			model.addAttribute("Flagmsg","등록 실패하셨습니다.."); 
			return "failedRedirect";
	         
	      }
	      
	      
	      ProductEtcDao productEtcDao = sqlSession.getMapper(ProductEtcDao.class);      


	      productEtcDao.addTag(pid, dogSize);
	      productEtcDao.addTag(pid, dogGender);
	      productEtcDao.addTag(pid, dogAge);

	      
	      return "redirect:index";
	      }
	   

	   /*상품 관리창*/
	   @RequestMapping(value = "/go_management")
	   
	      public String go_update(HttpServletRequest request, Model model){
	      
	      int PID = Integer.parseInt(request.getParameter("pid"));
	      
	      ArrayList<ProductDto> proMana = new ArrayList<>();
	      
	      ProductDao ProductDao = sqlSession.getMapper(ProductDao.class);

	      proMana = ProductDao.product_Manage(PID);
	      
	      model.addAttribute("proMana", pArrToPlArr(proMana));

	      return "Product_Management";
	      }
	   
	   
	   /*상품 관리창에서 삭제*/
	   @RequestMapping(value = "/Prodelete_btn")
	   
	      public String Prodelete_btn(HttpServletRequest request, Model model){
	      
	      int PID = Integer.parseInt(request.getParameter("pid")); 
	   
	      ProductDao ProductDao = sqlSession.getMapper(ProductDao.class);
	   
	      ProductDao.product_Delete(PID);
	      
	   
	      return "redirect:index";
	      }
	   
	   /*상품 관리창에서 수정으로 이동*/
	   @RequestMapping(value = "/Proupdate_btn")
	   public String Proupdate_btn(HttpServletRequest request, Model model){
	      
	      int PID = Integer.parseInt(request.getParameter("pid")); 
	      
	      ArrayList<ProductDto> proMana = new ArrayList<>();
	      
	      ProductDao ProductDao = sqlSession.getMapper(ProductDao.class);

	      proMana = ProductDao.product_Manage(PID);
	      
	      model.addAttribute("proMana", pArrToPlArr(proMana));
	      
	      return "Product_Update";
	      }
	   
	   /*수정창에서 수정 완료하기*/
	   @RequestMapping(value = "/ProupdateOk_btn")
	   public String ProupdateOk_btn(HttpServletRequest request, Model model){
	      
	      int PID = Integer.parseInt(request.getParameter("pid"));
	      String PNAME =(request.getParameter("name_text"));
	      int PPRICE =  Integer.parseInt(request.getParameter("price_text"));
	      String PDESC =(request.getParameter("desc_text"));
	      
	      
	      ProductDao ProductDao = sqlSession.getMapper(ProductDao.class);
	      
	      ProductDao.product_Update(PID,PNAME,PPRICE,PDESC);   

	      return "redirect:index";
	   }
	   
	   /*상품 설명창에 상품 목록 정보 가져와서 넣기(List >>>> explain)*/
	   @RequestMapping(value = "/go_explain")
	   public String go_explain(HttpServletRequest request, Model model){
	      
	      int PID = Integer.parseInt(request.getParameter("pid"));
	       
	      
	      ProductDao ProductDao = sqlSession.getMapper(ProductDao.class);
	      
	      ProductDto proexplain = ProductDao.product_Explain(PID);
	      
	      model.addAttribute("pro", PtoPl(proexplain)); 
	      return "explain";
	}
 
	   
	   
	   
	   
	   
	   // 여기까지
 
	 
	
	private int saveFile(MultipartFile Files) throws IllegalStateException, IOException {
		int iid = 1;
		
		
		if(Files.isEmpty()) {
			return iid;
		}else { 
			String orifilename = Files.getOriginalFilename();//원래 파일의 이름 가져오기
			String fileextension = FilenameUtils.getExtension(orifilename).toLowerCase();//확장자 가져오기(소문자로 변환)
			String fileurl = "D:\\springboot_workspace\\projectSGSG\\src\\main\\resources\\static\\uploadfiles\\";
			String filename;//변경된 파일의 이름(서버에 저장되는 파일의 이름)
			File desinationFile;//java.io의 파일관련 클래스
			 
			do {
			filename = RandomStringUtils.randomAlphanumeric(32) + "." + fileextension;
			//영문대소문자와 숫자가 혼합된 랜덤 32자의 파일이름을 생성한 후 확장자 연결하여 서버에 저장될 파일의 이름 생성			
			desinationFile = new File(fileurl+filename);
			}while(desinationFile.exists());//같은 이름의 파일이 저장소에 존재하면 true 출력
			
			desinationFile.getParentFile().mkdir();
			Files.transferTo(desinationFile);
			
			ImageDao imageDao = sqlSession.getMapper(ImageDao.class);
			imageDao.fileInsert(filename, orifilename, fileurl, fileextension);
			
			iid = imageDao.GetFileId(filename);
			
			return iid;
		}
		
	}
	
	private String loadFile(int iId) {
		ImageDao dao = sqlSession.getMapper(ImageDao.class);
		ImageDto dto = dao.GetImageInfo(iId); 
		return dto.getiFilename();
	}
	
	private ProductListDto PtoPl(ProductDto dto) { 
		ProductListDto pldto = new ProductListDto(dto.getpId(), dto.getpName(), dto.getpPrice(), dto.getpDesc(), loadFile(dto.getiId()));
		return pldto;
	}
	
	private ArrayList<ProductListDto> pArrToPlArr(ArrayList<ProductDto> arr){
		ArrayList<ProductListDto> listarr = new ArrayList<>();
		for(ProductDto dto : arr){
			listarr.add(PtoPl(dto));
		}
		return listarr;
	}
	
	
	
	
	
}
