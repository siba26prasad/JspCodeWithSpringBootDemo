<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mark Entry Form</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"
	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/3f5992c71f.js"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css" />
<!-- data table js -->
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script src="js/sweetalert2.all.js"></script>
<style type="text/css">
.content {
	background-color: #17a2b826;
}

.container {
	background-color: #95949438;
}
</style>
</head>
<body>

	<div class="container mt-4">
		<div>
			<c:if test="${not empty msg}">
				<p class="alert alert-success">${msg}</p>
				<c:remove var="msg" scope="session" />
			</c:if>
		</div>
		<div class="content">
			<h3 class="text-danger form-group w-50 m-auto text-center">Mark
				Entry Form</h3>
			<form:form class="form-group w-50 m-auto" method="post"
				action="saveEmployeeMark" id="billform"
				modelAttribute="batchDetailsBean">


				<div class="row">
					<div class="m-auto w-50">
						<lable class=" font-weight-bold ">Select Batch</lable>
						<form:select path="batchId" id="batchNameId" class="form-control ">
							<form:option value="0">Select</form:option>
							<form:options items="${batchList}" itemValue="batchId"
								itemLabel="batchName" />
						</form:select>
					</div>
				</div>

				<div class="row">
					<div class="w-50 m-auto">
						<lable class="font-weight-bold">Select Technology</lable>
						<form:select path="technologyId" id="technologyNameId"
							class="form-control">
							<form:option value="0">Select</form:option>
							<form:options items="${technologyList}" itemValue="technologyId"
								itemLabel="technologyName" />
						</form:select>

					</div>
				</div>

				<div class="row">
					<div class=" w-50 m-auto">
						<lable class="  font-weight-bold ">Select Employee Name</lable>
						<form:select path="empId" id="employeeId" class="form-control">
							<form:option value="0">Select</form:option>
						</form:select>
					</div>
				</div>

				<div class="row">
					<div class="m-auto w-50">
						<lable class="font-weight-bold ">Enyter Mark</lable>
						<form:input type="text" path="mark" id="markId"
							class="form-control" />
					</div>
				</div>


				<div class="row mt-3">
					<div class="text-center  m-auto col-md-2">
						<input type="submit" class="btn btn-success" id="submitId">
					</div>

				</div>
			</form:form>
		</div>
		<div class="content" style="">
			<form:form action="/filter" method="POST"
				modelAttribute="batchDetailsBean">

				<div class="row mt-4">
					<div class="col-md-1"></div>
					<div class="col-md-3">
						<lable class="font-weight-bold mt-1">SELECT BATCH NAME<sup
							class="text-danger">*</sup></lable>

					</div>


					<div class="w-50 m-auto col-md-3">
						<%-- <select class="form-control" name="filterBatchId" id="batchId">
							<option value="0">-select-</option>
							<c:forEach items="${batchList}" var="itm">
								<option value="${itm.batchId}"
									<c:if test="${batchDeatailsList.get(0).batchId eq itm.batchId}"> selected="selected"</c:if>>${itm.batchName}</option>
							</c:forEach>
						</select> --%>
						<form:select path="uBatchId" id="batchId" class="form-control">
							<form:option value="0">Select</form:option>
							<form:options items="${batchList}" itemValue="batchId"
								itemLabel="batchName" />
						</form:select>

					</div>



					<div class="col-md-3" style="">
						<input type="submit" id="btmId" class="btn btn-success"
							value="SHOW REPORT">

					</div>
					<div class="col-md-1"></div>
				</div>
			</form:form>
		</div>


		<table class="table table-bordered mt-4" id="book_data">
			<thead bgcolor="#FF9A46">
				<tr>

					<th>Sl#</th>
					<th>Batch Name</th>
					<th>Batch Start Date</th>
					<th>Technology Name</th>
					<th>Employee Name</th>
					<th>Employee Phone</th>
					<th>Mark</th>
					<th>Grade</th>
					<th>Status</th>


				</tr>

			</thead>
			<tbody bgcolor="#FFFFFF">
				<c:if test="${not empty batchDeatailsList }">
					<c:forEach var="batchDetails" items="${batchDeatailsList}"
						varStatus="counter">
						<tr>

							<td>${counter.count}</td>
							<td>${batchDetails.batchName}</td>
							<td>${batchDetails.batchStartDate}</td>

							<td>${batchDetails.technologyName}</td>
							<td>${batchDetails.employeeName}</td>
							<td>${batchDetails.employeePhone}</td>
							<td>${batchDetails.mark}</td>
							<td>${batchDetails.grade}</td>
							<td>${batchDetails.status}</td>

						</tr>
					</c:forEach>
				</c:if>
			</tbody>

		</table>
		<c:if test="${not empty batchDeatailsList }">
			<div class="row">

				<div class="col-md-4"></div>
				<div class="col-md-4 " style="background-color: #FFD6D6">
					<!-- <a class="btn border font-weight-bold" href="downloadPdf">DOWNLOAD IN PDF FORMAT</a> -->
					<a class="btn border font-weight-bold" href="" id="pdf"
						onclick="getPdf('dd1')">DOWNLOAD IN PDF FORMAT</a>
					<!-- -->
				</div>
				<div class="col-md-4"></div>
				<!--<div style="float: right; margin-bottom: 15px; color: blue">
								 <div style="cursor: pointer;" id="pdf_download">
														<i class="fa fa-download" aria-hidden="true"
															style="font-size: 36px"></i>
								</div> -->


			</div>
		</c:if>
		<c:if test="${empty batchDeatailsList}">
			<div class="text-center">
				<b style="color: red">No Record(s) Found</b>
			</div>
		</c:if>
		<form method="post" action="farmerRegStatusPortalReportDrillDown"
			name="farmerReportPrintPreview" target="_blank">
			<input type="hidden" name="pdfValue" id="pdfNewId">
			
		</form>


		<%-- </c:if> --%>
	</div>


