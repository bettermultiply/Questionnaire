function submitForm() {
    let form = document.getElementById("answerForm");
    let formData = new FormData(form);
    let pathList = window.location.href.split('/');

    let jsonData = {
        questionnaireId: pathList[pathList.length - 1],
        questionAnswers:[]
    };

    let questionNumber = 1;
    let questionIdElement = document.getElementById("questionId" + questionNumber);

    while (questionIdElement != null){
        let questionAnswer = {
            questionId: questionIdElement.value,
            answer: formData.getAll("question" + questionNumber)
        }

        jsonData.questionAnswers.push(questionAnswer);
        questionNumber++;
        questionIdElement = document.getElementById("questionId" + questionNumber);
    }

    fetch("/answerQuestionnaire/api/submitForm", {
        method: "POST",
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(jsonData)
    }).then(response => response.text())
        .then(data => {
            window.location.href = data;
        });
}