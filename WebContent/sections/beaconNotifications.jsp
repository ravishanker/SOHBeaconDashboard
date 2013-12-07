
<%@page import="com.soh.sohbeacon.model.Beacon"%>
<%@page import="com.soh.sohbeacon.store.BeaconStore"%>
<h2 id="beaconOffers">Beacon notifications</h2>

<h3>Existing notifications</h3>

<table class="table table-hover">
	<thead>
		<tr>
			<th width="100">On</th>
			<th>Beacon Identifier</th>
			<th width="220">Offer Image</th>
		</tr>
	</thead>
	<tbody>
		<%
		BeaconStore bs = BeaconStore.getInstance();
		for (Beacon beacon : bs.getNotificationBeacons())
		{
		%>
		<tr>
			<td><%=beacon.getType() %></td>
			<td><%=beacon.getBeaconName() %></td>
			<td><img alt="thumb" src="/stores/<%=beacon.getFileName() %>" class="beaconPreviewImage"></td>
		</tr>
		<%} %>
	</tbody>
</table>

<h3>Create new</h3>

<form id="createNotificationForm" 
	class="tab-pane form-horizontal"
	method="post" 
	enctype="multipart/form-data" 
	action="/CreateNotification">
	
	<div class="form-group">
		<label for="notificationType1" class="col-sm-2 control-label">Notification Type</label>
		<div class="col-sm-10">
			<select class="form-control" id="notificationType1" name="notificationType1">
				<option value="enter">Enter</option>
				<option value="leave">Leave</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="beaconChooser1" class="col-sm-2 control-label">Beacon</label>
		<div class="col-sm-10">
			<select class="form-control" id="beaconChooser1" name="beaconChooser1">
				<option value="beacon1">Beacon 1</option>
				<option value="beacon2">Beacon 2</option>
				<option value="beacon3">Beacon 3</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="notificationImageChooser" class="col-sm-2 control-label">Offer Content</label>
		<div class="col-sm-10">
			<a class='btn btn-primary'
				style="position: relative;"
				href='javascript:;'>
				Choose File... 
				<input type="file" id="notificationImageChooser"
					class='invisibleFilePicker'
					name="upload_file" 
					size="40"
					onchange='beaconNotificaionFileChosen(this)' />
			</a>
			&nbsp;
			<span id="upload-file-info"></span>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button style="display: none;"
				class="submitForm btn btn-default">Add</button>
		</div>
	</div>
</form>

<script>
	$(document).ready(function() {
		$("#createNotificationForm .submitForm").click(function(){
			alert('sending');
			$("#createNotificationForm")
				.ajaxSubmit({
					success: function(){
						alert('done!');
						$("#createNotificationForm .submitForm").hide();
						$("#createNotificationForm #upload-file-info").html('');
						$("#createNotificationForm")[0].reset();
					}
				});
			});
	});

	function beaconNotificaionFileChosen(target)
	{
		$("#createNotificationForm #upload-file-info").html($(target).val());
		$("#createNotificationForm .submitForm").show('slow');
		
	}
</script>
