<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resource/css/style.css" />">
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
<title>Welcome</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<img
					src="<spring:url value="/resource/images/logo2.jpg"  htmlEscape="true" />"
					alt="Logo" />
				<h1>${greeting}</h1>
				<p>${tagline}</p>


			</div>

			<div class="container">
				<c:choose>
					<c:when test="${empty user}">
						<a href="<spring:url value='/login' />"
							class="btn btn-default pull-right"> Login</a>
					</c:when>
					<c:otherwise >
						<c:choose>
							<c:when test="${user.userCredentials == 'admin'}">
								<a href="<spring:url value="/users/add" />"
							class="btn btn-default pull-right">Add User</a>
							</c:when>
						</c:choose>
						<a href="<spring:url value="/users" />"
							class="btn btn-default pull-right">User List</a>
						<br>
						<a href="<spring:url value='/logout' />"
							class="btn btn-default pull-right"> Logout</a>

					</c:otherwise>
				</c:choose>
				<a href="<spring:url value='/users' />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span> Go to Community
				</a>
			</div>
			<div class="pull-left">
				<h3>${SpecialBlurb}</h3>
			</div>

		</div>
		<c:choose>
			<c:when test="${!empty user}">

				<div class="col-xs-4 col-xs-offset-4">
					<br /> <br />
					<div id="wrapper">
						<div id="menu">
							<p class="welcome">
								Welcome, ${user.firstName}! <b></b>
							</p>
							<p class="logout">
								<a id="exit" href="<spring:url value='/logout' />">Exit Chat</a>
							</p>
							<div style="clear: both"></div>
						</div>
						<div id="chatbox">

							<c:choose>
								<c:when test="${!empty msgToBeAdded}">${user.firstName} @ ${msgToBeAdded.receiver.firstName}:  ${msgToBeAdded.message}</c:when>
							</c:choose>
						</div>
						<form id="msgtext" name="message" modelAttribute="newMessage"
							action="<spring:url value="/sendMsg"></spring:url>" method="post"
							class="form-signin">
							<sec:csrfInput />
							<fieldset>
							
								<div class="form-group">
									<div class="checkbox">

										<c:forEach items="${users}" var="m_user">
											<c:choose>
												<c:when test="${user.id != m_user.id}">
													<label> <input name="receiver.id" type="checkbox" data-id="${user.id}"
														value="${m_user.id}" />${m_user.firstName}
													</label><br>
													
												</c:when>
											</c:choose>
										</c:forEach>

									</div>
									
									<div class="form-group">
										<label for="InputMessage">Message</label>
										<div class="input-group">
											<!-- nput name="usermsg" type="text" id="usermsg" size="63" />
											<input name="message" type="text" class="form:input-large"/> -->
											<textarea name="message" class="form-control" rows="5"
												cols="12" required></textarea>
											<!-- <span class="input-group-addon"><i
											class="glyphicon glyphicon-ok form-control-feedback"></i></span>-->
										</div>
									</div>
								</div>
								<input type="hidden" name="sender.id" value="${user.id}" />

								<!--<form:hidden id="sender" path="${user.id}"/>		-->
								<input class="btn btn-lg btn-primary btn-block" name="submitmsg"
									type="submit" id="submitmsg" value="Send" /> <br />
								<br />
								<br />
							</fieldset>
						</form>

					</div>
					<br />
					<br />
					<br />
				</div>
			</c:when>
		</c:choose>
	</section>


</body>
</html>
