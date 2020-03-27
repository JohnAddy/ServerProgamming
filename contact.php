<?php include 'header.php' ?>
<style>
body{
  background-color:#353a40;
}
  input[type=text], select, textarea {
    width: 100% ;
    padding: 14px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
  }
  
    
  
  input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 8px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
   
  
  input[type=submit]:hover {
    background-color: #45a049;
  }

 h{
    color: #000;
    margin-left: 24%;
    font-size: 60px;
    border-bottom: 2px;
    padding-top: 10px;
    
}
h1{
    margin-left: 30%;
}


  
   .container {
    border-radius: 10px;
    background-color: #f2f2f2;
    padding: 20px;
    margin-top: 20px;
    margin-left: 100px;
    margin-right: 100px;
    margin-bottom: 20px;
  }

h3 {
    color: #000;
    margin-left: 33%;
    margin-top: 150px;
    font-size: 65px;
    margin-bottom: 50px;
    border-bottom: 2px;
    border-bottom-color: #fff;
   
}
p1{
    margin-left: 22%;
font-style: oblique;
    font-size: 30px;
}
p2{

    margin-left: 33%;
    font-size: 30px;
    font-style: oblique;
    padding-top: 10%;
}
p2 :hover{
    color:blue;
    background-color: gainsboro;
}


p3{
    margin-top: 10%;
    margin-left: 28%;
    font-size: 30px;
    font-style: oblique;  
}
p3 :hover{
    color: blue;
    background-color:gainsboro;
}

p5{
    padding: center;
    margin-left: 25%;
    
}
p5:hover{
    border-color:black;
    padding: 2px;
    width: 800px;
    height: 200px;
}
</style>
<!DOCTYPE html>
 <html lang="en">
   <html>
 <head>
   <title>MAMA RESTAURANT</title>
   
   <meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
	<link rel="icon" type="image/png" href="images/icons/favicon.png"/>

    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    
   
   
    <link rel="stylesheet" href="CONTA.css"> 
   

   
 </head>
 <body>
 
 
 
 

<div class="container">
  <div class="text">
   <h aling="center"> "Have Any Question?</h>

   <h1>We'd Love to Hear From You."</h>
               
</div>


  <form action="/action_page.php">
    <label for="firstname">First Name</label>
    <input type="text" id="firstname" name="firstname" placeholder="Write your first name..">

 

    <label for="lastname">Last Name</label>
    <input type="text" id="lastname" name="lastname" placeholder="write your last name..">

    <label for="emailadd">Email Address</label>
    <input type="text" id="emailadd" name="email address" placeholder="write your email..">

 

    <label for="country">Country</label>
    <select id="country" name="country">
    <option value="finland">Finland</option>
      <option value="bangladesh">Bangladesh</option>
      <option value="iraq">Iraq</option>
      <option value="india">India</option>
      <option value="ghana">Ghana</option>
    </select>
    

 

    <label for="rev">Review</label>
    <textarea id="rev" name="review" placeholder="Drop us a line using the form below. We'll be in touch as soon as possible..." style="height:200px"></textarea>

 

    <input type="submit" value="Submit">
  </form>
  
  
</div>
                     <div>
                         <h3 class="section-title">Contact Details</h3>
                           
                            <div><p2>Call Us On <a href="#">+358 (0)44 425 0212</a></p2></div>
                            <div><p3>"Email us at" <a href="#"> Info@mamarestaurant.fi </a>
                            </p3></div>

                        </div>



 

</body>
</html>
<?php include 'footer.php' ?>
