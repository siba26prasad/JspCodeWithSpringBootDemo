
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>

<html>
<head>
<title>Print Document</title>
<link href="assets/css/portalprint.css" rel="stylesheet" type="text/css" />
<script src="assets/js/portal/clock.js"></script>
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="bottomBorder">
		<tbody>
			<tr>
				<td height="70" align="left" valign="top"><img
					src="/assets/images/portal/printlogonew.gif" width="547"
					height="71">
					<div id="clock" align="right" valign="bottom"
						style="font-size: 12px;"></div></td>
			</tr>
		</tbody>
	</table>
	<hr>
	<div id="printHeader">Farmer Registration Status Report</div>
	<div>

		<div id="UpdPanel">

			<div id="autoFit" style="overflow: auto;">
				<div id="dvStatus">
					<div class="viewTable" id="viewTable">

						<table class="table table-bordered table-hover"
							id="farmerRegStatusReportDrillDownTblId">
							<thead>
								<tr>
									<td class="extd" colspan="1" rowspan="2" style="width: 3%;">Sl.No.</td>
									<td class="extd" colspan="1" rowspan="2" style="width: 15%;">PACS
										Name</td>
									<td class="extd" colspan="1" rowspan="2" style="width: 10%;">Code</td>
									<td class="extd" colspan="1" rowspan="2" style="width: 10%;">Mobile</td>
									<td class="extd" colspan="1" rowspan="2" style="width: 15%;">Secretary
										Name</td>
									<td class="extd" colspan="3" rowspan="1" style="width: 20%;">Total
										No. of Cultivators Registered</td>
									<td class="extd" colspan="1" rowspan="2" style="width: 30%;">Aadhaar
										Card</td>
								</tr>
								<tr>
									<th align="right" scope="col">New</th>
									<th align="right" scope="col">Renewed</th>
									<th align="right" scope="col">Total</th>
								</tr>
							</thead>
							<c:set var="totalNewFarmer" value="0" />
							<c:set var="totalRenewFarmer" value="0" />
							<c:set var="total" value="0" />
							<c:set var="totalAadhaar" value="0" />

							<tbody>
								<c:forEach var="listValue"
									items="${farmerRegStatusDataListPrint}" varStatus="myIndex">

									<tr>
										<td><c:out value="${(myIndex.index)+1}"></c:out></td>
										<td>${listValue.PACSName}</td>
										<td style="color: Blue; font-weight: bold;">${listValue.pacsCode}</td>
										<td>${listValue.mobile}</td>
										<td>${listValue.secreteryName}</td>
										<td>${listValue.newCultivaltorRegistered}</td>
										<td>${listValue.renewedCultivaltorRegistered}</td>
										<td>${listValue.totalCultivaltorRegistered}</td>
										<td>${listValue.noOfAadhaar}</td>

										<c:set var="totalNewFarmer"
											value="${listValue.newCultivaltorRegistered}" />
										<c:set var="totalRenewFarmer"
											value="${listValue.renewedCultivaltorRegistered}" />
										<c:set var="total"
											value="${listValue.totalCultivaltorRegistered}" />
										<c:set var="totalAadhaar" value="${listValue.noOfAadhaar}" />
									</tr>

								</c:forEach>
							</tbody>
							<tfoot>
								<tr class="ftrow">
									<td colspan="4"></td>
									<td>Total</td>
									<td><c:out value="${totalNewFarmer}"></c:out></td>
									<td><c:out value="${totalRenewFarmer}"></c:out></td>
									<td><c:out value="${total}"></c:out></td>
									<td><c:out value="${totalAadhaar}"></c:out></td>


								</tr>
							</tfoot>

						</table>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div align="center" class="copy">
		Copy ©&nbsp; 2016-17&nbsp; <strong>www.foododisha.in</strong>&nbsp;
		Odisha, All Rights Reserved
	</div>
</body>
</html>