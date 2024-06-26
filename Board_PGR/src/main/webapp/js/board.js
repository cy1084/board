setInterval(currentTime, 1000);

function currentTime(){
	let current = new Date();
	document.getElementById("currentTime").innerHTML = current.toLocaleString();	
}


window.onload = function(){
	var check = document.getElementsByName("check"); 
	var allCheck = document.getElementById("allCheck");
	
	for(let i=0; i<check.length; i++){
		check[i].onclick = function(){
			
			if(check.length == checkCount()){
				
				allCheck.checked = true;
				console.log(checkCount(), check.length);			
			} else{
				
				allCheck.checked = false;
				console.log(checkCount(), check.length);			
			}
		}	
	}	
}


function checkCount(){
	var check = document.getElementsByName("check");
	var cnt = 0;
	
	for(let i=0; i<check.length; i++){
		if(check[i].checked){
			cnt++;
		}
	}
	return cnt;
}


function allChk(bool){
	var check = document.getElementsByName("check");
	
	console.log(checkCount());
	console.log(bool);
	console.log(check.length);
	
	for(let i=0; i<check.length; i++){
		check[i].checked = bool;
		console.log(check[i].checked);	
	} 
	
}


function multiDelete(event){

	event.preventDefault();
	
	console.log(document.forms[0]);
	console.log(document.forms[1]);
	
	if(!checkCount() > 0){
		
		Swal.fire({
		  icon: "error",
		  title: "삭제할 글을 선택해주세요.",
		});
		
	} else{
		
		Swal.fire({
		  title: "선택한 글을 삭제하시겠습니까?",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  cancelButtonText: "취소",
		  confirmButtonText: "확인"
		}).then((result) => {
		  if (result.isConfirmed) {
		    Swal.fire({
		      title: "삭제완료",
		      icon: "success"
		    });
		    
		    document.forms[1].submit();
		  }
		});
		
		
	}
	
	
}

function detailDelete(seq){
	
	Swal.fire({
	  title: "게시글을 삭제하시겠습니까?",
	  icon: "warning",
	  showCancelButton: true,
	  confirmButtonColor: "#3085d6",
	  cancelButtonColor: "#d33",
	  cancelButtonText: "취소",
	  confirmButtonText: "확인"
	}).then((result) => {
	  if (result.isConfirmed) {
	    Swal.fire({
	      title: "삭제완료",
	      icon: "success"
	    });
	    
	    location.href= './deleteBoard.do?seq='+seq;
	  }
	});
	
}



function insertCheck(event){
	
	event.preventDefault();
	
	var title = document.getElementById("isertTitle").value;
	var content = document.getElementById("isertContent").value;
	var convertTitle = "";
	var convertContent = "";
	
	if(title.trim() == ""){
		
		Swal.fire({
		  icon: "error",
		  title: "제목을 입력해주세요.",
		});
		
		return;
	} 
	
	if(content.trim() == ""){
		
		Swal.fire({
		  icon: "error",
		  title: "내용을 입력해주세요.",
		});
		
		return;
	}
	
	convertTitle = title;
	convertTitle.replace("/\r\n|\r|\n|\n\r/gim", "<br>");
	convertTitle.replace("/</gim", "&lt;");
	convertTitle.replace("/>/gim", "&gt;");
	title = convertTitle;
	
	convertCon = content;
	convertCon.replace("/\r\n|\r|\n|\n\r/gim", "<br>");
	convertCon.replace("/</gim", "&lt;");
	convertCon.replace("/>/gim", "&gt;");
	content = convertContent;
	
	document.forms[1].submit();
	
	
}



