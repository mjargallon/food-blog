<#import "lib/utils.ftl" as u>
<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
	<head>
	<@u.head pagetitle="Add new post - My Food Blog" />
	</head>
	<body>
	<@u.body>
		<@u.left>
			<div class="card">
				<#if post?? && isValid??>
					<div class="alertSuccess">
				    	New post successfully created. 
				    	<a href="/posts${post.url}">View post</a>
				    	<label> | </label>
				    	<a href="/form">Add new post</a>
					</div>
				<#else>
				<h2>
					Add New Post
				</h2>
				<form action="/form" method="post">
					<label>Title:</label>
	                <span class="error">
	                	<@spring.formInput "post.title" 'size="65" maxlength="100"'/> 
	                	<@spring.showErrors "/"/>
                	</span>
					<br><br>
					<label>Content:</label><br>
	                <span class="error">
	               		<@spring.formTextarea "post.content" 'rows="5" cols="60" maxlength="1000"'/> 
	               		<@spring.showErrors "/"/>
					</span>
					<br><br>
					<label>URL:</label>
	                <span class="error">
	                	<@spring.formInput "post.url" 'size="65" maxlength="50" placeholder="/some-url-format/"'/> 
	                	<@spring.showErrors "/"/> 
	                </span>	
					<br><br>
					<label>SEO Title:</label>
	                <span class="error">
	                	<@spring.formInput "post.seoTitle" 'size="60" maxlength="100"'/> 
	                	<@spring.showErrors "/"/>
                	</span>
					<br><br>
					<label>SEO Description:</label><br>
	                <span class="error">
	               		<@spring.formTextarea "post.seoDescription" 'rows="5" cols="60" maxlength="500"'/> 
	               		<@spring.showErrors "/"/>
					</span>
					<br><br>
					<button type="submit">Submit</button>
					<button type="reset">Reset</button>
				</form>
				</#if>
			</div>

		</@u.left>
		<@u.right />
	</@u.body>
	</body>
</html>
