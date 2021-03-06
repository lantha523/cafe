
/*<![CDATA[*/
var header = $("meta[name='_csrf_header']").attr("content");
var token = $("meta[name='_csrf']").attr("content");

findAdmin();

function findAdmin(){
  var inputKeyWord = document.getElementById("keyWord").value;
  var inputLevel = document.getElementById("level").value;
  if(inputLevel==""){
    inputLevel = null;
  }
  ajaxFindAdmin(inputKeyWord, inputLevel);
}

function saveAdministrator(){
  var admNo = document.getElementById("admNo").value;
  var memNo = document.getElementById("memNo").value;
  var level = document.getElementById("select-level").value;
  var functionNos = [];

  var functionChecks = document.getElementsByName("functionCheck");
  if(level=="MANAGER"){
    functionChecks[3].checked = false;
  }
  for(var i=0; i<functionChecks.length; i++){
    if(functionChecks[i].checked){
      functionNos.push(parseInt(functionChecks[i].value));
    }
  }

  var errorMsg = verifyInputSaveData(memNo, level, functionNos);

  if (errorMsg ==""){
    ajaxSaveAdmin(admNo, memNo, level, functionNos);
  }else{
    showMsg(errorMsg);
  }
}


// resultDatas 從ajaxFindAdmin的 showResult(result.data);而來
function showResult(resultDatas){
  var tbody = document.querySelector("#admin_tbody");
  tbody.remove();

  tbody = document.createElement("tbody");
  tbody.id = "admin_tbody";

  for (let i = 0; i<resultDatas.length ; i++) {
    var newTr = document.createElement("tr");
    newTr.className = "admin-result-tr";
    newTr.appendChild(createNewTd(resultDatas[i].admNo));
    newTr.appendChild(createNewTd(resultDatas[i].memNo));
    newTr.appendChild(createNewTd(resultDatas[i].userName));
    newTr.appendChild(createNewTd(resultDatas[i].name));
    newTr.appendChild(createNewTd(resultDatas[i].phone));
    newTr.appendChild(createNewTd(resultDatas[i].address));
    newTr.appendChild(createNewTd(resultDatas[i].level));
    newTr.appendChild(createFeatureTd(resultDatas[i].features));
    newTr.appendChild(createActionTd(i));

    tbody.appendChild(newTr);
  }

  var table = document.getElementById("adminQueryTable");
  table.appendChild(tbody);

  for (let i = 0; i<resultDatas.length ; i++) {
    document.getElementsByClassName("admin-update")[i].onclick = showUpdate;
    document.getElementsByClassName("admin-delete")[i].onclick = showDelete;
  }

}

function showUpdate(event){
  var modelTitle = document.getElementById("saveModelTitle");
  modelTitle.textContent = "修改管理員";
  document.getElementById("admNo").setAttribute("readonly","true");
  document.getElementById("memNo").setAttribute("readonly","true");
  //取得當下點擊元素的id資料
  var updateButton = document.getElementById(event.target.id);
  var tdNodes = updateButton.parentNode.parentNode.parentNode.childNodes;
  var admNo = tdNodes[0].textContent;
  var memNo = tdNodes[1].textContent;
  var level = tdNodes[6].textContent;
  var functionNodes = tdNodes[7].childNodes;

  document.getElementById("admNo").value = admNo;
  document.getElementById("memNo").value = memNo;
  document.getElementById(level).selected = true;

  clearFuctionCheckBox();

  for (let i = 0; i<functionNodes.length ; i++) {
    functionNo = functionNodes[i].childNodes[0].value;

    functionChecks = document.getElementsByName("functionCheck");
    for (let j = 0; j<functionChecks.length ; j++){
      if(functionChecks[j].value == functionNo){
        functionChecks[j].checked = true;
      }
    }
  }

  changeLevelFunction();
}

function showDelete(event){
  showConfirmMsg('確認要移除這位管理員嗎？',"deleteConfirmMsg");
  document.getElementById('deleteConfirmMsg').addEventListener(
      'click', function () {

        var updateButton = document.getElementById(event.target.id);
        var tdNodes = updateButton.parentNode.parentNode.parentNode.childNodes;
        var admNo = tdNodes[0].textContent;
        ajaxDeleteAdmin(admNo);

        closeConfirmMsg();
      }, false);

}

function showInsert(){
  var modelTitle = document.getElementById("saveModelTitle");
  modelTitle.textContent = "新增管理員";
  document.getElementById("admNo").setAttribute("readonly","true");
  document.getElementById("memNo").removeAttribute("readonly");
  document.getElementById("admNo").value = null;
  document.getElementById("memNo").value = null;
  document.getElementById("level_choice").selected = true;

  clearFuctionCheckBox();
  document.getElementById("divFeatures").style.display="none";
}

function createNewTd(text){
  var newTd = document.createElement("td");
  newTd.textContent = text;
  return newTd;
}

