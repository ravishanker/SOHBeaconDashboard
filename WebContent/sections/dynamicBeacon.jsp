
<h2 id="dynamicOffers">Dynamic Beacon</h2>
<p>Beacon 1 is a dynamic content beacon. The following file is being displayed for it.</p>


<form id="dynamicBeaconForm" 
		method="post" 
		enctype="multipart/form-data" 
		action="/UploadBeacon">
	<img id="dynamicBeaconPreview" src="/stores/uploaded.jpg?cache=<%=System.currentTimeMillis() %>" class="beaconPreviewImage"/>
	<a class='btn btn-primary'
		style="position: relative;"
		href='javascript:;'>
		 Choose File... 
		<input type="file"
			class='invisibleFilePicker'
			name="upload_file" 
			size="40"
			onchange='dyBeaconFileChosen(this)' />
	</a>
	&nbsp;
	<span id="upload-file-info"></span>
	
	<button type="button" style="display: none" class="submitForm btn btn-danger">Upload</button>
</form>


<script>
	$(document).ready(function(){
		$("#dynamicBeaconForm .submitForm").click(function(){
			alert('sending');
			$("#dynamicBeaconForm")
				.ajaxSubmit({
					success: function(){
						alert('done!');
						$("#dynamicBeaconForm .submitForm").hide();
						$("#dynamicBeaconForm #upload-file-info").html('');
						$("#dynamicBeaconForm")[0].reset();
						
						var currentImg = $("#dynamicBeaconForm .beaconPreviewImage").attr('src');
						$("#dynamicBeaconForm .beaconPreviewImage").attr('src', currentImg+"1");
					}
				});
			});
	});

	function dyBeaconFileChosen(target)
	{
		$("#dynamicBeaconForm #upload-file-info").html($(target).val());
		$("#dynamicBeaconForm .submitForm").show('slow');
		
	}
</script>
