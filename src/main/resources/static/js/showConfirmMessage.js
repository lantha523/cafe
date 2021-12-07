
		function showConfirmMsg(message, buttonId){

			var closeDiv = document.getElementById("showConfirmMessageFooter");
			closeDiv.removeChild(closeDiv.firstChild);

			var confirmButton = document.createElement("button");
			confirmButton.id = buttonId;
			confirmButton.className = "btn btn-info";
			confirmButton.textContent = "確認";
			confirmButton.setAttribute("data-bs-dismiss","model");

			closeDiv.appendChild(confirmButton);

			document.getElementById("showConfirmMessage").click();
			document.getElementById("showConfirmMessageContent").innerText = message;
		}