function createFeatureTd(features){
  var newTd = document.createElement("td");

  for (let i = 0; i<features.length ; i++) {
    var newDiv = document.createElement("div");

    var newInputHiddenNo = document.createElement("input");
    newInputHiddenNo.type = "hidden";
    newInputHiddenNo.value = features[i].functionNo;
    newDiv.appendChild(newInputHiddenNo);

    var newSpan = document.createElement("span");
    newSpan.innerHTML = features[i].functionName;
    newDiv.appendChild(newSpan);

    var newBr = document.createElement("br");
    newDiv.appendChild(newBr);

    newTd.appendChild(newDiv);
  }


  return newTd;
}

function createActionTd(number){

  var newDiv = document.createElement("div");
  // inline讓按鈕可以平行對齊
  newDiv.style.display = "inline";
  //create 修改按鈕
  var newUpdateButton = document.createElement("button");
  newUpdateButton.className = "btn btn-info btn-sm admin-update";
  newUpdateButton.id = "admin-update-"+number;
  newUpdateButton.textContent = "修改";
  //設置觸發的modal
  newUpdateButton.setAttribute("data-bs-toggle", "modal");
  newUpdateButton.setAttribute("data-bs-target", "#saveModel");

  newDiv.appendChild(newUpdateButton);
  //設置空格append進去
  var newSpan = document.createElement("span");
  newSpan.innerHTML = "&nbsp;";
  newDiv.appendChild(newSpan);

  var newDeleteButton = document.createElement("button");
  newDeleteButton.className = "btn btn-danger btn-sm admin-delete";
  newDeleteButton.id = "admin-delete-"+number;
  newDeleteButton.textContent = "移除";

  newDiv.appendChild(newDeleteButton);

  var newTd = document.createElement("td");
  newTd.appendChild(newDiv);

  return newTd;
}

function clearFuctionCheckBox(){
  var functions = document.getElementsByName("functionCheck");
  for (let i = 0; i<functions.length ; i++) {
    functions[i].checked = false;
  }
}

function changeLevelFunction(){
  var selectLevel = document.getElementById("select-level").value;
  if(selectLevel == "MANAGER"){
    document.getElementById("divFeatures").removeAttribute("style");
    document.getElementsByName("functionCheck")[3].style.display="none";
    document.getElementsByName("functionCheckName")[3].style.display="none";
  }else if(selectLevel == "SUPER_MANAGER"){
    document.getElementById("divFeatures").removeAttribute("style");
    document.getElementsByName("functionCheck")[3].removeAttribute("style");
    document.getElementsByName("functionCheckName")[3].removeAttribute("style");
  }else{
    document.getElementById("divFeatures").style.display="none";
  }

}

function verifyInputSaveData(memNo, level, functionNos){
  var errorMsg = "";
  if(memNo == ""){
    errorMsg = errorMsg + "請輸入原會員編號\n";
  }
  if(level == "請選擇"){
    errorMsg = errorMsg + "請輸入等級\n";
  }
  if(level != "請選擇" && functionNos.length == 0 ){
    errorMsg = errorMsg + "請輸入至少一個功能權限\n";
  }
  return errorMsg;
}


function ajaxFindAdmin(inputKeyWord, inputLevel){
  //獲取利用window.location.href的變數獲取整個url，要哪一部分的地址，利用substring，indexof等字串處理函式對獲取到的url進行處理，擷取想要的部分。
  var ajaxTargetUri = window.location.href.substring(0, window.location.href.lastIndexOf
  ('/view')) + '/api/administrator/find';

  $.ajax({
    type: 'POST',
    url: ajaxTargetUri,
    headers: {
      'X-CSRF-TOKEN': token
    },
    data: JSON.stringify({
      keyWord: inputKeyWord,
      level: inputLevel
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

function ajaxSaveAdmin(admNo, memNo, level, functionNos){
  var ajaxTargetUri = window.location.href.substring(0, window.location.href.lastIndexOf
  ('/view')) + '/api/administrator/save';

  $.ajax({
    type: 'POST',
    url: ajaxTargetUri,
    headers: {
      'X-CSRF-TOKEN': token
    },
    data: JSON.stringify({
      admNo: parseInt(admNo),
      memNo: parseInt(memNo),
      level: level,
      functionNos: functionNos
    }),
    contentType: "application/json; charset=utf-8",
    success: function (result) {
      if(result.status=='OK'){

        showConfirmMsg('存檔成功',"saveSuccessConfirmMsg");
        document.getElementById('saveSuccessConfirmMsg').addEventListener(
            'click', function () {

              document.getElementById("closeSaveWindow").click();
              findAdmin();

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

function ajaxDeleteAdmin(admNo){
  var ajaxTargetUri = window.location.href.substring(0, window.location.href.lastIndexOf
  ('/view')) + '/api/administrator/delete?admNo='+admNo;

  $.ajax({
    type: 'GET',
    url: ajaxTargetUri,
    headers: {
      'X-CSRF-TOKEN': token
    },
    contentType: "application/json; charset=utf-8",
    success: function (result) {
      if(result.status=='OK'){
        findAdmin();
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
  document.getElementById("findAdmin").onclick = findAdmin; //查詢 按鈕
  document.getElementById("insert-admin").onclick = showInsert; // 新增管理員 按鈕
  document.getElementById("saveAdmin").onclick = saveAdministrator; // 新增/修改管理員 存檔 按鈕
  document.getElementById("select-level").onchange = changeLevelFunction; // 等級 下拉式選單
},false);

/*]]>*/