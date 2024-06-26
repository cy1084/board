
window.onload = function(){
	var UserCheck = document.getElementsByName("UserCheck"); 
	var userAllCheck = document.getElementById("userAllCheck");
	for(let i=0; i<UserCheck.length; i++){
		UserCheck[i].onclick = function(){	
			if(UserCheck.length == checkCount()){			
				userAllCheck.checked = true;	
			} else{		
				userAllCheck.checked = false;		
			}
		}	
	}
	
}

//체크개수
function checkCount(){
	var UserCheck = document.getElementsByName("UserCheck");
	var cnt = 0;	
	for(let i=0; i<UserCheck.length; i++){
		if(UserCheck[i].checked){
			cnt++;
		}
	}
	return cnt;
}

//전체체크
function userAllChk(bool){
	var UserCheck = document.getElementsByName("UserCheck");
	for(let i=0; i<UserCheck.length; i++){
		UserCheck[i].checked = bool;
		console.log(UserCheck[i].checked);	
	} 
}

function approvalUser(event){
	event.preventDefault();
	var frm = document.forms[1];
	
	
	if(!checkCount() > 0){
		Swal.fire({
		  icon: "error",
		  title: "가입승인 사용자를 선택해주세요.",
		});
		
	} else{
		
		Swal.fire({
		  title: "가입을 승인합니다.",
		  icon: "success",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  cancelButtonText: "취소",
		  confirmButtonText: "확인"
		}).then((result) => {
		  if (result.isConfirmed) {
		    Swal.fire({
		      title: "승인완료",
		      icon: "success"
		    });
		    
		    frm.setAttribute("action","./approvalUser.do")	    
		    frm.submit();
		  }
		});
	}
	
}


function refusalUser(event){
	event.preventDefault();
	var frm = document.forms[1];
	
	
	if(!checkCount() > 0){	
		Swal.fire({
		  icon: "error",
		  title: "가입거절 사용자를 선택해주세요.",
		});
		
	} else{
		
		Swal.fire({
		  title: "가입을 거절합니다.",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  cancelButtonText: "취소",
		  confirmButtonText: "확인"
		}).then((result) => {
		  if (result.isConfirmed) {
		    Swal.fire({
		      title: "거절완료",
		      icon: "success"
		    });	    
		    frm.setAttribute("action","./refusalUser.do")
		    frm.submit();
		  }
		});
		
		
	}
	
}


function deleteUser(event){
	event.preventDefault();
	var frm = document.forms[1];
	
	
	if(!checkCount() > 0){
		
		Swal.fire({
		  icon: "error",
		  title: "삭제할 사용자를 선택해주세요.",
		});
		
	} else{
		
		Swal.fire({
		  title: "선택한 사용자를 삭제합니다.",
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
		    
		    frm.setAttribute("action","./deleteUser.do")
		    frm.submit();
		  }
		});
	
	}
	
}





function duplicate(){
//	event.preventDefault();
	
	var registId = document.getElementById("registId").value;
	
	if(registId.trim() == ""){
		Swal.fire({
		  icon: "error",
		  title: "아이디를 입력해주세요.",
		});
		return;
	}
	
	window.open("./duplicate.do?registId="+registId, "","left=300px,top=300px,width=450px,height=300px");

	
}



function registUser(event){
	event.preventDefault();
	var pw = document.getElementById("registPassword").value;
	var pwCheck = document.getElementById("registPasswordCheck").value;
	var name = document.getElementById("registName").value;
	var phone = document.getElementById("registPhone").value;
	
	
	if(pw.trim() == ""){
		Swal.fire({
		  icon: "error",
		  title: "비밀번호를 입력해주세요.",
		});
		return;
	}
	
	if(name.trim() == ""){
		Swal.fire({
		  icon: "error",
		  title: "이름을 입력해주세요.",
		});
		return;
	}
	
	if(phone.trim() == ""){
		Swal.fire({
		  icon: "error",
		  title: "전화번호를 입력해주세요.",
		});
		return;
	}
	
	if(pw != pwCheck){
		Swal.fire({
		  icon: "error",
		  title: "비밀번호가 일치하지 않습니다.",
		});
		return;
	}
	
	document.forms[0].submit();
	
}



function enableChange(value){
	console.log(value);
	
	
	
}
















