/*<![CDATA[*/
var header = $("meta[name='_csrf_header']").attr("content");
var token = $("meta[name='_csrf']").attr("content");

findMember();

function findMember() {
    var inputKeyWord = document.getElementById("keyWord").value;
    var inputMemberStatus = document.getElementById("memberStatus").value;
    if(inputMemberStatus==""){
        inputMemberStatus = null;
    }
    ajaxfindMember(inputKeyWord, inputMemberStatus);
}

function saveMember(){
    var memNo = document.getElementById("memNo").value;
    var memberStatus = document.getElementById("select-memberStatus").value;


    var errorMsg = verifyInputSaveData(memNo, memberStatus);

    if (errorMsg ==""){
        ajaxSaveMember(memNo, memberStatus );
    }else{
        showMsg(errorMsg);
    }
}



function ajaxfindMember(inputKeyWord, inputMemberStatus){
    var ajaxTargetUri = window.location.href.substring(0, window.location.href.lastIndexOf
    ('/view')) + '/api/member/find';

    $.ajax({
        type: 'POST',
        url: ajaxTargetUri,
        headers: {
            'X-CSRF-TOKEN': token
        },
        data: JSON.stringify({
            keyWord: inputKeyWord,
            memberStatus: inputMemberStatus
        }),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result) {
            if(result.status=='OK'){
                showResult(result.data);
            }else{
                showMsg(result.message);
            }
        },
        error: function (result) {
            showMsg("系統出現異常");
        }
    });
}

function transMemStatusValue(memStatus) {


    let result;
    if (memStatus == "0") {
        result = "未啟用";
    }
    if (memStatus == "1") {
        result = "啟用";
    }
    if (memStatus == "2") {
        result = "封鎖";
    }
    return result;
}


function showResult(resultDatas) {
    var tbody = document.querySelector("#member_tbody");
    tbody.remove();

    tbody = document.createElement("tbody");
    tbody.id = "member_tbody";

    for (let i = 0; i < resultDatas.length; i++) {
        var newTr = document.createElement("tr");
        newTr.className = "member-result-tr";
        newTr.appendChild(createNewTd(resultDatas[i].memNo));
        newTr.appendChild(createNewTd(resultDatas[i].crDate));
        newTr.appendChild(createNewTd(resultDatas[i].userName));
        newTr.appendChild(createNewTd(resultDatas[i].name));
        newTr.appendChild(createNewTd(resultDatas[i].memBirth));
        newTr.appendChild(createNewTd(resultDatas[i].phone));
        newTr.appendChild(createNewTd(resultDatas[i].email));
        newTr.appendChild(createNewTd(resultDatas[i].address));
        newTr.appendChild(createNewTd(transMemStatusValue(resultDatas[i].memStatus)));
        newTr.appendChild(createActionTd(i));


        tbody.appendChild(newTr);

    }

    var table = document.getElementById("memberQueryTable");
    table.appendChild(tbody);

    for (let i = 0; i < resultDatas.length; i++) {
        document.getElementsByClassName("member-update")[i].onclick = showUpdate;

        }
    }

    function createNewTd(text) {
        var newTd = document.createElement("td");
        newTd.textContent = text;
        return newTd;
        console.log(newTd);
    }

    function createActionTd(number) {

        var newDiv = document.createElement("div");
        // inline讓按鈕可以平行對齊
        newDiv.style.display = "inline";
        //create 修改按鈕
        var newUpdateButton = document.createElement("button");
        newUpdateButton.className = "btn btn-info btn-sm member-update";
        newUpdateButton.id = "member-update-" + number;
        newUpdateButton.textContent = "修改";
        //設置觸發的modal
        newUpdateButton.setAttribute("data-bs-toggle", "modal");
        newUpdateButton.setAttribute("data-bs-target", "#saveModel");

        newDiv.appendChild(newUpdateButton);

        var newTd = document.createElement("td");
        newTd.appendChild(newDiv);

        return newTd;
    }

    function showUpdate(event) {
        var modelTitle = document.getElementById("saveModelTitle");
        modelTitle.textContent = "修改會員狀態";
        document.getElementById("memNo").setAttribute("readonly", "true");
        //取得當下點擊元素的id資料
        var updateButton = document.getElementById(event.target.id);
        var tdNodes = updateButton.parentNode.parentNode.parentNode.childNodes;
        var memNo = tdNodes[0].textContent;

        document.getElementById("memNo").value = memNo;

    }

function verifyInputSaveData(memNo, memberStatus){
    var errorMsg = "";
    if(memNo == ""){
        errorMsg = errorMsg + "請輸入原會員編號\n";
    }
    if(memberStatus == "請選擇"){
        errorMsg = errorMsg + "請輸入等級\n";
    }

    return errorMsg;
}

function ajaxSaveMember(memNo, memberStatus){
    var ajaxTargetUri = window.location.href.substring(0, window.location.href.lastIndexOf
    ('/view')) + '/api/member/save';

    $.ajax({
        type: 'POST',
        url: ajaxTargetUri,
        headers: {
            'X-CSRF-TOKEN': token
        },
        data: JSON.stringify({
            memNo: parseInt(memNo),
            memberStatus: memberStatus
        }),
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            if(result.status=='OK'){

                showConfirmMsg('存檔成功',"saveSuccessConfirmMsg");
                document.getElementById('saveSuccessConfirmMsg').addEventListener(
                    'click', function () {

                        document.getElementById("closeSaveWindow").click();
                        findMember();

                        closeConfirmMsg();
                    }, false);

            }else{
                showMsg(result.message);
            }

        },
        error: function (result) {
            showMsg("系統出現異常");
        }
    });
}


    window.addEventListener("load", function () {
        document.getElementById("findMember").onclick = findMember; //查詢 按鈕
        document.getElementById("saveMember").onclick = saveMember; // 新增/修改管理員 存檔 按鈕
    }, false);








/*]]>*/