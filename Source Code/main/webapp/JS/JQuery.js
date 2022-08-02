$(document).ready(function(){
 	 $("#myInput").on("keyup", function() {
    	var value = $(this).val().toLowerCase();
    	$("#myList tr").filter(function() {
     	 $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    	});
  	});
		});
function getvalueEdit(clicked_id){
	  		var number=document.getElementById("qte").value;  
	  		document.getElementById("qteCmd").max = number;
            var values = clicked_id;
              
              document.getElementById("codeArt").value = values;
          }