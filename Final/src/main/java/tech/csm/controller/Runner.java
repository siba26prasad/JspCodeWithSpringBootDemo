package tech.csm.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lowagie.text.DocumentException;

import tech.csm.bean.AsesmentMark;
import tech.csm.entity.BatchDetailsBean;
import tech.csm.pdf.PdfGeneratorBatchDetails;
import tech.csm.service.AssesmentMarkService;
import tech.csm.service.BatchAllocatedService;
import tech.csm.service.BatchMasterService;
import tech.csm.service.EmployeeMasterService;
import tech.csm.service.TechnologyService;

@Controller
public class Runner {

	@Autowired
	private BatchMasterService batchMasterService;

	@Autowired
	private BatchAllocatedService batchAllocatedService;

	@Autowired
	private EmployeeMasterService employeeMasterService;

	@Autowired
	private TechnologyService technologyService;

	@Autowired
	private AssesmentMarkService assesmentMarkService;

	@Autowired
	HttpSession session;

	@RequestMapping(path = "/getForm")
	public String getRegdForm(Model model,
			@ModelAttribute("batchDetailsBean") BatchDetailsBean batchDetailsBean/*
																					 * ,@ModelAttribute(
																					 * "batchFilterBean")
																					 * BatchDetailsBean bean
																					 */) {
		List<BatchDetailsBean> batchList = null;
		List<BatchDetailsBean> technologyList = null;
		try {
			batchList = batchMasterService.getAllBatch();
			technologyList = technologyService.getAllTechnology();
			model.addAttribute("batchList", batchList);
			model.addAttribute("technologyList", technologyList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "form";
	}

	@ResponseBody
	@RequestMapping("/fetchEmployeeListByTechIdAndBatchId")
	private List<BatchDetailsBean> fetchEmployeeListByTechIdAndBatchId(@RequestParam("technologyId") String techId,
			@RequestParam("batchId") String batchId) {
		List<BatchDetailsBean> employeeList = null;

		try {
			employeeList = employeeMasterService.fetchEmployeeListByTechIdAndBatchId(techId, batchId);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return employeeList;
	}

	@RequestMapping("/saveEmployeeMark")
	private String saveEmployeeMark(Model model, @ModelAttribute("batchDetailsBean") BatchDetailsBean batchDetailsBean,
			RedirectAttributes rd) {

		String msg = "";
		AsesmentMark asesmentMark = null;
		try {

			asesmentMark = assesmentMarkService.getMarkDetailsByEmpId(batchDetailsBean);
			if (asesmentMark != null) {
				rd.addFlashAttribute("msg", "Employee Mark Already Exists");
				model.addAttribute("msg", "Employee Mark Already Exists");
			} else {

				asesmentMark = assesmentMarkService.saveEmployeeMark(batchDetailsBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "forward:/getForm";

	}

	@RequestMapping(path = "/filter")
	public String filter(Model model, /*
										 * @RequestParam("filterBatchId") String
										 * batchId @ModelAttribute("batchFilterBean") BatchDetailsBean bean
										 */
			@ModelAttribute("batchDetailsBean") BatchDetailsBean bean) {

		List<BatchDetailsBean> batchDeatailsList = null;
		String uBatchId = "";
		try {

// if else is rquired to fetchAllBatchlist 
//			if (batchId == "0") {
//				batchDeatailsList = assesmentMarkService.getAllBatchDetails();
//				session.setAttribute("batchDeatailsList", batchDeatailsList);
//			} else {  
//		    }
			session.invalidate();
//			batchDeatailsList = assesmentMarkService.getAllBatchDetails(Integer.valueOf(batchId));
			batchDeatailsList = assesmentMarkService.getAllBatchDetails(bean.getUBatchId());

			session.setAttribute("batchDeatailsListPdf", batchDeatailsList);
			model.addAttribute("batchDeatailsList", batchDeatailsList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "forward:/getForm";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/downloadPdf")
	public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {

		List<BatchDetailsBean> listofBatch = null;
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=student" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		listofBatch = (List<BatchDetailsBean>) session.getAttribute("batchDeatailsListPdf");
		PdfGeneratorBatchDetails generator = new PdfGeneratorBatchDetails();
		generator.generate(listofBatch, response);
	}

	// added by siba prasad rout on 24-05-2023 for texting _blank

	@RequestMapping("/farmerRegStatusPortalReportDrillDown")
	public String getPrintPdf(Model model, @RequestParam("pdfValue") String pdfId) {
		List<BatchDetailsBean> batchDeatailsList = null;
		String uBatchId = "1";
		try {

// if else is rquired to fetchAllBatchlist 
//			if (batchId == "0") {
//				batchDeatailsList = assesmentMarkService.getAllBatchDetails();
//				session.setAttribute("batchDeatailsList", batchDeatailsList);
//			} else {  
//		    }
			session.invalidate();
//			batchDeatailsList = assesmentMarkService.getAllBatchDetails(Integer.valueOf(batchId));
			batchDeatailsList = assesmentMarkService.getAllBatchDetails(Integer.valueOf(uBatchId));

			session.setAttribute("batchDeatailsListPdf", batchDeatailsList);
			model.addAttribute("batchDeatailsList", batchDeatailsList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "printForm";
	}

}
