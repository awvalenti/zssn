# Zombie Survival Social Network
All resources receive JSON and return JSON.

## Command to run server on http://localhost:8081/zssn
```
mvn clean compile exec:java -Dexec.mainClass="com.github.awvalenti.zssn.main.MainRunServer"
```

## Finished features
<dl>
	<dt>Add survivor to the database</dt>
	<dd><code>POST /survivors</code></dd>
	<dd>
		<dl>
			<dt>Input format</dt>
			<dd>See file <code>survivor1.post.json</code></dd>
			<dt>Output format</dt>
			<dd>HTTP 201 Created</dd>
		</dl>
	</dd>

	<dt>Update survivor location</dt>
	<dd><code>PUT /survivors/{id}/location</code></dd>
	<dd>
		<dl>
			<dt>Input format</dt>
			<dd>See file <code>location1.json</code></dd>
			<dt>Output format</dt>
			<dd>HTTP 201 Created</dd>
		</dl>
	</dd>

	<dt>Check inventory (only for humans)</dt>
	<dd><code>GET /survivors/{id}/inventory</code></dd>
	<dd>
		<dl>
			<dt>Input format</dt>
			<dd>None</code></dd>
			<dt>Output format</dt>
			<dd>See file <code>inventory1.json</code></dd>
		</dl>
	</dd>

	<dt>Trade items (only for humans)</dt>
	<dd><code>POST /trades</code></dd>
	<dd>
		<dl>
			<dt>Input format</dt>
			<dd>See file <code>trade1.post.json</code></dd>
			<dt>Output format</dt>
			<dd>HTTP 200 OK</dd>
		</dl>
	</dd>
</dl>

## Unfinished features
<dl>
	<dt>Flag survivor as infected</dt>
	<dd><code>POST /survivors/{id}/contamination-flag</code></dd>

	<dt>Reports</dt>
	<dd><code>GET /reports/survivors/infected</code></dd>
	<dd><code>GET /reports/survivors/non-infected</code></dd>
	<dd><code>GET /reports/survivors/inventory/average</code></dd>
	<dd><code>GET /reports/survivors/inventory/points-lost</code></dd>

</dl>
