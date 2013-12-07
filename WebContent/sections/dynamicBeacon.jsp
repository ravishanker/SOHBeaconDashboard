
<h2 id="dynamicOffers">Dynamic Beacon</h2>
<p>Beacon 1 is a dynamic content beacon. The following file is being displayed for it.</p>

<form id="dynamicBeaconForm" method="post" enctype="multipart/form-data" action="/UploadCurrentOfferBeacon">
	<a class='btn btn-primary'
		style="position: relative;"
		href='javascript:;'>
		 Choose File... 
		<input type="file"
			style='position: absolute; z-index: 2; top: 0; left: 0; filter: alpha(opacity = 0); -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)"; opacity: 0; background-color: transparent; color: transparent;'
			name="upload_file" 
			size="40"
			onchange='fileChosen(this)' />
	</a>
	&nbsp;
	<span id="upload-file-info"></span>
	
	<button id="uploadBeaconFile" type="button" class="btn btn-danger">Upload</button>
</form>

<script>
	$(document).ready(function(){
		$("#uploadBeaconFile").click(function(){
			$("#dynamicBeaconForm")
				.ajaxSubmit({
					success: function(){
						alert('done!');
						$("#uploadBeaconFile").hide();
						$("#upload-file-info").html('');
						$("#dynamicBeaconForm")[0].reset();
					}
				});
		});
	});

	function fileChosen(target)
	{
		$("#upload-file-info").html($(target).val());
		$("#uploadBeaconFile").show('slow');
		
	}
</script>
