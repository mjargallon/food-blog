<#import "lib/utils.ftl" as u>

<!DOCTYPE html>
<html lang="en">
	<head>
	<@u.head pagetitle="${post.title} - My Food Blog" 
			 seotitle="${post.seoTitle}" 
			 seodesc="${post.seoDescription}" />
	</head>
	<body>
	<@u.body>
		<@u.left>
			<div class="card">
				<h2>
					${post.title}
				</h2>
				<hr>
				<p>${post.content}</p>
				<h5>Published on ${post.publicationDate?string("MMMM dd, yyyy")}</h5>
			</div>
		</@u.left>
		<@u.right />
	</@u.body>
	</body>
</html>