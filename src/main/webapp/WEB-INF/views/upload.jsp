<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>

	<form method="POST" action="uploadFile" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Upload file</td>
				<td> <input type="file" name="file"></td>
			</tr>
			<tr>
				<td>Press here to upload the file!</td>
				<td><input type="submit" value="Upload"></td>
			</tr>
			<tr>
				<td colspan="2"> Only supports ods (open document spreadsheet)</td>
			</tr>
		</table>
	</form>

</body>
</html>