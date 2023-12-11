function openTitleModifyPopup(popup, questionnaireId){
    let hiddenElement = document.getElementById('questionnaireId');
    hiddenElement.value = questionnaireId;
    popup.style.display = "block";
}

function openAddQuestionPopup(popup, questionId){
    let hiddenElement = document.getElementById("questionId");
    hiddenElement.value = questionId;
    popup.style.display = "block";
}

function openModifyQuestionPopup(popup, questionId){
    let hiddenElement = document.getElementById("questionModifyId");
    hiddenElement.value = questionId;
    popup.style.display = "block";
}

function openAddOptionPopup(popup, optionId){
    let hiddenElement = document.getElementById("optionAddId");
    hiddenElement.value = optionId;
    popup.style.display = "block";
}

function openModifyOptionPopup(popup, optionId){
    let hiddenElement = document.getElementById("optionModifyId");
    hiddenElement.value = optionId;
    popup.style.display = "block";
}

function closePopup(popup) {
    popup.style.display = "none";
}

function addRadio(){
    let addTypeElement = document.getElementById("addType");
    addTypeElement.value = "radio";
}

function addCheckbox(){
    let addTypeElement = document.getElementById("addType");
    addTypeElement.value = "checkbox";
}

function addText(){
    let addTypeElement = document.getElementById("addType");
    addTypeElement.value = "text";
}