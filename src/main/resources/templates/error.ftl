<#import "lib/utils.ftl" as u>

<!DOCTYPE html>
<html lang="en">
	<head>
	<@u.head pagetitle="Page cannot be found" />
	</head>
	<body>
	<@u.body>
		<@u.left>
			<div class="card">
				<h2>Sorry, That Page Cannot Be Found!</h2>
			</div>
		</@u.left>
		<@u.right />
	</@u.body>
	</body>
</html>
