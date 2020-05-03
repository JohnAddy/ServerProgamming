<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="persist.Kysymykset"%>
<%@page import="persist.Vastaukset"%>
<%@page import="persist.Ehdokkaat"%>
<%@page import="services.Question"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
	Ehdokkaat user = (Ehdokkaat) session.getAttribute("user");

if (user == null) {
	response.sendRedirect("candidate.jsp");

}
Question question = new Question(user);
List<Kysymykset> all= question.All();

%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="candidatescript.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<%

		List<Integer> nums = new ArrayList<Integer>(){
			{
				add(1); 
                add(2); 
                add(3); 
                add(4); 
                add(5); 
			}
		};
		
for (Kysymykset one: all){
	Vastaukset ans = question.Answer(one);
	int selected = ans.getVastaus();
	int name = one.getKysymysId();
	
	
	%>

		<p class="ans" data-num="<%=selected %>" data-name="vastaus<%=name %>"><%= one.getKysymys()%></p>
		<%
			for (Integer num: nums){
				if(selected == num){
					%>
		<label><%=num %></label><input type="radio" name="vastaus<%=name %>"
			value="<%=num %>" checked="checked" />
		<% 
				}else{
					%>
		<label><%=num %></label><input type="radio" name="vastaus<%=name %>"
			value="<%=num %>" />
		<% 
				}
			}
			%>


		<%
}
%>
		<input type="button" name="ok" value="Send"
			onclick="sendAns(this.form);"><br>
	</form>
</body>
</html>