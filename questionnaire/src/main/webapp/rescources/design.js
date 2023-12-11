function openTitleModifyPopup(popup){
    popup.style.display = "block";
}

function openAddQuestionPopup(popup){
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