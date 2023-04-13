
var loadButton;

$(document).ready(function(){
	loadButton = $("#buttonLoadTeacherAndSubjects");
	
	
	loadButton.click(function(){
		addNextDetailSection();
		//addTeachSubjectSectionWithDropdown();
	});
});

addTeachSubjectSectionWithDropdown = (endpointURL, idOfSelectTag,teacherAndSubjectObject) =>{
	url = contextPath + endpointURL;
	
	//performs ajax call
	$.get(url,
		//callback function
		function(responseJSON){
			//clear the dropdown
			//idOfSelectTag.empty();
			
			//iterate through each object in the response json
			$.each(responseJSON,
			//execute callback function
			//parameter 1 is the index of the element 
			//parameter 2 is the teacher object
			function(index, teacherAndSubjectObject){
				optionValue = teacherAndSubjectObject.id;
				
				if(idOfSelectTag == "#teacherSelectOption"){
					$("<option>").val(optionValue).text(teacherAndSubjectObject.fullName).appendTo(idOfSelectTag);
				}else{
					$("<option>").val(optionValue).text(teacherAndSubjectObject.name).appendTo(idOfSelectTag);
				}
				
				
				

			}
			);
		}
	);
}

addNextDetailSection = () => {
	//contextPath = "[[@{/}]]";
	//var $teacherSubjectSelectOption = $("#teacherSubjectSelectOption");
	//select all the divStaffSubIndex 
	allDivStaffSubIndex = $("[id^='divStaffSubIndex']");
	
	//counts the number of divStaffSubIndex on the form
	divStaffSubIndexCount = allDivStaffSubIndex.length;
	
	//nextDivStaffSubIndexId = divStaffSubIndexCount ;
	
	//id="divStaffSubIndex${nextDivStaffSubIndexId}" is a dynamic id assign to the div
	
	// `` is used to include the html code
	htmlTeacherSubjectSection = `
	
	<div class="form-row mt-2" id="divStaffSubIndex${divStaffSubIndexCount}">
	  <div class="col-1">
	    <label class=" col-form-label">Teacher</label>
	  </div>
	  <div class="col-4">
	   <div class="input-group ">
	     	 	<div class="input-group-prepend">
			    <label class="input-group-text" name="selectTeacher" >Select</label>
			  </div>
	      	<select class="custom-select form-select-sm "  id="teacherSelectOption">
			    <option selected>Teacher</option>
			    	
			 </select>
	     	 </div>
	  </div>
	  
	  <div class="col-1">
	    <label class=" col-form-label ml-4">Subject</label>
	  </div>
	  <div class="col-4">
	    <div class="input-group ">
	     	 	<div class="input-group-prepend">
			    <label class="input-group-text"name="selectSubject" >Select</label>
			  </div>
	      	<select class="custom-select form-select-sm "  id="subjectSelectOption">
			    <option selected>Subject</option>
			    	
			 </select>
	     	 </div>
	  </div>
	
	</div>
	
	
	`;
	
$("#divStaffSubject").append(htmlTeacherSubjectSection);

addTeachSubjectSectionWithDropdown("teacherSubjects/teachers", "#teacherSelectOption");
addTeachSubjectSectionWithDropdown("teacherSubjects/subjects", "#subjectSelectOption");

	
	//difine the last div section of allDivStaffSubIndex as the last element
	previousDivStaffSubjectSection = allDivStaffSubIndex.last();
	
	priviousDivStaffSubjectSectionID = previousDivStaffSubjectSection.attr("id");
	
	
	
	
	htmlLinkRemove = `
		<a class="fas fa-times-circle fa-2x"
		href="javascript:removeStaffSubjectById('${priviousDivStaffSubjectSectionID}')"
		title="Delete this section"></a>
	`;
	
	
	//append a delete button
	previousDivStaffSubjectSection.append(htmlLinkRemove);
	
	$("input[name='selectTeacher']").last().focus();
	
}


removeStaffSubjectById = (id) => {
	$("#" + id).remove();
}
