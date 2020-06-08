function deleteReader(id) {
    dateJSON = JSON.stringify({
        "id" : id
    });

    let xhr = new XMLHttpRequest()
    xhr.open("DELETE", "http://localhost:8081/readers");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(dateJSON);
    xhr.onload = () => {

    }
}