
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
	//optionIndex = ${selectionOptionIndex};
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
				
				
				if(idOfSelectTag == "#teacherSelectOptionIndex" + teacherSelectOptionIndexCount){
					
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
	
	allTeacherSelectOptionSubIndex = $("[id^='teacherSelectOptionIndex']");
	allSubjectSelectOptionSubIndex = $("[id^='subjectSelectOptionIndex']");
	
	//counts the number of divStaffSubIndex on the form
	divStaffSubIndexCount = allDivStaffSubIndex.length;
	
	teacherSelectOptionIndexCount = allTeacherSelectOptionSubIndex.length;
	subjectSelectOptionIndexCount = allSubjectSelectOptionSubIndex.length;
	
	//nextDivStaffSubIndexId = divStaffSubIndexCount ;
	
	//id="divStaffSubIndex${nextDivStaffSubIndexId}" is a dynamic id assign to the div
	
	// `` is used to include the html code
	htmlTeacherSubjectSection = `
	
	<div class="d-flex flex-row mt-2 " id="divStaffSubIndex${divStaffSubIndexCount}">
	  <div class="col-1">
	    <label class="form-label fw-bold fs-5">Teacher</label>
	  </div>
	  <div class="col-sm-4 me-4">
	  	<select class="form-select teacherSelectOption" name="selectTeacher"  id="teacherSelectOptionIndex${teacherSelectOptionIndexCount}">
		    <option selected>Teacher</option>
		 </select>
	  </div>
	  
	  <div class="col-1 ">
	    <label class="form-label fw-bold fs-5">Subject</label>
	  </div>
	  <div class="col-sm-4 me-4">
      	<select class="form-select subjectSelectOption" name="selectTeacher"  id="subjectSelectOptionIndex${subjectSelectOptionIndexCount}">
		    <option selected>Subject</option>
		 </select>
		</div>
	
	</div>
	`;
	
	addTeachSubjectSectionWithDropdown("assignSubjects/teachers", "#teacherSelectOptionIndex" + teacherSelectOptionIndexCount);
	addTeachSubjectSectionWithDropdown("assignSubjects/subjects", "#subjectSelectOptionIndex" + subjectSelectOptionIndexCount);

	$("#divStaffSubject").append(htmlTeacherSubjectSection);

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
	
	//$("input[name='selectTeacher']").last().focus();
	
}


removeStaffSubjectById = (id) => {
	$("#" + id).remove();
}
