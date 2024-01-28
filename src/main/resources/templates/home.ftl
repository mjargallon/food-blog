<#import "lib/utils.ftl" as u>

<!DOCTYPE html>
<html lang="en">
	<head>
	<@u.head pagetitle="Welcome to My Food Blog" />
	</head>
	<body>
	<@u.body>
		<@u.left>
			<#if posts?? && posts?size gt 0>
				<section class="card-group">
					<#list posts as post>
					<article class="card">
						<small><b>${post.publicationDate?string("MMMM dd, yyyy")}</b></small>
						<h2>
							<a href="/posts${post.url}">${post.title}</a>
						</h2>
						<p class="cutoff-text">${post.content}</p>
						<a href="/posts${post.url}">Continue reading...</a>
					</article>
					</#list>
				</section>
			<#else>
				<article class="card">
					<h2>No posts found!</h2>
				</article>
			</#if>
		</@u.left>
		<@u.right />
	</@u.body>
	</body>
</html>