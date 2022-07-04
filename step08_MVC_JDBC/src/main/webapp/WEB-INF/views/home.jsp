<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>VIEW.jsp</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  </head>
  <body>
  	<form>
  	<input name="deptno" placeholder="deptno"><br>
  	<input name="dname" placeholder="dname"><br>
  	<input name="loc" placeholder="loc"><br>
    <input type="submit" value="전송">
    </form>
    <script>
      //    axios
      //      .get('http://localhost:8080/jdbc/api/dept')
      //      .then((response) => console.log(response.data));
      
      
      
      //이하 일반 방식 전달
      const params = new URLSearchParams();
      params.append('deptno', 110);
      params.append('dname', 'insertDept');
      params.append('loc', 'postFunction');
      axios
        .post('http://localhost:8080/jdbc/api/deptform', params)
        .then(function a(response) {
          console.log(response);
        });
      
      
      //이하 json방식 전달
      const data = {
        deptno: 100,
        dname: 'JSON',
        loc: 'SPRING',
      };
      const config = {
        headers: {
          'Content-Type': 'application/json',
        },
      };
      const jsonData = JSON.stringify(data);
      axios
        .post('http://localhost:8080/jdbc/api/deptjson', jsonData, config)
        .then((response) => {
          console.log(response);
        });
      
    </script>
  </body>
</html>
