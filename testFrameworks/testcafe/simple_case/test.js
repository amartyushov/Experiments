import { Selector } from 'testcafe';

fixture `Getting Started`
    .page `http://spm.docker.localhost:8080`;



test
    .before(async t => {
        var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;
        var xhr = new XMLHttpRequest();
        var url = "http://localhost:9090/register";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var json = JSON.parse(xhr.responseText);
                console.log(json.email + ", " + json.password);
            }
        };
        var data = JSON.stringify({
            "firstName": "one",
            "lastName": "abc"
        });
        xhr.send(data);
    })
    ('My first test', async t => {
        await t
            .setTestSpeed(0.2)
            .typeText(Selector("#name"), "one.abc@BLA.com")
            .typeText(Selector("#password"), "BLA")
    
});