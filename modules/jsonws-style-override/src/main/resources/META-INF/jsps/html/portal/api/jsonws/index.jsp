<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portal/api/jsonws/init.jsp" %>

<c:if test="<%= PropsValues.JSONWS_WEB_SERVICE_API_DISCOVERABLE %>">
	<style>
		<%@ include file="/html/portal/api/jsonws/css.jspf" %>
	</style>

	<div class="pt-0" id="wrapper">
		<header id="banner" role="banner">
			<div id="heading">
				<h1 class="align-items-center d-flex m-2 site-title">
					<a class="logo mr-2" href="<%= HtmlUtil.escapeAttribute(jsonWSContextPath) %>" title="JSONWS API">
						<img alt="<%= HtmlUtil.escapeAttribute("JSONWS API") %>" height="50px" src="<%= HtmlUtil.escape(themeDisplay.getCompanyLogo()) %>" width="auto" />
					</a>

					<span class="site-name">
						JSONWS API
					</span>
				</h1>
			</div>
		</header>

		<div id="content">
			<div id="main-content">
				<div class="container-fluid">
					<aui:row>
						<aui:col cssClass="lfr-api-navigation pt-3" width="<%= 25 %>">
							<liferay-util:include page="/html/portal/api/jsonws/actions.jsp" />
						</aui:col>

						<aui:col cssClass="lfr-api-details pt-3" width="<%= 75 %>">
							<liferay-util:include page="/html/portal/api/jsonws/action.jsp" />
						</aui:col>
					</aui:row>
				</div>
			</div>
		</div>

		<footer class="mt-0" id="footer" role="contentinfo">
			<p class="m-0 p-2 powered-by">
				<liferay-ui:message key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
			</p>
		</footer>
	</div>

	<aui:script>
		AUI().ready(
			function() {
				var container = $('#main-content .lfr-api-navigation');
				var selected = $('#services .lfr-api-signature.selected')

				var scrollTop = selected.offset().top - container.children().offset().top;

				container.animate({scrollTop: scrollTop})
			}
		);
	</aui:script>
</c:if>