<#macro head pagetitle seotitle="" seodesc="">

    <meta charset="UTF-8">
	<title>${pagetitle}</title>
	<link rel="stylesheet" type="text/css" href="/css/styles.css" />
	<#if seotitle?has_content>
    <meta name="title" content="${seotitle}">
    </#if>
    <#if seodesc?has_content>
    <meta name="description" content="${seodesc}">
    </#if>
</#macro>


<#macro body >
	<div class="header">
		<h2>My Food Blog</h2>
	</div>
	
	<div class="row">
	
	<#-- This processes the enclosed content: -->
	<#nested>
	
	</div>
	<div class="footer">
		<h2>Footer</h2>
	</div>
</#macro>


<#macro left>
<div class="leftcolumn">

	<#-- This processes the enclosed content: -->
	<#nested>
	
</div>
</#macro>


<#macro right>
<div class="rightcolumn">

	<div class="card">
		<h3><a href="/home">Home</a></h3>
		<h3><a href="/form">New Post</a></h3>
	</div>
	<div class="card">
		<h3>Just Sidebar</h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
	</div>
</div>

</#macro>