</body>

<script type="text/javascript">
	$(document).ready(function() {
	});

	$("#technologyNameId")
			.on(
					"change",
					function() {
						debugger;
						var techId = $(this).val();
						var batchId = $("#batchNameId").val();
						if (batchId == "0") {

							/* $('#technologyNameId option:first').attr('selected','selected'); */
							$("#technologyNameId option:selected").prop(
									"selected", false);
							/* 							$("#technologyNameId option:first").prop("selected", "selected");
							 */$("#batchNameId").focus();

							swal("Error", "Please Select Batch Name", "error");
							return false;
						} else {
							$
									.ajax({
										type : "POST",
										url : "fetchEmployeeListByTechIdAndBatchId",
										data : {
											technologyId : techId,
											batchId : batchId

										},
										success : function(response) {
											debugger;
											//console.log(response);
											var len = response.length;
											var html = '';
											html += '<option value="0">Select</option>';
											for (var i = 0; i < len; i++) {

												html += '<option value="'+response[i].empId+'">'
														+ response[i].employeeName
														+ '</option>';

											}
											$("#employeeId").empty();
											$("#employeeId").append(html);

										},
										error : function(err) {
											console.log(err);
										}

									});
						}
					});

	$("#submitId").on('click', function() {

		var batchId = $("#batchNameId").val();
		var techId = $("#technologyNameId").val();
		var empId = $("#employeeId").val();
		var mark = $("#markId").val();

		if (batchId == '0') {

			$("#batchNameId").focus();
			swal("Error", "Please Select Batch Name", "error");
			return false;

		} else if (techId == '0') {

			$("#technologyNameId").focus();
			swal("Error", "Please Select Technology Name", "error");
			return false;

		} else if (empId == '0') {

			$("#employeeId").focus();
			swal("Error", "Please Select Employee Name", "error");
			return false;

		} else if (mark.length == 0) {

			$("#markId").focus();
			swal("Error", "Please Enter Mark", "error");
			return false;

		} else {
			return true;
		}

	})

	$("#btmId").on("click", function() {
		debugger;
		var batchId = $("#batchId").val();
		if (batchId == '0') {

			$("#batchId").focus();
			swal("Error", "Please Select Batch Name", "error");
			return false;
		}

	})
	function getPdf(value) {
		debugger;
		//$("#pdfNewId").val(value);
		$("form[name='farmerReportPrintPreview']").submit();
		//e.prin
	}

	/* $(function() {
		$("#book_data").dataTable();
	}); */
</script>
</html>